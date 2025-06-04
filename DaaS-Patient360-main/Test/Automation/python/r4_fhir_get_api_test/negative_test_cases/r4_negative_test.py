import base64
import requests
import json
import os
import sys
from base64 import b64encode
import names
import time
import datetime
import copy

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

#Importing common vault & IAM token module
sys.path.insert(0, home_path + "/Test/Automation/python/vault_details_iam_token")
from vault_details_iam_token import generate_iam_details
from vault_details_iam_token import vault_details

json_result = {
    "Test Name" : "",
    "Test Discription" : "",
    "Test Result" : "",
    "Start Time" : "",
    "End Time" : "",
    "Total Time" : ""
}

with open(home_path + "/Test/Automation/python/r4_fhir_get_api_test/negative_test_cases/test_data_config.json",'r') as dataset:
    jsonData = json.load(dataset)

print("Starting R4 AllergyIntolerance Resource API Test Case")

# Reading Vault Details
print("Extracting Vault Data")
vault_data       = vault_details(cf_org, cf_space, cf_usn, cf_pwd, vault_service_instance, api_endpoint)
# cf_org_id        = vault_data['cf_org_id']
# query_service    = vault_data['query_service']
# cdr_url          = vault_data['cdr_url']
r4_fhir_base_url = vault_data['r4_fhir_base_url']

# # #Generate IAM token
access_token = generate_iam_details(cf_org, cf_space, cf_usn, cf_pwd, vault_service_instance, api_endpoint, oauth2_client_id, oauth2_client_pwd, iam_usn, iam_pwd)

# Creating Header For R4 Resource Validation
r4_resource_header = {
'accept': '*/*',
'Authorization': 'Bearer ' + access_token
}

# Valid R4 Resource
allergyintolerance_resource   = jsonData["allergyintolerance_resource"]
allergyintolerance_url        = jsonData["allergyintolerance_url"]
condition_resource            = jsonData["condition_resource"]
condition_url                 = jsonData["condition_url"]
encounter_resource            = jsonData["encounter_resource"]
encounter_url                 = jsonData["encounter_url"] 
immunization_resource         = jsonData["immunization_resource"]
immunization_url              = jsonData["immunization_url"]
medication_resource           = jsonData["medication_resource"]
medication_url                = jsonData["medication_url"]
medicationrequest_resource    = jsonData["medicationrequest_resource"]
medicationrequest_url         = jsonData["medicationrequest_url"]
medicationStatement_resource  = jsonData["medicationStatement_resource"]
medicationStatement_url       = jsonData["medicationStatement_url"]
observation_resource          = jsonData["observation_resource"]
observation_url               = jsonData["observation_url"]
organization_resource         = jsonData["organization_resource"]
organization_url              = jsonData["organization_url"]
patient_resource              = jsonData["patient_resource"]
patient_url                   = jsonData["patient_url"]
practitioner_resource         = jsonData["practitioner_resource"]
practitioner_url              = jsonData["practitioner_url"]

def wrong_iam_token(resource, url_part):
    url = r4_fhir_base_url + "/" + url_part + "/" + resource
    print("Test URL:",url)
    start_time = datetime.datetime.now()
    json_result_wrong_IAM = copy.deepcopy(json_result)
    json_result_wrong_IAM['Test Name'] = url_part + " R4 Resource Negative Test Case 1. "
    json_result_wrong_IAM['Test Discription'] = "This test case is to verify proper exception message sent from FHIR API when wrong IAM token is used. "
    wrong_header = copy.deepcopy(r4_resource_header)
    wrong_header['Authorization'] = ''
    fhir_response = requests.request(method = "GET", url = url, headers = wrong_header)
    print(fhir_response.text)
    print(fhir_response.status_code)
    if fhir_response.status_code == 401:
        fhir_response_str = str(fhir_response.text)
        json_data = json.loads(fhir_response_str)
        if json_data['error'] == 'Unauthorized':
            print(url_part," R4 Resource Wrong IAM Token Test Case Passed.")
            json_result_wrong_IAM['Test Result'] = "Pass"
        else:
            print(url_part, " R4 Resource Wrong IAM Token Test Case Failed.")
            json_result_wrong_IAM['Test Result'] = "Fail"
    else:
        print(url_part, " R4 Resource Wrong IAM Token Test Case Failed. Wrong status code or response")
        json_result_wrong_IAM['Test Result'] = "Fail"
    end_time = datetime.datetime.now()
    total_time = end_time - start_time
    stime = str(start_time)
    etime = str(end_time)
    ttime = str(total_time)
    json_result_wrong_IAM["Start Time"] = stime
    json_result_wrong_IAM["End Time"] = etime
    json_result_wrong_IAM["Total Time"] = ttime
    with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
        feedsjson.write(json.dumps(json_result_wrong_IAM))
        feedsjson.write(",")

