Feature: PRSAMD_3488- Verifying Fetching Audit Log Filter Values via. GET API.

@DUU_PRSAMD-3488_success
Scenario Outline: PRSAMD_3488-Scenario's with Valid Authorization and Request Body

				Given the base URL gets entered for Fetching the Audit Log Filter Values
				When user gives a valid "<Authorization>" and "<Token>" and "<SheetName>" <RowNumber> and triggers the GET API for Fetching the Audit Log Filter Values
				Then Response is generated with success status code while Fetching the Audit Log Filter Values
				And an attribute "filterValues" is verified while Fetching the Audit Log Filter Values
				
	Examples:
|SheetName|RowNumber|Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	  		                                                                                         
 |Sheet1     |0|				Authorization| ic_admin_token | 
 |Sheet1     |1|				Authorization| hosp_admin_token | 
 |Sheet1     |2|				Authorization| hil_manager_token |
 |Sheet1     |3|				Authorization| ic_admin_token | 
 |Sheet1     |4|				Authorization| hosp_admin_token | 
 |Sheet1     |5|				Authorization| hil_manager_token |
 |Sheet1     |6|				Authorization| ic_admin_token | 
 |Sheet1     |7|				Authorization| hosp_admin_token | 
 |Sheet1     |8|				Authorization| hil_manager_token |
 

@DUU_PRSAMD-3488_unauthorised
Scenario Outline: PRSAMD_3488-Scenario's with Invalid Authorization and valid user facility ID

				Given the base URL gets entered for Fetching the Audit Log Filter Values
				When user gives an invalid "<Authorization>" and "<Token>" and valid "<SheetName>" <RowNumber> and triggers the GET API for  Fetching the Audit Log Filter Values
				Then Response is generated with unauthorized status code while Fetching the Audit Log Filter Values
				And an attribute "errors" is verified while Fetching the Audit Log Filter Values
				
	Examples:
|SheetName|RowNumber|Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	  		                                                                                         
|Sheet1|      9     |Authorization| invalid_token |


@DUU_PRSAMD-3488_success_HospitalAdmin
Scenario Outline: PRSAMD_3488-Scenario's with Valid Authorization and Request Body
				Given the base URL gets entered for Fetching the Audit Log Filter Values
				When user gives a valid "<Authorization>" and "<Token>" and "<SheetName>" <RowNumber> and triggers the GET API for Fetching the Audit Log Filter Values
				Then Response is generated with success status code while Fetching the Audit Log Filter Values
				And an attribute "filterValues" is verified while Fetching the Audit Log Filter Values
				
	Examples:
|SheetName|RowNumber|Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	  		                                                                                         
 |Sheet1     |1|				Authorization| hosp_admin_token | 
 
@DUU_PRSAMD-3488_Unauthorised_HospitalAdmin
Scenario Outline: PRSAMD_3488-Scenario's with Invalid Authorization and valid user facility ID
				Given the base URL gets entered for Fetching the Audit Log Filter Values
				When user gives an invalid "<Authorization>" and "<Token>" and valid "<SheetName>" <RowNumber> and triggers the GET API for  Fetching the Audit Log Filter Values
				Then Response is generated with unauthorized status code while Fetching the Audit Log Filter Values
				And an attribute "errors" is verified while Fetching the Audit Log Filter Values
				
	Examples:
|SheetName|RowNumber|Authorization|Token|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	  		                                                                                         
|Sheet1|      9     |Authorization| invalid_token |