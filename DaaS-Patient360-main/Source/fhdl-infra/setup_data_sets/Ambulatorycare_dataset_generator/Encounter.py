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

directory = os.getcwd()
#creating Ecounter file  
      
encounter_folder = directory +'/dataset/ecounter/'
if not os.path.exists(encounter_folder):
    os.makedirs(encounter_folder)
    
def encounter(patient_newname,new_patient_id,pract_id,Org_id):
    with open(directory + '/Sample_Template/Ecounter.json') as dataset:
        encounter_id = uuid.uuid4()
        jsonData = json.load(dataset)
        oldid = jsonData['id']
        jsonData['id'] = str(encounter_id)
        jsonData['subject']['reference']= "Patient/"+ str(new_patient_id)
        jsonData['subject']['display'] = str(patient_newname)
        jsonData['serviceProvider']['reference'] = "Organization/" + str(Org_id)
        jsonData['participant'][0]['individual']['reference'] = "Practitioner/" + str(pract_id)
        jsonData['identifier'][0]['value'] = str(encounter_id)
        jsonData['participant'][0]['period']['start'] = "2021" + '_0' + str(r.randint(1,4))+ '_0' + str(r.randint(1,9))
        jsonData['participant'][0]['period']['end'] = "2021" + '_0' + str(r.randint(5,9))+ '_0' + str(r.randint(1,9))
        jsonData['period']['start'] = "2021" + '_0' + str(r.randint(1,4))+ '_0' + str(r.randint(1,9))
        jsonData['period']['end'] = "2021" + '_0' + str(r.randint(5,9))+ '_0' + str(r.randint(1,9))
        resourceJson = jsonData.copy()
        jsonData['resourceJson'] = json.dumps(resourceJson)
    filename_encounter = "encounter.json"
    with open(encounter_folder + filename_encounter, mode='a+', encoding='utf-8') as feedsjson:
        feedsjson.write(json.dumps(jsonData))
        return encounter_id
        feedsjson.close()
    print(filename_Encounter)
    
