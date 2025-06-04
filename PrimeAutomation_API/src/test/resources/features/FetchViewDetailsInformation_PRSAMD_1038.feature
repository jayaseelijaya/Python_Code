Feature: PRSAMD_1038- Verifying fetching view details information on History Dashboard via. GET API.

@DUU_PRSAMD-1038_success
Scenario Outline: PRSAMD_1038 - Scenario's with Valid Authorization and Valid Request Parameters to fetch view details information.

				Given the User enters the Base URL to fetch view details information
				When user provides a valid "<Authorization>" with "<Token>" with the Request Parameter from "<SheetName>" and <RowNumber> and trigger the GET API to fetch view details information
				Then a response code of 200 is generated fetching the view details information
				And attribute named "uploadSizeKB" is verified in response body to fetch view details information.
				
	Examples:
 |SheetName| RowNumber |Authorization | Token |
 | Sheet1    |         0 | Authorization | ic_admin_token      |
 | Sheet1    |         1 | Authorization | ic_technician_token |
 | Sheet1    |         2 | Authorization | hosp_admin_token    |
 | Sheet1    |         3 | Authorization | surgeon_token       |
 | Sheet1    |         4 | Authorization | staff_token         |
 | Sheet1    |         5 | Authorization | hil_manager_token   | 

 
 @DUU_PRSAMD-1038_failure
 Scenario Outline: PRSAMD_1038 - Scenario's with Valid Authorization and Invalid or Blank Request Parameters to fetch view details information.

				Given the User enters the Base URL to fetch view details information
				When User provides a valid "<Authorization>" with "<Token>" with Invalid or Blank Request Parameter from "<SheetName>" and <RowNumber> and trigger the GET API to fetch view details information
				Then a response code of 400 is being generated showing error in fetching the view details information
				And attribute named "errors" is verified in response body to fetch view details information.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 | Sheet1    |         6 | Authorization | ic_admin_token      |
 | Sheet1    |         7 | Authorization | ic_technician_token |
 | Sheet1    |         8 | Authorization | hosp_admin_token    |
 | Sheet1    |         9 | Authorization | surgeon_token       |
 | Sheet1    |         10 | Authorization | staff_token         |
 | Sheet1    |         11 | Authorization | hil_manager_token   | 
 
 @DUU_PRSAMD-1038_unauthorised
 Scenario Outline: PRSAMD_1038 - Scenario's with Invalid Authorization and Valid Request Parameters to fetch view details information.

				Given the User enters the Base URL to fetch view details information
				When User provides an invalid "<Authorization>" with "<Token>" with Valid Request Parameters from "<SheetName>" and <RowNumber> and trigger the GET API to fetch view details information
				Then a response code of 401 is getting generated showing Unauthorised error in fetching the view details information
				And attribute named "errors" is verified in response body to fetch view details information.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |12|				Authorization| invalid_token |
 
 
@DUU_PRSAMD-1038_success_IcAdmin
Scenario Outline: PRSAMD_1038 - Scenario's with Valid Authorization and Valid Request Parameters to fetch view details information.

				Given the User enters the Base URL to fetch view details information
				When user provides a valid "<Authorization>" with "<Token>" with the Request Parameter from "<SheetName>" and <RowNumber> and trigger the GET API to fetch view details information
				Then a response code of 200 is generated fetching the view details information
				And attribute named "uploadSizeKB" is verified in response body to fetch view details information.
				
	Examples:
 |SheetName| RowNumber |Authorization | Token |
 | Sheet1    |         0 | Authorization | ic_admin_token      |

 
@DUU_PRSAMD-1038_failure_Ictechnician
 Scenario Outline: PRSAMD_1038 - Scenario's with Valid Authorization and Invalid or Blank Request Parameters to fetch view details information.
				Given the User enters the Base URL to fetch view details information
				When User provides a valid "<Authorization>" with "<Token>" with Invalid or Blank Request Parameter from "<SheetName>" and <RowNumber> and trigger the GET API to fetch view details information
				Then a response code of 400 is being generated showing error in fetching the view details information
				And attribute named "errors" is verified in response body to fetch view details information.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 | Sheet1    |         7 | Authorization | ic_technician_token |
 
@DUU_PRSAMD-1038_Unauthorised_IcAdmin
 Scenario Outline: PRSAMD_1038 - Scenario's with Invalid Authorization and Valid Request Parameters to fetch view details information.

				Given the User enters the Base URL to fetch view details information
				When User provides an invalid "<Authorization>" with "<Token>" with Valid Request Parameters from "<SheetName>" and <RowNumber> and trigger the GET API to fetch view details information
				Then a response code of 401 is getting generated showing Unauthorised error in fetching the view details information
				And attribute named "errors" is verified in response body to fetch view details information.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |12|				Authorization| invalid_token |