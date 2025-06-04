#!/usr/bin/env python
# pylint: disable=invalid-name
#
# This is disabled due to the use of single character variable names
# within context managers and list comprehensions.  Single character
# variables are acceptable in these use cases where the intent is
# clear within a couple of lines of code.
"""This script will extract credentials for an existing service instance from
the Cloud Controller.  To do this a temporary app reference is created (no app
is actually pushed), the service is bound to the app, and the credentials are
extracted and displayed on the console.  The service will be unbound and the
temporary application will be deleted after this is done.  This is not intended
to be used in any other automation.  It requires user input to get the username
and password to use when connecting to the Cloud Controller.
"""
from __future__ import print_function
import sys
import json
import string
import random
import getpass
import argparse
import yaml
from .cf import CfApi
from logger.logger import log


def randomstring(length):
    """Create a random string.

    This will return a random string the size of the length arg.

    Args:
       length (int): The length of the string that should be generated.
    """
    return ''.join(random.choice(string.lowercase) for i in range(length))


def get_credentials(cfapi, service_name):
    """Get the credentials for a service instance.

    This will extract the service credentials from an existing service
    instance and return them.

    Args:
        cfapi (cf.CfApi): An instance to the CfApi class.
        service_name (str): The name of the service to get credentials from.

    Returns:
        str: A JSON string of service credentials.
    """
    filters = {'q': 'space_guid:{0}'.format(cfapi.space_guid)}
    services = cfapi.service_instances(filters=filters)
    for service in services:
        if service['entity']['name'] == service_name:
            service_guid = service['metadata']['guid']
            log('Found GUID for service instance: {0}'.format(service_name))
            break
    else:
        log('Could not find GUID for service instance: {0}'.format(
            service_name))
        sys.exit(127)
    temporary_app_name = randomstring(16)
    log('Creating temporary app: {0}'.format(temporary_app_name))
    app = cfapi.create_app(temporary_app_name)
    app_guid = app['metadata']['guid']
    log('Binding service {0} to application {1}'.format(
        service_name, temporary_app_name))
    binding = cfapi.bind_service(service_guid, app_guid)
    log('Extracting credentials for service {0}.'.format(service_name))
    credentials = binding['entity']['credentials']
    log('Unbinding service {0} from application {1}'.format(
        service_name, temporary_app_name))
    cfapi.unbind_service(binding['metadata']['guid'])
    log('Deleting temporary application {0}.'.format(temporary_app_name))
    cfapi.delete_app(app_guid)
    return json.dumps(credentials, indent=4)


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
                        default='',
                        required=True,
                        help='The configuration file with environment '
                             'settings.')
    parser.add_argument('-s',
                        '--service-name',
                        dest='service_name',
                        default='',
                        required=True,
                        help='The name of the service to to pull '
                             'credentials for.')
    args = parser.parse_args()
    return args


def main():
    """Main entry point.
    """
    args = parse_args()
    print('Login to Cloud Foundry')
    username = input('username: ')
    password = getpass.getpass('Password: ')
    log('Started get credentials run.')
    try:
        with open(args.config) as f:
            config = yaml.load(f.read(),
                               Loader=yaml.FullLoader)
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
    cfapi = CfApi(
        username=username, password=password, login_host=login_host,
        api_host=api_host, org_name=org_name, space_name=space_name)
    credentials = get_credentials(cfapi, args.service_name)
    return credentials


if __name__ == '__main__':
    main()
