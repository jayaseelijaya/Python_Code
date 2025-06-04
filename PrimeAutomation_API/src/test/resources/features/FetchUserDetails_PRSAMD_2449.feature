
Feature: PRSAMD_2449 - Verifying fetching logged in user details from Common Login Portal via. GET API.

@HIL_PRSAMD-2449_success
Scenario Outline: PRSAMD_2449- Scenario's with Valid Authorization and valid Request Parameters

				Given a user enters the valid URL for fetching logged in user details from Common Login Portal
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch logged in user details from Common Login Portal
				Then Response is generated with success status code for fetching logged in user details from Common Login Portal
				And the attribute "userName" is validated for fetching logged in user details from Common Login Portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_reviewer_token |
| Sheet1  |    2      | Authorization | hil_manager_token |
| Sheet1  |    3      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-2449_unauthorised
Scenario Outline: PRSAMD_2449- Scenario's with Invalid Authorization and Valid Request Body

				Given a user enters the valid URL for fetching logged in user details from Common Login Portal
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch logged in user details from Common Login Portal
				Then Response is generated with unauthorized status code for fetching logged in user details from Common Login Portal
				And the attribute "errors" is validated for fetching logged in user details from Common Login Portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   4       |Authorization | invalid_token |