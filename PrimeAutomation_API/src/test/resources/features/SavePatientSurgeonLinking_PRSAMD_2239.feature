Feature: PRSAMD_2239 - Verifying saving Patient - Surgeon linking and deidentify patient file upload tags via. POST API.

@MIC_PRSAMD-2239_success
Scenario Outline: PRSAMD_2239- Scenario's with Valid Authorization and Value and Request Parameters for saving Patient - Surgeon linking

				Given the user enters the Base URL for saving Patient - Surgeon linking
				When a valid "<Authorization>" and "<Token>" is provided and passing valid "<uploadIdFolderPath>" for saving Patient - Surgeon linking via. POST API
				Then a 200 response is generated for saving Patient - Surgeon linking
				And the attribute validation of "responseMessage" is performed against the response body for patient surgeon linking
				
	Examples:
|Authorization | Token | uploadIdFolderPath |
|Lambda |  lambda_token | mic-raw-image-repository/RawImages/testUpload4 |

@MIC_PRSAMD-2239_failure
Scenario Outline: PRSAMD_2239- Scenario's with Valid Authorization and Value and invalid Request Parameters for saving Patient - Surgeon linking

				Given the user enters the Base URL for saving Patient - Surgeon linking
				When a valid "<Authorization>" and "<Token>" is provided and passing invalid or blank "<uploadIdFolderPath>" for saving Patient - Surgeon linking via. POST API
				Then a 400 response gets generated for saving Patient - Surgeon linking
				And the attribute validation of "errors" is performed against the response body for patient surgeon linking
				
	Examples:
|Authorization | Token | uploadIdFolderPath |
|Lambda |  lambda_token | |
|Lambda |  lambda_token | mic-raw-image-repository/ |
|Lambda |  lambda_token | mic-raw-image-repository/RawImages/testUpload2 |

@MIC_PRSAMD-2239_unauthorised
Scenario Outline: PRSAMD_2239- Scenario's with invalid Authorization and Value and valid Request Parameters for saving Patient - Surgeon linking

				Given the user enters the Base URL for saving Patient - Surgeon linking
				When an invalid "<Authorization>" and "<Token>" is provided and passing valid "<uploadIdFolderPath>" for saving Patient - Surgeon linking via. POST API
				Then a 401 response is getting generated for saving Patient - Surgeon linking
				And the attribute validation of "errors" is performed against the response body for patient surgeon linking
				
	Examples:
|Authorization | Token | uploadIdFolderPath |
|Lambda |  invalid_token | mic-raw-image-repository/RawImages/testUpload4 |