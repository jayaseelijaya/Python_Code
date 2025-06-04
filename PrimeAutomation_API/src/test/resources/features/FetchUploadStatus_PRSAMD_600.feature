
Feature: PRSAMD-600 - Verify fetching status details of the uploaded files via GET API 

@DUU_PRSAMD-600_success

Scenario Outline: PRSAMD-600 - Postitive Scenario's with valid Authorization Token for fetching status details of uploaded File 

	Given base url is entered to fetch status details of uploaded files
	When user enters valid "<Authorization>" , "<token>" & uploadId as "<uploadId>" and triggers GET API 
	Then Response is generated with upload file details and status code as 200 
	And "updatedby" attribute validation is performed against response messsage. 
	
	Examples: 
	| uploadId | Authorization | token |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                	  		                                                                                         
	| c3b08322-9e7e-49e5-8ba6-760bce232b7e |Authorization |ic_admin_token |
	| c3b08322-9e7e-49e5-8ba6-760bce232b7e |Authorization |hosp_admin_token |
	| c3b08322-9e7e-49e5-8ba6-760bce232b7e |Authorization |ic_technician_token |	
	| c3b08322-9e7e-49e5-8ba6-760bce232b7e |Authorization |surgeon_token |	
	| c3b08322-9e7e-49e5-8ba6-760bce232b7e |Authorization |staff_token |
	| c3b08322-9e7e-49e5-8ba6-760bce232b7e |Authorization |hil_manager_token |
	
	@DUU_PRSAMD-600_unauthorised
	
Scenario Outline: PRSAMD-600 - Negative Scenario's with in-valid Authorization Token for fetching status details of uploaded File 

	Given base url is entered to fetch status details of uploaded files
	When user enters invalid "<Authorization>" , "<token>" & uploadId as "<uploadId>" and triggers GET API 
	Then Response is not generated with upload file details and status code as 401 
	And "errors" attribute validation is performed against response messsage. 
	
	Examples: 
	| uploadId | Authorization | token |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                	  		                                                                                         
	| 762647f1-63e1-4a9e-b285-d308c1563b9c |Authorization | invalid_token |
	
	
@DUU_PRSAMD-600_failure

Scenario Outline: PRSAMD-600 - Exception Scenario's with valid Authorization Token for fetching status details of uploaded File 


	Given base url is entered to fetch status details of uploaded files
	When user enters valid "<Authorization>" , "<token>" & incorrect uploadId as "<uploadId>" and triggers GET API 
	Then Response is generated with empty file details and status code as 400 
	And "errors" attribute validation is performed against response messsage. 
	
	Examples: 
	| uploadId | Authorization | token |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                	  		                                                                                         
	| 762647f1-63e1-4a9e-b285-d308c1563b9c100 |Authorization |ic_admin_token |
	| 762647f1-63e1-4a9e-b285-d308c1563b9c |Authorization | hosp_admin_token |
	
	
@DUU_PRSAMD-600_success_HospitalAdmin
Scenario Outline: PRSAMD-600 - Postitive Scenario's with valid Authorization Token for fetching status details of uploaded File 
	Given base url is entered to fetch status details of uploaded files
	When user enters valid "<Authorization>" , "<token>" & uploadId as "<uploadId>" and triggers GET API 
	Then Response is generated with upload file details and status code as 200 
	And "updatedby" attribute validation is performed against response messsage. 
	
	Examples: 
	| uploadId | Authorization | token |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                	  		                                                                                         
	| c3b08322-9e7e-49e5-8ba6-760bce232b7e |Authorization |hosp_admin_token |
	
@DUU_PRSAMD-600_failure_Surgeon
Scenario Outline: PRSAMD-600 - Exception Scenario's with valid Authorization Token for fetching status details of uploaded File 
	Given base url is entered to fetch status details of uploaded files
	When user enters valid "<Authorization>" , "<token>" & incorrect uploadId as "<uploadId>" and triggers GET API 
	Then Response is generated with empty file details and status code as 400 
	And "errors" attribute validation is performed against response messsage. 
	
	Examples: 
	| uploadId | Authorization | token |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                	  		                                                                                         
	| 762647f1-63e1-4a9e-b285-d308c1563b9c100 |Authorization |surgeon_token |	
	
@DUU_PRSAMD-600_Unauthorised_HospitalAdmin
Scenario Outline: PRSAMD-600 - Negative Scenario's with in-valid Authorization Token for fetching status details of uploaded File 

	Given base url is entered to fetch status details of uploaded files
	When user enters invalid "<Authorization>" , "<token>" & uploadId as "<uploadId>" and triggers GET API 
	Then Response is not generated with upload file details and status code as 401 
	And "errors" attribute validation is performed against response messsage. 
	
	Examples: 
	| uploadId | Authorization | token |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                	  		                                                                                         
	| 762647f1-63e1-4a9e-b285-d308c1563b9c |Authorization | invalid_token |