Feature: PRSAMD_2291 - Verifying saving APPROVE / REJECT status of a HIL case from Image Editor UI via. PUT API.


@HIL_PRSAMD-2291_success
Scenario Outline: PRSAMD_2291- Scenario's with Valid Authorization and valid Request Body

				Given a user enters the valid URL for saving APPROVE / REJECT status of a HIL case from Image Editor UI
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to save APPROVE / REJECT status of a HIL case from Image Editor UI
				Then Response is generated with success status code for saving APPROVE / REJECT status of a HIL case from Image Editor UI
				And the attribute "responseMessage" is validated for saving APPROVE / REJECT status of a HIL case from Image Editor UI
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_reviewer_token |

@HIL_PRSAMD-2291_failure
Scenario Outline: PRSAMD_2291- Scenario's with Valid Authorization and Blank Request Body

				Given a user enters the valid URL for saving APPROVE / REJECT status of a HIL case from Image Editor UI
				When the user gives a valid "<Authorization>" and "<Token>" with blank Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to save APPROVE / REJECT status of a HIL case from Image Editor UI
				Then Response is generated with failure status code for saving APPROVE / REJECT status of a HIL case from Image Editor UI
				And the attribute "errors" is validated for saving APPROVE / REJECT status of a HIL case from Image Editor UI
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    2      | Authorization | hil_manager_token |
| Sheet1  |    3      | Authorization | hil_reviewer_token |
| Sheet1  |    4      | Authorization | hil_manager_token |
| Sheet1  |    5      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-2291_no_data
Scenario Outline: PRSAMD_2291- Scenario's with Valid Authorization and Invalid caseId 

				Given a user enters the valid URL for saving APPROVE / REJECT status of a HIL case from Image Editor UI
				When the user gives a valid "<Authorization>" and "<Token>" with invalid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to save APPROVE / REJECT status of a HIL case from Image Editor UI
				Then Response is generated with no data found status code for saving APPROVE / REJECT status of a HIL case from Image Editor UI
				And the attribute "errors" is validated for saving APPROVE / REJECT status of a HIL case from Image Editor UI
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    6      | Authorization | hil_manager_token |
| Sheet1  |    7      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-2291_unauthorised
Scenario Outline: PRSAMD_2291- Scenario's with Invalid Authorization and Valid Request Body

				Given a user enters the valid URL for saving APPROVE / REJECT status of a HIL case from Image Editor UI
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API for saving APPROVE / REJECT status of a HIL case from Image Editor UI
				Then Response is generated with unauthorized status code for saving APPROVE / REJECT status of a HIL case from Image Editor UI
				And the attribute "errors" is validated for saving APPROVE / REJECT status of a HIL case from Image Editor UI
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   8       |Authorization | invalid_token |
|Sheet1   |   9       |Authorization | invalid_token |