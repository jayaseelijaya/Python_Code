
Feature: PRSAMD-648 - Verify fetching the information of skipped files in a batch via an GET API 


@DUU_PRSAMD-648_success
Scenario Outline: PRSAMD-648 - Postitive Scenario's with valid Authorization Token for fetching details of Skipped File 

	Given base url is entered to fetch information of skipped file 
	When user entered valid "<Authorization>" , "<token>" & "<batchId>" and triggers GET API 
	Then Response is generated with skipped file details and status code as 200 
	And "fileName" attribute validation is performed. 
	
	Examples: 
|Authorization | token | batchId|
| Authorization | ic_admin_token      | DemoBatch |
| Authorization | ic_technician_token | DemoBatch |
| Authorization | hosp_admin_token    | DemoBatch |
| Authorization | surgeon_token       | DemoBatch |
| Authorization | staff_token         | DemoBatch |
		
@DUU_PRSAMD-648_unauthorised
Scenario Outline: PRSAMD-648 - Exception Scenario's with invalid Authorization Token for fetching details of Skipped File 

	Given base url is entered to fetch information of skipped file 
	When user entered invalid "<Authorization>" , "<token>" & "<batchId>" and triggers GET API 
	Then Response is generated with no skipped file details and status code as 401 
	And "errors" attribute validation is performed. 
	
	Examples: 
|Authorization | token | batchId|
| Authorization | invalid_token      | DemoBatch |

@DUU_PRSAMD-648_success_Surgeon
Scenario Outline: PRSAMD-648 - Negative Scenario's with valid Authorization Token for fetching details of Skipped File 

	Given base url is entered to fetch information of skipped file 
	When user entered valid "<Authorization>" , "<token>" &  invalid "<batchId>" and triggers GET API 
	Then Response is generated with empty details and status code as 200 
	
	Examples: 
|Authorization | token | batchId|
| Authorization | surgeon_token       | DemoBatch4 |

@DUU_PRSAMD-648_Unauthorised_IcAdmin
Scenario Outline: PRSAMD-648 - Exception Scenario's with invalid Authorization Token for fetching details of Skipped File 

	Given base url is entered to fetch information of skipped file 
	When user entered invalid "<Authorization>" , "<token>" & "<batchId>" and triggers GET API 
	Then Response is generated with no skipped file details and status code as 401 
	And "errors" attribute validation is performed. 
	
	Examples: 
|Authorization | token | batchId|
| Authorization | invalid_token      | DemoBatch |