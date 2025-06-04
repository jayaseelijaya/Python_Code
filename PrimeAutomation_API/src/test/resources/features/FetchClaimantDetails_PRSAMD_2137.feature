
Feature: PRSAMD_2137 - Verifying fetching claimant details for a caseId via. GET API.

@HIL_PRSAMD-2137_success
Scenario Outline: PRSAMD_2137- Scenario's with Valid Authorization and valid Request Parameters

				Given a user enters the valid URL for fetching claimant details for a caseId
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch claimant details for a caseId
				Then Response is generated with success status code for fetching claimant details for a caseId
				And the attribute "caseId" is validated for fetching claimant details for a caseId
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-2137_no_data
Scenario Outline: PRSAMD_2137- Scenario's with Valid Authorization and Invalid Request parameters

				Given a user enters the valid URL for fetching claimant details for a caseId
				When the user gives a valid "<Authorization>" and "<Token>" with invalid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch claimant details for a caseId
				Then Response is generated with no data found status code for fetching claimant details for a caseId
				And the attribute "errorDetails" is validated for fetching claimant details for a caseId
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    2      | Authorization | hil_manager_token |
| Sheet1  |    3      | Authorization | hil_reviewer_token |
| Sheet1  |    4      | Authorization | hil_manager_token |
| Sheet1  |    5      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-2137_unauthorised
Scenario Outline: PRSAMD_2137- Scenario's with Invalid Authorization and Valid Request Body

				Given a user enters the valid URL for fetching claimant details for a caseId
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch claimant details for a caseId
				Then Response is generated with unauthorized status code for fetching claimant details for a caseId
				And the attribute "errors" is validated for fetching claimant details for a caseId
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   6      |Authorization | invalid_token |