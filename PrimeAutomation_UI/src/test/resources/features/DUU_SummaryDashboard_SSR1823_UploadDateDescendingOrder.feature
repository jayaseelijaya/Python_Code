Feature: SSR1823 - Verifying summary dashboard displays upload date in descending order.

  @summaryDashboard_TC3014
  Scenario Outline: TC3014 - IC Admin_Verify if Data Upload Utility web application summary dashboard displays the record in descending order of upload date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    Then the dashboard summary shall display list of upload items
    And the second column shall display surgeon name with first name last name
    And the date of the file uploaded shall be displayed
    And the records shall be displayed in descending order of upload date
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |

  @summaryDashboard_TC3015
  Scenario Outline: TC3015 - IC Technician_Verify if Data Upload Utility web application summary dashboard displays the record in descending order of upload date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    Then the dashboard summary shall display list of upload items
    And the second column shall display surgeon name with first name last name
    And the date of the file uploaded shall be displayed
    And the records shall be displayed in descending order of upload date
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    Examples: 
      | user                       |
      | ic-test-user@capgemini.com |

  @summaryDashboard_TC3016
  Scenario Outline: TC3016 - Hospital Admin_Verify if Data Upload Utility web application summary dashboard displays the record in descending order of upload date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    Then the dashboard summary shall display list of upload items
    And the second column shall display surgeon name with first name last name
    And the date of the file uploaded shall be displayed
    And the records shall be displayed in descending order of upload date
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    Examples: 
      | user                                 |
      | ic-test-hospital-admin@capgemini.com |

  @summaryDashboard_TC3017
  Scenario Outline: TC3017 - Surgeon_Verify if Data Upload Utility web application summary dashboard displays the record in descending order of upload date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    Then the dashboard summary shall display list of upload items
    And the second column shall display surgeon name with first name last name
    And the date of the file uploaded shall be displayed
    And the records shall be displayed in descending order of upload date
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

    Examples: 
      | user                          |
      | ic-test-surgeon@capgemini.com |

  @summaryDashboard_TC3018
  Scenario Outline: TC3018 - Support Staff_Verify if Data Upload Utility web application summary dashboard displays the record in descending order of upload date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    Then the dashboard summary shall display list of upload items
    And the second column shall display surgeon name with first name last name
    And the date of the file uploaded shall be displayed
    And the records shall be displayed in descending order of upload date
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    Examples: 
      | user                        |
      | ic-test-staff@capgemini.com |

  @summaryDashboard_TC3019
  Scenario Outline: TC3019 - SN HIL Manager_Verify if Data Upload Utility web application summary dashboard displays the record in descending order of upload date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Choose Site screen is displayed
    When SN user click on any facility from list
    And clicks on Select button
    Then Homepage is displayed
    Then the dashboard summary shall display list of upload items
    And the second column shall display surgeon name with first name last name
    And the date of the file uploaded shall be displayed
    And the records shall be displayed in descending order of upload date
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |
