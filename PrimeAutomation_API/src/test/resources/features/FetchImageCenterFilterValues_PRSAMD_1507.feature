Feature: PRSAMD_1507 - Verifying fetching filter values for Image center name via. GET API.

@HIL_PRSAMD-1507_success
Scenario Outline: PRSAMD_1507- Scenario's with Valid Authorization and valid Request Parameters

				Given a user enters the valid URL for fetching filter values for Image center name
				When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch filter values for Image center name
				Then Response is generated with success status code for fetching filter values for Image center name
				And the attribute "sourceFacilityId" is validated for fetching filter values for Image center name
	Examples:
|SheetName| RowNumber | Authorization | Token |
| Sheet1  |    0      | Authorization | hil_manager_token |
| Sheet1  |    1      | Authorization | hil_manager_token |
| Sheet1  |    2      | Authorization | hil_manager_token |
| Sheet1  |    3      | Authorization | hil_manager_token |


@HIL_PRSAMD-1507_unauthorised
Scenario Outline: PRSAMD_1507- Scenario's with Invalid Authorization and Valid Request Parameter

				Given a user enters the valid URL for fetching filter values for Image center name
				When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API for fetching filter values for Image center name
				Then Response is generated with unauthorized status code for fetching filter values for Image center name
				And the attribute "errors" is validated for fetching filter values for Image center name
	Examples:
|SheetName| RowNumber | Authorization | Token |
|Sheet1|      4    |Authorization| invalid_token |
|Sheet1|      5    |Authorization| invalid_token |