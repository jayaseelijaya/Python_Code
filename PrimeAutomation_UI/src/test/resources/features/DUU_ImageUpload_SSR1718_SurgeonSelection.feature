Feature: SSR1718 - Data Upload Utility web application shall require a surgeon to be selected when initiating an upload

  @ImageUpload_TC0855
  Scenario: TC0855 - IC Admin_Verify User can select a folder containing multiple images for multiple patients from the users local drive using browse PC
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    Given Record the list of sites
    Given Record the list of surgeons
    Given Record the list of applications
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
    Then the list of site displayed is as recorded
    When the user selects a site and click on next button
    Then the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    ##Step 5
    Then the list of surgeons displayed is as recorded
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 6
    Then the list of application displayed is as recorded
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "four patients" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
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
    ##Step 10
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    ##Step 11
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "four patients" patients displayed
    ##Step 12
    Then the details of "four patients" matches with uploaded files
    ##Step 13
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC3150
  Scenario: TC3150 - Hospital Admin_Verify User can select a folder containing multiple images for multiple patients from the user's local drive using browse PC
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    Given Record the self linked site
    Given Record the list of surgeons
    Given Record the list of applications
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
      | Self linked site selected by default            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    Then Self linked site is selected by default
    When the user selects a site and click on next button
    Then the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    ##Step 5
    Then the list of surgeons displayed is as recorded
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 6
    Then the list of application displayed is as recorded
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "four patients" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
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
    ##Step 10
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    ##Step 11
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "four patients" patients displayed
    ##Step 12
    Then the details of "four patients" matches with uploaded files
    ##Step 13
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC3152
  Scenario: TC3152 - Support Staff_Verify User can select a folder containing multiple images for multiple patients from the users local drive using browse PC
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    And Upload dashboad page is displayed to user
    Given Record the self linked site
    Given Record the list of surgeons
    Given Record the list of applications
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
      | Self linked site selected by default            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    Then Self linked site is selected by default
    When the user selects a site and click on next button
    Then the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    ##Step 5
    Then the list of surgeons displayed is as recorded
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 6
    Then the list of application displayed is as recorded
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "four patients" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
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
    ##Step 10
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    ##Step 11
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "four patients" patients displayed
    ##Step 12
    Then the details of "four patients" matches with uploaded files
    ##Step 13
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC3153
  Scenario: TC3153 - Surgeon_Verify User can select a folder containing multiple images for multiple patients from the user's local drive using browse PC
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
    Given Record the self linked site
    Given Record the list of surgeons
    Given Record the list of applications
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
      | Self linked site selected by default            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    Then Self linked site is selected by default
    When the user selects a site and click on next button
    Then the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    ##Step 5
    Then the list of surgeons displayed is as recorded
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 6
    Then the list of application displayed is as recorded
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "four patients" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
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
    ##Step 10
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    ##Step 11
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "four patients" patients displayed
    ##Step 12
    Then the details of "four patients" matches with uploaded files
    ##Step 13
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC3151
  Scenario: TC3151 - IC_Technician_Verify User can select a folder containing multiple images for multiple patients from the users local drive using browse PC
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    And Upload dashboad page is displayed to user
    Given Record the list of sites
    Given Record the list of surgeons
    Given Record the list of applications
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
    Then the list of site displayed is as recorded
    When the user selects a site and click on next button
    Then the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    ##Step 5
    Then the list of surgeons displayed is as recorded
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    ##Step 6
    Then the list of application displayed is as recorded
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    ##Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "four patients" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 9
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
    ##Step 10
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    ##Step 11
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "four patients" patients displayed
    ##Step 12
    Then the details of "four patients" matches with uploaded files
    ##Step 13
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC0527
  Scenario: TC0527 - IC Admin_Verify validation error message is displayed if no surgeons are available for selected organization
    ##Ensure a linked hospital with no surgeon is available
    ##Step1
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
    When user selects site with no surgeon
    Then the Surgeon selection screen is displayed with no surgeons
      | Components                                                        |
      | Which surgeon are you supporting                                  |
      | Search box is displayed with header Search Surgeon                |
      | Enter First or Last Name of Surgeon                               |
      | No Surgeon available. Please request administrator to add surgeon |
      | close icon                                                        |
      | Back and Next buttons                                             |
      | I dont see my Surgeon listed                                      |
    ##Step 5
    Then the Error message is displayed as No Surgeon available Please request administrator to add surgeon
    #Step 6
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 7
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC3098
  Scenario: TC3098 - IC Technician_Verify validation error message is displayed if no surgeons are available for selected organization
    ##Ensure a linked hospital with no surgeon is available
    ##Step1
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
    When user selects site with no surgeon
    Then the Surgeon selection screen is displayed with no surgeons
      | Components                                                        |
      | Which surgeon are you supporting                                  |
      | Search box is displayed with header Search Surgeon                |
      | Enter First or Last Name of Surgeon                               |
      | No Surgeon available. Please request administrator to add surgeon |
      | close icon                                                        |
      | Back and Next buttons                                             |
      | I dont see my Surgeon listed                                      |
    ##Step 5
    Then the Error message is displayed as No Surgeon available Please request administrator to add surgeon
    #Step 6
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 7
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC3099
  Scenario: TC3099 - Hospital Admin_Verify validation error message is displayed if no surgeons are available for selected organization
    ##Ensure a linked hospital with no surgeon is available
    ##Step1
    Given that the user is logged in to Data-Upload Utility Application through chrome "hadmin with no surgeon"
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
      | Self linked site selected by default            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    When user selects site with no surgeon
    Then the Surgeon selection screen is displayed with no surgeons
      | Components                                                        |
      | Which surgeon are you supporting                                  |
      | Search box is displayed with header Search Surgeon                |
      | Enter First or Last Name of Surgeon                               |
      | No Surgeon available. Please request administrator to add surgeon |
      | close icon                                                        |
      | Back and Next buttons                                             |
      | I dont see my Surgeon listed                                      |
    ##Step 5
    Then the Error message is displayed as No Surgeon available Please request administrator to add surgeon
    #Step 6
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 7
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC7903
  Scenario: TC7903 - IC Admin_Verify if user is not able to begin with data upload if Surgeon is not selected
    ##Step1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    Given Record the list of sites
    Given Record the list of surgeons
    Given Record the list of applications
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
    When Select the site recorded
    Then the site is selected
    ##Step 5
    When the user clicks on next button in site selection screen
    Then the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
      | Selected Site name at the top                      |
    ##Step 6
    Then no surgeon is displayed as selected by default
    ##Step 7
    Then Next button should be in disabled mode & non-clickable
    ##Step 8
    When click on one surgeon name then try to select the 2nd surgeon
    Then user is not able to select multiple surgeon
    #Step 9
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 10
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC7904
  Scenario: TC7904 - IC Technician_Verify if user is not able to begin with data upload if Surgeon is not selected
    ##Step1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    And Upload dashboad page is displayed to user
    Given Record the list of sites
    Given Record the list of surgeons
    Given Record the list of applications
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
    When Select the site recorded
    Then the site is selected
    ##Step 5
    When the user clicks on next button in site selection screen
    Then the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
      | Selected Site name at the top                      |
    ##Step 6
    Then no surgeon is displayed as selected by default
    ##Step 7
    Then Next button should be in disabled mode & non-clickable
    ##Step 8
    When click on one surgeon name then try to select the 2nd surgeon
    Then user is not able to select multiple surgeon
    #Step 9
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 10
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC7902
  Scenario: TC7902 - Hospital Admin_Verify if user is not able to begin with data upload if Surgeon is not selected
    ##Step1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    Given Record the self linked site
    Given Record the list of surgeons
    Given Record the list of applications
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
      | Self linked site selected by default            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    When the user clicks on next button in site selection screen
    Then the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
      | Selected Site name at the top                      |
    ##Step 5
    Then no surgeon is displayed as selected by default
    ##Step 6
    Then Next button should be in disabled mode & non-clickable
    ##Step 7
    When click on one surgeon name then try to select the 2nd surgeon
    Then user is not able to select multiple surgeon
    #Step 8
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 9
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC7901
  Scenario: TC7901 - Surgeon_Verify if user is not able to begin with data upload if Surgeon is not selected
    ##Step1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
    Given Record the self linked site
    Given Record the list of surgeons
    Given Record the list of applications
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
      | Self linked site selected by default            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    When the user clicks on next button in site selection screen
    Then the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
      | Selected Site name at the top                      |
    ##Step 5
    Then no surgeon is displayed as selected by default
    ##Step 6
    Then Next button should be in disabled mode & non-clickable
    ##Step 7
    When click on one surgeon name then try to select the 2nd surgeon
    Then user is not able to select multiple surgeon
    #Step 8
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 9
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC7900
  Scenario: TC7900 - Support Staff_Verify if user is not able to begin with data upload if Surgeon is not selected
    ##Step1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    And Upload dashboad page is displayed to user
    Given Record the self linked site
    Given Record the list of surgeons
    Given Record the list of applications
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
      | Self linked site selected by default            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    ##Step 4
    When the user clicks on next button in site selection screen
    Then the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
      | Selected Site name at the top                      |
    ##Step 5
    Then no surgeon is displayed as selected by default
    ##Step 6
    Then Next button should be in disabled mode & non-clickable
    ##Step 7
    When click on one surgeon name then try to select the 2nd surgeon
    Then user is not able to select multiple surgeon
    #Step 8
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 9
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
  
  
  #Scenario Outline: TC0517 - Verify user should not be able to proceed with data upload if surgeon is not selected.
    #Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    #Then Homepage is getting displayed to the user
    #When User clicks on Upload Files from left panel
    #And Clicks on Upload File
    #Then Search facility screen is displayed to user along with back and next button
    #When User clicks on facility which has surgeon associated
    #And user clicks on Next button
    #Then surgeon list should be display as per the selected facility
    #And user is not able to proceed with data upload if no surgeon selected
    #And Data-Upload Application is closed
