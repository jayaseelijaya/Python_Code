Feature: PRSAMD_655- Verifying Fetching Filter Values on Summary Dashboard and History Screen via. GET API.

@DUU_PRSAMD-655_success
Scenario Outline: PRSAMD_655 -Scenario's with Valid Request Parameters and Valid tokens to fetch filter values on summary dashboard.

				Given The Base URL is entered to fetch dashboard filter values
				When user provides a valid "<Authorization>" with "<Token>" with the Request Parameter from "<SheetName>" and <RowNumber> and trigger the GET API to fetch dashboard filter values
				Then a 200 response is generated to fetch dashboard filter values
				And an attribute "facilityFilterResponse" is verified to filter dashboard details
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |0|				Authorization|ic_admin_token |
 |Sheet1     |1|				Authorization|ic_technician_token | 
 |Sheet1     |2|				Authorization|hosp_admin_token | 
 |Sheet1     |3|				Authorization|surgeon_token | 
 |Sheet1     |4|				Authorization|staff_token | 
 |Sheet1     |5|				Authorization|hil_manager_token |
 |Sheet1     |6|				Authorization|ic_admin_token |
 |Sheet1     |7|				Authorization|ic_technician_token | 
 |Sheet1     |8|				Authorization|hosp_admin_token | 
 |Sheet1     |9|				Authorization|surgeon_token | 
 |Sheet1     |10|				Authorization|staff_token | 
 |Sheet1     |11|				Authorization|hil_manager_token |


@DUU_PRSAMD-655_unauthorised
Scenario Outline: PRSAMD_655 -Scenario's with Valid Request Parameters and Invalid tokens to fetch filter values on summary dashboard.

				Given The Base URL is entered to fetch dashboard filter values
				When user provides an invalid "<Authorization>" with "<Token>" with the Request Parameter from "<SheetName>" and <RowNumber> and trigger the GET API to fetch dashboard filter values
				Then a 401 response gets generated to fetch dashboard filter values
				And an attribute "errors" is verified to filter dashboard details
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
|Sheet1     |12|				Authorization|invalid_token |


@DUU_PRSAMD-655_success_Icadmin
Scenario Outline: PRSAMD_655 -Scenario's with Valid Request Parameters and Valid tokens to fetch filter values on summary dashboard.
				Given The Base URL is entered to fetch dashboard filter values
				When user provides a valid "<Authorization>" with "<Token>" with the Request Parameter from "<SheetName>" and <RowNumber> and trigger the GET API to fetch dashboard filter values
				Then a 200 response is generated to fetch dashboard filter values
				And an attribute "facilityFilterResponse" is verified to filter dashboard details
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |0|				Authorization|ic_admin_token |
 
@DUU_PRSAMD-655_Unauthorised_Icadmin
Scenario Outline: PRSAMD_655 -Scenario's with Valid Request Parameters and Invalid tokens to fetch filter values on summary dashboard.
				Given The Base URL is entered to fetch dashboard filter values
				When user provides an invalid "<Authorization>" with "<Token>" with the Request Parameter from "<SheetName>" and <RowNumber> and trigger the GET API to fetch dashboard filter values
				Then a 401 response gets generated to fetch dashboard filter values
				And an attribute "errors" is verified to filter dashboard details
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
|Sheet1     |12|				Authorization|invalid_token |
 