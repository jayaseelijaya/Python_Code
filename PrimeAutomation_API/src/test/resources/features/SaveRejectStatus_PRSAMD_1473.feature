Feature: PRSAMD_1473 - Verifying saving REJECT status of a HIL case via. PUT API.

@HIL_PRSAMD-1473_success
Scenario Outline: PRSAMD_1473- Scenario's with Valid Authorization and valid Request Body

				Given a user enters the valid URL for saving REJECT status of a HIL case
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to save REJECT status of a HIL case
				Then Response is generated with success status code for saving REJECT status of a HIL case
				And the attribute "responseMessage" is validated for saving REJECT status of a HIL case
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_reviewer_token |
| Sheet1  |    2      | Lambda | lambda_token |


@HIL_PRSAMD-1473_failure
Scenario Outline: PRSAMD_1473- Scenario's with Valid Authorization and Blank Request Body

				Given a user enters the valid URL for saving REJECT status of a HIL case
				When the user gives a valid "<Authorization>" and "<Token>" with a blank Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to save REJECT status of a HIL case
				Then Response is generated with failure status code for saving REJECT status of a HIL case
				And the attribute "errors" is validated for saving REJECT status of a HIL case
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    3      | Authorization | hil_manager_token |
| Sheet1  |    4      | Authorization | hil_reviewer_token |
| Sheet1  |    5      | Lambda | lambda_token |


@HIL_PRSAMD-1473_no_data
Scenario Outline: PRSAMD_1473- Scenario's with Valid Authorization and Invalid Request Body

				Given a user enters the valid URL for saving REJECT status of a HIL case
				When the user gives a valid "<Authorization>" and "<Token>" with invalid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to save REJECT status of a HIL case
				Then Response is generated with no data found status code for saving REJECT status of a HIL case
				And the attribute "errors" is validated for saving REJECT status of a HIL case
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    6      | Authorization | hil_manager_token |
| Sheet1  |    7      | Authorization | hil_reviewer_token |
| Sheet1  |    8      | Lambda | lambda_token |

@HIL_PRSAMD-1473_unauthorised
Scenario Outline: PRSAMD_1473- Scenario's with Invalid Authorization and Valid Request Body

				Given a user enters the valid URL for saving REJECT status of a HIL case
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to save REJECT status of a HIL case
				Then Response is generated with unauthorized status code for saving REJECT status of a HIL case
				And the attribute "errors" is validated for saving REJECT status of a HIL case
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   9       |Authorization | invalid_token |
|Sheet1   |   10      |Authorization | invalid_token |