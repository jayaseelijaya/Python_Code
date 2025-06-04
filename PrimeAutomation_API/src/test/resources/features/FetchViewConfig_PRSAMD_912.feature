
Feature: PRSAMD_912 - Verifing fetching of user/facility specific view configuration via GET API.

@DUU_PRSAMD-912_success

Scenario Outline: PRSAMD_912 - Positive Flow with Valid authorization and Request Parameters

    Given user enters the base URL to verify user/facility specific view configuration
    When user gives valid "<Authorization>" "<Token>" "<userFacilityId>" and trigger the Get api to user/facility specific view configuration
    Then response is generated and status code as 200 to verify user/facility specific view configuration
    And "facilityId" value in response body gets validated to user/facility specific view configuration
    
     Examples:
    | Authorization | Token | userFacilityId |
    | Authorization | ic_admin_token | 1 | 
    | Authorization | hosp_admin_token | 2 |    
    | Authorization | ic_admin_token | 3 |  
    | Authorization | hosp_admin_token | 5 |
    
@DUU_PRSAMD-912_failure

Scenario Outline: PRSAMD_912 - Negative Flow with Valid Authorization but invalid Request Parameters

    Given user enters the base URL to verify user/facility specific view configuration
    When user gives valid "<Authorization>" "<Token>" and invalid "<userFacilityId>" and trigger the Get api to user/facility specific view configuration
    Then response generated and status code as 400 to verify user/facility specific view configuration
    And "errors" value in response body gets validated to user/facility specific view configuration
    
     Examples:
    | Authorization | Token | userFacilityId |
    | Authorization | ic_admin_token | 123 | 
    | Authorization | hosp_admin_token | 253 |    
    | Authorization | ic_admin_token | 367 |  
    | Authorization | hosp_admin_token | 545 |
    
 @DUU_PRSAMD-912_unauthorised 
 
Scenario Outline: PRSAMD_912 - Exception flow - Happy flow with invalid authorization token 

    Given user enters the base URL to verify user/facility specific view configuration
    When user gives invalid "<Authorization>" "<Token>" and valid "<userFacilityId>" and trigger the Get api to user/facility specific view configuration
    Then response will be generated as 401 status code to verify user/facility specific view configuration
    And "errors" value in response body gets validated to user/facility specific view configuration
    
     Examples:
    | Authorization | Token | userFacilityId |
    | Authorization | invalid_token | 1 |
    
@DUU_PRSAMD-912_success_IcAdmin
Scenario Outline: PRSAMD_912 - Positive Flow with Valid authorization and Request Parameters
    Given user enters the base URL to verify user/facility specific view configuration
    When user gives valid "<Authorization>" "<Token>" "<userFacilityId>" and trigger the Get api to user/facility specific view configuration
    Then response is generated and status code as 200 to verify user/facility specific view configuration
    And "facilityId" value in response body gets validated to user/facility specific view configuration
    
     Examples:
     | Authorization | Token | userFacilityId |
    | Authorization | ic_admin_token | 1 |     
    | Authorization | ic_admin_token | 3 |  
    
@DUU_PRSAMD-912_failure_HospitalAdmin
Scenario Outline: PRSAMD_912 - Negative Flow with Valid Authorization but invalid Request Parameters
    Given user enters the base URL to verify user/facility specific view configuration
    When user gives valid "<Authorization>" "<Token>" and invalid "<userFacilityId>" and trigger the Get api to user/facility specific view configuration
    Then response generated and status code as 400 to verify user/facility specific view configuration
    And "errors" value in response body gets validated to user/facility specific view configuration
    
     Examples:
    | Authorization | Token | userFacilityId |
    | Authorization | hosp_admin_token | 253 |    
    | Authorization | hosp_admin_token | 545 |
    
@DUU_PRSAMD-912_Unauthorised_Surgeon
Scenario Outline: PRSAMD_912 - Exception flow - Happy flow with invalid authorization token 
    Given user enters the base URL to verify user/facility specific view configuration
    When user gives invalid "<Authorization>" "<Token>" and valid "<userFacilityId>" and trigger the Get api to user/facility specific view configuration
    Then response will be generated as 401 status code to verify user/facility specific view configuration
    And "errors" value in response body gets validated to user/facility specific view configuration
    
     Examples:
    | Authorization | Token | userFacilityId |
    | Authorization | invalid_token | 1 |