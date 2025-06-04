Feature: SSR3692 - Verifying that DUU application shall provide the ability to filter the data contents of Upload Dashboard, History, and audit log tables within the past 24 hours.

  @summarydashboard_SSR3692
  Scenario: TC0583 - IC Admin_ Verify Summary Dashboard is filterable by surgeon, facility, application and status
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    #    Given Ensure at least 2 image upload records with different surgeon , site , application and file status are available on upload dashboard screen
    When click settings page button from left menu
    When the user enters "1" in successful upload expiration textbox
    And the user enters "1" in unsuccessful upload expiration textbox
    When the user clicks on save button in settings
    When the user clicks on dashbaord button from left menu bar
    #Step 2
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
    #Step 3
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 4
    When the user click on + for "Surgeon" and select a "surgeon" from the list and click on done button
    And the selected "surgeon name" pop-up is highlighted at the top-left
    Then the records are filtered out as per the "Surgeon" selected in filter
    #Step 5
    When the user click on "x" on the pop-up
    And the "surgeon name" pop-up is disappeared
    #Step 6
    When the user selects 24hrs filters on dashboard
    Then the 24 hrs filter is highlighted in Upload dashboard screen
    Then the records which is uploaded within 24 hours are displayed
    And the "surgeon name" pop-up is disappeared
    #Step 7
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 8
    When the user click on + for "Site" and select a "site" from the list and click on done button
    Then the records are filtered out as per the "Site" selected in filter
    And the selected "site name" pop-up is highlighted at the top-left
    #Step 9
    When the user click on "x" on the pop-up
    Then the "site name" pop-up is disappeared
    #Step 10
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 11
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application" selected in filter
    And the selected "application name" pop-up is highlighted at the top-left
    #Step 12
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 13
    When the user click on + for "File status" and select a "File status" from the list and click on done button
    Then the records are filtered out as per the "Application and File status" selected in filter
    And the selected "application name and File status" pop-up is highlighted at the top-left
    #Step 14
    When the user click on "x" on the pop-up
    Then the "application name and File status" pop-up is disappeared
    #Step 15
    When the user selects 24hrs filters on dashboard
    Then the 24 hrs filter is highlighted in Upload dashboard screen
    Then the records which is uploaded within 24 hours are displayed
    #Step 16
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 17
    When the user click on + for "Surgeon" and select a "surgeon"
    Then the selected "surgeon name" is highlighted under the surgeon filter
    #Step 18
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application and Surgeon" selected in filter
    And the selected "Application and Surgeon" pop-up is highlighted at the top-left
    #Step 19
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  #And Data-Upload Application is closed
  @summarydashboard_SSR3692
  Scenario: TC2904 - IC Technician_ Verify Summary Dashboard is filterable by surgeon, facility, application and status
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    When click settings page button from left menu
    When the user enters "1" in successful upload expiration textbox
    And the user enters "1" in unsuccessful upload expiration textbox
    When the user clicks on save button in settings
    When user clicks on Logout icon from left panel
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    And Upload dashboad page is displayed to user
    #    Given Ensure at least 2 image upload records with different surgeon , site , application and file status are available on upload dashboard screen
    #Step 2
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
    #Step 3
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 4
    When the user click on + for "Surgeon" and select a "surgeon" from the list and click on done button
    And the selected "surgeon name" pop-up is highlighted at the top-left
    Then the records are filtered out as per the "Surgeon" selected in filter
    #Step 5
    When the user selects 24hrs filters on dashboard
    Then the 24 hrs filter is highlighted in Upload dashboard screen
    Then the records which is uploaded within 24 hours are displayed
    And the "surgeon name" pop-up is disappeared
    #Step 6
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 7
    When the user click on + for "Site" and select a "site" from the list and click on done button
    Then the records are filtered out as per the "Site" selected in filter
    And the selected "site name" pop-up is highlighted at the top-left
    #Step 8
    When the user click on "x" on the pop-up
    Then the "site name" pop-up is disappeared
    #Step 9
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 10
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application" selected in filter
    And the selected "application name" pop-up is highlighted at the top-left
    #Step 11
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 12
    When the user click on + for "File status" and select a "File status" from the list and click on done button
    Then the records are filtered out as per the "Application and File status" selected in filter
    And the selected "application name and File status" pop-up is highlighted at the top-left
    #Step 13
    When the user click on "x" on the pop-up
    When the user selects 24hrs filters on dashboard
    #Step 14
    Then the 24 hrs filter is highlighted in Upload dashboard screen
    Then the records which is uploaded within 24 hours are displayed
    #Step 15
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 16
    When the user click on + for "Surgeon" and select a "surgeon"
    Then the selected "surgeon name" is highlighted under the surgeon filter
    #Step 17
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application and Surgeon" selected in filter
    And the selected "Application and Surgeon" pop-up is highlighted at the top-left
    #Step 18
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 19
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  #And Data-Upload Application is closed
  @summarydashboard_SSR3692
  Scenario: TC2905 - Hospital Admin_ Verify Summary Dashboard is filterable by surgeon, facility, application and status
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    #    Given Ensure at least 2 image upload records with different surgeon , site , application and file status are available on upload dashboard screen
    When click settings page button from left menu
    When the user enters "1" in successful upload expiration textbox
    And the user enters "1" in unsuccessful upload expiration textbox
    When the user clicks on save button in settings
    When the user clicks on dashbaord button from left menu bar
    #Step 2
    Then the records which is uploaded within 24 hours are displayed
    #Step 3
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 4
    When the user click on + for "Surgeon" and select a "surgeon" from the list and click on done button
    And the selected "surgeon name" pop-up is highlighted at the top-left
    Then the records are filtered out as per the "Surgeon" selected in filter
    #Step 5
    When the user selects 24hrs filters on dashboard
    Then the 24 hrs filter is highlighted in Upload dashboard screen
    Then the records which is uploaded within 24 hours are displayed
    And the "surgeon name" pop-up is disappeared
    #Step 6
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 7
    When the user click on + for "Site" and select a "site" from the list and click on done button
    Then the records are filtered out as per the "Site" selected in filter
    And the selected "site name" pop-up is highlighted at the top-left
    #Step 8
    When the user click on "x" on the pop-up
    Then the "site name" pop-up is disappeared
    #Step 9
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 10
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application" selected in filter
    And the selected "application name" pop-up is highlighted at the top-left
    #Step 11
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 12
    When the user click on + for "File status" and select a "File status" from the list and click on done button
    Then the records are filtered out as per the "Application and File status" selected in filter
    And the selected "application name and File status" pop-up is highlighted at the top-left
    #Step 13
    When the user click on "x" on the pop-up
    When the user selects 24hrs filters on dashboard
    #Step 14
    Then the 24 hrs filter is highlighted in Upload dashboard screen
    Then the records which is uploaded within 24 hours are displayed
    #Step 15
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 16
    When the user click on + for "Surgeon" and select a "surgeon"
    Then the selected "surgeon name" is highlighted under the surgeon filter
    #Step 17
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application and Surgeon" selected in filter
    And the selected "Application and Surgeon" pop-up is highlighted at the top-left
    #Step 18
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  #And Data-Upload Application is closed
  @summarydashboard_SSR3692
  Scenario: TC2906 - Surgeon_ Verify Summary Dashboard is filterable by surgeon, facility, application and file status
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    When click settings page button from left menu
    When the user enters "1" in successful upload expiration textbox
    And the user enters "1" in unsuccessful upload expiration textbox
    When the user clicks on save button in settings
    When user clicks on Logout icon from left panel
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
    #    Given Ensure at least 2 image upload records with different surgeon , site , application and file status are available on upload dashboard screen
    #Step 2
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
    #Step 3
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 4
    When the user click on + for "Surgeon" and select a "surgeon" from the list and click on done button
    And the selected "surgeon name" pop-up is highlighted at the top-left
    Then the records are filtered out as per the "Surgeon" selected in filter
    #Step 5
    When the user selects 24hrs filters on dashboard
    Then the 24 hrs filter is highlighted in Upload dashboard screen
    Then the records which is uploaded within 24 hours are displayed
    And the "surgeon name" pop-up is disappeared
    #Step 6
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 7
    When the user click on + for "Site" and select a "site" from the list and click on done button
    Then the records are filtered out as per the "Site" selected in filter
    And the selected "site name" pop-up is highlighted at the top-left
    #Step 8
    When the user click on "x" on the pop-up
    Then the "site name" pop-up is disappeared
    #Step 9
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 10
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application" selected in filter
    And the selected "application name" pop-up is highlighted at the top-left
    #Step 11
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 12
    When the user click on + for "File status" and select a "File status" from the list and click on done button
    Then the records are filtered out as per the "Application and File status" selected in filter
    And the selected "application name and File status" pop-up is highlighted at the top-left
    #Step 13
    When the user click on "x" on the pop-up
    When the user selects 24hrs filters on dashboard
    #Step 14
    Then the 24 hrs filter is highlighted in Upload dashboard screen
    Then the records which is uploaded within 24 hours are displayed
    #Step 15
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 16
    When the user click on + for "Surgeon" and select a "surgeon"
    Then the selected "surgeon name" is highlighted under the surgeon filter
    #Step 17
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application and Surgeon" selected in filter
    And the selected "Application and Surgeon" pop-up is highlighted at the top-left
    #Step 18
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 19
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  #And Data-Upload Application is closed
  @summarydashboard_SSR3692
  Scenario: TC2907 - Support staff_ Verify Summary Dashboard is filterable by surgeon, facility, application and status
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    When click settings page button from left menu
    When the user enters "1" in successful upload expiration textbox
    And the user enters "1" in unsuccessful upload expiration textbox
    When the user clicks on save button in settings
    When user clicks on Logout icon from left panel
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    And Upload dashboad page is displayed to user
    #    Given Ensure at least 2 image upload records with different surgeon , site , application and file status are available on upload dashboard screen
    #Step 2
    Then the records which is uploaded within 24 hours are displayed
    #Step 3
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 4
    When the user click on + for "Surgeon" and select a "surgeon" from the list and click on done button
    And the selected "surgeon name" pop-up is highlighted at the top-left
    Then the records are filtered out as per the "Surgeon" selected in filter
    #Step 5
    When the user click on "x" on the pop-up
    And the "surgeon name" pop-up is disappeared
    #Step 6
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 7
    When the user click on + for "Site" and select a "site" from the list and click on done button
    Then the records are filtered out as per the "Site" selected in filter
    And the selected "site name" pop-up is highlighted at the top-left
    #Step 8
    When the user click on "x" on the pop-up
    Then the "site name" pop-up is disappeared
    #Step 9
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 10
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application" selected in filter
    And the selected "application name" pop-up is highlighted at the top-left
    #Step 11
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 12
    When the user click on + for "File status" and select a "File status" from the list and click on done button
    Then the records are filtered out as per the "Application and File status" selected in filter
    And the selected "application name and File status" pop-up is highlighted at the top-left
    #Step 13
    When the user click on "x" on the pop-up
    When the user selects 24hrs filters on dashboard
    #Step 14
    Then the 24 hrs filter is highlighted in Upload dashboard screen
    Then the records which is uploaded within 24 hours are displayed
    #Step 15
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 16
    When the user click on + for "Surgeon" and select a "surgeon"
    Then the selected "surgeon name" is highlighted under the surgeon filter
    #Step 17
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application and Surgeon" selected in filter
    And the selected "Application and Surgeon" pop-up is highlighted at the top-left
    #Step 18
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 19
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  #And Data-Upload Application is closed
  @summarydashboard_SSR3692
  Scenario: TC2908 - S&N HIL Manager_ Verify Summary Dashboard is filterable by surgeon, facility, application and status
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    When click settings page button from left menu
    When the user enters "1" in successful upload expiration textbox
    And the user enters "1" in unsuccessful upload expiration textbox
    When the user clicks on save button in settings
    When user clicks on Logout icon from left panel
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-snn-hil-manager@capgemini.com"
    And Choose Site screen is displayed
    #Step 2
    When user selects the site that IC admin belongs to
    And click on select button
    Then Upload dashboad page is displayed to user
    #Step 3
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
    #Step 4
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 5
    When the user click on + for "Surgeon" and select a "surgeon" from the list and click on done button
    And the selected "surgeon name" pop-up is highlighted at the top-left
    Then the records are filtered out as per the "Surgeon" selected in filter
    #Step 6
    When the user selects 24hrs filters on dashboard
    Then the 24 hrs filter is highlighted in Upload dashboard screen
    Then the records which is uploaded within 24 hours are displayed
    And the "surgeon name" pop-up is disappeared
    #Step 7
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 8
    When the user click on + for "Site" and select a "site" from the list and click on done button
    Then the records are filtered out as per the "Site" selected in filter
    And the selected "site name" pop-up is highlighted at the top-left
    #Step 9
    When the user click on "x" on the pop-up
    Then the "site name" pop-up is disappeared
    #Step 10
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 11
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application" selected in filter
    And the selected "application name" pop-up is highlighted at the top-left
    #Step 12
    When the user click on "x" on the pop-up
    Then the "site name" pop-up is disappeared
    #Step 13
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 14
    When the user click on + for "File status" and select a "File status" from the list and click on done button
    #Then the records are filtered out as per the "Application and File status" selected in filter
    #And the selected "application name and File status" pop-up is highlighted at the top-left
    Then the records are filtered out as per the "File status" selected in filter
    And the selected "File status" pop-up is highlighted at the top-left
    #Step 15
    When the user click on "x" on the pop-up
    When the user selects 24hrs filters on dashboard
    #Step 16
    Then the 24 hrs filter is highlighted in Upload dashboard screen
    Then the records which is uploaded within 24 hours are displayed
    #Step 17
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 18
    When the user click on + for "Surgeon" and select a "surgeon"
    Then the selected "surgeon name" is highlighted under the surgeon filter
    #Step 19
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application and Surgeon" selected in filter
    And the selected "Application and Surgeon" pop-up is highlighted at the top-left
    #Step 20
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 21
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  #And Data-Upload Application is closed
  @summarydashboard_SSR3692
  Scenario Outline: TC0767 - IC admin_Verify the Upload dashboard screen displays error message when no data available for applied filter.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    And hrs filter is displayed at top-right of the Upload Dashboard screen
    When user clicks on Hours checkbox filter
    Then the text No data to display is displayed in upload dashboard screen
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |

  @summarydashboard_SSR3692
  Scenario Outline: TC2972 - IC Technician_Verify the Upload dashboard screen displays error message when no data available for applied filter.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    And hrs filter is displayed at top-right of the Upload Dashboard screen
    When user clicks on Hours checkbox filter
    Then the text No data to display is displayed in upload dashboard screen
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | ic-test-user@capgemini.com |

  @summarydashboard_SSR3692
  Scenario Outline: TC2973 - Hospital admin_Verify the Upload dashboard screen displays error message when no data available for applied filter.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    And hrs filter is displayed at top-right of the Upload Dashboard screen
    When user clicks on Hours checkbox filter
    Then the text No data to display is displayed in upload dashboard screen
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

    Examples: 
      | user                                 |
      | ic-test-hospital-admin@capgemini.com |

  @summarydashboard_SSR3692
  Scenario Outline: TC2974 - Surgeon _Verify the Upload dashboard screen displays error message when no data available for applied filter.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    And hrs filter is displayed at top-right of the Upload Dashboard screen
    When user clicks on Hours checkbox filter
    Then the text No data to display is displayed in upload dashboard screen
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

    Examples: 
      | user                          |
      | ic-test-surgeon@capgemini.com |

  @summarydashboard_SSR3692
  Scenario Outline: TC2975 - Support staff _Verify the Upload dashboard screen displays error message when no data available for applied filter.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    And hrs filter is displayed at top-right of the Upload Dashboard screen
    When user clicks on Hours checkbox filter
    Then the text No data to display is displayed in upload dashboard screen
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-staff@capgemini.com |
