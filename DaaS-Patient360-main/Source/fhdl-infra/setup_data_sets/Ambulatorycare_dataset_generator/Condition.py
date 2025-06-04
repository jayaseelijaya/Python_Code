import base64
import requests
import json
import os
import sys
import time
import subprocess
import names
import random as r
import datetime
from datetime import datetime
import uuid
import calendar

directory = os.getcwd()

condition_folder = directory +'/dataset/condition/'
if not os.path.exists(condition_folder):
    os.makedirs(condition_folder)
    
def condition_dataset(patient_newname,new_patient_id,pract_id,new_encounter_id):
    for i in range(0,4):
     #creating Condition file     
        condition_id = uuid.uuid4()
        with open(directory + '/Sample_Template/Condition.json') as dataset:
            jsonData = json.load(dataset)
            oldid = jsonData['id']
            update_clinical_status = ('active', 'resolved', 'inactive')
            clinical_status = update_clinical_status[r.randint(0,len(update_clinical_status)-1)]
            update_verification_status = ('confirmed', 'differential')
            verification_status = update_verification_status[r.randint(0,len(update_verification_status)-1)]
            category = ('Problem List Item', 'Encounter Diagnosis', 'Problem', 'diagnosis')
            category_code = category[r.randint(0,len(category)-1)]
            severity = ('Severe', 'Moderate to severe', 'Moderate', 'Mild to moderate', 'Mild')
            severity_code = severity[r.randint(0,len(category)-1)]
            code = ({"system": "http://snomed.info/sct", "code": "254637007", "display": "Acute renal insufficiency specified as due to procedure"},
                    {"system": "http://snomed.info/sct", "code": "254637007", "display": "Malignant neoplastic disease"},
                    {"system": "http://snomed.info/sct", "code": "254637007", "display": "Bacterial sepsis"},
                    {"system": "http://snomed.info/sct", "code": "254637007", "display": "Bacterial infectious disease"},
                    {"system": "http://snomed.info/sct", "code": "254637007", "display": "Heart valve disorder"},
                    {"system": "http://snomed.info/sct", "code": "254637007", "display": "NSCLC - Non-small cell lung cancer"},
                    {"system": "http://snomed.info/sct", "code": "254637007", "display": "Retropharyngeal abscess"},
                    {"system": "http://snomed.info/sct", "code": "254637007", "display": "Ischemic stroke (disorder)"},
                    {"system": "http://snomed.info/sct", "code": "254637007", "display": "Family history of cancer of colon"})
            code = ('Malignant neoplastic disease', 'Bacterial sepsis', 'Acute renal insufficiency specified as due to procedure',
                    'Bacterial infectious disease', 'Heart valve disorder', 'NSCLC - Non-small cell lung cancer',
                    'Retropharyngeal abscess', 'Ischemic stroke (disorder)', 'Family history of cancer of colon')
            coding_code = code[r.randint(0,len(code)-1)]
            body_site = ('Entire retropharyngeal area', 'Thorax', 'Left thorax', 'Kidney', 'Pulmonary vascular structure', 
            'Entire head and neck', 'Entire body as a whole', 'Left external ear structure')
            body_site_code = body_site[r.randint(0,len(body_site)-1)]
            jsonData['id'] = str(condition_id)
            jsonData['clinicalStatus'] = clinical_status
            jsonData['verificationStatus'] = verification_status
            month_num = str((r.randint(1,9)))
            year = '201' + str((r.randint(1,9)))
            date = str((r.randint(1,9)))
            jsonData['onsetDateTime'] = year + '-0' + month_num + '-0' + date
            jsonData['abatementDateTime'] = '201' + str((r.randint(1,9))) + '-0' + str((r.randint(1,9))) + '-0' + str((r.randint(1,9)))
            datetime_object = datetime.strptime(month_num, "%m")
            full_month_name = datetime_object.strftime("%B")
            jsonData['abatementString'] = "around" + ' ' + str(full_month_name) + ' ' + date + ',' + ' ' + year
            jsonData['assertedDate'] = '201' + str((r.randint(1,9))) + '-0' + str((r.randint(1,9))) + '-0' + str((r.randint(1,9))) 
            jsonData['category'][0]['coding'][0]['code'] = str((r.randint(109401001,809401001)))
            jsonData['severity']['coding'][0]['code'] = str((r.randint(109401001,809401001)))
            jsonData['category'][0]['coding'][0]['display'] = category_code
            jsonData['severity']['coding'][0]['display'] = severity_code
            jsonData['code']['coding'][0]['display'] = coding_code
            jsonData['asserter']['reference'] = "Practitioner/" + str(pract_id) 
            jsonData['subject']['reference']= "Patient/"+ str(new_patient_id)
            jsonData['bodySite'][0]['coding'][0]['code'] = str((r.randint(109401001,809401001)))
            jsonData['bodySite'][0]['coding'][0]['display'] = body_site_code
            jsonData['evidence'][0]['code'][0]['coding'][0]['display']=body_site_code
            jsonData['subject']['display'] = patient_newname
            resourceJson = jsonData.copy()
            jsonData['resourceJson'] = json.dumps(resourceJson)
            jsonData['context']['reference']= "Encounter/"+ str(new_encounter_id)
        filename  = "condition" + ".json"#creating a new Condition data
        with open(condition_folder + filename, mode='a+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(jsonData))
            feedsjson.close()
            