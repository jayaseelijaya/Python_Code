import json
import sys
import subprocess

home_path = sys.argv[1]

subprocess.run("rm "+ home_path +"/Test/Automation/python/report/json_result.json", shell=True, stdout=subprocess.PIPE)

with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
    feedsjson.write("[")

