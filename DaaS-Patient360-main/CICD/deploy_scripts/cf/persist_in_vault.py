"""Vault operations"""
from MyVault import MyVault
from GetKey import GetKey
import traceback

def get_client_key(cfapi, vault_service_name, vault_url):
    try:
        key = GetKey.cf_get_key("https://" + cfapi.api_host,
                                cfapi.username,
                                cfapi.password,
                                cfapi.org_name,
                                cfapi.space_name,
                                vault_service_name)
    except:
        print("Reading keys from service name failed")

    try:
        client = MyVault.create_client("https://" + vault_url, key['role_id'], key['secret_id'])
        return key, client
    except:
        traceback.print_exc()
        print("Creating client for vault failed")
        return None


def write_to_vault(cfapi, vault_service_name, vault_url, djson, vault_path):
    """Writes to vault"""
    try:
        key, client = get_client_key(cfapi, vault_service_name, vault_url)
        print(key['service_secret_path'].strip('v1/') + '/' + vault_path)
        MyVault.write_config_file(client, key['service_secret_path'].strip('v1/') + '/' + vault_path, djson)
        print("write to vault path:{0} completed".format(vault_path))
    except:
        traceback.print_exc()
        print("Error in persisting json to vault")


def read_from_vault(cfapi, vault_service_name, vault_path, vault_url):
    """read from vault function """
    try:
        key, client = get_client_key(cfapi, vault_service_name, vault_url)
        print(key['service_secret_path'].strip('v1/') + '/' + vault_path)
        value = MyVault.read_config_file(client, key['service_secret_path'].strip('v1/') + '/' + vault_path)
        print("Data in Vault path:{0} is as follows:".format(vault_path))
        print(value)
    except:
        traceback.print_exc()
        print("Error in fetching")
