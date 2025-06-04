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
allergyintolerence_folder = directory +'/dataset/allergyintolerence/'   
if not os.path.exists(allergyintolerence_folder):
    os.makedirs(allergyintolerence_folder)
    
def allergyintolerance_files(patient_newname,new_patient_id):  
    allergy_code = ["Fish - dietary (substance)","Penicillin G","Cashew nuts"]
    category = ['food', 'medication']
    system = ["http://snomed.info/sct","http://www.nlm.nih.gov/research/umls/rxnorm"]
    coding = ["227037002","7980","227493005"]
    code1 = allergy_code[r.randint(0,(len(allergy_code)-1))]     
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
    allergy_id = uuid.uuid4()
    with open(directory + '/Sample_Template/AllergyIntolerance.json') as dataset:
        jsonData = json.load(dataset)
        jsonData['id'] = str(allergy_id)
        jsonData['patient']['reference']= "Patient/"+ str(new_patient_id)
        jsonData['patient']['display'] = str(patient_newname)
        jsonData['code']['coding'][0]['system'] = system_value
        jsonData['code']['coding'][0]['code'] = coding_value
        jsonData['code']['coding'][0]['display'] = code1
        jsonData['code']['text'] = code1
        jsonData['category'][0] = code2
        resourceJson = jsonData.copy()
        jsonData['resourceJson'] = json.dumps(resourceJson)
    filename_allergy = "allergyintolerance.json"
    with open(allergyintolerence_folder + filename_allergy, mode='a+', encoding='utf-8') as feedsjson:
        feedsjson.write(json.dumps(jsonData))
        feedsjson.close()