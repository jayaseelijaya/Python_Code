
Feature: SSR1807 - Verifying landing page of currently selected activity tab

@login_TC0847
Scenario Outline: TC0847 - IC Admin_Verify the system indicates which activity tab is currently selected in the landing page status ribbon

  Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
	Then Homepage is displayed 
	##Step 2
		When the user clicks on settings button from left menu bar
	Then the settings shall be higlighted in left menu bar
	And the right side header shall be displayed as settings
	##Step 3
	When the user clicks on dashbaord button from left menu bar
	Then the dashbaord shall be higlighted in left menu bar
	And the right side header shall be displayed as upload dashboard
	##Step 4
	When User clicks on Upload files button from left menu bar 
	Then the upload files shall be higlighted in left menu bar
	And the right side header shall be displayed as upload files
	##Step 5
	When the user clicks on upload status button from left menu bar
	Then the upload status shall be higlighted in left menu bar
	And the right side header shall be displayed as upload status
	##Step 6
	When the user clicks on history button from left menu bar
	Then the history shall be higlighted in left menu bar
	And the right side header shall be displayed as history
	##Step 7
	When the user clicks on audit log button from left menu bar
	Then the audit log shall be higlighted in left menu bar
	And the right side header shall be displayed as audit log
	##Step 8
	When the user clicks on imaging links button from left menu bar
	Then the imaging links shall be higlighted in left menu bar
	And the right side header shall be displayed as provider links
	##Step 9
	When the user clicks on exit to app button from left menu bar
	Then the Application access screen is displayed
	When user clicks on Logout icon from left panel
  Then user is logout from the application.
#	And Data-Upload Application is closed 
 
 Examples: 
		|user|  
		|ic-test-admin@capgemini.com |
		
		

   @login_TC3128 
Scenario Outline: TC3128 - IC Technician_Verify the system indicates which activity tab is currently selected in the landing page status ribbon

  Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
	Then Homepage is displayed 
	##Step 2
	When User clicks on Upload files button from left menu bar 
	Then the upload files shall be higlighted in left menu bar
	And the right side header shall be displayed as upload files
	##Step 3
	When the user clicks on dashbaord button from left menu bar
	Then the dashbaord shall be higlighted in left menu bar
	And the right side header shall be displayed as upload dashboard
	##Step 4
	When the user clicks on upload status button from left menu bar
	Then the upload status shall be higlighted in left menu bar
	And the right side header shall be displayed as upload status
	##Step 5
	When the user clicks on history button from left menu bar
	Then the history shall be higlighted in left menu bar
	And the right side header shall be displayed as history
	##Step 6
		When the user clicks on exit to app button from left menu bar
	Then the Application access screen is displayed
	When user clicks on Logout icon from left panel
  Then user is logout from the application.
#	And Data-Upload Application is closed 
 
 Examples: 
		|user|  
		|ic-test-user@capgemini.com |
		
		@login_TC3129
Scenario Outline: TC3129 - Hospital Admin_Verify the system indicates which activity tab is currently selected in the landing page status ribbon

  Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
	Then Homepage is displayed 
	##Step 2
	When the user clicks on settings button from left menu bar
	Then the settings shall be higlighted in left menu bar
	And the right side header shall be displayed as settings
	##Step 3
	When the user clicks on dashbaord button from left menu bar
	Then the dashbaord shall be higlighted in left menu bar
	And the right side header shall be displayed as upload dashboard
	##Step 4
	When User clicks on Upload files button from left menu bar 
	Then the upload files shall be higlighted in left menu bar
	And the right side header shall be displayed as upload files
	##Step 5
	When the user clicks on upload status button from left menu bar
	Then the upload status shall be higlighted in left menu bar
	And the right side header shall be displayed as upload status
	##Step 6
	When the user clicks on history button from left menu bar
	Then the history shall be higlighted in left menu bar
	And the right side header shall be displayed as history
	##Step 7
	When the user clicks on audit log button from left menu bar
	Then the audit log shall be higlighted in left menu bar
	And the right side header shall be displayed as audit log
	##Step 8
	When the user clicks on imaging links button from left menu bar
	Then the imaging links shall be higlighted in left menu bar
	And the right side header shall be displayed as provider links
	##Step 9
		When the user clicks on exit to app button from left menu bar
	Then the Application access screen is displayed
	When user clicks on Logout icon from left panel
  Then user is logout from the application.
#	And Data-Upload Application is closed 

 Examples: 
		|user|  
		|	ic-test-hospital-admin@capgemini.com |
	
	@login_TC3130	
Scenario Outline: TC3130 - Surgeon_Verify the system indicates which activity tab is currently selected in the landing page status ribbon

  Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
	Then Homepage is displayed 
	##Step 2
	When User clicks on Upload files button from left menu bar 
	Then the upload files shall be higlighted in left menu bar
	And the right side header shall be displayed as upload files
	##Step 3
	When the user clicks on dashbaord button from left menu bar
	Then the dashbaord shall be higlighted in left menu bar
	And the right side header shall be displayed as upload dashboard
	##Step 4
	When the user clicks on upload status button from left menu bar
	Then the upload status shall be higlighted in left menu bar
	And the right side header shall be displayed as upload status
	##Step 5
	When the user clicks on history button from left menu bar
	Then the history shall be higlighted in left menu bar
	And the right side header shall be displayed as history
	 ##Step 6
		When the user clicks on exit to app button from left menu bar
	Then the Application access screen is displayed
	When user clicks on Logout icon from left panel
  Then user is logout from the application.
