Feature: SSR2331 - Data Upload Utility web application summary dashboard shall be searchable by any of the fields including surgeon name, patient name, application name, facility name, status, and date of birth

  @summarydashboard_SSR2331
  Scenario: TC0698 - IC admin_Verify the DUU web app upload dashboard is searchable by surgeon name, patient name, application name, facility name, file status and date of birth
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    #Given Ensure at least 2 image upload records with different surgeon , site , application and file status are available on upload dashboard screen
    When click settings page button from left menu
    When the user enters "1" in successful upload expiration textbox
    And the user enters "1" in unsuccessful upload expiration textbox
    When the user clicks on save button in settings
    When the user clicks on dashbaord button from left menu bar
    Then the records which is uploaded within 24 hours are displayed
    Then the Searchbox shall be displayed
    And the search button shall be displayed
    When Enter the "surgeon name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "surgeon name"
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    When Enter the "patient name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "patient name"
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    When Enter the "application name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "application name"
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    When Enter the "site name" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "site name"
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    When Enter the "file status" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "file status"
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed 
    When Enter the "DOB" in Search bar and click on Search button
    Then the image upload record details are filtered with searched "DOB"
    When the user clears the search bar
    Then the records which is uploaded within 24 hours are displayed
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

