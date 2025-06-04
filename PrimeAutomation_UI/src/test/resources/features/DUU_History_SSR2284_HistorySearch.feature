

Feature: SSR2284 - Verifying History view is searchable and Filterbale by certain fields.

 @history_TC1582
  Scenario Outline: TC1582 - Surgeon_Verify History records search and filter functionality by Invalid input data.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    #step2,3
    When the user clicks on history button from left menu bar
    Then the history tab shall be displayed
    And History label at the top left side is highlighted in white color
    And hours checkbox is displayed
    And Filter option is displayed
    And Search Box is displayed
    And Search Button is displayed
    And Record entry text is displayed at the top
    And the below table header shall be displayed on history page
      | header      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    And View Details button in disabled mode is displayed
    And Show More button is displayed
    And list of history records are displayed to user
    #step4
    When the user enters current date in the search box
    And the user clicks on Search Button on history page
    Then the history view shall be displayed as no data to display
    #step5
    When the user removes text in searchbox
    Then the history view table shall be displayed
    When the user enter any upload user name in search box from the history screen
    And the user clicks on Search Button on history page
    Then list of history records are displayed to user
    #step6
    When the user clicks on Filter Option
    And click on uploader icon & selects another uploader name
    And click on Done button from the filter option
    Then the history view shall be displayed as no data to display
    #step7
    When the user removes upload user text from searchbox
    And the user clicks on Search Button on history page
    #Then list of history records are displayed to user
    #step8
    And user removes the filter from screen
    When the user enters any data which is not present in history record in the search box
    And the user clicks on Search Button on history page
    Then the history view shall be displayed as no data to display
    #step9
    When user removes text from searchbox & click on hours quick filter
    Then the history view shall be displayed as no data to display
    #step10,11
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                          |
      | ic-test-surgeon@capgemini.com |