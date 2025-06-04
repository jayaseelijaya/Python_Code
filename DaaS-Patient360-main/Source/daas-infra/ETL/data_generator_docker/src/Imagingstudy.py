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

Imagingstudy_folder = directory +'/Dataset/'        
if not os.path.exists(Imagingstudy_folder):
    os.makedirs(Imagingstudy_folder)
    
def imagingstudy_files(patient_newname,new_patient_id):
    #creating Imagingstudy file
    modality = [{"system": "http://dicom.nema.org/resources/ontology/DCM","code": "DX","display": "Digital Radiography"},{ "system": "http://dicom.nema.org/resources/ontology/DCM", "code": "US", "display": "Ultrasound" },
    {"system": "http://dicom.nema.org/resources/ontology/DCM","code": "CT","display": "Computed Tomography"}]
    bodysite = [{"system": "http://snomed.info/sct","code": "40983000","display": "Arm"},{
                  "system": "http://snomed.info/sct","code": "344001","display": "Ankle"},
               {"system": "http://snomed.info/sct","code": "12921003","display": "Pelvis"},{
              "system": "http://snomed.info/sct","code": "51299004","display": "Clavicle"},{
              "system": "http://snomed.info/sct","code": "51185008","display": "Chest"},{
              "system": "http://snomed.info/sct","code": "51185008","display": "Thoracic structure (body structure)"},
              {"system": "http://snomed.info/sct","code": "8205005","display": "Wrist"},
              {"system": "http://snomed.info/sct","code": "261179002","display": "thoracic"}]
    for Imagingstudy in range(0,2):
        with open(directory + '/Sample_Template/Imagingstudy.json') as dataset:
            sopClass = 'urn:oid:1.2.840.10008.5.1.4.1.1.'
            Imagingstudy_id = uuid.uuid4()
            jsonData = json.load(dataset)
            jsonData['id'] = str(Imagingstudy_id)
            jsonData['uid']= 'urn:oid:1.2.840.99999999.1.' + str(r.randint(11111111,100000000)) + '.' + '1568644917999'
            jsonData['series'][0]['uid']= 'urn:oid:1.2.840.99999999.1' + str(r.randint(1111111,100000000)) + '.' + '1568644917999'
            modality_values = r.randint(0,len(modality)-1)
            bodysite_value = r.randint(0,len(bodysite)-1)
            if(modality_values == 0 and bodysite_value == 0):
                jsonData['series'][0]['modality']=modality[0]                  
                jsonData['series'][0]['bodySite']=bodysite[0]
                jsonData['series'][0]['instance'][0]['title'] = 'Image of arm'
                jsonData['series'][0]['instance'][0]['sopClass'] = sopClass + '1'
            if (modality_values == 0 and bodysite_value == 1):
                jsonData['series'][0]['modality']=modality[0]
                jsonData['series'][0]['bodySite']=bodysite[1]
                jsonData['series'][0]['instance'][0]['title'] = 'Image of ankle'
                jsonData['series'][0]['instance'][0]['sopClass'] = sopClass + '1'
            if (modality_values == 0 and bodysite_value == 2):
                jsonData['series'][0]['modality']=modality[0]
                jsonData['series'][0]['bodySite']=bodysite[2]
                jsonData['series'][0]['instance'][0]['title'] = 'Image of pelvis'
                jsonData['series'][0]['instance'][0]['sopClass'] = sopClass + '1'
            if (modality_values == 0 and bodysite_value == 3):
                jsonData['series'][0]['modality']=modality[0]
                jsonData['series'][0]['bodySite']=bodysite[3]
                jsonData['series'][0]['instance'][0]['title'] = 'Image of clavicle'
                jsonData['series'][0]['instance'][0]['sopClass'] = sopClass + '1'
            if (modality_values == 0 and bodysite_value == 4):
                jsonData['series'][0]['modality']=modality[0]
                jsonData['series'][0]['bodySite']=bodysite[4]
                jsonData['series'][0]['instance'][0]['title'] = 'Image of chest'
                jsonData['series'][0]['instance'][0]['sopClass'] = sopClass + '1'
            if (modality_values == 0 and bodysite_value == 5):
                jsonData['series'][0]['modality']=modality[0]
                jsonData['series'][0]['bodySite']=bodysite[5]
                jsonData['series'][0]['instance'][0]['title'] = 'Plain chest X-ray'
                jsonData['series'][0]['instance'][0]['sopClass'] = sopClass + '1'
            if (modality_values == 0 and bodysite_value == 6):
                jsonData['series'][0]['modality']=modality[0]
                jsonData['series'][0]['bodySite']=bodysite[6]
                jsonData['series'][0]['instance'][0]['title'] = 'Image of wrist'
                jsonData['series'][0]['instance'][0]['sopClass'] = sopClass + '1'
            if(modality_values == 1 and bodysite_value == 7):
                jsonData['series'][0]['modality']=modality[1]           
                jsonData['series'][0]['bodySite']=bodysite[7]
                jsonData['series'][0]['instance'][0]['title'] = 'Ultrasound Multiframe Image Storage'
                jsonData['series'][0]['instance'][0]['sopClass'] = sopClass + '3.1'
            if(modality_values == 2 and bodysite_value == 5):
                jsonData['series'][0]['modality']=modality[2]           
                jsonData['series'][0]['bodySite']=bodysite[5]
                jsonData['series'][0]['instance'][0]['title'] = 'CT Image Storage'
                jsonData['series'][0]['instance'][0]['sopClass'] = sopClass + '1.2'
            jsonData['series'][0]['instance'][0]['uid'] = 'urn:oid:1.2.840.99999999.1.' + str(r.randint(111111,1000000)) + '.' + '1568644917998'
            jsonData['patient']['reference'] = 'Patient/' + str(new_patient_id)
            jsonData['patient']['display'] = str(patient_newname)
            resourceJson = jsonData.copy()
            jsonData['resourceJson'] = json.dumps(resourceJson)
        filename  = "Imagingstudy"+str(Imagingstudy) + ".json"
        with open(Imagingstudy_folder + filename, mode='w+', encoding='utf-8') as feedsjson:
            feedsjson.write(json.dumps(jsonData))
            feedsjson.close()
            print(filename) 
                
