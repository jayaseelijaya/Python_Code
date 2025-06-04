Feature: PRSAMD_2162 - Verifying Upload Dashboard Details list with search and filter functionality via POST API

  @DUU_PRSAMD-2162_success
  Scenario Outline: PRSAMD_2162 - Scenario's with Valid Authorization Tokens for Fetching Dashboard Details
    Given Base URL is used to fetch upload dashboad details with Search/filter capability
    When user enters valid "<Authorization>" "<Token>" and "<linkedFacilityId>" and then triggers POST API for search/filter capability
    Then Response is generated with success status code with search/filter capability
    And an attribute "dashboardDetails" is verified for search/filter capability

    Examples: 
      | Authorization | Token               | linkedFacilityId |
      | Authorization | ic_admin_token      |                2 |
      | Authorization | ic_technician_token |                2 |
      | Authorization | hosp_admin_token    |                2 |
      | Authorization | surgeon_token       |                2 |
      | Authorization | staff_token         |                2 |
      | Authorization | hil_manager_token   |                2 |

  @DUU_PRSAMD-2162_success
  Scenario Outline: PRSAMD_2162 - Scenario's with Valid Authorization Tokens for fetching dashboard details with Search Criteria
    Given Base URL is used to fetch upload dashboad details with Search/filter capability
    When user enters valid "<Authorization>" "<Token>" and search text as "<searchText>" and then triggers POST API for search/filter capability
    Then Response is generated with success status code with search/filter capability
    And an attribute "dashboardDetails" is verified for search/filter capability

    Examples: 
      | Authorization | Token               | searchText            |
      | Authorization | ic_admin_token      | ElizabethAnnDailey    |
      | Authorization | ic_technician_token | PA-C                  |
      | Authorization | hosp_admin_token    | ChristopherBaker CRNP |
      | Authorization | surgeon_token       | Patrick David         |
      | Authorization | staff_token         | ACMH Hospital         |
      | Authorization | hil_manager_token   | FAI 2                 |
      | Authorization | ic_admin_token      | PROCESSING            |

  @DUU_PRSAMD-2162_success
  Scenario Outline: PRSAMD_2162 - Scenario's with Valid Authorization Tokens for fetching dashboard details with Filter Criteria
    Given Base URL is used to fetch upload dashboad details with Search/filter capability
    When user enters valid "<Authorization>" "<Token>" and filter as "<targetFacilityId>" and then triggers POST API for search/filter capability
    Then Response is generated with success status code with search/filter capability
    And an attribute "dashboardDetails" is verified for search/filter capability

    Examples: 
      | Authorization | Token               | targetFacilityId |
      | Authorization | ic_admin_token      |                1 |
      | Authorization | ic_technician_token |                6 |
      | Authorization | hosp_admin_token    |                1 |
      | Authorization | surgeon_token       |                6 |
      | Authorization | staff_token         |                1 |
      | Authorization | hil_manager_token   |                6 |
      | Authorization | ic_admin_token      |                6 |
      | Authorization | ic_technician_token |                1 |

  @DUU_PRSAMD-2162_failure
  Scenario Outline: PRSAMD_2162 - Scenario's with Valid Authorization Tokens for Fetching Dashboard Details with Blank linkedFacilityId
    Given Base URL is used to fetch upload dashboad details with Search/filter capability
    When user enters valid "<Authorization>" "<Token>" and a blank linked facility id  as "<linkedFacilityId>" and then triggers POST API for search/filter capability
    Then Response is generated with failure status code with search/filter capability
    And an attribute "errors" is verified for search/filter capability

    Examples: 
      | Authorization | Token               | linkedFacilityId |
      | Authorization | ic_admin_token      |                  |
      | Authorization | ic_technician_token |                  |
      | Authorization | hosp_admin_token    |                  |
      | Authorization | surgeon_token       |                  |
      | Authorization | staff_token         |                  |
      | Authorization | hil_manager_token   |                  |

  @DUU_PRSAMD-2162_unauthorised
  Scenario Outline: PRSAMD_2162 - Scenario's with invalid Authorization tokens for Fetching Dashboard Details
    Given Base URL is used to fetch upload dashboad details with Search/filter capability
    When user enters an invalid "<Authorization>" "<Token>" and valid test datas and then triggers POST API for search/filter capability
    Then Response is generated with unauthorized status code with search/filter capability
    And an attribute "errors" is verified for search/filter capability

    Examples: 
      | Authorization | Token         |
      | Authorization | invalid_token |

  @DUU_PRSAMD-2162_success_Surgeon
  Scenario Outline: PRSAMD_2162 - Scenario's with Valid Authorization Tokens for Fetching Dashboard Details
    Given Base URL is used to fetch upload dashboad details with Search/filter capability
    When user enters valid "<Authorization>" "<Token>" and "<linkedFacilityId>" and then triggers POST API for search/filter capability
    Then Response is generated with success status code with search/filter capability
    And an attribute "dashboardDetails" is verified for search/filter capability

    Examples: 
      | Authorization | Token         | linkedFacilityId |
      | Authorization | surgeon_token |                2 |

  @DUU_PRSAMD-2162_success_Surgeon
  Scenario Outline: PRSAMD_2162 - Scenario's with Valid Authorization Tokens for fetching dashboard details with Search Criteria
    Given Base URL is used to fetch upload dashboad details with Search/filter capability
    When user enters valid "<Authorization>" "<Token>" and search text as "<searchText>" and then triggers POST API for search/filter capability
    Then Response is generated with success status code with search/filter capability
    And an attribute "dashboardDetails" is verified for search/filter capability

    Examples: 
      | Authorization | Token         | searchText    |
      | Authorization | surgeon_token | Patrick David |

  @DUU_PRSAMD-2162_success_Surgeon
  Scenario Outline: PRSAMD_2162 - Scenario's with Valid Authorization Tokens for fetching dashboard details with Filter Criteria
    Given Base URL is used to fetch upload dashboad details with Search/filter capability
    When user enters valid "<Authorization>" "<Token>" and filter as "<targetFacilityId>" and then triggers POST API for search/filter capability
    Then Response is generated with success status code with search/filter capability
    And an attribute "dashboardDetails" is verified for search/filter capability

    Examples: 
      | Authorization | Token         | targetFacilityId |
      | Authorization | surgeon_token |                6 |

  @DUU_PRSAMD-2162_failure_Surgeon
  Scenario Outline: PRSAMD_2162 - Scenario's with Valid Authorization Tokens for Fetching Dashboard Details with Blank linkedFacilityId
    Given Base URL is used to fetch upload dashboad details with Search/filter capability
    When user enters valid "<Authorization>" "<Token>" and a blank linked facility id  as "<linkedFacilityId>" and then triggers POST API for search/filter capability
    Then Response is generated with failure status code with search/filter capability
    And an attribute "errors" is verified for search/filter capability

    Examples: 
      | Authorization | Token         | linkedFacilityId |
      | Authorization | surgeon_token |                  |

  @DUU_PRSAMD-2162_unauthorised
  Scenario Outline: PRSAMD_2162 - Scenario's with invalid Authorization tokens for Fetching Dashboard Details
    Given Base URL is used to fetch upload dashboad details with Search/filter capability
    When user enters an invalid "<Authorization>" "<Token>" and valid test datas and then triggers POST API for search/filter capability
    Then Response is generated with unauthorized status code with search/filter capability
    And an attribute "errors" is verified for search/filter capability

    Examples: 
      | Authorization | Token         |
      | Authorization | invalid_token |
