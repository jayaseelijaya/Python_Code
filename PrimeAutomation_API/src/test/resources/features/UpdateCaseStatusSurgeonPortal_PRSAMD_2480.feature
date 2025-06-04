Feature: PRSAMD_2480 - Verifying update case status for Surgeon and admin Portal via. PUT API.

Scenario Outline: PRSAMD_2480- Scenario's with Valid Authorization and valid Request Body

				Given a user enters the valid URL for updating case status for Surgeon and admin Portal
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update case status for Surgeon and admin Portal
				Then Response is generated with success status code to update case status Surgeon portal
				And the attribute "responseMessage" is validated for updating case status for Surgeon and admin Portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | surgeon_token |
| Sheet1  |    1      | Authorization | staff_token |
| Sheet1  |    2      | Authorization | cloud_support_token |

Scenario Outline: PRSAMD_2480- Scenario's with Valid Authorization and Blank Request Body

				Given a user enters the valid URL for updating case status for Surgeon and admin Portal
				When the user gives a valid "<Authorization>" and "<Token>" with blank Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update case status for Surgeon and admin Portal
				Then Response is generated with failure status code to update case status Surgeon portal
				And the attribute "errorMessage" is validated for updating case status for Surgeon and admin Portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    3      | Authorization | surgeon_token |
| Sheet1  |    4      | Authorization | staff_token |
| Sheet1  |    5      | Authorization | cloud_support_token |

Scenario Outline: PRSAMD_2480- Scenario's with Valid Authorization and Invalid Request Body

				Given a user enters the valid URL for updating case status for Surgeon and admin Portal
				When the user gives a valid "<Authorization>" and "<Token>" with invalid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update case status for Surgeon and admin Portal
				Then Response is generated with no data found status code to update case status Surgeon portal
				And the attribute "errorMessage" is validated for updating case status for Surgeon and admin Portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    6      | Authorization | surgeon_token |
| Sheet1  |    7      | Authorization | staff_token |
| Sheet1  |    8      | Authorization | cloud_support_token |


Scenario Outline: PRSAMD_2480- Scenario's with Invalid Authorization and Valid Request Body

				Given a user enters the valid URL for updating case status for Surgeon and admin Portal
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to case status for Surgeon and admin Portal
				Then Response is generated with unauthorized status code to update case status Surgeon portal
				And the attribute "errorMessage" is validated for updating case status for Surgeon and admin Portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1   |   9       |Authorization | invalid_token |
|Sheet1   |   10       |Authorization | invalid_token |