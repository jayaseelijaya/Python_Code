Feature: SSR2606 - The default due date shall be set to 48 hours after time of upload (excluding weekends).

	@hil_TC3065
	Scenario Outline: TC3065 - S&N HIL Reviewer_Verify S&N HIL Reviewer allows default due date to be set for 48 hours after upload time 
		Given that the user is logged in to HIL Application through chrome "<user>"
		And the active cases screen shall be displayed
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
	  Then User clicks filter button in top menu bar of Active Cases Page
	  And Wait 10 seconds
	  Then User clicks Status button in the filter menu of active cases page
	  Then User clicks new status button in the filter menu of active cases page
	  Then User clicks done button in the filter menu of active cases page
	  And Wait 4 seconds
	 	And Verify the difference between created date and due date
	  And Get difference between Created and Due date against Time Until Due Value
		When the user clicks on Logout button at top right section
	  Then the user is logged out successfully and navigated to CLP login screen
		
		Examples:
    | user                                 	|
    | ic-test-snn-hil-manager@capgemini.com |
    
	@hil_TC3068
	Scenario Outline: TC3068 - S&N HIL Manager_Verify the default due date is set to 48 hours after time of upload excluding weekend.  
		Given that the user is logged in to HIL Application through chrome "<user>"
		And the active cases screen shall be displayed
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
	  Then User clicks filter button in top menu bar of Active Cases Page
	  And Wait 10 seconds
	  Then User clicks Status button in the filter menu of active cases page
	  Then User clicks new status button in the filter menu of active cases page
	  Then User clicks done button in the filter menu of active cases page
	  And Wait 4 seconds
	 	And Verify the difference between created date and due date
	  And Get difference between Created and Due date against Time Until Due Value
		When the user clicks on Logout button at top right section
	  Then the user is logged out successfully and navigated to CLP login screen
		
		Examples:
    | user                                 	|
    | ic-test-snn-hil-manager@capgemini.com |
    
	@hil_TC3069
	Scenario Outline: TC3069 - S&N HIL Reviewer_Verify if default due date be set to 48 hours after time of upload 
		Given that the user is logged in to HIL Application through chrome "<user>"
		And the active cases screen shall be displayed
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
	  Then User clicks filter button in top menu bar of Active Cases Page
	  And Wait 10 seconds
	  Then Reviewer user clicks status button in filter menu
	  Then Reviewer user clicks new status button in filter menu
	  Then Reviewer user clicks done button in filter menu
	  And Wait 4 seconds
	 	And Verify the difference between created date and due date
	  And Get difference between Created and Due date against Time Until Due Value
		When the user clicks on Logout button at top right section
	  Then the user is logged out successfully and navigated to CLP login screen
		
		Examples:
    | user                                 	 |
    | ic-test-snn-hil-reviewer@capgemini.com |
    
	@hil_TC3073
	Scenario Outline: TC3073 - S&N HIL Manager_Verify usability of S&N HIL manager active case due date and time till due column   
		Given that the user is logged in to HIL Application through chrome "<user>"
		And the active cases screen shall be displayed
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
	  Then User clicks filter button in top menu bar of Active Cases Page
	  And Wait 10 seconds
	  Then User clicks Status button in the filter menu of active cases page
	  Then User clicks new status button in the filter menu of active cases page
	  Then User clicks done button in the filter menu of active cases page
	  And Wait 4 seconds
	 	And Verify the difference between created date and due date
	  And Get difference between Created and Due date against Time Until Due Value
	  And Get Time Until Due Value
	  Then User clicks edit date button on first entry
	  And Check if new date header is displayed
	  Then User selects the date one after the current day
	  And User clicks submit button in edit date page
	  And Compare original time until due date to current time until due date
	  Then User clicks edit date button on first entry
	  Then User selects the date two after the current day
	  And User clicks submit button in edit date page
	  And Compare original time until due date to current time until due date
		When the user clicks on Logout button at top right section
	  Then the user is logged out successfully and navigated to CLP login screen
		
		Examples:
    | user                                 	|
    | ic-test-snn-hil-manager@capgemini.com |

	@hil_TC2802
	Scenario Outline: TC2802 - S&N HIL Manager_Verify the case list calculates a case due date based on the configurable time period after time of upload  
		Given that the user is logged in to HIL Application through chrome "<user>"
		And the active cases screen shall be displayed
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
	  Then User clicks filter button in top menu bar of Active Cases Page
	  And Wait 10 seconds
	  Then User clicks Status button in the filter menu of active cases page
	  Then User clicks new status button in the filter menu of active cases page
	  Then User clicks done button in the filter menu of active cases page
	  And Wait 4 seconds
	 	And Verify the difference between created date and due date
	  And Get difference between Created and Due date against Time Until Due Value
	  And Get Time Until Due Value
	  Then User clicks edit date button on first entry
	  And Check if new date header is displayed
	  Then User clicks PM button
	  Then User clicks cancel button
	  And Wait 4 seconds
	  Then User clicks edit date button on first entry
	  Then User selects the date one after the current day
	  And User clicks submit button in edit date page
	  And Wait 4 seconds
	  And Compare original time until due date to current time until due date
	  Then User clicks edit date button on first entry
	  Then User selects the date five after the current day
	  And User clicks submit button in edit date page
	  And Wait 4 seconds
	  Then User clicks edit date button on first entry
	  Then User selects the current date
	  And User clicks submit button in edit date page
	  And Wait 4 seconds
	  And Compare original time until due date to current time until due date
	  And Check for Overdue Status
	  And Compare original time until due date to current time until due date
	 	Then User clicks edit date button on first entry
	  Then User selects the date two after the current day
	  And User clicks submit button in edit date page
	  And Wait 4 seconds
		When the user clicks on Logout button at top right section
	  Then the user is logged out successfully and navigated to CLP login screen
		
		Examples:
    | user                                 	|
    | ic-test-snn-hil-manager@capgemini.com |