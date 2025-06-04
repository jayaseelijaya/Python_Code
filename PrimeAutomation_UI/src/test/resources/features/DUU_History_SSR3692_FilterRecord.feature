
Feature: SSR3692 - Verifying that DUU application shall provide the ability to filter the data contents of Upload Dashboard, History, and audit log tables within the past 24 hours.

@history_TC1120
  Scenario Outline: TC1120 - IC Admin_Verify combined search & filter functionalities on history screen.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    #step2,3,4
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
    #And Show More button is displayed
    And list of history records are displayed to user
    #step5
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    #step6
    When the user enters a patient first name in search box
    And the user clicks on Search Button on history page
    Then the entered patient record shall be displayed in 24hrs filter
    #step7
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step8
    When clicks on file status & selects any status
    And click on Done button from the filter option
    Then the 24hrs checkbox filter shall be removed automatically
    And the selected filter shall be displayed at top left section
    And list of history records are displayed to user
    #step9
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step10
    When clicks on site option & selects any site
    And click on Done button from the filter option
    And the selected filter shall be displayed at top left section
    Then list of history records are displayed to user
    #step11
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step12
    When clicks on uploader option & selects any uploader
    And click on Done button from the filter option
    And the selected filter shall be displayed at top left section
    Then list of history records are displayed to user
    #step13
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    #step14
    When the user selects 24hrs filter checkbox
    Then list of history records are displayed to user
    #step15,16
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |

  @history_TC2788
  Scenario Outline: TC2788 - IC Technician_Verify combined search & filter functionalities on history screen.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    #step2,3,4
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
    #step5
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    #step6
    When the user enters a patient first name in search box
    And the user clicks on Search Button on history page
    Then the entered patient record shall be displayed in 24hrs filter
    #step7
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step8
    When clicks on file status & selects any status
    And click on Done button from the filter option
    Then the 24hrs checkbox filter shall be removed automatically
    And the selected filter shall be displayed at top left section
    And list of history records are displayed to user
    #step9
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step10
    When clicks on site option & selects any site
    And click on Done button from the filter option
    And the selected filter shall be displayed at top left section
    Then list of history records are displayed to user
    #step11
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step12
    When clicks on uploader option & selects any uploader
    And click on Done button from the filter option
    And the selected filter shall be displayed at top left section
    Then list of history records are displayed to user
    #step13
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    #step14
    When the user selects 24hrs filter checkbox
    Then list of history records are displayed to user
    #step15,16
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                       |
      | ic-test-tech@capgemini.com |

  @history_TC2789
  Scenario Outline: TC2789 - Hospital Admin_Verify combined search & filter functionalities on history screen.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    #step2,3,4
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
    #step5
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    #step6
    When the user enters a patient first name in search box
    And the user clicks on Search Button on history page
    Then the entered patient record shall be displayed in 24hrs filter
    #step7
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step8
    When clicks on file status & selects any status
    And click on Done button from the filter option
    Then the 24hrs checkbox filter shall be removed automatically
    And the selected filter shall be displayed at top left section
    And list of history records are displayed to user
    #step9
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step10
    When clicks on site option & selects any site
    And click on Done button from the filter option
    And the selected filter shall be displayed at top left section
    Then list of history records are displayed to user
    #step11
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step12
    When clicks on uploader option & selects any uploader
    And click on Done button from the filter option
    And the selected filter shall be displayed at top left section
    Then list of history records are displayed to user
    #step13
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    #step14
    When the user selects 24hrs filter checkbox
    Then list of history records are displayed to user
    #step15,16
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

  @history_TC2790
  Scenario Outline: TC2790 - Surgeon_Verify combined search & filter functionalities on history screen.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    #step2,3,4
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
    #step5
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    #step6
    When the user enters a patient first name in search box
    And the user clicks on Search Button on history page
    Then the entered patient record shall be displayed in 24hrs filter
    #step7
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step8
    When clicks on file status & selects any status
    And click on Done button from the filter option
    Then the 24hrs checkbox filter shall be removed automatically
    And the selected filter shall be displayed at top left section
    And list of history records are displayed to user
    #step9
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step10
    When clicks on site option & selects any site
    And click on Done button from the filter option
    And the selected filter shall be displayed at top left section
    Then list of history records are displayed to user
    #step11
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step12
    When clicks on uploader option & selects any uploader
    And click on Done button from the filter option
    And the selected filter shall be displayed at top left section
    Then list of history records are displayed to user
    #step13
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    #step14
    When the user selects 24hrs filter checkbox
    Then list of history records are displayed to user
    #step15,16
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                          |
      | ic-test-surgeon@capgemini.com |

  @history_TC2791
  Scenario Outline: TC2791 - Support-staff_Verify combined search & filter functionalities on history screen.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    #step2,3,4
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
    #step5
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    #step6
    When the user enters a patient first name in search box
    And the user clicks on Search Button on history page
    Then the entered patient record shall be displayed in 24hrs filter
    #step7
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step8
    When clicks on file status & selects any status
    And click on Done button from the filter option
    Then the 24hrs checkbox filter shall be removed automatically
    And the selected filter shall be displayed at top left section
    And list of history records are displayed to user
    #step9
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step10
    When clicks on site option & selects any site
    And click on Done button from the filter option
    And the selected filter shall be displayed at top left section
    Then list of history records are displayed to user
    #step11
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step12
    When clicks on uploader option & selects any uploader
    And click on Done button from the filter option
    And the selected filter shall be displayed at top left section
    Then list of history records are displayed to user
    #step13
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    #step14
    When the user selects 24hrs filter checkbox
    Then list of history records are displayed to user
    #step15,16
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                        |
      | ic-test-staff@capgemini.com |

  @history_TC2792
  Scenario Outline: TC2792 - S&N HIL Manager_Verify combined search & filter functionalities on history screen.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And Choose Site screen is displayed
    Then Search for hospital
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    Then Upload dashboad page is displayed to user
    And the dashboard summary shall display list of upload items
    #step2,3,4
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
    #step5
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    #step6
    When the user enters a patient first name in search box
    And the user clicks on Search Button on history page
    Then the entered patient record shall be displayed in 24hrs filter
    #step7
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step8
    When clicks on file status & selects any status
    And click on Done button from the filter option
    Then the 24hrs checkbox filter shall be removed automatically
    And the selected filter shall be displayed at top left section
    And list of history records are displayed to user
    #step9
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step10
    When clicks on site option & selects any site
    And click on Done button from the filter option
    And the selected filter shall be displayed at top left section
    Then list of history records are displayed to user
    #step11
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
    #step12
    When clicks on uploader option & selects any uploader
    And click on Done button from the filter option
    And the selected filter shall be displayed at top left section
    Then list of history records are displayed to user
    #step13
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    #step14
    When the user selects 24hrs filter checkbox
    Then list of history records are displayed to user
    #step15,16
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |