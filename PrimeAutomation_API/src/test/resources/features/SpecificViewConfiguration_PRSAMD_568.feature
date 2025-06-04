
Feature: PRSAMD_568- Verifying creating user/facility specific view configuration via. POST API.

@DUU_PRSAMD-568_success
Scenario Outline: PRSAMD_568- Scenario's with Valid Authorization and Request Body to create specific view configuration.
				
				Given User enters the Base URL for Creating Specific View Configuration
				When User gives a valid "<Authorization>" with "<Token>" along with userFacilityId and "<isFacilityWide>" triggering the POST API
				Then 200 response gets generated depicting Specific View Configuration Details
				And "responseMessage" attribute is verified by the User
				
	Examples:
|Authorization  | Token | isFacilityWide |
| Authorization | ic_admin_token   | false |
| Authorization | hosp_admin_token | true |

@DUU_PRSAMD-568_failure
Scenario Outline: PRSAMD_568-Scenario's with Valid Authorization and invalid or blank Request Body parameters to create specific view configuration.

				Given User enters the Base URL for Creating Specific View Configuration
				When User provides a valid "<Authorization>" & "<Token>" and pull Test Data from "<SheetName>" <RowNumber> triggering the POST API
				Then 400 response is generated showing the Specific View Configuration Details
				And "errors" attribute is verified by the User
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
| Sheet1    |         0 | Authorization | ic_admin_token    |
| Sheet1    |         1 | Authorization | hosp_admin_token  |
| Sheet1    |         2 | Authorization | ic_admin_token    |
| Sheet1    |         3 | Authorization | hosp_admin_token  |

 @DUU_PRSAMD-568_configuration_exists
Scenario Outline: PRSAMD_568-Scenario's with Valid Authorization and already existing specific view configuration.

				Given User enters the Base URL for Creating Specific View Configuration
				When User give  a valid "<Authorization>" & "<Token>" and pull already existing Configuration Test Data from "<SheetName>" <RowNumber> triggering the POST API
				Then 409 response is getting generated showing the Specific View Configuration Details
				And "errors" attribute is verified by the User
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
| Sheet1    |         4 | Authorization | ic_admin_token    |
| Sheet1    |         5 | Authorization | hosp_admin_token  |
| Sheet1    |         6 | Authorization | ic_admin_token    |

@DUU_PRSAMD-568_unauthorised
Scenario Outline: PRSAMD_568- Scenario's with Invalid Authorization and Request Body to create specific view configuration.

				
				Given User enters the Base URL for Creating Specific View Configuration
				When User gives an invalid "<Authorization>" with "<Token>" along with userFacilityId and "<isFacilityWide>" triggering the POST API
				Then 401 response must get generated depicting Specific View Configuration Details
				And "errors" attribute is verified by the User
				
	Examples:
|Authorization | Token | isFacilityWide |
|Authorization| invalid_token | true |
|Authorization| invalid_token | false |

@DUU_PRSAMD-568_success_Ictechnician
Scenario Outline: PRSAMD_568- Scenario's with Valid Authorization and Request Body to create specific view configuration.
				
				Given User enters the Base URL for Creating Specific View Configuration
				When User gives a valid "<Authorization>" with "<Token>" along with userFacilityId and "<isFacilityWide>" triggering the POST API
				Then 200 response gets generated depicting Specific View Configuration Details
				And "responseMessage" attribute is verified by the User
				
	Examples:
|Authorization  | Token | isFacilityWide |
| Authorization | ic_admin_token   | false |

@DUU_PRSAMD-568_failure_Ictechnician
Scenario Outline: PRSAMD_568-Scenario's with Valid Authorization and invalid or blank Request Body parameters to create specific view configuration.

				Given User enters the Base URL for Creating Specific View Configuration
				When User provides a valid "<Authorization>" & "<Token>" and pull Test Data from "<SheetName>" <RowNumber> triggering the POST API
				Then 400 response is generated showing the Specific View Configuration Details
				And "errors" attribute is verified by the User
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
| Sheet1    |         0 | Authorization | ic_admin_token    |
| Sheet1    |         2 | Authorization | ic_admin_token    |

@DUU_PRSAMD-568_Unauthorized_Ictechnician
Scenario Outline: PRSAMD_568- Scenario's with Invalid Authorization and Request Body to create specific view configuration.

				
				Given User enters the Base URL for Creating Specific View Configuration
				When User gives an invalid "<Authorization>" with "<Token>" along with userFacilityId and "<isFacilityWide>" triggering the POST API
				Then 401 response must get generated depicting Specific View Configuration Details
				And "errors" attribute is verified by the User
				
	Examples:
|Authorization | Token | isFacilityWide |
|Authorization| invalid_token | true |
|Authorization| invalid_token | false |


