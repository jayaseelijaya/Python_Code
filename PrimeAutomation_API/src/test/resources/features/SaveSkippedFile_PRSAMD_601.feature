Feature: PRSAMD-601 - Verify  saving all skipped file information per batch via POST API

  @DUU_PRSAMD-648_success
  Scenario Outline: PRSAMD-601 - Postitive Scenario's with Valid Authorization Token for saving of Skipped File
    Given base url is entered to save skipped file information
    When user enters valid "<Authorization>" "<Value>" and extract testdata from "<SheetName>" <RowNumber> then trigger POST method
    Then Response Body gets generated with status code as 200
    And "responseMessage" attribute in Response Message is verified

    Examples: 
      | SheetName | RowNumber | Authorization | Value               |
      | Sheet1    |         0 | Authorization | ic_admin_token      |
      | Sheet1    |         1 | Authorization | ic_technician_token |
      | Sheet1    |         2 | Authorization | hosp_admin_token    |
      | Sheet1    |         3 | Authorization | surgeon_token       |
      | Sheet1    |         4 | Authorization | staff_token         |

  @DUU_PRSAMD-648_failure
  Scenario Outline: PRSAMD_601 -Negative Scenario's with Valid Authorization Token for saving of Skipped File
    Given base url is entered to save skipped file information
    When user enters valid "<Authorization>" "<Value>" and extract blank testdata from "<SheetName>" <RowNumber> then trigger POST method
    Then Response Body got generated with status code as 400
    And "errors" attribute in Response Message is verified

    Examples: 
      | SheetName | RowNumber | Authorization | Value               |
      | Sheet1    |         5 | Authorization | ic_admin_token      |
      | Sheet1    |         6 | Authorization | ic_technician_token |
      | Sheet1    |         7 | Authorization | hosp_admin_token    |
      | Sheet1    |         8 | Authorization | surgeon_token       |
      | Sheet1    |         9 | Authorization | staff_token         |
      | Sheet1    |        10 | Authorization | ic_admin_token      |
      | Sheet1    |        11 | Authorization | ic_technician_token |
      | Sheet1    |        12 | Authorization | hosp_admin_token    |
      | Sheet1    |        13 | Authorization | surgeon_token       |
      | Sheet1    |        14 | Authorization | staff_token         |
      | Sheet1    |        15 | Authorization | ic_admin_token      |
      | Sheet1    |        16 | Authorization | ic_technician_token |
      | Sheet1    |        17 | Authorization | hosp_admin_token    |
      | Sheet1    |        18 | Authorization | surgeon_token       |
      | Sheet1    |        19 | Authorization | staff_token         |
      | Sheet1    |        20 | Authorization | ic_admin_token      |
      | Sheet1    |        21 | Authorization | ic_technician_token |
      | Sheet1    |        22 | Authorization | hosp_admin_token    |
      | Sheet1    |        23 | Authorization | surgeon_token       |
      | Sheet1    |        24 | Authorization | staff_token         |

  @DUU_PRSAMD-648_no_data
  Scenario Outline: PRSAMD_601 - Negative Scenario's with Valid Authorization Token and invalid data for saving of Skipped File
    Given base url is entered to save skipped file information
    When user enters valid "<Authorization>" "<Value>" and extract invalid testdata from "<SheetName>" <RowNumber> then trigger POST method
    Then Response Body get generated with status code as 404
    And "errors" attribute in Response Message is verified

    Examples: 
      | SheetName | RowNumber | Authorization | Value               |
      | Sheet1    |        25 | Authorization | ic_admin_token      |
      | Sheet1    |        26 | Authorization | ic_technician_token |
      | Sheet1    |        27 | Authorization | hosp_admin_token    |
      | Sheet1    |        28 | Authorization | surgeon_token       |
      | Sheet1    |        29 | Authorization | staff_token         |

  @DUU_PRSAMD-648_unauthorised
  Scenario Outline: PRSAMD_601 - Exception Scenario's with Invalid Authorization Token for saving of Skipped File
    Given base url is entered to save skipped file information
    When user enters invalid "<Authorization>" "<Value>" and extract testdata from "<SheetName>" <RowNumber> then trigger POST method
    Then Response Body  generated with status code as 401
    And "errors" attribute in Response Message is verified

    Examples: 
      | SheetName | RowNumber | Authorization | Value         |
      | Sheet1    |        30 | Authorization | invalid_token |

  @DUU_PRSAMD-601_success_IcAdmin
  Scenario Outline: PRSAMD-601 - Postitive Scenario's with Valid Authorization Token for saving of Skipped File
    Given base url is entered to save skipped file information
    When user enters valid "<Authorization>" "<Value>" and extract testdata from "<SheetName>" <RowNumber> then trigger POST method
    Then Response Body gets generated with status code as 200
    And "responseMessage" attribute in Response Message is verified

    Examples: 
      | SheetName | RowNumber | Authorization | Value          |
      | Sheet1    |         0 | Authorization | ic_admin_token |

  @DUU_PRSAMD-601_failure_IcAdmin
  Scenario Outline: PRSAMD_601 -Negative Scenario's with Valid Authorization Token for saving of Skipped File
    Given base url is entered to save skipped file information
    When user enters valid "<Authorization>" "<Value>" and extract blank testdata from "<SheetName>" <RowNumber> then trigger POST method
    Then Response Body got generated with status code as 400
    And "errors" attribute in Response Message is verified

    Examples: 
      | SheetName | RowNumber | Authorization | Value          |
      | Sheet1    |         5 | Authorization | ic_admin_token |
      | Sheet1    |        10 | Authorization | ic_admin_token |
      | Sheet1    |        15 | Authorization | ic_admin_token |
      | Sheet1    |        20 | Authorization | ic_admin_token |

  @DUU_PRSAMD-601_Unauthorised_IcAdmin
  Scenario Outline: PRSAMD_601 - Exception Scenario's with Invalid Authorization Token for saving of Skipped File
    Given base url is entered to save skipped file information
    When user enters invalid "<Authorization>" "<Value>" and extract testdata from "<SheetName>" <RowNumber> then trigger POST method
    Then Response Body  generated with status code as 401
    And "errors" attribute in Response Message is verified

    Examples: 
      | SheetName | RowNumber | Authorization | Value         |
      | Sheet1    |        30 | Authorization | invalid_token |
