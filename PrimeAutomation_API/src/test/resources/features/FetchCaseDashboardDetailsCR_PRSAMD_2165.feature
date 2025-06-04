@DUU_PRSAMD-2165

Feature: PRSAMD_2165 - Verifying fetching case Dashboard Details list with search and filter functionality via POST API 

@HIL_PRSAMD-2165_success
Scenario Outline: PRSAMD_2165 - Scenario's with Valid Authorization Tokens for filtering Case Dashboard Details on Source Facility ID
  
    Given Base URL is used to fetch case dashboad details with Search/filter capability
    When user enters valid "<Authorization>" "<Token>" and source facility id "<sourceFacilityId>" and then triggers POST API for search/filter capability to fetch case dashboad details
    Then Response is generated with success status code to fetch case dashboad details
    And an attribute "dashboardDetails" is verified to fetch case dashboad details
    
 Examples:
|Authorization | Token | sourceFacilityId |
| Authorization | hil_manager_token | 1 |
| Authorization | hil_reviewer_token | 2 | 
| Authorization | hil_manager_token | 2 |
| Authorization | hil_reviewer_token | 4 |

@HIL_PRSAMD-2165_success
Scenario Outline: PRSAMD_2165 - Scenario's with Valid Authorization Tokens for filtering case dashboard details with Imaging Type
  
    Given Base URL is used to fetch case dashboad details with Search/filter capability
    When user enters valid "<Authorization>" "<Token>" and filter as imaging type "<imagingType>" and then triggers POST API for search/filter capability to fetch case dashboad details
    Then Response is generated with success status code to fetch case dashboad details
    And an attribute "dashboardDetails" is verified to fetch case dashboad details
    
 Examples:
|Authorization | Token | imagingType |
| Authorization | hil_manager_token | CT |
| Authorization | hil_reviewer_token | CT | 
| Authorization | hil_manager_token | MRI |
| Authorization | hil_reviewer_token | MRI |

@HIL_PRSAMD-2165_success
Scenario Outline: PRSAMD_2165 - Scenario's with Valid Authorization Tokens for fetching case dashboard details with Search Criteria
  
    Given Base URL is used to fetch case dashboad details with Search/filter capability
    When user enters valid "<Authorization>" "<Token>" and search text as "<searchText>" and then triggers POST API for search/filter capability to fetch case dashboad details
    Then Response is generated with success status code to fetch case dashboad details
    And an attribute "dashboardDetails" is verified to fetch case dashboad details
    
 Examples:
|Authorization | Token | searchText |
| Authorization | hil_manager_token | SarahElizabethAbdella |
| Authorization | hil_reviewer_token | Sinha | 
| Authorization | hil_manager_token | Sinha Rahul |
| Authorization | hil_reviewer_token | SarahElizabethAbdella PA-C | 
| Authorization | hil_manager_token | Canton Health Center |
| Authorization | hil_reviewer_token | CT | 


@HIL_PRSAMD-2165_unauthorised
Scenario Outline: PRSAMD_2165 - Scenario's with invalid Authorization tokens for Fetching Case Dashboard Details
  
    Given Base URL is used to fetch case dashboad details with Search/filter capability
    When user enters an invalid "<Authorization>" "<Token>" and valid test datas and then triggers POST API for search/filter capability to fetch case dashboad details
    Then Response is generated with unauthorized status code to fetch case dashboad details
    And an attribute "errors" is verified to fetch case dashboad details

Examples:	
| Authorization | Token |
| Authorization | invalid_token |