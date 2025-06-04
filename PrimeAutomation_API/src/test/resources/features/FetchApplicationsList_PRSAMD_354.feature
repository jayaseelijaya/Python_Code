
Feature: PRSAMD_354 - Verify fetching the Applications list via Get api Scenarios  

Scenario Outline: PRSAMD_354 - Positive Flow with valid Authorization tokens for Application List

	Given base url is entered to fetch application list details 
	When user enters valid "<Authorization>" "<Token>" "<SheetName>" <RowNumber> and trigger Get method to fetch application list
	Then response body generated with status code as 200 to fetch application list
	And "ApplicationDetails" attribute in response message is validated to fetch application list
	
	Examples: 
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | ic_admin_token |
| Sheet1  |    1      | Authorization | ic_technician_token |
| Sheet1  |    2      | Authorization | surgeon_token |
| Sheet1  |    3      | Authorization | hosp_admin_token |
    
		
Scenario Outline: PRSAMD_354 - Positive Flow with invalid authorization

	Given  base url is entered to fetch application list details 
	When user gives invalid "<Authorization>" "<Token>" and valid test data from  "<SheetName>" <RowNumber> and trigger the Get api to fetch application list
	Then response message body is generated and status code as 401 to fetch application list
	And "errorMessage" attribute in response message is validated to fetch application list
	
	Examples: 
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    4      | Authorization | invalid_token |

		
		 
Scenario Outline: PRSAMD_354 - Negative Flow with valid Authorization tokens for Application List 

	Given base url is entered to fetch application list details 
	When user enters valid "<Authorization>" "<Token>" and invalid parameters from "<SheetName>" <RowNumber> and trigger Get method to fetch application list
	Then response message body is generated with status code as 400 to fetch application list
	And "errorMessage" attribute in response message is validated to fetch application list
	
	Examples: 
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    5      | Authorization | ic_admin_token |
| Sheet1  |    6      | Authorization | ic_technician_token |
| Sheet1  |    7      | Authorization | surgeon_token |
| Sheet1  |    8      | Authorization | hosp_admin_token |

@DUU_PRSAMD-354_success_Surgeon		
Scenario Outline: PRSAMD_354 - Positive Flow with valid Authorization tokens for Application List
	Given base url is entered to fetch application list details 
	When user enters valid "<Authorization>" "<Token>" "<SheetName>" <RowNumber> and trigger Get method to fetch application list
	Then response body generated with status code as 200 to fetch application list
	And "ApplicationDetails" attribute in response message is validated to fetch application list
	
	Examples: 
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    2      | Authorization | surgeon_token |

@DUU_PRSAMD-354_Unauthorised_Staff
Scenario Outline: PRSAMD_354 - Positive Flow with invalid authorization
	Given  base url is entered to fetch application list details 
	When user gives invalid "<Authorization>" "<Token>" and valid test data from  "<SheetName>" <RowNumber> and trigger the Get api to fetch application list
	Then response message body is generated and status code as 401 to fetch application list
	And "errorMessage" attribute in response message is validated to fetch application list
	
	Examples: 
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    4      | Authorization | invalid_token |

@DUU_PRSAMD-354_failure_Staff
Scenario Outline: PRSAMD_354 - Negative Flow with valid Authorization tokens for Application List 
	Given base url is entered to fetch application list details 
	When user enters valid "<Authorization>" "<Token>" and invalid parameters from "<SheetName>" <RowNumber> and trigger Get method to fetch application list
	Then response message body is generated with status code as 400 to fetch application list
	And "errorMessage" attribute in response message is validated to fetch application list
	
	Examples: 
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    7      | Authorization | staff_token |