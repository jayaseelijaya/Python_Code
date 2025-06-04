#!/usr/bin/env python
# pylint: disable=invalid-name
#
# This is disabled due to the use of single character variable names
# within context managers and list comprehensions.  Single character
# variables are acceptable in these use cases where the intent is
# clear within a couple of lines of code.
"""This script should be used to provision all services defined in the
provided configuration file when doing (mostly) automated deployments.
"""
from __future__ import print_function
import sys
import argparse
import logging
import getpass
import urllib
import urllib.error
from time import sleep
import yaml
from cf import CfApi


logging.basicConfig(
    level=logging.DEBUG,
    format='%(asctime)s %(levelname)s %(message)s',
    filename='./deploy.log',
    filemode='a'
)


def log(msg):
    """Simple logging function.

    Simple function to print and log events during processing of manifest
    files.  The log file will be written to ./deploy.log.

    Args:
        msg (str): A log message.
    """
    logging.debug(msg)


def create_services(cfapi, services):
    """Create service instance in config file.
 
    Read config file and create service instances using CfApi class.
 
    Args:
        services (list[dict]): A list of services and service parameters.
 
    Returns:
        list: A list of services that were created.
    """
    managed = verify_servicename(cfapi, services,
                                 service_type='managed')
    user_provided = verify_servicename(
        cfapi, services, service_type='user-provided'
    )
    existing_services = managed + user_provided
 
    if existing_services:
        log('Service(s) already exist: '
            '{0}'.format(', '.join(existing_services)))
 
    for service in services.values():
        try:
            if service['service_name'] not in existing_services:
                if service["service_type"] == 'managed':
                    log("Creating CF service instance: Name: " +
                        service['service_name'] + ", Plan: " +
                        service['plan_name'] + ", Broker: " +
                        service['broker_name'] + '\n')
                    cfapi.create_service(
                        service['service_name'], service['broker_name'],
                        service['plan_name']
                    )
                elif service["service_type"] == 'user-provided':
                    log("Creating CF user provided service instance:  Name: " +
                        service['service_name'] + '\n')
                    cfapi.create_user_provided_service(
                        service['service_name']
                    )
                else:
                    log("Ignoring service named {0}".format(
                        service['service_name']))
        except urllib.error.HTTPError as err:
            log('Error: {0}'.format(err.read()))
            sys.exit(127)


def monitor_service_creation(cfapi, services):
    """Monitor the state of service creation.
 
    Monitors the list of services provided in the services arg to determine if
    they are in a completed state.
 
    Args:
        cfapi (cf.CfApi): An instance of the CfApi class to perform Cloud
            Foundry API calls with.
        services (list[dict]): A list of service dicts with all metadata and
            state for the services.
 
    """
    filters = {'q': 'space_guid:{0}'.format(cfapi.space_guid)}
 
    service_names = []
    for k, v in services.items():
        if type(v) is dict:
            for t, c in v.items():
                if t == 'service_name':
                    service_names.append(c)
 
 
    while True:
        service_instances = cfapi.service_instances(filters=filters)
        #in_progress = dict([
        #    (x['entity']['name'], x['entity']['last_operation']['state'])
        #    for x in service_instances
        #      if x['entity']['last_operation']['state'] != 'succeeded'
        #      and x['entity']['last_operation']['type'] == 'create'
        #      and x['entity']['name'] in services
        #])
 
        in_progress = {}
 
        #for service_instances in services
        for x in service_instances:
            if x['entity']['last_operation']['state'] != 'succeeded' and \
                            x['entity']['last_operation']['type'] == 'create':
                if x['entity']['name'] in service_names:
                    in_progress[x['entity']['name']] = x['entity']['last_operation']['state']
 
        if in_progress:
            log('Provisioning still in progress for service:{0}'.format(
                ', '.join(in_progress.keys())))
            log('Sleeping for one minute....')
            sleep(60)
        else:
            break


def verify_servicename(cfapi, services, service_type=None):
    """Verify that a existing service does not exist with the same name.
 
    Args:
        cfapi (cf.CfApi): An instance of the CfApi class to perform Cloud
            Foundry API calls with.
        services (list[dict]): A list of service dicts with all metadata and
            state for the services.
 
    Returns:
        list: A list of named services that already exist or an empty list.
    """
    services = dict([
        (k, v) for (k, v) in services.items()
        if v['service_type'] == service_type
    ])
    filters = {'q': 'space_guid:{0}'.format(cfapi.space_guid)}
    if service_type == 'managed':
        service_instances = cfapi.service_instances(filters=filters)
    elif service_type == 'user-provided':
        service_instances = cfapi.user_provided_service_instances(
            filters=filters
        )
    else:
        log('Error: Unknown service type: {0}'.format(service_type))
        sys.exit(127)
 
    service_names = []
    for k, v in services.items():
        if type(v) is dict:
            for t, c in v.items():
                if t == 'service_name':
                    service_names.append(c)
    if_exists = [
        s['entity']['name'] for s in service_instances
        if s['entity']['name'] in service_names
    ]
    return if_exists


def parse_args():
    """Parse command line args.

    Simple function to parse and return command line args.

    Returns:
        argparse.Namespace: An argparse.Namespace object.
    """
    parser = argparse.ArgumentParser()
    parser.add_argument('-c',
                        '--config',
                        dest='config',
                        default=None,
                        required=True,
                        help='The name of the config file to read service '
                             'parameters from.')
    parser.add_argument('-cfUsername',
                        dest='cfUsername',
                        default=None,
                        help='Provide Cloud Foundry User Name')
    parser.add_argument('-cfPassword',
                        dest='cfPassword',
                        default=None,
                        help='Pass Cloud Foundry User Password')
    args = parser.parse_args()
    return args


def main():
    """Main entry point.
    """
    args = parse_args()
    #print('Login to Cloud Foundry')
    #username = raw_input('username: ')
    #password = getpass.getpass('Password: ')
    username = args.cfUsername
    password = args.cfPassword
    try:
        with open(args.config) as f:
            config = yaml.load(f.read(),Loader=yaml.FullLoader)
        services = config['services']
        org_name = config['org_name']
        space_name = config['space_name']
        api_host = config['api_host']
        login_host = config['login_host']
    except IOError:
        log("ERROR: Can't read config from {0}".format(args.config))
        sys.exit(127)
    except KeyError as err:
        log("ERROR: Required key ({0}) not in config".format(err))
        sys.exit(127)
    cfapi = CfApi(username=username, password=password, login_host=login_host,
                  api_host=api_host, org_name=org_name, space_name=space_name)
    create_services(cfapi, services)
    monitor_service_creation(cfapi, services)


if __name__ == '__main__':
    main()
