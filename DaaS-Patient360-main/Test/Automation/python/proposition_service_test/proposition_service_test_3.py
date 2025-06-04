import json
import time
import subprocess
import boto3
import datetime
import sys

from botocore.exceptions import ClientError
from aws_schema_registry import DataAndSchema, SchemaRegistryClient
from aws_schema_registry.avro import AvroSchema

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

with open(home_path + '/Test/Automation/python/proposition_service_test/proposition_details.json','r') as dataset:
    proposition_details = json.load(dataset)

schema_name = proposition_details["Profile Name"]
registry_name = proposition_details["Proposition Name"]

test_result = {
    "Test Name" : "Verification of Schema in Glue Registry",
    "Test Discription" : "Verify the Proposition service have stored valid Schema Glue Registry",
    "Test Result" : "",
    "Start Time" : "",
    "End Time" : "",
    "Total Time" : ""
}

try:
    start_time = datetime.datetime.now()

    session = boto3.Session(aws_access_key_id=aws_access_key, aws_secret_access_key=aws_secret_key, region_name=region_name, aws_session_token =aws_session_token)

    glue_client = session.client('glue')
    schema_message = glue_client.get_schema_version(
        SchemaId={
            'SchemaName': schema_name,
            'RegistryName': registry_name
        },
        SchemaVersionNumber={
            'LatestVersion': True
        }
    )
    schema = schema_message['SchemaDefinition']
    schema_details = json.loads(schema)
    if schema_details:
        print("Verification of schema in Glue registry passed.")
        print("Deleteing Schema created for testing")
        try:
            delete_schema_response = glue_client.delete_schema(
                SchemaId={
                    'SchemaName': schema_name,
                    'RegistryName': registry_name
                }
            )
            print("delete_schema_response", delete_schema_response)
            delete_registry_response = glue_client.delete_registry(
                RegistryId={
                    'RegistryName': registry_name
                }
            )
            print("delete_registry_response", delete_registry_response)
            test_result['Test Result'] = "Pass"
        except:
            print("Error while deleting Schema craeted for testing")
            test_result['Test Result'] = "Fail"        
    else:
        print("Verification of schema in Glue registry failed.")
        test_result['Test Result'] = "Fail"

    end_time = datetime.datetime.now()

except:
    print("Verification of schema in Glue registry failed. Exception raised")
    test_result['Test Result'] = "Fail"
    end_time = datetime.datetime.now()

total_time = end_time - start_time
test_result["Start Time"] = str(start_time)
test_result["End Time"] = str(end_time)
test_result["Total Time"] = str(total_time)

with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
    feedsjson.write(json.dumps(test_result))
    feedsjson.write(",")