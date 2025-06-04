import base64
import requests
import json
import os
import sys

client_id = sys.argv[1]
client_pwd = sys.argv[2]
grant_username = sys.argv[3]
grant_password = sys.argv[4]
WORKSPACE = sys.argv[5]

print("Starting Subscribe CDR Dicom Store Test Case")

# Reading config file for URLs
with open(WORKSPACE + "/Source/fhdl-infra/subscribe-cdr-dicom-store/subscriptions/cicd_config.json") as json_data_file:
    config_data = json.load(json_data_file)
iam_url         = config_data['iam_url']
cdr_url         = config_data['cdr_url']
fhir_org_id     = config_data['fhir_org_id']

#Generate IAM token
#print( "Getting IAM Token...")
iam_auth = base64.b64encode((client_id + ":" + client_pwd).encode("utf-8")).decode('ascii')
cdr_listener_auth = base64.b64encode(("admin" + ":" + "admin").encode("utf-8")).decode('ascii')
url = iam_url + "/authorize/oauth2/token"
payload = "grant_type=password&username=" + grant_username + "&password=" + grant_password

headers = {
  'Content-Type': 'application/x-www-form-urlencoded',
  'api-version': '2',
  'Authorization': 'Basic ' + iam_auth
}
response = requests.request("POST", url, headers=headers, data = payload)
if response.status_code == 400:
    print("Fail as IAM token is not generated.")
    sys.exit(0)
elif response.status_code == 200:
    authData = json.loads(response.text)


#Subscription of Files Template for CDR & DICOM  Store
subscriptionFile_Path = WORKSPACE + '/Source/fhdl-infra/subscribe-cdr-dicom-store/subscriptions/subscriptions_template.json'
#Criteria Type File to be configured as per requuired
criteriaTypeFile_Path = WORKSPACE + '/Source/fhdl-infra/subscribe-cdr-dicom-store/subscriptions/criteriaType.json'

with open(criteriaTypeFile_Path, 'r+') as criteriaTypeFile:
     criteriaType = criteriaTypeFile.read()

# Reading from file
criteriaTypeData = json.loads(criteriaType)

# Closing criteriaTypeFile
criteriaTypeFile.close()

# Iterating through the json criteriaTypeFile
# list
for subscriptionCriteria in criteriaTypeData['criteria']:

        with open(subscriptionFile_Path, 'r+') as subscriptionFile:
            subscriptionFiledata = subscriptionFile.read()

        subscriptionFiledata = subscriptionFiledata.replace('[IAMAUTH]',cdr_listener_auth)
        subscriptionFiledata = subscriptionFiledata.replace('[SUBSCRIPTIONS]', subscriptionCriteria)
        subscriptionFiledatajsonData = json.loads(subscriptionFiledata)

        cdrUrl = cdr_url + '/store/fhir/' + fhir_org_id + '/Subscription'
        cdrHeaders = {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        'Authorization': 'Bearer ' + authData['access_token'],
        'api-version': '1'
        }
        response = requests.request(method = "POST", url = cdrUrl, headers = cdrHeaders, json = subscriptionFiledatajsonData)
        print("Subscription for Criteria :", subscriptionCriteria, " and Response : ", response)
        #result = json.loads(response.text)
        #print("result :", result)

        # Closing subscriptionFile
        subscriptionFile.close()