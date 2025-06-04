Feature: SSR2605 - The HIL case list shall calculate a case due date based on the a configurable time period after time of upload

  @hil_TC2802
  Scenario Outline: TC2802 - S&N HIL Manager_Verify the case list calculates a case due date based on the configurable time period after time of upload
    ##Step 1
    ##Given Ensure a recently(Current day) uploaded valid dicom file is available in DUU
    Given that the user is logged in to HIL Application through chrome "<user>"
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
    When the user select the case with Created date as current date in created column
    Then the due date column of the selected case displays due date as two workdays
    ##Step 4
    When the user select the case with Created date as current date and click Edit icon of due date
    Then Select a new due date popup is displayed
    ##Step 5
    When the user changes the due date and time to "24 hrs" from current date recorded
    ##Step 6
    When the user clicks cancel button in the new date popup
    Then new due date popup is dismissed and changes are not saved
    ##Step 7
    When the user select the case with Created date as current date and click Edit icon of due date
    Then Select a new due date popup is displayed
    ##Step 8
    When the user changes the due date and time to "24 hrs" from current date recorded
    ##Step 9
    When the user clicks Submit button in the new date popup
    ##Step 10
    Then the changed date and time is reflected in  the selected Case ID
    And the time until due displays "1 day"
    ##Step 11
    When the user select the case with Created date as current date and click Edit icon of due date
    Then Select a new due date popup is displayed
    ##Step 12
    When the user changes the due date and time to "5 days" from current date recorded
    When the user clicks Submit button in the new date popup
    ##Step 13
    Then the changed date and time is reflected in  the selected Case ID
    And the time until due displays "5 days"
    ##Step 14
    When the user select the case with Created date as current date and click Edit icon of due date
    Then Select a new due date popup is displayed
    ##Step 15
    When the user changes the due date and time to "5 minutes" from current date recorded
    When the user clicks Submit button in the new date popup
    ##Step 16
    Then the changed date and time is reflected in  the selected Case ID
    And the time until due displays "5 minutes"
    ##Step 17
    When the user wait until the Case status changes to overdue
    Then time until due column displays the crossed due time
    ##Step 18
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |

  @hil_TC3605
  Scenario Outline: TC3065 - S&N HIL Reviewer_Verify S&N HIL Reviewer allows default due date to be set for 48 hours after upload time
    ##Step 1
    ##Given Ensure a recently(Current day) uploaded valid dicom file is available in DUU
    Given that the user is logged in to HIL Application through chrome "<user>"
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
    When the user select the case with Created date as current date in created column
    Then the due date column of the selected case displays due date as two workdays
    ##Step 4
    Then the time until due is calculated automatically based on created date and it is displayed as "2 days"
    ##Step 5
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

    Examples: 
      | user                                   |
      | ic-test-snn-hil-reviewer@capgemini.com |
