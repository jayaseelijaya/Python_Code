Feature: PRSAMD_2286 - Verifying exiting from Image Editor Screen via. POST API.


@HIL_PRSAMD-2286_success
Scenario Outline: PRSAMD_2286- Scenario's with Valid Authorization and valid Request Parameters

				Given a user enters the valid URL for exiting from Image Editor Screen
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger POST API to exit from Image Editor Screen
				Then Response is generated with success status code for exiting from Image Editor Screen
				And the attribute "responseMessage" is validated for exiting from Image Editor Screen
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_reviewer_token |
| Sheet1  |    2      | Authorization | hil_manager_token |
| Sheet1  |    3      | Authorization | hil_reviewer_token |
| Sheet1  |    4      | Authorization | hil_manager_token |
| Sheet1  |    5      | Authorization | hil_reviewer_token |

@HIL_PRSAMD-2286_unauthorised
Scenario Outline: PRSAMD_2286- Scenario's with Invalid Authorization and Valid Request Parameters

				Given a user enters the valid URL for exiting from Image Editor Screen
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger POST API to exit from Image Editor Screen
				Then Response is generated with unauthorized status code for exiting from Image Editor Screen
				And the attribute "errors" is validated for exiting from Image Editor Screen
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   6      |Authorization | invalid_token |
|Sheet1   |   7      |Authorization | invalid_token |