Feature: SSR2409 - The HIL manager case list view shall allow the HIL manager to open completed cases in a view only mode.

  @hil_TC2870
  Scenario Outline: TC2870 - S&N HIL Manager_Verify the case list on Case History screen allows the S&N HIL Manager in view only mode 
    Given that the user is logged in to HIL Application through chrome "<user>"
    Then list of cases with table of 10 columns is displayed in "Active Cases" screen
      | Column                    |
      | Audit log icon ,info icon |
      | Case ID                   |
      | Anatomy                   |
      | Type                      |
      | Status                    |
      | Created                   |
      | Due date                  |
      | Time until due            |
      | Claim,Unassign            |
      | Open,View                 |
		Then User clicks unassign button on first entry
		And Verify first entry has claim button
		And Verify first entry has view button
		Then User clicks claim button on first entry 
		And Verify first entry has unassign button
		And Verify first entry has open button
		Then User clicks open button on first entry
		And Wait 10 seconds
		Then User clicks reject button
		Then User enters text into reject pop up text box
		Then User clicks reject button in reject pop up
		Then User clicks exit button in bottom right panel
		Then User clicks unassign button on first entry
		Then User clicks claim button on first entry 
		Then User clicks open button on first entry
		And Wait 10 seconds
		Then User clicks axial view in HIL Page
		And User clicks sliders to get 100 percent on sliders
		Then User clicks approve in bottom right panel
		And User clicks approve button in approve button pop up
		Then User clicks exit button in bottom right panel
		And Wait 5 seconds
		Then User clicks case history button
		Then User clicks filter button in Case History Page
		And Wait 5 seconds
		Then User clicks status filter button in Case History Page
		Then User clicks approve button in Case History Filter Menu
		Then User clicks done button in Case History Filter Menu
		And Check the view button for the first entry is displayed
		Then User clicks view button on first entry in case history page
		And Wait 10 seconds
		And the below components shall be disabled in view mode
		| components    |
		| lasso         |
		| brush         |
		| eraser        |
		| approve       |
		| save          |
		| reject        |
		| ctrl z        | 
		| ctrl y        |
		| reset changes |
		Then User clicks exit button in bottom right panel
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |
      
	@hil_TC2871
	Scenario Outline: TC2871 - S&N HIL Manager_Verify the usability of the case list view allows the S&N HIL Manager to open completed cases in a view only mode
		Given that the user is logged in to HIL Application through chrome "<user>"
	  Then list of cases with table of 10 columns is displayed in "Active Cases" screen
	    | Column                    |
	    | Audit log icon ,info icon |
	    | Case ID                   |
	    | Anatomy                   |
	    | Type                      |
	    | Status                    |
	    | Created                   |
	    | Due date                  |
	    | Time until due            |
	    | Claim,Unassign            |
	    | Open,View                 |
	  Then User clicks case history button
	  And Check that all columns are displayed in case history page
	  And Check Error Filter Button is Displayed
	  Then User clicks error filter button
	  And Wait 5 seconds
	  Then User clicks error filter button
	  And Check for filter button, search button, and search bar
	  And Verify sorting arrows are displayed
	  And Verify show more button is displayed
	  And Verify format of review time
	  And Verify format of completed Date
	  And Verify format of due Date
	  Then User clicks first case audit log button
	  Then User clicks filter button in Case History Page
		And Wait 5 seconds
		Then User clicks status filter button in Case History Page
		Then User clicks error status in filter menu
		Then User clicks done button in Case History Filter Menu
	  And Wait 5 seconds
	  And Verify view button is not displayed for error entry
	  Then Print completed date of error entry
	  Then Print review time of error entry
	  And Check the settings button is displayed in top bar
	  And Check the error icon is displayed for error entry
		Then User clicks filter button in Case History Page
		And Wait 5 seconds
		Then User clicks clear all filters button in filter menu
		Then User clicks status filter button in Case History Page
		Then User clicks approve button in Case History Filter Menu
		Then User clicks done button in Case History Filter Menu
		And Check the view button for the first entry is displayed
	  Then User clicks view button on first entry in case history page
	  And Wait 10 seconds
	  Then User clicks exit button in bottom right panel
	  When the user clicks on Logout button at top right section
	  Then the user is logged out successfully and navigated to CLP login screen

	Examples: 
	  | user                                  |
	  | ic-test-snn-hil-manager@capgemini.com |

	@hil_TC8193
  Scenario Outline: TC8193 - S&N HIL Manager_Verify the case list view allows the S&N HIL Manager to open completed cases in a view only mode
  	Given that the user is logged in to HIL Application through chrome "<user>"
    Then list of cases with table of 10 columns is displayed in "Active Cases" screen
      | Column                    |
      | Audit log icon ,info icon |
      | Case ID                   |
      | Anatomy                   |
      | Type                      |
      | Status                    |
      | Created                   |
      | Due date                  |
      | Time until due            |
      | Claim,Unassign            |
      | Open,View                 |
		Then User clicks unassign button on first entry
		And Verify first entry has claim button
		And Verify first entry has view button
		Then User clicks claim button on first entry 
		And Verify first entry has unassign button
		And Verify first entry has open button
		Then User clicks open button on first entry
		And Wait 10 seconds
		Then User clicks reject button
		Then User enters text into reject pop up text box
		Then User clicks reject button in reject pop up
		Then User clicks exit button in bottom right panel
		Then User clicks unassign button on first entry
		Then User clicks claim button on first entry 
		Then User clicks open button on first entry
		And Wait 10 seconds
		Then User clicks axial view in HIL Page
		And User clicks sliders to get 100 percent on sliders
		Then User clicks approve in bottom right panel
		And User clicks approve button in approve button pop up
		Then User clicks exit button in bottom right panel
		And Wait 5 seconds
		Then User clicks case history button
		Then User clicks filter button in Case History Page
		And Wait 5 seconds
		Then User clicks status filter button in Case History Page
		Then User clicks approve button in Case History Filter Menu
		Then User clicks done button in Case History Filter Menu
		And Check the view button for the first entry is displayed
		Then User clicks view button on first entry in case history page
		And Wait 10 seconds
		And the below components shall be disabled in view mode
		| components    |
		| lasso         |
		| brush         |
		| eraser        |
		| approve       |
		| save          |
		| reject        |
		| ctrl z        | 
		| ctrl y        |
		| reset changes |
		Then User clicks exit button in bottom right panel
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |