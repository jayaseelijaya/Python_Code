
Feature: PRSAMD_2976 - Verifying update due date for HIL Case Management via. PUT API.

@HIL_PRSAMD-2976_success
Scenario Outline: PRSAMD_2976- Scenario's with Valid Authorization and valid Request Body

				Given a user enters the valid URL for updating due date for HIL Case Management
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data "<caseId>" and "<dueDateTime>" and trigger PUT API to update due date for HIL Case Management
				Then Response is generated with success status code for updating due date for HIL Case Management
				And the attribute "responseMessage" is validated for updating due date for HIL Case Management
	Examples:
|caseId   | dueDateTime 				| Authorization | Token |
| tIi97J  | 09/05/2028 10:23:35 | Authorization | hil_manager_token |
| 02ipQu  | 11/05/2028 10:23:35 | Authorization | hil_manager_token |
| GNGxNE  | 09/05/2028 10:23:35 | Authorization | hil_manager_token |

@HIL_PRSAMD-2976_failure
Scenario Outline: PRSAMD_2976- Scenario's with Valid Authorization and Invalid or blank Request Body or invalid case status caseIds

				Given a user enters the valid URL for updating due date for HIL Case Management
				When the user gives a valid "<Authorization>" and "<Token>" with invalid or blank Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update due date for HIL Case Management
				Then Response is generated with failure status code for updating due date for HIL Case Management
				And the attribute "errorDetails" is validated for updating due date for HIL Case Management
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_manager_token |
| Sheet1  |    2      | Authorization | hil_manager_token |
| Sheet1  |    3      | Authorization | hil_manager_token |


@HIL_PRSAMD-2976_no_data
Scenario Outline: PRSAMD_2976- Scenario's with Valid Authorization and Invalid caseIds

				Given a user enters the valid URL for updating due date for HIL Case Management
				When the user gives a valid "<Authorization>" and "<Token>" with invalid caseId "<caseId>" and "<dueDateTime>" and trigger PUT API to update due date for HIL Case Management
				Then Response is generated with no data found status code for updating due date for HIL Case Management
				And the attribute "errorDetails" is validated for updating due date for HIL Case Management
	Examples:
|caseId   | dueDateTime 				| Authorization | Token |
| 02ip  | 11/05/2028 10:23:35 | Authorization | hil_manager_token |
| GNGxNEsda  | 09/05/2028 10:23:35 | Authorization | hil_manager_token |
| GNNE  | 09/05/2028 10:23:35 | Authorization | hil_manager_token |


@HIL_PRSAMD-2976_unauthorised
Scenario Outline: PRSAMD_2976- Scenario's with Invalid Authorization and Valid Request Body

				Given a user enters the valid URL for updating due date for HIL Case Management
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data "<caseId>" and "<dueDateTime>" and trigger PUT API to update due date for HIL Case Management
				Then Response is generated with unauthorized status code for updating due date for HIL Case Management
				And the attribute "errors" is validated for updating due date for HIL Case Management
	Examples:
|caseId   | dueDateTime 				| Authorization | Token |
| tIi97J  | 11/05/2028 10:23:35 | Authorization | invalid_token |