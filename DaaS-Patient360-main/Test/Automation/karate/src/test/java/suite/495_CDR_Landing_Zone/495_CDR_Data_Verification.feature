@Smoke @USUID_495 @TC_601 @UTC_601
Feature: CDR Landing Zone & Data Verification

  Background: 
    * def token = callonce read('classpath:suite/reusable/GetIAMToken.feature')
    * def IAM_Token = token.Access_Token

  Scenario: Post CDR Resource Bundle_0
    Given url CDA_URL + "/"+ FHIR_ORG_ID
    And header Content-Type = 'application/json'
    And header Accept = 'application/json'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    And def requestBody = read('classpath:suite/test_datasets/cdr_datasets/Bundle_0.json')
    And request requestBody
    When method POST
    Then status 200
    And print response
    And def resourceType0 =  response.entry[0].resource.resourceType
    And def resourceId0 =  response.entry[0].resource.id
    And def resourceType1 =  response.entry[1].resource.resourceType
    And def resourceId1 =  response.entry[1].resource.id
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType0 +"/" + resourceId0
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType1 +"/" + resourceId1
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response

  Scenario: Post CDR Resource Bundle_1
    Given url CDA_URL + "/"+ FHIR_ORG_ID
    And header Content-Type = 'application/json'
    And header Accept = 'application/json'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    And def requestBody = read('classpath:suite/test_datasets/cdr_datasets/Bundle_1.json')
    And request requestBody
    When method POST
    Then status 200
    And print response
    And def resourceType0 =  response.entry[0].resource.resourceType
    And def resourceId0 =  response.entry[0].resource.id
    And def resourceType1 =  response.entry[1].resource.resourceType
    And def resourceId1 =  response.entry[1].resource.id
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType0 +"/" + resourceId0
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType1 +"/" + resourceId1
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response

  Scenario: Post CDR Resource Bundle_2
    Given url CDA_URL + "/"+ FHIR_ORG_ID
    And header Content-Type = 'application/json'
    And header Accept = 'application/json'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    And def requestBody = read('classpath:suite/test_datasets/cdr_datasets/Bundle_2.json')
    And request requestBody
    When method POST
    Then status 200
    And print response
    And def resourceType0 =  response.entry[0].resource.resourceType
    And def resourceId0 =  response.entry[0].resource.id
    And def resourceType1 =  response.entry[1].resource.resourceType
    And def resourceId1 =  response.entry[1].resource.id
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType0 +"/" + resourceId0
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType1 +"/" + resourceId1
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response

  Scenario: Post CDR Resource Bundle_3
    Given url CDA_URL + "/"+ FHIR_ORG_ID
    And header Content-Type = 'application/json'
    And header Accept = 'application/json'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    And def requestBody = read('classpath:suite/test_datasets/cdr_datasets/Bundle_3.json')
    And request requestBody
    When method POST
    Then status 200
    And print response
    And def resourceType0 =  response.entry[0].resource.resourceType
    And def resourceId0 =  response.entry[0].resource.id
    And def resourceType1 =  response.entry[1].resource.resourceType
    And def resourceId1 =  response.entry[1].resource.id
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType0 +"/" + resourceId0
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType1 +"/" + resourceId1
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response

  Scenario: Post CDR Resource Bundle_4
    Given url CDA_URL + "/"+ FHIR_ORG_ID
    And header Content-Type = 'application/json'
    And header Accept = 'application/json'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    And def requestBody = read('classpath:suite/test_datasets/cdr_datasets/Bundle_4.json')
    And request requestBody
    When method POST
    Then status 200
    And print response
    And def resourceType0 =  response.entry[0].resource.resourceType
    And def resourceId0 =  response.entry[0].resource.id
    And def resourceType1 =  response.entry[1].resource.resourceType
    And def resourceId1 =  response.entry[1].resource.id
    And def resourceType2 =  response.entry[2].resource.resourceType
    And def resourceId2 =  response.entry[2].resource.id
    And def resourceType3 =  response.entry[3].resource.resourceType
    And def resourceId3 =  response.entry[3].resource.id
    And def resourceType4 =  response.entry[4].resource.resourceType
    And def resourceId4 =  response.entry[4].resource.id
    And def resourceType5 =  response.entry[5].resource.resourceType
    And def resourceId5 =  response.entry[5].resource.id
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType0 +"/" + resourceId0
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType1 +"/" + resourceId1
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType2 +"/" + resourceId2
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType3 +"/" + resourceId3
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType4 +"/" + resourceId4
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType5 +"/" + resourceId5
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response

  Scenario: Post CDR Resource Bundle_5
    Given url CDA_URL + "/"+ FHIR_ORG_ID
    And header Content-Type = 'application/json'
    And header Accept = 'application/json'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    And def requestBody = read('classpath:suite/test_datasets/cdr_datasets/Bundle_5.json')
    And request requestBody
    When method POST
    Then status 200
    And print response
    And def resourceType0 =  response.entry[0].resource.resourceType
    And def resourceId0 =  response.entry[0].resource.id
    And def resourceType1 =  response.entry[1].resource.resourceType
    And def resourceId1 =  response.entry[1].resource.id
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType0 +"/" + resourceId0
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType1 +"/" + resourceId1
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response

  Scenario: Post CDR Resource Bundle_6
    Given url CDA_URL + "/"+ FHIR_ORG_ID
    And header Content-Type = 'application/json'
    And header Accept = 'application/json'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    And def requestBody = read('classpath:suite/test_datasets/cdr_datasets/Bundle_6.json')
    And request requestBody
    When method POST
    Then status 200
    And print response
    And def resourceType0 =  response.entry[0].resource.resourceType
    And def resourceId0 =  response.entry[0].resource.id
    And def resourceType1 =  response.entry[1].resource.resourceType
    And def resourceId1 =  response.entry[1].resource.id
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType0 +"/" + resourceId0
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType1 +"/" + resourceId1
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response

  Scenario: Post CDR Resource Bundle_7
    Given url CDA_URL + "/"+ FHIR_ORG_ID
    And header Content-Type = 'application/json'
    And header Accept = 'application/json'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    And def requestBody = read('classpath:suite/test_datasets/cdr_datasets/Bundle_7.json')
    And request requestBody
    When method POST
    Then status 200
    And print response
    And def resourceType0 =  response.entry[0].resource.resourceType
    And def resourceId0 =  response.entry[0].resource.id
    And def resourceType1 =  response.entry[1].resource.resourceType
    And def resourceId1 =  response.entry[1].resource.id
    And def resourceType2 =  response.entry[2].resource.resourceType
    And def resourceId2 =  response.entry[2].resource.id
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType0 +"/" + resourceId0
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType1 +"/" + resourceId1
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType2 +"/" + resourceId2
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response

  Scenario: Post CDR Resource Bundle_8
    Given url CDA_URL + "/"+ FHIR_ORG_ID
    And header Content-Type = 'application/json'
    And header Accept = 'application/json'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    And def requestBody = read('classpath:suite/test_datasets/cdr_datasets/Bundle_8.json')
    And request requestBody
    When method POST
    Then status 200
    And print response
    And def resourceType0 =  response.entry[0].resource.resourceType
    And def resourceId0 =  response.entry[0].resource.id
    And def resourceType1 =  response.entry[1].resource.resourceType
    And def resourceId1 =  response.entry[1].resource.id
    And def resourceType2 =  response.entry[2].resource.resourceType
    And def resourceId2 =  response.entry[2].resource.id
    And def resourceType3 =  response.entry[3].resource.resourceType
    And def resourceId3 =  response.entry[3].resource.id
    And def resourceType4 =  response.entry[4].resource.resourceType
    And def resourceId4 =  response.entry[4].resource.id
    And def resourceType5 =  response.entry[5].resource.resourceType
    And def resourceId5 =  response.entry[5].resource.id
    And def resourceType6 =  response.entry[6].resource.resourceType
    And def resourceId6 =  response.entry[6].resource.id
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType0 +"/" + resourceId0
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType1 +"/" + resourceId1
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType2 +"/" + resourceId2
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType3 +"/" + resourceId3
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType4 +"/" + resourceId4
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType5 +"/" + resourceId5
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
    Given url CDA_URL + "/"+ FHIR_ORG_ID + "/" + resourceType6 +"/" + resourceId6
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 1
    And header Authorization = 'Bearer ' + IAM_Token
    When method GET
    Then status 200
    And print response
