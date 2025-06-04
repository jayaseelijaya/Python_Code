
Feature: PRSAMD_136 - Verify fetching the facility details List scenarios 

Scenario Outline: PRSAMD_136 - Positive Flow with valid tokens
  
    Given user enter base URL
    When user provides valid "<Authorization>" "<token>" and trigger the Get api
    Then response will generate and status code as 200
    And "isHospital" in response body gets validated
  
    Examples:
    | Authorization | token |
    | Authorization | ic_admin_token |  
    | Authorization | ic_technician_token | 
    | Authorization | surgeon_token | 
    | Authorization | hosp_admin_token |
   
    Scenario Outline: PRSAMD_136 - Negative Flow with invalid tokens
    
    Given user enter base URL
    When user provides invalid "<Authorization>" "<token>" and trigger the Get api
    Then response will be generated with status code as 401
    
    Examples:
    | Authorization | token |
    | Authorization |invalid_token|
    
    
    Scenario Outline: PRSAMD_136 - Exception Flow with valid tokens and incorrect URL
    
    Given user enter base URL
    When user provides invalid "<Authorization>" "<token>" and incorrect Url
    Then Response generated with 404 as status code 
    
     Examples:
    | Authorization | token |
    | Authorization | ic_admin_token |
    
@DUU_PRSAMD-136_success_HospitalAdmin  
Scenario Outline: PRSAMD_136 - Positive Flow with valid tokens
    Given user enter base URL
    When user provides valid "<Authorization>" "<token>" and trigger the Get api
    Then response will generate and status code as 200
    And "isHospital" in response body gets validated
  
    Examples:
    | Authorization | hosp_admin_token |

@DUU_PRSAMD-136_Unauthorized_Surgeon
 Scenario Outline: PRSAMD_136 - Negative Flow with invalid tokens
    Given user enter base URL
    When user provides invalid "<Authorization>" "<token>" and trigger the Get api
    Then response will be generated with status code as 401
    
    Examples:
    | Authorization | token |
    | Authorization |invalid_token|
 