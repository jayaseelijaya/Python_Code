Feature: SSR1731 - Data Upload Utility web app shall allow Admin user to set the timeframe to persist a successful upload in the summary dashboard view between 1-30 days

  @settings_TC1108
  Scenario Outline: TC1108 - IC Admin_Verify DUU allows Admin to modify unsuccessful upload expiration setting value between 1 – 30 days 
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And Upload dashboard page is displayed
    #And ensure 20 records should be present on summary dashboard screen uploaded  within 30 days and for all statuses
    When click settings page button from left menu
    Then the records match the default settings number
    #Step2
    When the user clicks on dashbaord button from left menu bar
    Then the upload dashboard shall displayed all successful and unsuccessful image upload details from "14" day date counting back from current date
    #Step3
    When the user clicks on filter button
    Then the following filter menu shall be displayed
      | menu				|
  		| filter by		|
  		| date				|
  		| surgeon			|
  		| site				|
  		| application	|
  		| file status	|
  	#Step4
  	When the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #Step5
    When the user clicks on start button	
    And the user selects "14" date counting back from current date
    #Step6
    When the user clicks on end button
  	And the user selects end date as current date 	
  	And the user clicks on done button to close the filter option
  	#Step7
  	Then the upload dashboard shall displayed all successful and unsuccessful image upload details from "14" day date counting back from current date
  	#Step8 
  	And the upload dashboard screen shall display same number of records
  	#Step9
  	When the user removes date filter
  	And the user clicks on filter button
  	#step
  	And the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #Step10
    When the user clicks on start button	
    And the user selects "10" date counting back from current date
    #Step11
    And the user clicks on end button
  	And the user selects end date as current date 	
  	And the user clicks on done button to close the filter option
  	Then the upload dashboard shall displayed all successful and unsuccessful image upload details from "10" day date counting back from current date
  	#Step12
  	When the user removes date filter
  	#Step13,#Step14
  	Then the upload dashboard screen shall display same number of records
  	#Step15
  	When the user clicks on filter button
  	And the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #Step16
    When the user clicks on start button	
    And the user selects "5" date counting back from current date
    #Step17
    And the user clicks on end button
  	And the user selects end date as current date 	
  	And the user clicks on done button to close the filter option
  	Then the upload dashboard shall displayed all successful and unsuccessful image upload details from "5" day date counting back from current date
  	#Step18
  	When the user removes date filter 
  	#Step19,	#Step20	
  	Then the upload dashboard screen shall display same number of records
  	#Step21
  	When click settings page button from left menu
  	Then the following components shall be displayed on right side of settings
      | settings                     |
      | heading											 |
      | successful expiration        |
      | unsuccessful expiration      |
      | global viewing toggle button |
      | reset to default             |
      | save button                  |
    #Step23  
  	When the user enters "10" in successful upload expiration textbox
  	#Step24
  	And the user enters "5" in unsuccessful upload expiration textbox
  	#Step25
  	When the user clicks on save button in settings
  	Then the value "10" shall be saved in successful upload expiration textbox
  	And the value "5" shall be saved in unsuccessful upload expiration textbox
  	#Step26
  	When the user clicks on dashbaord button from left menu bar
  	#Step27
  	Then the upload dashboard screen shall display same number of records
  	#Step28
  	When the user clicks on filter button
  	And the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #Step29
    When the user clicks on start button	
    And the user selects "15" date counting back from current date
    #Step30
    And the user clicks on end button
  	And the user selects end date as current date 	
  	And the user clicks on done button to close the filter option
  	#Step31
  	Then the upload dashboard shall displayed all successful and unsuccessful image upload details from "25" day date counting back from current date
  	When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application. 	
  	
        
  Examples: 
		|user|  
		|ic-test-admin@capgemini.com |  
		
 @settings_TC1360
  Scenario Outline: TC1360 - Hospital Admin_Verify DUU allows Admin to modify unsuccessful upload expiration setting value between 1 – 30 days 
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And Upload dashboard page is displayed
    #And ensure 20 records should be present on summary dashboard screen uploaded  within 30 days and for all statuses
    When click settings page button from left menu
    Then the records match the default settings number
    #Step2
    When the user clicks on dashbaord button from left menu bar
    Then the upload dashboard shall displayed all successful and unsuccessful image upload details from "14" day date counting back from current date
    #Step3
    When the user clicks on filter button
    Then the following filter menu shall be displayed
      | menu				|
  		| filter by		|
  		| date				|
  		| surgeon			|
  		| site				|
  		| application	|
  		| file status	|
  	#Step4
  	When the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #Step5
    When the user clicks on start button	
    And the user selects "14" date counting back from current date
    #Step6
    When the user clicks on end button
  	And the user selects end date as current date 	
  	And the user clicks on done button to close the filter option
  	#Step7
  	Then the upload dashboard shall displayed all successful and unsuccessful image upload details from "14" day date counting back from current date
  	#Step8 
  	And the upload dashboard screen shall display same number of records
  	#Step9
  	When the user removes date filter
  	And the user clicks on filter button
  	#step
  	And the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #Step10
    When the user clicks on start button	
    And the user selects "10" date counting back from current date
    #Step11
    And the user clicks on end button
  	And the user selects end date as current date 	
  	And the user clicks on done button to close the filter option
  	Then the upload dashboard shall displayed all successful and unsuccessful image upload details from "10" day date counting back from current date
  	#Step12
  	When the user removes date filter
  	#Step13,#Step14
  	Then the upload dashboard screen shall display same number of records
  	#Step15
  	When the user clicks on filter button
  	And the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #Step16
    When the user clicks on start button	
    And the user selects "5" date counting back from current date
    #Step17
    And the user clicks on end button
  	And the user selects end date as current date 	
  	And the user clicks on done button to close the filter option
  	Then the upload dashboard shall displayed all successful and unsuccessful image upload details from "5" day date counting back from current date
  	#Step18
  	When the user removes date filter 
  	#Step19,	#Step20	
  	Then the upload dashboard screen shall display same number of records
  	#Step21
  	When click settings page button from left menu
  	Then the following components shall be displayed on right side of settings
      | settings                     |
      | heading											 |
      | successful expiration        |
      | unsuccessful expiration      |
      | global viewing toggle button |
      | reset to default             |
      | save button                  |
    #Step23  
  	When the user enters "10" in successful upload expiration textbox
  	#Step24
  	And the user enters "5" in unsuccessful upload expiration textbox
  	#Step25
  	When the user clicks on save button in settings
  	Then the value "10" shall be saved in successful upload expiration textbox
  	And the value "5" shall be saved in unsuccessful upload expiration textbox
  	#Step26
  	When the user clicks on dashbaord button from left menu bar
  	#Step27
  	Then the upload dashboard screen shall display same number of records
  	#Step28
  	When the user clicks on filter button
  	And the user clicks on date filter menu option
    Then the start button and end button shall be displayed
    #Step29
    When the user clicks on start button	
    And the user selects "15" date counting back from current date
    #Step30
    And the user clicks on end button
  	And the user selects end date as current date 	
  	And the user clicks on done button to close the filter option
  	#Step31
  	Then the upload dashboard shall displayed all successful and unsuccessful image upload details from "25" day date counting back from current date
  	When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application. 	
  	
        
  Examples: 
		|user|  
		|ic-test-hospital-admin@capgemini.com |
		
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
    
 @settings_TC1111  
 Scenario Outline: TC1111 - IC Admin_Verify DUU does not allow Admin to set invalid values for successful and unsuccessful upload expiration settings 
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And Upload dashboard page is displayed
    #Step2
  	When click settings page button from left menu
  	Then the following components shall be displayed on right side of settings
      | settings                     |
      | heading											 |
      | successful expiration        |
      | unsuccessful expiration      |
      | global viewing toggle button |
      | reset to default             |
      | save button                  |
    #step3
     Then successful uploads text is displayed
    And unsuccessful uploads text is displayed
    And the number of days image uploads are shown on the dashboard before being archived text shall be displayed in white color
    #step4 
    When the user removes the value from successful upload expiration textbox  
  	And the user enters "31" in successful upload expiration textbox
  	Then the value "31" shall be displayed in successful upload expiration textbox
  	And the succcessful upload expiration input box borderline shall be displayed in red color
  	#step5
  	When the user removes the value from unsuccessful upload expiration textbox 
  	And the user enters "100" in unsuccessful upload expiration textbox
  	Then the value "100" shall be displayed in unsuccessful upload expiration textbox
  	And the unsucccessful upload expiration input box borderline shall be displayed in red color
  	#step6
  	And save button is displayed and disabled
  	And the user shall not be allowed to save "31" value
  	#step7
  	When the user removes the value from successful upload expiration textbox  
  	And the user enters "0" in successful upload expiration textbox
  	Then the value "0" shall be displayed in successful upload expiration textbox
  	And the succcessful upload expiration input box borderline shall be displayed in red color
  	#step8
  	When the user removes the value from unsuccessful upload expiration textbox 
  	And the user enters "0" in unsuccessful upload expiration textbox
  	Then the value "0" shall be displayed in unsuccessful upload expiration textbox
  	And the unsucccessful upload expiration input box borderline shall be displayed in red color
  	#step9
  	And save button is displayed and disabled
  	And the user shall not be allowed to save "0" value
  	#step10
  	When the user removes the value from successful upload expiration textbox
  	And the succcessful upload expiration input box borderline shall be displayed in red color 
  	#step11
  	When the user removes the value from unsuccessful upload expiration textbox
  	And the unsucccessful upload expiration input box borderline shall be displayed in red color
  	#step12
  	And save button is displayed and disabled
  	And the user shall not be allowed to save "blank" value
  	#step13
  	When the user removes the value from successful upload expiration textbox  
  	And the user enters "-1" in successful upload expiration textbox
  	Then the value "-1" shall be displayed in successful upload expiration textbox
  	And the succcessful upload expiration input box borderline shall be displayed in red color
  	#step14
  	When the user removes the value from unsuccessful upload expiration textbox 
  	And the user enters "-150" in unsuccessful upload expiration textbox
  	Then the value "-150" shall be displayed in unsuccessful upload expiration textbox
  	And the unsucccessful upload expiration input box borderline shall be displayed in red color
  	#step15
  	And save button is displayed and disabled
  	And the user shall not be allowed to save "-1" value
  	#step16
  	When the user removes the value from successful upload expiration textbox  
  	And the user enters "@a1" in successful upload expiration textbox
  	Then the value "@a1" shall be displayed in successful upload expiration textbox
  	And the succcessful upload expiration input box borderline shall be displayed in red color
  	#step17
  	When the user removes the value from unsuccessful upload expiration textbox 
  	And the user enters "&abc" in unsuccessful upload expiration textbox
  	Then the value "&abc" shall be displayed in unsuccessful upload expiration textbox
  	And the unsucccessful upload expiration input box borderline shall be displayed in red color
  	#step18
  	And save button is displayed and disabled
  	And the user shall not be allowed to save "@a1" value
  	#step19
  	When the user clicks on upload status button from left menu bar
  	Then the right side header shall be displayed as upload status
  	#step20
  	When click settings page button from left menu
  	Then the setting screen shall be displayed with default values
  	And disable global view setting
  	#step21,22,23
  	When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed  	
  	
        
  Examples: 
		|user|  
		|ic-test-admin@capgemini.com |  
  	
        
  Examples: 
		|user|  
		|ic-test-admin@capgemini.com |  
		
