import json
import sys
from json2html import *

home_path = sys.argv[1]

with open(home_path + "/Test/Automation/python/report/json_result.json", mode='r') as dataset:
    jsonData = json.load(dataset)
    dataset.close()

test = json2html.convert(json = jsonData)
test = test.replace("<tr><th>Test Name", "<tr style=\"background-color:Wheat;\"><th>Test Name")
test = test.replace("<td>Pass</td>", "<td><b><font color=\"Green\">Pass</font></b></td>")
test = test.replace("<td>Fail</td>", "<td><b><font color=\"Red\">Fail</font></b></td>")

print("Printing HTML Data")
print("#####################################################################################")
print(test)
print("#####################################################################################")

file_data = open("result_html.html","w")
file_data.write(test)
file_data.close()