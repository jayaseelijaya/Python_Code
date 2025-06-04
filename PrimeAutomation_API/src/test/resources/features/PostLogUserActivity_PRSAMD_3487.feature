Feature: PRSAMD_3487 -Verifying Log User Activities via. POST API.

  @DUU_PRSAMD-3487_success
  Scenario Outline: PRSAMD_3487- Scenario's with Valid Authorization and Valid Request Bodies for logging User activities.
    Given User provides a base URL for logging user Activities
    When a valid "<Authorization>" and valid "<Token>" is provided with valid test data extracted from "<SheetName>" <RowNumber>  for logging User activities and POST API is triggered
    Then Response is generated with success status code for log User activities
    And an attribute of "responseMessage" is validated for logging user activities

    Examples: 
      | SheetName | RowNumber | Authorization | Token             |
      | Sheet1    |         0 | Authorization | ic_admin_token    |
      | Sheet1    |         1 | Authorization | hosp_admin_token  |
      | Sheet1    |         2 | Authorization | hil_manager_token |

  @DUU_PRSAMD-3487_failure
  Scenario Outline: PRSAMD_3487- Scenario's with Valid Authorization and Invalid Request Bodies for logging User activities.
    Given User provides a base URL for logging user Activities
    When a Valid "<Authorization>" and Valid "<Token>" is provided with invalid test data extracted from "<SheetName>" <RowNumber> for logging User activities and POST API is triggered
    Then Response is generated with failure status code for log User activities
    And an attribute of "errors" is validated for logging user activities

    Examples: 
      | SheetName | RowNumber | Authorization | Token             |
      | Sheet1    |         3 | Authorization | ic_admin_token    |
      | Sheet1    |         4 | Authorization | hosp_admin_token  |
      | Sheet1    |         5 | Authorization | hil_manager_token |
      | Sheet1    |         6 | Authorization | ic_admin_token    |
      | Sheet1    |         7 | Authorization | hosp_admin_token  |
      | Sheet1    |         8 | Authorization | hil_manager_token |

  @DUU_PRSAMD-3487_unauthorised
  Scenario Outline: PRSAMD_3487- Scenario's with Invalid Authorization and Valid Request Bodies for logging User activities.
    Given User provides a base URL for logging user Activities
    When an invalid "<Authorization>" and invalid "<Token>" is provided with test data extracted from "<SheetName>" <RowNumber> for logging User activities and POST API is triggered
    Then Response is generated with unauthorised status code for log User activities
    And an attribute of "errors" is validated for logging user activities

    Examples: 
      | SheetName | RowNumber | Authorization | Token         |
      | Sheet1    |         9 | Authorization | invalid_token |

  @DUU_PRSAMD-3487_success_HospitalAdmin
  Scenario Outline: PRSAMD_3487- Scenario's with Valid Authorization and Valid Request Bodies for logging User activities.
    Given User provides a base URL for logging user Activities
    When a valid "<Authorization>" and valid "<Token>" is provided with valid test data extracted from "<SheetName>" <RowNumber>  for logging User activities and POST API is triggered
    Then Response is generated with success status code for log User activities
    And an attribute of "responseMessage" is validated for logging user activities

    Examples: 
      | SheetName | RowNumber | Authorization | Token            |
      | Sheet1    |         1 | Authorization | hosp_admin_token |

  @DUU_PRSAMD-3487_failure_HospitalAdmin
  Scenario Outline: PRSAMD_3487- Scenario's with Valid Authorization and Invalid Request Bodies for logging User activities.
    Given User provides a base URL for logging user Activities
    When a Valid "<Authorization>" and Valid "<Token>" is provided with invalid test data extracted from "<SheetName>" <RowNumber> for logging User activities and POST API is triggered
    Then Response is generated with failure status code for log User activities
    And an attribute of "errors" is validated for logging user activities

    Examples: 
      | SheetName | RowNumber | Authorization | Token            |
      | Sheet1    |         4 | Authorization | hosp_admin_token |

  @DUU_PRSAMD-3487_Unauthorized_HospitalAdmin
  Scenario Outline: PRSAMD_3487- Scenario's with Invalid Authorization and Valid Request Bodies for logging User activities.
    Given User provides a base URL for logging user Activities
    When an invalid "<Authorization>" and invalid "<Token>" is provided with test data extracted from "<SheetName>" <RowNumber> for logging User activities and POST API is triggered
    Then Response is generated with unauthorised status code for log User activities
    And an attribute of "errors" is validated for logging user activities

    Examples: 
      | SheetName | RowNumber | Authorization | Token         |
      | Sheet1    |         9 | Authorization | invalid_token |
