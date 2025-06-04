import os

import fastapi
import uvicorn
from typing import Union


app = fastapi.FastAPI()

@app.get("/api/data_ingestion/{datasettype}")
async def getdata(datasettype: str):

    if datasettype == "basic_resource":
       print(os.system("python3 Patient.py"))
       return {"message": "IPS Basic Resource Data Generated"}

    elif datasettype == "bundle_resource":
         print(os.system("python3 Bundle.py"))
         return {"message":"IPS Resource Bundle Data Generated"}


    elif datasettype == "syntaxscore":
         print(os.system("python3 SyntaxScore.py"))
         return {"message":"SyntaxScore Data Generated"}

     else:
      return {"message":"Invalid Input"}
