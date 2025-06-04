Feature: SSR1827 - Data Upload Utility web application summary dashboard shall be filterable by surgeon, facility, application and status

  @summarydashboard_TC0583
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
  @summarydashboard_TC2904
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
  @summarydashboard_TC2905
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

  @summarydashboard_TC2906
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

  @summarydashboard_TC2907
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

  @summarydashboard_TC2908
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

  @summarydashboard_TC1208
  Scenario: TC1208 - IC admin _ Verify the selected filtered value to be removed when the user clicks on the selected filtered value
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    #Given Ensure at least 2 image upload records with different surgeon , site , application and file status are available on upload dashboard screen
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
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Surgeon"
    Then the selected "surgeon name" is highlighted under the surgeon filter
    #Step 6
    When the user click on selected "surgeon name"
    Then the selected "surgeon name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
    #Step7
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
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Site"
    Then the selected "site name" is highlighted under the surgeon filter
    #Step 10
    When the user click on selected "site name"
    Then the selected "site name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
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
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application" selected in filter
    And the selected "application name" pop-up is highlighted at the top-left
    #Step 13
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Application"
    Then the selected "application name" is highlighted under the surgeon filter
    #Step 14
    When the user click on selected "application name"
    Then the selected "application name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
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
    When the user click on + for "File status" and select a "File status" from the list and click on done button
    Then the records are filtered out as per the "File status" selected in filter
    And the selected "File status" pop-up is highlighted at the top-left
    #Step 17
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "File status"
    Then the selected "file status" is highlighted under the surgeon filter
    #Step 18
    When the user click on selected "File status"
    Then the selected "File status" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
    #Step 19
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @summarydashboard_TC2909
  Scenario: TC2909 - IC Technician _ Verify the selected filtered value to be removed when the user clicks on the selected filtered value
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
    #Given Ensure at least 2 image upload records with different surgeon , site , application and file status are available on upload dashboard screen
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
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Surgeon"
    Then the selected "surgeon name" is highlighted under the surgeon filter
    #Step 6
    When the user click on selected "surgeon name"
    Then the selected "surgeon name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
    #Step7
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
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Site"
    Then the selected "site name" is highlighted under the surgeon filter
    #Step 10
    When the user click on selected "site name"
    Then the selected "site name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
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
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application" selected in filter
    And the selected "application name" pop-up is highlighted at the top-left
    #Step 13
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Application"
    Then the selected "application name" is highlighted under the surgeon filter
    #Step 14
    When the user click on selected "application name"
    Then the selected "application name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
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
    When the user click on + for "File status" and select a "File status" from the list and click on done button
    Then the records are filtered out as per the "File status" selected in filter
    And the selected "File status" pop-up is highlighted at the top-left
    #Step 17
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "File status"
    Then the selected "file status" is highlighted under the surgeon filter
    #Step 18
    When the user click on selected "File status"
    Then the selected "File status" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
    #Step 19
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @summarydashboard_TC2910
  Scenario: TC2910 - Hospital admin _ Verify the selected filtered value to be removed when the user clicks on the selected filtered value
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    #Given Ensure at least 2 image upload records with different surgeon , site , application and file status are available on upload dashboard screen
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
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Surgeon"
    Then the selected "surgeon name" is highlighted under the surgeon filter
    #Step 6
    When the user click on selected "surgeon name"
    Then the selected "surgeon name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
    #Step7
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
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Site"
    Then the selected "site name" is highlighted under the surgeon filter
    #Step 10
    When the user click on selected "site name"
    Then the selected "site name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
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
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application" selected in filter
    And the selected "application name" pop-up is highlighted at the top-left
    #Step 13
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Application"
    Then the selected "application name" is highlighted under the surgeon filter
    #Step 14
    When the user click on selected "application name"
    Then the selected "application name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
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
    When the user click on + for "File status" and select a "File status" from the list and click on done button
    Then the records are filtered out as per the "File status" selected in filter
    And the selected "File status" pop-up is highlighted at the top-left
    #Step 17
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "File status"
    Then the selected "file status" is highlighted under the surgeon filter
    #Step 18
    When the user click on selected "File status"
    Then the selected "File status" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
    #Step 19
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @summarydashboard_TC2911
  Scenario: TC2911 - Surgeon _ Verify the selected filtered value to be removed when the user clicks on the selected filtered value
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
    #Given Ensure at least 2 image upload records with different surgeon , site , application and file status are available on upload dashboard screen
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
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Surgeon"
    Then the selected "surgeon name" is highlighted under the surgeon filter
    #Step 6
    When the user click on selected "surgeon name"
    Then the selected "surgeon name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
    #Step7
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
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Site"
    Then the selected "site name" is highlighted under the surgeon filter
    #Step 10
    When the user click on selected "site name"
    Then the selected "site name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
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
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application" selected in filter
    And the selected "application name" pop-up is highlighted at the top-left
    #Step 13
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Application"
    Then the selected "application name" is highlighted under the surgeon filter
    #Step 14
    When the user click on selected "application name"
    Then the selected "application name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
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
    When the user click on + for "File status" and select a "File status" from the list and click on done button
    Then the records are filtered out as per the "File status" selected in filter
    And the selected "File status" pop-up is highlighted at the top-left
    #Step 17
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "File status"
    Then the selected "file status" is highlighted under the surgeon filter
    #Step 18
    When the user click on selected "File status"
    Then the selected "File status" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
    #Step 19
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @summarydashboard_TC2912
  Scenario: TC2912 - Support staff _ Verify the selected filtered value to be removed when the user clicks on the selected filtered value
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
    #Given Ensure at least 2 image upload records with different surgeon , site , application and file status are available on upload dashboard screen
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
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Surgeon"
    Then the selected "surgeon name" is highlighted under the surgeon filter
    #Step 6
    When the user click on selected "surgeon name"
    Then the selected "surgeon name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
    #Step7
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
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Site"
    Then the selected "site name" is highlighted under the surgeon filter
    #Step 10
    When the user click on selected "site name"
    Then the selected "site name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
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
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application" selected in filter
    And the selected "application name" pop-up is highlighted at the top-left
    #Step 13
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Application"
    Then the selected "application name" is highlighted under the surgeon filter
    #Step 14
    When the user click on selected "application name"
    Then the selected "application name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
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
    When the user click on + for "File status" and select a "File status" from the list and click on done button
    Then the records are filtered out as per the "File status" selected in filter
    And the selected "File status" pop-up is highlighted at the top-left
    #Step 17
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "File status"
    Then the selected "file status" is highlighted under the surgeon filter
    #Step 18
    When the user click on selected "File status"
    Then the selected "File status" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
    #Step 19
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @summarydashboard_TC2913
  Scenario: TC2913 - S&N HIL Manager _ Verify the selected filtered value to be removed when the user clicks on the selected filtered value
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
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Surgeon"
    Then the selected "surgeon name" is highlighted under the surgeon filter
    #Step 7
    When the user click on selected "surgeon name"
    Then the selected "surgeon name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
    #Step 8
    When User clicks on Filter button from upload dashboard page
    Then the following filter menu shall be displayed
     | menu        |
      | date        |
      | surgeon     |
      | site        |
      | application |
      | file status |
    #Step 9
    When the user click on + for "Site" and select a "site" from the list and click on done button
    Then the records are filtered out as per the "Site" selected in filter
    And the selected "site name" pop-up is highlighted at the top-left
    #Step 10
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Site"
    Then the selected "site name" is highlighted under the surgeon filter
    #Step 11
    When the user click on selected "site name"
    Then the selected "site name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
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
    When the user click on + for "Application" and select a "application" from the list and click on done button
    Then the records are filtered out as per the "Application" selected in filter
    And the selected "application name" pop-up is highlighted at the top-left
    #Step 14
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "Application"
    Then the selected "application name" is highlighted under the surgeon filter
    #Step 15
    When the user click on selected "application name"
    Then the selected "application name" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
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
    When the user click on + for "File status" and select a "File status" from the list and click on done button
    Then the records are filtered out as per the "File status" selected in filter
    And the selected "File status" pop-up is highlighted at the top-left
    #Step 18
    When User clicks on Filter button from upload dashboard page
    When the user click on + for "File status"
    Then the selected "file status" is highlighted under the surgeon filter
    #Step 19
    When the user click on selected "File status"
    Then the selected "File status" is not highlighted and unselected
    When user clicks done button in filter menu
    Then the image upload details recorded in precondition is displayed in the Upload dashboard screen
    #Step 20
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 21
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed
