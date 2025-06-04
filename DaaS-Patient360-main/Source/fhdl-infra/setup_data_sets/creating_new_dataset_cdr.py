import base64
import requests
import json
import os
import sys
import names

directory = os.getcwd()
foldername = directory +'/new_generated_datasets/'
for i in range(2):
    newname = names.get_full_name()
    print(newname)

#Store bundle to CDR
    with open('ips.json') as dataset:
        jsonData = json.load(dataset)
        oldname = jsonData['entry'][0]['resource']['name'][0]['given'][0]
        print("The value of oldname is",oldname)
        jsonData['entry'][0]['resource']['name'][0]['given'][0] = newname    
    filename1  = newname
    filename2  = ".json"#creating a new patient data
    filename   = filename1 + filename2
    folderpath = os.path.join(foldername,filename)
    with open(folderpath, 'w', encoding='utf-8') as f:
        jsonData1 = json.dump(jsonData, f, ensure_ascii=False, indent=4)    
     