def wrong_resource(resource, url_part):
    start_time = datetime.datetime.now()
    json_result_wrong_resource = copy.deepcopy(json_result)
    json_result_wrong_resource['Test Name'] = url_part + " R4 Resource Negative Test Case 2. "
    json_result_wrong_resource['Test Discription'] = "This test case is to verify proper exception message sent from FHIR API when wrong resource id is used. "
    invalid_r4_resource = "c0130bf9-13d4-11ed-ac7b-2c8db1a15f98"
    allergyIntolerance_url_new = r4_fhir_base_url + '/' + url_part + '/' + invalid_r4_resource
    fhir_response = requests.request(method = "GET", url = allergyIntolerance_url_new, headers = r4_resource_header)
    if fhir_response.status_code == 500:
        fhir_response_str = str(fhir_response.text)
        json_data = json.loads(fhir_response_str)
        if json_data['error'] == 'Internal Server Error':
            print(url_part, " R4 Resource Wrong Resource Test Case Passed.")
            json_result_wrong_resource['Test Result'] = "Pass"
        else:
            print(url_part, " R4 Resource Wrong Resource Test Case Failed.")
            json_result_wrong_resource['Test Result'] = "Fail"
    else:
        print(url_part, " R4 Resource Wrong IAM Token Test Case Failed. Wrong status code or response")
        json_result_wrong_resource['Test Result'] = "Fail"
    end_time = datetime.datetime.now()
    total_time = end_time - start_time
    stime = str(start_time)
    etime = str(end_time)
    ttime = str(total_time)
    json_result_wrong_resource["Start Time"] = stime
    json_result_wrong_resource["End Time"] = etime
    json_result_wrong_resource["Total Time"] = ttime
    with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
        feedsjson.write(json.dumps(json_result_wrong_resource))
        feedsjson.write(",")
        
def wrong_method(resource, url_part, status):
    url = r4_fhir_base_url + "/" + url_part + "/" + resource
    start_time = datetime.datetime.now()
    json_result_wrong_method = copy.deepcopy(json_result)
    json_result_wrong_method['Test Name'] = url_part + " R4 Resource Negative Test Case 3. "
    json_result_wrong_method['Test Discription'] = "This test case is to verify proper exception message sent from FHIR API when wrong method is used. "
    fhir_response = requests.request(method = "POST", url = url, headers = r4_resource_header)
    if fhir_response.status_code == 405:
        fhir_response_str = str(fhir_response.text)
        json_data = json.loads(fhir_response_str)
        if json_data['error'] == 'Method Not Allowed':
            print(url_part, " R4 Resource Wrong Method Test Case Passed.")
            json_result_wrong_method['Test Result'] = "Pass"
        else:
            print(url_part, " R4 Resource Wrong Method Test Case Failed.")
            json_result_wrong_method['Test Result'] = "Fail"
    else:
        print(url_part, " R4 Resource Wrong IAM Token Test Case Failed. Wrong status code or response")
        json_result_wrong_method['Test Result'] = "Fail"
    end_time = datetime.datetime.now()
    total_time = end_time - start_time
    stime = str(start_time)
    etime = str(end_time)
    ttime = str(total_time)
    json_result_wrong_method["Start Time"] = stime
    json_result_wrong_method["End Time"] = etime
    json_result_wrong_method["Total Time"] = ttime
    if status == 'running':
        with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(json_result_wrong_method))
            feedsjson.write(",")
    elif status == 'finish':
        with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(json_result_wrong_method))
        print("Test Case Execution  Finished")

def test_runner(resource, url_part, status):
    wrong_iam_token(resource, url_part)
    wrong_resource(resource, url_part)
    wrong_method(resource, url_part, status)

# Test Running for allergyintolerance
test_runner(allergyintolerance_resource, allergyintolerance_url, "running")

# Test Running for condition
test_runner(condition_resource, condition_url, "running")

# Test Running for encounter
test_runner(encounter_resource, encounter_url, "running")

# Test Running for immunization
test_runner(immunization_resource, immunization_url, "running")

# Test Running for medication
test_runner(medication_resource, medication_url, "running")

# Test Running for medicationrequest
test_runner(medicationrequest_resource, medicationrequest_url, "running")

# Test Running for medicationStatement
test_runner(medicationStatement_resource, medicationStatement_url, "running")

# Test Running for observation
test_runner(observation_resource, observation_url, "running")

# Test Running for organization
test_runner(organization_resource, organization_url, "running")

# Test Running for patient
test_runner(patient_resource, patient_url, "running")

# Test Running for practitioner
test_runner(practitioner_resource, practitioner_url, "finish")
