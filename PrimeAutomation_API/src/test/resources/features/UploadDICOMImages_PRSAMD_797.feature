
Feature: PRSAMD_797- Verifying Uploading DICOM Images to AWS S3 via POST API.

@DUU_PRSAMD-797_success
Scenario Outline: PRSAMD_797- Scenario's with Valid Authorization Token for uploading DICOM Images

				Given the Base URL is entered for uploading DICOM Images in AWS S3
				When User enter a valid "<Authorization>" & "<Token>" with valid "<batchId>" triggering the POST API
				Then a 200 response code is generated with file upload success message 
				And the attribute "responseMessage" shown in response is verified
				
	Examples:
	
|Authorization | Token | batchId|
| Authorization | ic_admin_token      | DemoBatch |
| Authorization | ic_technician_token | DemoBatch |
| Authorization | hosp_admin_token    | DemoBatch |
| Authorization | surgeon_token       | DemoBatch |
| Authorization | staff_token         | DemoBatch |

@DUU_PRSAMD-797_failure
Scenario Outline: PRSAMD_797- Scenario's with Valid Authorization Token and Blank Batch ID  for Uploading DICOM Images
				
				Given the Base URL is entered for uploading DICOM Images in AWS S3
				When User enter a valid "<Authorization>" & "<Token>" along with blank "<batchId>" triggering the POST API
				Then a 400 response code is generated with file or batchId invalid message 
				And the attribute "errors" shown in response is verified
				
	Examples:
	
 |Authorization | Token | batchId|
| Authorization | ic_admin_token      |  |
| Authorization | ic_technician_token |  |
| Authorization | hosp_admin_token    |  |
| Authorization | surgeon_token       |  |
| Authorization | staff_token         |  |
 
 
@DUU_PRSAMD-797_no_data
Scenario Outline: PRSAMD_797- Scenario's with Valid Authorization Token and invalid Batch ID for uploading DICOM Images

				Given the Base URL is entered for uploading DICOM Images in AWS S3
				When User enter a valid "<Authorization>" & "<Token>" with an invalid "<batchId>" triggering the POST API
				Then a 404 response code is generated with batchId not found invalid message 
				And the attribute "errors" shown in response is verified

Examples:
	
 |Authorization | Token | batchId|
| Authorization | ic_admin_token      | randomBatch |
| Authorization | ic_technician_token | randomBatch |
| Authorization | hosp_admin_token    | randomBatch |
| Authorization | surgeon_token       | 123Batch |
| Authorization | staff_token         | RanBat | 


@DUU_PRSAMD-797_unauthorised
Scenario Outline: PRSAMD_797- Scenario's with Invalid Authorization Token and Valid Batch ID and File for uploading DICOM Images

				Given the Base URL is entered for uploading DICOM Images in AWS S3
				When the user enters the invalid "<Authorization>" and "<Token>" also with "<batchId>" and triggers the POST API
				Then a response with status code 401  being generated with Unauthorised error details
				And the attribute "errors" shown in response is verified
				
 Examples:
 
 |Authorization | Token |batchId|
 | Authorization | invalid_token | DemoBatch |
 
@DUU_PRSAMD-797_success_Ictechnician
Scenario Outline: PRSAMD_797- Scenario's with Valid Authorization Token for uploading DICOM Images

				Given the Base URL is entered for uploading DICOM Images in AWS S3
				When User enter a valid "<Authorization>" & "<Token>" with valid "<batchId>" triggering the POST API
				Then a 200 response code is generated with file upload success message 
				And the attribute "responseMessage" shown in response is verified
				
	Examples:
	
|Authorization | Token | batchId|
| Authorization | ic_technician_token | DemoBatch |


@DUU_PRSAMD-797_failure_Ictechnician
Scenario Outline: PRSAMD_797- Scenario's with Valid Authorization Token and Blank Batch ID  for Uploading DICOM Images
				
				Given the Base URL is entered for uploading DICOM Images in AWS S3
				When User enter a valid "<Authorization>" & "<Token>" along with blank "<batchId>" triggering the POST API
				Then a 400 response code is generated with file or batchId invalid message 
				And the attribute "errors" shown in response is verified
				
	Examples:
	
 |Authorization | Token | batchId|
| Authorization | ic_technician_token |  |
 
@DUU_PRSAMD-797_Unauthorised_Ictechnician
Scenario Outline: PRSAMD_797- Scenario's with Invalid Authorization Token and Valid Batch ID and File for uploading DICOM Images

				Given the Base URL is entered for uploading DICOM Images in AWS S3
				When the user enters the invalid "<Authorization>" and "<Token>" also with "<batchId>" and triggers the POST API
				Then a response with status code 401  being generated with Unauthorised error details
				And the attribute "errors" shown in response is verified
				
 Examples:
 
 |Authorization | Token |batchId|
 | Authorization | invalid_token | DemoBatch |
 