@settings_TC1361  
 Scenario Outline: TC1361 - Hospital Admin_Verify DUU does not allow Admin to set invalid values for successful and unsuccessful upload expiration settings 
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And Upload dashboard page is displayed
    #Step2
  	When click settings page button from left menu
  	Then the following components shall be displayed on right side of settings
      | settings                     |
      | heading											 |
      | successful expiration        |
      | unsuccessful expiration      |
      | global viewing toggle button |
      | reset to default             |
      | save button                  |
    #step3
     Then successful uploads text is displayed
    And unsuccessful uploads text is displayed
    And the number of days image uploads are shown on the dashboard before being archived text shall be displayed in white color
    #step4 
    When the user removes the value from successful upload expiration textbox  
  	And the user enters "31" in successful upload expiration textbox
  	Then the value "31" shall be displayed in successful upload expiration textbox
  	And the succcessful upload expiration input box borderline shall be displayed in red color
  	#step5
  	When the user removes the value from unsuccessful upload expiration textbox 
  	And the user enters "100" in unsuccessful upload expiration textbox
  	Then the value "100" shall be displayed in unsuccessful upload expiration textbox
  	And the unsucccessful upload expiration input box borderline shall be displayed in red color
  	#step6
  	And save button is displayed and disabled
  	And the user shall not be allowed to save "31" value
  	#step7
  	When the user removes the value from successful upload expiration textbox  
  	And the user enters "0" in successful upload expiration textbox
  	Then the value "0" shall be displayed in successful upload expiration textbox
  	And the succcessful upload expiration input box borderline shall be displayed in red color
  	#step8
  	When the user removes the value from unsuccessful upload expiration textbox 
  	And the user enters "0" in unsuccessful upload expiration textbox
  	Then the value "0" shall be displayed in unsuccessful upload expiration textbox
  	And the unsucccessful upload expiration input box borderline shall be displayed in red color
  	#step9
  	And save button is displayed and disabled
  	And the user shall not be allowed to save "0" value
  	#step10
  	When the user removes the value from successful upload expiration textbox
  	And the succcessful upload expiration input box borderline shall be displayed in red color 
  	#step11
  	When the user removes the value from unsuccessful upload expiration textbox
  	And the unsucccessful upload expiration input box borderline shall be displayed in red color
  	#step12
  	And save button is displayed and disabled
  	And the user shall not be allowed to save "blank" value
  	#step13
  	When the user removes the value from successful upload expiration textbox  
  	And the user enters "-1" in successful upload expiration textbox
  	Then the value "-1" shall be displayed in successful upload expiration textbox
  	And the succcessful upload expiration input box borderline shall be displayed in red color
  	#step14
  	When the user removes the value from unsuccessful upload expiration textbox 
  	And the user enters "-150" in unsuccessful upload expiration textbox
  	Then the value "-150" shall be displayed in unsuccessful upload expiration textbox
  	And the unsucccessful upload expiration input box borderline shall be displayed in red color
  	#step15
  	And save button is displayed and disabled
  	And the user shall not be allowed to save "-1" value
  	#step16
  	When the user removes the value from successful upload expiration textbox  
  	And the user enters "@a1" in successful upload expiration textbox
  	Then the value "@a1" shall be displayed in successful upload expiration textbox
  	And the succcessful upload expiration input box borderline shall be displayed in red color
  	#step17
  	When the user removes the value from unsuccessful upload expiration textbox 
  	And the user enters "&abc" in unsuccessful upload expiration textbox
  	Then the value "&abc" shall be displayed in unsuccessful upload expiration textbox
  	And the unsucccessful upload expiration input box borderline shall be displayed in red color
  	#step18
  	And save button is displayed and disabled
  	And the user shall not be allowed to save "@a1" value
  	#step19
  	When the user clicks on upload status button from left menu bar
  	Then the right side header shall be displayed as upload status
  	#step20
  	When click settings page button from left menu
  	Then the setting screen shall be displayed with default values
  	And disable global view setting
  	#step21,22,23
  	When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed  	
  	
        
  Examples: 
		|user|  
		|h-test-admin@capgemini.com |  		      				    