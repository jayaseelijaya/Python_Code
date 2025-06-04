#!/usr/bin/env python
# pylint: disable=invalid-name
#
# This is disabled due to the use of single character variable names
# within context managers and list comprehensions.  Single character
# variables are acceptable in these use cases where the intent is
# clear within a couple of lines of code.
"""This script should be used to provision all applications defined in the
provided configuration file when doing (mostly) automated deployments.

Steps are:
1. Delete all application which mentioned in input file.
2. Deploy all application which mentioned in input file.
3. Start all application in specify order.

"""

import yaml
import json
import os
import random
import logging
import os
from subprocess import getoutput
import re
import argparse
import time
import sys
from urllib.parse import urlparse
import subprocess
import csv

app_manifest_path = "./manifests"

with open('./configurations/config-core.yml', "r") as INPUTF:
    INPUT = yaml.safe_load(INPUTF)

APP_START_ORDER = INPUT['APP_START_ORDER']

parser = argparse.ArgumentParser(description="CDAL Auto Deployment Script")
parser.add_argument('-cfUsername',
                    dest='cfUsername',
                    default=None,
                    help='Provide Cloud Foundry User Name')
parser.add_argument('-cfPassword',
                    dest='cfPassword',
                    default=None,
                    help='Pass Cloud Foundry User Password')
parser.add_argument('-dockerPassword',
                    dest='dockerPassword',
                    default=None,
                    help='Enter HSDP Docker User Password')
parser.add_argument('-routePrefix',
                    dest='routePrefix',
                    default=None,
                    help='Pass route prefix for each app')
parser.add_argument('-logDrainurl',
                    dest='logDrainurl',
                    default=None,
                    help='Pass logdrain url')
args, unknown_args = parser.parse_known_args()


def login_cf_cli(cf_username, cf_password):
    api_host = INPUT['api_host']
    org_name = INPUT['org_name']
    space_name = INPUT['space_name']
    import os
    os.environ['http_proxy'] = 'http://umbrella.philips.com:80'
    os.environ['https_proxy'] = 'http://umbrella.philips.com:443'
    os.system(
        "/cf login --skip-ssl-validation -u " + cf_username + " -p " + cf_password + " -o " + org_name + " -s " + space_name + " -a https://" + api_host)


def get_appnames():
    manifest_file_list = os.listdir(os.path.join(app_manifest_path))
    manifestList = []
    for manifest_name in manifest_file_list:
        if manifest_name.endswith(".yml") and not manifest_name.startswith(("base", "master")):
            manifestList.append(manifest_name)
    manifestList.sort()
    appnameslist = []
    for manifest_file in manifestList:
        manifest_yml = yaml.load(
            open(os.path.join('./manifests/', manifest_file)),Loader=yaml.FullLoader)
        appnameslist.append(manifest_yml['applications'][0]['name'])
    return (appnameslist)


def delete_apps():
    current_apps_list = getoutput(
        "cf a |grep -v -w -e \"^OK\$\" -e ^name -e \"^Getting apps\" -e \"No apps found\"|awk \'{print $1}\'|xargs")
    current_apps_list = current_apps_list.replace(" ", ",").split(",")
    to_install_app_list = get_appnames()
    if current_apps_list:
        for toapplist in to_install_app_list:
            for curapplist in current_apps_list:
                if re.match("^" + toapplist + "$", curapplist):
                    os.system("/cf delete -f " + toapplist)
                    print("Deleting app " + toapplist)

def push_apps(cf_username, cf_password, docker_password):
    """ Push applications based on list of valid manifests.
    """
    login_cf_cli(cf_username, cf_password)
    manifest_file_list = os.listdir(os.path.join(app_manifest_path))
    manifestList = []
    for manifest_name in manifest_file_list:
        if manifest_name.endswith(".yml") and not manifest_name.startswith(("base", "master")):
            manifestList.append(manifest_name)
    manifestList.sort()
    delete_apps()
    for manifest_file in manifestList:
        manifest_loc = "./manifests/" + manifest_file
        manifest_yml = yaml.load(
            open(os.path.join('./manifests/', manifest_file)),Loader=yaml.FullLoader)
        app_name = manifest_yml['applications'][0]['name']
        print("Processing.. application PUSH" + str(manifest_loc))
        os.environ['CF_DOCKER_PASSWORD'] = docker_password
        if app_name != 'fhdl-rabbitmq' and app_name != 'fhdl-rabbitmq-test':
            appdepstate = getoutput("/cf push -f " + manifest_loc + " --no-start")
            if 'FAILED' in appdepstate:
                sys.exit(str(app_name) +
                        " creation is failed. Please check" + str(appdepstate))
            else:
                print(str(app_name) + " deployment completed")
    time.sleep(60)


