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

#Creating Immunization file 
immunization_folder = directory +'/dataset/immunization/'

if not os.path.exists(immunization_folder):
    os.makedirs(immunization_folder)  

def immunization_resource(patient_newname,new_patient_id,Org_id):
     for i in range(0,3):
        immunization_id = uuid.uuid4()
        iot_number = ['AAJN11K', 'PT123F', 'PPL909K']
        code = ["IA", "IC", "ICOR", "IOSSC", "IT", "IV", "IPINHL", "ORIFINHL", "REBREATH", "CHOLINJ", "CERVINJ","EPIDURINJ", "EPIINJ", "EXTCORPINJ", "GBINJ", "GINGINJ"]
        iot_number_vaccine = iot_number[r.randint(0,len(iot_number)-1)]
        data_file = directory + '/code_values/code_immunization.txt'
        text_file = open(data_file, "r")
        lines = text_file.read().split(',')
        value = r.randint(0,len(code)-1)
        with open(directory + '/Sample_Template/Immunization.json') as dataset:
            jsonData = json.load(dataset)
            oldid = jsonData['id']
            jsonData['id'] = str(immunization_id)
            if (value == 0):
                jsonData['vaccineCode']['coding'][0]['code'] =str(code[value])
                jsonData['vaccineCode']['coding'][0]['display'] =str(lines[0])
                jsonData['route']['coding'][0]['code'] = str(code[value])
                jsonData['route']['coding'][0]['display'] = str(lines[0])
            if (value == 1):
                jsonData['vaccineCode']['coding'][0]['code'] =str(code[value])
                jsonData['vaccineCode']['coding'][0]['display'] =str(lines[1])
                jsonData['route']['coding'][0]['code'] = str(code[value])
                jsonData['route']['coding'][0]['display'] = str(lines[1])
            if (value == 2):
                jsonData['vaccineCode']['coding'][0]['code'] =str(code[value])
                jsonData['vaccineCode']['coding'][0]['display'] =str(lines[2])
                jsonData['route']['coding'][0]['code'] = str(code[value])
                jsonData['route']['coding'][0]['display'] = str(lines[2])
            if (value == 3):
                jsonData['vaccineCode']['coding'][0]['code'] =str(code[value])
                jsonData['vaccineCode']['coding'][0]['display'] =str(lines[3])
                jsonData['route']['coding'][0]['code'] = str(code[value])
                jsonData['route']['coding'][0]['display'] = str(lines[3])
            if (value == 4):
                jsonData['vaccineCode']['coding'][0]['code'] =str(code[value])
                jsonData['vaccineCode']['coding'][0]['display'] =str(lines[4])
                jsonData['route']['coding'][0]['code'] = str(code[value])
                jsonData['route']['coding'][0]['display'] = str(lines[4])
            if (value == 5):
                jsonData['vaccineCode']['coding'][0]['code'] =str(code[value])
                jsonData['vaccineCode']['coding'][0]['display'] =str(lines[5])
                jsonData['route']['coding'][0]['code'] = str(code[value])
                jsonData['route']['coding'][0]['display'] = str(lines[5])
            if (value == 6):
                jsonData['vaccineCode']['coding'][0]['code'] =str(code[value])
                jsonData['vaccineCode']['coding'][0]['display'] =str(lines[6])
                jsonData['route']['coding'][0]['code'] = str(code[value])
                jsonData['route']['coding'][0]['display'] = str(lines[6])
            if (value == 7):
                jsonData['vaccineCode']['coding'][0]['code'] =str(code[value])
                jsonData['vaccineCode']['coding'][0]['display'] =str(lines[7])
                jsonData['route']['coding'][0]['code'] = str(code[value])
                jsonData['route']['coding'][0]['display'] = str(lines[7])
            if (value == 8):
                jsonData['vaccineCode']['coding'][0]['code'] =str(code[value])
                jsonData['vaccineCode']['coding'][0]['display'] =str(lines[8])
                jsonData['route']['coding'][0]['code'] = str(code[value])
                jsonData['route']['coding'][0]['display'] = str(lines[8])
            if (value == 9):
                jsonData['vaccineCode']['coding'][0]['code'] =str(code[value])
                jsonData['vaccineCode']['coding'][0]['display'] =str(lines[9])
                jsonData['route']['coding'][0]['code'] = str(code[value])
                jsonData['route']['coding'][0]['display'] = str(lines[9])
            if (value == 10):
                jsonData['vaccineCode']['coding'][0]['code'] =str(code[value])
                jsonData['vaccineCode']['coding'][0]['display'] =str(lines[10])
                jsonData['route']['coding'][0]['code'] = str(code[value])
                jsonData['route']['coding'][0]['display'] = str(lines[10])
            if (value == 11):
                jsonData['vaccineCode']['coding'][0]['code'] =str(code[value])
                jsonData['vaccineCode']['coding'][0]['display'] =str(lines[11])
                jsonData['route']['coding'][0]['code'] = str(code[value])
                jsonData['route']['coding'][0]['display'] = str(lines[11])
            if (value == 12):
                jsonData['vaccineCode']['coding'][0]['code'] =str(code[value])
                jsonData['vaccineCode']['coding'][0]['display'] =str(lines[12])
                jsonData['route']['coding'][0]['code'] = str(code[value])
                jsonData['route']['coding'][0]['display'] = str(lines[12])
            if (value == 13):
                jsonData['vaccineCode']['coding'][0]['code'] =str(code[value])
                jsonData['vaccineCode']['coding'][0]['display'] =str(lines[13])
                jsonData['route']['coding'][0]['code'] = str(code[value])
                jsonData['route']['coding'][0]['display'] = str(lines[13])
            if (value == 14):
                jsonData['vaccineCode']['coding'][0]['code'] =str(code[value])
                jsonData['vaccineCode']['coding'][0]['display'] =str(lines[14])
                jsonData['route']['coding'][0]['code'] = str(code[value])
                jsonData['route']['coding'][0]['display'] = str(lines[14])
            if (value == 15):
                jsonData['vaccineCode']['coding'][0]['code'] =str(code[value])
                jsonData['vaccineCode']['coding'][0]['display'] =str(lines[15])
                jsonData['route']['coding'][0]['code'] = str(code[value])
                jsonData['route']['coding'][0]['display'] = str(lines[15])
            jsonData['lotNumber'] = iot_number_vaccine
            jsonData['doseQuantity']['value'] = r.randint(0,10)
            jsonData['expirationDate'] = str(r.randint(2023,2025)) + '_0' + str(r.randint(1,9))+ '_0' + str(r.randint(1,9))
            jsonData['patient']['reference']= "Patient/"+ str(new_patient_id)
            jsonData['manufacturer']['reference'] = "Organization/" + str(Org_id)
            jsonData['patient']['display'] = patient_newname
            resourceJson = jsonData.copy()
            jsonData['resourceJson'] = json.dumps(resourceJson)
        filename  = "immunization" + ".json"
        with open(immunization_folder + filename, mode='a+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(jsonData))
            feedsjson.close()

     