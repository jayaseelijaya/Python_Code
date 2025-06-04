

Feature: PRSAMD_3020 - Verifying generating 3D bone model via. PUT API.


@HIL_PRSAMD-3020_success
Scenario Outline: PRSAMD_3020- Scenario's with Valid Authorization and valid Request Parameters

				Given a user enters the valid URL for generating 3D bone model
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to generate 3D bone model
				Then Response is generated with success status code for generating 3D bone model
				And the attribute "responseMessage" is validated for generating 3D bone model
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_reviewer_token |
| Sheet1  |    2      | Authorization | hil_manager_token |
| Sheet1  |    3      | Authorization | hil_reviewer_token |

@HIL_PRSAMD-3020_failure
Scenario Outline: PRSAMD_3020- Scenario's with Valid Authorization and Invalid isApproved and isSessionSave

				Given a user enters the valid URL for generating 3D bone model
				When the user gives a valid "<Authorization>" and "<Token>" with invalid isApproved and isSessionSave Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to generate 3D bone model
				Then Response is generated with failure status code for generating 3D bone model
				And the attribute "errors" is validated for generating 3D bone model
	Examples:
|SheetName| RowNumber| Authorization | Token |
| Sheet1  |    4      | Authorization | hil_manager_token |
| Sheet1  |    5      | Authorization | hil_reviewer_token |
| Sheet1  |    6      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-3020_no_data
Scenario Outline: PRSAMD_3020- Scenario's with Valid Authorization and Invalid caseId

				Given a user enters the valid URL for generating 3D bone model
				When the user gives a valid "<Authorization>" and "<Token>" with invalid caseId Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to generate 3D bone model
				Then Response is generated with no data found status code for generating 3D bone model
				And the attribute "errors" is validated for generating 3D bone model
	Examples:
|SheetName| RowNumber| Authorization | Token |
| Sheet1  |    7      | Authorization | hil_manager_token |
| Sheet1  |    8      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-3020_unauthorised
Scenario Outline: PRSAMD_3020- Scenario's with Invalid Authorization and Valid Request Body

				Given a user enters the valid URL for generating 3D bone model
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to generate 3D bone model
				Then Response is generated with unauthorized status code for generating 3D bone model
				And the attribute "errors" is validated for generating 3D bone model
	Examples:
|SheetName| RowNumber| Authorization | Token |
|Sheet1   |   9      |Authorization | invalid_token |