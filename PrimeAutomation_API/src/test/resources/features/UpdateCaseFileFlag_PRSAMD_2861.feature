@HIL_PRSAMD-2861

Feature: PRSAMD_2861- Verifying updating case file flag via. PUT API.


Scenario Outline: PRSAMD_2861-Scenario's with Valid Authorization and Request Body PUT API

				Given the base URL is entered for updating case file flag by PUT API
				When user gives a valid "<Authorization>" and "<Token>" and "<SheetName>" <RowNumber> and triggers the PUT API for updating case file flag
				Then Response is generated with success status code while updating case file flag PUT API
				And an attribute "responseMessage" is verified while updating case file flag PUT API
				
	Examples:
|SheetName|RowNumber|Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	  		                                                                                         
|Sheet1|      0     |Lambda| lambda_token |
|Sheet1|      1     |Lambda| lambda_token |
|Sheet1|      2     |Lambda| lambda_token |
|Sheet1|      3     |Lambda| lambda_token |
|Sheet1|      4     |Lambda| lambda_token |

Scenario Outline: PRSAMD_2861-Scenario's with Valid Authorization and Invalid Request Body PUT API

				Given the base URL is entered for updating case file flag by PUT API
				When user gives a valid "<Authorization>" and "<Token>" and invalid test data from "<SheetName>" <RowNumber> and triggers the PUT API for updating case file flag
				Then Response is generated with no data found status code while updating case file flag PUT API
				And an attribute "errorDetails" is verified while updating case file flag PUT API
				
	Examples:
|SheetName|RowNumber|Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	  		                                                                                         
|Sheet1|      5     |Lambda| lambda_token |
|Sheet1|      6     |Lambda| lambda_token |
|Sheet1|      7     |Lambda| lambda_token |

Scenario Outline: PRSAMD_2861-Scenario's with Invalid Authorization and Valid Request Body PUT API

				Given the base URL is entered for updating case file flag by PUT API
				When user gives an invalid "<Authorization>" and "<Token>" and valid test data from "<SheetName>" <RowNumber> and triggers the PUT API for updating case file flag
				Then Response is generated with unauthorised status code while updating case file flag PUT API
				And an attribute "errors" is verified while updating case file flag PUT API
				
	Examples:
|SheetName|RowNumber|Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	  		                                                                                         
|Sheet1|      8     |Lambda| invalid_token |