

Feature: PRSAMD_1277 - Verifying fetching Active Case pop-up details via. GET API.


@HIL_PRSAMD-1277_success
Scenario Outline: PRSAMD_1277- Scenario's with Valid Authorization and valid Request Parameters

				Given a user enters the valid URL for fetching Active Case pop-up details
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch Active Case pop-up details
				Then Response is generated with success status code for fetching Active Case pop-up details
				And the attribute "caseId" is validated for fetching Active Case pop-up details
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_reviewer_token |
| Sheet1  |    2      | Authorization | hil_manager_token |
| Sheet1  |    3      | Authorization | hil_reviewer_token |
| Sheet1  |    4      | Authorization | hil_manager_token |
| Sheet1  |    5      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-1277_unauthorised
Scenario Outline: PRSAMD_1277- Scenario's with Invalid Authorization and Valid Request Body

				Given a user enters the valid URL for fetching Active Case pop-up details
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch Active Case pop-up details
				Then Response is generated with unauthorized status code for fetching Active Case pop-up details
				And the attribute "errors" is validated for fetching Active Case pop-up details
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   6       |Authorization | invalid_token |