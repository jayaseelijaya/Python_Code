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
#creating observation file 
       
observation_folder = directory +'/dataset/observation/'
if not os.path.exists(observation_folder):
    os.makedirs(observation_folder)
    
def observation(patient_newname,new_patient_id,pract_id):
    code_value =[{"system": "http://loinc.org","code": "8302-2","display": "Body Height"}, {"system": "http://loinc.org","code": "29463-7","display": "Body Weight"},{"system": "http://loinc.org","code": "39156-5","display": "Body Mass Index"}, {"system": "http://loinc.org","code": "8867-4","display": "Heart rate"},{"system": "http://loinc.org","code": "9279-1","display": "Respiratory rate"},{"system": "http://loinc.org","code": "8310-5","display": "Body temperature"}]
    for observation_vital_sign in range(0,4): 
        observation_id = uuid.uuid4()
        with open(directory + '/Sample_Template/Observation_vital_signs.json') as dataset:
            jsonData = json.load(dataset)
            oldid = jsonData['id']
            jsonData['id'] = str(observation_id)
            values_code =r.randint(0,(len(code_value)-1))
            if (values_code == 1):
               jsonData['code']['coding'][0] = code_value[1]
               jsonData['code']['text'] = code_value[1]['display']
               jsonData['valueQuantity']['value']=r.randint(40,90)
               jsonData['valueQuantity']['unit'] = "kg"
               jsonData['valueQuantity']['code'] = "kg"
            if (values_code == 0):
               jsonData['code']['coding'][0] = code_value[0]
               jsonData['code']['text'] = code_value[0]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(120.1, 180.9)))
               jsonData['valueQuantity']['unit'] = "cm"
               jsonData['valueQuantity']['code'] = "cm"           
            if (values_code == 2):
               jsonData['code']['coding'][0] = code_value[2]
               jsonData['code']['text'] = code_value[2]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(18.5, 40.5)))
               jsonData['valueQuantity']['unit'] = "kg/m2"
               jsonData['valueQuantity']['code'] = "kg/m2"
            if (values_code == 3):
               jsonData['code']['coding'][0] = code_value[3]
               jsonData['code']['text'] = code_value[3]['display']
               jsonData['valueQuantity']['value']=r.randint(60,100)
               jsonData['valueQuantity']['unit']= "/min"
               jsonData['valueQuantity']['code']= "/min"
            if (values_code == 4):
               jsonData['code']['coding'][0] = code_value[4]
               jsonData['code']['text'] = code_value[4]['display']
               jsonData['valueQuantity']['value']=r.randint(11,25)
               jsonData['valueQuantity']['unit'] = "/min"
               jsonData['valueQuantity']['code'] = "/min"
            if (values_code == 5):
               jsonData['code']['coding'][0] = code_value[5]
               jsonData['code']['text'] = code_value[5]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(50,150)))
               jsonData['valueQuantity']['unit'] = "C"
               jsonData['valueQuantity']['code'] = "Cel"  
            jsonData['subject']['reference']= "Patient/"+ str(new_patient_id)
            jsonData['subject']['display'] = patient_newname
            jsonData['effectiveDateTime'] = '20' + str((r.randint(10,18))) + '-0' + str((r.randint(1,9))) + '-0' + str((r.randint(1,9))) + 'T09:30:10+01:00'
            jsonData['issued'] = '20' + str((r.randint(10,18))) + '-0' + str((r.randint(1,9))) + '-0' + str((r.randint(1,9))) + 'T03:30:10+01:00'
            resourceJson = jsonData.copy()
            jsonData['resourceJson'] = json.dumps(resourceJson)
        filename  = "observation_vital_sign" + str(observation_vital_sign) + ".json"
        with open(observation_folder + filename, mode='a+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(jsonData))
            feedsjson.close()

    code_obs = [{"system": "http://loinc.org","code": "2093-3","display": "Total Cholesterol"}, {"system": "http://loinc.org","code": "2571-8","display": "Triglycerides"}, {"system": "http://loinc.org","code": "18262-6","display": "Low Density Lipoprotein Cholesterol"}, {"system": "http://loinc.org","code": "2085-9","display": "High Density Lipoprotein Cholesterol"},{"system": "http://loinc.org","code": "6690-2","display": "Leukocytes [#/volume] in Blood by Automated count"}, {"system": "http://loinc.org","code": "789-8","display": "Erythrocytes [#/volume] in Blood by Automated count"}, {"system": "http://loinc.org","code": "718-7","display": "Hemoglobin [Mass/volume] in Blood"},{"system": "http://loinc.org","code": "4544-3","display": "Hematocrit [Volume Fraction] of Blood by Automated count"}, {"system": "http://loinc.org","code": "787-2","display": "MCV [Entitic volume] by Automated count"}, {"system": "http://loinc.org","code": "785-6","display": "MCH [Entitic mass] by Automated count"}, {"system": "http://loinc.org","code": "786-4","display": "MCHC [Mass/volume] by Automated count"},{"system": "http://loinc.org","code": "38483-4","display": "Creatinine"},{"system": "http://loinc.org","code": "49765-1","display": "Calcium"},{"system": "http://loinc.org","code": "2947-0","display": "Sodium"},{"system": "http://loinc.org","code": "6298-4","display": "Potassium"},{"system": "http://loinc.org","code": "2069-3","display": "Chloride"}]
    for observation_lab in range(0,2): 
        with open(directory + '/Sample_Template/Observation_laboratory.json') as dataset:
            observation_id = uuid.uuid4()
            jsonData = json.load(dataset)
            oldid = jsonData['id']
            jsonData['id'] = str(observation_id)
            code_value =r.randint(0,(len(code_obs)-1))
            if (code_value == 0):
               jsonData['code']['coding'][0] = code_obs[code_value]
               jsonData['code']['text'] = code_obs[code_value]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(60.5, 200.5)))
               jsonData['valueQuantity']['unit'] = "mg/dL"
               jsonData['valueQuantity']['code'] = "mg/dL"         
            if (code_value == 1):
               jsonData['code']['coding'][0] = code_obs[code_value]
               jsonData['code']['text'] = code_obs[code_value]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(70.5, 160.5)))
               jsonData['valueQuantity']['unit'] = "mg/dL"
               jsonData['valueQuantity']['code'] = "mg/dL"
            if (code_value == 2):
               jsonData['code']['coding'][0] = code_obs[code_value]
               jsonData['code']['text'] = code_obs[code_value]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(
               50.5, 120.5)))
               jsonData['valueQuantity']['unit']= "mg/dL"
               jsonData['valueQuantity']['code']= "mg/dL"
            if (code_value == 3):
               jsonData['code']['coding'][0] = code_obs[code_value]
               jsonData['code']['text'] = code_obs[code_value]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(
               40.5, 60.5)))
               jsonData['valueQuantity']['unit'] = "mg/dL"
               jsonData['valueQuantity']['code'] = "mg/dL"
            if (code_value == 4):
               jsonData['code']['coding'][0] = code_obs[code_value]
               jsonData['code']['text'] = code_obs[code_value]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(4.5,12)))
               jsonData['valueQuantity']['unit'] = "10*3/uL"
               jsonData['valueQuantity']['code'] = "10*3/uL"         
            if (code_value == 5):
               jsonData['code']['coding'][0] = code_obs[code_value]
               jsonData['code']['text'] = code_obs[code_value]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(4.2,5.9)))
               jsonData['valueQuantity']['unit'] = "10*6/uL"
               jsonData['valueQuantity']['code'] = "10*6/uL"
            if (code_value == 6):
               jsonData['code']['coding'][0] = code_obs[code_value]
               jsonData['code']['text'] = code_obs[code_value]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(14.1,18)))
               jsonData['valueQuantity']['unit']= "g/dL"
               jsonData['valueQuantity']['code']= "g/dL"
            if (code_value == 7):
               jsonData['code']['coding'][0] = code_obs[code_value]
               jsonData['code']['text'] = code_obs[code_value]['display']
               jsonData['valueQuantity']['value']=r.randint(30,55)
               jsonData['valueQuantity']['unit'] = "%"
               jsonData['valueQuantity']['code'] = "%"
            if (code_value == 8):
               jsonData['code']['coding'][0] = code_obs[code_value]
               jsonData['code']['text'] = code_obs[code_value]['display']
               jsonData['valueQuantity']['value']=r.randint(70,100)
               jsonData['valueQuantity']['unit'] = "fL"
               jsonData['valueQuantity']['code'] = "fL"
            if (code_value == 9):
               jsonData['code']['coding'][0] = code_obs[code_value]
               jsonData['code']['text'] = code_obs[code_value]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(27.5,33.5)))
               jsonData['valueQuantity']['unit'] = "pg"
               jsonData['valueQuantity']['code'] = "pg"
            if (code_value == 10):
               jsonData['code']['coding'][0] = code_obs[code_value]
               jsonData['code']['text'] = code_obs[code_value]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(30,37.5)))
               jsonData['valueQuantity']['unit'] = "g/dL"
               jsonData['valueQuantity']['code'] = "g/dL"
            if (code_value == 11):
               jsonData['code']['coding'][0] = code_obs[code_value]
               jsonData['code']['text'] = code_obs[code_value]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(0.6,1.2)))
               jsonData['valueQuantity']['unit'] = "mg/dL"
               jsonData['valueQuantity']['code'] = "mg/dL"
            if (code_value == 12):
               jsonData['code']['coding'][0] = code_obs[code_value]
               jsonData['code']['text'] = code_obs[code_value]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(6,11)))
               jsonData['valueQuantity']['unit'] = "mg/dL"
               jsonData['valueQuantity']['code'] = "mg/dL"
            if (code_value == 13):
               jsonData['code']['coding'][0] = code_obs[code_value]
               jsonData['code']['text'] = code_obs[code_value]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(130,150)))
               jsonData['valueQuantity']['unit'] = "mmol/L"
               jsonData['valueQuantity']['code'] = "mmol/L"
            if (code_value == 14):
               jsonData['code']['coding'][0] = code_obs[code_value]
               jsonData['code']['text'] = code_obs[code_value]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(3.0,5.9)))
               jsonData['valueQuantity']['unit'] = "mmol/L"
               jsonData['valueQuantity']['code'] = "mmol/L"
            if (code_value == 15):
               jsonData['code']['coding'][0] = code_obs[code_value]
               jsonData['code']['text'] = code_obs[code_value]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(80,200)))
               jsonData['valueQuantity']['unit'] = "mmol/L"
               jsonData['valueQuantity']['code'] = "mmol/L"
            jsonData['subject']['reference']= "Patient/"+ str(new_patient_id)
            jsonData['subject']['display'] = patient_newname
            jsonData['effectiveDateTime'] = '20' + str((r.randint(10,18))) + '-0' + str((r.randint(1,9))) + '-0' + str((r.randint(1,9))) + 'T09:30:10+01:00'
            jsonData['issued'] = '20' + str((r.randint(10,18))) + '-0' + str((r.randint(1,9))) + '-0' + str((r.randint(1,9))) + 'T03:30:10+01:00'
            resourceJson = jsonData.copy()
            jsonData['resourceJson'] = json.dumps(resourceJson)
        filename  = "observation_laboratory" + str(observation_lab) + ".json"
        with open(observation_folder + filename, mode='a+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(jsonData))
            feedsjson.close()
         
        with open(directory + '/Sample_Template/Observation_blood_pressure.json') as dataset:
            observation_id = uuid.uuid4()
            jsonData = json.load(dataset)
            oldid = jsonData['id']
            jsonData['id'] = str(observation_id)
            jsonData['subject']['reference']= "Patient/"+ str(new_patient_id)
            jsonData['subject']['display'] = patient_newname
            jsonData['effectiveDateTime'] = '20' + str((r.randint(10,18))) + '-0' + str((r.randint(1,9))) + '-0' + str((r.randint(1,9))) + 'T09:30:10+01:00'
            jsonData['issued'] = '20' + str((r.randint(10,18))) + '-0' + str((r.randint(1,9))) + '-0' + str((r.randint(1,9))) + 'T03:30:10+01:00'
            jsonData['component'][0]['valueQuantity']['value']= (r.randint(50,85))
            jsonData['component'][1]['valueQuantity']['value']= (r.randint(100,129))
            resourceJson = jsonData.copy()
            jsonData['resourceJson'] = json.dumps(resourceJson)
        filename   = "observation_blood_pressure" + str(observation_lab) + ".json" 
        with open(observation_folder + filename, mode='a+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(jsonData))
            feedsjson.close()

    code_co2 = [{"system": "http://loinc.org","code": "15074-8","display": "Glucose [Moles/volume] in Blood"},
                {"system": "http://loinc.org","code": "11557-6","display": "Carbon dioxide in blood"}]
    for observation_lab in range(0,2): 
        with open(directory + '/Sample_Template/Observation.json') as dataset:
            observation_id = uuid.uuid4()
            jsonData = json.load(dataset)
            oldid = jsonData['id']
            jsonData['id'] = str(observation_id)
            values_code =r.randint(0,(len(code_co2)))
            if (values_code == 0):
                jsonData['code']['coding'][0] = code_co2[values_code]
                jsonData['code']['text'] = code_co2[values_code]['display']
                jsonData['valueQuantity']['value'] = float("{:.2f}".format(r.uniform(1.5, 50.5)))
                jsonData['referenceRange'][0]['low']['value'] = float("{:.1f}".format(r.uniform(1.5, 4)))
                jsonData['referenceRange'][0]['high']['value'] = float("{:.1f}".format(r.uniform(1.5, 6.9)))
            if (values_code == 1):
               jsonData['code']['coding'][0] = code_co2[values_code]
               jsonData['code']['text'] = code_co2[values_code]['display']
               jsonData['valueQuantity']['value']=float("{:.2f}".format(r.uniform(4,6)))
               jsonData['valueQuantity']['unit'] = "kPa"
               jsonData['valueQuantity']['code'] = "kPa"
               jsonData['referenceRange'][0]['low']['value']=float("{:.2f}".format(r.uniform(4,6)))
               jsonData['referenceRange'][0]['low']['unit'] = "kPa"
               jsonData['referenceRange'][0]['low']['code'] = "kPa"
               jsonData['referenceRange'][0]['high']['value']=float("{:.2f}".format(r.uniform(4,6)))
               jsonData['referenceRange'][0]['high']['unit'] = "kPa"
               jsonData['referenceRange'][0]['high']['code'] = "kPa"
               resourceJson = jsonData.copy()
               jsonData['resourceJson'] = json.dumps(resourceJson)
            jsonData['subject']['reference']= "Patient/"+ str(new_patient_id)
            jsonData['subject']['display'] = patient_newname
            jsonData['performer'][0]['reference'] = "Practitioner/" + str(pract_id)
            jsonData['effectivePeriod']['start'] = '20' + str((r.randint(10,18))) + '-0' + str((r.randint(1,9))) + '-0' + str((r.randint(1,9))) + 'T09:30:10+01:00'
            jsonData['issued'] = '20' + str((r.randint(10,18))) + '-0' + str((r.randint(1,9))) + '-0' + str((r.randint(1,9))) + 'T03:30:10+01:00'
        filename   = "observation_laboratory" + str(observation_lab) + ".json" 
        with open(observation_folder + filename, mode='a+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(jsonData))
            feedsjson.close()