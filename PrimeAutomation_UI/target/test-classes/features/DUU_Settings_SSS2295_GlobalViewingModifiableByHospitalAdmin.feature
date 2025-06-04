Feature: SSR1728 - Data Upload Utility web application shall allow Admin user to modify setting to allow Non-Admin user to view upload activity of all users from the same facility in the summary dashboard and the history table

  Scenario Outline: TC1359 - Hospital Amin_Verify DUU allows Admin to modify successful and unsuccessful upload expiration setting value between 1 – 30 days and enables global viewing
    Given that the user is logged in to Data-Upload Utility Application through chrome "h-test-admin@capgemini.com"
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

    
    @1116
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
    
     @settings_TC0862
  Scenario Outline: TC0862 - IC Admin_Verify Global Viewing settings is modifiable by IC admin
   #Make sure successful and unsuccessful expiration is set to 14 days by default
  	Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Homepage is displayed to the user
    #Step2
    When click settings page button from left menu
    And disable global view setting
    #step3
  	When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #step4
    When Clicks on Upload Button
    #step5
    Then the Site selection screen is displayed
    When the user selects a site and click on next button
    Then the Site is selected
    #step6
		And the Surgeon selection screen is displayed
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		#step7
		And the Application selection screen is displayed
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		#step8
		When the user clicks on Browse PC button and select a valid DICOM file and upload
		Then the Upload successful screen is displayed
		#step9
		Then the user clicks file dashboard in left menu
		#step10
		And the user is able to view image upload records in dashboard
		#Step11
		Then the user clicks history in left menu
		#step12
		And the user is able to view image upload records in history
		#step13,14,15
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #Step16
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech1@capgemini.com"
  	And Homepage is displayed to the user
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
		#step17
		When the user clicks file dashboard in left menu
		#step18
		Then the user is able to view image upload records in dashboard
		#Step19
		When the user clicks history in left menu
		#step20,21
		Then the user is able to view image upload records in history
		#step22,23,24
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #step25
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech2@capgemini.com"
  	And Homepage is displayed to the user
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
		#step26
		When the user clicks file dashboard in left menu
		#Step27
		Then the user is able to view image upload records in dashboard
		#Step28
		When the user clicks history in left menu
		#step29,30
		Then the user is able to view image upload records in history
		#step31,32
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #step33
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
		And Homepage is displayed to the user
		#step34,#step35
		When the user clicks history in left menu
		#Step36
    When click settings page button from left menu
    And successful uploads text is displayed
    And unsuccessful uploads text is displayed
    And global viewing toggle is displayed
    And reset to default button is displayed and enabled
    And save button is displayed and disabled
    And settings page header is displayed
    #step37
    When turn on global view setting
    And click on Save Button
    #step38
		When the user clicks file dashboard in left menu
		#step39
		When the user clicks history in left menu
    #step40,41
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #step42
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech1@capgemini.com"
  	And Homepage is displayed to the user
  	#step43,  	#step44
		When the user clicks history in left menu
		#step45,46
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #step47
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech2@capgemini.com"
  	And Homepage is displayed to the user
  	#step48,#step49
		When the user clicks history in left menu
		#step50,51,52
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
  	
    
  @settings_TC1104
  Scenario Outline: TC1104 - Hospital Admin_Verify Global Viewing settings is modifiable by Hospital admin.
    #Make sure successful and unsuccessful expiration is set to 14 days by default
  	Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Homepage is displayed to the user
    #Step2
    When click settings page button from left menu
    And disable global view setting
    #step3
  	When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #step4
    When Clicks on Upload Button
    #step5
    Then the Site selection screen is displayed
    When the user selects a site and click on next button
    Then the Site is selected
    #step6
		And the Surgeon selection screen is displayed
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		#step7
		And the Application selection screen is displayed
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		#step8
		When the user clicks on Browse PC button and select a valid DICOM file and upload
		Then the Upload successful screen is displayed
		#step9
		Then the user clicks file dashboard in left menu
		#step10
		And the user is able to view image upload records in dashboard
		#Step11
		Then the user clicks history in left menu
		#step12
		And the user is able to view image upload records in history
		#step13,14,15
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #Step16
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech1@capgemini.com"
  	And Homepage is displayed to the user
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
		#step17
		When the user clicks file dashboard in left menu
		#step18
		Then the user is able to view image upload records in dashboard
		#Step19
		When the user clicks history in left menu
		#step20,21
		Then the user is able to view image upload records in history
		#step22,23,24
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #step25
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech2@capgemini.com"
  	And Homepage is displayed to the user
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
		#step26
		When the user clicks file dashboard in left menu
		#Step27
		Then the user is able to view image upload records in dashboard
		#Step28
		When the user clicks history in left menu
		#step29,30
		Then the user is able to view image upload records in history
		#step31,32
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #step33
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
		And Homepage is displayed to the user
		#step34,#step35
		When the user clicks history in left menu
		#Step36
    When click settings page button from left menu
    And successful uploads text is displayed
    And unsuccessful uploads text is displayed
    And global viewing toggle is displayed
    And reset to default button is displayed and enabled
    And save button is displayed and disabled
    And settings page header is displayed
    #step37
    When turn on global view setting
    And click on Save Button
    #step38
		When the user clicks file dashboard in left menu
		#step39
		When the user clicks history in left menu
    #step40,41
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #step42
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech1@capgemini.com"
  	And Homepage is displayed to the user
  	#step43,  	#step44
		When the user clicks history in left menu
		#step45,46
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #step47
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech2@capgemini.com"
  	And Homepage is displayed to the user
  	#step48,#step49
		When the user clicks history in left menu
		#step50,51,52
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
  	
    
    @settings_TC1107
    Scenario Outline: TC1107 - IC Admin_Verify UI of Settings screen
  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    #Step2
    When click settings page button from left menu
    Then successful uploads text is displayed
    And unsuccessful uploads text is displayed
    And global viewing toggle is displayed
    And reset to default button is displayed and enabled
    And save button is displayed and disabled
    And settings page header is displayed
    #Step3
    And the successful expiration unsuccessful expiration and global viewing shall be separated by line in grey color
    And settings text in left menu bar is green
    And the setting header shall be displayed in white color
    #And disable global view setting
    #Step4
    And the successful uploads textbox shall be displayed in green color
    And the successful uploads expiration text shall be displayed in white color
    And the number of days image uploads are shown on the dashboard before being archived text shall be displayed in white color
    When enter 20 into successful upload days input box
    Then the enterered value in upload successful textbox is displayed in green color
    #Step5
    Then the unsuccessful uploads textbox is displayed in green color
    And the unsuccessful uploads expiration text shall be displayed in white color
    And the number of days image uploads are shown on the dashboard before being archived text shall be displayed in white color
    When enter 20 into unsuccessful upload days input box
    Then the enterered value in upload unsuccessful textbox is displayed in green color
    #Step6
    Then turn on global view setting
    #Step7
    And save button is displayed and disabled
    And reset to default button is displayed and enabled
    #Step8
    When the user clicks on save button in settings
    #Step9
    And the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    #Step10
    When click settings page button from left menu
    Then the successful upload expiration shall be displayed as 20
    Then the unsuccessful upload expiration shall be displayed as 20
    #Step11
    And the global viewing shall be toggled on
    #Step12
    And the save button shall be in disabled
    #Step13
    And reset to default button is displayed and enabled
    #Step14    
    When enter negative number into successful upload days input box
    Then check successful upload days input box text color
    #Step15
    When enter negative number into unsuccessful upload days input box    
    Then check unsuccessful upload days input box text color
    #Step16
    When enter high number into successful upload days input box
    Then check successful upload days input box text color
     #Step17
    When enter special character into successful upload days input box
    Then check successful upload days input box text color
    #Stp18
    When enter negative number into unsuccessful upload days input box    
    Then check unsuccessful upload days input box text color
    #Step19
    When enter no value into successful upload days input box
    Then check successful upload days input box text color
    #Step20
    When enter high number into unsuccessful upload days input box
    Then check unsuccessful upload days input box text color
    #Step21
    And enter special character into unsuccessful upload days input box
    And check unsuccessful upload days input box text color
    #Step22
    Then reset to default button is displayed and enabled
    And save button is displayed and disabled
    #Step23
    Then disable global view setting
    And the global viewing text shall be displayed in white color
    #Step24,25
    When disable global view setting
    Then the setting screen shall be displayed with default values
    #Step26
    When User clicks on Upload files button from left menu bar 
	And the right side header shall be displayed as upload files
	#Step27
	Then click settings page button from left menu
	Then the setting screen shall be displayed with default values
	Then reset to default button is displayed and enabled
  And save button is displayed and disabled
  And reset to default button is displayed and enabled
  When the user clicks on exit to app button from left menu bar
	And user clicks on Logout icon from left panel
	Then user is logout from the application.

	Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
  
    @settings_TC1308
  Scenario Outline: TC1308 - Hospital Admin_Verify UI of Settings screen
  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    #Step2
    When click settings page button from left menu
    Then successful uploads text is displayed
    And unsuccessful uploads text is displayed
    And global viewing toggle is displayed
    And reset to default button is displayed and enabled
    And save button is displayed and disabled
    And settings page header is displayed
    #Step3
    And the successful expiration unsuccessful expiration and global viewing shall be separated by line in grey color
    And settings text in left menu bar is green
    And the setting header shall be displayed in white color
    #And disable global view setting
    #Step4
    And the successful uploads textbox shall be displayed in green color
    And the successful uploads expiration text shall be displayed in white color
    And the number of days image uploads are shown on the dashboard before being archived text shall be displayed in white color
    When enter 20 into successful upload days input box
    Then the enterered value in upload successful textbox is displayed in green color
    #Step5
    Then the unsuccessful uploads textbox is displayed in green color
    And the unsuccessful uploads expiration text shall be displayed in white color
    And the number of days image uploads are shown on the dashboard before being archived text shall be displayed in white color
    When enter 20 into unsuccessful upload days input box
    Then the enterered value in upload unsuccessful textbox is displayed in green color
    #Step6
    Then turn on global view setting
    #Step7
    And save button is displayed and disabled
    And reset to default button is displayed and enabled
    #Step8
    When the user clicks on save button in settings
    #Step9
    And the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    #Step10
    When click settings page button from left menu
    Then the successful upload expiration shall be displayed as 20
    Then the unsuccessful upload expiration shall be displayed as 20
    #Step11
    And the global viewing shall be toggled on
    #Step12
    And the save button shall be in disabled
    #Step13
    And reset to default button is displayed and enabled
    #Step14    
    When enter negative number into successful upload days input box
    Then check successful upload days input box text color
    #Step15
    When enter negative number into unsuccessful upload days input box    
    Then check unsuccessful upload days input box text color
    #Step16
    When enter high number into successful upload days input box
    Then check successful upload days input box text color
     #Step17
    When enter special character into successful upload days input box
    Then check successful upload days input box text color
    #Stp18
    When enter negative number into unsuccessful upload days input box    
    Then check unsuccessful upload days input box text color
    #Step19
    When enter no value into successful upload days input box
    Then check successful upload days input box text color
    #Step20
    When enter high number into unsuccessful upload days input box
    Then check unsuccessful upload days input box text color
    #Step21
    And enter special character into unsuccessful upload days input box
    And check unsuccessful upload days input box text color
    #Step22
    Then reset to default button is displayed and enabled
    And save button is displayed and disabled
    #Step23
    Then disable global view setting
    And the global viewing text shall be displayed in white color
    #Step24,25
    When disable global view setting
    Then the setting screen shall be displayed with default values
    #Step26
    When User clicks on Upload files button from left menu bar 
	And the right side header shall be displayed as upload files
	#Step27
	Then click settings page button from left menu
	Then the setting screen shall be displayed with default values
	Then reset to default button is displayed and enabled
  And save button is displayed and disabled
  And reset to default button is displayed and enabled
  When the user clicks on exit to app button from left menu bar
	And user clicks on Logout icon from left panel
	Then user is logout from the application.

	Examples: 
      | user                        |
      | ic-test-hospital-admin@capgemini.com |
    