#
    #Examples: 
      #| user                        |
      #| ic-test-admin@capgemini.com |
#
  #| ic-test-tech@capgemini.com |
  #| ic-test-surgeon@capgemini.com |
  #| ic-test-supportstaff@capgemini.com |
  #| h-test-admin@capgemini.com |
  #Scenario Outline: TC0527 - Verify that notification message is displayed to user if Surgeon is not available for selected organisation.
    #Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    #Then Homepage is getting displayed to the user
    #When User clicks on Upload Files from left panel
    #And Clicks on Upload File
    #Then Search facility screen is displayed to user along with back and next button
    #When User clicks on facility which has no surgeon associated
    #And user clicks on Next button
    #Then notification message should be displayed to the user
    #And Back button should be in enabled mode & clickable
    #And Next button should be in disabled mode & non-clickable
    #And Data-Upload Application is closed
#
    #Examples: 
      #| user                        |
      #| ic-test-admin@capgemini.com |
#
  # | ic-test-tech@capgemini.com |
  #| ic-test-surgeon@capgemini.com |
  #| ic-test-supportstaff@capgemini.com |
  #| h-test-admin@capgemini.com |
  #Scenario Outline: TC0842 - Verify that Surgeon should be selected by user to begin with data upload workflow.
    #Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    #Then Homepage is getting displayed to the user
    #When User clicks on Upload Files from left panel
    #And Clicks on Upload File
    #Then Search facility screen is displayed to user along with back and next button
    #When User clicks on facility which has surgeon associated
    #And user clicks on Next button
    #Then surgeon list should be display as per the selected facility
    #And user clicks on any of the surgeon listed
    #And Next button should be in enabled mode after selecting surgeon
    #And Data-Upload Application is closed
#
    #Examples: 
      #| user                        |
      #| ic-test-admin@capgemini.com |
#	#| ic-test-tech@capgemini.com |
#	#| ic-test-surgeon@capgemini.com |
#	#| ic-test-supportstaff@capgemini.com |
#	#| h-test-admin@capgemini.com |	
