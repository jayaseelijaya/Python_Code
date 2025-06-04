
Feature: PRSAMD_436 - Verifying updating user/facility specific view configuration via. PUT API.


@DUU_PRSAMD-436_success
Scenario Outline: PRSAMD_436- Scenario's with Valid Authorization and valid Request Body

				Given a user enters the valid URL for updating specific view Configuration
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update view Configuration
				Then a response of 200 is generated for updating Specific view configuration
				And the attribute "responseMessage" is validated for updating specific view
				
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | ic_admin_token |
| Sheet1  |    1      | Authorization | hosp_admin_token |

@DUU_PRSAMD-436_failure
Scenario Outline: PRSAMD_436- Scenario's with Valid Authorization and invalid user Facility ID

				Given a user enters the valid URL for updating specific view Configuration
				When the user gives a valid "<Authorization>" and "<Token>" with invalid Test Data for userFacilityId from "<SheetName>" and <RowNumber> and trigger PUT API to update view Configuration
				Then a response of 400 is being generated for updating Specific view configuration
				And the attribute "errors" is validated for updating specific view
				
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    2      | Authorization | ic_admin_token |
| Sheet1  |    3      | Authorization | hosp_admin_token |


@DUU_PRSAMD-436_failure
Scenario Outline: PRSAMD_436- Scenario's with Valid Authorization and invalid is Facility Wide

				Given a user enters the valid URL for updating specific view Configuration
				When the user gives a valid "<Authorization>" and "<Token>" with invalid Test Data for isFacilityWide from "<SheetName>" and <RowNumber> and trigger PUT API to update view Configuration
				Then a response of 400 is being generated for updating Specific view configuration
				And the attribute "errors" is validated for updating specific view
				
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    4      | Authorization | ic_admin_token |
| Sheet1  |    5      | Authorization | hosp_admin_token |


@DUU_PRSAMD-436_failure
Scenario Outline: PRSAMD_436- Scenario's with Valid Authorization and invalid Success Days

				Given a user enters the valid URL for updating specific view Configuration
				When the user gives a valid "<Authorization>" and "<Token>" with invalid Test Data for successDays from "<SheetName>" and <RowNumber> and trigger PUT API to update view Configuration
				Then a response of 400 is being generated for updating Specific view configuration
				And the attribute "errors" is validated for updating specific view
				
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    6      | Authorization | ic_admin_token |
| Sheet1  |    7      | Authorization | hosp_admin_token |


@DUU_PRSAMD-436_failure
Scenario Outline: PRSAMD_436- Scenario's with Valid Authorization and invalid Error Days

				Given a user enters the valid URL for updating specific view Configuration
				When the user gives a valid "<Authorization>" and "<Token>" with invalid Test Data for errorDays from "<SheetName>" and <RowNumber> and trigger PUT API to update view Configuration
				Then a response of 400 is being generated for updating Specific view configuration
				And the attribute "errors" is validated for updating specific view
				
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    8      | Authorization | ic_admin_token |
| Sheet1  |    9      | Authorization | hosp_admin_token |

@DUU_PRSAMD-436_unauthorised
Scenario Outline: PRSAMD_436- Scenario's with Invalid Authorization and valid Request Body

				Given a user enters the valid URL for updating specific view Configuration
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update view Configuration
				Then a response of 401 is getting generated for updating Specific view configuration
				And the attribute "errors" is validated for updating specific view
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
|Sheet1   |   10      |Authorization | invalid_token |

@DUU_PRSAMD-436_success_HospitalAdmin
Scenario Outline: PRSAMD_436- Scenario's with Valid Authorization and valid Request Body

				Given a user enters the valid URL for updating specific view Configuration
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update view Configuration
				Then a response of 200 is generated for updating Specific view configuration
				And the attribute "responseMessage" is validated for updating specific view
				
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    1      | Authorization | hosp_admin_token |

@DUU_PRSAMD-436_failure_IcAdmin
Scenario Outline: PRSAMD_436- Scenario's with Valid Authorization and invalid user Facility ID

				Given a user enters the valid URL for updating specific view Configuration
				When the user gives a valid "<Authorization>" and "<Token>" with invalid Test Data for userFacilityId from "<SheetName>" and <RowNumber> and trigger PUT API to update view Configuration
				Then a response of 400 is being generated for updating Specific view configuration
				And the attribute "errors" is validated for updating specific view
				
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    2      | Authorization | ic_admin_token |

@DUU_PRSAMD-436_Unauthorised_Staff
Scenario Outline: PRSAMD_436- Scenario's with Invalid Authorization and valid Request Body

				Given a user enters the valid URL for updating specific view Configuration
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update view Configuration
				Then a response of 401 is getting generated for updating Specific view configuration
				And the attribute "errors" is validated for updating specific view
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
|Sheet1   |   10      |Authorization | invalid_token |