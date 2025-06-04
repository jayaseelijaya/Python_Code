
Feature: PRSAMD_5205 - Verifying updating patient information in MIC surgeon portal via. PUT API.


@MIC_PRSAMD-5205_success
Scenario Outline: PRSAMD_5205- Scenario's with Valid Authorization and Valid Request Body

				Given a user enters the valid URL for updating patient information in MIC surgeon portal
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update patient information in MIC surgeon portal
				Then Response is generated with success status code for updating patient information in MIC surgeon portal
				And the attribute "responseMessage" is validated for updating patient information in MIC surgeon portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | surgeon_token |
| Sheet1  |    1      | Authorization | staff_token |
| Sheet1  |    2      | Authorization | surgeon_token |
| Sheet1  |    3      | Authorization | staff_token |

@MIC_PRSAMD-5205_failure_blank_patientId
Scenario Outline: PRSAMD_5205- Scenario's with Valid Authorization and blank patientID

				Given a user enters the valid URL for updating patient information in MIC surgeon portal
				When the user gives a valid "<Authorization>" and "<Token>" with a blank patientId Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update patient information in MIC surgeon portal
				Then Response is generated with faliure status code for updating patient information in MIC surgeon portal
				And the attribute "errorMessage" is validated for updating patient information in MIC surgeon portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    4      | Authorization | surgeon_token |
| Sheet1  |    5      | Authorization | staff_token |

@MIC_PRSAMD-5205_failure_invalid_patientId
Scenario Outline: PRSAMD_5205- Scenario's with Valid Authorization and invalid patientID

				Given a user enters the valid URL for updating patient information in MIC surgeon portal
				When the user gives a valid "<Authorization>" and "<Token>" with an invalid patientId Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update patient information in MIC surgeon portal
				Then Response is generated with faliure status code for updating patient information in MIC surgeon portal
				And the attribute "errorMessage" is validated for updating patient information in MIC surgeon portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    6      | Authorization | surgeon_token |
| Sheet1  |    7      | Authorization | staff_token |

@MIC_PRSAMD-5205_failure_no_details_patient
Scenario Outline: PRSAMD_5205- Scenario's with Valid Authorization and no details of patient

				Given a user enters the valid URL for updating patient information in MIC surgeon portal
				When the user gives a valid "<Authorization>" and "<Token>" with no details of patient Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update patient information in MIC surgeon portal
				Then Response is generated with faliure status code for updating patient information in MIC surgeon portal
				And the attribute "errorMessage" is validated for updating patient information in MIC surgeon portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    8      | Authorization | surgeon_token |
| Sheet1  |    9      | Authorization | staff_token |



@MIC_PRSAMD-5205_unauthorised
Scenario Outline: PRSAMD_5205- Scenario's with Invalid Authorization and valid Request Body

				Given a user enters the valid URL for updating patient information in MIC surgeon portal
				When the user gives a invalid "<Authorization>" and "<Token>" with valid mandatory Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update patient information in MIC surgeon portal
				Then Response is generated with unauthorised status code for updating patient information in MIC surgeon portal
				And the attribute "errorMessage" is validated for updating patient information in MIC surgeon portal
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    10      | Authorization | invalid_token |
| Sheet1  |    11      | Authorization | invalid_token |
