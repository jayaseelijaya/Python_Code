Feature: PRSAMD_734- Verifying fetching Segmentation status of images from the MIC cloud via. GET API.

@MIC_PRSAMD-734_success
Scenario Outline: PRSAMD_734 - Scenario's with Valid Authorization and Valid Request Parameters to fetch Segmentation Status.

				Given the User enters the Base URL to fetch Segmentation Status
				When user provides a valid "<Authorization>" with "<Token>" with the Request Parameter from "<SheetName>" and <RowNumber> and trigger the GET API to fetch segmentation status
				Then a response code of 200 is generated fetching the Segmentation Status
				And attribute named "status" is verified in response body to fetch status.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |0|				Authorization|ic_admin_token | 
 |Sheet1     |1|				Authorization|ic_technician_token | 
 |Sheet1     |2|				Authorization|hosp_admin_token | 
 |Sheet1     |3|				Authorization|surgeon_token | 
 |Sheet1     |4|				Authorization|staff_token | 
 |Sheet1     |5|				Authorization|hil_manager_token |
 |Sheet1     |6|				Lambda| lambda_token |
 
 @MIC_PRSAMD-734_no_data
 Scenario Outline: PRSAMD_734 - Scenario's with Valid Authorization and Invalid and Blank Request Parameters to fetch Segmentation Status.

				Given the User enters the Base URL to fetch Segmentation Status
				When User provides a valid "<Authorization>" with "<Token>" with Invalid or Blank Request Parameter from "<SheetName>" and <RowNumber> and trigger the GET API to fetch segmentation status
				Then a response code of 404 is generated showing error in fetching the Segmentation Status
				And attribute named "errors" is verified in response body to fetch status.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |7|				Authorization|ic_admin_token | 
 |Sheet1     |8|				Authorization|ic_technician_token | 
 |Sheet1     |9|				Authorization|hosp_admin_token | 
 |Sheet1     |10|				Authorization|surgeon_token | 
 |Sheet1     |11|				Authorization|staff_token | 
 |Sheet1     |12|				Authorization|hil_manager_token |
 |Sheet1     |13|				Lambda| lambda_token |
 
 
 @MIC_PRSAMD-734_unauthorised
 Scenario Outline: PRSAMD_734 - Scenario's with Invalid Authorization and Valid Request Parameters to fetch Segmentation Status.

				Given the User enters the Base URL to fetch Segmentation Status
				When User provides an invalid "<Authorization>" with "<Token>" with Valid Request Parameters from "<SheetName>" and <RowNumber> and trigger the GET API to fetch segmentation status
				Then a response code of 401 is generated showing Unauthorised error in fetching the Segmentation Status
				And attribute named "errors" is verified in response body to fetch status.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |14|				Authorization| invalid_token |
 |Sheet1     |15|				Authorization| invalid_token |