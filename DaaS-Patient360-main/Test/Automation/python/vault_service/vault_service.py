import base64
import requests
import json
import os
import sys
import subprocess
import datetime

start_time = datetime.datetime.now()

json_result = {
"Test Name" : "Vault Service Test Case. ",
"Test Discription" : "This test case is to verify working of vault instance created storing data. ",
"Test Result" : "",
"Start Time" : 0,
"End Time" : 0,
"Total Time" : 0
}

cf_org                 = sys.argv[1]
cf_space               = sys.argv[2]
cf_usn                 = sys.argv[3]
cf_pwd                 = sys.argv[4]
vault_zone             = sys.argv[5]
home_path              = sys.argv[6]
vault_service_instance = sys.argv[7]
api_endpoint           = sys.argv[8]

# Importing common vault & IAM token module
sys.path.insert(0, home_path + "/Test/Automation/python/vault_details_iam_token")
from vault_details_iam_token import generate_iam_details
from vault_details_iam_token import vault_details

print("Starting Vault Service Test Case")

# Reading Vault Details
print("Extracting Vault Data")
vault_data        = vault_details(cf_org, cf_space, cf_usn, cf_pwd, vault_service_instance, api_endpoint)
vault_url_login   = vault_data['vault_url']
vault_url_secret  = vault_data['vault_url']
cf_login_endpoint = api_endpoint

vault_url_login  = vault_url_login + "/auth/approle/login"
vault_url_secret = vault_url_secret + "/cf/4dd2d972-3634-4485-9f6f-077a09b5df80/secret/"

#Login to Cloud Foundry
cf_login = subprocess.run(['/cf', 'login', '-a', cf_login_endpoint, '-u', cf_usn, '-p', cf_pwd, '-o', cf_org, '-s', cf_space], stdout=subprocess.PIPE)

#Retrive Service Key
vault_service_key      = subprocess.run(['/cf', 'service-key', vault_zone, vault_zone + '-key'], stdout=subprocess.PIPE)
vault_service_key_res  = str(vault_service_key.stdout, 'utf-8')
vault_service_key_json = json.loads(vault_service_key_res.split('\n', 2)[2].strip().replace(" ", ""))

role_key   = vault_service_key_json['role_id']
secret_key = vault_service_key_json['secret_id']

#Create a post request and extract client token
client_token_headers = {
                            'Content-Type': 'application/json',
                            'Accept': '*/*',
                            'Accept-Encoding': 'gzip, deflate, br',
                        }
request_body = {
                    "role_id" : role_key,
                    "secret_id" : secret_key
                }
resp = requests.post(url = vault_url_login, headers = client_token_headers, json = request_body)
result = json.loads(resp.text)
client_token = result['auth']['client_token']
print("Value of generated clinet token is" , client_token)

#creating new  header to get service credentials using client token
service_credentials_header = {
                                'Content-Type': 'application/json',
                                'Accept': '*/*',
                                'Accept-Encoding': 'gzip, deflate, br',
                                'X-Vault-Token' : client_token
                            }
vault_service = ["fhdl-dynamodb-credentials", "fhdl-rabbitmq-credentials", "fhdl-redshift-credentials",
                 "fhdl-s3-credentials", "fhdl-s3-dynamodb-credentials", "fhdl-s3-loader-credentials",
                 "cdr-credentials", "dicom-credentials", "iam-credentials", "org-credentials"]
for services in vault_service:
    vault_service_url = vault_url_secret + services
    response_data = requests.get(url = vault_service_url, headers = service_credentials_header)
    service_result = json.loads(response_data.text)
    service_data = service_result['data']
    if service_data != "":
        print("Vault Service Test Case Passed : Credentials of service are")
        print(service_data )
        json_result['Test Result'] = "Pass"
    else:
        print("Vault Service Test Case Failed : No data found")
        json_result['Test Result'] = "Fail"

end_time = datetime.datetime.now()
total_time = end_time - start_time
stime = str(start_time)
etime = str(end_time)
ttime = str(total_time)
json_result["Start Time"] = stime
json_result["End Time"] = etime
json_result["Total Time"] = ttime
with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
    feedsjson.write(json.dumps(json_result))
    feedsjson.write(",")
