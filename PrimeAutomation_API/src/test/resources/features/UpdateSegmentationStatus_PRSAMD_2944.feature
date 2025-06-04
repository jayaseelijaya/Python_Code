Feature: PRSAMD_2944- Verifying Updating Segmentation status of patient images from the MIC cloud via. PUT API.

@MIC_PRSAMD-2944_success
Scenario Outline: PRSAMD_2944 - Scenario's with Valid Authorization and Valid Request Body to update Segmentation Status.

				Given the User enters the Base URL for Updating Segmentation status of patient images from the MIC cloud
				When user provides a valid "<Authorization>" with "<Token>" with the valid Request body from "<SheetName>" and <RowNumber> and trigger the PUT API for Updating Segmentation status of patient images from the MIC cloud
				Then a response is generated with a success status code for Updating Segmentation status of patient images from the MIC cloud
				And attribute named "responseMessage" is verified in response body for Updating Segmentation status of patient images from the MIC cloud
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |0|				Authorization|ic_admin_token | 
 |Sheet1     |1|				Authorization|ic_technician_token | 
 |Sheet1     |2|				Authorization|hosp_admin_token | 
 |Sheet1     |3|				Authorization|surgeon_token | 
 |Sheet1     |4|				Authorization|staff_token | 
 |Sheet1     |5|				Authorization|hil_manager_token |
 |Sheet1     |6|				Authorization|hil_reviewer_token |
 |Sheet1     |7|				Lambda| lambda_token |
 
 @MIC_PRSAMD-2944_failure
 Scenario Outline: PRSAMD_2944 - Scenario's with Valid Authorization and Blank Request Body to update Segmentation Status.

				Given the User enters the Base URL for Updating Segmentation status of patient images from the MIC cloud
				When User provides a valid "<Authorization>" with "<Token>" with Blank Request Body from "<SheetName>" and <RowNumber> and trigger the PUT API for Updating Segmentation status of patient images from the MIC cloud
				Then a response is generated with a failure status code for Updating Segmentation status of patient images from the MIC cloud
				And attribute named "errors" is verified in response body for Updating Segmentation status of patient images from the MIC cloud
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |8|				Authorization|ic_admin_token | 
 |Sheet1     |9|				Authorization|ic_technician_token | 
 |Sheet1     |10|				Authorization|hosp_admin_token | 
 |Sheet1     |11|				Authorization|surgeon_token | 
 |Sheet1     |12|				Authorization|staff_token | 
 |Sheet1     |13|				Authorization|hil_manager_token |
 |Sheet1     |14|				Authorization|hil_reviewer_token |
 |Sheet1     |15|				Lambda| lambda_token |
 
 @MIC_PRSAMD-2944_no_data
 Scenario Outline: PRSAMD_2944 - Scenario's with Valid Authorization and Invalid Request Body to update Segmentation Status.

				Given the User enters the Base URL for Updating Segmentation status of patient images from the MIC cloud
				When User provides a valid "<Authorization>" with "<Token>" with Invalid Request Body from "<SheetName>" and <RowNumber> and trigger the PUT API for Updating Segmentation status of patient images from the MIC cloud
				Then a response is generated with a no data status code for Updating Segmentation status of patient images from the MIC cloud
				And attribute named "errors" is verified in response body for Updating Segmentation status of patient images from the MIC cloud
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |16|				Authorization|ic_admin_token | 
 |Sheet1     |17|				Authorization|ic_technician_token | 
 |Sheet1     |18|				Authorization|hosp_admin_token | 
 |Sheet1     |19|				Authorization|surgeon_token | 
 |Sheet1     |20|				Authorization|staff_token | 
 |Sheet1     |21|				Authorization|hil_manager_token |
 |Sheet1     |22|				Authorization|hil_reviewer_token |
 |Sheet1     |23|				Lambda| lambda_token |
 
 @MIC_PRSAMD-2944_unauthorised
 Scenario Outline: PRSAMD_2944 - Scenario's with Invalid Authorization and Valid Request Body to update Segmentation Status.

				Given the User enters the Base URL for Updating Segmentation status of patient images from the MIC cloud
				When User provides an invalid "<Authorization>" with "<Token>" with Valid Request body from "<SheetName>" and <RowNumber> and trigger the PUT API for Updating Segmentation status of patient images from the MIC cloud
				Then a response is generated with a unauthorised status code for Updating Segmentation status of patient images from the MIC cloud
				And attribute named "errors" is verified in response body for Updating Segmentation status of patient images from the MIC cloud
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |24|				Authorization|invalid_token |
 |Sheet1     |25|				Authorization|invalid_token |