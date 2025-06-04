import json
import time
import datetime
import requests
import sys
import copy

cf_org = sys.argv[1]
cf_space = sys.argv[2]
cf_usn = sys.argv[3]
cf_pwd = sys.argv[4]
home_path = sys.argv[5]
vault_service_instance = sys.argv[6]
api_endpoint = sys.argv[7]

# Importing common vault & IAM token module
sys.path.insert(0, home_path + "/Test/Automation/python/vault_details_iam_token")
from vault_details_iam_token import generate_iam_details
from vault_details_iam_token import vault_details

vault_data = vault_details(cf_org, cf_space, cf_usn, cf_pwd, vault_service_instance, api_endpoint)

syntaxscore_input_bundle = vault_data['syntaxscore_input_bundle']
syntaxscore_calculator = vault_data['syntaxscore_calculator']

print("syntaxscore_input_bundle", syntaxscore_input_bundle)
print("syntaxscore_calculator", syntaxscore_calculator)

with open(home_path + '/Test/Automation/python/syntax_score_standalone_test/flow_invalid.json','r') as dataset:
    jsondata = json.load(dataset)

post_call_header = {
    'accept': 'application/fhir+json; fhirVersion=4.0',
    'Content-Type': 'application/fhir+json; fhirVersion=4.0',
    'api-version' : '1'
}

test_result = {
    "Test Name" : "Verification of negative test case for Syntaxscore service bundle generation API",
    "Test Discription" : "Verification of negative test for Input Syntaxscore service bundle generation API",
    "Test Result" : "",
    "Start Time" : "",
    "End Time" : "",
    "Total Time" : ""
}

try:
    start_time = datetime.datetime.now()
    response = requests.request(method = "POST", url = syntaxscore_input_bundle, headers = post_call_header, json = jsondata)
    text = response.text
    print(text)

    if response.status_code == 500:
        print("Verification of negative test case for Syntaxscore service bundle generation API is passed ")
        test_result['Test Result'] = "Pass"
    else:
        print("Verification of negative test case for Syntaxscore service bundle generation API is Failed ")
        test_result['Test Result'] = "Fail"

except:
    print("Verification of negative test Syntaxscore service is failed. Exception raised")
    test_result['Test Result'] = "Fail"
    
end_time = datetime.datetime.now()
total_time = end_time - start_time
test_result["Start Time"] = str(start_time)
test_result["End Time"]   = str(end_time)
test_result["Total Time"] = str(total_time)

with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
    feedsjson.write(json.dumps(test_result))
    feedsjson.write(",")
