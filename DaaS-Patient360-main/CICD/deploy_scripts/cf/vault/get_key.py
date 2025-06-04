from cloudfoundry_client.client import CloudFoundryClient
import os
import json
import subprocess
import sys


def get_space_guid(client, org, space):
    """ Method to get CF Space guid.

    :param client: Cloud foundry client for Vault
    :param org: CF Org Name
    :param space: CF Space Name
    :return: Returns Space guid
    """

    if org != '' and space != '':
        for organization in client.organizations:
            if str(organization['entity']['name']).lower() == str(org).lower():
                for spaces in organization.spaces():
                    if str(spaces['entity']['name']).lower() == str(space).lower():
                        return spaces['metadata']['guid']
    else:
        print('Input: Org or Space is empty. Considering by default, Space guid is empty')
    return None


def get_service_guid(client, space_guid, vault_service_name):
    """ Method to get CF Vault Service Name guid.

    :param client: Cloud foundry client for Vault
    :param space_guid: CF Space guid
    :param vault_service_name: CF Vault Service Name
    :return: Returns Service Instance guid
    """

    print(client.service_instances)
    for service in client.service_instances:
        if space_guid is not None and vault_service_name != '':
            if service['entity']['space_guid'] == space_guid:
                if str(service['entity']['name']).lower() == str(vault_service_name).lower():
                    return service['metadata']['guid']
        elif space_guid is None and vault_service_name != '':
            if str(service['entity']['name']).lower() == str(vault_service_name).lower():
                return service['metadata']['guid']
        else:
            print('Input: Vault Service Name is empty.')
            return service_guid
    return None


def get_service_key_creds(client, service_guid):
    """ Method to get the Service Key based on vault service name guid .

    :param client: Cloud foundry client for Vault
    :param service_guid: CF Vault Service guid
    :return: Returns Service Key object
    """

    if service_guid is not None:
        for service_key in client.service_keys:
            if service_key['entity']['service_instance_guid'] == service_guid.strip():
                return service_key['entity']['credentials']
    else:
        print('Service guid is empty.')
    return None


def cf_get_key(cf_url, usr, p, org, space, vault_service_name):
    """ Method to get Service-Key.

    :param cf_url: Cloud Foundry URL.
    :param usr: Cloud Foundry UserName.
    :param p: Cloud Foundry Password
    :param org: Cloud Foundry Org
    :param space: Cloud Foundry Space
    :param vault_service_name: Cloud Foundry Vault Service Instance Name
    :return: Returns client for Vault
    """

    global space_guid, service_guid

    try:
        http = os.environ.get('http_proxy')
        if len(http) == 0:
            http = os.environ.get('http_proxy', '')
    except:
        print("Environment Variable Did Not Exist: HTTP_PROXY. Setting Value as Blank")
        http = os.environ.get('http_proxy', '')

    try:
        https = os.environ.get('https_proxy')
        if len(https) == 0:
            https = os.environ.get('https_proxy', '')
    except:
        print("Environment Variable Did Not Exist: HTTPS_PROXY. Setting Value as Blank")
        https = os.environ.get('https_proxy', '')

    proxy = dict(http=http, https=https)
    client = CloudFoundryClient(cf_url, proxy=proxy, skip_verification=True)
    client.init_with_user_credentials(usr, p)
    keys = None
    space_guid = get_space_guid(client, org, space)
    if space_guid is not None:
        service_guid = get_service_guid(client, space_guid, vault_service_name)
        if service_guid is not None:
            keys = get_service_key_creds(client, service_guid)
    return keys


''' Following list of methods are being created to 
    get vault service instance keys using CF CLI '''


def execute_command(command):
    """
    Execute the provided command in shell
    :param command:
    :return: output, status
    """

    try:
        http = os.environ.get('http_proxy')
        if len(http) == 0:
            http = os.environ.get('http_proxy', '')
    except:
        http = ''

    try:
        https = os.environ.get('https_proxy')
        if len(https) == 0:
            https = os.environ.get('https_proxy', '')
    except:
        https = ''

    proxy = dict(os.environ)
    proxy['HTTP_PROXY'] = http
    proxy['HTTPS_PROXY'] = https

    response = (subprocess.Popen(command,
                                 shell=True,
                                 stdout=subprocess.PIPE,
                                 env=proxy).communicate()[0]).decode().lower()
    index = response.find('failed\n')
    status = False
    if index == -1:
        status = True
    return response, status


def cf_cli_login(api_host, username, password, org, space):
    """ Attempts CF login with given user name and password.
        WARNING: DO NOT CALL THIS WITH INVALID CREDENTIALS

    :param api_host: CF API Host Name. Example: api.cloud.pcftest.com
    :param username: CF user id
    :param password: CF password
    :param org: CF org
    :param space: CF Space
    """

    command = ["cf", "login", "-a", api_host,
               "-u", username,
               "-p", password,
               "-o", org,
               "-s", space]

    return execute_command(command)


def create_service_key(service_name, service_key):
    """Create the service key for a given service"""
    command = ['cf', 'create-service-key', service_name, service_key]
    response, status = execute_command(command)
    if status is False and 'not found' in response:
        return status
    if not status:
        print("Failed to create service key for provided service instance {service_name}" \
              "\n\t\t\tError: {response}")
    return status


def get_service_key_credentials(service_name, service_key):
    """Return the creds for the given service"""
    command = ['cf', 'service-key', service_name, service_key]
    response, status = execute_command(command)
    if not status:
        print('Failed to get service key. Please check service exists.')
        return None
    response = response.split('\n')[1:]
    response = ''.join(response)
    return json.loads(response.strip())


def is_service_exists(service_name):
    """Check service exists in the CF"""
    command = ['cf', 'service', service_name]
    response, success = execute_command(command)
    if 'failed' in response.lower():
        print('Vault Service Did Not Exist')
        return False
    return True


def get_vault_credentials(cf_api_host, username, password, org, space, vault_service_name):
    """ Get vault credentials by querying service key on CF

    :param cf_api_host: CF API Host Name. Example: api.cloud.pcftest.com
    :param username: CF user id
    :param password: CF password
    :param org: CF org
    :param space: CF Space
    :param vault_service_name: CF Vault Service Name
    :return: vault credentials
    """

    response, status = cf_cli_login(cf_api_host, username, password, org, space)
    get_vault_keys = None
    if status is True:
        print('Logged in to Cloud Foundry')
        vault_service_key = '{}-service-key'.format(vault_service_name)
        if is_service_exists(vault_service_name) is True:
            create_service_key(vault_service_name, vault_service_key)
            get_vault_keys = get_service_key_credentials(vault_service_name, vault_service_key)
    else:
        print('Failed to login to cloud foundry')
        sys.exit(1)
    return get_vault_keys


def exit_if_error(output):
    """Check if output contains string OK if not,exit"""
    if 'OK' not in output:
        sys.exit(1)
