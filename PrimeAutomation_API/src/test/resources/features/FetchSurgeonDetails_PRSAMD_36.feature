
Feature: PRSAMD_36 - Verify fetching the Surgeon details for hospital scenarios

@DUU_PRSAMD-36_success
  Scenario Outline: PRSAMD_36 - Positive Flow with valid tokens
  
    Given base url entered
    When user enter valid "<Authorization>" "<token>" and trigger the Get api
    Then response is generated with status code 200
    And "userStatus" in response body validated
    And "facilityName" in response body validated
  
   Examples:
    | Authorization | token |
    | Authorization | ic_admin_token |   
    | Authorization | ic_technician_token | 
    | Authorization | surgeon_token |
   
 @DUU_PRSAMD-36_unauthorised
    Scenario Outline: PRSAMD_36 - Negative Flow with valid tokens
    
    Given base url entered
    When user entered invalid "<Authorization>" "<token>" and trigger the Get api
    Then response generated with status code 401
    
    Examples:
    | Authorization | token |
    | Authorization | invalid_token |
    
@DUU_PRSAMD-36_success_Surgeon
  Scenario Outline: PRSAMD_36 - Positive Flow with valid tokens
    Given base url entered
    When user enter valid "<Authorization>" "<token>" and trigger the Get api
    Then response is generated with status code 200
    And "userStatus" in response body validated
    And "facilityName" in response body validated
  
   Examples:
    | Authorization | token |
    | Authorization | surgeon_token |
   
@DUU_PRSAMD-36_Unauthorised_HospitalAdmin
    Scenario Outline: PRSAMD_36 - Negative Flow with valid tokens
    Given base url entered
    When user entered invalid "<Authorization>" "<token>" and trigger the Get api
    Then response generated with status code 401
    
    Examples:
    | Authorization | token |
    | Authorization | invalid_token |
   