import json
import time
import datetime
import requests
import sys
import boto3

from botocore.exceptions import ClientError

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

service_name = vault_data['service_name']
region_name = vault_data['region_name']
table_name = vault_data['table_name']
aws_access_key = vault_data['aws_access_key']
aws_secret_key = vault_data['aws_secret_key']
aws_session_token = vault_data['aws_session_token']

proposition_service_url = vault_data['proposition_service_url']
print(proposition_service_url)

with open(home_path + '/Test/Automation/python/proposition_service_test/proposition_details.json','r') as dataset:
    proposition_details = json.load(dataset)

schema_name = proposition_details["Profile Name"]
registry_name = proposition_details["Proposition Name"]

with open(home_path + '/Test/Automation/python/proposition_service_test/sample_structure.json','r') as dataset:
    proposition_schema = json.load(dataset)

proposition_id = ""

post_call_header = {
    'accept': '*/*',
    'Content-Type': 'application/json'
}

test_result = {
    "Test Name" : "Verification proposition service is up & running",
    "Test Discription" : "Verify the proposition service will return valid proposition id after data is posted.",
    "Test Result" : "",
    "Start Time" : "",
    "End Time" : "",
    "Total Time" : ""
}

try:
    start_time = datetime.datetime.now()

    response = requests.request(method = "POST", url = proposition_service_url, headers = post_call_header, json = proposition_details)
    response_text = str(response.text)
    url_data = json.loads(response_text)
    if response.status_code == 201:
        print(url_data)
        proposition_id = url_data["proposition_details"]["proposition_id"]
        org_id = url_data["proposition_details"]["org_id"]
        print("Verification proposition service is passed")
        test_result['Test Result'] = "Pass"
        with open("proposition_response_details.json", mode='w', encoding='utf-8') as feedjson:
            feedjson.write(json.dumps(url_data))
    else:
        test_result['Test Result'] = "Fail"
        dynamo_client = boto3.resource(service_name = service_name, region_name = region_name,
                  aws_access_key_id = aws_access_key,
                  aws_secret_access_key = aws_secret_key, aws_session_token =aws_session_token)
        product_table = dynamo_client.Table(table_name)
        response = product_table.scan(TableName=table_name)
        json_object = json.dumps(response, indent = 4)
        data = json.loads(json_object)
        for x in range(product_table.item_count):
            profile_name = data['Items'][x]['profileName']
            if profile_name == proposition_details["Profile Name"]:
                proposition_id = data['Items'][x]['propositionId']
        if (proposition_id):
            try:
                delete_response = product_table.delete_item(Key={"propositionId": proposition_id})
                print("Proposition MDM details deleted for retry", delete_response)
                session = boto3.Session(aws_access_key_id=aws_access_key, aws_secret_access_key=aws_secret_key, region_name=region_name, aws_session_token =aws_session_token)
                glue_client = session.client('glue')
                delete_schema_response = glue_client.delete_schema(
                SchemaId={
                        'SchemaName': schema_name,
                        'RegistryName': registry_name
                    }
                )
                print("Deleted Glue schema to retry", delete_schema_response)
                delete_registry_response = glue_client.delete_registry(
                    RegistryId={
                        'RegistryName': registry_name
                    }
                )
                print("Deleted Glue registry to retry", delete_registry_response)
                print("Retrying to post proposition")
                response = requests.request(method = "POST", url = proposition_service_url, headers = post_call_header, json = proposition_details)
                response_text = str(response.text)
                url_data = json.loads(response_text)
                proposition_id = url_data["proposition_details"]["proposition_id"]
                org_id = url_data["proposition_details"]["org_id"]

                if response.status_code == 201:
                    print("Verification proposition service is passed")
                    test_result['Test Result'] = "Pass"
                    with open("proposition_response_details.json", mode='w', encoding='utf-8') as feedjson:
                        feedjson.write(json.dumps(url_data))
                else:
                    print("Second Time Failuer to post proposition")
                    print("Verification proposition service is failed ")
                    test_result['Test Result'] = "Fail"
            except Exception as e:
                print(e)
                print("Verification proposition service is failed ")
                test_result['Test Result'] = "Fail"
    end_time = datetime.datetime.now()

except Exception as e:
    print(e)
    print("Verification proposition service is failed. Exception raised")
    test_result['Test Result'] = "Fail"
    end_time = datetime.datetime.now()

total_time = end_time - start_time
test_result["Start Time"] = str(start_time)
test_result["End Time"] = str(end_time)
test_result["Total Time"] = str(total_time)

with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
    feedsjson.write(json.dumps(test_result))
    feedsjson.write(",")