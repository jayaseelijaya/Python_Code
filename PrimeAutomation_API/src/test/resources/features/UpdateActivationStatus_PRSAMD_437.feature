Feature: PRSAMD_437- Verifying updating activation status of facility via. PUT API.


@DUU_PRSAMD-437_success
Scenario Outline: PRSAMD_437 - Scenario's with Valid Authorization and Valid Request Body to update activation status of facility.

				Given the User enters the Base URL to update activation status of facility
				When user provides a valid "<Authorization>" with "<Token>" with the Request Body from "<SheetName>" and <RowNumber> and trigger the PUT API to update activation status of facility
				Then a response code of 200 is generated fetching the update activation status of facility
				And attribute named "responseMessage" is verified in response body to update activation status of facility.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
|Sheet1     |0|				Authorization| hil_manager_token |
|Sheet1     |1|				Authorization| hil_manager_token |
|Sheet1     |2|				Authorization| hil_manager_token |
|Sheet1     |3|				Authorization| hil_manager_token |
|Sheet1     |4|				Authorization| hil_manager_token |

@DUU_PRSAMD-437_failure
 Scenario Outline: PRSAMD_437 - Scenario's with Valid Authorization and Invalid or Blank Request Bodies to update activation status of facility.

				Given the User enters the Base URL to update activation status of facility
				When User provides a valid "<Authorization>" with "<Token>" with Invalid or Blank Request Bodies from "<SheetName>" and <RowNumber> and trigger the PUT API to update activation status of facility
				Then a response code of 400 is being generated showing error in updating activation status of facility
				And attribute named "errors" is verified in response body to update activation status of facility.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
|Sheet1     |5|				Authorization| hil_manager_token |
|Sheet1     |6|				Authorization| hil_manager_token |
|Sheet1     |7|				Authorization| hil_manager_token |

 
 @DUU_PRSAMD-437_unauthorised
 Scenario Outline: PRSAMD_437 - Scenario's with Invalid Authorization and Valid Request Bodies to update activation status of facility.

				Given the User enters the Base URL to update activation status of facility
				When User provides an invalid "<Authorization>" with "<Token>" with Valid Request Bodies from "<SheetName>" and <RowNumber> and trigger the PUT API to update activation status of facility
				Then a response code of 401 is getting generated showing Unauthorised error in updating activation status of facility
				And attribute named "errors" is verified in response body to update activation status of facility.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |8|				Authorization| invalid_token |
 
 
@DUU_PRSAMD-437_success_SNHilManager
Scenario Outline: PRSAMD_437 - Scenario's with Valid Authorization and Valid Request Body to update activation status of facility.

				Given the User enters the Base URL to update activation status of facility
				When user provides a valid "<Authorization>" with "<Token>" with the Request Body from "<SheetName>" and <RowNumber> and trigger the PUT API to update activation status of facility
				Then a response code of 200 is generated fetching the update activation status of facility
				And attribute named "responseMessage" is verified in response body to update activation status of facility.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
|Sheet1     |0|				Authorization| hil_manager_token |

@DUU_PRSAMD-437_failure_SNHilManager
 Scenario Outline: PRSAMD_437 - Scenario's with Valid Authorization and Invalid or Blank Request Bodies to update activation status of facility.

				Given the User enters the Base URL to update activation status of facility
				When User provides a valid "<Authorization>" with "<Token>" with Invalid or Blank Request Bodies from "<SheetName>" and <RowNumber> and trigger the PUT API to update activation status of facility
				Then a response code of 400 is being generated showing error in updating activation status of facility
				And attribute named "errors" is verified in response body to update activation status of facility.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
|Sheet1     |5|				Authorization| hil_manager_token |

@DUU_PRSAMD-437_Unauthorised_SNHilManager
 Scenario Outline: PRSAMD_437 - Scenario's with Invalid Authorization and Valid Request Bodies to update activation status of facility.

				Given the User enters the Base URL to update activation status of facility
				When User provides an invalid "<Authorization>" with "<Token>" with Valid Request Bodies from "<SheetName>" and <RowNumber> and trigger the PUT API to update activation status of facility
				Then a response code of 401 is getting generated showing Unauthorised error in updating activation status of facility
				And attribute named "errors" is verified in response body to update activation status of facility.
				
	Examples:
|SheetName| RowNumber |Authorization | Token |
 |Sheet1     |8|				Authorization| invalid_token |
