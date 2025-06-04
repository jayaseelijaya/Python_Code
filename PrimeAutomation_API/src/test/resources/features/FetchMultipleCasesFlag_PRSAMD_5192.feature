
Feature: PRSAMD_5192 - Verifying fetching a flag to indicate presence of multiple cases for the same patient via. GET API.


@MIC_PRSAMD-5192_success
Scenario Outline: PRSAMD_5192- Scenario's with Valid Authorization and Valid Request Body

				Given a user enters the valid URL for fetching a flag to indicate presence of multiple cases for the same patient
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch a flag to indicate presence of multiple cases for the same patient
				Then Response is generated with success status code for fetching a flag to indicate presence of multiple cases for the same patient
				And the attribute "isMultipleCaseAvailable" is validated for fetching a flag to indicate presence of multiple cases for the same patient
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | surgeon_token |
| Sheet1  |    1      | Authorization | staff_token |
| Sheet1  |    2      | Authorization | surgeon_token |
| Sheet1  |    3      | Authorization | staff_token |


@MIC_PRSAMD-5192_unauthorised
Scenario Outline: PRSAMD_5192- Scenario's with Invalid Authorization and valid Request Body

				Given a user enters the valid URL for fetching a flag to indicate presence of multiple cases for the same patient
				When the user gives a invalid "<Authorization>" and "<Token>" with valid mandatory Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch a flag to indicate presence of multiple cases for the same patient
				Then Response is generated with unauthorised status code for fetching a flag to indicate presence of multiple cases for the same patient
				And the attribute "errorMessage" is validated for fetching a flag to indicate presence of multiple cases for the same patient
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    4      | Authorization | invalid_token |
| Sheet1  |    5      | Authorization | invalid_token |
