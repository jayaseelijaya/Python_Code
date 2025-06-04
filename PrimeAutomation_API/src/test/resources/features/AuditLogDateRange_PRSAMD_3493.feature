
Feature: PRSAMD_3493 - Verifying fetching Audit logs based on date range selection via. GET API.


@HIL_PRSAMD-3493_success
Scenario Outline: PRSAMD_3493- Scenario's with Valid Authorization and valid Request Parameters

				Given a user enters the valid URL for fetching Audit logs based on date range selection
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data as "<SheetName>" <RowNumber> and trigger GET API to fetch Audit logs based on date range selection
				Then Response is generated with success status code for fetching Audit logs based on date range selection 200
				
	Examples:

|SheetName| RowNumber |Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                	  		                                                                                         
|Sheet1     |0|				 Authorization|hil_manager_token | 
|Sheet1     |1|				 Authorization|hil_manager_token |

@HIL_PRSAMD-3493_unauthorised
Scenario Outline: PRSAMD_3493- Scenario's with Invalid Authorization and valid Request Parameters

				Given a user enters the valid URL for fetching Audit logs based on date range selection
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data as "<SheetName>" <RowNumber> and trigger GET API to fetch Audit logs based on date range selection
				Then Response is generated with unauthorised status code for fetching Audit logs based on date range selection 401
				And the attribute "errors" is validated for fetching Audit logs based on date range selection
	Examples:

|SheetName| RowNumber |Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                	  		                                                                                         
|Sheet1     |2|				 Authorization| invalid_token |
|Sheet1     |3|				 Authorization| invalid_token |