#	And Data-Upload Application is closed 
 
 Examples: 
		|user|  
		|ic-test-surgeon@capgemini.com |
	
 @login_TC3131				
Scenario Outline: TC3131 - Support Staff_Verify the system indicates which activity tab is currently selected in the landing page status ribbon

  Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
	Then Homepage is displayed 
	##Step 2
	When User clicks on Upload files button from left menu bar 
	Then the upload files shall be higlighted in left menu bar
	And the right side header shall be displayed as upload files
	##Step 3
	When the user clicks on dashbaord button from left menu bar
	Then the dashbaord shall be higlighted in left menu bar
	And the right side header shall be displayed as upload dashboard
	##Step 4
	When the user clicks on upload status button from left menu bar
	Then the upload status shall be higlighted in left menu bar
	And the right side header shall be displayed as upload status
	##Step 5
	When the user clicks on history button from left menu bar
	Then the history shall be higlighted in left menu bar
	And the right side header shall be displayed as history
	##Step 6
		When the user clicks on exit to app button from left menu bar
	Then the Application access screen is displayed
	When user clicks on Logout icon from left panel
  Then user is logout from the application.
#	And Data-Upload Application is closed 
 
 Examples: 
		|user|  
		|ic-test-staff@capgemini.com |

	@login_TC3132	
Scenario Outline: TC3132 - SN HIL Manager_Verify the system indicates which activity tab is currently selected in the landing page status ribbon

  Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
	Then Choose Site screen is displayed
	##Step 2
	 Then Choose Site menu in the left menu panel is highlighted
	 Then Choose Site screen is displayed
  ##Step 3
  When clicks on any of the faclity from the facility selection screen
    And click on select button
	Then the dashbaord shall be higlighted in left menu bar
	And the right side header shall be displayed as upload dashboard
	##Step 4
	When the user clicks on history button from left menu bar
	Then the history shall be higlighted in left menu bar
	And the right side header shall be displayed as history
	##Step 5
	When the user clicks on audit log button from left menu bar
	Then the audit log shall be higlighted in left menu bar
	And the right side header shall be displayed as audit log
		##Step 6
	When the user clicks on imaging links button from left menu bar
	Then the imaging links shall be higlighted in left menu bar
	And the right side header shall be displayed as provider links
	##Step 7
		When the user clicks on exit to app button from left menu bar
	Then the Application access screen is displayed
	When user clicks on Logout icon from left panel
  Then user is logout from the application.
#	And Data-Upload Application is closed 

 
 Examples: 
		|user|  
		|ic-test-snn-hil-manager@capgemini.com |
	
	
	##########################################################
	##The below testcase is removed. keeping for reference.
	###########################################################
	
#	 @login_TC1160
  #Scenario: TC1160 - Verify Left menu panel as per user access
    #Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    #Then Homepage is displayed
    #Then the user can only see the left menu components as per access
      #| menuitems      |
      #| File Dashboard |
      #| Upload Files   |
      #| Upload status  |
      #| History        |
      #| Audit log      |
      #| Imaging links  |
      #| Settings       |
      #| Help           |
      #| Info           |
    #When user clicks on Logout icon from left panel
    #Then user is logout from the application.
    #When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    #Then the user can only see the left menu components as per access
      #| menuitems      |
      #| File Dashboard |
      #| Upload Files   |
      #| Upload status  |
      #| History        |
      #| Help           |
      #| Info           |
    #When user clicks on Logout icon from left panel
    #Then user is logout from the application.
    #When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech@capgemini.com"
    #Then the user can only see the left menu components as per access
      #| menuitems      |
      #| File Dashboard |
      #| Upload Files   |
      #| Upload status  |
      #| History        |
      #| Help           |
      #| Info           |
    #When user clicks on Logout icon from left panel
    #Then user is logout from the application.
    #When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-supportstaff@capgemini.com"
    #Then the user can only see the left menu components as per access
      #| menuitems      |
      #| File Dashboard |
      #| Upload Files   |
      #| Upload status  |
      #| History        |
      #| Help           |
      #| Info           |
    #When user clicks on Logout icon from left panel
    #Then user is logout from the application.
    #When that the user is logged in to Data-Upload Utility Application through chrome "h-test-admin@capgemini.com"
    #Then the user can only see the left menu components as per access
      #| menuitems      |
      #| File Dashboard |
      #| Upload Files   |
      #| Upload status  |
      #| History        |
      #| Audit log      |
      #| Imaging links  |
      #| Settings       |
      #| Help           |
      #| Info           |
    #When user clicks on Logout icon from left panel
    #Then user is logout from the application.
    #When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-snhilmanager@capgemini.com"
    #Then the user can only see the left menu components as per access
      #| menuitems      |
      #| Choose site    |
      #| File Dashboard |
      #| History        |
      #| Audit log      |
      #| Imaging links  |
      #| Help           |
      #| Info           |
    #When user clicks on Logout icon from left panel
    #Then user is logout from the application.
    #And then applicaton should be closed
    #
    #Examples: 
#		|user|  
#		|ic-test-admin@capgemini.com |
    

