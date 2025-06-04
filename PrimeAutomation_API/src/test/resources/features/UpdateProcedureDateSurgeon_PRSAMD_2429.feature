Feature: PRSAMD_2429 - Verifying update procedure date for Surgeon Portal via. PUT API.

@MIC_PRSAMD-2429_success
Scenario Outline: PRSAMD_2429- Scenario's with Valid Authorization and valid Request Body

				Given a user enters the valid URL for updating procedure date for Surgeon Portal
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update procedure date for Surgeon Portal
				Then Response is generated with success status code to update procedure date
				And the attribute "responseMessage" is validated for updating procedure date for Surgeon Portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | surgeon_token |
| Sheet1  |    1      | Authorization | staff_token |
| Sheet1  |    2      | Authorization | surgeon_token |
| Sheet1  |    3      | Authorization | staff_token |

@MIC_PRSAMD-2429_no_data
Scenario Outline: PRSAMD_2429- Scenario's with Valid Authorization and Invalid or blank Request Body

				Given a user enters the valid URL for updating procedure date for Surgeon Portal
				When the user gives a valid "<Authorization>" and "<Token>" with invalid or blank Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update procedure date for Surgeon Portal
				Then Response is generated with no data found status code to update procedure date
				And the attribute "errorMessage" is validated for updating procedure date for Surgeon Portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    4      | Authorization | surgeon_token |
| Sheet1  |    5      | Authorization | staff_token |
| Sheet1  |    6      | Authorization | surgeon_token |
| Sheet1  |    7      | Authorization | staff_token |


@MIC_PRSAMD-2429_unauthorised
Scenario Outline: PRSAMD_2429- Scenario's with Invalid Authorization and Valid Request Body

				Given a user enters the valid URL for updating procedure date for Surgeon Portal
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update procedure date for Surgeon Portal
				Then Response is generated with unauthorized status code to update procedure date
				And the attribute "errorMessage" is validated for updating procedure date for Surgeon Portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   8      |Authorization | invalid_token |
|Sheet1   |   9      |Authorization | invalid_token |