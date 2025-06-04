@HIL_PRSAMD-3491

Feature: PRSAMD_3491 - Verifying exporting list of case audit log via. GET API.

@HIL_PRSAMD-3491_success
Scenario Outline: PRSAMD_3491- Scenario's with Valid Authorization and valid Request Parameters

				Given a user enters the valid URL for exporting list of case audit log
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data as "<SheetName>" <RowNumber> and trigger GET API to export list of case audit log
				Then Response is generated with success status code exporting list of case audit log 200
				
	Examples:

|SheetName| RowNumber |Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                	  		                                                                                         
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_manager_token |
| Sheet1  |    2      | Authorization | hil_manager_token |
| Sheet1  |    3      | Authorization | hil_manager_token |


@HIL_PRSAMD-3491_unauthorised
Scenario Outline: PRSAMD_3491- Scenario's with Invalid Authorization and valid Request Parameters

				Given a user enters the valid URL for exporting list of case audit log
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data as "<SheetName>" <RowNumber> and trigger GET API to export list of case audit log
				Then Response is generated with unauthorised status code exporting list of case audit log 401
				And the attribute "errors" is validated for exporting list of case audit log
	Examples:

|SheetName| RowNumber |Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                	  		                                                                                         
|Sheet1     |4|				 Authorization| invalid_token |
|Sheet1     |5|				 Authorization| invalid_token  |