Feature: SSR3090 - Data Upload Utility web application summary dashboard shall be searchable by any of the fields including surgeon name, patient name, application name, facility name, status, and date of birth

  @summarydashboard_SSR3090
  Scenario: TC2930 - S&N HIL Manager_Verify the DUU web app upload dashboard is searchable by surgeon name, patient name, application name, facility name, status and date of birth
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-snn-hil-manager@capgemini.com"
    #    Given Ensure at least 2 image upload records with different surgeon , site , application and file status are available on upload dashboard screen
    ##################################
    #below steps are not valid for the testcase
    #When click settings page button from left menu
    #When the user enters "1" in successful upload expiration textbox
    #And the user enters "1" in unsuccessful upload expiration textbox
    #When the user clicks on save button in settings
    ##################################
    Then Choose Site screen is displayed
    #Step 2
    When clicks on any of the faclity from the facility selection screen
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
    #Step 16
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    #Step 17
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 18
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

