Feature: PRSAMD_3656 -Verifying Log User Activities PRSAMD-3656 via. POST API.

  @DUU_PRSAMD-3656_success
  Scenario Outline: PRSAMD_3656- Scenario's with Valid Authorization and Valid Request Bodies for logging User activities.
    Given User provides a base URL for logging user Activities PRSAMD 3656
    When a valid "<Authorization>" and valid "<Token>" is provided with valid test data extracted from "<SheetName>" <RowNumber>  for logging User activities and POST API is triggered PRSAMD 3656
    Then Response is generated with success status code for log User activities PRSAMD 3656
    And an attribute of "responseMessage" is validated for logging user activities PRSAMD 3656

    Examples: 
      | SheetName | RowNumber | Authorization | Token               |
      | Sheet1    |         0 | Authorization | ic_admin_token      |
      | Sheet1    |         1 | Authorization | ic_technician_token |
      | Sheet1    |         2 | Authorization | hosp_admin_token    |
      | Sheet1    |         3 | Authorization | surgeon_token       |
      | Sheet1    |         4 | Authorization | staff_token         |
      | Sheet1    |         5 | Authorization | hil_manager_token   |
      | Sheet1    |         6 | Authorization | hil_reviewer_token  |
      | Sheet1    |         7 | Authorization | cloud_support_token |

  @DUU_PRSAMD-3656_failure
  Scenario Outline: PRSAMD_3656- Scenario's with Valid Authorization and Invalid Request Bodies for logging User activities.
    Given User provides a base URL for logging user Activities PRSAMD 3656
    When a Valid "<Authorization>" and Valid "<Token>" is provided with invalid test data extracted from "<SheetName>" <RowNumber> for logging User activities and POST API is triggered PRSAMD 3656
    Then Response is generated with failure status code for log User activities PRSAMD 3656
    And an attribute of "errors" is validated for logging user activities PRSAMD 3656

    Examples: 
      | SheetName | RowNumber | Authorization | Token               |
      | Sheet1    |         8 | Authorization | ic_admin_token      |
      | Sheet1    |         9 | Authorization | ic_technician_token |
      | Sheet1    |        10 | Authorization | hosp_admin_token    |
      | Sheet1    |        11 | Authorization | surgeon_token       |
      | Sheet1    |        12 | Authorization | staff_token         |
      | Sheet1    |        13 | Authorization | hil_manager_token   |
      | Sheet1    |        14 | Authorization | hil_reviewer_token  |
      | Sheet1    |        15 | Authorization | cloud_support_token |

  @DUU_PRSAMD-3656_unauthorised
  Scenario Outline: PRSAMD_3656- Scenario's with Invalid Authorization and Valid Request Bodies for logging User activities.
    Given User provides a base URL for logging user Activities PRSAMD 3656
    When an invalid "<Authorization>" and invalid "<Token>" is provided with test data extracted from "<SheetName>" <RowNumber> for logging User activities and POST API is triggered PRSAMD 3656
    Then Response is generated with unauthorised status code for log User activities PRSAMD 3656
    And an attribute of "errors" is validated for logging user activities PRSAMD 3656

    Examples: 
      | SheetName | RowNumber | Authorization | Token         |
      | Sheet1    |        16 | Authorization | invalid_token |

  @DUU_PRSAMD-3656_success_Surgeon
  Scenario Outline: PRSAMD_3656- Scenario's with Valid Authorization and Valid Request Bodies for logging User activities.
    Given User provides a base URL for logging user Activities PRSAMD 3656
    When a valid "<Authorization>" and valid "<Token>" is provided with valid test data extracted from "<SheetName>" <RowNumber>  for logging User activities and POST API is triggered PRSAMD 3656
    Then Response is generated with success status code for log User activities PRSAMD 3656
    And an attribute of "responseMessage" is validated for logging user activities PRSAMD 3656

    Examples: 
      | SheetName | RowNumber | Authorization | Token         |
      | Sheet1    |         3 | Authorization | surgeon_token |

  @DUU_PRSAMD-3656_failure_Surgeon
  Scenario Outline: PRSAMD_3656- Scenario's with Valid Authorization and Invalid Request Bodies for logging User activities.
    Given User provides a base URL for logging user Activities PRSAMD 3656
    When a Valid "<Authorization>" and Valid "<Token>" is provided with invalid test data extracted from "<SheetName>" <RowNumber> for logging User activities and POST API is triggered PRSAMD 3656
    Then Response is generated with failure status code for log User activities PRSAMD 3656
    And an attribute of "errors" is validated for logging user activities PRSAMD 3656

    Examples: 
      | SheetName | RowNumber | Authorization | Token         |
      | Sheet1    |        11 | Authorization | surgeon_token |

  @DUU_PRSAMD-3656_Unauthorized_Surgeon
  Scenario Outline: PRSAMD_3656- Scenario's with Invalid Authorization and Valid Request Bodies for logging User activities.
    Given User provides a base URL for logging user Activities PRSAMD 3656
    When an invalid "<Authorization>" and invalid "<Token>" is provided with test data extracted from "<SheetName>" <RowNumber> for logging User activities and POST API is triggered PRSAMD 3656
    Then Response is generated with unauthorised status code for log User activities PRSAMD 3656
    And an attribute of "errors" is validated for logging user activities PRSAMD 3656

    Examples: 
      | SheetName | RowNumber | Authorization | Token         |
      | Sheet1    |        16 | Authorization | invalid_token |
