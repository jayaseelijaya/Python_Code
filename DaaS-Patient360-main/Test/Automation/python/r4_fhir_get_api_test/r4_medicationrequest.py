import base64
import requests
import json
import os
import sys
from base64 import b64encode
import names
import time
import datetime

cf_org                 = sys.argv[1]
cf_space               = sys.argv[2]
cf_usn                 = sys.argv[3]
cf_pwd                 = sys.argv[4]
oauth2_client_id       = sys.argv[5]
oauth2_client_pwd      = sys.argv[6]
iam_usn                = sys.argv[7]
iam_pwd                = sys.argv[8]
home_path              = sys.argv[9]
vault_service_instance = sys.argv[10]
api_endpoint           = sys.argv[11]

# Importing common vault & IAM token module
sys.path.insert(0, home_path + "/Test/Automation/python/vault_details_iam_token")
from vault_details_iam_token import generate_iam_details
from vault_details_iam_token import vault_details

start_time = datetime.datetime.now()

json_result = {
"Test Name" : "R4 MedicationRequest Resource Test Case API. ",
"Test Discription" : "This test case is to verify positive working of R4 medicationrequest resource API. ",
"Test Result" : "",
"Start Time" : "",
"End Time" : "",
"Total Time" : ""
}

print("Starting R4 MedicationRequest Resource API Test Case")

# Reading Vault Details
vault_data       = vault_details(cf_org, cf_space, cf_usn, cf_pwd, vault_service_instance, api_endpoint)
# cf_org_id        = vault_data['cf_org_id']
# query_service    = vault_data['query_service']
# cdr_url          = vault_data['cdr_url']
r4_fhir_base_url = vault_data['r4_fhir_base_url']

# Generate IAM token
access_token = generate_iam_details(cf_org, cf_space, cf_usn, cf_pwd, vault_service_instance, api_endpoint, oauth2_client_id, oauth2_client_pwd, iam_usn, iam_pwd)

# Creating Header For R4 Resource Validation
r4_resource_header = {
'accept': '*/*',
'Authorization': 'Bearer ' + access_token
}

# Valid & Invalid R4 Resource
valid_r4_resource   = '0378ee8c-0efc-11ed-95d4-2c8db1a15f90'

try:
    # Posting valid R4 MedicationRequest resource 
    MedicationRequest_url = r4_fhir_base_url + '/MedicationRequest/' + valid_r4_resource
    fhir_response = requests.request(method = "GET", url = MedicationRequest_url, headers = r4_resource_header)
    if fhir_response.status_code == 200:
        fhir_response_str = str(fhir_response.text)
        json_data = json.loads(fhir_response_str)
        if json_data['id'] == valid_r4_resource:
            print("R4 MedicationRequest Resource Testing Pass ")
            json_result['Test Result'] = "Pass"
        else:
            print("R4 MedicationRequest Resource Testing Failed")
            json_result['Test Result'] = "Fail"
    else:
        print("R4 MedicationRequest Resource Testing Failed")
        json_result['Test Result'] = "Fail"
except:
    print("Error occured at R4 medicationrequest resource testing")
    json_result['Test Result'] = "Fail"

end_time = datetime.datetime.now()
total_time = end_time - start_time
json_result["Start Time"] = str(start_time)
json_result["End Time"]   = str(end_time)
json_result["Total Time"] = str(total_time)
with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
    feedsjson.write(json.dumps(json_result))
    feedsjson.write(",")