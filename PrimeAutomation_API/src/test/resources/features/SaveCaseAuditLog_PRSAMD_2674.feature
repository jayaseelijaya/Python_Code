
Feature: PRSAMD_2674 -Verifying Save Case Audit Log via. POST API.


@HIL_PRSAMD-2674_success
Scenario Outline: PRSAMD_2674- Scenario's with Valid Authorization and Valid Request Bodies for saving case audit log.
				Given User provides a base URL for saving case audit log
				When a valid "<Authorization>" and valid "<Token>" is provided with valid test data extracted from "<SheetName>" <RowNumber>  for saving case audit log via. POST API
				Then Response is generated with success status code for saving case audit log
				And an attribute of "responseMessage" is validated for saving case audit log

	Examples:
|SheetName|RowNumber|Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	  		                                                                                         
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_reviewer_token |
| Sheet1  |    2      |    Lambda     | lambda_token |
| Sheet1  |    3      | Authorization | hil_manager_token |
| Sheet1  |    4      | Authorization | hil_reviewer_token |
| Sheet1  |    5      |    Lambda     | lambda_token |

@HIL_PRSAMD-2674_failure
Scenario Outline: PRSAMD_2674- Scenario's with Valid Authorization and Invalid Request Bodies for saving case audit log.
				Given User provides a base URL for saving case audit log
				When a valid "<Authorization>" and valid "<Token>" is provided with invalid test datas extracted from "<SheetName>" <RowNumber>  for saving case audit log via. POST API
				Then Response is generated with failure status code for saving case audit log
				And an attribute of "errors" is validated for saving case audit log

	Examples:
|SheetName|RowNumber|Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	  		                                                                                         
| Sheet1  |    6      | Authorization | hil_manager_token |
| Sheet1  |    7      | Authorization | hil_reviewer_token |
| Sheet1  |    8      |    Lambda     | lambda_token |
| Sheet1  |    9      | Authorization | hil_manager_token |
| Sheet1  |    10      | Authorization | hil_reviewer_token |
| Sheet1  |    11      |    Lambda     | lambda_token |


@HIL_PRSAMD-2674_unauthorised
Scenario Outline: PRSAMD_2674- Scenario's with Invalid Authorization and Valid Request Bodies for saving case audit log.
				Given User provides a base URL for saving case audit log
				When an invalid "<Authorization>" and invalid "<Token>" is provided with valid test datas extracted from "<SheetName>" <RowNumber>  for saving case audit log via. POST API
				Then Response is generated with unauthorized status code for saving case audit log
				And an attribute of "errors" is validated for saving case audit log

	Examples:
|SheetName|RowNumber|Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	  		                                                                                         
|Sheet1|      12    |Authorization| invalid_token |