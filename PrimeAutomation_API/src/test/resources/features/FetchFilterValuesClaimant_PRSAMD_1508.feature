@HIL_PRSAMD-1508

Feature: PRSAMD_1508 - Verifying fetching filter values for claimant via. GET API.

@HIL_PRSAMD-1508_success
Scenario Outline: PRSAMD_1508- Scenario's with Valid Authorization and valid Request Parameters

				Given a user enters the valid URL for fetching filter values for claimant
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch filter values for claimant
				Then Response is generated with success status code for fetching filter values for claimant
				And the attribute "claimantUserName" is validated for fetching filter values for claimant
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_reviewer_token |
| Sheet1  |    2      | Authorization | hil_manager_token |
| Sheet1  |    3      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-1508_failure
Scenario Outline: PRSAMD_2137- Scenario's with Valid Authorization and Invalid Request parameters

				Given a user enters the valid URL for fetching filter values for claimant
				When the user gives a valid "<Authorization>" and "<Token>" with invalid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch filter values for claimant
				Then Response is generated with failure status code for fetching filter values for claimant
				And the attribute "errorDetails" is validated for fetching filter values for claimant
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    4      | Authorization | hil_manager_token |
| Sheet1  |    5      | Authorization | hil_reviewer_token |
| Sheet1  |    6      | Authorization | hil_manager_token |
| Sheet1  |    7      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-1508_unauthorised
Scenario Outline: PRSAMD_2137- Scenario's with Invalid Authorization and Valid Request Body

				Given a user enters the valid URL for fetching filter values for claimant
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch filter values for claimant
				Then Response is generated with unauthorized status code for fetching filter values for claimant
				And the attribute "errors" is validated for fetching filter values for claimant
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   8      |Authorization | invalid_token |