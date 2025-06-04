
Feature: PRSAMD_200 - Verify fetching the status details list via Get api Scenarios 


@DUU_PRSAMD-200_success
Scenario Outline: PRSAMD_200 - Positive Flow with valid Authorization tokens
  
  
    Given base url is entered to fetch status details 
    When user enters valid "<Authorization>" "<token>" and Trigger Get method
    Then response body is generated with status code as 200
    And "statuscode" attribute in response body is validated
    And "description" attribute in response body is validated
    
    Examples:
    | Authorization | token |
    | Authorization | ic_admin_token |   
    | Authorization | hosp_admin_token |
    | Authorization | ic_technician_token | 
    | Authorization | surgeon_token |
    
@DUU_PRSAMD-200_unauthorised

Scenario Outline: PRSAMD_200 - Negative Flow with valid Authorization tokens
  
    Given base url is entered to fetch status details 
    When user enters invalid "<Authorization>" "<token>" and Trigger Get method
    Then response body is generated with status code 401
    
     
    Examples:
    | Authorization | token |
    | Authorization | invalid_token |
    
    
@DUU_PRSAMD-200_success_Ictechnician
Scenario Outline: PRSAMD_200 - Positive Flow with valid Authorization tokens
    Given base url is entered to fetch status details 
    When user enters valid "<Authorization>" "<token>" and Trigger Get method
    Then response body is generated with status code as 200
    And "statuscode" attribute in response body is validated
    And "description" attribute in response body is validated
    
    Examples:
    | Authorization | token |
    | Authorization | ic_technician_token | 
    
@DUU_PRSAMD-200_Unauthorised_Ictechnician
Scenario Outline: PRSAMD_200 - Negative Flow with valid Authorization tokens
    Given base url is entered to fetch status details 
    When user enters invalid "<Authorization>" "<token>" and Trigger Get method
    Then response body is generated with status code 401
    
    Examples:
    | Authorization | token |
    | Authorization | invalid_token |