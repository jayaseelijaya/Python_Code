Feature: SSR2604 - The HIL case list view shall include an option for the user to logout of the system.

  @hil_TC2795
  Scenario Outline: TC2795 - SNHIL Manager_Verify the user has an option for logout.  
   
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
   	And Exit to Apps button is displayed at Active Cases Screen
   	When clicks on the Exit to Apps button at the top right
    Then application selection screen is displayed to the user
    When the user clicks HIL launch button
    Then Logout button is displayed on the Active cases screen
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |


  @hil_TC2796
  Scenario Outline: TC2796 - S&N HIL Reviewer_Verify the user has an option for logout.
     
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
   	And Exit to Apps button is displayed at Active Cases Screen
   	When clicks on the Exit to Apps button at the top right
    Then application selection screen is displayed to the user
    When the user clicks HIL launch button
    Then Logout button is displayed on the Active cases screen
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
    Examples: 
      | user                                   |
      | ic-test-snn-hil-reviewer@capgemini.com |



  @hil_TC2797
  Scenario Outline: TC2797 - HIL Reviewer_Verify the usuability of Logout option in HIl web app.
   
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
    Then Logout button is displayed on the Active cases screen
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
    
    Examples: 
      | user                                   |
      | ic-test-snn-hil-reviewer@capgemini.com |

  