#!/bin/bash -e

ACTION=$1
    echo "######## Moving to Python Test Folder ########"
    WORKSPACE="/__w/DaaS-Patient360/DaaS-Patient360"
    cd ${WORKSPACE}/Test/Automation/python

smokeTest(){
    echo "######## Running SMOKETEST ########"
    echo "######## Creating JSON Report File ########"
    echo ${OAUTH2_CLIENT_ID}
    echo ${CF_ORG}
    cd ${WORKSPACE}/Test/Automation/python/report/
    python3 ${WORKSPACE}/Test/Automation/python/report/create_report_json.py ${WORKSPACE}

    echo "######## Running R4 Practitioner Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_practitioner.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Patient Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_patient.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Organization Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_organization.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Observation Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_observation.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Medicationstatement Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_medicationstatement.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Medicationrequest Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_medicationrequest.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Medication Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_medication.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Immunization Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_immunization.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Encounter Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_encounter.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Condition Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_condition.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 AllergyIntolerance Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_allergyIntolerance.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running verification of kafka topic Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/Verification_script_kafka_routing_service/
    python3 ${WORKSPACE}/Test/Automation/python/Verification_script_kafka_routing_service/verification_kafka_topic.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}
    
    echo "######## Running verification of kafka topic1 Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/Verification_script_kafka_routing_service/
    python3 ${WORKSPACE}/Test/Automation/python/Verification_script_kafka_routing_service/verification_kafka_topic_1.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}
    
    echo "######## Running verification of kafka topic1 and topic2 Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/Verification_script_kafka_routing_service/
    python3 ${WORKSPACE}/Test/Automation/python/Verification_script_kafka_routing_service/verification_kafka_topic1_topic2_.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}
	
	 echo "######## Running Verification script for Co_ordinator service ########"
    cd ${WORKSPACE}/Test/Automation/python/co_ordinator_service_test/
    python3 ${WORKSPACE}/Test/Automation/python/co_ordinator_service_test/verify_coordinator_testing.py ${WORKSPACE} ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT} 

    echo "######## Running Negative Test cases for Co_ordinator service ########"
    cd ${WORKSPACE}/Test/Automation/python/co_ordinator_service_test/
    python3 ${WORKSPACE}/Test/Automation/python/co_ordinator_service_test/verify_co_ordiantor_invalid_data.py ${WORKSPACE} ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT} 


    echo "######## Running Proposition Service_ Test 1 ########"
    cd ${WORKSPACE}/Test/Automation/python/proposition_service_test/
    python3 ${WORKSPACE}/Test/Automation/python/proposition_service_test/proposition_service_test_1.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running Proposition Service_ Test 2 ########"
    cd ${WORKSPACE}/Test/Automation/python/proposition_service_test/
    python3 ${WORKSPACE}/Test/Automation/python/proposition_service_test/proposition_service_test_2.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running Proposition Service_ Test 3 ########"
    cd ${WORKSPACE}/Test/Automation/python/proposition_service_test/
    python3 ${WORKSPACE}/Test/Automation/python/proposition_service_test/proposition_service_test_3.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running Proposition Service_ Test 5 ########"
    cd ${WORKSPACE}/Test/Automation/python/proposition_service_test/
    python3 ${WORKSPACE}/Test/Automation/python/proposition_service_test/proposition_service_test_5.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}
    
    echo "######## Running Syntaxscore Service Test ########"
    cd ${WORKSPACE}/Test/Automation/python/syntax_score_standalone_test/
    python3 ${WORKSPACE}/Test/Automation/python/syntax_score_standalone_test/syntaxscore_service_test.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}
    
    echo "######## Running Verification script for Co_ordinator service ########"
    cd ${WORKSPACE}/Test/Automation/python/co_ordinator_service_test/
    python3 ${WORKSPACE}/Test/Automation/python/co_ordinator_service_test/verify_coordinator_testing.py ${WORKSPACE} ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT} 
    
    echo "######## Running Negative Test cases for Co_ordinator service ########"
    cd ${WORKSPACE}/Test/Automation/python/co_ordinator_service_test/
    python3 ${WORKSPACE}/Test/Automation/python/co_ordinator_service_test/verify_co_ordiantor_invalid_data.py ${WORKSPACE} ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT} 

    echo "######## Running Negative R4 Test ########"
    echo "######## Running Syntaxscore Service Negative Test1 ########"
    cd ${WORKSPACE}/Test/Automation/python/syntax_score_standalone_test/
    python3 ${WORKSPACE}/Test/Automation/python/syntax_score_standalone_test/syntaxscore_negative_test_case_invalid_flow.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running Syntaxscore Service Negative Test2 ########"
    cd ${WORKSPACE}/Test/Automation/python/syntax_score_standalone_test/
    python3 ${WORKSPACE}/Test/Automation/python/syntax_score_standalone_test/syntaxscore_negative_test_case_invalid_bundle.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running E2E DaaS Test ########"
    cd ${WORKSPACE}/Test/Automation/python/e2e_daas_test/
    python3 ${WORKSPACE}/Test/Automation/python/e2e_daas_test/e2e_daas_test.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running Syntaxscore Service Negative Test1 ########"
    cd ${WORKSPACE}/Test/Automation/python/syntax_score_standalone_test/
    python3 ${WORKSPACE}/Test/Automation/python/syntax_score_standalone_test/syntaxscore_negative_test_case_invalid_flow.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running Syntaxscore Service Negative Test2 ########"
    cd ${WORKSPACE}/Test/Automation/python/syntax_score_standalone_test/
    python3 ${WORKSPACE}/Test/Automation/python/syntax_score_standalone_test/syntaxscore_negative_test_case_invalid_bundle.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running E2E DaaS Test ########"
    cd ${WORKSPACE}/Test/Automation/python/e2e_daas_test/
    python3 ${WORKSPACE}/Test/Automation/python/e2e_daas_test/e2e_daas_test.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## RRunning Negative R4 Test ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/negative_test_cases/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/negative_test_cases/r4_negative_test.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}
    
    echo "######## Finishing JSON Report File ########"
    cd ${WORKSPACE}/Test/Automation/python/report/
    python3 ${WORKSPACE}/Test/Automation/python/report/finish_report_json.py ${WORKSPACE}

    echo "######## Generating HTML Report File ########"
    python3 ${WORKSPACE}/Test/Automation/python/report/html_report_generator.py ${WORKSPACE}    
    echo SMOKETEST COMPLETED
}

