Feature: PRSAMD_1335 - Verifying fetching filter values on HIL Case Dashboard screens via. GET API.

@HIL_PRSAMD-1335_success
Scenario Outline: PRSAMD_1335- Scenario's with Valid Authorization and valid Request Parameters

				Given a user enters the valid URL for fetching filter values on HIL Case Dashboard screens
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch filter values on HIL Case Dashboard screens
				Then Response is generated with success status code for fetching filter values on HIL Case Dashboard screens
				And the attribute "anatomy" is validated for fetching filter values on HIL Case Dashboard screens
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_reviewer_token |
| Sheet1  |    2      | Authorization | hil_manager_token |
| Sheet1  |    3      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-1335_unauthorised
Scenario Outline: PRSAMD_1335- Scenario's with Invalid Authorization and Valid Request Parameter

				Given a user enters the valid URL for fetching filter values on HIL Case Dashboard screens
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API for fetching filter values on HIL Case Dashboard screens
				Then Response is generated with unauthorized status code for fetching filter values on HIL Case Dashboard screens
				And the attribute "errors" is validated for fetching filter values on HIL Case Dashboard screens
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   4      |Authorization | invalid_token |
|Sheet1   |   5      |Authorization | invalid_token |