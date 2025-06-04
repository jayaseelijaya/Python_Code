Feature: SSR1724 - Data Upload Utility web application shall allow a user to select a folder of multiple images from the users computer file system for upload to the selected target hospital and the associated surgeon. 

  @ImageUpload_TC3393
  Scenario: TC3393 - IC Admin_Verify DUU web app allows to upload folder of 2 sub folders with DICOM files of 2 patients in each sub folder using drag & drop and displays failure message when DICOM files of size more than 3 GB is uploaded 
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
    #Step 5
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #Step 6
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects dataset with "two patients" and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the user is redirected to Image uploading screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Smith & Nephew logo                                             |
      | Loading bar                                                     |
      | Uploaded – shows the size of files being uploaded               |
      | Time Remaining                                                  |
      | Cancel upload button                                            |
      | Start Next Upload button                                        |
    ##Step 8
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
     | components                      |
     | Upload Successful               |
     | Close, Start New Upload         |
     | Dashboard button in green color |
    ##Step 9
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "first four" patients displayed
    ##Step 10
    Then the details of "four patients" matches with uploaded files
    ##Step 11
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 12
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 13
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 14
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
    #Step 15
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #Step 16
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 17
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects 3gb dataset with "single patients" and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the upload failure screen shall be displayed with following details
     | detail																													 |
     | Breadcrumb of selected Site name, surgeon name application name |
     | Failed icon																										 |
     | upload failed text																							 |
     | total size exceeded the limit of 3gb message										 |
     | yellow progress bar																						 |
     | start new upload and reupload buttons													 |
     #step18
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen 
    #Step 20
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 21
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC8016
  Scenario: TC8016 - IC Technician_Verify DUU web app allows to upload folder of 2 sub folders with DICOM files of 2 patients in each sub folder using drag & drop and displays failure message when DICOM files of size more than 3 GB is uploaded 
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
    #Step 5
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #Step 6
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects dataset with "two patients" and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the user is redirected to Image uploading screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Smith & Nephew logo                                             |
      | Loading bar                                                     |
      | Uploaded – shows the size of files being uploaded               |
      | Time Remaining                                                  |
      | Cancel upload button                                            |
      | Start Next Upload button                                        |
    ##Step 8
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
     | components                      |
     | Upload Successful               |
     | Close, Start New Upload         |
     | Dashboard button in green color |
    ##Step 9
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "first four" patients displayed
    ##Step 10
    Then the details of "four patients" matches with uploaded files
    ##Step 11
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 12
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 13
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 14
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
    #Step 15
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #Step 16
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 17
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects 3gb dataset with "single patients" and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the upload failure screen shall be displayed with following details
     | detail																													 |
     | Breadcrumb of selected Site name, surgeon name application name |
     | Failed icon																										 |
     | upload failed text																							 |
     | total size exceeded the limit of 3gb message										 |
     | yellow progress bar																						 |
     | start new upload and reupload buttons													 |
     #step18
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen 
    #Step 20
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 21
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC8017
  Scenario: TC8017 - Hospital Admin_Verify DUU web app allows to upload folder of 2 sub folders with DICOM files of 2 patients in each sub folder using drag & drop and displays failure message when DICOM files of size more than 3 GB is uploaded 
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
    #Step 5
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #Step 6
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects dataset with "two patients" and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the user is redirected to Image uploading screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Smith & Nephew logo                                             |
      | Loading bar                                                     |
      | Uploaded – shows the size of files being uploaded               |
      | Time Remaining                                                  |
      | Cancel upload button                                            |
      | Start Next Upload button                                        |
    ##Step 8
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
     | components                      |
     | Upload Successful               |
     | Close, Start New Upload         |
     | Dashboard button in green color |
    ##Step 9
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "first four" patients displayed
    ##Step 10
    Then the details of "four patients" matches with uploaded files
    ##Step 11
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 12
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 13
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 14
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
    #Step 15
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #Step 16
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 17
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects 3gb dataset with "single patients" and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the upload failure screen shall be displayed with following details
     | detail																													 |
     | Breadcrumb of selected Site name, surgeon name application name |
     | Failed icon																										 |
     | upload failed text																							 |
     | total size exceeded the limit of 3gb message										 |
     | yellow progress bar																						 |
     | start new upload and reupload buttons													 |
     #step18
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen 
    #Step 20
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 21
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC8018
  Scenario: TC8018 - Surgeon_Verify DUU web app allows to upload folder of 2 sub folders with DICOM files of 2 patients in each sub folder using drag & drop and displays failure message when DICOM files of size more than 3 GB is uploaded 
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
    #Step 5
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #Step 6
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects dataset with "two patients" and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the user is redirected to Image uploading screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Smith & Nephew logo                                             |
      | Loading bar                                                     |
      | Uploaded – shows the size of files being uploaded               |
      | Time Remaining                                                  |
      | Cancel upload button                                            |
      | Start Next Upload button                                        |
    ##Step 8
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
     | components                      |
     | Upload Successful               |
     | Close, Start New Upload         |
     | Dashboard button in green color |
    ##Step 9
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "first four" patients displayed
    ##Step 10
    Then the details of "four patients" matches with uploaded files
    ##Step 11
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 12
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 13
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 14
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
    #Step 15
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #Step 16
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 17
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects 3gb dataset with "single patients" and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the upload failure screen shall be displayed with following details
     | detail																													 |
     | Breadcrumb of selected Site name, surgeon name application name |
     | Failed icon																										 |
     | upload failed text																							 |
     | total size exceeded the limit of 3gb message										 |
     | yellow progress bar																						 |
     | start new upload and reupload buttons													 |
     #step18
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen 
    #Step 20
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 21
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC8019
  Scenario: TC8019 - Support Staff_Verify DUU web app allows to upload folder of 2 sub folders with DICOM files of 2 patients in each sub folder using drag & drop and displays failure message when DICOM files of size more than 3 GB is uploaded 
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
    #Step 5
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #Step 6
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects dataset with "two patients" and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the user is redirected to Image uploading screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Smith & Nephew logo                                             |
      | Loading bar                                                     |
      | Uploaded – shows the size of files being uploaded               |
      | Time Remaining                                                  |
      | Cancel upload button                                            |
      | Start Next Upload button                                        |
    ##Step 8
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
     | components                      |
     | Upload Successful               |
     | Close, Start New Upload         |
     | Dashboard button in green color |
    ##Step 9
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "first four" patients displayed
    ##Step 10
    Then the details of "four patients" matches with uploaded files
    ##Step 11
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 12
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 13
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 14
    When the user selects a site and click on next button
    #And the Surgeon selection screen is displayed with
      #| Components                                         |
      #| Which surgeon are you supporting                   |
      #| Search box is displayed with header Search Surgeon |
      #| Enter First or Last Name of Surgeon                |
      #| list of linked surgeons                            |
      #| close icon                                         |
      #| Back and Next buttons                              |
      #| I dont see my Surgeon listed                       |
    #Step 15
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #Step 16
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 17
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects 3gb dataset with "single patients" and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the upload failure screen shall be displayed with following details
     | detail																													 |
     | Breadcrumb of selected Site name, surgeon name application name |
     | Failed icon																										 |
     | upload failed text																							 |
     | total size exceeded the limit of 3gb message										 |
     | yellow progress bar																						 |
     | start new upload and reupload buttons													 |
     #step18
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen 
    #Step 20
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 21
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    
    @ImageUpload_TC3318
  Scenario: TC3318 - IC Admin_Verify DUU web app allows to upload multiple DICOM files for single patient and does not allow file size over 3  
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 12
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 13
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 14
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
    #Step 15
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #Step 16
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 17
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects 3gb dataset with "single patients" and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the upload failure screen shall be displayed with following details
     | detail																													 |
     | Breadcrumb of selected Site name, surgeon name application name |
     | Failed icon																										 |
     | upload failed text																							 |
     | total size exceeded the limit of 3gb message										 |
     | yellow progress bar																						 |
     | start new upload and reupload buttons													 |
     #step18
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen 
    #Step 20
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 21
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC8061
  Scenario: TC8061 - IC Technician_Verify DUU web app allows to upload multiple DICOM files for single patient and does not allow file size over 3  
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 12
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 13
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 14
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
    #Step 15
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #Step 16
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 17
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects 3gb dataset with "single patients" and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the upload failure screen shall be displayed with following details
     | detail																													 |
     | Breadcrumb of selected Site name, surgeon name application name |
     | Failed icon																										 |
     | upload failed text																							 |
     | total size exceeded the limit of 3gb message										 |
     | yellow progress bar																						 |
     | start new upload and reupload buttons													 |
     #step18
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen 
    #Step 20
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 21
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC8060
  Scenario: TC8060 - Hospital Admin_Verify DUU web app allows to upload multiple DICOM files for single patient and does not allow file size over 3  
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 12
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 13
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 14
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
    #Step 15
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #Step 16
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 17
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects 3gb dataset with "single patients" and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the upload failure screen shall be displayed with following details
     | detail																													 |
     | Breadcrumb of selected Site name, surgeon name application name |
     | Failed icon																										 |
     | upload failed text																							 |
     | total size exceeded the limit of 3gb message										 |
     | yellow progress bar																						 |
     | start new upload and reupload buttons													 |
     #step18
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen 
    #Step 20
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 21
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC8063
  Scenario: TC8063 - Surgeon_Verify DUU web app allows to upload multiple DICOM files for single patient and does not allow file size over 3  
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 12
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 13
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 14
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
    #Step 15
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #Step 16
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 17
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects 3gb dataset with "single patients" and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the upload failure screen shall be displayed with following details
     | detail																													 |
     | Breadcrumb of selected Site name, surgeon name application name |
     | Failed icon																										 |
     | upload failed text																							 |
     | total size exceeded the limit of 3gb message										 |
     | yellow progress bar																						 |
     | start new upload and reupload buttons													 |
     #step18
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen 
    #Step 20
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 21
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC8062
  Scenario: TC8062 - Support Staff_Verify DUU web app allows to upload multiple DICOM files for single patient and does not allow file size over 3  
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 12
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 13
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 14
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
    #Step 15
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #Step 16
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 17
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects 3gb dataset with "single patients" and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the upload failure screen shall be displayed with following details
     | detail																													 |
     | Breadcrumb of selected Site name, surgeon name application name |
     | Failed icon																										 |
     | upload failed text																							 |
     | total size exceeded the limit of 3gb message										 |
     | yellow progress bar																						 |
     | start new upload and reupload buttons													 |
     #step18
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen 
    #Step 20
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 21
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   