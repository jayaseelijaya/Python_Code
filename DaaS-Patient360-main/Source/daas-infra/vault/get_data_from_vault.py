import os
import sys
import subprocess
import requests
import json
import requests
import re
import base64


def vault_details():
    encoded_role_id = 'ODQ4OTIyYzktOGMwNy1iMDgzLTllYmQtNjIzNDA4OWNmZmQx'
    encode_secret_id = 'YTU0MDVhYzUtZDZhNy0wMjE5LWQ2YWMtMDU2YzU3YzIwNTVh'

    # Create a post request and extract client token
    client_token_headers = {
        'Content-Type': 'application/json',
        'Accept': '*/*',
        'Accept-Encoding': 'gzip, deflate, br',
    }
    request_body = {
        "role_id": base64.b64decode(encoded_role_id).decode("ascii"),
        "secret_id": base64.b64decode(encode_secret_id).decode("ascii")
    }
    # Creating URL for client token generation
    vault_endpoint_url = "https://vproxy.us-east.philips-healthsuite.com/v1/auth/approle/login"

    # Posting rest request to generate client token
    resp = requests.post(url=vault_endpoint_url, headers=client_token_headers, json=request_body)
    result = json.loads(resp.text)
    client_token = result['auth']['client_token']

    # creating new header to get service credentials using client token
    service_credentials_header = {
        'Content-Type': 'application/json',
        'Accept': '*/*',
        'Accept-Encoding': 'gzip, deflate, br',
        'X-Vault-Token': client_token
    }

    # Creating vault url to extract vaul;t details
    vault_url = "https://vproxy.us-east.philips-healthsuite.com/v1/cf/3e34fbe8-4f9c-40d3-9d4a-fb3646004b45/secret/daas-common-credentials"

    response_data = requests.get(url=vault_url, headers=service_credentials_header)
    service_result = json.loads(response_data.text)
    service_data = service_result['data']
    if service_data != "":
        print("Pass : Vault Data Extracted")
    else:
        print("Fail : No Vault Data Found")
    return service_data
