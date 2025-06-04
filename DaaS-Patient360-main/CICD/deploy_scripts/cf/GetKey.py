from cloudfoundry_client.client import CloudFoundryClient
import os


class GetKey:
   
    def __init__(self):
        """Class for getting Keys, (Parameters & Return: : , Usage: from GetKey.py import GetKey.
        
        """
        pass

    @staticmethod
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
            http = os.environ.get('HTTP_PROXY')
            if(len(http) == 0):
                http = os.environ.get('http_proxy', '')
        except:
            print("Environment Variable Did Not Exist: HTTP_PROXY. Setting Value as Blank")
            http = os.environ.get('http_proxy', '')

        try:
            https = os.environ.get('HTTPS_PROXY')
            if(len(https) == 0):
                https = os.environ.get('https_proxy', '')
        except:
            print("Environment Variable Did Not Exist: HTTPS_PROXY. Setting Value as Blank")
            https = os.environ.get('https_proxy', '')

        proxy = dict(http=http, https=https)
        client = CloudFoundryClient(cf_url, proxy=proxy, skip_verification=True)
        client.init_with_user_credentials(usr, p)
        for organization in client.organizations:
            if str(organization['entity']['name']).lower() == str(org).lower():
                for spaces in organization.spaces():
                    if str(spaces['entity']['name']).lower() == str(space).lower():
                        space_guid = spaces['metadata']['guid']
                        break
        for service in client.service_instances:
            if service['entity']['space_guid'] == space_guid:
                if str(service['entity']['name']).lower() == str(vault_service_name).lower():
                    service_guid = service['metadata']['guid']
                    break
                    
        for service_key in client.service_keys:
            if service_key['entity']['service_instance_guid'] == service_guid:
                return service_key['entity']['credentials']