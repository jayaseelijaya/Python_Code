Feature: PRSAMD_1685 - Verifying Fetching Facilities list and optionally Source Facilities via. GET API.


@DUU_PRSAMD-1685_success
Scenario Outline: PRSAMD_1685- Scenario's with Valid Authorization and Value and Request Parameters for fetching Facilities

				Given the user enters the Base URL for fetching Facilities
				When a valid "<Authorization>" and "<Token>" is provided extracting Test data form "<SheetName>" <RowNumber> for fetching facilities via. GET API
				Then a 200 response is generated for Fetching Facilities
				And the attribute validation of "facilityId" is performed against the response body
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 | Sheet1    |         0 | Authorization | ic_admin_token      |
 | Sheet1    |         1 | Authorization | ic_technician_token |
 | Sheet1    |         2 | Authorization | hosp_admin_token    |
 | Sheet1    |         3 | Authorization | surgeon_token       |
 | Sheet1    |         4 | Authorization | staff_token         |
 | Sheet1    |         5 | Authorization | hil_manager_token   | 
 | Sheet1    |         6 | Authorization | ic_admin_token      |
 | Sheet1    |         7 | Authorization | ic_technician_token |
 | Sheet1    |         8 | Authorization | hosp_admin_token    |
 | Sheet1    |         9 | Authorization | surgeon_token       |
 | Sheet1    |         10 | Authorization | staff_token         |
 | Sheet1    |         11 | Authorization | hil_manager_token   | 
	
	
@DUU_PRSAMD-1685_unauthorised
Scenario Outline: PRSAMD_1685- Scenario's with Invalid Authorization and Value and Valid Request Parameters for fetching Facilities

				Given the user enters the Base URL for fetching Facilities
				When an invalid "<Authorization>" and "<Token>" is provided extracting Test data form "<SheetName>" <RowNumber> for fetching facilities via. GET API
				Then a 401 response is being generated for Fetching Facilities
				And the attribute validation of "errors" is performed against the response body
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
|Sheet1     |12|				Authorization| invalid_token |


@DUU_PRSAMD-1685_success_Ictechnician
Scenario Outline: PRSAMD_1685- Scenario's with Valid Authorization and Value and Request Parameters for fetching Facilities
				Given the user enters the Base URL for fetching Facilities
				When a valid "<Authorization>" and "<Token>" is provided extracting Test data form "<SheetName>" <RowNumber> for fetching facilities via. GET API
				Then a 200 response is generated for Fetching Facilities
				And the attribute validation of "facilityId" is performed against the response body		
	Examples:
|SheetName| RowNumber |Authorization | Token |
 | Sheet1    |         1 | Authorization | ic_technician_token |
 
@DUU_PRSAMD-1685_Unauthorised_Ictechnician
Scenario Outline: PRSAMD_1685- Scenario's with Invalid Authorization and Value and Valid Request Parameters for fetching Facilities
				Given the user enters the Base URL for fetching Facilities
				When an invalid "<Authorization>" and "<Token>" is provided extracting Test data form "<SheetName>" <RowNumber> for fetching facilities via. GET API
				Then a 401 response is being generated for Fetching Facilities
				And the attribute validation of "errors" is performed against the response body
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
|Sheet1     |12|				Authorization| invalid_token |
