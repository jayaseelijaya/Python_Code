Feature: PRSAMD_2434 - Verifying updating Review Time via PUT API.

  @HIL_PRSAMD-2434_success
  Scenario Outline: PRSAMD_2434- Scenario's with Valid Authorization and valid Request Body
    Given a user enters the valid URL for updating Review Time for HIL User
    When the user gives a valid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update Review Time for HIL User
    Then Response is generated with success status code for updating Review Time for HIL User
    And the attribute "responseMessage" is validated for updating Review Time for HIL User

    Examples: 
      | SheetName | RowNumber | Authorization | Token              |
      | Sheet1    |         0 | Authorization | hil_manager_token  |
      | Sheet1    |         1 | Authorization | hil_reviewer_token |

  @HIL_PRSAMD-2434_failure
  Scenario Outline: PRSAMD_2434- Scenario's with Valid Authorization and Blank Request Body
    Given a user enters the valid URL for updating Review Time for HIL User
    When the user gives a valid "<Authorization>" and "<Token>" with blank Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update Review Time for HIL User
    Then Response is generated with failure status code for updating Review Time for HIL User
    And the attribute "errors" is validated for updating Review Time for HIL User

    Examples: 
      | SheetName | RowNumber | Authorization | Token              |
      | Sheet1    |         2 | Authorization | hil_manager_token  |
      | Sheet1    |         3 | Authorization | hil_reviewer_token |
      | Sheet1    |         4 | Authorization | hil_manager_token  |

  @HIL_PRSAMD-2434_no_data
  Scenario Outline: PRSAMD_2434- Scenario's with Valid Authorization and Invalid caseId
    Given a user enters the valid URL for updating Review Time for HIL User
    When the user gives a valid "<Authorization>" and "<Token>" with invalid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API to update Review Time for HIL User
    Then Response is generated with no data found status code for updating Review Time for HIL User
    And the attribute "errors" is validated for updating Review Time for HIL User

    Examples: 
      | SheetName | RowNumber | Authorization | Token              |
      | Sheet1    |         5 | Authorization | hil_manager_token  |
      | Sheet1    |         6 | Authorization | hil_reviewer_token |

  @HIL_PRSAMD-2434_unauthorised
  Scenario Outline: PRSAMD_2434- Scenario's with Invalid Authorization and Valid Request Body
    Given a user enters the valid URL for updating Review Time for HIL User
    When the user gives an invalid "<Authorization>" and "<Token>" with valid Test Data from "<SheetName>" and <RowNumber> and trigger PUT API for updating Review Time for HIL User
    Then Response is generated with unauthorized status code for updating Review Time for HIL User
    And the attribute "errors" is validated for updating Review Time for HIL User

    Examples: 
      | SheetName | RowNumber | Authorization | Token         |
      | Sheet1    |         7 | Authorization | invalid_token |
      | Sheet1    |         8 | Authorization | invalid_token |
