Feature: SSR3406 - Data Upload Utility shall allow the S&N HIL Manager to choose a site to work for a specific facility. 
    
   @login_SSR3406
  Scenario Outline: TC1260 - S&N HIL Manager_Verify DUU app shall view login information on landing page.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Choose Site screen is displayed
    ##Step 2
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    Then Upload dashboad page is displayed to user
    And the following components shall be displayed on right side of upload dashboard
      | dashboard                  |
      | dashboard heading          |
      | uploaded records table     |
      | processing status checkbox |
      | uploaded status checkbox   |
      | complete status checkbox   |
      | error status checkbox      |
      | 24hrs checkbox             |
      | filter                     |
      | search box                 |
      | search button              |
    ##Step 3
    And the heading Smith and Nephew shall be displayed at the top left side in orange color
    ##Step 4
    And user verifies name of the logged-in user on left menu bar
    And user verifies role of the user logged-in
    ##Step 5
    And user verifies profile picture of the logged-in user on left menu bar
    ##Step 6
    And the welcome message shall be displayed
    ##Step 7
    And user verifies name of the logged-in user on left menu bar
    ##Step 8
    And user verifies role of the user logged-in
    ##Step 9
    Then the following information shall be displayed at left navigation bar
      | infomation     |
      | File dashboard |
      | Choose Site    |
      | History        |
      | Audit log      |
      | imaging links  |
      | Help           |
      | Info           |
      | Logout         |
      | Exit to app    |
    ##Step 10
    Then the following information should not be displayed at left navigation bar
      | infomation    |
      | Upload status |
      | Upload files  |
      | Settings      |
    ##Step 11
    When the user clicks on history button from left menu bar
    Then the following components shall be displayed on right side of history
      | history             |
      | history heading     |
      | 24hrs checkbox      |
      | filter              |
      | search textbox      |
      | search button       |
      | record table        |
      | view details button |
      | show more           |
    ##Step 12
    When the user clicks on audit log button from left menu bar
    Then the following components shall be displayed on right side of audit log
      | audit                |
      | audit log heading    |
      | 24hrs checkbox       |
      | filter               |
      | search textbox       |
      | search button        |
      | audit log list table |
      | exported selected    |
      | exported all         |
      | show more            |
    ##Step 13
    When the user clicks on imaging links button from left menu bar
    Then the following components shall be displayed on imaging links screen
      | imaging                                      |
      | Create or Modify links                       |
      | Two tables for Providers and Imaging centers |
      | Provider table                               |
      | All Organization heading                     |
      | search textbox                               |
      | search button                                |
      | List registered organizations                |
      | Provider details of the 1st provider         |
      | Activate Site                                |
      | Deactivate Site                              |
      | Imaging center table                         |
      | Pin linked centers to top toggle button      |
      | search textbox                               |
      | search button                                |
      | List of linked and unlinked facilities       |
      | facility details of 1st record               |
      | remove button                                |
      | create button                                |
      ##Step 14
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    ##Step 15
    When the user clicks on software information icon from left menu bar
    Then the software information popup shall be displayed
    And the software version details shall be displayed
    And the cross button shall be displayed
    When the user click on cross button
    ##Step 16
    And the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

    Examples: 
      | user                               |
      | ic-test-snn-hil-manager@capgemini.com |

	@login_SSR3406
  Scenario: TC3446 - S&N HIL Manager_Verify Main landing page status ribbon provides a control to navigate back to the applications view
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-snn-hil-manager@capgemini.com"
    And Choose Site screen is displayed
    Then Choose Site menu in the left menu panel is highlighted
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    And the dashboard summary shall display list of upload items
    Then the Exit to Apps is displayed at bottom of the left menu panel
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

    @login_SSR3406
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
    
    ###########################################
    ##Removed
    ############################################
    
    #Scenario Outline: TC0866 -S&N HIL Manager_Verify S&N HIL Manager has access to summary dashboard, upload history and user activity logs.
    #
    #Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    #Then Homepage is displayed to the user
    #And Choose Site screen is displayed
    #When clicks on any of the faclity from the facility selection screen
    #And click on select button
    #Then the dashboard summary shall display list of upload items
    #And the following components shall be displayed on right side of upload dashboard
      #| dashboard                  |
      #| dashboard heading          |
      #| uploaded records table     |
      #| processing status checkbox |
      #| uploaded status checkbox   |
      #| complete status checkbox   |
      #| error status checkbox      |
      #| 24hrs checkbox             |
      #| filter                     |
      #| search box                 |
      #| search button              |
    #When the user clicks on history button from left menu bar
    #Then the following components shall be displayed on right side of history
      #| history             |
      #| history heading     |
      #| 24hrs checkbox      |
      #| filter              |
      #| search textbox      |
      #| search button       |
      #| record table        |
      #| view details button |
      #| show more           |
    #When the user clicks on audit log button from left menu bar
    #Then the following components shall be displayed on right side of audit log
      #| audit                |
      #| audit log heading    |
      #| 24hrs checkbox       |
      #| filter               |
      #| search textbox       |
      #| search button        |
      #| exported selected    |
      #| exported all         |
      #| show more            |
    #When user clicks again on Choose site from left panel
    #And clicks on any other facility from the facility selection screen
    #And click on select button
    #Then the dashboard summary shall display list of upload items
    #And the following components shall be displayed on right side of upload dashboard
      #| dashboard                  |
      #| dashboard heading          |
      #| uploaded records table     |
      #| processing status checkbox |
      #| uploaded status checkbox   |
      #| complete status checkbox   |
      #| error status checkbox      |
      #| 24hrs checkbox             |
      #| filter                     |
      #| search box                 |
      #| search button              |
    #When the user clicks on history button from left menu bar
    #Then the following components shall be displayed on right side of history
      #| history             |
      #| history heading     |
      #| 24hrs checkbox      |
      #| filter              |
      #| search textbox      |
      #| search button       |
      #| record table        |
      #| view details button |
      #| show more           |
    #When the user clicks on audit log button from left menu bar
    #Then the following components shall be displayed on right side of audit log
      #| audit                |
      #| audit log heading    |
      #| 24hrs checkbox       |
      #| filter               |
      #| search textbox       |
      #| search button        |
      #| exported selected    |
      #| exported all         |
      #| show more            |
    #And the user clicks on exit to app button from left menu bar
    #Then the right side header shall be displayed as exit to app works
    #When user clicks on Logout icon from left panel
    #Then user is logout from the application.
    #And Data-Upload Application is closed
#
    #Examples: 
#		|user|  
#		|ic-test-snn-hil-manager@capgemini.com |
    #
    