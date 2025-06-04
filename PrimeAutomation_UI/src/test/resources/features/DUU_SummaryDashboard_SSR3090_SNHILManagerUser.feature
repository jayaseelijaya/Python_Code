Feature: SSR3090 - The System shall support a S&N HIL Manager user type

  @summarydashboard_SSR3090
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