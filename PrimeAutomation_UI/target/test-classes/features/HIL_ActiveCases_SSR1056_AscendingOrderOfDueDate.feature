Feature: SSR1056 - The HIL case list shall present the review queue in ascending order of due date

  @hil_TC2872
  Scenario Outline: TC2872 - S&N HIL Manager_Verify Active Cases screen displays records in ascending order of due date
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
    ##Step 4
    When clicks on the "downward" arrow of "Due date" column
    Then the "Due date" is sorted in "descending" order
    ##Step 5
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |

  @hil_TC2873
  Scenario Outline: TC2873 - S&N HIL Reviewer_Verify Active Cases screen displays records in ascending order of due date
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
    ##Step 4
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

    Examples: 
      | user                                   |
      | ic-test-snn-hil-reviewer@capgemini.com |

  @hil_TC2874
  Scenario Outline: TC2874 - S&N HIL Reviewer_Verify My Cases screen displays records in ascending order of due date
    ##Step 1
    Given that the user is logged in to HIL Application through chrome "<user>"
    ##Given Ensure there are Claimed and Unclaimed case records
    ##Step 2
    When the user select an unclaimed case and click on Claim button
    Then the selected case file is claimed for S&N HIL reviewer and status is changed to "Reviewer username"
    And View option in column 10 on selected case is changed to "Open"
    And Claim option in column 9 is changed to "Unclaim"
    ##Step 3
    When the user selects another unclaimed case and click on Claim button
    Then the selected case file is claimed for S&N HIL reviewer and status is changed to "Reviewer username"
    And View option in column 10 on selected case is changed to "Open"
    And Claim option in column 9 is changed to "Unclaim"
    ##Step 4
    When the user clicks on My Cases at top left
    Then My Cases screen is displayed
    And claimed record from above steps are displayed
    ##Step 5
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
    ##Step 6
    Then the records are sorted in "ascending" order of due date by default in My cases screen
    ##Step 7
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

    Examples: 
      | user                                   |
      | ic-test-snn-hil-reviewer@capgemini.com |

  @hil_TC2770
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

  @hil_TC2875
  Scenario Outline: TC2875 - S&N HIL Manager_Verify HIL active cases screen displays records in ascending order of due date
    ##Step 1
    Given that the user is logged in to HIL Application through chrome "<user>"
    ##Step 2
    Then the Active cases screen is displayed with list of records
    ##Step 3
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
    ##Step 4
    Then the records are sorted in "ascending" order of due date by default
    And fonts and toggleable arrow in white color
    ##Step 5
    Then the Due date text is vertically centered alligned with the dates displayed in their column
    And verify Due Date and time format and time zone
    ##Step 6
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |
