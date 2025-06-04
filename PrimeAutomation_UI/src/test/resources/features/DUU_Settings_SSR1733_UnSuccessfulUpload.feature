
Feature: SSR1733 - Verifying Data Upload Utility web app shall set the default timeframe to persist an unsuccessful upload in the summary dashboard view to 14 days..

@settings_TC1298		
Scenario Outline: TC1298 - Hospital Admin_Verify DUU sets default successful and unsuccessful upload setting to 14 days.
	
	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    #Step2
    Then the user clicks file dashboard in left menu
    #And the entries on the dashboard are within the default 14 day range
    Then the user clicks the filter button in the top right
    And All fields are displayed in filter pop up
    #Step3
    Then click date filter + button
    And the start and end buttons are displayed
    #Step4
    Then user clicks start button in date filter
    When the user selects "5" date counting back from current date
     #Step5
    And the user clicks on end button
  	And the user selects end date as current date 	
  	And the user clicks on done button to close the filter option
  	#Step6
  	Then the upload dashboard shall displayed all successful and unsuccessful image upload details from "5" day date counting back from current date
    #Step7
    And user clears the filter from the top menu bar and checks dashboard entries to default
    #Step8 
  	And the records match the number as seen in the filter step
  	#Step9&10
    Then click settings page button from left menu
    And successful uploads text is displayed
    And unsuccessful uploads text is displayed
    And global viewing toggle is displayed
    And reset to default button is displayed and enabled
    And save button is displayed and disabled
    And settings page header is displayed
    And settings text in left menu bar is green
    And the setting screen shall be displayed with default values
    #Step11
    Then user enters 5 into successful and unsuccessful text boxes
    #Step12
   	And the user clicks file dashboard in left menu
   	And the records match the number as seen in the filter step
   	#Step13
   	Then click settings page button from left menu
    And successful uploads text is displayed
    And unsuccessful uploads text is displayed
    And global viewing toggle is displayed
    And reset to default button is displayed and enabled
    And save button is displayed and disabled
    And settings page header is displayed
    And settings text in left menu bar is green
    Then reset to default settings
    #Step14
    Then the user clicks file dashboard in left menu
    #Step15
    And the records match the default settings number
    When the user clicks on exit to app button from left menu bar
	And user clicks on Logout icon from left panel
	Then user is logout from the application. 
	
	Examples: 
		|user|  
		|ic-test-hospital-admin@capgemini.com |	
		
@settings_TC3468
Scenario Outline: TC3468 - Hospital Admin_Verify DUU displays error message when applied filter dates exceed the 14 day default value for successful and unsuccessful upload expiration settings.
  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    When user clicks on settings from left panel
    And reset to default settings
	  When user clicks on File dashboard from left panel
	  And the total number of records displayed on dashboard screen
    #Step2
    When the user clicks on filter button
    And the following filter menu shall be displayed
      | menu				|
      | filter by		|
      | date				|
      | surgeon			|
      | site				|
      | application	|
      | file status	|
    #step3
    Then click date filter + button
    And the start and end buttons are displayed
    #step4
    When the user clicks on start button	
    And the user selects "16" date counting back from current date
    #Step5
    And the user clicks on end button
  	And the user selects "15" date counting back from current date	
  	And the user clicks on done button to close the filter option
  	#step6,7
  	Then the error message as Failed to retrieve data contact your administrator shall be displayed
  	#step8
  	When the user clicks on filter button
  	Then click date filter + button
    And the start and end buttons are displayed
    #step9
    When the user clicks on clear button to remove selected
    And the user clicks on done button to close the filter option
    And the user removes date filter
    And the upload dashboard screen shall display same number of records
    #step10,11,12
    When the user clicks on exit to app button from left menu bar
	And user clicks on Logout icon from left panel
	Then user is logout from the application.

	
	Examples: 
		|user|  
		|ic-test-hospital-admin@capgemini.com|	
	
	
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
      
    @settings_TC3470
  Scenario Outline: TC3470 - IC Admin_Verify DUU displays error message when applied filter dates exceed the 14 day default value for successful and unsuccessful upload expiration settings.
  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    When user clicks on settings from left panel
    And reset to default settings
	  When user clicks on File dashboard from left panel
	  And the total number of records displayed on dashboard screen
    #Step2
    When the user clicks on filter button
    And the following filter menu shall be displayed
      | menu				|
      | filter by		|
      | date				|
      | surgeon			|
      | site				|
      | application	|
      | file status	|
    #step3
    Then click date filter + button
    And the start and end buttons are displayed
    #step4
    When the user clicks on start button	
    And the user selects "16" date counting back from current date
    #Step5
    And the user clicks on end button
  	And the user selects "15" date counting back from current date	
  	And the user clicks on done button to close the filter option
  	#step6,7
  	Then the error message as Failed to retrieve data contact your administrator shall be displayed
  	#step8
  	When the user clicks on filter button
  	Then click date filter + button
    And the start and end buttons are displayed
    #step9
    When the user clicks on clear button to remove selected
    And the user clicks on done button to close the filter option
    And the user removes date filter
    And the upload dashboard screen shall display same number of records
    #step10,11,12
    When the user clicks on exit to app button from left menu bar
	And user clicks on Logout icon from left panel
	Then user is logout from the application.

	Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |   
      
      
 @settings_TC0869
  Scenario Outline: TC0869 - IC Admin_Verify DUU sets default successful and unsuccessful upload setting to 14 days  
  	
  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    #Step2
    Then the user clicks file dashboard in left menu
    And the entries on the dashboard are within the default 14 day range
    Then the user clicks the filter button in the top right
    And All fields are displayed in filter pop up
    #Step3
    Then click date filter + button
    And the start and end buttons are displayed
    #Step4
    Then user clicks start button in date filter
    When the user selects "5" date counting back from current date
     #Step5
    And the user clicks on end button
  	And the user selects end date as current date 	
  	And the user clicks on done button to close the filter option
  	#Step6
  	Then the upload dashboard shall displayed all successful and unsuccessful image upload details from "5" day date counting back from current date
    #Step7
    And user clears the filter from the top menu bar and checks dashboard entries to default
    #Step8 
  	And the records match the number as seen in the filter step
  	#Step9&10
    Then click settings page button from left menu
    And successful uploads text is displayed
    And unsuccessful uploads text is displayed
    And global viewing toggle is displayed
    And reset to default button is displayed and enabled
    And save button is displayed and disabled
    And settings page header is displayed
    And settings text in left menu bar is green
    And the setting screen shall be displayed with default values
    #Step11
    Then user enters 5 into successful and unsuccessful text boxes
    #Step12
   	And the user clicks file dashboard in left menu
   	#And the records match the number as seen in the filter step
   	#Step13
   	Then click settings page button from left menu
    And successful uploads text is displayed
    And unsuccessful uploads text is displayed
    And global viewing toggle is displayed
    And reset to default button is displayed and enabled
    And save button is displayed and disabled
    And settings page header is displayed
    And settings text in left menu bar is green
    Then reset to default settings
    #Step14
    Then the user clicks file dashboard in left menu
    #Step15
    And the records match the default settings number
    When the user clicks on exit to app button from left menu bar
	And user clicks on Logout icon from left panel
	Then user is logout from the application. 

	Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |     