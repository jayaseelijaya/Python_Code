Feature: PRSAMD_296 - Verifying facility linking between a Provider type facility and an Imaging type facility via POST API

  Scenario Outline: PRSAMD_296 - Positive Scenario's with valid Authorization tokens
    Given base url is entered for linking
    When user enters valid "<Authorization>" "<token>" and fetch values from "<SheetName>" <RowNumber> and trigger Post method
    Then response body gets generated with success message and status code as 200
    And "responseMessage" is validated in response message.

    Examples: 
      | SheetName | RowNumber | Authorization | token             |
      | Sheet1    |         0 | Authorization | hil_manager_token |
      | Sheet1    |         1 | Authorization | hil_manager_token |
      | Sheet1    |         2 | Authorization | hosp_admin_token  |

  Scenario Outline: PRSAMD_296 - Negative Scenario's with valid Authorization tokens
    Given base url is entered for linking
    When user enters valid "<Authorization>" "<token>" and fetch invaliddata from "<SheetName>" <RowNumber> and trigger Post method
    Then response body got generated with error message and status code as 400
    And "errors" is validated in response message.

    Examples: 
      | SheetName | RowNumber | Authorization | token             |
      | Sheet1    |         3 | Authorization | hil_manager_token |
      | Sheet1    |         4 | Authorization | hil_manager_token |
      | Sheet1    |         5 | Authorization | hil_manager_token |
      | Sheet1    |         6 | Authorization | hil_manager_token |
      | Sheet1    |         7 | Authorization | hil_manager_token |
      | Sheet1    |         8 | Authorization | hil_manager_token |
      | Sheet1    |         9 | Authorization | hil_manager_token |
      | Sheet1    |        10 | Authorization | hil_manager_token |
      | Sheet1    |        11 | Authorization | hil_manager_token |
      | Sheet1    |        12 | Authorization | hil_manager_token |
      | Sheet1    |        13 | Authorization | hil_manager_token |
      | Sheet1    |        14 | Authorization | hosp_admin_token  |
      | Sheet1    |        15 | Authorization | hosp_admin_token  |
      | Sheet1    |        16 | Authorization | hosp_admin_token  |
      | Sheet1    |        17 | Authorization | hosp_admin_token  |
      | Sheet1    |        18 | Authorization | hosp_admin_token  |
      | Sheet1    |        19 | Authorization | hosp_admin_token  |
      | Sheet1    |        20 | Authorization | hosp_admin_token  |
      | Sheet1    |        21 | Authorization | hosp_admin_token  |
      | Sheet1    |        22 | Authorization | hosp_admin_token  |

  Scenario Outline: PRSAMD_296 - Exception Scenario's with invalid Authorization tokens
    Given base url is entered for linking
    When user enters invalid "<Authorization>" "<token>" and valid test-data from "<SheetName>" <RowNumber> and trigger Post method
    Then response body will be generate error message with status code as 401
    And "errors" is validated in response message.

    Examples: 
      | SheetName | RowNumber | Authorization | token         |
      | Sheet1    |        23 | Authorization | invalid_token |

  @DUU_PRSAMD-296_success_Staff
  Scenario Outline: PRSAMD_296 - Positive Scenario's with valid Authorization tokens
    Given base url is entered for linking
    When user enters valid "<Authorization>" "<token>" and fetch values from "<SheetName>" <RowNumber> and trigger Post method
    Then response body gets generated with success message and status code as 200
    And "responseMessage" is validated in response message.

    Examples: 
      | SheetName | RowNumber | Authorization | token            |
      | Sheet1    |         2 | Authorization | hosp_admin_token |

  @DUU_PRSAMD-296_failure_HospitalAdmin
  Scenario Outline: PRSAMD_296 - Negative Scenario's with valid Authorization tokens
    Given base url is entered for linking
    When user enters valid "<Authorization>" "<token>" and fetch invaliddata from "<SheetName>" <RowNumber> and trigger Post method
    Then response body got generated with error message and status code as 400
    And "errors" is validated in response message.

    Examples: 
      | SheetName | RowNumber | Authorization | token            |
      | Sheet1    |        14 | Authorization | hosp_admin_token |
      | Sheet1    |        15 | Authorization | hosp_admin_token |
      | Sheet1    |        16 | Authorization | hosp_admin_token |
      | Sheet1    |        17 | Authorization | hosp_admin_token |
      | Sheet1    |        18 | Authorization | hosp_admin_token |
      | Sheet1    |        19 | Authorization | hosp_admin_token |
      | Sheet1    |        20 | Authorization | hosp_admin_token |
      | Sheet1    |        21 | Authorization | hosp_admin_token |
      | Sheet1    |        22 | Authorization | hosp_admin_token |

  @DUU_PRSAMD-296_Unauthorized_Staff
  Scenario Outline: PRSAMD_296 - Exception Scenario's with invalid Authorization tokens
    Given base url is entered for linking
    When user enters invalid "<Authorization>" "<token>" and valid test-data from "<SheetName>" <RowNumber> and trigger Post method
    Then response body will be generate error message with status code as 401
    And "errors" is validated in response message.

    Examples: 
      | SheetName | RowNumber | Authorization | token         |
      | Sheet1    |        23 | Authorization | invalid_token |
