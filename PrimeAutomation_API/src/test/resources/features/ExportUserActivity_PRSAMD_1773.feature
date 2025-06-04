Feature: PRSAMD_1773 - Verifying export list of User activity via. POST API.

  @DUU_PRSAMD-1773_success
  Scenario Outline: PRSAMD_1773 - Scenario's with valid Authorization and Request Body
    Given User enters a valid URL for exporting list of user activities
    When User gives a valid "<Authorization>" and "<Token>" and extract valid data from excel "<SheetName>" and <RowNumber> for exporting list of User Activities and triggers the POST API
    Then a response is generated with status code 200 for exporting user activities list

    Examples: 
      | SheetName | RowNumber | Authorization | Token             |
      | Sheet1    |         0 | Authorization | ic_admin_token    |
      | Sheet1    |         1 | Authorization | hosp_admin_token  |
      | Sheet1    |         2 | Authorization | hil_manager_token |

  @DUU_PRSAMD-1773_failure
  Scenario Outline: PRSAMD_1773 - Scenario's with valid Authorization and invalid userFacilityId
    Given User enters a valid URL for exporting list of user activities
    When User provides a valid "<Authorization>" and "<Token>" and extract invalid userFacilityId data from excel "<SheetName>" and <RowNumber> for exporting list of User Activities and triggers the POST API
    Then a response gets generated with status code 400 for exporting user activities list
    And the attribute "errors" is verified

    Examples: 
      | SheetName | RowNumber | Authorization | Token             |
      | Sheet1    |         3 | Authorization | ic_admin_token    |
      | Sheet1    |         4 | Authorization | hosp_admin_token  |
      | Sheet1    |         5 | Authorization | hil_manager_token |
      | Sheet1    |         6 | Authorization | ic_admin_token    |
      | Sheet1    |         7 | Authorization | hosp_admin_token  |
      | Sheet1    |         8 | Authorization | hil_manager_token |

  @DUU_PRSAMD-1773_unauthorised
  Scenario Outline: PRSAMD_1773 - Scenario's with Invalid Authorization and Valid Request Body
    Given User enters a valid URL for exporting list of user activities
    When User provides an invalid "<Authorization>" and "<Token>" and extract valid data from excel "<SheetName>" and <RowNumber> for exporting list of User Activities and triggers the POST API
    Then a response generates with status code 401 for exporting user activities list
    And the attribute "errors" is verified

    Examples: 
      | SheetName | RowNumber | Authorization | Token         |
      | Sheet1    |         9 | Authorization | invalid_token |

  @DUU_PRSAMD-1773_success_HospitalAdmin
  Scenario Outline: PRSAMD_1773 - Scenario's with valid Authorization and Request Body
    Given User enters a valid URL for exporting list of user activities
    When User gives a valid "<Authorization>" and "<Token>" and extract valid data from excel "<SheetName>" and <RowNumber> for exporting list of User Activities and triggers the POST API
    Then a response is generated with status code 200 for exporting user activities list

    Examples: 
      | SheetName | RowNumber | Authorization | Token             |
      | Sheet1    |         1 | Authorization | hosp_admin_token  |

  @DUU_PRSAMD-1773_failure_HospitalAdmin
  Scenario Outline: PRSAMD_1773 - Scenario's with valid Authorization and invalid userFacilityId
    Given User enters a valid URL for exporting list of user activities
    When User provides a valid "<Authorization>" and "<Token>" and extract invalid userFacilityId data from excel "<SheetName>" and <RowNumber> for exporting list of User Activities and triggers the POST API
    Then a response gets generated with status code 400 for exporting user activities list
    And the attribute "errors" is verified

    Examples: 
      | SheetName | RowNumber | Authorization | Token             |
      | Sheet1    |         4 | Authorization | hosp_admin_token  |
 
  @DUU_PRSAMD-1773_Unauthorized_HospitalAdmin
  Scenario Outline: PRSAMD_1773 - Scenario's with Invalid Authorization and Valid Request Body
    Given User enters a valid URL for exporting list of user activities
    When User provides an invalid "<Authorization>" and "<Token>" and extract valid data from excel "<SheetName>" and <RowNumber> for exporting list of User Activities and triggers the POST API
    Then a response generates with status code 401 for exporting user activities list
    And the attribute "errors" is verified

    Examples: 
      | SheetName | RowNumber | Authorization | Token         |
      | Sheet1    |         9 | Authorization | invalid_token |
