Feature: PRSAMD_2226- Verifying Fetching User activity List via. POST API.

  @DUU_PRSAMD-2226_success
  Scenario Outline: PRSAMD_2226-Scenario's with Valid Authorization and valid Request Body
    Given the base URL gets entered for fetching user activity
    When user gives a valid "<Authorization>" and "<Token>" and "<userFacilityId>" and triggers the POST API for fetching user activity list
    Then Response is generated with success status code for fetching user activity list
    And an attribute "auditLogResponseList" is verified while fetching user activity

    Examples: 
      | Authorization | Token             | userFacilityId |
      | Authorization | ic_admin_token    |              2 |
      | Authorization | hosp_admin_token  |              2 |
      | Authorization | hil_manager_token |              2 |

  @DUU_PRSAMD-2226_success
  Scenario Outline: PRSAMD_2226-Scenario's with Valid Authorization and Search Capability
    Given the base URL gets entered for fetching user activity
    When user enters a valid "<Authorization>" and "<Token>" and search Text as "<searchText>" and triggers the POST API for fetching user activity list
    Then Response is generated with success status code for fetching user activity list
    And an attribute "auditLogResponseList" is verified while fetching user activity

    Examples: 
      | Authorization | Token             | searchText                    |
      | Authorization | ic_admin_token    | User landed on DUU            |
      | Authorization | hosp_admin_token  | Uploaded image data is viewed |
      | Authorization | hil_manager_token | success                       |
      | Authorization | ic_admin_token    | failure                       |

  @DUU_PRSAMD-2226_success
  Scenario Outline: PRSAMD_2226-Scenario's with Valid Authorization and Request Body with filter capability
    Given the base URL gets entered for fetching user activity
    When user gives a valid "<Authorization>" and "<Token>" and filter field as "<fromActionDate>" and triggers the POST API for fetching user activity list
    Then Response is generated with success status code for fetching user activity list
    And an attribute "auditLogResponseList" is verified while fetching user activity

    Examples: 
      | Authorization | Token             | fromActionDate    |
      | Authorization | ic_admin_token    | 6/9/2023 08:19:05 |
      | Authorization | hosp_admin_token  | 6/9/2023 08:19:05 |
      | Authorization | hil_manager_token | 6/9/2023 08:19:05 |

  @DUU_PRSAMD-2226_success
  Scenario Outline: PRSAMD_2226-Scenario's with SN Manager created audit logs and fetched by Admins
    Given the base URL gets entered for fetching user activity
    When user gives a valid "<Authorization>" and "<Token>", user facility id "<userFacilityId>" and username "<userName>" and triggers the POST API for fetching user activity list
    Then Response is generated with success status code for fetching user activity list
    And an attribute "auditLogResponseList" is verified while fetching user activity

    Examples: 
      | Authorization | Token            | userFacilityId | userName |
      | Authorization | ic_admin_token   |              1 | xyz      |
      | Authorization | hosp_admin_token |              1 | xyz1     |
      | Authorization | ic_admin_token   |              1 | xyz10    |

  @DUU_PRSAMD-2226_success
  Scenario Outline: PRSAMD_2226-Scenario's with Admin created audit logs and fetched by SN Manager
    Given the base URL gets entered for fetching user activity
    When user gives a valid "<Authorization>" and "<Token>" along with user facility id "<userFacilityId>" and username "<userName>" and triggers the POST API for fetching user activity list
    Then Response is generated with success status code for fetching user activity list
    And an attribute "auditLogResponseList" is verified while fetching user activity

    Examples: 
      | Authorization | Token             | userFacilityId | userName |
      | Authorization | hil_manager_token |              1 | abc1     |
      | Authorization | hil_manager_token |              1 | abc2     |

  @DUU_PRSAMD-2226_failure
  Scenario Outline: PRSAMD_2226-Scenario's with Valid Authorization and invalid or blank user facility ID
    Given the base URL gets entered for fetching user activity
    When user gives a valid "<Authorization>" and "<Token>" and blank or invalid "<userFacilityId>" and triggers the POST API for fetching user activity list
    Then Response is generated with failure status code for fetching user activity list
    And an attribute "errors" is verified while fetching user activity

    Examples: 
      | Authorization | Token             | userFacilityId |
      | Authorization | ic_admin_token    |                |
      | Authorization | hosp_admin_token  |                |
      | Authorization | hil_manager_token |                |

  @DUU_PRSAMD-2226_unauthorised
  Scenario Outline: PRSAMD_2226-Scenario's with Invalid Authorization and valid user facility ID
    Given the base URL gets entered for fetching user activity
    When user gives an invalid "<Authorization>" and "<Token>" and valid "<userFacilityId>" and triggers the POST API for fetching user activity list
    Then Response is generated with unauthorized status code for fetching user activity list
    And an attribute "errors" is verified while fetching user activity

    Examples: 
      | Authorization | Token         | userFacilityId |
      | Authorization | invalid_token |              2 |

  @DUU_PRSAMD-2226_success_IcAdmin
  Scenario Outline: PRSAMD_2226-Scenario's with Valid Authorization and valid Request Body
    Given the base URL gets entered for fetching user activity
    When user gives a valid "<Authorization>" and "<Token>" and "<userFacilityId>" and triggers the POST API for fetching user activity list
    Then Response is generated with success status code for fetching user activity list
    And an attribute "auditLogResponseList" is verified while fetching user activity

    Examples: 
      | Authorization | Token          | userFacilityId |
      | Authorization | ic_admin_token |              2 |

  @DUU_PRSAMD-2226_success_IcAdmin
  Scenario Outline: PRSAMD_2226-Scenario's with Valid Authorization and Search Capability
    Given the base URL gets entered for fetching user activity
    When user enters a valid "<Authorization>" and "<Token>" and search Text as "<searchText>" and triggers the POST API for fetching user activity list
    Then Response is generated with success status code for fetching user activity list
    And an attribute "auditLogResponseList" is verified while fetching user activity

    Examples: 
      | Authorization | Token          | searchText         |
      | Authorization | ic_admin_token | User landed on DUU |
      | Authorization | ic_admin_token | failure            |

  @DUU_PRSAMD-2226_success_IcAdmin
  Scenario Outline: PRSAMD_2226-Scenario's with Valid Authorization and Request Body with filter capability
    Given the base URL gets entered for fetching user activity
    When user gives a valid "<Authorization>" and "<Token>" and filter field as "<fromActionDate>" and triggers the POST API for fetching user activity list
    Then Response is generated with success status code for fetching user activity list
    And an attribute "auditLogResponseList" is verified while fetching user activity

    Examples: 
      | Authorization | Token          | fromActionDate    |
      | Authorization | ic_admin_token | 6/9/2023 08:19:05 |

  @DUU_PRSAMD-2226_success_IcAdmin
  Scenario Outline: PRSAMD_2226-Scenario's with SN Manager created audit logs and fetched by Admins
    Given the base URL gets entered for fetching user activity
    When user gives a valid "<Authorization>" and "<Token>", user facility id "<userFacilityId>" and username "<userName>" and triggers the POST API for fetching user activity list
    Then Response is generated with success status code for fetching user activity list
    And an attribute "auditLogResponseList" is verified while fetching user activity

    Examples: 
      | Authorization | Token          | userFacilityId | userName |
      | Authorization | ic_admin_token |              1 | xyz      |
      | Authorization | ic_admin_token |              1 | xyz10    |

  @DUU_PRSAMD-2226_success_IcAdmin
  Scenario Outline: PRSAMD_2226-Scenario's with Admin created audit logs and fetched by SN Manager
    Given the base URL gets entered for fetching user activity
    When user gives a valid "<Authorization>" and "<Token>" along with user facility id "<userFacilityId>" and username "<userName>" and triggers the POST API for fetching user activity list
    Then Response is generated with success status code for fetching user activity list
    And an attribute "auditLogResponseList" is verified while fetching user activity

    Examples: 
      | Authorization | Token             | userFacilityId | userName |
      | Authorization | hil_manager_token |              1 | abc1     |
      | Authorization | hil_manager_token |              1 | abc2     |

  @DUU_PRSAMD-2226_failure_Surgeon
  Scenario Outline: PRSAMD_2226-Scenario's with Valid Authorization and invalid or blank user facility ID
    Given the base URL gets entered for fetching user activity
    When user gives a valid "<Authorization>" and "<Token>" and blank or invalid "<userFacilityId>" and triggers the POST API for fetching user activity list
    Then Response is generated with failure status code for fetching user activity list
    And an attribute "errors" is verified while fetching user activity

    Examples: 
      | Authorization | Token            | userFacilityId |
      | Authorization | hosp_admin_token |                |

  @DUU_PRSAMD-2226_Unauthorized_Surgeon
  Scenario Outline: PRSAMD_2226-Scenario's with Invalid Authorization and valid user facility ID
    Given the base URL gets entered for fetching user activity
    When user gives an invalid "<Authorization>" and "<Token>" and valid "<userFacilityId>" and triggers the POST API for fetching user activity list
    Then Response is generated with unauthorized status code for fetching user activity list
    And an attribute "errors" is verified while fetching user activity

    Examples: 
      | Authorization | Token         | userFacilityId |
      | Authorization | invalid_token |              2 |
