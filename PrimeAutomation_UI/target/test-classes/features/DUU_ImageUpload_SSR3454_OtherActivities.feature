Feature: SSR3454 - Data Upload Utility shall allow users to perform other activities while the upload operations are in status tray

  @ImageUpload_TC3640
  Scenario: TC3640 - IC Admin_Verify the Data Upload Utility shall allow user to navigate, perform actions during image upload and logout during an upload progress
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
    When user selects dataset with "500 mb" and click on upload button
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
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploading is displayed in Upload Status screen
    ##Step 11
    When the user clicks on history button from left menu bar
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    ##Step 12
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    When user waits for upload to complete
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    ##Step 13
    When the user clicks on dashbaord button from left menu bar
    Then Upload dashboad page is displayed to user
    When the user selects 24hrs filters on dashboard
    Then Record details of "first" patients displayed
    ##Step 14
    Then the details of "500 mb" matches with uploaded files
    ##Step 15
    When User clicks on Upload Files from left panel
    When Clicks on Upload Button
    When the user selects a site and click on next button
    When the user selects a surgeon and click on next button
    When the user selects an application and click on Next button
    When the user clicks on browse pc button
    When user selects dataset with "500 mb" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 16
    When the user clicks upload button and wait for the upload progress bar to load half a way and then logout
    Then user is logout from the application.
    ##Step 17
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    Then Upload dashboad page is displayed to user
    ##Step 18
    Then Files uploaded is not displayed
    When the user clicks on history button from left menu bar
    Then file uploaded is not displayed in history screen
    When the user clicks on upload status from left menu bar
    Then file uploaded is not displayed in upload status screen
    ##Step 19
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC3641
  Scenario: TC3641 - Hospital Admin_Verify the Data Upload Utility shall allow user to navigate, perform actions during image upload and logout during an upload progress
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
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "500 mb" and click on upload button
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
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploading is displayed in Upload Status screen
    ##Step 11
    When the user clicks on history button from left menu bar
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    ##Step 12
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    When user waits for upload to complete
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    ##Step 13
    When the user clicks on dashbaord button from left menu bar
    Then Upload dashboad page is displayed to user
    When the user selects 24hrs filters on dashboard
    Then Record details of "first" patients displayed
    ##Step 14
    Then the details of "500 mb" matches with uploaded files
    ##Step 15
    When User clicks on Upload Files from left panel
    When Clicks on Upload Button
    When the user selects a site and click on next button
    When the user selects a surgeon and click on next button
    When the user selects an application and click on Next button
    When the user clicks on browse pc button
    When user selects dataset with "500 mb" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 16
    When the user clicks upload button and wait for the upload progress bar to load half a way and then logout
    Then user is logout from the application.
    ##Step 17
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    Then Upload dashboad page is displayed to user
    ##Step 18
    Then Files uploaded is not displayed
    When the user clicks on history button from left menu bar
    Then file uploaded is not displayed in history screen
    When the user clicks on upload status from left menu bar
    Then file uploaded is not displayed in upload status screen
    ##Step 19
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC3642
  Scenario: TC3642 - IC Technician_Verify the Data Upload Utility shall allow user to navigate, perform actions during image upload and logout during an upload progress
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
    When user selects dataset with "500 mb" and click on upload button
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
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploading is displayed in Upload Status screen
    ##Step 11
    When the user clicks on history button from left menu bar
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    ##Step 12
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    When user waits for upload to complete
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    ##Step 13
    When the user clicks on dashbaord button from left menu bar
    Then Upload dashboad page is displayed to user
    When the user selects 24hrs filters on dashboard
    Then Record details of "first" patients displayed
    ##Step 14
    Then the details of "500 mb" matches with uploaded files
    ##Step 15
    When User clicks on Upload Files from left panel
    When Clicks on Upload Button
    When the user selects a site and click on next button
    When the user selects a surgeon and click on next button
    When the user selects an application and click on Next button
    When the user clicks on browse pc button
    When user selects dataset with "500 mb" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 16
    When the user clicks upload button and wait for the upload progress bar to load half a way and then logout
    Then user is logout from the application.
    ##Step 17
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    Then Upload dashboad page is displayed to user
    ##Step 18
    Then Files uploaded is not displayed
    When the user clicks on history button from left menu bar
    Then file uploaded is not displayed in history screen
    When the user clicks on upload status from left menu bar
    Then file uploaded is not displayed in upload status screen
    ##Step 19
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC3643
  Scenario: TC3643 - Surgeon_Verify the Data Upload Utility shall allow user to navigate, perform actions during image upload and logout during an upload progress
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
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "500 mb" and click on upload button
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
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploading is displayed in Upload Status screen
    ##Step 11
    When the user clicks on history button from left menu bar
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    ##Step 12
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    When user waits for upload to complete
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    ##Step 13
    When the user clicks on dashbaord button from left menu bar
    Then Upload dashboad page is displayed to user
    When the user selects 24hrs filters on dashboard
    Then Record details of "first" patients displayed
    ##Step 14
    Then the details of "500 mb" matches with uploaded files
    ##Step 15
    When User clicks on Upload Files from left panel
    When Clicks on Upload Button
    When the user selects a site and click on next button
    When the user selects a surgeon and click on next button
    When the user selects an application and click on Next button
    When the user clicks on browse pc button
    When user selects dataset with "500 mb" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 16
    When the user clicks upload button and wait for the upload progress bar to load half a way and then logout
    Then user is logout from the application.
    ##Step 17
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    Then Upload dashboad page is displayed to user
    ##Step 18
    Then Files uploaded is not displayed
    When the user clicks on history button from left menu bar
    Then file uploaded is not displayed in history screen
    When the user clicks on upload status from left menu bar
    Then file uploaded is not displayed in upload status screen
    ##Step 19
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

  @ImageUpload_TC3644
  Scenario: TC3644 - Support Staff_Verify the Data Upload Utility shall allow user to navigate, perform actions during image upload and logout during an upload progress
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
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    ##Step 8
    When user selects dataset with "500 mb" and click on upload button
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
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploading is displayed in Upload Status screen
    ##Step 11
    When the user clicks on history button from left menu bar
    When the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    ##Step 12
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    When user waits for upload to complete
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    ##Step 13
    When the user clicks on dashbaord button from left menu bar
    Then Upload dashboad page is displayed to user
    When the user selects 24hrs filters on dashboard
    Then Record details of "first" patients displayed
    ##Step 14
    Then the details of "500 mb" matches with uploaded files
    ##Step 15
    When User clicks on Upload Files from left panel
    When Clicks on Upload Button
    When the user selects a site and click on next button
    When the user selects a surgeon and click on next button
    When the user selects an application and click on Next button
    When the user clicks on browse pc button
    When user selects dataset with "500 mb" and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 16
    When the user clicks upload button and wait for the upload progress bar to load half a way and then logout
    Then user is logout from the application.
    ##Step 17
    When that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    Then Upload dashboad page is displayed to user
    ##Step 18
    Then Files uploaded is not displayed
    When the user clicks on history button from left menu bar
    Then file uploaded is not displayed in history screen
    When the user clicks on upload status from left menu bar
    Then file uploaded is not displayed in upload status screen
    ##Step 19
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
