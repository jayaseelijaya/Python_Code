
Feature: PRSAMD_2947- Verifying Updating Status of Uploaded File via. PUT API.

@DUU_PRSAMD-2947_success
Scenario Outline: PRSAMD_2947- Scenario's with valid Authorization Tokens and Request Body to update status of uploaded file.

		Given the Base URL is entered for Updating Status of Uploaded File
		When the user provides valid "<Authorization>" with valid "<Token>" and is extracting test data from "<SheetName>" <RowNumber> for updating uploaded file status and triggers the PUT API
		Then Response is generated with success status code for updating uploaded file status
		And an attribute "responseMessage" is validated for updating uploaded file status
		
	Examples:
	
 |SheetName| RowNumber |Authorization | Token |
 |Sheet1     |0|				Authorization|ic_admin_token | 
 |Sheet1     |1|				Authorization|ic_technician_token | 
 |Sheet1     |2|				Authorization|hosp_admin_token | 
 |Sheet1     |3|				Authorization|surgeon_token | 
 |Sheet1     |4|				Authorization|staff_token | 
 |Sheet1     |5|				Authorization|hil_manager_token |
 |Sheet1     |6|				Lambda| lambda_token |
 |Sheet1     |7|				Authorization|hil_reviewer_token |
 
 @DUU_PRSAMD-2947_failure
Scenario Outline: PRSAMD_2947- Scenario's with Valid Authorization Tokens and invalid uploadId updating uploaded file status.

		Given the Base URL is entered for Updating Status of Uploaded File
		When the user uses valid "<Authorization>" & valid "<Token>" along with an invalid or blank uploadId in "<SheetName>" <RowNumber> for updating uploaded file status and triggers the PUT API
		Then Response is generated with failure status code for updating uploaded file status
		And an attribute "errors" is validated for updating uploaded file status
		
	Examples:
	
 |SheetName| RowNumber |Authorization | Token |
 |Sheet1     |8|				Authorization|ic_admin_token | 
 |Sheet1     |9|				Authorization|ic_technician_token | 
 |Sheet1     |10|				Authorization|hosp_admin_token | 
 |Sheet1     |11|				Authorization|surgeon_token | 
 |Sheet1     |12|				Authorization|staff_token | 
 |Sheet1     |13|				Authorization|hil_manager_token |
 |Sheet1     |14|				Lambda| lambda_token |
 |Sheet1     |15|				Authorization|hil_reviewer_token |
 
 
 @DUU_PRSAMD-2947_failure
Scenario Outline: PRSAMD_2947- Scenario's with Valid Authorization Tokens and invalid status for updating uploaded file status.

		Given the Base URL is entered for Updating Status of Uploaded File
		When the user uses a valid "<Authorization>" & valid "<Token>" along with invalid or blank status in "<SheetName>" <RowNumber> for updating uploaded file status and triggers the PUT API
		Then Response is generated with failure status code for updating uploaded file status
		And an attribute "errors" is validated for updating uploaded file status
	Examples:
	
 |SheetName| RowNumber |Authorization | Token |
 |Sheet1     |16|				Authorization|ic_admin_token | 
 |Sheet1     |17|				Authorization|ic_technician_token | 
 |Sheet1     |18|				Authorization|hosp_admin_token | 
 |Sheet1     |19|				Authorization|surgeon_token | 
 |Sheet1     |20|				Authorization|staff_token | 
 |Sheet1     |21|				Authorization|hil_manager_token |
 |Sheet1     |22|				Lambda| lambda_token |
 |Sheet1     |23|				Authorization|hil_reviewer_token |
 
 @DUU_PRSAMD-2947_unauthorised
Scenario Outline: PRSAMD_2947- Scenario's with invalid Authorization Tokens and valid Request Body for updating uploaded file status.

		Given the Base URL is entered for Updating Status of Uploaded File
		When the user provides an invalid "<Authorization>" with invalid "<Token>" and the test data is being extracted from "<SheetName>" <RowNumber> for updating uploaded file status and triggers the PUT API
		Then Response is generated with unauthorized status code for updating uploaded file status
		And an attribute "errors" is validated for updating uploaded file status
	Examples:
	
 |SheetName| RowNumber  |Authorization | Token |
 |Sheet1     |24|				Authorization |invalid_token |
 
@DUU_PRSAMD-2947_success_Ictechnician
Scenario Outline: PRSAMD_2947- Scenario's with valid Authorization Tokens and Request Body to update status of uploaded file.

		Given the Base URL is entered for Updating Status of Uploaded File
		When the user provides valid "<Authorization>" with valid "<Token>" and is extracting test data from "<SheetName>" <RowNumber> for updating uploaded file status and triggers the PUT API
		Then Response is generated with success status code for updating uploaded file status
		And an attribute "responseMessage" is validated for updating uploaded file status
		
	Examples:
	
 |SheetName| RowNumber |Authorization | Token |
 |Sheet1     |1|				Authorization|ic_technician_token | 
 
 
@DUU_PRSAMD-2947_failure_Ictechnician
Scenario Outline: PRSAMD_2947- Scenario's with Valid Authorization Tokens and invalid status for updating uploaded file status.
		Given the Base URL is entered for Updating Status of Uploaded File
		When the user uses a valid "<Authorization>" & valid "<Token>" along with invalid or blank status in "<SheetName>" <RowNumber> for updating uploaded file status and triggers the PUT API
		Then Response is generated with failure status code for updating uploaded file status
		And an attribute "errors" is validated for updating uploaded file status
	Examples:
	
 |SheetName| RowNumber |Authorization | Token |
 |Sheet1     |17|				Authorization|ic_technician_token | 
 
@DUU_PRSAMD-2947_Unauthorised_Ictechnician
Scenario Outline: PRSAMD_2947- Scenario's with invalid Authorization Tokens and valid Request Body for updating uploaded file status.

		Given the Base URL is entered for Updating Status of Uploaded File
		When the user provides an invalid "<Authorization>" with invalid "<Token>" and the test data is being extracted from "<SheetName>" <RowNumber> for updating uploaded file status and triggers the PUT API
		Then Response is generated with unauthorized status code for updating uploaded file status
		And an attribute "errors" is validated for updating uploaded file status
	Examples:
	
 |SheetName| RowNumber  |Authorization | Token |
 |Sheet1     |24|				Authorization |invalid_token |
 