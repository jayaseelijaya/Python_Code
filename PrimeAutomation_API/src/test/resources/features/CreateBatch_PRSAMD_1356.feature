
Feature: PRSAMD_1356- Verifying Create Batch via POST API.
	
@HIL_PRSAMD-1356_success
Scenario Outline: PRSAMD_1356- Scenario's with Valid Authorization token for Creating Batch.
	
		Given a Base URL is entered for creating batch 
		When user enter a valid "<Authorization>" & "<token>" and trigger the POST API for creating batch
		Then the response body gets generated with create batch success response and status code 200
		And attribute validation consisting "responseMessage" is verified for creating batch
		
	Examples: 
|Authorization | token |
| Authorization | ic_admin_token      |
| Authorization | ic_technician_token |
| Authorization | hosp_admin_token    |
| Authorization | surgeon_token       |
| Authorization | staff_token         |

@HIL_PRSAMD-1356_failure
Scenario Outline: PRSAMD_1356- Scenario's with Valid authorization token and already present batchId.
   
   	Given a Base URL is entered for creating batch
		When user enters a valid "<Authorization>" & "<token>" & already present "<batchId>" and trigger the POST API for creating batch
		Then the response body generate with create batch error message and status code 400
		And attribute validation consisting "errors" is verified for creating batch
		
		Examples: 
		
	|Authorization | token | batchId|
| Authorization | ic_admin_token      | DemoBatch |
| Authorization | ic_technician_token | DemoBatch |
| Authorization | hosp_admin_token    | DemoBatch |
| Authorization | surgeon_token       | DemoBatch |
| Authorization | staff_token         | DemoBatch |
    
    
 @HIL_PRSAMD-1356_failure
Scenario Outline: PRSAMD_1356 - Scenario's with valid authorization token and invalid request body.
   
   	Given a Base URL is entered for creating batch
		When user enters valid "<Authorization>" & "<token>" with an invalid Request body and trigger the POST API for creating batch
		Then the response body generate with create batch error message and status code 400
		And attribute validation consisting "errors" is verified for creating batch
		
		Examples: 
		
	|Authorization | token |
| Authorization | ic_admin_token      |
| Authorization | ic_technician_token |
| Authorization | hosp_admin_token    |
| Authorization | surgeon_token       |
| Authorization | staff_token         |
 
 
 @HIL_PRSAMD-1356_unauthorised
Scenario: PRSAMD_1356 - Scenario's  with Invalid authorization token and valid Request Body.
  
  	Given a Base URL is entered for creating batch
		When user enters invalid "<Authorization>" & "<token>" and trigger the POST API for creating batch
		Then the response body having generate the create batch error message with status code 401
		And attribute validation consisting "errors" is verified for creating batch
   	
		Examples:
		
	|Authorization | token |
	|Authorization| invalid_token |