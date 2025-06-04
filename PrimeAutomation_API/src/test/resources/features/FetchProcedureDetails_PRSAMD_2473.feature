Feature: PRSAMD_2473 - Verifying fetching procedure details for Admin-Surgeon Portal via. GET API.

Scenario Outline: PRSAMD_2473- Scenario's with Valid Authorization and valid Request Parameters

				Given a user enters the valid URL for fetching procedure details for Admin-Surgeon Portal
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch procedure details for Admin-Surgeon Portal
				Then Response is generated with success status code for fetching procedure details for Admin-Surgeon Portal
				And the attribute "caseId" is validated for fetching procedure details for Admin-Surgeon Portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | cloud_support_token |
| Sheet1  |    1      | Authorization | cloud_support_token |
| Sheet1  |    2      | Authorization | cloud_support_token |
| Sheet1  |    3      | Authorization | cloud_support_token |

Scenario Outline: PRSAMD_2473- Scenario's with Invalid Authorization and Valid Request Parameter

				Given a user enters the valid URL for fetching procedure details for Admin-Surgeon Portal
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch procedure details for Admin-Surgeon Portal
				Then Response is generated with unauthorized status code for fetching procedure details for Admin-Surgeon Portal
				And the attribute "errorMessage" is validated for fetching procedure details for Admin-Surgeon Portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   4       |Authorization  | invalid_token |
|Sheet1   |   5       |Authorization  | invalid_token |
