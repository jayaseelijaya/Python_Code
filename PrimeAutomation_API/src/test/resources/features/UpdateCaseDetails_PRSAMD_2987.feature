
Feature: PRSAMD_2987 - Verifying update case details  via. PUT API.

@HIL_PRSAMD-2987_success
Scenario Outline: PRSAMD_2987- Scenario's with Valid Authorization and valid Request Body

				Given a user enters the valid URL for updating case details in HIL
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update case details in HIL
				Then Response is generated with success status code for updating case details in HIL
				And the attribute "responseMessage" is validated for updating case details in HIL
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_reviewer_token |
| Sheet1  |    2      | Lambda | lambda_token |


@HIL_PRSAMD-2987_failure
Scenario Outline: PRSAMD_2987- Scenario's with Valid Authorization and Blank Request Body

				Given a user enters the valid URL for updating case details in HIL
				When the user gives a valid "<Authorization>" and "<Token>" with blank Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update case details in HIL
				Then Response is generated with failure status code for updating case details in HIL
				And the attribute "errorDetails" is validated for updating case details in HIL
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    3      | Authorization | hil_manager_token |
| Sheet1  |    4      | Authorization | hil_reviewer_token |
| Sheet1  |    5      | Lambda | lambda_token |


@HIL_PRSAMD-2987_no_data
Scenario Outline: PRSAMD_2987- Scenario's with Valid Authorization and Invalid caseId and dueDate

				Given a user enters the valid URL for updating case details in HIL
				When the user gives a valid "<Authorization>" and "<Token>" with invalid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update case details in HIL
				Then Response is generated with no data found status code for updating case details in HIL
				And the attribute "errorDetails" is validated for updating case details in HIL
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    6      | Authorization | hil_manager_token |
| Sheet1  |    7      | Authorization | hil_reviewer_token |
| Sheet1  |    8      | Lambda | lambda_token |
| Sheet1  |    9      | Authorization | hil_manager_token |
| Sheet1  |    10     | Authorization | hil_reviewer_token |
| Sheet1  |    11     | Lambda | lambda_token |


@HIL_PRSAMD-2987_unauthorised
Scenario Outline: PRSAMD_2987- Scenario's with Invalid Authorization and Valid Request Body

				Given a user enters the valid URL for updating case details in HIL
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API for updating case details in HIL
				Then Response is generated with unauthorized status code for updating case details in HIL
				And the attribute "errors" is validated for updating case details in HIL
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   12       |Authorization | invalid_token |