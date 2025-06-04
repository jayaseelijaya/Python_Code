Feature: SSR1729 - Verifying user's upload History view

  @history_TC0863
  Scenario Outline: TC0863 - IC Admin_verify DDU web App shall allow view of User's upload history
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
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
    Then the Upload successful screen is displayed
    When the user clicks file dashboard in left menu
    Then Upload dashboad page is displayed to user
    And the uploaded files details shall be displayed as below
      | details                        |
      | Date of upload                 |
      | site									   			 |
      | Surgeon                        |
      | Patient name                   |
      | Application	and uploaded files |
      | Status of image uploaded       |
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
    And the history screen shall display uploaded details at the top
    And the details of uploaded record shall be displayed as below
      | record      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
      
  @history_TC2755
  Scenario Outline: TC2755 - Hospital Admin_verify DDU web App shall allow view of User's upload history
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
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
    Then the Upload successful screen is displayed
    When the user clicks file dashboard in left menu
    Then Upload dashboad page is displayed to user
    And the uploaded files details shall be displayed as below
      | details                        |
      | Date of upload                 |
      | site									   			 |
      | Surgeon                        |
      | Patient name                   |
      | Application	and uploaded files |
      | Status of image uploaded       |
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
    And the history screen shall display uploaded details at the top
    And the details of uploaded record shall be displayed as below
      | record      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-hospital-admin@capgemini.com |    
      
   @history_TC2756
  Scenario Outline: TC2756 - IC Technician_verify DDU web App shall allow view of User's upload history
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
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
    Then the Upload successful screen is displayed
    When the user clicks file dashboard in left menu
    Then Upload dashboad page is displayed to user
    And the uploaded files details shall be displayed as below
      | details                        |
      | Date of upload                 |
      | site									   			 |
      | Surgeon                        |
      | Patient name                   |
      | Application	and uploaded files |
      | Status of image uploaded       |
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
    And the history screen shall display uploaded details at the top
    And the details of uploaded record shall be displayed as below
      | record      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-user@capgemini.com  |     
      
    @history_TC2757
  Scenario Outline: TC2757 - Support Staff_verify DDU web App shall allow view of User's upload history
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
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
    Then the Upload successful screen is displayed
    When the user clicks file dashboard in left menu
    Then Upload dashboad page is displayed to user
    And the uploaded files details shall be displayed as below
      | details                        |
      | Date of upload                 |
      | site									   			 |
      | Surgeon                        |
      | Patient name                   |
      | Application	and uploaded files |
      | Status of image uploaded       |
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
    And the history screen shall display uploaded details at the top
    And the details of uploaded record shall be displayed as below
      | record      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-staff@capgemini.com  |  
      
  @history_TC2758
  Scenario Outline: TC2758 - Surgeon_verify DDU web App shall allow view of User's upload history
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
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
    Then the Upload successful screen is displayed
    When the user clicks file dashboard in left menu
    Then Upload dashboad page is displayed to user
    And the uploaded files details shall be displayed as below
      | details                        |
      | Date of upload                 |
      | site									   			 |
      | Surgeon                        |
      | Patient name                   |
      | Application	and uploaded files |
      | Status of image uploaded       |
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
    And the history screen shall display uploaded details at the top
    And the details of uploaded record shall be displayed as below
      | record      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-surgeon@capgemini.com  |        
      
   @history_TC2759
  Scenario Outline: TC2759 - SNN HIL Manager_verify DDU web App shall allow view of User's upload history
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And Choose Site screen is displayed
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    And the user clicks file dashboard in left menu
    Then Upload dashboad page is displayed to user
    And the uploaded files details shall be displayed as below
      | details                        |
      | Date of upload                 |
      | site									   			 |
      | Surgeon                        |
      | Patient name                   |
      | Application	and uploaded files |
      | Status of image uploaded       |
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
    And the history screen shall display uploaded details at the top
    And the details of uploaded record shall be displayed as below
      | record      |
      | date        |
      | upload id   |
      | upload user |
      | patient     |
      | doctor      |
      | hospital    |
      | status      |
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-snn-hil-manager@capgemini.com  |               

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