fullTest(){
    echo "######## Running FULL TEST ########"
    echo "######## Creating JSON Report File ########"
    cd ${WORKSPACE}/Test/Automation/python/report/
    python3 ${WORKSPACE}/Test/Automation/python/report/create_report_json.py ${WORKSPACE}

    echo "######## Running R4 Practitioner Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_practitioner.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Patient Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_patient.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Organization Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_organization.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Observation Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_observation.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Medicationstatement Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_medicationstatement.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Medicationrequest Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_medicationrequest.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Medication Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_medication.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Immunization Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_immunization.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Encounter Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_encounter.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 Condition Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_condition.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running R4 AllergyIntolerance Resource API Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/r4_allergyIntolerance.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running verification of kafka topic Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/Verification_script_kafka_routing_service/
    python3 ${WORKSPACE}/Test/Automation/python/Verification_script_kafka_routing_service/verification_kafka_topic.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}
    
    echo "######## Running verification of kafka topic1 Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/Verification_script_kafka_routing_service/
    python3 ${WORKSPACE}/Test/Automation/python/Verification_script_kafka_routing_service/verification_kafka_topic_1.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}
    
    echo "######## Running verification of kafka topic1 and topic2 Test Case ########"
    cd ${WORKSPACE}/Test/Automation/python/Verification_script_kafka_routing_service/
    python3 ${WORKSPACE}/Test/Automation/python/Verification_script_kafka_routing_service/verification_kafka_topic1_topic2_.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running Proposition Service_ Test 1 ########"
    cd ${WORKSPACE}/Test/Automation/python/proposition_service_test/
    python3 ${WORKSPACE}/Test/Automation/python/proposition_service_test/proposition_service_test_1.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running Proposition Service_ Test 2 ########"
    cd ${WORKSPACE}/Test/Automation/python/proposition_service_test/
    python3 ${WORKSPACE}/Test/Automation/python/proposition_service_test/proposition_service_test_2.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running Proposition Service_ Test 3 ########"
    cd ${WORKSPACE}/Test/Automation/python/proposition_service_test/
    python3 ${WORKSPACE}/Test/Automation/python/proposition_service_test/proposition_service_test_3.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Running Proposition Service_ Test 5 ########"
    cd ${WORKSPACE}/Test/Automation/python/proposition_service_test/
    python3 ${WORKSPACE}/Test/Automation/python/proposition_service_test/proposition_service_test_5.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}
    
    echo "######## Running Syntaxscore Service Test ########"
    cd ${WORKSPACE}/Test/Automation/python/syntax_score_standalone_test/
    python3 ${WORKSPACE}/Test/Automation/python/syntax_score_standalone_test/syntaxscore_service_test.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## RRunning Negative R4 Test ########"
    cd ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/negative_test_cases/
    python3 ${WORKSPACE}/Test/Automation/python/r4_fhir_get_api_test/negative_test_cases/r4_negative_test.py ${CF_ORG} ${CF_SPACE} ${CF_USN} ${CF_PWD} ${OAUTH2_CLIENT_ID} ${OAUTH2_CLIENT_PWD} ${IAM_USN} ${IAM_PWD} ${WORKSPACE} ${VAULT_SERVICE_INSTANCE} ${API_ENDPOINT}

    echo "######## Finishing JSON Report File ########"
    cd ${WORKSPACE}/Test/Automation/python/report/
    python3 ${WORKSPACE}/Test/Automation/python/report/finish_report_json.py ${WORKSPACE}

    echo "######## Generating HTML Report File ########"
    python3 ${WORKSPACE}/Test/Automation/python/report/html_report_generator.py ${WORKSPACE}    
    echo FULL TEST COMPLETED
    cd $WORKSPACE
}

if [ "${ACTION}" == "SMOKETEST" ];then
    smokeTest
elif [ "${ACTION}" == "FULLTEST" ];then
    fullTest
fi