def start_apps(cf_username, cf_password, routePrefix):
    api_host = INPUT['api_host']
    org_name = INPUT['org_name']
    space_name = INPUT['space_name']
    vault_instance = INPUT['vault_instance']
    app_name_list = get_appnames()
    FAILED_APP_LIST = []
    SUCCESS_APP_LIST = []
    if APP_START_ORDER:
        for rmlist in APP_START_ORDER:
            if rmlist in app_name_list:
                app_name_list.remove(rmlist)
    for aps in APP_START_ORDER:
        if routePrefix != 'ci':
            aps = routePrefix + '-' + aps
        if aps != 'fhdl-rabbitmq' and aps != 'fhdl-rabbitmq-test':
            # get status of apps
            status = getoutput("/cf start " + aps)

            if "FAILED" in status:
                sys.exit(str(aps) + " application is not started")
            if "running" in status:
                SUCCESS_APP_LIST.append(aps)
    for aps1 in app_name_list:
        if aps != 'fhdl-rabbitmq' and aps != 'fhdl-rabbitmq-test':
            status = getoutput("/cf start " + aps1)
            if "FAILED" in status:
                FAILED_APP_LIST.append(aps1)
            if "running" in status:
                SUCCESS_APP_LIST.append(aps1)
    if SUCCESS_APP_LIST:
        print(str(SUCCESS_APP_LIST) + " Applications are started.")
    if FAILED_APP_LIST:
        print(str(FAILED_APP_LIST) +
              " Applications are fail to start, Please check.")


def init_logger():
    """logger object is initialized and returned"""
    logger_init = logging.getLogger(
        'DEPLOYMENT LOGGER')  # logger here is a local variable
    logger_init.setLevel(logging.INFO)
    logging_stream_handler = logging.StreamHandler()
    formatter = logging.Formatter(
        "%(asctime)s - %(name)s - %(levelname)s - %(message)s")
    logging_stream_handler.setFormatter(formatter)
    logger_init.addHandler(logging_stream_handler)
    return logger_init


def print_log(msg, type='info'):
    global logger
    if type == 'error':
        logger.error(msg)
    else:
        logger.info(msg)


def get_app_names():
    """Returns list of apps from config-core.yml"""
    app_names = []
    with open('./configurations/config-core.yml', "r") as conf_yaml:
        file_data = yaml.safe_load(conf_yaml)
        apps = file_data['apps']
        for key in apps:
            app_names.append(apps[key]['cf_app_name'])
    return app_names


def bind_logging_cup_service(cupname, logdrain_url):
    '''creates cup service and maps to each apps'''
    try:
        getoutput('cf cups {} -l {} '.format(cupname, logdrain_url))
    except:
        print_log("Cup mapping already exists... Proceeding with mapping")
    base_app_names = get_app_names()
    if args.routePrefix == 'ci':
        app_names = base_app_names
    else:
        app_names = [args.routePrefix + '-' + name for name in base_app_names]
    for name in app_names:
        print_log("Binding {} app to cup service".format(name))
        print(getoutput('cf bind-service {} {} '.format(name, cupname)))
        print_log("Restaging {} app ".format(name))
        print(getoutput('cf restage {}'.format(name)))
        
def execute_command(args = '-l'):
    cmd = '/cf';
    try:
        temp = subprocess.Popen([cmd, args], stdout = subprocess.PIPE);
        output = str(temp.communicate())
        output = output.split("\n")
        output = output[0].split('\\')
        res = []
        for line in output:
            res.append(line)
        return res
    except Exception as e:
        print('Error running cf command:  %s' % e)
        
def bindapps(cf_username, cf_password, docker_password):
    """ Bind applications based on list of valid manifests.
    """
    login_cf_cli(cf_username, cf_password)
    try: 
        #bind apps with vault
        apparray = execute_command('apps')
        for i in range(4, len(apparray) - 1):
            apps = apparray[i].split()[0]    
            appname =apps[1:].replace(" ", "")
            subprocess.run(['/cf', 'bind-service', appname, 'fhdl-vault'], stdout = subprocess.PIPE)
        print("Binded apps with vault")
    except Exception as e:
        print('Error binding apps:  %s' % e)
def main():
    login_cf_cli(args.cfUsername, args.cfPassword)
    push_apps(args.cfUsername, args.cfPassword, args.dockerPassword)    
    bindapps(args.cfUsername, args.cfPassword, args.dockerPassword)
    start_apps(args.cfUsername, args.cfPassword, args.routePrefix)
    #bind_logging_cup_service(logging_cups_name, args.logDrainurl)


if __name__ == '__main__':
    logger = init_logger()
    main()