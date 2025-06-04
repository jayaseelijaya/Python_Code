from typing import Union
from fastapi import FastAPI, HTTPException
from kafka.admin import KafkaAdminClient, NewTopic

sys.path.append.(os.path.abspath('../../vault')
from get_data_from_vault import vault_details


#Extracting Vault Data
vault_data    = vault_details()
broker_b1 = vault_data['MSKbroker1']
broker_b2 = vault_data['MSKbroker2']
broker_b3 = vault_data['MSKbroker3']

brokers = [broker_b1, broker_b2, broker_b3]
app = FastAPI()
def createTopic(org, dept, proposition):
    adminClient = KafkaAdminClient(bootstrap_servers = brokers)
    baseTopicName = org+"."+dept
    requestTopicName = org+"."+dept+"."+proposition
    resultTopicName = org+"."+dept+"."+proposition+".result"
    topics = [baseTopicName.lower(), requestTopicName.lower(), resultTopicName.lower()]
    topicList = []
    for topic in topics:
        topicList.append(NewTopic(name=topic, num_partitions=1, replication_factor=3))
    adminClient.create_topics(new_topics=topicList, validate_only=False)
    return topicList

@app.post("/createkafkatopics")
def createTopicApi(orgName:str, deptName:str, propositionName:str):
    try:
        responseData = createTopic(orgName, deptName, propositionName)
        return {"status":200, "value":responseData}
    except Exception as ex:
        raise HTTPException(
            status_code = 400,
            detail = "Topics already exists"
        )