import sys
from pathling import PathlingContext
from pyspark.sql import *
from pyspark.sql.functions import *
pc = PathlingContext.create()

pc.spark.sparkContext.setLogLevel("ERROR")

#insert location of file path
file_path = {file_path_location}

try:
    patient_id = sys.argv[1]
except IndexError:
    patient_id = 'null'

#Read Patient files
df_patient = pc.spark.read.load(file_path+"Patient.parquet")
if patient_id == 'null':
    patient = df_patient.select(col("id"), col("id_versioned"), to_json(struct([df_patient[x] for x in df_patient.columns]))\
    .alias("patient_json")).dropDuplicates(["id"])
else:
    patient = df_patient.select(col("id"), col("id_versioned"), to_json(struct([df_patient[x] for x in df_patient.columns]))\
    .alias("patient_json")).dropDuplicates(["id"]).where(col("id").isin(patient_id))

#Read Allergyintolerance files
df_allergy_intolerance = pc.spark.read.load(file_path+"AllergyIntolerance.parquet")
allergy_intolerance = df_allergy_intolerance.select(col("id"), col('patient.reference'), to_json(struct([df_allergy_intolerance[x] for x in df_allergy_intolerance.columns]))\
        .alias("allergy_intolerance_json")).groupBy(col("reference")).agg(collect_set("allergy_intolerance_json").alias("allergy_intolerance_json"))

#Read Observation files
df_observation = pc.spark.read.load(file_path+"Observation.parquet")
observation = df_observation.select(col("id"), col('subject.reference'), to_json(struct([df_observation[x] for x in df_observation.columns]))\
        .alias("observation_json")).groupBy(col("reference")).agg(collect_set("observation_json").alias("observation_json"))

#Read Condition files
df_condition = pc.spark.read.load(file_path+"Condition.parquet")
condition = df_condition.select(col("id"), col('subject.reference'), to_json(struct([df_condition[x] for x in df_condition.columns]))\
        .alias("condition_json")).groupBy(col("reference")).agg(collect_set("condition_json").alias("condition_json"))

#Read Condition files
dfEncounter = pc.spark.read.load(file_path+"Encounter.parquet")
encounter = dfEncounter.select(col("id"), col('subject.reference'), to_json(struct([dfEncounter[x] for x in dfEncounter.columns]))\
        .alias("encounter_json")).groupBy(col("reference")).agg(collect_set("encounter_json").alias("encounter_json"))

print("---------------------------Patient Summary-------------------------------------")
patient_summary = patient.join(observation, patient.id_versioned == observation.reference, "left")\
    .join(condition,patient.id_versioned == condition.reference, "left")\
    .join(allergy_intolerance,patient.id_versioned == allergy_intolerance.reference, "left")\
    .join(encounter,patient.id_versioned == encounter.reference, "left")\
    .select(patient.id, patient.patient_json, allergy_intolerance.allergy_intolerance_json, observation.observation_json, condition.condition_json, encounter.encounter_json)

patient_summary.show(truncate=True)

patient_summary = patient_summary.withColumn("allergy_intolerance_json", concat_ws(",", col("allergy_intolerance_json")))
patient_summary = patient_summary.withColumn("observation_json", concat_ws(",", col("observation_json")))
patient_summary = patient_summary.withColumn("condition_json", concat_ws(",", col("condition_json")))
patient_summary = patient_summary.withColumn("encounter_json", concat_ws(",", col("encounter_json")))
patient_summary = patient_summary.select(col("id"), col("patient_json").alias("patient_resource_json"), concat(lit("["), col("allergy_intolerance_json"), lit("]")).alias("allergy_intolerance_resource_json"),concat(lit("["), col("observation_json"), lit("]")).alias("observation_resource_json"), concat(lit("["), col("condition_json"), lit("]")).alias("condition_resource_json"), concat(lit("["), col("encounter_json"), lit("]")).alias("encounter_resource_json"))

patient_summary.write.format("jdbc").mode("append")\
    .option("url", "jdbc:postgresql://daas-db.cpfbf0nsafep.ap-south-1.rds.amazonaws.com:5432/postgres")\
    .option("driver", "org.postgresql.Driver").option("dbtable", "patient_summary_path")\
    .option("user", "postgres").option("stringtype", "unspecified")\
    .option("password", "daasadmin1234").save()
    
