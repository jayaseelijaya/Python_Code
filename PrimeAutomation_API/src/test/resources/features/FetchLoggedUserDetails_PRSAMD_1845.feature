Feature: PRSAMD_1845- Verifying fetching logged in user details from Common Login Portal via. GET API.

@DUU_PRSAMD-1845_success
Scenario Outline: PRSAMD_1845 -Scenario's with Valid Authorization and Valid Request parameters

				Given user enters the Base URL to fetch logged in user details
				When user gives a valid "<Authorization>" and "<Token>" along with a valid userName from "<SheetName>" <RowNumber> and trigger the GET API to fetch logged in user details
				Then a 200 response is generated showing the logged in user details 
				And the response message of "userName" is verified for logged in user details 
				
	Examples:
 |SheetName|RowNumber|Authorization | Token |
 |Sheet1     |0|				Authorization|ic_admin_token | 
 |Sheet1     |1|				Authorization|ic_technician_token | 
 |Sheet1     |2|				Authorization|hosp_admin_token | 
 |Sheet1     |3|				Authorization|surgeon_token | 
 |Sheet1     |4|				Authorization|staff_token | 
 |Sheet1     |5|				Authorization|hil_manager_token | 
 
 @DUU_PRSAMD-1845_success
 Scenario Outline: PRSAMD_1845 -Scenario's with Valid Authorization and Invalid Request parameters

				Given user enters the Base URL to fetch logged in user details
				When user gives a valid "<Authorization>" and "<Token>" along with an invalid userName from "<SheetName>" <RowNumber> and trigger the GET API to fetch logged in user details
				Then a 200 response is generated showing the logged in user details 
			
				
	Examples:
 |SheetName|RowNumber|Authorization | Token |
 |Sheet1     |6|				Authorization|ic_admin_token | 
 |Sheet1     |7|				Authorization|ic_technician_token | 
 |Sheet1     |8|				Authorization|hosp_admin_token | 
 |Sheet1     |9|				Authorization|surgeon_token | 
 |Sheet1     |10|				Authorization|staff_token | 
 |Sheet1     |11|				Authorization|hil_manager_token | 
  
 @DUU_PRSAMD-1845_unauthorised
Scenario Outline: PRSAMD_1845 -Scenario's with Invalid Authorization and Valid Request parameters

				Given user enters the Base URL to fetch logged in user details
				When user gives an invalid "<Authorization>" and "<Token>" along with userName from "<SheetName>" <RowNumber>  and trigger the GET API to fetch logged in user details
				Then a 401 response gets generated showing the logged in user details 
				And the response message of "errors" is verified for logged in user details 
				
	Examples:
|SheetName|RowNumber|Authorization | Token |	
|Sheet1     |12|				Authorization| invalid_token |



@DUU_PRSAMD-1845_success_Staff
Scenario Outline: PRSAMD_1845 -Scenario's with Valid Authorization and Valid Request parameters
				Given user enters the Base URL to fetch logged in user details
				When user gives a valid "<Authorization>" and "<Token>" along with a valid userName from "<SheetName>" <RowNumber> and trigger the GET API to fetch logged in user details
				Then a 200 response is generated showing the logged in user details 
				And the response message of "userName" is verified for logged in user details 
				
	Examples:
 |SheetName|RowNumber|Authorization | Token |
 |Sheet1     |4|				Authorization|staff_token | 
 
@DUU_PRSAMD-1845_Unauthorised_Staff
Scenario Outline: PRSAMD_1845 -Scenario's with Invalid Authorization and Valid Request parameters
				Given user enters the Base URL to fetch logged in user details
				When user gives an invalid "<Authorization>" and "<Token>" along with userName from "<SheetName>" <RowNumber>  and trigger the GET API to fetch logged in user details
				Then a 401 response gets generated showing the logged in user details 
				And the response message of "errors" is verified for logged in user details 
				
	Examples:
|SheetName|RowNumber|Authorization | Token |	
|Sheet1     |12|				Authorization| invalid_token |