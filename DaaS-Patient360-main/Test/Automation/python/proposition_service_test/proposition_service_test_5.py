import json
import time
import datetime
import requests
import sys

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

proposition_service_url = vault_data['proposition_service_url']

with open(home_path + '/Test/Automation/python/proposition_service_test/blank_profile_name_header.json','r') as data:
    blank_profile_name_header = json.load(data)

post_call_header = {
    'accept': '*/*',
    'Content-Type': 'application/json'
}

test_result = {
    "Test Name" : "Verification of negative test for missing proposition name",
    "Test Discription" : "Verify the proposition service will give error when proposition name is missing in header.",
    "Test Result" : "",
    "Start Time" : "",
    "End Time" : "",
    "Total Time" : ""
}

try:
    start_time = datetime.datetime.now()

    response = requests.request(method = "POST", url = proposition_service_url, headers = post_call_header, json = blank_profile_name_header)
    result = json.loads(response.text)
    if response.status_code == 500:
        print("Verification of negative test for missing proposition name is passed")
        test_result['Test Result'] = "Pass"

    elif response.status_code == 200:
        print("Verification of negative test for missing proposition name failed")
        test_result['Test Result'] = "Fail"

    else:
        print("Verification of negative test for missing proposition name is failed")
        test_result['Test Result'] = "Fail"

    end_time = datetime.datetime.now()

except:
    print("Verification of negative test for missing proposition name failed. Exception raised")
    test_result['Test Result'] = "Fail"
    end_time = datetime.datetime.now()

total_time = end_time - start_time
test_result["Start Time"] = str(start_time)
test_result["End Time"] = str(end_time)
test_result["Total Time"] = str(total_time)

with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
    feedsjson.write(json.dumps(test_result))
    feedsjson.write(",")