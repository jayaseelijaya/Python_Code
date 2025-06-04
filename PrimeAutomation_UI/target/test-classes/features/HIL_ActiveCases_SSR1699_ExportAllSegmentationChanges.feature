Feature: SSR1699 - Verifying the S+N HIL Manager View shall allow to export all segmentation changes by case.

  #create one folder under reports folder as "HILAuditLogs" before executing test case
  @activeCases_TC2867
  Scenario Outline: TC2867 - SN HIL Manager_Verify the user is allowed to export all segmentation changes by case.
    #Step-1
    Given that the user is logged in to HIL Application through chrome "<user>"
    And the active cases screen shall be displayed
    #Step-2
    Then the case records shall be displayed in tabular column of active cases
    When the user selects the casefile claimed by the logged in user
    #Step-3
    Then the user clicks on audit log icon for the selected case file
    Then the active cases audit log file of selected case record shall be downloaded in .csv file
    #Step-4
    When the user clicks on "Case History" tab at the header
    Then the case records shall be displayed in the list of case history
    When the user selects a case record from the case history list
    #Step-5
    Then the user clicks on audit log icon for the selected case history file
    Then the case history audit log file of selected case record shall be downloaded in .csv file
    #Step-6
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |

  @activeCases_TC2868
  Scenario Outline: TC2868 - SN HIL Manager_Verify usability of S&N HIL Manager export option for segmentation changes by case.
    #Step-1
    Given that the user is logged in to HIL Application through chrome "<user>"
    And the active cases screen shall be displayed
    #Step-2
    Then the case records shall be displayed in tabular column of active cases
    When the user selects the casefile claimed by the logged in user
    #Step-3
    When the user clicks on audit log icon for the selected case file
    Then the active cases audit log file of selected case record shall be downloaded in .csv file
    #Step-4
    Then the following headers shall be displayed in downloaded audit log file
      | header  |
      | Date    |
      | Case Id |
      | User Id |
      | Action  |
    #Step-5
    When the user clicks on "Case History" tab at the header
    Then the case records shall be displayed in the list of case history
    #Step-6
    When the user selects a case record from the case history list
    Then the case record shall be selected and higlighted in green color
    #Step-7
    When the user clicks on audit log icon for the selected case history file
    Then the case history audit log file of selected case record shall be downloaded in .csv file
    Then the following headers shall be displayed in downloaded case history audit log file
      | header  |
      | Date    |
      | Case Id |
      | User Id |
      | Action  |
    #Step-8
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |
