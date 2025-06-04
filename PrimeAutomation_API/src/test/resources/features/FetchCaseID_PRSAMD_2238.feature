Feature: PRSAMD_2238- Verifying fetching Case Id from Upload Id in MIC Hospital Microservice via. GET API


@MIC_PRSAMD-2238_success
Scenario Outline: PRSAMD_2238- Scenario's with Valid Tokens and valid Request Parameters

				Given user enters the valid URL for fetching case ID 
				When User enters a valid "<Authorization>" and "<Token>" with test data from "<SheetName>" and <RowNumber> for fetching case ID from MIC Hospital Microservice
				Then a 200 response status is generated for fetching case ID
				And the response body attribute "caseId" is validated against the response body provided 

	Examples:
|SheetName| RowNumber |Authorization| Token |
| Sheet1  |    0      |Lambda				| lambda_token |
| Sheet1  |    1      | Authorization | hil_manager_token |
| Sheet1  |    2      | Authorization | hil_reviewer_token |
| Sheet1  |    3      |Lambda				| lambda_token |
| Sheet1  |    4      | Authorization | hil_manager_token |
| Sheet1  |    5      | Authorization | hil_reviewer_token |

@MIC_PRSAMD-2238_unauthorised
Scenario Outline: PRSAMD_2238- Scenario's with Invalid Authorization and valid Request Parameters

				Given user enters the valid URL for fetching case ID 
				When User enters an invalid "<Authorization>" and "<Token>" with valid  test data from "<SheetName>" and <RowNumber> for fetching case ID from MIC Hospital Microservice
				Then a 401 response status gets generated for fetching case ID
				And the response body attribute "errors" is validated against the response body provided 

	Examples:
|SheetName| RowNumber |Authorization | Token |
|Sheet1     |6|				Authorization| invalid_token |
|Sheet1     |7|				Authorization| invalid_token |