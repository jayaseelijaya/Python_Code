from kafka import KafkaConsumer
import requests
import json
import sys

sys.path.append.(os.path.abspath('../vault')
from get_data_from_vault import generate_iam_details
from get_data_from_vault import vault_details

#Reading Vault Details
vault_data = vault_details()

oauth2_client_id = vault_data["iam_auth_username"]
oauth2_client_pwd = vault_data["iam_auth_password"]
iam_usn = vault_data["iam_grant_username"]
iam_pwd = vault_data["iam_grant_password"]
cdrUrl = vault_data["cdr_r4_url"]
fhirOrgId = vault_data["cf_org_id"]
broker_b1 = vault_data['MSKbroker1']
broker_b2 = vault_data['MSKbroker2']
broker_b3 = vault_data['MSKbroker3']

access_token = generate_iam_details(oauth2_client_id, oauth2_client_pwd, iam_usn, iam_pwd)

# Topic List for kafka consumption
# to be taken from MDM later
topicsList = ['IBEToKafka2']

# consuming topics and posting into CDR
cdrDataUrl = cdrUrl + '/store/fhir/' + fhirOrgId

cdrHeaders = {
    'api-version' : '1',
    'Content-Type' : 'application/fhir+json;fhirVersion=4.0',
    'Accept' : 'application/fhir+json;fhirVersion=4.0',
    'Authorization' : "Bearer {}".format(access_token)
}

# Consuming Data from topic and posting to cdr
consumer = KafkaConsumer(bootstrap_servers= [broker_b1,broker_b2,broker_b3], auto_offset_reset='earliest')
consumer.subscribe(topicsList)

while True:
    for msg in consumer:
        if isinstance(msg.value, bytes):
            print("Data is in Bytes")
            msgData = msg.value.decode('utf-8')
            msgResponse = json.loads(msgData)
            print("Printing the msg format after conversion:", type(msgResponse))
        elif isinstance(msg.value, dict):
            print("Data is in Dict")
            msgResponse = msg.value
        headersInfo = msg.headers
        if not headersInfo:
            print(msgResponse['resourceType'])
            if msgResponse['resourceType'] == 'Bundle':
                cdrFinalUrl = cdrDataUrl
            else:
                cdrFinalUrl = cdrDataUrl + "/" + msgResponse['resourceType']
            response = requests.request(method="POST", url=cdrFinalUrl, headers=cdrHeaders, json=msgResponse)
            print("Response Code ", response.status_code)
            result = json.loads(response.text)
            if response.status_code == 201:
                print(f"{msgResponse['resourceType']} data uploaded into cdr store")
                print("Id ", result['id'])
                print("\n")
            elif response.status_code == 200:
                print(result)
                print(f"{msgResponse['resourceType']} data uploaded into cdr store")
                print("\n")
            else:
                print(result)
                print("Data not posted\n")
        else:
            print(f"Header data {headersInfo}")

        print("-------------------------------------------------------------------------------------------------------")