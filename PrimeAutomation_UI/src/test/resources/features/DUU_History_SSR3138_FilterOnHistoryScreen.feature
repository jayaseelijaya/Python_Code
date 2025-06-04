Feature: SSR3138 - Verifying filter functionality on history screen

  @history_TC0884
  Scenario Outline: TC0884 - IC Admin_Verify filter functionality on History screen.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    #Then Ensure at least 5 records shall be present on history which is 5 days counting back from current date for different patient surgeon application date and file status
    #step2
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
    #step3
    Then the records are sorted by Date in Descending order by default with arrow "facing down"
    #step4
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
     #step5
     When the user clicks on date filter option on history page
     Then the start and end boxes shall be displayed
     When the user clicks on start date button
     #step6
     And the user selects two days back from current date as start date
     And the user clicks on end date button
     And the user selects end date as current date
     Then the dates shall be selected in start and end date
     And the user clicks on done button to close the filter option
     And the selected date shall be displayed on the top of history screen
     And the history record table shall be filtered out as per selected date
     #step7
     When the user clicks on the header "Date"
     Then the records should sort in "ascending" order as per "Date" indicated by arrow "facing up"
     #step8
     When the user clicks on filter button in history page
     #step9
     And the user clicks on + for uploader filter  
     Then the uploader names shall be displayed
     #And the uploader list shall have no duplicates
     #step10
     When the user selects any uploader name
     And the user clicks on done button to close the filter option
     And the selected uploader name and date shall be displayed on the top of history screen
     And the history record table shall be filtered out as per selected uploader name and dates
     #step11
     #When the user clicks on the header "Upload User"
     #Then the records should sort in "descending" order as per "Upload User" indicated by arrow "facing down"
   #step12
    When the user clicks on x to remove the filters
    #Then the selected filter shall be removed
    #step13
    When the user clicks on filter button in history page
    #step14
    And the user clicks on + for patient filter 
    Then the uploader names shall be displayed
    #step15
    When the user selects any patient name
    And the user clicks on done button to close the filter option
    And the selected patient name shall be displayed on the top of history screen
    And the history record table shall be filtered out as per selected patient name
    #step16
    #When the user clicks on the header "Patient"
    #Then the records should sort in "descending" order as per "Patient" indicated by arrow "facing down"
    #step17
    When the user clicks on filter button in history page
    #step18
    And the user deselects patient name
    And the user click on + for surgeon 
    Then the surgeon names shall be displayed
    #step19
    When the user selects any surgeon name
    And the user clicks on done button to close the filter option
    And the selected surgeon name shall be displayed on the top of history screen
    And the history record table shall be filtered out as per selected surgeon name
    #step20
    #When the user clicks on the header "Doctor"
    #Then the records should sort in "descending" order as per "Doctor" indicated by arrow "facing down"
    #step21
    When the user clicks on filter button in history page
    #step22
    And the user deselects surgeon name
    And the user click on + for site 
    #step24
    Then the user selects any site name
    #step25
    And the user click on + for file status 
    #step26
    Then the user selects any file status
    Then the site and file status names shall be displayed
    And the user clicks on done button to close the filter option
    And the selected site and file status name shall be displayed on the top of history screen
    And the history record table shall be filtered out as per selected site and file status name
    #step27
    #When the user clicks on the header "Hospital"
    #Then the records should sort in "descending" order as per "Hospital" indicated by arrow "facing down"
    #step28
    #When the user clicks on the header "Status"
    #Then the records should sort in "descending" order as per "Status" indicated by arrow "facing down"
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
      
   @history_TC2817
  Scenario Outline: TC2817 - IC Technician_Verify filter functionality on History screen.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
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
      | user                        |
      | ic-test-user@capgemini.com |
      
    @history_TC2818
  Scenario Outline: TC2818 - Hospital Admin_Verify filter functionality on History screen.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
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
      | user                        |
      | ic-test-hospital-admin@capgemini.com |
      
    @history_TC2819
  Scenario Outline: TC2819 - Surgeon_Verify filter functionality on History screen.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
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
      | user                        |
      | ic-test-surgeon@capgemini.com |
      
    @history_TC2820
  Scenario Outline: TC2820 - Support Staff_Verify filter functionality on History screen.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
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
      | user                        |
      | ic-test-staff@capgemini.com |
      
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
      | user                        |
      | ic-test-snn-hil-manager@capgemini.com |           
    
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
    
    
    
    
    
    
    
    