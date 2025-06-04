Feature: SSR1726 - Data Upload Utility web application shall allow a user to select a folder containing subfolders of multiple images from the users computer file system for upload

  @ImageUpload_TC0860
  Scenario: TC0860 - IC Admin_Verify User can select a folder containing subfolders of multiple DICOM images from the users computer with less than 3 GB data
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
      | close icon                                      |
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
    When user clicks on back button in upload screen
    Then the Application selection screen is displayed with
      | componenets                                    |
      | Select the application associated with upload  |
      | list of linked Application cards               |
      | I dont see my application listed               |
      | Back and Next buttons                          |
      | previously selected application is highlighted |
    ##Step 8
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 9
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 10
    When the user clicks on cancel button in Select Folder to upload pop-up
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 11
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    #Step 12
    When user selects dataset with "four patients" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 13
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
    ##Step 14
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    ##Step 15
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "first four" patients displayed
    ##Step 16
    Then the details of "four patients" matches with uploaded files
    ##Step 17
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    #Step 18
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 19
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC8012
  Scenario: TC8012- IC Technician_Verify User can select a folder containing subfolders of multiple DICOM images from the users computer with less than 3GB data
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
      | close icon                                      |
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
    When user clicks on back button in upload screen
    Then the Application selection screen is displayed with
      | componenets                                    |
      | Select the application associated with upload  |
      | list of linked Application cards               |
      | I dont see my application listed               |
      | Back and Next buttons                          |
      | previously selected application is highlighted |
    ##Step 8
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 9
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 10
    When the user clicks on cancel button in Select Folder to upload pop-up
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 11
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    #Step 12
    When user selects dataset with "four patients" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 13
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
    ##Step 14
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    ##Step 15
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "first four" patients displayed
    ##Step 16
    Then the details of "four patients" matches with uploaded files
    ##Step 17
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    #Step 18
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 19
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC8013
  Scenario: TC8013- Hospital Admin_Verify User can select a folder containing subfolders of multiple DICOM images from the user's computer with less than 3GB data
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
      | close icon                                      |
      | I dont see my Site listed                       |
    ##Step 4
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
    When user clicks on back button in upload screen
    Then the Application selection screen is displayed with
      | componenets                                    |
      | Select the application associated with upload  |
      | list of linked Application cards               |
      | I dont see my application listed               |
      | Back and Next buttons                          |
      | previously selected application is highlighted |
    ##Step 8
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 9
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 10
    When the user clicks on cancel button in Select Folder to upload pop-up
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 11
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    #Step 12
    When user selects dataset with "four patients" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 13
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
    ##Step 14
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    ##Step 15
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "first four" patients displayed
    ##Step 16
    Then the details of "four patients" matches with uploaded files
    ##Step 17
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    #Step 18
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 19
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC8014
  Scenario: TC8014 - Support Staff_Verify User can select a folder containing subfolders of multiple DICOM images from the users computer with less than 3GB data
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
      | close icon                                      |
      | I dont see my Site listed                       |
    ##Step 4
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
    When user clicks on back button in upload screen
    Then the Application selection screen is displayed with
      | componenets                                    |
      | Select the application associated with upload  |
      | list of linked Application cards               |
      | I dont see my application listed               |
      | Back and Next buttons                          |
      | previously selected application is highlighted |
    ##Step 8
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 9
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 10
    When the user clicks on cancel button in Select Folder to upload pop-up
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 11
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    #Step 12
    When user selects dataset with "four patients" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 13
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
    ##Step 14
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    ##Step 15
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "first four" patients displayed
    ##Step 16
    Then the details of "four patients" matches with uploaded files
    ##Step 17
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    #Step 18
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 19
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC8015
  Scenario: TC8015 - Surgeon_Verify User can select a folder containing subfolders of multiple DICOM images from the users computer with less than 3GB data
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
      | close icon                                      |
      | I dont see my Site listed                       |
    ##Step 4
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
    When user clicks on back button in upload screen
    Then the Application selection screen is displayed with
      | componenets                                    |
      | Select the application associated with upload  |
      | list of linked Application cards               |
      | I dont see my application listed               |
      | Back and Next buttons                          |
      | previously selected application is highlighted |
    ##Step 8
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 9
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 10
    When the user clicks on cancel button in Select Folder to upload pop-up
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 11
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    #Step 12
    When user selects dataset with "four patients" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 13
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
    ##Step 14
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    ##Step 15
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "first four" patients displayed
    ##Step 16
    Then the details of "four patients" matches with uploaded files
    ##Step 17
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    #Step 18
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 19
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC3274
  Scenario: TC3274
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
      | close icon                                      |
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
    When user selects dataset with "consists of 2 sub folders with Invalid DICOM files of 2 patients in each sub folder" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) may be an invalid DICOM file(s) or missing the following mandatory DICOM tag(s): Patient Name, Date of Birth, or Patient ID |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
    ##Step 10
    Then Yellow(dot) notification symbol is "displayed" on left menu for Upload Status screen
    ##Step 11
    When the user clicks on dashbaord button from left menu bar
    Then Upload dashboad page is displayed to user
    And Files uploaded is not displayed
    ##Step 12
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 13
    Then Yellow(dot) notification symbol is "not displayed" on left menu for Upload Status screen
    ##Step 14
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 15
    When Clicks on Upload Button
    When the user selects a site and click on next button
    When the user selects a surgeon and click on next button
    When the user selects an application and click on Next button
    When the user clicks on browse pc button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 16
    When user selects dataset with "size more than 3 GB" and click on upload button
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                       |
      | Upload File label                                                |
      | Selected Site-> Surgeon -> Application                           |
      | Upload Failed icon                                               |
      | Upload Failed text                                               |
      | The total size of the selected file(s) exceeds the limit of 3 GB |
      | Yellow progress bar                                              |
      | Start New upload button                                          |
      | Re-upload button                                                 |
    ##Step 17
    Then Yellow(dot) notification symbol is "displayed" on left menu for Upload Status screen
    ##Step 18
    When the user clicks on dashbaord button from left menu bar
    Then Upload dashboad page is displayed to user
    And Files uploaded is not displayed
    ##Step 19
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 20
    Then Yellow(dot) notification symbol is "not displayed" on left menu for Upload Status screen
    ##Step 21
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 22
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC7995
  Scenario: TC7995
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
      | close icon                                      |
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
    When user selects dataset with "consists of 2 sub folders with Invalid DICOM files of 2 patients in each sub folder" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) may be an invalid DICOM file(s) or missing the following mandatory DICOM tag(s): Patient Name, Date of Birth, or Patient ID |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
    ##Step 10
    Then Yellow(dot) notification symbol is "displayed" on left menu for Upload Status screen
    ##Step 11
    When the user clicks on dashbaord button from left menu bar
    Then Upload dashboad page is displayed to user
    And Files uploaded is not displayed
    ##Step 12
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 13
    Then Yellow(dot) notification symbol is "not displayed" on left menu for Upload Status screen
    ##Step 14
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 15
    When Clicks on Upload Button
    When the user selects a site and click on next button
    When the user selects a surgeon and click on next button
    When the user selects an application and click on Next button
    When the user clicks on browse pc button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 16
    When user selects dataset with "size more than 3 GB" and click on upload button
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                       |
      | Upload File label                                                |
      | Selected Site-> Surgeon -> Application                           |
      | Upload Failed icon                                               |
      | Upload Failed text                                               |
      | The total size of the selected file(s) exceeds the limit of 3 GB |
      | Yellow progress bar                                              |
      | Start New upload button                                          |
      | Re-upload button                                                 |
    ##Step 17
    Then Yellow(dot) notification symbol is "displayed" on left menu for Upload Status screen
    ##Step 18
    When the user clicks on dashbaord button from left menu bar
    Then Upload dashboad page is displayed to user
    And Files uploaded is not displayed
    ##Step 19
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 20
    Then Yellow(dot) notification symbol is "not displayed" on left menu for Upload Status screen
    ##Step 21
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 22
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC7996
  Scenario: TC7996
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
      | close icon                                      |
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
    When user selects dataset with "consists of 2 sub folders with Invalid DICOM files of 2 patients in each sub folder" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) may be an invalid DICOM file(s) or missing the following mandatory DICOM tag(s): Patient Name, Date of Birth, or Patient ID |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
    ##Step 10
    Then Yellow(dot) notification symbol is "displayed" on left menu for Upload Status screen
    ##Step 11
    When the user clicks on dashbaord button from left menu bar
    Then Upload dashboad page is displayed to user
    And Files uploaded is not displayed
    ##Step 12
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 13
    Then Yellow(dot) notification symbol is "not displayed" on left menu for Upload Status screen
    ##Step 14
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 15
    When Clicks on Upload Button
    When the user selects a site and click on next button
    When the user selects a surgeon and click on next button
    When the user selects an application and click on Next button
    When the user clicks on browse pc button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 16
    When user selects dataset with "size more than 3 GB" and click on upload button
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                       |
      | Upload File label                                                |
      | Selected Site-> Surgeon -> Application                           |
      | Upload Failed icon                                               |
      | Upload Failed text                                               |
      | The total size of the selected file(s) exceeds the limit of 3 GB |
      | Yellow progress bar                                              |
      | Start New upload button                                          |
      | Re-upload button                                                 |
    ##Step 17
    Then Yellow(dot) notification symbol is "displayed" on left menu for Upload Status screen
    ##Step 18
    When the user clicks on dashbaord button from left menu bar
    Then Upload dashboad page is displayed to user
    And Files uploaded is not displayed
    ##Step 19
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 20
    Then Yellow(dot) notification symbol is "not displayed" on left menu for Upload Status screen
    ##Step 21
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 22
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC7997
  Scenario: TC7997
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
      | close icon                                      |
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
    When user selects dataset with "consists of 2 sub folders with Invalid DICOM files of 2 patients in each sub folder" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) may be an invalid DICOM file(s) or missing the following mandatory DICOM tag(s): Patient Name, Date of Birth, or Patient ID |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
    ##Step 10
    Then Yellow(dot) notification symbol is "displayed" on left menu for Upload Status screen
    ##Step 11
    When the user clicks on dashbaord button from left menu bar
    Then Upload dashboad page is displayed to user
    And Files uploaded is not displayed
    ##Step 12
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 13
    Then Yellow(dot) notification symbol is "not displayed" on left menu for Upload Status screen
    ##Step 14
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 15
    When Clicks on Upload Button
    When the user selects a site and click on next button
    When the user selects a surgeon and click on next button
    When the user selects an application and click on Next button
    When the user clicks on browse pc button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 16
    When user selects dataset with "size more than 3 GB" and click on upload button
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                       |
      | Upload File label                                                |
      | Selected Site-> Surgeon -> Application                           |
      | Upload Failed icon                                               |
      | Upload Failed text                                               |
      | The total size of the selected file(s) exceeds the limit of 3 GB |
      | Yellow progress bar                                              |
      | Start New upload button                                          |
      | Re-upload button                                                 |
    ##Step 17
    Then Yellow(dot) notification symbol is "displayed" on left menu for Upload Status screen
    ##Step 18
    When the user clicks on dashbaord button from left menu bar
    Then Upload dashboad page is displayed to user
    And Files uploaded is not displayed
    ##Step 19
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 20
    Then Yellow(dot) notification symbol is "not displayed" on left menu for Upload Status screen
    ##Step 21
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 22
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC7998
  Scenario: TC7998
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
      | close icon                                      |
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
    When user selects dataset with "consists of 2 sub folders with Invalid DICOM files of 2 patients in each sub folder" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                                                                                                       |
      | Upload File label                                                                                                                                |
      | Selected Site-> Surgeon -> Application                                                                                                           |
      | Upload Failed icon                                                                                                                               |
      | The Name of failed upload file                                                                                                                   |
      | The selected file(s) may be an invalid DICOM file(s) or missing the following mandatory DICOM tag(s): Patient Name, Date of Birth, or Patient ID |
      | Yellow progress bar                                                                                                                              |
      | Start New upload button                                                                                                                          |
      | Re-upload button                                                                                                                                 |
    ##Step 10
    Then Yellow(dot) notification symbol is "displayed" on left menu for Upload Status screen
    ##Step 11
    When the user clicks on dashbaord button from left menu bar
    Then Upload dashboad page is displayed to user
    And Files uploaded is not displayed
    ##Step 12
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 13
    Then Yellow(dot) notification symbol is "not displayed" on left menu for Upload Status screen
    ##Step 14
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    ##Step 15
    When Clicks on Upload Button
    When the user selects a site and click on next button
    When the user selects a surgeon and click on next button
    When the user selects an application and click on Next button
    When the user clicks on browse pc button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 16
    When user selects dataset with "size more than 3 GB" and click on upload button
    When the user clicks on upload button in the popup and record the time
    Then the Upload failure screen is displayed with
      | components                                                       |
      | Upload File label                                                |
      | Selected Site-> Surgeon -> Application                           |
      | Upload Failed icon                                               |
      | Upload Failed text                                               |
      | The total size of the selected file(s) exceeds the limit of 3 GB |
      | Yellow progress bar                                              |
      | Start New upload button                                          |
      | Re-upload button                                                 |
    ##Step 17
    Then Yellow(dot) notification symbol is "displayed" on left menu for Upload Status screen
    ##Step 18
    When the user clicks on dashbaord button from left menu bar
    Then Upload dashboad page is displayed to user
    And Files uploaded is not displayed
    ##Step 19
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Failed is displayed in Upload Status screen
    ##Step 20
    Then Yellow(dot) notification symbol is "not displayed" on left menu for Upload Status screen
    ##Step 21
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 22
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
