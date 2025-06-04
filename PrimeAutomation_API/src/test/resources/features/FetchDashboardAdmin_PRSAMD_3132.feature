
Feature: PRSAMD_3132 - Verifying fetching dashboard for admin - Surgeon Portal in MIC via. GET API.


@MIC_PRSAMD-3132_success
Scenario Outline: PRSAMD_3132- Scenario's with Valid Authorization and Valid Request Parameters

				Given a user enters the valid URL for fetching dashboard for admin - Surgeon Portal in MIC
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch dashboard for admin - Surgeon Portal in MIC
				Then Response is generated with success status code for fetching dashboard for admin - Surgeon Portal in MIC
				And the attribute "adminDashboardDetails" is validated for fetching dashboard for admin - Surgeon Portal in MIC
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | cloud_support_token |
| Sheet1  |    1      | Authorization | cloud_support_token |
| Sheet1  |    2      | Authorization | cloud_support_token |
| Sheet1  |    3      | Authorization | cloud_support_token |
| Sheet1  |    4      | Authorization | cloud_support_token |
| Sheet1  |    5      | Authorization | cloud_support_token |
| Sheet1  |    6      | Authorization | cloud_support_token |
| Sheet1  |    7      | Authorization | cloud_support_token |
| Sheet1  |    8      | Authorization | cloud_support_token |

@MIC_PRSAMD-3132_success_blank_parameters
Scenario Outline: PRSAMD_3132- Scenario's with Valid Authorization and blank Request Parameters

				Given a user enters the valid URL for fetching dashboard for admin - Surgeon Portal in MIC
				When the user gives a valid "<Authorization>" and "<Token>" with blank Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch dashboard for admin - Surgeon Portal in MIC
				Then Response is generated with success status code for fetching dashboard for admin - Surgeon Portal in MIC
				And the attribute "adminDashboardDetails" is validated for fetching dashboard for admin - Surgeon Portal in MIC
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    9      | Authorization | cloud_support_token |

@MIC_PRSAMD-3462_success_invalid_parameters
Scenario Outline: PRSAMD_3132- Scenario's with Valid Authorization and invalid  Request Parameters

				Given a user enters the valid URL for fetching dashboard for admin - Surgeon Portal in MIC
				When the user gives a valid "<Authorization>" and "<Token>" with invalid  Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch dashboard for admin - Surgeon Portal in MIC
				Then Response is generated with success status code for fetching dashboard for admin - Surgeon Portal in MIC
				And the attribute "adminDashboardDetails" is validated for fetching dashboard for admin - Surgeon Portal in MIC
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    10      | Authorization | cloud_support_token |
| Sheet1  |    11      | Authorization | cloud_support_token |

@MIC_PRSAMD-3132_unauthorised
Scenario Outline: PRSAMD_3132 - Scenario's with invalid Authorization tokens and valid parameters
  
    		Given a user enters the valid URL for fetching dashboard for admin - Surgeon Portal in MIC
				When the user gives an invalid "<Authorization>" and "<Token>" with valid  Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch dashboard for admin - Surgeon Portal in MIC
				Then Response is generated with unauthorised status code for fetching dashboard for admin - Surgeon Portal in MIC
				And the attribute "errorMessage" is validated for fetching dashboard for admin - Surgeon Portal in MIC
	
Examples:	
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    12     | Authorization | invalid_token |
