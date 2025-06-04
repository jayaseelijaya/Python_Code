import base64
import requests
import json
import os
import sys
import time
import subprocess
import names

oauth2_client_id   = "" # Use oauth2_client_id
oauth2_client_pwd  = "" # Use oauth2_client_pwd
iam_usn            = "" # Use IAM User Name
iam_pwd            = "" # Use IAM PWD


#Retreiving data from config file
with open("cicd_config.json") as json_data:
    config_data = json.load(json_data)
iam_url               = config_data['iam_url']
cdr_url               = config_data['cdr_url']
fhir_org_id           = config_data['fhir_org_id']

#Generate IAM token
iam_auth = base64.b64encode((oauth2_client_id + ":" + oauth2_client_pwd).encode("utf-8")).decode('ascii')
url      = iam_url + "/authorize/oauth2/token"
payload  = "grant_type=password&username=" + iam_usn + "&password=" + iam_pwd
headers  = {
  'Content-Type': 'application/x-www-form-urlencoded',
  'api-version': '2',
  'Authorization': 'Basic ' + iam_auth
}
response = requests.request("POST", url, headers = headers, data = payload)
if response.status_code == 400:
    print("Fail as IAM token is not generated.")
    sys.exit(0)
elif response.status_code == 200:
    authData = json.loads(response.text)

# Folder Path
path = "/Test/Automation/python/Setup_dataset/new_generated_datasets/"
os.chdir(path)

def read_text_file(file_path):
    print(file)
    with open(file_path, 'r') as myfile:
            data_cdr = myfile.read()
    jsonData   = json.loads(data_cdr)
    cdrUrl     = cdr_url + '/store/fhir/' + fhir_org_id
    cdrHeaders = {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json',
                    'Authorization': 'Bearer ' + authData['access_token'],
                    'api-version': '1'
                 }
    time.sleep(2)
    response = requests.request(method = "POST", url = cdrUrl, headers = cdrHeaders, json = jsonData)
    result1  = json.loads(response.text)
    print("File uploaded into cdr store")

for file in os.listdir():
        file_path = f"{path}\{file}"
        read_text_file(file_path)
