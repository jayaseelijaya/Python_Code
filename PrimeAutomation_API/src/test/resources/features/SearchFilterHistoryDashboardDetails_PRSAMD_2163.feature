Feature: PRSAMD_2163 - Verifying fetching image upload history details list with search and filter functionality via POST API

  @DUU_PRSAMD-2163_success
  Scenario Outline: PRSAMD_2163 - Scenario's with Valid Authorization Tokens for Fetching Dashboard Details
    Given Base URL  is entered for fetching image upload history details list with search and filter functionality
    When user enters the valid "<Authorization>" "<Token>" and "<linkedFacilityId>" and then triggering POST API for fetching image upload history details list with search and filter functionality
    Then Response is generated with success status code for fetching image upload history details list with search and filter functionality
    And an attribute validation "historyDetails" in Response body is being verified fetching image upload history details list with search and filter functionality

    Examples: 
      | Authorization | Token               | linkedFacilityId |
      | Authorization | ic_admin_token      |                2 |
      | Authorization | ic_technician_token |                2 |
      | Authorization | hosp_admin_token    |                2 |
      | Authorization | surgeon_token       |                2 |
      | Authorization | staff_token         |                2 |
      | Authorization | hil_manager_token   |                2 |

  @DUU_PRSAMD-2163_success
  Scenario Outline: PRSAMD_2163 - Scenario's with Valid Authorization Tokens for fetching dashboard details with Search Criteria
    Given Base URL  is entered for fetching image upload history details list with search and filter functionality
    When user enters the valid "<Authorization>" "<Token>" along with search parameter "<searchText>" and then triggering POST API for fetching image upload history details list with search and filter functionality
    Then Response is generated with success status code for fetching image upload history details list with search and filter functionality
    And an attribute validation "historyDetails" in Response body is being verified fetching image upload history details list with search and filter functionality

    Examples: 
      | Authorization | Token               | searchText           |
      | Authorization | ic_admin_token      | DR.Uploader Batch    |
      | Authorization | ic_technician_token | Batch DR.Uploader    |
      | Authorization | hosp_admin_token    | Dr.Test d'souza Code |
      | Authorization | surgeon_token       | Code Dr.Test d'souza |
      | Authorization | staff_token         | 08/10/1958           |
      | Authorization | hil_manager_token   | Other                |

  @DUU_PRSAMD-2163_success
  Scenario Outline: PRSAMD_2163 - Scenario's with Valid Authorization Tokens for fetching dashboard details with Filter Criteria
    Given Base URL  is entered for fetching image upload history details list with search and filter functionality
    When user enters valid "<Authorization>" "<Token>" and filter as "<targetFacilityId>" and then triggers POST API for fetching image upload history details list with search and filter functionality
    Then Response is generated with success status code for fetching image upload history details list with search and filter functionality
    And an attribute validation "historyDetails" in Response body is being verified fetching image upload history details list with search and filter functionality

    Examples: 
      | Authorization | Token               | targetFacilityId |
      | Authorization | ic_admin_token      |                1 |
      | Authorization | ic_technician_token |                1 |
      | Authorization | hosp_admin_token    |                3 |
      | Authorization | surgeon_token       |                1 |
      | Authorization | staff_token         |                1 |
      | Authorization | hil_manager_token   |                7 |

  @DUU_PRSAMD-2163_failure
  Scenario Outline: PRSAMD_2163 - Scenario's with Valid Authorization Tokens for Fetching Dashboard Details with Blank linkedFacilityId
    Given Base URL  is entered for fetching image upload history details list with search and filter functionality
    When user enters the valid "<Authorization>" "<Token>" along with blank "<linkedFacilityId>" and then triggering POST API fetching image upload history details list with search and filter functionality
    Then Response is generated with failure status code for fetching image upload history details list with search and filter functionality
    And an attribute validation "errors" in Response body is being verified fetching image upload history details list with search and filter functionality

    Examples: 
      | Authorization | Token               | linkedFacilityId |
      | Authorization | ic_admin_token      |                  |
      | Authorization | ic_technician_token |                  |
      | Authorization | hosp_admin_token    |                  |
      | Authorization | surgeon_token       |                  |
      | Authorization | staff_token         |                  |
      | Authorization | hil_manager_token   |                  |

  @DUU_PRSAMD-2163_unauthorised
  Scenario Outline: PRSAMD_2163- Scenario's with invalid Authorization tokens for Fetching Dashboard Details
    Given Base URL  is entered for fetching image upload history details list with search and filter functionality
    When user enters an invalid "<Authorization>" "<Token>" along with valid request body and then triggering POST API for fetching image upload history details list with search and filter functionality
    Then Response is generated with unauthorised status code for fetching image upload history details list with search and filter functionality
    And an attribute validation "errors" in Response body is being verified fetching image upload history details list with search and filter functionality

    Examples: 
      | Authorization | Token         |
      | Authorization | invalid_token |

  @DUU_PRSAMD-2163_success_Staff
  Scenario Outline: PRSAMD_2163 - Scenario's with Valid Authorization Tokens for Fetching Dashboard Details
    Given Base URL  is entered for fetching image upload history details list with search and filter functionality
    When user enters the valid "<Authorization>" "<Token>" and "<linkedFacilityId>" and then triggering POST API for fetching image upload history details list with search and filter functionality
    Then Response is generated with success status code for fetching image upload history details list with search and filter functionality
    And an attribute validation "historyDetails" in Response body is being verified fetching image upload history details list with search and filter functionality

    Examples: 
      | Authorization | Token       | linkedFacilityId |
      | Authorization | staff_token |                2 |

  @DUU_PRSAMD-2163_success_Staff
  Scenario Outline: PRSAMD_2163 - Scenario's with Valid Authorization Tokens for fetching dashboard details with Search Criteria
    Given Base URL  is entered for fetching image upload history details list with search and filter functionality
    When user enters the valid "<Authorization>" "<Token>" along with search parameter "<searchText>" and then triggering POST API for fetching image upload history details list with search and filter functionality
    Then Response is generated with success status code for fetching image upload history details list with search and filter functionality
    And an attribute validation "historyDetails" in Response body is being verified fetching image upload history details list with search and filter functionality

    Examples: 
      | Authorization | Token       | searchText |
      | Authorization | staff_token | 08/10/1958 |

  @DUU_PRSAMD-2163_success_Staff
  Scenario Outline: PRSAMD_2163 - Scenario's with Valid Authorization Tokens for fetching dashboard details with Filter Criteria
    Given Base URL  is entered for fetching image upload history details list with search and filter functionality
    When user enters valid "<Authorization>" "<Token>" and filter as "<targetFacilityId>" and then triggers POST API for fetching image upload history details list with search and filter functionality
    Then Response is generated with success status code for fetching image upload history details list with search and filter functionality
    And an attribute validation "historyDetails" in Response body is being verified fetching image upload history details list with search and filter functionality

    Examples: 
      | Authorization | Token       | targetFacilityId |
      | Authorization | staff_token |                1 |

  @DUU_PRSAMD-2163_failure_Staff
  Scenario Outline: PRSAMD_2163 - Scenario's with Valid Authorization Tokens for Fetching Dashboard Details with Blank linkedFacilityId
    Given Base URL  is entered for fetching image upload history details list with search and filter functionality
    When user enters the valid "<Authorization>" "<Token>" along with blank "<linkedFacilityId>" and then triggering POST API fetching image upload history details list with search and filter functionality
    Then Response is generated with failure status code for fetching image upload history details list with search and filter functionality
    And an attribute validation "errors" in Response body is being verified fetching image upload history details list with search and filter functionality

    Examples: 
      | Authorization | Token       | linkedFacilityId |
      | Authorization | staff_token |                  |

  @DUU_PRSAMD-2163_Unauthorized_Staff
  Scenario Outline: PRSAMD_2163- Scenario's with invalid Authorization tokens for Fetching Dashboard Details
    Given Base URL  is entered for fetching image upload history details list with search and filter functionality
    When user enters an invalid "<Authorization>" "<Token>" along with valid request body and then triggering POST API for fetching image upload history details list with search and filter functionality
    Then Response is generated with unauthorised status code for fetching image upload history details list with search and filter functionality
    And an attribute validation "errors" in Response body is being verified fetching image upload history details list with search and filter functionality

    Examples: 
      | Authorization | Token         |
      | Authorization | invalid_token |
