Feature: SSR2644 - Verifying Data Upload utility shall filter the audit log, upload dashboard, imaging links, and history pages based on the organization selected by the S&N HIL Manager.

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

  @history_TC2821
  Scenario Outline: TC2821 - SN HIL Manager_Verify filter functionality on History screen.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And Choose Site screen is displayed
    Then Search for hospital
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    Then Upload dashboad page is displayed to user
    #Then Ensure at least 5 records shall be present on history which is 5 days counting back from current date for different patient surgeon application date and file status
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
    Then the records are sorted by Date in Descending order by default with arrow "facing down"
    When the user clicks on filter button in history page
    #Then the filter by options shall be displayed with + as below
    #| option			|
    #| date				|
    #| uploader		|
    #| patient			|
    #| surgeon			|
    #| site				|
    #| file status	|
    #| done				|
    When the user clicks on date filter option on history page
    Then the start and end boxes shall be displayed
    When the user clicks on start date button
    And the user selects two days back from current date as start date
    And the user clicks on end date button
    And the user selects end date as current date
    Then the dates shall be selected in start and end date
    And the user clicks on done button to close the filter option
    And the selected date shall be displayed on the top of history screen
    And the history record table shall be filtered out as per selected date
    When the user clicks on the header "Date"
    Then the records should sort in "ascending" order as per "Date" indicated by arrow "facing up"
    When the user clicks on filter button in history page
    And the user clicks on + for uploader filter
    Then the uploader names shall be displayed
    #And the uploader list shall have no duplicates
    When the user selects any uploader name
    And the user clicks on done button to close the filter option
    And the selected uploader name and date shall be displayed on the top of history screen
    And the history record table shall be filtered out as per selected uploader name and dates
    #When the user clicks on the header "Upload User"
    #Then the records should sort in "descending" order as per "Upload User" indicated by arrow "facing down"
    When the user clicks on x to remove the filters
    #Then the selected filter shall be removed
    When the user clicks on filter button in history page
    And the user clicks on + for patient filter
    Then the uploader names shall be displayed
    When the user selects any patient name
    And the user clicks on done button to close the filter option
    And the selected patient name shall be displayed on the top of history screen
    And the history record table shall be filtered out as per selected patient name
    #When the user clicks on the header "Patient"
    #Then the records should sort in "descending" order as per "Patient" indicated by arrow "facing down"
    When the user clicks on filter button in history page
    And the user deselects patient name
    And the user click on + for surgeon
    Then the surgeon names shall be displayed
    When the user selects any surgeon name
    And the user clicks on done button to close the filter option
    And the selected surgeon name shall be displayed on the top of history screen
    And the history record table shall be filtered out as per selected surgeon name
    #When the user clicks on the header "Doctor"
    #Then the records should sort in "descending" order as per "Doctor" indicated by arrow "facing down"
    When the user clicks on filter button in history page
    And the user deselects surgeon name
    And the user click on + for site
    Then the user selects any site name
    And the user click on + for file status
    Then the user selects any file status
    Then the site and file status names shall be displayed
    And the user clicks on done button to close the filter option
    And the selected site and file status name shall be displayed on the top of history screen
    And the history record table shall be filtered out as per selected site and file status name
    #When the user clicks on the header "Hospital"
    #Then the records should sort in "descending" order as per "Hospital" indicated by arrow "facing down"
    #When the user clicks on the header "Status"
    #Then the records should sort in "descending" order as per "Status" indicated by arrow "facing down"
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |

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
    #Then the history screen shall be displayed records as per entered upload user
    Then list of history records are displayed to user
    #step6
    When the user clicks on Filter Option
    And click on uploader icon & selects another uploader name
    And click on Done button from the filter option
    #Then the different uploader shall be selected
    #And the previous entered upload user shall be displayed in search box
    Then the history view shall be displayed as no data to display
    #step7
    When the user removes upload user text from searchbox
    And the user clicks on Search Button on history page
    #Then the history screen shall be filtered out as per selected upload user
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

  @history_TC1123
  Scenario Outline: TC1123 - S&N HIL Manager_Verify S&N HIL Manager can view all users upload activity from an organization in summary dashboard and history
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    When Clicks on Upload Button
    Then the Site selection screen is displayed
    When the user selects a site and click on next button
    Then the Site is selected
    And the Surgeon selection screen is displayed
    When the user selects a surgeon and click on next button
    Then the Surgeon is selected
    And the Application selection screen is displayed
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on Browse PC button and select a valid DICOM file and upload
    Then upload successful screen is displayed
    Then the user clicks file dashboard in left menu
    And Data-Upload Application is closed
    Given that the user is logged in to Data-Upload Utility Application through chrome "<secondUser>"
    Then the uploaded entry is shown on the upload dashboard
    When User clicks on History button from homepage
    Then the uploaded entry is shown in the history page table
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    When Clicks on Upload Button
    Then the Site selection screen is displayed
    When the user selects a site and click on next button
    Then the Site is selected
    And the Surgeon selection screen is displayed
    When the user selects a surgeon and click on next button
    Then the Surgeon is selected
    And the Application selection screen is displayed
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on Browse PC button and select a valid DICOM file and upload
    Then upload successful screen is displayed
    Then the user clicks file dashboard in left menu
    And Data-Upload Application is closed
    Given that the user is logged in to Data-Upload Utility Application through chrome "<thirdUser>"
    When Choose Canton Health Center Site and click next button
    Then the uploaded entry is shown on the upload dashboard
    When User clicks on History button from homepage
    Then the uploaded entry is shown in the history page table
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

    Examples: 
      | user                       | secondUser                  | thirdUser                             |
      | ic-test-user@capgemini.com | ic-test-admin@capgemini.com | ic-test-snn-hil-manager@capgemini.com |
