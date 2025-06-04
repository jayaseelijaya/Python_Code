Feature: SSR3475 - Data Upload Utility web application shall provide a show more function to append more entry records in the upload dashboard, history, and audit log page

  @history_TC1134

  Scenario Outline: TC1134 - IC Admin_Verify Usability of History screen
    
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on history button from left menu bar
    Then the history tab shall be displayed
    And History label at the top left side is highlighted in white color
    And the below table header shall be displayed on history page
      | header      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    And the scroll bar shall be displayed at the left side
    And the scroll bar shall be displayed in green colour
    And View Details button in disabled mode is displayed
    And the user clicks on the first entry in the history page
    And the View Details button is in enabled mode
   #And Show More button is displayed
    And the 24hrs filter checkbox shall be displayed
    When the user selects 24hrs filter checkbox
    Then the 24hrs checkbox shall be highlighted in green colour
    And the filter button shall be displayed
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
     And the user clicks on + for uploader filter
     And the user clicks on + for patient filter
     And the user click on + for surgeon
     And the user click on + for site
     And the user click on + for file status
     And click on Done button from the filter option
     And the search bar shall be displayed
     And the search button shall be displayed on history screen
     When the user clicks on filter button in history page
     When the user clicks on date filter option on history page
     Then the start and end boxes shall be displayed
     When the user clicks on start date button
     And the user selects two days back from current date as start date
     And the user clicks on end date button
     And the user selects end date as current date
     Then the dates shall be selected in start and end date
     And click on Done button from the filter option
     And the selected date shall be displayed on the top of history screen
     And the history record table shall be filtered out as per selected date
     And the user selects 24hrs filter checkbox
     Then the filter block gets removed
     When the user clicks on Filter Button
     And the user click on + for surgeon
     Then the user selects any surgeon name
     And the user clicks on done button to close the filter option
     When the user clicks on upload status button from left menu bar
     Then the following components shall be displayed on right side of upload status
      | status                 |
      | upload status heading  |
     When the user clicks on history button from left menu bar
     Then the history tab shall be displayed
     Then the filter block gets removed
     When the user enters a patient first name in search box
     And the user clicks on Search Button on history page
     Then list of history records are displayed to user
     When user clicks on file dashboard page and verifies the header
     And the user clicks on history button from left menu bar
     Then the history tab shall be displayed
     When the user clicks on exit to app button from left menu bar
     And user clicks on Logout icon from left panel
     Then user is logout from the application.
    

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
      
 @history_TC7712

  Scenario Outline: TC7712 - IC Technician_Verify Usability of History screen
    
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on history button from left menu bar
    Then the history tab shall be displayed
    And History label at the top left side is highlighted in white color
    And the below table header shall be displayed on history page
      | header      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    And the scroll bar shall be displayed at the left side
    And the scroll bar shall be displayed in green colour
    And View Details button in disabled mode is displayed
    And the user clicks on the first entry in the history page
    And the View Details button is in enabled mode
   #And Show More button is displayed
    And the 24hrs filter checkbox shall be displayed
    When the user selects 24hrs filter checkbox
    Then the 24hrs checkbox shall be highlighted in green colour
    And the filter button shall be displayed
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
     And the user clicks on + for uploader filter
     And the user clicks on + for patient filter
     And the user click on + for surgeon
     And the user click on + for site
     And the user click on + for file status
     And click on Done button from the filter option
     And the search bar shall be displayed
     And the search button shall be displayed on history screen
     When the user clicks on filter button in history page
     When the user clicks on date filter option on history page
     Then the start and end boxes shall be displayed
     When the user clicks on start date button
     And the user selects two days back from current date as start date
     And the user clicks on end date button
     And the user selects end date as current date
     Then the dates shall be selected in start and end date
     And click on Done button from the filter option
     And the selected date shall be displayed on the top of history screen
     And the history record table shall be filtered out as per selected date
     And the user selects 24hrs filter checkbox
     Then the filter block gets removed
     When the user clicks on Filter Button
     And the user click on + for surgeon
     Then the user selects any surgeon name
     And the user clicks on done button to close the filter option
     When the user clicks on upload status button from left menu bar
     Then the following components shall be displayed on right side of upload status
      | status                 |
      | upload status heading  |
     When the user clicks on history button from left menu bar
     Then the history tab shall be displayed
     Then the filter block gets removed
     When the user enters a patient first name in search box
     And the user clicks on Search Button on history page
     Then list of history records are displayed to user
     When user clicks on file dashboard page and verifies the header
     And the user clicks on history button from left menu bar
     Then the history tab shall be displayed
     When the user clicks on exit to app button from left menu bar
     And user clicks on Logout icon from left panel
     Then user is logout from the application.
    

    Examples: 
      | user                        |
      | ic-test-user@capgemini.com |
      
  @history_TC7713

  Scenario Outline: TC7713 - Hospital Admin_Verify Usability of History screen
    
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on history button from left menu bar
    Then the history tab shall be displayed
    And History label at the top left side is highlighted in white color
    And the below table header shall be displayed on history page
      | header      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    And the scroll bar shall be displayed at the left side
    And the scroll bar shall be displayed in green colour
    And View Details button in disabled mode is displayed
    And the user clicks on the first entry in the history page
    And the View Details button is in enabled mode
   #And Show More button is displayed
    And the 24hrs filter checkbox shall be displayed
    When the user selects 24hrs filter checkbox
    Then the 24hrs checkbox shall be highlighted in green colour
    And the filter button shall be displayed
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
     And the user clicks on + for uploader filter
     And the user clicks on + for patient filter
     And the user click on + for surgeon
     And the user click on + for site
     And the user click on + for file status
     And click on Done button from the filter option
     And the search bar shall be displayed
     And the search button shall be displayed on history screen
     When the user clicks on filter button in history page
     When the user clicks on date filter option on history page
     Then the start and end boxes shall be displayed
     When the user clicks on start date button
     And the user selects two days back from current date as start date
     And the user clicks on end date button
     And the user selects end date as current date
     Then the dates shall be selected in start and end date
     And click on Done button from the filter option
     And the selected date shall be displayed on the top of history screen
     And the history record table shall be filtered out as per selected date
     And the user selects 24hrs filter checkbox
     Then the filter block gets removed
     When the user clicks on Filter Button
     And the user click on + for surgeon
     Then the user selects any surgeon name
     And the user clicks on done button to close the filter option
     When the user clicks on upload status button from left menu bar
     Then the following components shall be displayed on right side of upload status
      | status                 |
      | upload status heading  |
     When the user clicks on history button from left menu bar
     Then the history tab shall be displayed
     Then the filter block gets removed
     When the user enters a patient first name in search box
     And the user clicks on Search Button on history page
     Then list of history records are displayed to user
     When user clicks on file dashboard page and verifies the header
     And the user clicks on history button from left menu bar
     Then the history tab shall be displayed
     When the user clicks on exit to app button from left menu bar
     And user clicks on Logout icon from left panel
     Then user is logout from the application.
    

    Examples: 
      | user                        |
      | ic-test-user@capgemini.com |
 
  @history_TC7714

  Scenario Outline: TC7714 - Surgeon_Verify Usability of History screen
    
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on history button from left menu bar
    Then the history tab shall be displayed
    And History label at the top left side is highlighted in white color
    And the below table header shall be displayed on history page
      | header      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    And the scroll bar shall be displayed at the left side
    And the scroll bar shall be displayed in green colour
    And View Details button in disabled mode is displayed
    And the user clicks on the first entry in the history page
    And the View Details button is in enabled mode
   #And Show More button is displayed
    And the 24hrs filter checkbox shall be displayed
    When the user selects 24hrs filter checkbox
    Then the 24hrs checkbox shall be highlighted in green colour
    And the filter button shall be displayed
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
     And the user clicks on + for uploader filter
     And the user clicks on + for patient filter
     And the user click on + for surgeon
     And the user click on + for site
     And the user click on + for file status
     And click on Done button from the filter option
     And the search bar shall be displayed
     And the search button shall be displayed on history screen
     When the user clicks on filter button in history page
     When the user clicks on date filter option on history page
     Then the start and end boxes shall be displayed
     When the user clicks on start date button
     And the user selects two days back from current date as start date
     And the user clicks on end date button
     And the user selects end date as current date
     Then the dates shall be selected in start and end date
     And click on Done button from the filter option
     And the selected date shall be displayed on the top of history screen
     And the history record table shall be filtered out as per selected date
     And the user selects 24hrs filter checkbox
     Then the filter block gets removed
     When the user clicks on Filter Button
     And the user click on + for surgeon
     Then the user selects any surgeon name
     And the user clicks on done button to close the filter option
     When the user clicks on upload status button from left menu bar
     Then the following components shall be displayed on right side of upload status
      | status                 |
      | upload status heading  |
     When the user clicks on history button from left menu bar
     Then the history tab shall be displayed
     Then the filter block gets removed
     When the user enters a patient first name in search box
     And the user clicks on Search Button on history page
     Then list of history records are displayed to user
     When user clicks on file dashboard page and verifies the header
     And the user clicks on history button from left menu bar
     Then the history tab shall be displayed
     When the user clicks on exit to app button from left menu bar
     And user clicks on Logout icon from left panel
     Then user is logout from the application.
    

    Examples: 
      | user                        |
      | ic-test-surgeon@capgemini.com |
      
   
  @history_TC7715

  Scenario Outline: TC7715 - Support Staff_Verify Usability of History screen
    
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on history button from left menu bar
    Then the history tab shall be displayed
    And History label at the top left side is highlighted in white color
    And the below table header shall be displayed on history page
      | header      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    And the scroll bar shall be displayed at the left side
    And the scroll bar shall be displayed in green colour
    And View Details button in disabled mode is displayed
    And the user clicks on the first entry in the history page
    And the View Details button is in enabled mode
   #And Show More button is displayed
    And the 24hrs filter checkbox shall be displayed
    When the user selects 24hrs filter checkbox
    Then the 24hrs checkbox shall be highlighted in green colour
    And the filter button shall be displayed
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
     And the user clicks on + for uploader filter
     And the user clicks on + for patient filter
     And the user click on + for surgeon
     And the user click on + for site
     And the user click on + for file status
     And click on Done button from the filter option
     And the search bar shall be displayed
     And the search button shall be displayed on history screen
     When the user clicks on filter button in history page
     When the user clicks on date filter option on history page
     Then the start and end boxes shall be displayed
     When the user clicks on start date button
     And the user selects two days back from current date as start date
     And the user clicks on end date button
     And the user selects end date as current date
     Then the dates shall be selected in start and end date
     And click on Done button from the filter option
     And the selected date shall be displayed on the top of history screen
     And the history record table shall be filtered out as per selected date
     And the user selects 24hrs filter checkbox
     Then the filter block gets removed
     When the user clicks on Filter Button
     And the user click on + for surgeon
     Then the user selects any surgeon name
     And the user clicks on done button to close the filter option
     When the user clicks on upload status button from left menu bar
     Then the following components shall be displayed on right side of upload status
      | status                 |
      | upload status heading  |
     When the user clicks on history button from left menu bar
     Then the history tab shall be displayed
     Then the filter block gets removed
     When the user enters a patient first name in search box
     And the user clicks on Search Button on history page
     Then list of history records are displayed to user
     When user clicks on file dashboard page and verifies the header
     And the user clicks on history button from left menu bar
     Then the history tab shall be displayed
     When the user clicks on exit to app button from left menu bar
     And user clicks on Logout icon from left panel
     Then user is logout from the application.
    

    Examples: 
      | user                        |
      | ic-test-staff@capgemini.com |
      
  @history_TC7717

  Scenario Outline: TC7717 - SNN HIL Manager_Verify Usability of History screen
    
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on history button from left menu bar
    Then the history tab shall be displayed
    And History label at the top left side is highlighted in white color
    And the below table header shall be displayed on history page
      | header      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    And the scroll bar shall be displayed at the left side
    And the scroll bar shall be displayed in green colour
    And View Details button in disabled mode is displayed
    And the user clicks on the first entry in the history page
    And the View Details button is in enabled mode
   #And Show More button is displayed
    And the 24hrs filter checkbox shall be displayed
    When the user selects 24hrs filter checkbox
    Then the 24hrs checkbox shall be highlighted in green colour
    And the filter button shall be displayed
    When the user clicks on filter button in history page
    Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
     And the user clicks on + for uploader filter
     And the user clicks on + for patient filter
     And the user click on + for surgeon
     And the user click on + for site
     And the user click on + for file status
     And click on Done button from the filter option
     And the search bar shall be displayed
     And the search button shall be displayed on history screen
     When the user clicks on filter button in history page
     When the user clicks on date filter option on history page
     Then the start and end boxes shall be displayed
     When the user clicks on start date button
     And the user selects two days back from current date as start date
     And the user clicks on end date button
     And the user selects end date as current date
     Then the dates shall be selected in start and end date
     And click on Done button from the filter option
     And the selected date shall be displayed on the top of history screen
     And the history record table shall be filtered out as per selected date
     And the user selects 24hrs filter checkbox
     Then the filter block gets removed
     When the user clicks on Filter Button
     And the user click on + for surgeon
     Then the user selects any surgeon name
     And the user clicks on done button to close the filter option
     When the user clicks on upload status button from left menu bar
     Then the following components shall be displayed on right side of upload status
      | status                 |
      | upload status heading  |
     When the user clicks on history button from left menu bar
     Then the history tab shall be displayed
     Then the filter block gets removed
     When the user enters a patient first name in search box
     And the user clicks on Search Button on history page
     Then list of history records are displayed to user
     When user clicks on file dashboard page and verifies the header
     And the user clicks on history button from left menu bar
     Then the history tab shall be displayed
     When the user clicks on exit to app button from left menu bar
     And user clicks on Logout icon from left panel
     Then user is logout from the application.
    

    Examples: 
      | user                        |
      | ic-test-snn-hil-manager@capgemini.com |