Feature: PRSAMD_2290 - Verifying fetching In Session 3D model via. GET API.

@HIL_PRSAMD-2290_success
Scenario Outline: PRSAMD_2290- Scenario's with Valid Authorization and valid Request Parameters

				Given a user enters the valid URL for fetching In Session 3D model
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch In Session 3D model
				Then Response is generated with success status code for fetching In Session 3D model
				And the attribute "draftInSession3DBoneModelLink" is validated for fetching In Session 3D model
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-2290_no_data
Scenario Outline: PRSAMD_2290- Scenario's with Valid Authorization and Invalid Request parameters

				Given a user enters the valid URL for fetching In Session 3D model
				When the user gives a valid "<Authorization>" and "<Token>" with invalid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch In Session 3D model
				Then Response is generated with no data found status code for fetching In Session 3D model
				And the attribute "errors" is validated for fetching In Session 3D model
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    2      | Authorization | hil_manager_token |
| Sheet1  |    3      | Authorization | hil_reviewer_token |
| Sheet1  |    4      | Authorization | hil_manager_token |
| Sheet1  |    5      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-2290_unauthorised
Scenario Outline: PRSAMD_2290- Scenario's with Invalid Authorization and Valid Request Body

				Given a user enters the valid URL for fetching In Session 3D model
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch In Session 3D model
				Then Response is generated with unauthorized status code for fetching In Session 3D model
				And the attribute "errors" is validated for fetching In Session 3D model
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   6      |Authorization | invalid_token |
|Sheet1   |   7      |Authorization | invalid_token |