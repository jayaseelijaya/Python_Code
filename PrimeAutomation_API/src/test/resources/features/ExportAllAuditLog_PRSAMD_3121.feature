Feature: PRSAMD_3121- Verifying Exporting all functionality in Audit Logs via. POST and GET API.

  #-------------------------------------POST API----------------------------------------------------
  @DUU_PRSAMD-3121_post_success
  Scenario Outline: PRSAMD_3121-Scenario's with Valid Authorization and Request Body POST API
    Given the base URL is entered for Exporting all functionality in Audit Logs
    When user gives a valid "<Authorization>" and "<Token>" and "<SheetName>" <RowNumber> and triggers the POST API for Exporting all functionality in Audit Logs
    Then Response is generated with success status code while Exporting all functionality in Audit Logs POST API
    And an attribute "responseMessage" is verified while Exporting all functionality in Audit Logs POST API

    Examples: 
      | SheetName | RowNumber | Authorization | Token             |
      | Sheet1    |         0 | Authorization | ic_admin_token    |
      | Sheet1    |         1 | Authorization | hosp_admin_token  |
      | Sheet1    |         2 | Authorization | hil_manager_token |
      | Sheet1    |         3 | Authorization | ic_admin_token    |
      | Sheet1    |         4 | Authorization | hosp_admin_token  |
      | Sheet1    |         5 | Authorization | hil_manager_token |

  @DUU_PRSAMD-3121_post_failure
  Scenario Outline: PRSAMD_3121-Scenario's with Valid Authorization and Invalid Request Body POST API
    Given the base URL is entered for Exporting all functionality in Audit Logs
    When user gives a valid "<Authorization>" and "<Token>" and invalid test data from "<SheetName>" <RowNumber> and triggers the POST API for Exporting all functionality in Audit Logs
    Then Response is generated with failure status code while Exporting all functionality in Audit Logs POST API
    And an attribute "errors" is verified while Exporting all functionality in Audit Logs POST API

    Examples: 
      | SheetName | RowNumber | Authorization | Token             |
      | Sheet1    |         6 | Authorization | ic_admin_token    |
      | Sheet1    |         7 | Authorization | hosp_admin_token  |
      | Sheet1    |         8 | Authorization | hil_manager_token |

  @DUU_PRSAMD-3121_post_unauthorised
  Scenario Outline: PRSAMD_3121-Scenario's with Invalid Authorization and Valid Request Body POST API
    Given the base URL is entered for Exporting all functionality in Audit Logs
    When user gives an invalid "<Authorization>" and "<Token>" and valid test data from "<SheetName>" <RowNumber> and triggers the POST API for Exporting all functionality in Audit Logs
    Then Response is generated with unauthorised status code while Exporting all functionality in Audit Logs POST API
    And an attribute "errors" is verified while Exporting all functionality in Audit Logs POST API

    Examples: 
      | SheetName | RowNumber | Authorization | Token         |
      | Sheet1    |         9 | Authorization | invalid_token |

  #-------------------------------------GET API----------------------------------------------------
  @DUU_PRSAMD-3121_get_success
  Scenario Outline: PRSAMD_3121-Scenario's with Valid Authorization and Request Body GET API
    Given the base URL is entered for Exporting all functionality in Audit Logs
    When user gives a valid "<Authorization>" and "<Token>" and "<SheetName>" <RowNumber> and triggers the GET API for Exporting all functionality in Audit Logs
    Then Response is generated with success status code while Exporting all functionality in Audit Logs GET API
    And an attribute "logfileurl" is verified while Exporting all functionality in Audit Logs GET API

    Examples: 
      | SheetName | RowNumber | Authorization | Token             |
      | Sheet1    |        10 | Authorization | ic_admin_token    |
      | Sheet1    |        11 | Authorization | hosp_admin_token  |
      | Sheet1    |        12 | Authorization | hil_manager_token |
      | Sheet1    |        13 | Authorization | ic_admin_token    |
      | Sheet1    |        14 | Authorization | hosp_admin_token  |
      | Sheet1    |        15 | Authorization | hil_manager_token |

  @DUU_PRSAMD-3121_get_failure
  Scenario Outline: PRSAMD_3121-Scenario's with Valid Authorization and Invalid Request Body GET API
    Given the base URL is entered for Exporting all functionality in Audit Logs
    When user gives a valid "<Authorization>" and "<Token>" and invalid test data from "<SheetName>" <RowNumber> and triggers the GET API for Exporting all functionality in Audit Logs
    Then Response is generated with failure status code while Exporting all functionality in Audit Logs GET API
    And an attribute "errors" is verified while Exporting all functionality in Audit Logs GET API

    Examples: 
      | SheetName | RowNumber | Authorization | Token             |
      | Sheet1    |        16 | Authorization | ic_admin_token    |
      | Sheet1    |        17 | Authorization | hosp_admin_token  |
      | Sheet1    |        18 | Authorization | hil_manager_token |

  @DUU_PRSAMD-3121_get_unauthorised
  Scenario Outline: PRSAMD_3121-Scenario's with Invalid Authorization and Valid Request Body GET API
    Given the base URL is entered for Exporting all functionality in Audit Logs
    When user gives an invalid "<Authorization>" and "<Token>" and valid test data from "<SheetName>" <RowNumber> and triggers the GET API for Exporting all functionality in Audit Logs
    Then Response is generated with unauthorised status code while Exporting all functionality in Audit Logs GET API
    And an attribute "errors" is verified while Exporting all functionality in Audit Logs GET API

    Examples: 
      | SheetName | RowNumber | Authorization | Token         |
      | Sheet1    |        19 | Authorization | invalid_token |

  @DUU_PRSAMD-3121_success_IcAdmin
  Scenario Outline: PRSAMD_3121-Scenario's with Valid Authorization and Request Body POST API
    Given the base URL is entered for Exporting all functionality in Audit Logs
    When user gives a valid "<Authorization>" and "<Token>" and "<SheetName>" <RowNumber> and triggers the POST API for Exporting all functionality in Audit Logs
    Then Response is generated with success status code while Exporting all functionality in Audit Logs POST API
    And an attribute "responseMessage" is verified while Exporting all functionality in Audit Logs POST API

    Examples: 
      | SheetName | RowNumber | Authorization | Token          |
      | Sheet1    |         0 | Authorization | ic_admin_token |
      | Sheet1    |         3 | Authorization | ic_admin_token |

  @DUU_PRSAMD-3121_failure_IcAdmin
  Scenario Outline: PRSAMD_3121-Scenario's with Valid Authorization and Invalid Request Body POST API
    Given the base URL is entered for Exporting all functionality in Audit Logs
    When user gives a valid "<Authorization>" and "<Token>" and invalid test data from "<SheetName>" <RowNumber> and triggers the POST API for Exporting all functionality in Audit Logs
    Then Response is generated with failure status code while Exporting all functionality in Audit Logs POST API
    And an attribute "errors" is verified while Exporting all functionality in Audit Logs POST API

    Examples: 
      | SheetName | RowNumber | Authorization | Token          |
      | Sheet1    |         6 | Authorization | ic_admin_token |

  @DUU_PRSAMD-3121_Unauthorized_IcAdmin
  Scenario Outline: PRSAMD_3121-Scenario's with Invalid Authorization and Valid Request Body POST API
    Given the base URL is entered for Exporting all functionality in Audit Logs
    When user gives an invalid "<Authorization>" and "<Token>" and valid test data from "<SheetName>" <RowNumber> and triggers the POST API for Exporting all functionality in Audit Logs
    Then Response is generated with unauthorised status code while Exporting all functionality in Audit Logs POST API
    And an attribute "errors" is verified while Exporting all functionality in Audit Logs POST API

    Examples: 
      | SheetName | RowNumber | Authorization | Token         |
      | Sheet1    |         9 | Authorization | invalid_token |
