Feature: SSR1811 - Data Upload Utility web application summary dashboard shall have the mechanism to receive upload processing status and display it.

	@history_TC1119
  Scenario: TC1119 - IC Admin_Verify DUU Upload dashboard  screen and History screen reflects the file upload status as Uploaded and Recalled
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When the user clicks on dashbaord button from left menu bar
    Then the File upload screen is displayed
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    Then the Record uploaded is displayed at the top of the Upload dashboard screen with "Uploaded" status
    Then on mouse hover on Uploaded icon system should display the Uploaded status name
    When User clicks on History button from homepage
    Then history screen is displayed
    Then the stSatus "Uploaded" is displayed under Status column for the record uploaded
    When the user clicks on dashbaord button from left menu bar
    Then the recall button is displayed for the recently uploaded record
    When the user clicks recall button
    Then confirmation pop up for recall is displayed
    When the user clicks on confirm button in recall popup
    Then the record uploaded is disappeared from upload dashboard screen
    When User clicks on History button from homepage
    Then history screen is displayed
    Then the status "Recalled" is displayed under Status column for the record uploaded
    And the user clicks on exit to app button from left menu bar
    Then the right side header shall be displayed as exit to app works
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

	@history_TC2844
  Scenario: TC2844 - IC technician_Verify DUU Upload dashboard screen and History screen reflects the file status as Uploaded  and Recalled
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When the user clicks on dashbaord button from left menu bar
    Then the File upload screen is displayed
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    Then the Record uploaded is displayed at the top of the Upload dashboard screen with "Uploaded" status
    Then on mouse hover on Uploaded icon system should display the Uploaded status name
    When User clicks on History button from homepage
    Then history screen is displayed
    Then the stSatus "Uploaded" is displayed under Status column for the record uploaded
    When the user clicks on dashbaord button from left menu bar
    Then the recall button is displayed for the recently uploaded record
    When the user clicks recall button
    Then confirmation pop up for recall is displayed
    When the user clicks on confirm button in recall popup
    Then the record uploaded is disappeared from upload dashboard screen
    When User clicks on History button from homepage
    Then history screen is displayed
    Then the status "Recalled" is displayed under Status column for the record uploaded
    And the user clicks on exit to app button from left menu bar
    Then the right side header shall be displayed as exit to app works
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed
    
    @history_TC2845
  Scenario: TC2845 - Hospital Admin_Verify DUU Upload dashboard  screen and History screen reflects the file status as Uploaded and Recalled
    Given that the user is logged in to Data-Upload Utility Application through chrome "h-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When the user clicks on dashbaord button from left menu bar
    Then the File upload screen is displayed
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    Then the Record uploaded is displayed at the top of the Upload dashboard screen with "Uploaded" status
    Then on mouse hover on Uploaded icon system should display the Uploaded status name
    When User clicks on History button from homepage
    Then history screen is displayed
    Then the stSatus "Uploaded" is displayed under Status column for the record uploaded
    When the user clicks on dashbaord button from left menu bar
    Then the recall button is displayed for the recently uploaded record
    When the user clicks recall button
    Then confirmation pop up for recall is displayed
    When the user clicks on confirm button in recall popup
    Then the record uploaded is disappeared from upload dashboard screen
    When User clicks on History button from homepage
    Then history screen is displayed
    Then the status "Recalled" is displayed under Status column for the record uploaded
    And the user clicks on exit to app button from left menu bar
    Then the right side header shall be displayed as exit to app works
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed
    
    
     @history_TC2846
  Scenario: TC2846 - Surgeon_Verify DUU upload dashboard screen and History screen reflects the file upload status as Uploaded and Recalled
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When the user clicks on dashbaord button from left menu bar
    Then the File upload screen is displayed
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    Then the Record uploaded is displayed at the top of the Upload dashboard screen with "Uploaded" status
    Then on mouse hover on Uploaded icon system should display the Uploaded status name
    When User clicks on History button from homepage
    Then history screen is displayed
    Then the stSatus "Uploaded" is displayed under Status column for the record uploaded
    When the user clicks on dashbaord button from left menu bar
    Then the recall button is displayed for the recently uploaded record
    When the user clicks recall button
    Then confirmation pop up for recall is displayed
    When the user clicks on confirm button in recall popup
    Then the record uploaded is disappeared from upload dashboard screen
    When User clicks on History button from homepage
    Then history screen is displayed
    Then the status "Recalled" is displayed under Status column for the record uploaded
    And the user clicks on exit to app button from left menu bar
    Then the right side header shall be displayed as exit to app works
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed
    
    @history_TC2847
  Scenario: TC2847 - Support staff_Verify DUU Upload dashboard screen and History screen reflects the file status as Uploaded and Recalled
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-supportstaff@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When the user clicks on dashbaord button from left menu bar
    Then the File upload screen is displayed
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    Then the Record uploaded is displayed at the top of the Upload dashboard screen with "Uploaded" status
    Then on mouse hover on Uploaded icon system should display the Uploaded status name
    When User clicks on History button from homepage
    Then history screen is displayed
    Then the stSatus "Uploaded" is displayed under Status column for the record uploaded
    When the user clicks on dashbaord button from left menu bar
    Then the recall button is displayed for the recently uploaded record
    When the user clicks recall button
    Then confirmation pop up for recall is displayed
    When the user clicks on confirm button in recall popup
    Then the record uploaded is disappeared from upload dashboard screen
    When User clicks on History button from homepage
    Then history screen is displayed
    Then the status "Recalled" is displayed under Status column for the record uploaded
    And the user clicks on exit to app button from left menu bar
    Then the right side header shall be displayed as exit to app works
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed
    
    @history_TC3164
  Scenario: TC3164 - S&N HIL Manager_Verify DUU Upload dashboard screen and History screen reflects the file status as Uploaded and Recalled
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-snhilmanager@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When the user clicks on dashbaord button from left menu bar
    Then the File upload screen is displayed
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    Then the Record uploaded is displayed at the top of the Upload dashboard screen with "Uploaded" status
    Then on mouse hover on Uploaded icon system should display the Uploaded status name
    When User clicks on History button from homepage
    Then history screen is displayed
    Then the stSatus "Uploaded" is displayed under Status column for the record uploaded
    When the user clicks on dashbaord button from left menu bar
    Then the recall button is displayed for the recently uploaded record
    When the user clicks recall button
    Then confirmation pop up for recall is displayed
    When the user clicks on confirm button in recall popup
    Then the record uploaded is disappeared from upload dashboard screen
    When User clicks on History button from homepage
    Then history screen is displayed
    Then the status "Recalled" is displayed under Status column for the record uploaded
    And the user clicks on exit to app button from left menu bar
    Then the right side header shall be displayed as exit to app works
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed
    
  @history_TC2849
  Scenario: TC2849 - Hospital Admin_Verify DUU Upload dashboard screen and History screen reflects the file status as Processing
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
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
    
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    When the user clicks on dashbaord button from left menu bar
    Then the File upload screen is displayed
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    
    
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed
    
 @history_TC1126
  Scenario: TC1126 - IC Admin_Verify DUU Upload dashboard screen and History screen reflects the file status as Processing
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
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
    
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    When the user clicks on dashbaord button from left menu bar
    Then the File upload screen is displayed
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    
    
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed
    
 @history_TC2848
  Scenario: TC2848 - IC Technician_Verify DUU Upload dashboard screen and History screen reflects the file status as Processing
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    And Upload dashboad page is displayed to user
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
    
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    When the user clicks on dashbaord button from left menu bar
    Then the File upload screen is displayed
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    
    
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed
    
   @history_TC2851
  Scenario: TC2851 - Support Staff_Verify DUU Upload dashboard screen and History screen reflects the file status as Processing
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    And Upload dashboad page is displayed to user
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
    
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    When the user clicks on dashbaord button from left menu bar
    Then the File upload screen is displayed
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    
    
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed
    
  @history_TC2850
  Scenario: TC2850 - Surgeon_Verify DUU Upload dashboard screen and History screen reflects the file status as Processing
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    When the user clicks on dashbaord button from left menu bar
    Then the File upload screen is displayed
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed
    
    
  @history_TC1127
  Scenario: TC1127 - IC Admin_Verify DUU upload summary dashboard & history screen shall reflect the file state as Complete
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    When User clicks on History button from homepage
    Then history screen is displayed
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application.  
    
    
  @history_TC2856
  Scenario: TC2856 - IC Technician_Verify DUU upload summary dashboard & history screen shall reflect the file state as Complete
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    And Upload dashboad page is displayed to user
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    When User clicks on History button from homepage
    Then history screen is displayed
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application.  
    
    
  @history_TC2857
  Scenario: TC2857 - Hospital Admin_Verify DUU upload summary dashboard & history screen shall reflect the file state as Complete
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    When User clicks on History button from homepage
    Then history screen is displayed
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application. 
    
 @history_TC2858
  Scenario: TC2858 - Surgeon_Verify DUU upload summary dashboard & history screen shall reflect the file state as Complete
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    When User clicks on History button from homepage
    Then history screen is displayed
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application. 
    
  @history_TC2859
  Scenario: TC2859 - Support Staff_Verify DUU upload summary dashboard & history screen shall reflect the file state as Complete
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    And Upload dashboad page is displayed to user
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    When User clicks on History button from homepage
    Then history screen is displayed
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application. 
    
    
  @history_TC3160
  Scenario: TC3160 - SN HIL Manager_Verify DUU upload summary dashboard & history screen shall reflect the file state as Complete
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-snhilmanager@capgemini.com"
    And Upload dashboad page is displayed to user
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    When User clicks on History button from homepage
    Then history screen is displayed
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application. 
    
    
  @history_TC1130
  Scenario: TC1130 - IC Admin_Verify DUU upload summary dashboard & history screen shall reflect the file state as Error
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    When User clicks on History button from homepage
    Then history screen is displayed
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application.  
    
 @history_TC2852
  Scenario: TC2852 - IC Technician_Verify DUU upload summary dashboard & history screen shall reflect the file state as Error
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    When User clicks on History button from homepage
    Then history screen is displayed
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application. 
    
    
  @history_TC2853
  Scenario: TC2853 - Hospital Admin_Verify DUU upload summary dashboard & history screen shall reflect the file state as Error
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    When User clicks on History button from homepage
    Then history screen is displayed
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application. 
    
    
  @history_TC2854
  Scenario: TC2854 - Surgeon_Verify DUU upload summary dashboard & history screen shall reflect the file state as Error
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    When User clicks on History button from homepage
    Then history screen is displayed
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application. 
    
    
  @history_TC2855
  Scenario: TC2855 - Support Staff_Verify DUU upload summary dashboard & history screen shall reflect the file state as Error
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    When User clicks on History button from homepage
    Then history screen is displayed
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application. 
    
    
  @history_TC3161
  Scenario: TC3161 - SN HIL Manager_Verify DUU upload summary dashboard & history screen shall reflect the file state as Error
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-snn-hil-manager@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    When User clicks on History button from homepage
    Then history screen is displayed
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application. 
    
    
 @SSR1811_TC3159
 Scenario: TC3159 - SN HIL Manager_Verify DUU upload summary dashboard & history screen shall reflect the file state as Processing
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-snn-hil-manager@capgemini.com"
    And Upload dashboad page is displayed to user
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
    When User clicks on History button from homepage
    Then history screen is displayed
    Then record the uploadId of the file uploaded
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    Then the records are displayed in tabular format with
      | Columns                                     |
      | Status symbol for each uploaded status      |
      | Surgeon name and uploaded date              |
      | Patient name with DOB                       |
      | Application name with no. of files uploaded |
    When User clicks on History button from homepage
    Then history screen is displayed
    And the user clicks on exit to app button from left menu bar
    When user clicks on Logout icon from left panel
    Then user is logout from the application. 
 