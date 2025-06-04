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
AllergyIntollerence_folder = directory +'/Dataset/'   
if not os.path.exists(AllergyIntollerence_folder):
    os.makedirs(AllergyIntollerence_folder)
    
def AllergyIntolerance_files(patient_newname,new_patient_id):  
    Allergy_code = ["Fish - dietary (substance)","Penicillin G","Cashew nuts"]
    category = ['food', 'medication']
    system = ["http://snomed.info/sct","http://www.nlm.nih.gov/research/umls/rxnorm"]
    coding = ["227037002","7980","227493005"]
    code1 = Allergy_code[r.randint(0,(len(Allergy_code)-1))]     
    if (code1 == "Cashew nuts" or "Fish - dietary (substance)"):
        code2 = category[(len(category)-2)]
        system_value = system[(len(system)-2)]
        coding_value = coding[(len(coding)-1)]
        if (code1 == "Fish - dietary (substance)"):
            coding_value = coding[(len(coding)-3)]
    if (code1 == "Penicillin G"):
        code2 = category[(len(category)-1)]
        system_value = system[(len(system)-1)]
        coding_value = coding[(len(coding)-2)]
    Allergy_id = uuid.uuid4()
    with open(directory + '/Sample_Template/AllergyIntolerance.json') as dataset:
        jsonData = json.load(dataset)
        oldid = jsonData['id']
        jsonData['id'] = str(Allergy_id)
        jsonData['patient']['reference']= "Patient/"+ str(new_patient_id)
        jsonData['patient']['display'] = str(patient_newname)
        jsonData['code']['coding'][0]['system'] = system_value
        jsonData['code']['coding'][0]['code'] = coding_value
        jsonData['code']['coding'][0]['display'] = code1
        jsonData['code']['text'] = code1
        jsonData['category'][0] = code2
        resourceJson = jsonData.copy()
        jsonData['resourceJson'] = json.dumps(resourceJson)
    filename_Allergy = "Allergyintolerance.json"
    with open(AllergyIntollerence_folder + filename_Allergy, mode='w', encoding='utf-8') as feedsjson:
        feedsjson.write(json.dumps(jsonData))
        feedsjson.close()
    print(filename_Allergy)
