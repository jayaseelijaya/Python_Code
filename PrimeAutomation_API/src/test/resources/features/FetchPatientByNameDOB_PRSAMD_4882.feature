
Feature: PRSAMD_4882 - Verifying fetching patient procedure search by name and DOB - surgeon portal via. GET API.


@MIC_PRSAMD-4882_success
Scenario Outline: PRSAMD_4882- Scenario's with Valid Authorization and Valid Request Parameters

				Given a user enters the valid URL for fetching patient procedure search by name and DOB - surgeon portal
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch patient procedure search by name and DOB - surgeon portal
				Then Response is generated with success status code for fetching patient procedure search by name and DOB - surgeon portal
				And the attribute "patientname" is validated for fetching patient procedure search by name and DOB - surgeon portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | surgeon_token |
| Sheet1  |    1      | Authorization | staff_token |

@MIC_PRSAMD-4882_success_blank_parameters
Scenario Outline: PRSAMD_4882- Scenario's with Valid Authorization and optional blank Request Parameters

				Given a user enters the valid URL for fetching patient procedure search by name and DOB - surgeon portal
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch patient procedure search by name and DOB - surgeon portal
				Then Response is generated with success status code for fetching patient procedure search by name and DOB - surgeon portal
				And the attribute "patientname" is validated for fetching patient procedure search by name and DOB - surgeon portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    2      | Authorization | surgeon_token |
| Sheet1  |    3      | Authorization | staff_token |

@MIC_PRSAMD-4882_failure
Scenario Outline: PRSAMD_4882- Scenario's with Valid Authorization and invalid mandatory Request Parameters

				Given a user enters the valid URL for fetching patient procedure search by name and DOB - surgeon portal
				When the user gives a valid "<Authorization>" and "<Token>" with invalid mandatory Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch patient procedure search by name and DOB - surgeon portal
				Then Response is generated with failure status code for fetching patient procedure search by name and DOB - surgeon portal
				And the attribute "errorMessage" is validated for fetching patient procedure search by name and DOB - surgeon portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    4      | Authorization | surgeon_token |
| Sheet1  |    5      | Authorization | staff_token |

@MIC_PRSAMD-4882_unauthorised
Scenario Outline: PRSAMD_4882- Scenario's with Invalid Authorization and valid Request Parameters

				Given a user enters the valid URL for fetching patient procedure search by name and DOB - surgeon portal
				When the user gives a invalid "<Authorization>" and "<Token>" with valid mandatory Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch patient procedure search by name and DOB - surgeon portal
				Then Response is generated with unauthorised status code for fetching patient procedure search by name and DOB - surgeon portal
				And the attribute "errorMessage" is validated for fetching patient procedure search by name and DOB - surgeon portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    6      | Authorization | invalid_token |
