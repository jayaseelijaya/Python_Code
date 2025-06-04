#!/usr/bin/env python
# pylint: disable=invalid-name
#
# This is disabled due to the use of single character variable names
# within context managers and list comprehensions.  Single character
# variables are acceptable in these use cases where the intent is
# clear within a couple of lines of code.
"""This script will populate config file for different environment taking
key/value information.
"""
from __future__ import print_function

import argparse
import logging
import os

import yaml
from jinja2 import Environment, FileSystemLoader

TEMPLATE_PATH = './'

logging.basicConfig(
    level=logging.DEBUG,
    format='%(asctime)s %(levelname)s %(message)s',
    filename='/home/jenkins/workspace/FederatedHealthLake_GATED/CICD/deploy_scripts/deploy.log',
    filemode='a'
)
os.chmod('/home/jenkins/workspace/FederatedHealthLake_GATED/CICD/deploy_scripts/deploy.log', 0o777)

def log(msg):
    """Simple logging function.

    Simple function to print and log events during processing of manifest
    files.  The log file will be written to ./deploy.log.

    Args:
        msg (str): A log message.
    """
    print(msg)
    logging.debug(msg)


def populate_smoke_setup(smoke_config_file, config_keyvalue_file, keys_file):
    """Renders all condif template files and populate with actual values.

    Args:
        smoke_config_file (str): The path to the yaml config file needed to populated.
        config_keyvalue_file (str): The path to the yaml key vlaue file.
    """

    with open(config_keyvalue_file) as _f:
        config_keyvalue_file = yaml.load(_f.read())
    with open(keys_file) as _kf:
        keys_file = yaml.load(_kf.read())
    config_keyvalue_file.update(keys_file)
    head, cfgfilename = os.path.split(smoke_config_file)
    j2 = Environment(loader=FileSystemLoader(head), trim_blocks=True)
    template = j2.get_template(cfgfilename)
    config_contents = template.render(**config_keyvalue_file)
    config_name = '.'.join(cfgfilename.split('.')[:2])
    config_file = os.path.join('./SmokeTests/', config_name)
    with open(config_file, 'w') as f:
        log('Generating {0}'.format(config_file))
        f.write(config_contents)

    log('Completed smoke setup  generation.')


def populate_config(config_file, config_keyvalue_file, domain, org_name, space_name, api_host, login_host, vault_instance,vault_plan, rabbitmq_instance, routePrefix):
    """Renders all condif template files and populate with actual values.

    Args:
        config_file (str): The path to the yaml config file needed to populated.
        config_keyvalue_file (str): The path to the yaml key vlaue file.
    """

    fname = config_keyvalue_file
    with open(config_keyvalue_file) as _f:
        config_keyvalue_file = yaml.load(_f.read(),Loader=yaml.FullLoader)
    head, cfgfilename = os.path.split(config_file)
    j2 = Environment(loader=FileSystemLoader(head), trim_blocks=True)
    template = j2.get_template(cfgfilename)

    config_keyvalue_file["org_name"] = org_name
    config_keyvalue_file["space_name"] = space_name
    config_keyvalue_file["api_host"] = api_host
    config_keyvalue_file["login_host"] = login_host
    config_keyvalue_file["vault_instance"] = vault_instance
    config_keyvalue_file["vault_plan"] = vault_plan
    config_keyvalue_file["end_points"]["vault_instance"] = vault_instance
    config_keyvalue_file["end_points"]["rabbitmq_instance_name"] = rabbitmq_instance

    config_contents = template.render(**config_keyvalue_file)
    config_name = '.'.join(cfgfilename.split('.')[:2])
    config_file = os.path.join(head, config_name)

    with open(config_file, 'w') as f:
        log('Generating {0}'.format(config_file))
        #print(config_contents)      
        f.write(config_contents)

    with open(fname, 'w') as f:
        yaml.dump(config_keyvalue_file, f)

    log('Completed config generation.')


def parse_args():
    """Parse command line args.

    Simple function to parse and return command line args.

    Returns:
        argparse.Namespace: An argparse.Namespace object.
    """
    parser = argparse.ArgumentParser()
    parser.add_argument('-p',
                        '--populate',
                        help='Create manifest files from a config file.')
    parser.add_argument('-i',
                        '--input',
                        help='Input file to populate the config file')
    parser.add_argument('-d',
                        '--domain',
                        help='Domain as per the target deployment env. Example - cloud.pcftest.com')
    parser.add_argument('-k',
                        '--keys',
                        help='Keys file to populate the config file')
    parser.add_argument('-s',
                        '--smoke',
                        help='smoke file template to populate the smoke test setup file')
    parser.add_argument('-org_name',
                        dest='org_name',
                        default=None,
                        help='Pass cf org name')
    parser.add_argument('-space_name',
                        dest='space_name',
                        default=None,
                        help='Pass cf space name')
    parser.add_argument('-api_host',
                        dest='api_host',
                        default=None,
                        help='Pass cf api host')
    parser.add_argument('-login_host',
                        dest='login_host',
                        default=None,
                        help='Pass cf login host')
    parser.add_argument('-vault_instance',
                        dest='vault_instance',
                        default=None,
                        help='Pass vault instance name')
    parser.add_argument('-vault_plan',
                        dest='vault_plan',
                        default=None,
                        help='Pass vault instance plan name')
    parser.add_argument('-rabbitmq_instance',
                        dest='rabbitmq_instance',
                        default=None,
                        help='Pass rabbitmq instance name')
    parser.add_argument('-routePrefix',
                        dest='routePrefix',
                        default=None,
                        help='Pass route prefix for each app')
    args = parser.parse_args()
    return args


def main():
    """Main entry point.
    """
    args = parse_args()
    print ("Executing populate config")

    if args.populate and args.input:
        populate_config(args.populate, args.input, args.domain, args.org_name, args.space_name, args.api_host,
                        args.login_host, args.vault_instance, args.vault_plan, args.rabbitmq_instance, args.routePrefix)


if __name__ == '__main__':
    main()