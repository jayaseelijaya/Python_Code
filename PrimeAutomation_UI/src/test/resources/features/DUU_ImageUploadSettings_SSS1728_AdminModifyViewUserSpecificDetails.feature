Feature: SSR1728 - Data Upload Utility web application shall allow Admin user to modify setting to allow Non-Admin user to view upload activity of all users from the same facility in the summary dashboard and the history table

	@settings_TC1359
  Scenario Outline: TC1359 - Hospital Amin_Verify DUU allows Admin to modify successful and unsuccessful upload expiration setting value between 1 – 30 days and enables global viewing
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Homepage is displayed to the user
    And Upload dashboard page is displayed
    #And Ensure 3 successful and 2 unsuccessful records should be present on summary dashboard screen uploaded  within 25 days and for all statues
    #And Ensure 5 successful and 5 unsuccessful records should be present on summary dashboard screen uploaded  within 20 days and for all statues Complete by hospital admin, Surgeon and Support staff
    #And Ensure Hospital admin has 2 successful and 1 unsuccessful uploads
    #And Ensure Surgeon has 2 successful and 3 unsuccessful uploads
    #And Ensure Support staff  has 1 successful and 1 unsuccessful uploads
    When click settings page button from left menu
    And disable global view setting
     When the user enters "25" in successful upload expiration textbox
    And the user enters "25" in unsuccessful upload expiration textbox
    When the user clicks on save button in settings
    Then the following components shall be displayed on right side of settings
      | settings                     |
      | heading                      |
      | successful expiration        |
      | unsuccessful expiration      |
      | global viewing toggle button |
      | reset to default             |
      | save button                  |
    Then an input box with "Successful Uploads Expiration" is displayed
    And "Number of days image uploads are shown on the dashboard before being archived (1-30)" text is displayed
    Then an input box with "successful Uploads Expiration" is displayed
    And "Number of days image uploads are shown on the dashboard before being archived (1-30)" text is displayed
    When the user enters "20" in successful upload expiration textbox
    And the user enters "20" in unsuccessful upload expiration textbox
    Then turn on global view setting
    When the user clicks on save button in settings
    Then the global settings is toggled on
    Then the value "20" shall be saved in successful upload expiration textbox
    And the value "20" shall be saved in unsuccessful upload expiration textbox
    And save button is displayed and disabled
    When the user clicks on dashbaord button from left menu bar
    Then the successful and unsuccessful records uploaded by hospital users within 20 days is only displayed
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

    
    @settings_TC1116
    Scenario Outline: TC1116 - IC Admin_Verify DUU allows Admin to modify successful and unsuccessful upload expiration setting value between 1 – 30 days and enables global viewing
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Homepage is displayed to the user
    And Upload dashboard page is displayed
    #And Ensure 3 successful and 2 unsuccessful records should be present on summary dashboard screen uploaded  within 25 days and for all statues
    #And Ensure 5 successful and 5 unsuccessful records should be present on summary dashboard screen uploaded  within 20 days and for all statues Complete by IC admin and IC technician
    #And Ensure IC admin has 3 successful and 2 unsuccessful uploads
    #And Ensure IC Technician has 2 successful and 3 unsuccessful uploads
    When click settings page button from left menu
    And disable global view setting
     When the user enters "25" in successful upload expiration textbox
    And the user enters "25" in unsuccessful upload expiration textbox
    When the user clicks on save button in settings
    Then the following components shall be displayed on right side of settings
      | settings                     |
      | heading                      |
      | successful expiration        |
      | unsuccessful expiration      |
      | global viewing toggle button |
      | reset to default             |
      | save button                  |
    Then an input box with "Successful Uploads Expiration" is displayed
    And "Number of days image uploads are shown on the dashboard before being archived (1-30)" text is displayed
    Then an input box with "successful Uploads Expiration" is displayed
    And "Number of days image uploads are shown on the dashboard before being archived (1-30)" text is displayed
    When the user enters "20" in successful upload expiration textbox
    And the user enters "20" in unsuccessful upload expiration textbox
    Then turn on global view setting
    When the user clicks on save button in settings
    Then the global settings is toggled on
    Then the value "20" shall be saved in successful upload expiration textbox
    And the value "20" shall be saved in unsuccessful upload expiration textbox
    And save button is displayed and disabled
    When the user clicks on dashbaord button from left menu bar
    Then the successful and unsuccessful records uploaded by ic users within 20 days is only displayed
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed
    
    @settings_SSR1728
  Scenario Outline: TC0862 - IC Admin_Verify Global Viewing settings is modifiable by IC admin
  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    When click settings page button from left menu
    And disable global view setting
  	When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    When Clicks on Upload Button
    Then the Site selection screen is displayed
    When the user selects a site and click on next button
    Then the Site is selected
		And the Surgeon selection screen is displayed
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		When the user clicks on Browse PC button and select a valid DICOM file and upload
		Then the Upload successful screen is displayed
		Then the user clicks file dashboard in left menu
		And the user is able to view image upload records in dashboard
		Then the user clicks history in left menu
		And the user is able to view image upload records in history
		Then the user clicks file dashboard in left menu
		Then click settings page button from left menu
		And turn on global view setting
		Then the user clicks file dashboard in left menu
		And the user clicks history in left menu
		And Data-Upload Application is closed
    
    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
      #ic-test-tech1@capgemini.com 
      #ic-test-tech2@capgemini.com
  
  @settings_SSR1728
  Scenario Outline: TC1104 - Hospital Admin_Verify Global Viewing settings is modifiable by Hospital admin.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    When click settings page button from left menu
    And disable global view setting
  	When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    When Clicks on Upload Button
    Then the Site selection screen is displayed
    When the user selects a site and click on next button
    Then the Site is selected
		And the Surgeon selection screen is displayed
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		When the user clicks on Browse PC button and select a valid DICOM file and upload
		Then the Upload successful screen is displayed
		Then the user clicks file dashboard in left menu
		And the user is able to view image upload records in dashboard
		Then the user clicks history in left menu
		And the user is able to view image upload records in history
		Then the user clicks file dashboard in left menu
		Then click settings page button from left menu
		And turn on global view setting
		Then the user clicks file dashboard in left menu
		And the user clicks history in left menu
		And Data-Upload Application is closed
		
		Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
      #h-test-admin@capgemini.com
      #ic-test-surgeon@capgemini.com
      #ic-test-supportstaff@capgemini.com
      
      @settings_SSR1728
      Scenario Outline: TC1107 - IC Admin_Verify UI of Settings screen
  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    When click settings page button from left menu
    And successful uploads text is displayed
    And unsuccessful uploads text is displayed
    And global viewing toggle is displayed
    And reset to default button is displayed and enabled
    And save button is displayed and disabled
    And settings page header is displayed
    And cosmetic lines are displayed
    And settings text in left menu bar is green
    And disable global view setting
    Then enter 20 into successful upload days input box
    And enter 20 into unsuccessful upload days input box
    Then turn on global view setting
    When the user clicks on upload status from left menu bar
    Then click settings page button from left menu
    And save button is displayed and disabled
    And reset to default button is displayed and enabled
    Then enter negative number into successful upload days input box
    And enter negative number into unsuccessful upload days input box
    Then check successful upload days input box text color
    And check unsuccessful upload days input box text color
    Then enter no value into successful upload days input box
    And enter no value into unsuccessful upload days input box
    Then check successful upload days input box text color
    And check unsuccessful upload days input box text color
    Then enter high number into successful upload days input box
    And enter high number into unsuccessful upload days input box
    Then check successful upload days input box text color
    And check unsuccessful upload days input box text color
    Then enter special character into successful upload days input box
    And enter special character into unsuccessful upload days input box
    Then check successful upload days input box text color
    And check unsuccessful upload days input box text color
    Then reset to default button is displayed and enabled
    And save button is displayed and disabled
    Then disable global view setting
    When the user clicks on upload status from left menu bar
    Then click settings page button from left menu
    And successful uploads text is displayed
    And unsuccessful uploads text is displayed
    And global viewing toggle is displayed
    And reset to default button is displayed and enabled
    And save button is displayed and disabled
    And settings page header is displayed
    And cosmetic lines are displayed
    And settings text in left menu bar is green
    And Data-Upload Application is closed

	Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
  
  @settings_SSR1728
  Scenario Outline: TC1308 - Hospital Admin_Verify UI of Settings screen
		Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    When click settings page button from left menu
    And successful uploads text is displayed
    And unsuccessful uploads text is displayed
    And global viewing toggle is displayed
    And reset to default button is displayed and enabled
    And save button is displayed and disabled
    And settings page header is displayed
    And cosmetic lines are displayed
    And settings text in left menu bar is green
    And disable global view setting
    Then enter 20 into successful upload days input box
    And enter 20 into unsuccessful upload days input box
    Then turn on global view setting
    When the user clicks on upload status from left menu bar
    Then click settings page button from left menu
    And save button is displayed and disabled
    And reset to default button is displayed and enabled
    Then enter negative number into successful upload days input box
    And enter negative number into unsuccessful upload days input box
    Then check successful upload days input box text color
    And check unsuccessful upload days input box text color
    Then enter no value into successful upload days input box
    And enter no value into unsuccessful upload days input box
    Then check successful upload days input box text color
    And check unsuccessful upload days input box text color
    Then enter high number into successful upload days input box
    And enter high number into unsuccessful upload days input box
    Then check successful upload days input box text color
    And check unsuccessful upload days input box text color
    Then enter special character into successful upload days input box
    And enter special character into unsuccessful upload days input box
    Then check successful upload days input box text color
    And check unsuccessful upload days input box text color
    Then reset to default button is displayed and enabled
    And save button is displayed and disabled
    Then disable global view setting
    When the user clicks on upload status from left menu bar
    Then click settings page button from left menu
    And successful uploads text is displayed
    And unsuccessful uploads text is displayed
    And global viewing toggle is displayed
    And reset to default button is displayed and enabled
    And save button is displayed and disabled
    And settings page header is displayed
    And cosmetic lines are displayed
    And settings text in left menu bar is green
    And Data-Upload Application is closed
    
	Examples: 
      | user                        |
      | ic-test-hospital-admin@capgemini.com |
    