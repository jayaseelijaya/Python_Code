Feature: SSR2612 - Verifying Data Upload Utility will change the Status of a facility from NA to Inactive after the facility has been given a license

	@activeCases_TC2773
	Scenario Outline: TC2773 - SN HIL Reviewer_Verify a six digit alphanumeric unique case ID is displayed under Case ID column for all the cases in active cases screen
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
		And the case id column shall display six digits alphanumeric unique ID
		When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
		
		Examples:
    | user                                  |
    | ic-test-snn-hil-reviewer@capgemini.com  |
    
    @activeCases_TC2774
	Scenario Outline: TC2774 - SN HIL Manager_Verify a six digit alphanumeric unique case ID is displayed under Case ID column for all the cases in active cases screen. 
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
		And the case id column shall display six digits alphanumeric unique ID
		When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
		
		Examples:
    | user                                  |
    | ic-test-snn-hil-manager@capgemini.com  |
    
    
    @activeCases_TC2775
	Scenario Outline: TC2775 - SN HIL Reviewer_Verify a six digit alphanumeric unique case ID is displayed under Case ID column for all the cases in My cases screen. 
		Given that the user is logged in to HIL Application through chrome "<user>"
		And the active cases screen shall be displayed
		When the user clicks on "My Cases" tab at the header
		Then list of cases with table of 10 columns is displayed in "My Cases" screen
      | Column                    |
      | Audit log icon ,info icon |
      | Case ID                   |
      | Anatomy                   |
      | Type                      |
      | Status                    |
      | Completed Date            |
      | Due date                  |
      | Time until due            |
      | Claim,Unassign            |
      | Open,View                 |
    And the case id column shall display six digits alphanumeric unique ID  
		When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
		
		Examples:to HIL Application through chrome "<user>"
		And the active cases screen shall b
    | user                                  |
    | ic-test-snn-hil-reviewer@capgemini.com  |
    
    
    @activeCases_TC2776
	Scenario Outline: TC2776 - SN HIL Manager_Verify if a six digit alphanumeric unique case ID is displayed under Case ID column for all the case in Case History screen. 
		Given that the user is logged in e displayed
		When the user clicks on "Case History" tab at the header
		Then list of cases with table of 10 columns is displayed in "Case History" screen
      | Column                    |
      | Audit log icon ,info icon |
      | Case ID                   |
      | Anatomy                   |
      | Type                      |
      | Status                    |
      | Completed Date            |
      | Due date                  |
      | Time until due            |
      | Claim,Unassign            |
      | Open,View                 |
    And the case id column shall display six digits alphanumeric unique ID  
		When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
		
		Examples:
    | user                                  |
    | ic-test-snn-hil-manager@capgemini.com  |
    
    
    @activeCases_TC2766
	Scenario Outline: TC2776 - SN HIL Manager_Verify the usability of Case ID column in Active Case screen and Case History screen. 
		Given that the user is logged in to HIL Application through chrome "<user>"
		And the active cases screen shall be displayed
  	Then list of cases with table of 10 columns is displayed in "Active Case" screen
      | Column                    |
      | Audit log icon ,info icon |
      | Case ID                   |
      | Anatomy                   |
      | Type                      |
      | Status                    |
      | Completed Date            |
      | Due date                  |
      | Time until due            |
      | Claim,Unassign            |
      | Open,View                 |
		When the user clicks on "Case History" tab at the header
		Then list of cases with table of 10 columns is displayed in "Case History" screen
      | Column                    |
      | Audit log icon ,info icon |
      | Case ID                   |
      | Anatomy                   |
      | Type                      |
      | Status                    |
      | Completed Date            |
      | Due date                  |
      | Time until due            |
      | Claim,Unassign            |
      | Open,View                 |
    And the case id column shall display six digits alphanumeric unique ID  
		When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
		
		Examples:
    | user                                  |
    | ic-test-snn-hil-manager@capgemini.com  |
    
    
    @activeCases_TC2767
	Scenario Outline: TC2776 - SN HIL Reviewer_Verify the usability of Case ID column in Active Cases screen and My Cases screen. 
		Given that the user is logged in to HIL Application through chrome "<user>"
		And the active cases screen shall be displayed
		Then list of cases with table of 10 columns is displayed in "Active Cases" screen
      | Column                    |
      | Audit log icon ,info icon |
      | Case ID                   |
      | Anatomy                   |
      | Type                      |
      | Status                    |
      | Completed Date            |
      | Due date                  |
      | Time until due            |
      | Claim,Unassign            |
      | Open,View                 |
		When the user clicks on "My Cases" tab at the header
		Then list of cases with table of 10 columns is displayed in "My Cases" screen
      | Column                    |
      | Audit log icon ,info icon |
      | Case ID                   |
      | Anatomy                   |
      | Type                      |
      | Status                    |
      | Completed Date            |
      | Due date                  |
      | Time until due            |
      | Claim,Unassign            |
      | Open,View                 |
    And the case id column shall display six digits alphanumeric unique ID  
		When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
		
		Examples:
    | user                                  |
    | ic-test-snn-hil-reviewer@capgemini.com  |
    
    
    
    
    
    
    