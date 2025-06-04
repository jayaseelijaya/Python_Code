Feature: SSR2405 - The HIL case list shall include the reviewer name next to any "in review" case.
	
	@hil_TC2876
  Scenario Outline: TC2876 - S&N HIL Reviewer_Verify Reviewer name is displayed for claimed cases in active cases screen 
    Given that the user is logged in to HIL Application through chrome "<user>"
		Then User clicks unassign button on first entry
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
    Given that the user is logged in to HIL Application through chrome "<secondUser>"
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
    And Save case id of first entry
    Then User clicks claim button on first entry
    And Print first entry status
    Then User clicks my cases page button
		And Get first entry status in my cases page
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
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
    And Print first entry status
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

    Examples: 
      | user                                  | secondUser                             |
      | ic-test-snn-hil-manager@capgemini.com | ic-test-snn-hil-reviewer@capgemini.com |
	
  @hil_TC2877
  Scenario Outline: TC2877 - S&N HIL Manager_Verify that Reviewer name is displayed for claimed cases in active cases screen  
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
		And Print first entry status
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
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
    And Print first entry status
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

 	Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |
      
  @hil_TC2878
  Scenario Outline: TC2878 - S&N HIL Manager_Verify S&N HIL Manager is able to see claimed case of S&N HIL Reviewer
    Given that the user is logged in to HIL Application through chrome "<user>"
		Then User clicks unassign button on first entry
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
    Given that the user is logged in to HIL Application through chrome "<secondUser>"
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
    And Save case id of first entry
    Then User clicks claim button on first entry
    And Print first entry status
    Then User clicks my cases page button
		And Get first entry status in my cases page
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
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
    And Print first entry status
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

  Examples: 
      | user                                  | secondUser                             |
      | ic-test-snn-hil-manager@capgemini.com | ic-test-snn-hil-reviewer@capgemini.com |
      
  @hil_TC2879
  Scenario Outline: TC2879 - S&N HIL Reviewer_Verify S&N HIL Reviewer can see cases claimed by S&N HIL Manager  
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
		And Save case id of first entry
		Then User clicks unassign button on first entry
		And Verify first entry has claim button
		And Verify first entry has view button
		Then User clicks claim button on first entry 
		And Verify first entry has unassign button
		And Verify first entry has open button
		And Print first entry status  
		When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
    Given that the user is logged in to HIL Application through chrome "<secondUser>"
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
    And Print first entry status
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
    
	Examples: 
    | user                                  | secondUser                             |
    | ic-test-snn-hil-manager@capgemini.com | ic-test-snn-hil-reviewer@capgemini.com |
    
  @hil_TC2881
  Scenario Outline: TC2881 - S&N HIL Reviewer_Verify functionalities like Audit log , Edit and Settings icon along with the reviewer name for claimed cases is not displayed  
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
		And Save case id of first entry
		Then User clicks unassign button on first entry
		When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
    Given that the user is logged in to HIL Application through chrome "<secondUser>"
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
    Then User clicks claim button on first entry
    And Check that Edit Date icon is not displayed
    And Print first entry status
    And Check that audit log icon is not displayed
    Then User clicks my cases page button
		And Get first entry status in my cases page
		And Check that Settings button is not displayed
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
    
	Examples: 
    | user                                  | secondUser                             |
    | ic-test-snn-hil-manager@capgemini.com | ic-test-snn-hil-reviewer@capgemini.com |
    