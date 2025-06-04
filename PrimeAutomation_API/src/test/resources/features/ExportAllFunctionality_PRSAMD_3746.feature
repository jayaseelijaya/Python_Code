Feature: PRSAMD_3746- Verifying Exporting all functionality in Audit Logs via. PUT API.

@DUU_PRSAMD-3746_success
Scenario Outline: PRSAMD_3746-Scenario's with Valid Authorization and Request Body PUT API

				Given the base URL is entered for Exporting all functionality in Audit Logs by PUT API
				When user gives a valid "<Authorization>" and "<Token>" and "<SheetName>" <RowNumber> and triggers the PUTT API for Exporting all functionality in Audit Logs
				Then Response is generated with success status code while Exporting all functionality in Audit Logs PUT API
				And an attribute "responseMessage" is verified while Exporting all functionality in Audit Logs PUT API
				
	Examples:
|SheetName|RowNumber|Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	  		                                                                                         
|Sheet1|      0     |Lambda| lambda_token |
|Sheet1|      1     |Lambda| lambda_token |
|Sheet1|      2     |Lambda| lambda_token |

@DUU_PRSAMD-3746_failure
Scenario Outline: PRSAMD_3746-Scenario's with Valid Authorization and Invalid Request Body PUT API

				Given the base URL is entered for Exporting all functionality in Audit Logs by PUT API
				When user gives a valid "<Authorization>" and "<Token>" and invalid test data from "<SheetName>" <RowNumber> and triggers the PUT API for Exporting all functionality in Audit Logs
				Then Response is generated with failure status code while Exporting all functionality in Audit Logs PUT API
				And an attribute "errors" is verified while Exporting all functionality in Audit Logs PUT API
				
	Examples:
|SheetName|RowNumber|Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	  		                                                                                         
|Sheet1|      3     |Lambda| lambda_token |
|Sheet1|      4     |Lambda| lambda_token |
|Sheet1|      5     |Lambda| lambda_token |
|Sheet1|      6     |Lambda| lambda_token |


@DUU_PRSAMD-3746_unauthorised
Scenario Outline: PRSAMD_3746-Scenario's with Invalid Authorization and Valid Request Body PUT API

				Given the base URL is entered for Exporting all functionality in Audit Logs by PUT API
				When user gives an invalid "<Authorization>" and "<Token>" and valid test data from "<SheetName>" <RowNumber> and triggers the PUT API for Exporting all functionality in Audit Logs
				Then Response is generated with unauthorised status code while Exporting all functionality in Audit Logs PUT API
				And an attribute "errors" is verified while Exporting all functionality in Audit Logs PUT API
				
	Examples:
|SheetName|RowNumber|Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	  		                                                                                         
|Sheet1|      7     |Lambda| invalid_token |

@DUU_PRSAMD-3746_success_Lambda
Scenario Outline: PRSAMD_3746-Scenario's with Valid Authorization and Request Body PUT API

				Given the base URL is entered for Exporting all functionality in Audit Logs by PUT API
				When user gives a valid "<Authorization>" and "<Token>" and "<SheetName>" <RowNumber> and triggers the PUTT API for Exporting all functionality in Audit Logs
				Then Response is generated with success status code while Exporting all functionality in Audit Logs PUT API
				And an attribute "responseMessage" is verified while Exporting all functionality in Audit Logs PUT API
				
	Examples:
|SheetName|RowNumber|Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	  		                                                                                         
|Sheet1|      0     |Lambda| lambda_token |

@DUU_PRSAMD-3746_failure_Lambda
Scenario Outline: PRSAMD_3746-Scenario's with Valid Authorization and Invalid Request Body PUT API

				Given the base URL is entered for Exporting all functionality in Audit Logs by PUT API
				When user gives a valid "<Authorization>" and "<Token>" and invalid test data from "<SheetName>" <RowNumber> and triggers the PUT API for Exporting all functionality in Audit Logs
				Then Response is generated with failure status code while Exporting all functionality in Audit Logs PUT API
				And an attribute "errors" is verified while Exporting all functionality in Audit Logs PUT API
				
	Examples:
|SheetName|RowNumber|Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	  		                                                                                         
|Sheet1|      3     |Lambda| lambda_token |

@DUU_PRSAMD-3746_Unauthorised_Lambda
Scenario Outline: PRSAMD_3746-Scenario's with Invalid Authorization and Valid Request Body PUT API
				Given the base URL is entered for Exporting all functionality in Audit Logs by PUT API
				When user gives an invalid "<Authorization>" and "<Token>" and valid test data from "<SheetName>" <RowNumber> and triggers the PUT API for Exporting all functionality in Audit Logs
				Then Response is generated with unauthorised status code while Exporting all functionality in Audit Logs PUT API
				And an attribute "errors" is verified while Exporting all functionality in Audit Logs PUT API
				
	Examples:
|SheetName|RowNumber|Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	  		                                                                                         
|Sheet1|      7     |Lambda| invalid_token |

