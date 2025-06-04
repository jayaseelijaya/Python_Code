Feature: SSR2607 - The HIL manager case list view shall allow the HIL manager to overwrite the due date for unclaimed cases

  @hil_TC2768
  Scenario Outline: TC2768 - S&N HIL Manager_Verify the case list view allow the S&N HIL manager to overwrite the due date for unclaimed cases
		##Step 1
		Given that the user is logged in to HIL Application through chrome "ic-test-snn-hil-manager@capgemini.com"
		Then the Active cases screen is displayed with list of records
		##Step 2
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
      ##Step 3
      When the user selects an unclaimed case and click Edit icon of due date
      Then Select a new due date popup is displayed with
      | the current date is highlighted in the calendar in teal color Weekends are grayed out |
      | Enter time input field populated with current time is displayed which is editable     |
      | Toggle button AMPM is displayed                                                       |
      | New due date field is displayed which is populated with current date and time         |
      | Cancel button                                                                         |
      | Submit button highlighted in teal color |
      ##Step 4
      When the user changes the Due date in the popup displayed
      ##Step 5
       When the user clicks Submit button in the new date popup
    	Then the changed date and time is reflected in  the selected Case ID
    	##Step 6
    	When the user clicks on Logout button at top right section
    	Then the user is logged out successfully and navigated to CLP login screen
    	##Step 7
    	Given that the user is logged in to HIL Application through chrome "ic-test-snn-hil-reviewer@capgemini.com"
			Then the Active cases screen is displayed with list of records
			##Step 8
			Then the changed date and time is reflected in  the selected Case ID
			##Step 9
			When the user clicks on Logout button at top right section
    	Then the user is logged out successfully and navigated to CLP login screen
    	
    	
    @hil_TC2769
  Scenario Outline: TC2769 - S&N HIL Manager_Verify if Edit icon of due date is not present in claimed cases for S&N HIL Manager
  ##Step 1
		Given that the user is logged in to HIL Application through chrome "ic-test-snn-hil-manager@capgemini.com"
		Then the Active cases screen is displayed with list of records
		##Step 2
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
      And edit icon is present in Due Date Column for New or unclaimed cases
      ##Step 3
        When the user select an unclaimed case and click on Claim button
        And Claim option in column 9 is changed to "Unassign"
        ##Step 4
        Then the edit icon is not displayed in due date column for recorded case
        ##Step 5
			When the user clicks on Logout button at top right section
    	Then the user is logged out successfully and navigated to CLP login screen
    	
    	@hil_SSR2607
  Scenario Outline: TC2770 - S&N HIL Manager_Verify the Usability of  Due date and Edit icon
    ##Step 1
    Given that the user is logged in to HIL Application through chrome "<user>"
    ##Given Ensure there are Claimed and Unclaimed case records
    ##Step 2
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
    ##Step 3
    Then the records are sorted in "ascending" order of due date by default
    And verify Due Date and time format and time zone
    And fonts and toggleable arrow in white color
    ##Step 4
    When the user selects an unclaimed case and click Edit icon of due date
    Then Select a new due date popup is displayed with
      | the current date is highlighted in the calendar in teal color Weekends are grayed out |
      | Enter time input field populated with current time is displayed which is editable     |
      | Toggle button AMPM is displayed                                                       |
      | New due date field is displayed which is populated with current date and time         |
      | Cancel button                                                                         |
      | Submit button highlighted in teal color                                               |
    ##Step 5
    When the user clicks Submit button in the new date popup
    Then the changed date and time is reflected in  the selected Case ID
    ##Step 6
    Then the records are sorted in "ascending" order of due date by default
    ##Step 7
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |
      
			
    	