Feature: SSR1691 - The HIL case list shall reflect the status of a case (ready for review, in review, approved, rejected) in the review queue.

  @hil_TC3091
  Scenario Outline: TC3091 - S&N HIL Manager_Verify that S&N HIL Manager reflects the status of a case (ready for review,approved, rejected) in the review queue. 
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
		Then User clicks open button on first entry
		And Wait 10 seconds
		Then User clicks reject button
		Then User enters text into reject pop up text box
		Then User clicks reject button in reject pop up
		Then User clicks exit button in bottom right panel
		And Refresh active cases table
		And Check first entry status in table
		And Check first entry ID against previous check
		Then User clicks unassign button on first entry
		Then User clicks claim button on first entry 
		Then User clicks open button on first entry
		And Wait 10 seconds
		Then User clicks axial view in HIL Page
		And User clicks sliders to get 100 percent on sliders
		Then User clicks approve in bottom right panel
		And User clicks approve button in approve button pop up
		Then User clicks exit button in bottom right panel
		And Refresh active cases table
		And Check first entry status in table
		And Check first entry ID against previous check
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |
  
  
  @hil_TC3092
  Scenario Outline: TC3092 - S&N HIL Reviewer_Verify that S&N HIL Reviewer reflects the status of a case (ready for review,approved, rejected) in the review queue  
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
    And Check first entry ID against active cases
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

    Examples: 
      | user                                  | secondUser                             |
      | ic-test-snn-hil-manager@capgemini.com | ic-test-snn-hil-reviewer@capgemini.com |
   
  @hil_TC3093
  Scenario Outline: TC3093 - S&N HIL Manager_Verify Usability of HIL case list reflects the status of a case (ready for review, approved, rejected) in the review queue 
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
		Then User clicks case history button
		And Print first entry status in case history page
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |
  