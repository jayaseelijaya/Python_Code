
Feature: PRSAMD_1466 - Verifying fetching NRRD Mask via. GET API.


@HIL_PRSAMD-1466_success
Scenario Outline: PRSAMD_1466- Scenario's with Valid Authorization and valid Request Parameters

				Given a user enters the valid URL for fetching NRRD Mask
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch NRRD Mask details
				Then Response is generated with success status code for fetching NRRD Mask
				And the attribute "segmentedNrrdMaskLink" is validated for fetching NRRD Mask
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_reviewer_token |

@HIL_PRSAMD-1466_no_data
Scenario Outline: PRSAMD_1466- Scenario's with Valid Authorization and Invalid or blank Request parameters

				Given a user enters the valid URL for fetching NRRD Mask
				When the user gives a valid "<Authorization>" and "<Token>" with invalid or blank Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch NRRD Mask
				Then Response is generated with no data found status code for fetching NRRD Mask
				And the attribute "errors" is validated for fetching NRRD Mask
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    2      | Authorization | hil_manager_token |
| Sheet1  |    3      | Authorization | hil_reviewer_token |
| Sheet1  |    4      | Authorization | hil_manager_token |
| Sheet1  |    5      | Authorization | hil_reviewer_token |


@HIL_PRSAMD-1466_unauthorised
Scenario Outline: PRSAMD_1466- Scenario's with Invalid Authorization and Valid Request Body

				Given a user enters the valid URL for fetching NRRD Mask
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch NRRD Mask
				Then Response is generated with unauthorized status code for fetching NRRD Mask
				And the attribute "errors" is validated for fetching NRRD Mask
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   6      |Authorization | invalid_token | 