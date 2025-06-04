Feature: PRSAMD_435- Verifying updating isRead flag associated with an error status via. PUT API.


@DUU_PRSAMD-435_success
Scenario Outline: PRSAMD_435 - Scenario's with Valid Authorization and Valid Request Body to update isRead Flag.

				Given the User enters the Base URL to update isRead Flag
				When user provides a valid "<Authorization>" with "<Token>" with the Request Body from "<SheetName>" and <RowNumber> and trigger the PUT API to update isRead Flag
				Then a response code of 200 is generated fetching the update isRead Flag
				And attribute named "responseMessage" is verified in response body to update isRead Flag.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |0|				Authorization|ic_admin_token | 
 |Sheet1     |1|				Authorization|ic_technician_token | 
 |Sheet1     |2|				Authorization|hosp_admin_token | 
 |Sheet1     |3|				Authorization|surgeon_token | 
 |Sheet1     |4|				Authorization|staff_token |
 
 @DUU_PRSAMD-435_failure
 Scenario Outline: PRSAMD_435 - Scenario's with Valid Authorization and Invalid or Blank Request Bodies to update isRead Flag.

				Given the User enters the Base URL to update isRead Flag
				When User provides a valid "<Authorization>" with "<Token>" with Invalid or Blank Request Bodies from "<SheetName>" and <RowNumber> and trigger the PUT API to update isRead Flag
				Then a response code of 400 is being generated showing error in updating isRead Flag
				And attribute named "errors" is verified in response body to update isRead Flag.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |5|				Authorization|ic_admin_token | 
 |Sheet1     |6|				Authorization|ic_technician_token | 
 |Sheet1     |7|				Authorization|hosp_admin_token | 
 |Sheet1     |8|				Authorization|surgeon_token | 
 |Sheet1     |9|				Authorization|staff_token |
 |Sheet1     |10|				Authorization|ic_admin_token | 
 |Sheet1     |11|				Authorization|ic_technician_token | 
 |Sheet1     |12|				Authorization|hosp_admin_token | 

 
 @DUU_PRSAMD-435_unauthorised
 Scenario Outline: PRSAMD_435 - Scenario's with Invalid Authorization and Valid Request Bodies to update isRead Flag.

				Given the User enters the Base URL to update isRead Flag
				When User provides an invalid "<Authorization>" with "<Token>" with Valid Request Bodies from "<SheetName>" and <RowNumber> and trigger the PUT API to update isRead Flag
				Then a response code of 401 is getting generated showing Unauthorised error in updating isRead Flag
				And attribute named "errors" is verified in response body to update isRead Flag.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |13|				Authorization|invalid_token | 
 |Sheet1     |14|				Authorization|invalid_token |
 
@DUU_PRSAMD-435_success_IcAdmin
Scenario Outline: PRSAMD_435 - Scenario's with Valid Authorization and Valid Request Body to update isRead Flag.
				Given the User enters the Base URL to update isRead Flag
				When user provides a valid "<Authorization>" with "<Token>" with the Request Body from "<SheetName>" and <RowNumber> and trigger the PUT API to update isRead Flag
				Then a response code of 200 is generated fetching the update isRead Flag
				And attribute named "responseMessage" is verified in response body to update isRead Flag.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |0|				Authorization|ic_admin_token | 

@DUU_PRSAMD-435_failure_IcAdmin
 Scenario Outline: PRSAMD_435 - Scenario's with Valid Authorization and Invalid or Blank Request Bodies to update isRead Flag.
				Given the User enters the Base URL to update isRead Flag
				When User provides a valid "<Authorization>" with "<Token>" with Invalid or Blank Request Bodies from "<SheetName>" and <RowNumber> and trigger the PUT API to update isRead Flag
				Then a response code of 400 is being generated showing error in updating isRead Flag
				And attribute named "errors" is verified in response body to update isRead Flag.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |5|				Authorization|ic_admin_token | 
 
@DUU_PRSAMD-435_Unauthorised_IcAdmin
 Scenario Outline: PRSAMD_435 - Scenario's with Invalid Authorization and Valid Request Bodies to update isRead Flag.
				Given the User enters the Base URL to update isRead Flag
				When User provides an invalid "<Authorization>" with "<Token>" with Valid Request Bodies from "<SheetName>" and <RowNumber> and trigger the PUT API to update isRead Flag
				Then a response code of 401 is getting generated showing Unauthorised error in updating isRead Flag
				And attribute named "errors" is verified in response body to update isRead Flag.

	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |13|				Authorization|invalid_token | 
 |Sheet1     |14|				Authorization|invalid_token |
