import os
import sys
import subprocess
import requests
import json
import requests
import re
import base64

def vault_details(cf_org, cf_space, cf_usn, cf_pwd, vault_zone, cf_login_endpoint):
    #Login to Cloud Foundry
    # cf_login = subprocess.run(['cf', 'login', '-a', cf_login_endpoint, '-u', cf_usn, '-p', cf_pwd, '-o', cf_org, '-s', cf_space], stdout=subprocess.PIPE)

    # #Retrive Service Key
    # vault_service_key = subprocess.run(['cf', 'service-key', vault_zone, vault_zone + '-key'], stdout=subprocess.PIPE)
    # vault_service_key_res = str(vault_service_key.stdout, 'utf-8')
    # vault_service_key_json = json.loads(vault_service_key_res.split('\n', 2)[2].strip().replace(" ", ""))
    # role_key = vault_service_key_json['role_id']
    # secrete_key = vault_service_key_json['secret_id']

    #Create a post request and extract client token
    client_token_headers = {
    'Content-Type': 'application/json',
    'Accept': '*/*',
    'Accept-Encoding': 'gzip, deflate, br',
    }
    request_body = {
    "role_id" : "848922c9-8c07-b083-9ebd-6234089cffd1", #role_key,
    "secret_id" : "a5405ac5-d6a7-0219-d6ac-056c57c2055a" #secrete_key
    }
    # Creating URL for client token generation
    # vault_endpoint_url = vault_service_key_json['endpoint'] + "v1/auth/approle/login"
    vault_endpoint_url = "https://vproxy.us-east.philips-healthsuite.com/v1/auth/approle/login"

    # Posting rest request to generate client token
    resp = requests.post(url = vault_endpoint_url, headers = client_token_headers, json = request_body)
    result = json.loads(resp.text)
    client_token = result['auth']['client_token']

    # creating new header to get service credentials using client token
    service_credentials_header = {
    'Content-Type': 'application/json',
    'Accept': '*/*',
    'Accept-Encoding': 'gzip, deflate, br',
    'X-Vault-Token' : client_token
    }

    # Creating vault url to extract vaul;t details
    # vault_url = vault_service_key_json['endpoint'] + vault_service_key_json['service_secret_path'] + "/" + "daas-common-credentials"
    # vault_url_final = vault_url.replace(".com/", ".com")
    vault_url_final = "https://vproxy.us-east.philips-healthsuite.com/v1/cf/3e34fbe8-4f9c-40d3-9d4a-fb3646004b45/secret/daas-common-credentials"

    response_data = requests.get(url = vault_url_final, headers = service_credentials_header)
    service_result = json.loads(response_data.text)
    service_data = service_result['data']
    if service_data != "":
        print("Pass : Vault Data Extracted")
    else:
        print("Fail : No Vault Data Found")
    return service_data
