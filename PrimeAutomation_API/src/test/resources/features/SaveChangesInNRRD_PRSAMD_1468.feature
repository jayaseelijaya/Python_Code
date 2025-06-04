

Feature: PRSAMD_1468 - Verifying saving changes in nrrd mask via. GET API.

@HIL_PRSAMD-1468_success
Scenario Outline: PRSAMD_1468- Scenario's with Valid Authorization and valid Request Parameters

				Given a user enters the valid URL for saving changes in nrrd mask
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to save changes in nrrd mask
				Then Response is generated with success status code for saving changes in nrrd mask
				And the attribute "segmentedNrrdMaskUploadLink" is validated for saving changes in nrrd mask
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_reviewer_token |
| Sheet1  |    2      | Authorization | hil_manager_token |
| Sheet1  |    3      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-1468_failure
Scenario Outline: PRSAMD_1468- Scenario's with Valid Authorization and Blank Request Parameters

				Given a user enters the valid URL for saving changes in nrrd mask
				When the user gives a valid "<Authorization>" and "<Token>" with blank Test Data from "<SheetName>" and <RowNumber> and trigger GET API to save changes in nrrd mask
				Then Response is generated with failure status code for saving changes in nrrd mask
				And the attribute "errors" is validated for saving changes in nrrd mask
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    4      | Authorization | hil_manager_token |
| Sheet1  |    5      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-1468_no_data
Scenario Outline: PRSAMD_1468- Scenario's with Valid Authorization and Invalid caseId 

				Given a user enters the valid URL for saving changes in nrrd mask
				When the user gives a valid "<Authorization>" and "<Token>" with invalid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to save changes in nrrd mask
				Then Response is generated with no data found status code for saving changes in nrrd mask
				And the attribute "errors" is validated for saving changes in nrrd mask
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    6      | Authorization | hil_manager_token |
| Sheet1  |    7      | Authorization | hil_reviewer_token |
| Sheet1  |    8      | Authorization | hil_manager_token |
| Sheet1  |    9      | Authorization | hil_reviewer_token |

@HIL_PRSAMD-1468_unauthorised
Scenario Outline: PRSAMD_1468- Scenario's with Invalid Authorization and Valid Request Parameter

				Given a user enters the valid URL for saving changes in nrrd mask
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API for saving changes in nrrd mask
				Then Response is generated with unauthorized status code for saving changes in nrrd mask
				And the attribute "errors" is validated for saving changes in nrrd mask
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   10      |Authorization | invalid_token |
|Sheet1   |   11      |Authorization | invalid_token |