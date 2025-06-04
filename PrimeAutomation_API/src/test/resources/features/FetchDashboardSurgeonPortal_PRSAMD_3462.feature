
Feature: PRSAMD_3462 - Verifying fetching dashboard - Surgeon Portal in MIC via. GET API.


@MIC_PRSAMD-3462_success
Scenario Outline: PRSAMD_3462- Scenario's with Valid Authorization and Valid Request Parameters

				Given a user enters the valid URL for fetching dashboard - Surgeon Portal in MIC
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch dashboard - Surgeon Portal in MIC
				Then Response is generated with success status code for fetching dashboard - Surgeon Portal in MIC
				And the attribute "patientname" is validated for fetching dashboard - Surgeon Portal in MIC
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | surgeon_token |
| Sheet1  |    1      | Authorization | staff_token |
| Sheet1  |    2      | Authorization | surgeon_token |
| Sheet1  |    3      | Authorization | staff_token |

@MIC_PRSAMD-3462_success_blank_parameters
Scenario Outline: PRSAMD_3462- Scenario's with Valid Authorization and blank Request Parameters

				Given a user enters the valid URL for fetching dashboard - Surgeon Portal in MIC
				When the user gives a valid "<Authorization>" and "<Token>" with blank Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch dashboard - Surgeon Portal in MIC
				Then Response is generated with success status code for fetching dashboard - Surgeon Portal in MIC
				And the attribute "patientname" is validated for fetching dashboard - Surgeon Portal in MIC
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    4      | Authorization | surgeon_token |
| Sheet1  |    5      | Authorization | staff_token |

@MIC_PRSAMD-3462_success_invalid_parameters
Scenario Outline: PRSAMD_3462- Scenario's with Valid Authorization and invalid  Request Parameters

				Given a user enters the valid URL for fetching dashboard - Surgeon Portal in MIC
				When the user gives a valid "<Authorization>" and "<Token>" with invalid  Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch dashboard - Surgeon Portal in MIC
				Then Response is generated with success status code for fetching dashboard - Surgeon Portal in MIC
				And the attribute "patientname" is validated for fetching dashboard - Surgeon Portal in MIC
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    6      | Authorization | surgeon_token |
| Sheet1  |    7      | Authorization | staff_token |

