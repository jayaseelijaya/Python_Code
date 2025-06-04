Feature: PRSAMD_1471 - Verifying fetching 3D Model via. GET API.

@HIL_PRSAMD-1471_success
Scenario Outline: PRSAMD_1471- Scenario's with Valid Authorization and valid Request Parameters

				Given a user enters the valid URL for fetching 3D Model
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch 3D Model details
				Then Response is generated with success status code for fetching 3D Model
				And the attribute "raw3DBoneModelLink" is validated for fetching 3D Model
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_reviewer_token |

@HIL_PRSAMD-1471_no_data
Scenario Outline: PRSAMD_1471- Scenario's with Valid Authorization and Invalid Request parameters

				Given a user enters the valid URL for fetching 3D Model
				When the user gives a valid "<Authorization>" and "<Token>" with invalid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch 3D Model
				Then Response is generated with no data found status code for fetching 3D Model
				And the attribute "errors" is validated for fetching 3D Model
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    2      | Authorization | hil_manager_token |
| Sheet1  |    3      | Authorization | hil_reviewer_token |
| Sheet1  |    4      | Authorization | hil_manager_token |
| Sheet1  |    5      | Authorization | hil_reviewer_token |

@HIL_PRSAMD-1471_unauthorised
Scenario Outline: PRSAMD_1471- Scenario's with Invalid Authorization and Valid Request Body

				Given a user enters the valid URL for fetching 3D Model
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch 3D Model
				Then Response is generated with unauthorized status code for fetching 3D Model
				And the attribute "errors" is validated for fetching 3D Model
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   6      |Authorization | invalid_token |