Feature: SSR1831 - Data Upload Utility web application history view shall be searchable by any of the fields including surgeon name, patient name, application name, facility name, status, upload user first name, upload user last name

  @history_TC0865
  Scenario: TC0865-  IC Admin_Verify search functionality on History screen
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    #Given Ensure at least 5 records should be present on History screen for different patient, surgeon and file status
    #step2
    When User clicks on History button from homepage
    Then history screen is displayed
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
    #step3
    Then Search Box is displayed
    And Search Button is displayed
    #step4
    Then the below table header shall be displayed on history page
      | header      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    #step5
    Then enter any "Patient first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step6
    Then enter any "Patient last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step7
    Then enter any "Hospital name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step8
    Then enter any "Application name" in the Search bar and click on Search button and verify result in view details
      | Test data                           |
      | combination of lower and upper case |
    #step9
    When the user selects any record displayed on record entry table and Click on View details button
    Then the View detail pop up is opened
    And the Application name is matched with searched Application
    #step10
    Then enter any "Uploader first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step11
    Then enter any "Uploader last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step12
    Then enter any "Surgeon first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step13
    Then enter any "Surgeon last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step14
    Then enter any "Upload status" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #Step15
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

  @history_TC2780
  Scenario: TC2780 -  IC Technician_Verify search functionality on History screen
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech@capgemini.com"
    And Upload dashboad page is displayed to user
    #Given Ensure at least 5 records should be present on History screen for different patient, surgeon and file status
    #step2
    When User clicks on History button from homepage
    Then history screen is displayed
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
    #step3
    Then Search Box is displayed
    And Search Button is displayed
    #step4
    Then the below table header shall be displayed on history page
      | header      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    #step5
    Then enter any "Patient first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step6
    Then enter any "Patient last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step7
    Then enter any "Hospital name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step8
    Then enter any "Application name" in the Search bar and click on Search button and verify result in view details
      | Test data                           |
      | combination of lower and upper case |
    #step9
    When the user selects any record displayed on record entry table and Click on View details button
    Then the View detail pop up is opened
    And the Application name is matched with searched Application
    #step10
    Then enter any "Uploader first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step11
    Then enter any "Uploader last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step12
    Then enter any "Surgeon first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step13
    Then enter any "Surgeon last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step14
    Then enter any "Upload status" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #Step15
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

  @history_TC2781
  Scenario: TC2781 -  Hospital Admin_Verify search functionality on History screen
    Given that the user is logged in to Data-Upload Utility Application through chrome "h-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    #Given Ensure at least 5 records should be present on History screen for different patient, surgeon and file status
    #step2
    When User clicks on History button from homepage
    Then history screen is displayed
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
    #step3
    Then Search Box is displayed
    And Search Button is displayed
    #step4
    Then the below table header shall be displayed on history page
      | header      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    #step5
    Then enter any "Patient first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step6
    Then enter any "Patient last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step7
    Then enter any "Hospital name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step8
    Then enter any "Application name" in the Search bar and click on Search button and verify result in view details
      | Test data                           |
      | combination of lower and upper case |
    #step9
    When the user selects any record displayed on record entry table and Click on View details button
    Then the View detail pop up is opened
    And the Application name is matched with searched Application
    #step10
    Then enter any "Uploader first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step11
    Then enter any "Uploader last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step12
    Then enter any "Surgeon first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step13
    Then enter any "Surgeon last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step14
    Then enter any "Upload status" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #Step15
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

  @history_TC2782
  Scenario: TC2782 -  Surgeon_Verify search functionality on History screen
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
    #Given Ensure at least 5 records should be present on History screen for different patient, surgeon and file status
    #step2
    When User clicks on History button from homepage
    Then history screen is displayed
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
    #step3
    Then Search Box is displayed
    And Search Button is displayed
    #step4
    Then the below table header shall be displayed on history page
      | header      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    #step5
    Then enter any "Patient first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step6
    Then enter any "Patient last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step7
    Then enter any "Hospital name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step8
    Then enter any "Application name" in the Search bar and click on Search button and verify result in view details
      | Test data                           |
      | combination of lower and upper case |
    #step9
    When the user selects any record displayed on record entry table and Click on View details button
    Then the View detail pop up is opened
    And the Application name is matched with searched Application
    #step10
    Then enter any "Uploader first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step11
    Then enter any "Uploader last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step12
    Then enter any "Surgeon first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step13
    Then enter any "Surgeon last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step14
    Then enter any "Upload status" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #Step15
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

  @history_TC2783
  Scenario: TC2783 -  Support Staff_Verify search functionality on History screen
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    And Upload dashboad page is displayed to user
    #Given Ensure at least 5 records should be present on History screen for different patient, surgeon and file status
    #step2
    When User clicks on History button from homepage
    Then history screen is displayed
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
    #step3
    Then Search Box is displayed
    And Search Button is displayed
    #step4
    Then the below table header shall be displayed on history page
      | header      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    #step5
    Then enter any "Patient first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step6
    Then enter any "Patient last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step7
    Then enter any "Hospital name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step8
    Then enter any "Application name" in the Search bar and click on Search button and verify result in view details
      | Test data                           |
      | combination of lower and upper case |
    #step9
    When the user selects any record displayed on record entry table and Click on View details button
    Then the View detail pop up is opened
    And the Application name is matched with searched Application
    #step10
    Then enter any "Uploader first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step11
    Then enter any "Uploader last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step12
    Then enter any "Surgeon first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step13
    Then enter any "Surgeon last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step14
    Then enter any "Upload status" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #Step15
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

  @history_TC2784
  Scenario: TC2784 -  S&N HIL Manager_Verify search functionality on History screen
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-snhilmanager@capgemini.com"
    Then Homepage is displayed to the user
    And Choose Site screen is displayed
    Then Search for hospital
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    Then Upload dashboad page is displayed to user
    #Given Ensure at least 5 records should be present on History screen for different patient, surgeon and file status
    #step2
    When User clicks on History button from homepage
    Then history screen is displayed
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
    #step3
    Then Search Box is displayed
    And Search Button is displayed
    #step4
    Then the below table header shall be displayed on history page
      | header      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    #step5
    Then enter any "Patient first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step6
    Then enter any "Patient last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step7
    Then enter any "Hospital name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step8
    Then enter any "Application name" in the Search bar and click on Search button and verify result in view details
      | Test data                           |
      | combination of lower and upper case |
    #step9
    When the user selects any record displayed on record entry table and Click on View details button
    Then the View detail pop up is opened
    And the Application name is matched with searched Application
    #step10
    Then enter any "Uploader first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step11
    Then enter any "Uploader last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step12
    Then enter any "Surgeon first name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step13
    Then enter any "Surgeon last name" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #step14
    Then enter any "Upload status" in the Search bar and click on Search button and verify result
      | Test data                           |
      | combination of lower and upper case |
      | lower case                          |
      | upper case                          |
    #Step15
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

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

  @history_TC0882
  Scenario Outline: TC0882 - IC Admin_Verify History records search and filter functionality by Invalid input data.
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
    #And Show More button is displayed
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
      | user                        |
      | ic-test-admin@capgemini.com |

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

  @history_TC1581
  Scenario Outline: TC1581 - Hospital_Admin_Verify History records search and filter functionality by Invalid input data.
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
      | user                       |
      | h-test-admin@capgemini.com |

  @history_TC1583
  Scenario Outline: TC1583 - Support-staff_Verify History records search and filter functionality by Invalid input data.
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
      | user                        |
      | ic-test-staff@capgemini.com |

  @history_TC1585
  Scenario Outline: TC1585 - S&N HIL Manager_Verify History records search and filter functionality by Invalid input data.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And Choose Site screen is displayed
    Then Search for hospital
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    Then Upload dashboad page is displayed to user
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
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |

  @history_TC1584
  Scenario Outline: TC1584 - IC Technician_Verify History records search and filter functionality by Invalid input data.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And Choose Site screen is displayed
    Then Search for hospital
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    Then Upload dashboad page is displayed to user
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
      | user                       |
      | ic-test-tech@capgemini.com |
