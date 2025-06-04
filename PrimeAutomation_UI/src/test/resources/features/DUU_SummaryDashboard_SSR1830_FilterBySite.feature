
Feature: SSR1830 - Data Upload Utility web application summary dashboard shall filter the list as search criteria are entered

 @summarydashboard_SSR1830
  Scenario: TC0698 - IC admin_Verify the DUU web app upload dashboard is searchable by surgeon name, patient name, application name, facility name, file status and date of birth
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    #Given Ensure at least 2 image upload records with different surgeon , site , application and file status are available on upload dashboard screen
    And Homepage is displayed to the user
    When click settings page button from left menu
    When the user enters "1" in successful upload expiration textbox
    And the user enters "1" in unsuccessful upload expiration textbox
    When the user clicks on save button in settings
    When the user clicks on dashbaord button from left menu bar
    #Step 2
    Then the records which is uploaded within 24 hours are displayed
    #Step 3
    Then the Searchbox shall be displayed
    And the search button shall be displayed
    #Step 4
    When Enter the "surgeon name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "surgeon name"
    #Step 5
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 6
    When Enter the "patient name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "patient name"
    #Step 7
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 8
    When Enter the "application name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "application name"
    #Step 9
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 10
    When Enter the "site name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "site name"
    #Step 11
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 12
    When Enter the "file status" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "file status"
    #Step 13
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 14
    When Enter the "DOB" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "DOB"
    #Step 15
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 16
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 17
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @summarydashboard_SSR1830
  Scenario: TC2926 - IC Technician_Verify the DUU web app upload dashboard is searchable by surgeon name, patient name, application name, facility name, status and date of birth
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
    Then the records which is uploaded within 24 hours are displayed
    #Step 3
    Then the Searchbox shall be displayed
    And the search button shall be displayed
    #Step 4
    When Enter the "surgeon name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "surgeon name"
    #Step 5
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 6
    When Enter the "patient name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "patient name"
    #Step 7
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 8
    When Enter the "application name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "application name"
    #Step 9
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 10
    When Enter the "site name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "site name"
    #Step 11
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 12
    When Enter the "file status" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "file status"
    #Step 13
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 14
    When Enter the "DOB" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "DOB"
    #Step 15 This step is not there in manual tescase. keeping for reference
    #When the user clears the search bar
    #Then the records which is uploaded within 24 hours are displayed
    #Step 16
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 17
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @summarydashboard_SSR1830
  Scenario: TC2927 - Hospital admin_Verify the DUU web app upload dashboard is searchable by surgeon name, patient name, application name, facility name, status and date of birth
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
    Then the records which is uploaded within 24 hours are displayed
    #Step 3
    Then the Searchbox shall be displayed
    And the search button shall be displayed
    #Step 4
    When Enter the "surgeon name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "surgeon name"
    #Step 5
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 6
    When Enter the "patient name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "patient name"
    #Step 7
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 8
    When Enter the "application name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "application name"
    #Step 9
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 10
    When Enter the "site name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "site name"
    #Step 11
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 12
    When Enter the "file status" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "file status"
    #Step 13
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 14
    When Enter the "DOB" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "DOB"
   #Step 15 This step is not there in manual tescase. keeping for reference
    #When the user clears the search bar
    #Then the records which is uploaded within 24 hours are displayed
    #Step 16
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 17
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @summarydashboard_SSR1830
  Scenario: TC2928 - Surgeon_Verify the DUU web app upload dashboard is searchable by surgeon name, patient name, application name, facility name, status and date of birth
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
    Then the records which is uploaded within 24 hours are displayed
    #Step 3
    Then the Searchbox shall be displayed
    And the search button shall be displayed
    #Step 4
    When Enter the "surgeon name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "surgeon name"
    #Step 5
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 6
    When Enter the "patient name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "patient name"
    #Step 7
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 8
    When Enter the "application name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "application name"
    #Step 9
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 10
    When Enter the "site name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "site name"
    #Step 11
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 12
    When Enter the "file status" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "file status"
    #Step 13
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 14
    When Enter the "DOB" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "DOB"
    #Step 15 This step is not there in manual tescase. keeping for reference
    #When the user clears the search bar
    #Then the records which is uploaded within 24 hours are displayed
    #Step 16
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 17
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @summarydashboard_SSR1830
  Scenario: TC2929 - Support staff_Verify the DUU web app upload dashboard is searchable by surgeon name, patient name, application name, facility name, status and date of birth
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
    Then the Searchbox shall be displayed
    And the search button shall be displayed
    #Step 4
    When Enter the "surgeon name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "surgeon name"
    #Step 5
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 6
    When Enter the "patient name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "patient name"
    #Step 7
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 8
    When Enter the "application name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "application name"
    #Step 9
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 10
    When Enter the "site name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "site name"
    #Step 11
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 12
    When Enter the "file status" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "file status"
    #Step 13
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 14
    When Enter the "DOB" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "DOB"
    #Step 15 This step is not there in manual tescase. keeping for reference
    #When the user clears the search bar
    #Then the records which is uploaded within 24 hours are displayed
    #Step 16
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 17
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @summarydashboard_SSR1830
  Scenario: TC2930 - S&N HIL Manager_Verify the DUU web app upload dashboard is searchable by surgeon name, patient name, application name, facility name, status and date of birth
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
    Then the records which is uploaded within 24 hours are displayed
    #Step 4
    Then the Searchbox shall be displayed
    And the search button shall be displayed
    #Step 5
    When Enter the "surgeon name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "surgeon name"
    #Step 6
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 7
    When Enter the "patient name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "patient name"
    #Step 8
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 9
    When Enter the "application name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "application name"
    #Step 10
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 11
    When Enter the "site name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "site name"
    #Step 12
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 13
    When Enter the "file status" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "file status"
    #Step 14
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 15
    When Enter the "DOB" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "DOB"
    #Step 16 This step is not there in manual tescase. keeping for reference
    #When the user clears the search bar
    #Then the records which is uploaded within 24 hours are displayed
    #Step 17
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 18
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @summarydashboard_SSR1830
  Scenario: TC0699 - IC admin _ Verify the search functionality using invalid data in Upload Dashboard screen
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
    Then the records which is uploaded within 24 hours are displayed
    #Step 3
    Then the Searchbox shall be displayed
    And the search button shall be displayed
    #Step 4
    When Enter invalid "surgeon name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 5
    When the user clears the search bar
    When Enter invalid "patient name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 6
    When the user clears the search bar
    When Enter invalid "application name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 7
    When the user clears the search bar
    When Enter invalid "site name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 8
    When the user clears the search bar
    When Enter invalid "file status" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 9
    When the user clears the search bar
    When Enter invalid "DOB" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 10
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 11
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @summarydashboard_SSR1830
  Scenario: TC02931 - IC Technician _ Verify the search functionality using invalid data in Upload Dashboard screen
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
    Then the records which is uploaded within 24 hours are displayed
    #Step 3
    Then the Searchbox shall be displayed
    And the search button shall be displayed
    #Step 4
    When Enter invalid "surgeon name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 5
    When the user clears the search bar
    When Enter invalid "patient name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 6
    When the user clears the search bar
    When Enter invalid "application name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 7
    When the user clears the search bar
    When Enter invalid "site name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 8
    When the user clears the search bar
    When Enter invalid "file status" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 9
    When the user clears the search bar
    When Enter invalid "DOB" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 10
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 11
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @summarydashboard_SSR1830
  Scenario: TC02932 - Hospital admin  _ Verify the search functionality using invalid data in Upload Dashboard screen
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
    Then the records which is uploaded within 24 hours are displayed
    #Step 3
    Then the Searchbox shall be displayed
    And the search button shall be displayed
    #Step 4
    When Enter invalid "surgeon name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 5
    When the user clears the search bar
    When Enter invalid "patient name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 6
    When the user clears the search bar
    When Enter invalid "application name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 7
    When the user clears the search bar
    When Enter invalid "site name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 8
    When the user clears the search bar
    When Enter invalid "file status" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 9
    When the user clears the search bar
    When Enter invalid "DOB" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 10
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 11
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @summarydashboard_SSR1830
  Scenario: TC02933 - Surgeon _ Verify the search functionality using invalid data in Upload Dashboard screen
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
    Then the records which is uploaded within 24 hours are displayed
    #Step 3
    Then the Searchbox shall be displayed
    And the search button shall be displayed
    #Step 4
    When Enter invalid "surgeon name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 5
    When the user clears the search bar
    When Enter invalid "patient name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 6
    When the user clears the search bar
    When Enter invalid "application name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 7
    When the user clears the search bar
    When Enter invalid "site name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 8
    When the user clears the search bar
    When Enter invalid "file status" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 9
    When the user clears the search bar
    When Enter invalid "DOB" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 10
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 11
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @summarydashboard_SSR1830
  Scenario: TC02934 - Support staff_ Verify the search functionality using invalid data in Upload Dashboard screen
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
    Then the Searchbox shall be displayed
    And the search button shall be displayed
    #Step 4
    When Enter invalid "surgeon name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 5
    When the user clears the search bar
    When Enter invalid "patient name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 6
    When the user clears the search bar
    When Enter invalid "application name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 7
    When the user clears the search bar
    When Enter invalid "site name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 8
    When the user clears the search bar
    When Enter invalid "file status" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 9
    When the user clears the search bar
    When Enter invalid "DOB" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 10
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 11
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @summarydashboard_SSR1830
  Scenario: TC2935 - S&N HIL Manager _ Verify the search functionality using invalid data in Upload Dashboard screen
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
    #    Given Ensure at least 2 image upload records with different surgeon , site , application and file status are available on upload dashboard screen
    #Step 2
    When user selects the site that IC admin belongs to
    And click on select button
    Then Upload dashboad page is displayed to user
    #Step 3
    Then the records which is uploaded within 24 hours are displayed
    #Step 4
    Then the Searchbox shall be displayed
    And the search button shall be displayed
    #Step 5
    When Enter invalid "surgeon name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 6
    When the user clears the search bar
    When Enter invalid "patient name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 7
    When the user clears the search bar
    When Enter invalid "application name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 8
    When the user clears the search bar
    When Enter invalid "site name" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 9
    When the user clears the search bar
    When Enter invalid "file status" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 10
    When the user clears the search bar
    When Enter invalid "DOB" in Search bar and click on Search button
    Then "No data to display" message is displayed
    #Step 11
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 12
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed
