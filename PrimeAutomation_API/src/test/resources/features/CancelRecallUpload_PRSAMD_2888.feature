
Feature: PRSAMD_2888 - Verifying cancel/recall all the uploads for an batchId/uploadId via. PUT API.

@DUU_PRSAMD-2888_success
Scenario Outline: PRSAMD_2888 - Positive Scenario's with valid Authorization tokens
  
    Given the Base url is entered to cancel/recall all the uploads 
    When user gives valid "<Authorization>" & "<Token>" and trigger PUT API to cancel/recall all the uploads
    Then Response is generated with success status code to cancel/recall
    And "responseMessage" field validates in Response body to cancel/recall all the uploads

    Examples:
|Authorization | Token |
| Authorization | ic_admin_token      |
| Authorization | ic_technician_token |
| Authorization | hosp_admin_token    |
| Authorization | surgeon_token       |
| Authorization | staff_token         |
 
 @DUU_PRSAMD-2888_failure
 Scenario Outline: PRSAMD_2888 - Negative Scenario's with valid Authorization tokens
  
    Given the Base url is entered to cancel/recall all the uploads
    When User gives valid "<Authorization>" & "<Token>" and fetch testdata from "<SheetName>" <RowNumber> and trigger PUT API to cancel/recall all the uploads
    Then Response is generated with failure status code to cancel/recall
    And "errors" field validates in Response body to cancel/recall all the uploads

    Examples:   
    	| SheetName | RowNumber | Authorization | Token               |
      | Sheet1    |         0 | Authorization | ic_admin_token      |
      | Sheet1    |         1 | Authorization | ic_technician_token |
      | Sheet1    |         2 | Authorization | hosp_admin_token    |
      | Sheet1    |         3 | Authorization | surgeon_token       |
      | Sheet1    |         4 | Authorization | staff_token         |
  		| Sheet1    |         5 | Authorization | ic_technician_token |
  		
 @DUU_PRSAMD-2888_no_data
 Scenario Outline: PRSAMD_2888 - Negative Scenario's with valid Authorization tokens and invalid batchId
  
    Given the Base url is entered to cancel/recall all the uploads
    When User gives valid "<Authorization>" & "<Token>" and fetch invalid batchId testdata from "<SheetName>" <RowNumber> and trigger PUT API to cancel/recall all the uploads
    Then Response is generated with no data found status code to cancel/recall
    And "errors" field validates in Response body to cancel/recall all the uploads

    Examples:   
    	| SheetName | RowNumber | Authorization | Token               |
      | Sheet1    |         6 | Authorization | ic_admin_token      |
      | Sheet1    |         7 | Authorization | ic_technician_token |
      | Sheet1    |         8 | Authorization | hosp_admin_token    |
      | Sheet1    |         9 | Authorization | surgeon_token       |
      | Sheet1    |         10 | Authorization | staff_token         |

  @DUU_PRSAMD-2888_unauthorised
   Scenario Outline: PRSAMD_2888 - Exception Scenario's with invalid Authorization tokens
  
    Given the Base url is entered to cancel/recall all the uploads
    When User gives invalid "<Authorization>" & "<Token>" and fetch testdata and trigger PUT API to cancel/recall all the uploads
    Then Response is generated with unauthorized status code  to cancel/recall
    And "errors" field validates in Response body to cancel/recall all the uploads
    
    Examples:   
    | Authorization | Token |	
    | Authorization | invalid_token |
    
@DUU_PRSAMD-2888_success_HospitalAdmin
Scenario Outline: PRSAMD_2888 - Positive Scenario's with valid Authorization tokens
    Given the Base url is entered to cancel/recall all the uploads 
    When user gives valid "<Authorization>" & "<Token>" and trigger PUT API to cancel/recall all the uploads
    Then Response is generated with success status code to cancel/recall
    And "responseMessage" field validates in Response body to cancel/recall all the uploads

    Examples:
|Authorization | Token |
| Authorization | hosp_admin_token    |

@DUU_PRSAMD-2888_failure_HospitalAdmin
 Scenario Outline: PRSAMD_2888 - Negative Scenario's with valid Authorization tokens
    Given the Base url is entered to cancel/recall all the uploads
    When User gives valid "<Authorization>" & "<Token>" and fetch testdata from "<SheetName>" <RowNumber> and trigger PUT API to cancel/recall all the uploads
    Then Response is generated with failure status code to cancel/recall
    And "errors" field validates in Response body to cancel/recall all the uploads

    Examples:   
    	| SheetName | RowNumber | Authorization | Token               |
      | Sheet1    |         2 | Authorization | hosp_admin_token    |
      
@DUU_PRSAMD-2888_Unauthorised_HospitalAdmin
  Scenario Outline: PRSAMD_2888 - Exception Scenario's with invalid Authorization tokens
  
    Given the Base url is entered to cancel/recall all the uploads
    When User gives invalid "<Authorization>" & "<Token>" and fetch testdata and trigger PUT API to cancel/recall all the uploads
    Then Response is generated with unauthorized status code  to cancel/recall
    And "errors" field validates in Response body to cancel/recall all the uploads
    
    Examples:   
    | Authorization | Token |	
    | Authorization | invalid_token |