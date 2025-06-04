Feature: PRSAMD_3133 - Verifying fetching procedure details for Surgeon Portal through GET API.

  @MIC_PRSAMD-3133_success
  Scenario Outline: PRSAMD_3133- Scenario's with Valid Authorization and valid Request Parameters
    Given a user enters the valid URL for fetching procedure details for Surgeon Portal
    When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch procedure details for Surgeon Portal
    Then Response is generated with success status code for fetching procedure details for Surgeon Portal
    And the attribute "caseId" is validated for fetching procedure details for Surgeon Portal

    Examples: 
      | SheetName | RowNumber | Authorization | Token         |
      | Sheet1    |         0 | Authorization | surgeon_token |
      | Sheet1    |         1 | Authorization | staff_token   |
      | Sheet1    |         2 | Authorization | surgeon_token |
      | Sheet1    |         3 | Authorization | staff_token   |

  @MIC_PRSAMD-3133_unauthorised
  Scenario Outline: PRSAMD_3133- Scenario's with Invalid Authorization and InValid Request Parameter
    Given a user enters the valid URL for fetching procedure details for Surgeon Portal
    When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger GET API to fetch procedure details for Surgeon Portal
    Then Response is generated with unauthorized status code for fetching procedure details for Surgeon Portal
    And the attribute "errorMessage" is validated for fetching procedure details for Surgeon Portal

    Examples: 
      | SheetName | RowNumber | Authorization | Token         |
      | Sheet1    |         4 | Authorization | invalid_token |
      | Sheet1    |         5 | Authorization | invalid_token |
