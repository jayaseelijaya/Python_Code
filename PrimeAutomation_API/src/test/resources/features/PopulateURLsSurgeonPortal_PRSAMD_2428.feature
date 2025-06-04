
Feature: PRSAMD_2428 - Verifying populating URLs against patient case files for Surgeon Portal via. GET API.


@MIC_PRSAMD-2428_success
Scenario Outline: PRSAMD_2428- Scenario's with Valid Authorization and Valid Request Parameters

				Given a user enters the valid URL for populating URLs against patient case files for Surgeon Portal
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to populate URLs against patient case files for Surgeon Portal
				Then Response is generated with success status code for populating URLs against patient case files for Surgeon Portal
				And the attribute "Base_Dicom_File" is validated for populating URLs against patient case files for Surgeon Portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | surgeon_token |
| Sheet1  |    1      | Authorization | staff_token |
| Sheet1  |    2      | Authorization | surgeon_token |
| Sheet1  |    3      | Authorization | staff_token |
| Sheet1  |    4      | Authorization | surgeon_token |
| Sheet1  |    5      | Authorization | staff_token |

@MIC_PRSAMD-2428_no_data
Scenario Outline: PRSAMD_2428- Scenario's with Valid Authorization and invalid Request Parameters

				Given a user enters the valid URL for populating URLs against patient case files for Surgeon Portal
				When the user gives a valid "<Authorization>" and "<Token>" with an invalid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to populate URLs against patient case files for Surgeon Portal
				Then Response is generated with no data status code for populating URLs against patient case files for Surgeon Portal
				And the attribute "Base_Dicom_File" is validated for populating URLs against patient case files for Surgeon Portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    6      | Authorization | surgeon_token |
| Sheet1  |    7      | Authorization | staff_token |



@MIC_PRSAMD-2428_unauthorised
Scenario Outline: PRSAMD_2428- Scenario's with Invalid Authorization and valid Request Parameters

				Given a user enters the valid URL for populating URLs against patient case files for Surgeon Portal
				When the user gives a invalid "<Authorization>" and "<Token>" with valid mandatory Test Data from "<SheetName>" and <RowNumber> and trigger GET API to populate URLs against patient case files for Surgeon Portal
				Then Response is generated with unauthorised status code for populating URLs against patient case files for Surgeon Portal
				And the attribute "errorMessage" is validated for populating URLs against patient case files for Surgeon Portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    8      | Authorization | invalid_token |
| Sheet1  |    9      | Authorization | invalid_token |
