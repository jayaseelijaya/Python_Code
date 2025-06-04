Feature: PRSAMD_2392 - Verifying fetching isEditAllowed flag value via. GET API.

@HIL_PRSAMD-2392_success
Scenario Outline: PRSAMD_2392- Scenario's with Valid Authorization and valid Request Parameters

				Given a user enters the valid URL for fetching isEditAllowed flag value
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch isEditAllowed flag value
				Then Response is generated with success status code for fetching isEditAllowed flag value
				And the attribute "isEditAllowed" is validated for fetching isEditAllowed flag value
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-2392_no_data
Scenario Outline: PRSAMD_2392- Scenario's with Valid Authorization and Invalid Request parameters

				Given a user enters the valid URL for fetching isEditAllowed flag value
				When the user gives a valid "<Authorization>" and "<Token>" with invalid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch isEditAllowed flag value
				Then Response is generated with no data found status code for fetching isEditAllowed flag value
				And the attribute "errors" is validated for fetching isEditAllowed flag value
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    2      | Authorization | hil_manager_token |
| Sheet1  |    3      | Authorization | hil_reviewer_token |
| Sheet1  |    4      | Authorization | hil_manager_token |
| Sheet1  |    5      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-2392_unauthorised
Scenario Outline: PRSAMD_2392- Scenario's with Invalid Authorization and Valid Request Body

				Given a user enters the valid URL for fetching isEditAllowed flag value
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch isEditAllowed flag value
				Then Response is generated with unauthorized status code for fetching isEditAllowed flag value
				And the attribute "errors" is validated for fetching isEditAllowed flag value
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   6      |Authorization | invalid_token |