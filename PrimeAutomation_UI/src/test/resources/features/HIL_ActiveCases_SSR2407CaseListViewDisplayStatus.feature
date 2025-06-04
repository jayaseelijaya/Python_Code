Feature: SSR2407 - Verifying the The HIL manager case list view shall display ready for review in review and completed cases 

	@activeCases_TC2869
	Scenario Outline: TC2869 - SN HIL Manager_Verify the S&N HIL Manager case list view displays ready for review, in review, and completed cases. 
		Given that the user is logged in to HIL Application through chrome "<user>"
		And the active cases screen shall be displayed
		Then the case records shall be displayed in tabular column of active cases
		And the unclaimed case status shall be displayed as new or unclaimed
		When the user selects an unclaimed case and clicks on claim button
    Then the open button in 10th column shall be enabled
    And the status of claimed case shall be displayed as reviewer name
    When the user clciks on open button of selected case
    Then the hil image editor screen shall be displayed for selected case
    And the following four views along with toolbar shall be displayed
      | view  							|
      | Axial 							|
      | Sagittal 						|
      | Coronal 						|
      | 3D Model 						|
      | right panel toolbar |
    When the user selects only coronal view
    And User clicks sliders to get 100 percent on sliders
		Then User clicks approve in bottom right panel
		And User clicks approve button in approve button pop up
		Then User clicks exit button in bottom right panel
    #Then the double confirmation popup shall be displayed
    #And the following details shall be displayed in double confirmation popup
      #| popup											  |
      #| confirm you want to approve |
      #| cancel button   					  |
      #| approve button						  |
    #When the user clicks on approve button in approve double confirmation
    #Then the case record shall be approved  
    #When the user clicks on exit file button
    #Then the save file popup shall be displayed with following details
      #| would you like to save before exit	|
      #| exit and save button								|
      #| exit button													|
    #When the user clicks on save and exit button
     Then User clicks exit button in bottom right panel
		And Refresh active cases table
    And the active cases screen shall be displayed    
    When the user selects already claimed case record from the active case list
    When the user clciks on open button of selected case
    Then the hil image editor screen shall be displayed for selected case
    And the following four views along with toolbar shall be displayed
      | view  							|
      | Axial 							|
      | Sagittal 						|
      | Coronal 						|
      | 3D Model 						|
      | right panel toolbar |
    When the user selects only coronal view
    And User clicks sliders to get 100 percent on sliders
    And the reject button shall be displayed at the right bottom of the screen
    Then User clicks reject button
		Then User enters text into reject pop up text box
		Then User clicks reject button in reject pop up
    Then User clicks exit button in bottom right panel
		And Refresh active cases table 
    When the user clicks on "Case History" tab at the header
    Then the case records shall be displayed in the list of case history
    #And the status of rejected case shall be displayed as rejected  
		When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
		
		Examples:
    | user                                  |
    | ic-test-snn-hil-manager@capgemini.com  |
    
    
    @activeCases_TC2866
	Scenario Outline: TC2866 - SN HIL Manager_Verify the usability of case list of Active Cases screen  
		Given that the user is logged in to HIL Application through chrome "<user>"
		And the active cases screen shall be displayed
		Then the case records shall be displayed in tabular column of active cases
		And the unclaimed case status shall be displayed as new or unclaimed
    And the reviewer name shall be displayed for the claimed case
    And the view button shall be enabled for the uncalimed case
    And the open button shall be enabled for the claimed case
    And the unassign button shall be enabled for the claimed case 
		When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
		
		Examples:
    | user                                  |
    | ic-test-snn-hil-manager@capgemini.com  |
    
    
    
 