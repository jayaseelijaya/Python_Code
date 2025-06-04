Feature: SSR1817 - Data Upload Utility web application shall provide a rationale for any failed file upload at the time of attempted upload\

@ImageUpload_TC3362
  Scenario: TC3362 - IC Admin_Verify Upload failure work flow from upload status screen
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
     ##Step 2
    When User clicks on Upload Files from left panel
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | close icon                                      |
      | I dont see my Site listed                       |
       ##Step 3
    When the user selects a site and click on next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
      ##Step 4
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 5
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
     ##Step 6
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 7
     When user selects dataset with "non-DICOM file" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
     ##Step 8
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
    ##Step 9
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 10
    When the user selects the record with Failed status then clicks View Details button 
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
    ##Step 11
    When the user clicks on the Re-Upload button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    And breadcrumb with Selected Site ,Surgeon and Application name is displayed
    ##Step 12
    When the user clicks on browse pc button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
     When user selects dataset with "non-DICOM file" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 13
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                       |
      | Upload File label                                                |
      | Selected Site-> Surgeon -> Application                           |
      | Upload Failed icon                                               |
      | Upload Failed text                                               |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                              |
      | Start New upload button                                          |
      | Re-upload button                                                 |
      ##Step 14
      When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 15
    When the user selects the record with Failed status then clicks View Details button 
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
    ##Step 16
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 18
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    
    @ImageUpload_TC7916
  Scenario: TC7916 - Hospital Admin_Verify Upload failure work flow from upload status screen
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
     ##Step 2
    When User clicks on Upload Files from left panel
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | close icon                                      |
      | I dont see my Site listed                       |
       ##Step 3
    Then self linked site is default selected and click on Next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
      ##Step 4
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 5
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
     ##Step 6
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 7
     When user selects dataset with "non-DICOM file" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
     ##Step 8
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
    ##Step 9
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 10
    When the user selects the record with Failed status then clicks View Details button 
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
    ##Step 11
    When the user clicks on the Re-Upload button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    And breadcrumb with Selected Site ,Surgeon and Application name is displayed
    ##Step 12
    When the user clicks on browse pc button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
     When user selects dataset with "non-DICOM file" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 13
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                       |
      | Upload File label                                                |
      | Selected Site-> Surgeon -> Application                           |
      | Upload Failed icon                                               |
      | Upload Failed text                                               |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                              |
      | Start New upload button                                          |
      | Re-upload button                                                 |
      ##Step 14
      When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 15
    When the user selects the record with Failed status then clicks View Details button 
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
      ##Step 16
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 18
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    
    @ImageUpload_TC7917
  Scenario: TC7917 - IC Technician_Verify Upload failure work flow from upload status screen
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    And Upload dashboad page is displayed to user
     ##Step 2
    When User clicks on Upload Files from left panel
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | close icon                                      |
      | I dont see my Site listed                       |
       ##Step 3
    When the user selects a site and click on next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
      ##Step 4
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 5
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
     ##Step 6
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 7
     When user selects dataset with "non-DICOM file" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
     ##Step 8
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
    ##Step 9
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 10
    When the user selects the record with Failed status then clicks View Details button 
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
    ##Step 11
    When the user clicks on the Re-Upload button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    And breadcrumb with Selected Site ,Surgeon and Application name is displayed
    ##Step 12
    When the user clicks on browse pc button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
     When user selects dataset with "non-DICOM file" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 13
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                       |
      | Upload File label                                                |
      | Selected Site-> Surgeon -> Application                           |
      | Upload Failed icon                                               |
      | Upload Failed text                                               |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                              |
      | Start New upload button                                          |
      | Re-upload button                                                 |
      ##Step 14
      When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 15
    When the user selects the record with Failed status then clicks View Details button 
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
      ##Step 16
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 18
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC7918
  Scenario: TC7918 - Support Staff_Verify Upload failure work flow from upload status screen. 
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    And Upload dashboad page is displayed to user
     ##Step 2
    When User clicks on Upload Files from left panel
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | close icon                                      |
      | I dont see my Site listed                       |
       ##Step 3
    Then self linked site is default selected and click on Next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
      ##Step 4
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 5
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
     ##Step 6
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 7
     When user selects dataset with "non-DICOM file" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
     ##Step 8
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
    ##Step 9
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 10
    When the user selects the record with Failed status then clicks View Details button 
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
    ##Step 11
    When the user clicks on the Re-Upload button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    And breadcrumb with Selected Site ,Surgeon and Application name is displayed
    ##Step 12
    When the user clicks on browse pc button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
     When user selects dataset with "non-DICOM file" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 13
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                       |
      | Upload File label                                                |
      | Selected Site-> Surgeon -> Application                           |
      | Upload Failed icon                                               |
      | Upload Failed text                                               |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                              |
      | Start New upload button                                          |
      | Re-upload button                                                 |
      ##Step 14
      When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 15
    When the user selects the record with Failed status then clicks View Details button 
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
      ##Step 16 
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 18
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    
    @ImageUpload_TC7919
  Scenario: TC7919 - Surgeon_Verify Upload failure work flow from upload status screen
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
     ##Step 2
    When User clicks on Upload Files from left panel
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | close icon                                      |
      | I dont see my Site listed                       |
       ##Step 3
    Then self linked site is default selected and click on Next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
      ##Step 4
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 5
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
     ##Step 6
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 7
     When user selects dataset with "non-DICOM file" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
     ##Step 8
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
    ##Step 9
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 10
    When the user selects the record with Failed status then clicks View Details button 
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
    ##Step 11
    When the user clicks on the Re-Upload button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    And breadcrumb with Selected Site ,Surgeon and Application name is displayed
    ##Step 12
    When the user clicks on browse pc button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
     When user selects dataset with "non-DICOM file" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 13
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                       |
      | Upload File label                                                |
      | Selected Site-> Surgeon -> Application                           |
      | Upload Failed icon                                               |
      | Upload Failed text                                               |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                              |
      | Start New upload button                                          |
      | Re-upload button                                                 |
      ##Step 14
      When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 15
    When the user selects the record with Failed status then clicks View Details button 
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) are not valid DICOM file(s) |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
      ##Step 16
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 18
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
  @ImageUpload_TC1142
  Scenario: TC1142 - IC Admin_Verify if DUU app displays Failure message when an empty folder with no images from the users computer file system is uploaded to the same account
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    When the user selects a site and click on next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    ##Step 5
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 6
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "an empty folder" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
    When the user clicks on upload button in the popup and record the time
    ##step12,13
    When the user clicks on dashbaord button from left menu bar
	And the right side header shall be displayed as upload dashboard
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC5099
  Scenario: TC5099- IC Technician_Verify if DUU app displays Failure message when an empty folder with no images from the users computer file system is uploaded to the same account
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    When the user selects a site and click on next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    ##Step 5
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 6
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "an empty folder" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
    When the user clicks on upload button in the popup and record the time
    ##step12,13
    When the user clicks on dashbaord button from left menu bar
	And the right side header shall be displayed as upload dashboard
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    
    @ImageUpload_TC5101
  	Scenario: TC5101- Hospital Admin_Verify if DUU app displays Failure message when an empty folder with no images from the users computer file system is uploaded to the same account
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    When the user selects a site and click on next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    ##Step 5
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 6
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "an empty folder" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
    When the user clicks on upload button in the popup and record the time
    ##step12,13
    When the user clicks on dashbaord button from left menu bar
	And the right side header shall be displayed as upload dashboard
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC5105
  	Scenario: TC5105 - Support Staff_Verify if DUU app displays Failure message when an empty folder with no images from the users computer file system is uploaded to the same account
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    When the user selects a site and click on next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    ##Step 5
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 6
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "an empty folder" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
    When the user clicks on upload button in the popup and record the time
    ##step12,13
    When the user clicks on dashbaord button from left menu bar
	And the right side header shall be displayed as upload dashboard
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    
    @ImageUpload_TC5102
  	Scenario: TC5102 - Surgeon_Verify if DUU app displays Failure message when an empty folder with no images from the users computer file system is uploaded to the same account
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    When the user selects a site and click on next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    ##Step 5
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 6
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "an empty folder" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
    When the user clicks on upload button in the popup and record the time
    ##step12,13
    When the user clicks on dashbaord button from left menu bar
	And the right side header shall be displayed as upload dashboard
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC0548
  Scenario: TC0548 - IC Admin_Verify user can select a folder containing subfolders of multiple images of dicom and non-dicom from the users computer
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    When the user selects a site and click on next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    ##Step 5
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 6
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "consists of 1 sub folder with Invalid DICOM files" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
    When the user clicks on upload button in the popup and record the time
    And the right side header shall be displayed as upload files
    And the breadcrumb list of selected site, surgeon and application shall be displayed at top
    Then selected files are not valid dicom files text shall be displayed
    And upload fail screen shall be displayed along with failed message
    And the start new button shall be displayed
    And re-upload button shall be displayed and highlighted in green color
    ##step12
    When the user clicks on dashbaord button from left menu bar
	And the right side header shall be displayed as upload dashboard
    #Step 18
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 19
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC7924
  Scenario: TC7924 - Support Staff_Verify user can select a folder containing subfolders of multiple images of dicom and non-dicom from the users computer
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    When the user selects a site and click on next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    ##Step 5
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 6
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "consists of 1 sub folder with Invalid DICOM files" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
    When the user clicks on upload button in the popup and record the time
    And the right side header shall be displayed as upload files
    And the breadcrumb list of selected site, surgeon and application shall be displayed at top
    Then selected files are not valid dicom files text shall be displayed
    And upload fail screen shall be displayed along with failed message
    And the start new button shall be displayed
    And re-upload button shall be displayed and highlighted in green color
    ##step12
    When the user clicks on dashbaord button from left menu bar
	And the right side header shall be displayed as upload dashboard
    #Step 18
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 19
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    Then user is logout from the application.
    
    @ImageUpload_TC7923
  Scenario: TC7923 - Surgeon_Verify user can select a folder containing subfolders of multiple images of dicom and non-dicom from the users computer
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    When the user selects a site and click on next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    ##Step 5
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 6
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "consists of 1 sub folder with Invalid DICOM files" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
    When the user clicks on upload button in the popup and record the time
    And the right side header shall be displayed as upload files
    And the breadcrumb list of selected site, surgeon and application shall be displayed at top
    Then selected files are not valid dicom files text shall be displayed
    And upload fail screen shall be displayed along with failed message
    And the start new button shall be displayed
    And re-upload button shall be displayed and highlighted in green color
    ##step12
    When the user clicks on dashbaord button from left menu bar
	And the right side header shall be displayed as upload dashboard
    #Step 18
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 19
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC7922
  Scenario: TC7922 - IC Technician_Verify user can select a folder containing subfolders of multiple images of dicom and non-dicom from the users computer
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    When the user selects a site and click on next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    ##Step 5
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 6
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "consists of 1 sub folder with Invalid DICOM files" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
    When the user clicks on upload button in the popup and record the time
    And the right side header shall be displayed as upload files
    And the breadcrumb list of selected site, surgeon and application shall be displayed at top
    Then selected files are not valid dicom files text shall be displayed
    And upload fail screen shall be displayed along with failed message
    And the start new button shall be displayed
    And re-upload button shall be displayed and highlighted in green color
    ##step12
    When the user clicks on dashbaord button from left menu bar
	And the right side header shall be displayed as upload dashboard
    #Step 18
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 19
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC7921
  Scenario: TC7921 - Hospital Admin_Verify user can select a folder containing subfolders of multiple images of dicom and non-dicom from the users computer
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    When the user selects a site and click on next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    ##Step 5
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 6
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "consists of 1 sub folder with Invalid DICOM files" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
    When the user clicks on upload button in the popup and record the time
    And the right side header shall be displayed as upload files
    And the breadcrumb list of selected site, surgeon and application shall be displayed at top
    Then selected files are not valid dicom files text shall be displayed
    And upload fail screen shall be displayed along with failed message
    And the start new button shall be displayed
    And re-upload button shall be displayed and highlighted in green color
    ##step12
    When the user clicks on dashbaord button from left menu bar
	And the right side header shall be displayed as upload dashboard
    #Step 18
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 19
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    