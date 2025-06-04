import json
import sys

home_path = sys.argv[1]

with open(home_path + "/Test/Automation/python/report/json_result.json", mode='a+', encoding='utf-8') as feedsjson:
    feedsjson.write("]")
    #print(feedsjson.text)