Feature: SSR1829 - Verifying Filter based on start and end date in summary dashboard

  @summaryDashboard_TC0750
  Scenario Outline: TC0750 - IC admin_Verify the Upload dashboard records is filterable by start and end date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    #step2
    And the dashboard summary shall display list of upload items
    #step3
    And the filter button shall be displayed
    When the user clicks on filter button
    And the following filter menu shall be displayed
      | menu        |
      | filter by   |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #step4
    When the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #step5
    When the user clicks on start button
    Then the start date picker table shall be diaplsyed
    #step6
    When the user selects a start date from the date picker table
    Then the selected start date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    #step7
    When the user clicks on filter button
    And the user clicks on date filter menu option
    And the user clicks on end button
    Then the end date picker table shall be displayed
    #step8
    When the user selects a end date from the date picker table
    Then the selected end date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |

  @summaryDashboard_TC2936
  Scenario Outline: TC2936 - IC Technician_Verify the Upload dashboard records is filterable by start and end date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    #step2
    And the dashboard summary shall display list of upload items
    #step3
    And the filter button shall be displayed
    When the user clicks on filter button
    And the following filter menu shall be displayed
      | menu        |
      | filter by   |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #step4
    When the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #step5
    When the user clicks on start button
    Then the start date picker table shall be diaplsyed
    #step6
    When the user selects a start date from the date picker table
    Then the selected start date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    #step7
    When the user clicks on filter button
    And the user clicks on date filter menu option
    And the user clicks on end button
    Then the end date picker table shall be displayed
    #step8
    When the user selects a end date from the date picker table
    Then the selected end date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                       |
      | ic-test-user@capgemini.com |

  @summaryDashboard_TC2937
  Scenario Outline: TC2937 - Hospital Admin_Verify the Upload dashboard records is filterable by start and end date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    #step2
    And the dashboard summary shall display list of upload items
    #step3
    And the filter button shall be displayed
    When the user clicks on filter button
    And the following filter menu shall be displayed
      | menu        |
      | filter by   |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #step4
    When the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #step5
    When the user clicks on start button
    Then the start date picker table shall be diaplsyed
    #step6
    When the user selects a start date from the date picker table
    Then the selected start date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    #step7
    When the user clicks on filter button
    And the user clicks on date filter menu option
    And the user clicks on end button
    Then the end date picker table shall be displayed
    #step8
    When the user selects a end date from the date picker table
    Then the selected end date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                                 |
      | ic-test-hospital-admin@capgemini.com |

  @summaryDashboard_TC2938
  Scenario Outline: TC2938 - Surgeon_Verify the Upload dashboard records is filterable by start and end date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    #step2
    And the dashboard summary shall display list of upload items
    #step3
    And the filter button shall be displayed
    When the user clicks on filter button
    And the following filter menu shall be displayed
      | menu        |
      | filter by   |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #step4
    When the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #step5
    When the user clicks on start button
    Then the start date picker table shall be diaplsyed
    #step6
    When the user selects a start date from the date picker table
    Then the selected start date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    #step7
    When the user clicks on filter button
    And the user clicks on date filter menu option
    And the user clicks on end button
    Then the end date picker table shall be displayed
    #step8
    When the user selects a end date from the date picker table
    Then the selected end date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                          |
      | ic-test-surgeon@capgemini.com |

  @summaryDashboard_TC2939
  Scenario Outline: TC2939 - Support Staff_Verify the Upload dashboard records is filterable by start and end date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    #step2
    And the dashboard summary shall display list of upload items
    #step3
    And the filter button shall be displayed
    When the user clicks on filter button
    And the following filter menu shall be displayed
      | menu        |
      | filter by   |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #step4
    When the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #step5
    When the user clicks on start button
    Then the start date picker table shall be diaplsyed
    #step6
    When the user selects a start date from the date picker table
    Then the selected start date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    #step7
    When the user clicks on filter button
    And the user clicks on date filter menu option
    And the user clicks on end button
    Then the end date picker table shall be displayed
    #step8
    When the user selects a end date from the date picker table
    Then the selected end date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                        |
      | ic-test-staff@capgemini.com |

  @summaryDashboard_TC2940
  Scenario Outline: TC2940 - SN HIL Manager_Verify the Upload dashboard records is filterable by start and end date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And Choose Site screen is displayed
    Then Search for hospital
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    Then Upload dashboad page is displayed to user
    #step2
    And the dashboard summary shall display list of upload items
    #step3
    And the filter button shall be displayed
    When the user clicks on filter button
    And the following filter menu shall be displayed
      | menu        |
      | filter by   |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #step4
    When the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #step5
    When the user clicks on start button
    Then the start date picker table shall be diaplsyed
    #step6
    When the user selects a start date from the date picker table
    Then the selected start date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    #step7
    When the user clicks on filter button
    And the user clicks on date filter menu option
    And the user clicks on end button
    Then the end date picker table shall be displayed
    #step8
    When the user selects a end date from the date picker table
    Then the selected end date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |

  @summaryDashboard_TC1206
  Scenario Outline: TC1206 - IC Admin_Verify the Upload dashboard records is filterable by start and end date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    #step2
    And the filter button shall be displayed
    #step3
    When the user clicks on filter button
    And the following filter menu shall be displayed
      | menu        |
      | filter by   |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #step4
    When the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #step5
    When the user clicks on start button
    Then the start date picker table shall be diaplsyed
    #step6
    And the user selects current date as start date
    Then the selected start date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    #step7
    When the user clicks on filter button
    And the user clicks on date filter menu option
    And the user clicks on end button
    Then the end date picker table shall be displayed
    #step8
    When the user selects lesser date in end date
    Then the calender shall be displayed all dates in greyed out
    And the only current date shall be selectable
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |

  @summaryDashboard_TC2948
  Scenario Outline: TC2948 - IC Technician_Verify the Upload dashboard records is filterable by start and end date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    #step2
    And the filter button shall be displayed
    #step3
    When the user clicks on filter button
    And the following filter menu shall be displayed
      | menu        |
      | filter by   |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #step4
    When the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #step5
    When the user clicks on start button
    Then the start date picker table shall be diaplsyed
    #step6
    And the user selects current date as start date
    Then the selected start date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    #step7
    When the user clicks on filter button
    And the user clicks on date filter menu option
    And the user clicks on end button
    Then the end date picker table shall be displayed
    #step8
    When the user selects lesser date in end date
    Then the calender shall be displayed all dates in greyed out
    And the only current date shall be selectable
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                       |
      | ic-test-user@capgemini.com |

  @summaryDashboard_TC2949
  Scenario Outline: TC2949 - Hospital Admin_Verify the Upload dashboard records is filterable by start and end date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    #step2
    And the filter button shall be displayed
    #step3
    When the user clicks on filter button
    And the following filter menu shall be displayed
      | menu        |
      | filter by   |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #step4
    When the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #step5
    When the user clicks on start button
    Then the start date picker table shall be diaplsyed
    #step6
    And the user selects current date as start date
    Then the selected start date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    #step7
    When the user clicks on filter button
    And the user clicks on date filter menu option
    And the user clicks on end button
    Then the end date picker table shall be displayed
    #step8
    When the user selects lesser date in end date
    Then the calender shall be displayed all dates in greyed out
    And the only current date shall be selectable
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                                 |
      | ic-test-hospital-admin@capgemini.com |

  @summaryDashboard_TC2950
  Scenario Outline: TC2950 - Surgeon_Verify the Upload dashboard records is filterable by start and end date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    #step2
    And the filter button shall be displayed
    #step3
    When the user clicks on filter button
    And the following filter menu shall be displayed
      | menu        |
      | filter by   |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #step4
    When the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #step5
    When the user clicks on start button
    Then the start date picker table shall be diaplsyed
    #step6
    And the user selects current date as start date
    Then the selected start date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    #step7
    When the user clicks on filter button
    And the user clicks on date filter menu option
    And the user clicks on end button
    Then the end date picker table shall be displayed
    #step8
    When the user selects lesser date in end date
    Then the calender shall be displayed all dates in greyed out
    And the only current date shall be selectable
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                          |
      | ic-test-surgeon@capgemini.com |

  @summaryDashboard_TC2951
  Scenario Outline: TC2951 - Support Staff_Verify the Upload dashboard records is filterable by start and end date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    #step2
    And the filter button shall be displayed
    #step3
    When the user clicks on filter button
    And the following filter menu shall be displayed
      | menu        |
      | filter by   |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #step4
    When the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #step5
    When the user clicks on start button
    Then the start date picker table shall be diaplsyed
    #step6
    And the user selects current date as start date
    Then the selected start date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    #step7
    When the user clicks on filter button
    And the user clicks on date filter menu option
    And the user clicks on end button
    Then the end date picker table shall be displayed
    #step8
    When the user selects lesser date in end date
    Then the calender shall be displayed all dates in greyed out
    And the only current date shall be selectable
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                        |
      | ic-test-staff@capgemini.com |

  @summaryDashboard_TC2952
  Scenario Outline: TC2952 - SN HIL Manager_Verify the Upload dashboard records is filterable by start and end date.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    #step2
    And the filter button shall be displayed
    #step3
    When the user clicks on filter button
    And the following filter menu shall be displayed
      | menu        |
      | filter by   |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #step4
    When the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #step5
    When the user clicks on start button
    Then the start date picker table shall be diaplsyed
    #step6
    And the user selects current date as start date
    Then the selected start date shall be displayed
    And the user clicks on done button
    Then the dashboard summary shall be filtered based on selected date
    #step7
    When the user clicks on filter button
    And the user clicks on date filter menu option
    And the user clicks on end button
    Then the end date picker table shall be displayed
    #step8
    When the user selects lesser date in end date
    Then the calender shall be displayed all dates in greyed out
    And the only current date shall be selectable
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |
