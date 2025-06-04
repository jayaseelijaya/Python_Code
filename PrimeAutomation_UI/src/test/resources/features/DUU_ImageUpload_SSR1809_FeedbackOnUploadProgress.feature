Feature: SSR1809 - Data Upload Utility web application shall provide feedback on upload progress for each batch. 

  @ImageUpload_TC3357
  Scenario: TC3357 - IC Admin_Verify Upload success work flow from upload status screen.
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
      | I dont see my Site listed                       |
    ##Step 3
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
    When user selects valid dicom dataset and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 8
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
    ##Step 9
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    ##Step 10, 11
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of most recent uploaded patient displayed
    ##Step 12
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    #step13
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    #step14
    When the user selects record with uploaded status
    Then the user clicks on view details button
    And upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    #step15
    When the user clicks on close button on upload successful screen
    Then the upload status screen shall be displayed   
    #Step 16
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 17
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
      @ImageUpload_TC7890
  Scenario: TC7890 - Hospital Admin_Verify Upload success work flow from upload status screen.
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
      | I dont see my Site listed                       |
    ##Step 3
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
    When user selects valid dicom dataset and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 8
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
    ##Step 9
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    ##Step 10, 11
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of most recent uploaded patient displayed
    ##Step 12
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    #step13
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    #step14
    When the user selects record with uploaded status
    Then the user clicks on view details button
    And upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    #step15
    When the user clicks on close button on upload successful screen
    Then the upload status screen shall be displayed   
    #Step 16
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 17
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    
      @ImageUpload_TC7891
  Scenario: TC7891 - IC Technician_Verify Upload success work flow from upload status screen.
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
      | I dont see my Site listed                       |
    ##Step 3
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
    When user selects valid dicom dataset and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 8
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
    ##Step 9
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    ##Step 10, 11
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of most recent uploaded patient displayed
    ##Step 12
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    #step13
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    #step14
    When the user selects record with uploaded status
    Then the user clicks on view details button
    And upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    #step15
    When the user clicks on close button on upload successful screen
    Then the upload status screen shall be displayed   
    #Step 16
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 17
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    
      @ImageUpload_TC7892
  Scenario: TC7892 - Support Staff_Verify Upload success work flow from upload status screen.
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
      | I dont see my Site listed                       |
    ##Step 3
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
    When user selects valid dicom dataset and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 8
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
    ##Step 9
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    ##Step 10, 11
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of most recent uploaded patient displayed
    ##Step 12
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    #step13
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    #step14
    When the user selects record with uploaded status
    Then the user clicks on view details button
    And upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    #step15
    When the user clicks on close button on upload successful screen
    Then the upload status screen shall be displayed   
    #Step 16
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 17
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    
      @ImageUpload_TC7893
  Scenario: TC7893 - Surgeon_Verify Upload success work flow from upload status screen.
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
    When user selects valid dicom dataset and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    ##Step 8
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
    ##Step 9
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    ##Step 10, 11
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of most recent uploaded patient displayed
    ##Step 12
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    #step13
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    #step14
    When the user selects record with uploaded status
    Then the user clicks on view details button
    And upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    #step15
    When the user clicks on close button on upload successful screen
    Then the upload status screen shall be displayed   
    #Step 16
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 17
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

@ImageUpload_TC7943
  Scenario: TC7943 - Hospital Admin_Verify Uploading status work flow from upload status screen.
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
      | I dont see my Site listed                       |
    ##Step 3
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
    When user selects valid dicom dataset of 500MB and clicks on upload button
    #step8
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
    When the user clicks on upload status button from left menu bar
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploading is displayed in Upload Status screen
    #step11
    When the user selects record with uploading status
    Then the user clicks on view details button
    Then the user is redirected to Image uploading screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Smith & Nephew logo                                             |
      | Loading bar                                                     |
      | Uploaded – shows the size of files being uploaded               |
      | Time Remaining                                                  |
      | Cancel upload button                                            |
      | Start Next Upload button                                        |
    #step12
    When the user clicks on cancel upload button on upload successful screen
    Then the upload icon and Upload button are displayed
    #step13
    When Clicks on Upload Button
    When the user selects a site and click on next button
    When the user selects a surgeon and click on next button
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects valid dicom dataset of 500MB and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    #step14
     When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    #step15  
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "first" patients displayed  
    #step16
    Then the details of "first patients" matches with uploaded files
    #step17
     When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
   And Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen 
   And Date Time recorded,Organization,Surgeon,Application and Status as Cancelled is displayed in Upload Status screen 
   #step18
   When the user selects record with uploaded status
   Then the view details button shall be disabled for cancelled record
    #Step 19
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC7944
  Scenario: TC7944 - IC Technician_Verify Uploading status work flow from upload status screen.
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
      | I dont see my Site listed                       |
    ##Step 3
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
    When user selects valid dicom dataset of 500MB and clicks on upload button
    #step8
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
    When the user clicks on upload status button from left menu bar
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploading is displayed in Upload Status screen
    #step11
    When the user selects record with uploading status
    Then the user clicks on view details button
    Then the user is redirected to Image uploading screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Smith & Nephew logo                                             |
      | Loading bar                                                     |
      | Uploaded – shows the size of files being uploaded               |
      | Time Remaining                                                  |
      | Cancel upload button                                            |
      | Start Next Upload button                                        |
    #step12
    When the user clicks on cancel upload button on upload successful screen
    Then the upload icon and Upload button are displayed
    #step13
    When Clicks on Upload Button
    When the user selects a site and click on next button
    When the user selects a surgeon and click on next button
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects valid dicom dataset of 500MB and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    #step14
     When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    #step15  
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "first" patients displayed  
    #step16
    Then the details of "first patients" matches with uploaded files
    #step17
     When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
   And Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen 
   And Date Time recorded,Organization,Surgeon,Application and Status as Cancelled is displayed in Upload Status screen 
   #step18
   When the user selects record with uploaded status
   Then the view details button shall be disabled for cancelled record
    #Step 19
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC7945
  Scenario: TC7945 - Support Staff_Verify Uploading status work flow from upload status screen.
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
      | I dont see my Site listed                       |
    ##Step 3
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
    When user selects valid dicom dataset of 500MB and clicks on upload button
    #step8
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
    When the user clicks on upload status button from left menu bar
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploading is displayed in Upload Status screen
    #step11
    When the user selects record with uploading status
    Then the user clicks on view details button
    Then the user is redirected to Image uploading screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Smith & Nephew logo                                             |
      | Loading bar                                                     |
      | Uploaded – shows the size of files being uploaded               |
      | Time Remaining                                                  |
      | Cancel upload button                                            |
      | Start Next Upload button                                        |
    #step12
    When the user clicks on cancel upload button on upload successful screen
    Then the upload icon and Upload button are displayed
    #step13
    When Clicks on Upload Button
    When the user selects a site and click on next button
    When the user selects a surgeon and click on next button
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects valid dicom dataset of 500MB and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    #step14
     When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    #step15  
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "first" patients displayed  
    #step16
    Then the details of "first patients" matches with uploaded files
    #step17
     When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
   And Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen 
   And Date Time recorded,Organization,Surgeon,Application and Status as Cancelled is displayed in Upload Status screen 
   #step18
   When the user selects record with uploaded status
   Then the view details button shall be disabled for cancelled record
    #Step 19
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC7946
  Scenario: TC7946 - Surgeon_Verify Uploading status work flow from upload status screen.
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
      | I dont see my Site listed                       |
    ##Step 3
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
    When user selects valid dicom dataset of 500MB and clicks on upload button
    #step8
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
    When the user clicks on upload status button from left menu bar
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploading is displayed in Upload Status screen
    #step11
    When the user selects record with uploading status
    Then the user clicks on view details button
    Then the user is redirected to Image uploading screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Smith & Nephew logo                                             |
      | Loading bar                                                     |
      | Uploaded – shows the size of files being uploaded               |
      | Time Remaining                                                  |
      | Cancel upload button                                            |
      | Start Next Upload button                                        |
    #step12
    When the user clicks on cancel upload button on upload successful screen
    Then the upload icon and Upload button are displayed
    #step13
    When Clicks on Upload Button
    When the user selects a site and click on next button
    When the user selects a surgeon and click on next button
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects valid dicom dataset of 500MB and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    #step14
     When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    #step15  
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "first" patients displayed  
    #step16
    Then the details of "first patients" matches with uploaded files
    #step17
     When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
   And Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen 
   And Date Time recorded,Organization,Surgeon,Application and Status as Cancelled is displayed in Upload Status screen 
   #step18
   When the user selects record with uploaded status
   Then the view details button shall be disabled for cancelled record
    #Step 19
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC3367
  Scenario: TC3367 - IC Admin_Verify Uploading status work flow from upload status screen.
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
      | I dont see my Site listed                       |
    ##Step 3
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
    When user selects valid dicom dataset of 500MB and clicks on upload button
    #step8
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
    When the user clicks on upload status button from left menu bar
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploading is displayed in Upload Status screen
    #step11
    When the user selects record with uploading status
    Then the user clicks on view details button
    Then the user is redirected to Image uploading screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Smith & Nephew logo                                             |
      | Loading bar                                                     |
      | Uploaded – shows the size of files being uploaded               |
      | Time Remaining                                                  |
      | Cancel upload button                                            |
      | Start Next Upload button                                        |
    #step12
    When the user clicks on cancel upload button on upload successful screen
    Then the upload icon and Upload button are displayed
    #step13
    When Clicks on Upload Button
    When the user selects a site and click on next button
    When the user selects a surgeon and click on next button
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects valid dicom dataset of 500MB and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    #step14
     When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    #step15  
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    Then Record details of "first" patients displayed  
    #step16
    Then the details of "first patients" matches with uploaded files
    #step17
     When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
   And Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen 
   And Date Time recorded,Organization,Surgeon,Application and Status as Cancelled is displayed in Upload Status screen 
   #step18
   When the user selects record with uploaded status
   Then the view details button shall be disabled for cancelled record
    #Step 19
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 20
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    @ImageUpload_TC8588
  Scenario: TC8588 - Hospital Admin_Verify the Usability of Upload progress screens
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 2
    When User clicks on Upload Files from left panel
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
    ##Step 7, 8, 9
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects valid dicom dataset and clicks on upload button
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
    ##Step 10
    And the right side header shall be displayed as upload files
    #step11
    When the user clicks on start new upload button from progress screen
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
      #step12
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
    ##Step 13
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |  
     ##Step 14
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button  
    #step15, 16
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects invalid dicom dataset and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the selected files are not valid dicom files text shall be displayed
    And upload fail screen shall be displayed along with failed message
    And the yellow progress bar shall be displayed
    #step17
    And the start new button shall be displayed
    And re-upload button shall be displayed and highlighted in green color
    And the breadcrumb list of selected site, surgeon and application shall be displayed at top
    #step18
    And the yellow dot shall be displayed as soon as upload failed
    #step19
    When the user clicks on start new upload button from progress screen
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
      #step20
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
    ##Step 21
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |  
     ##Step 22
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button  
    #step23, 24, 25
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects valid and non dicom dataset and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the upload success screen shall be displayed
    And the upload successful text shall be displayed with tick mark
    And the text x of y files not uploaded files that are not uploaded may be invalid dicom or missing tags shall be displayed 
    And close, start new upload and dashboard buttons shall be displayed
    #Step 26
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 27
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC8589
  Scenario: TC8589 - Support Staff_Verify the Usability of Upload progress screens
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 2
    When User clicks on Upload Files from left panel
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
    ##Step 7, 8, 9
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects valid dicom dataset and clicks on upload button
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
    ##Step 10
    And the right side header shall be displayed as upload files
    #step11
    When the user clicks on start new upload button from progress screen
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
      #step12
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
    ##Step 13
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |  
     ##Step 14
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button  
    #step15, 16
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects invalid dicom dataset and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the selected files are not valid dicom files text shall be displayed
    And upload fail screen shall be displayed along with failed message
    And the yellow progress bar shall be displayed
    #step17
    And the start new button shall be displayed
    And re-upload button shall be displayed and highlighted in green color
    And the breadcrumb list of selected site, surgeon and application shall be displayed at top
    #step18
    And the yellow dot shall be displayed as soon as upload failed
    #step19
    When the user clicks on start new upload button from progress screen
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
      #step20
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
    ##Step 21
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |  
     ##Step 22
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button  
    #step23, 24, 25
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects valid and non dicom dataset and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the upload success screen shall be displayed
    And the upload successful text shall be displayed with tick mark
    And the text x of y files not uploaded files that are not uploaded may be invalid dicom or missing tags shall be displayed 
    And close, start new upload and dashboard buttons shall be displayed
    #Step 26
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 27
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC8590
  Scenario: TC8590 - Surgeon_Verify the Usability of Upload progress screens
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 2
    When User clicks on Upload Files from left panel
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
    ##Step 7, 8, 9
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects valid dicom dataset and clicks on upload button
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
    ##Step 10
    And the right side header shall be displayed as upload files
    #step11
    When the user clicks on start new upload button from progress screen
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
      #step12
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
    ##Step 13
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |  
     ##Step 14
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button  
    #step15, 16
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects invalid dicom dataset and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the selected files are not valid dicom files text shall be displayed
    And upload fail screen shall be displayed along with failed message
    And the yellow progress bar shall be displayed
    #step17
    And the start new button shall be displayed
    And re-upload button shall be displayed and highlighted in green color
    And the breadcrumb list of selected site, surgeon and application shall be displayed at top
    #step18
    And the yellow dot shall be displayed as soon as upload failed
    #step19
    When the user clicks on start new upload button from progress screen
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
      #step20
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
    ##Step 21
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |  
     ##Step 22
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button  
    #step23, 24, 25
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects valid and non dicom dataset and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the upload success screen shall be displayed
    And the upload successful text shall be displayed with tick mark
    And the text x of y files not uploaded files that are not uploaded may be invalid dicom or missing tags shall be displayed 
    And close, start new upload and dashboard buttons shall be displayed
    #Step 26
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 27
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC3345
  Scenario: TC3345 - IC Admin_Verify the Usability of Upload progress screens
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 2
    When User clicks on Upload Files from left panel
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
    ##Step 7, 8, 9
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects valid dicom dataset and clicks on upload button
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
    ##Step 10
    And the right side header shall be displayed as upload files
    #step11
    When the user clicks on start new upload button from progress screen
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
      #step12
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
    ##Step 13
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |  
     ##Step 14
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button  
    #step15, 16
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects invalid dicom dataset and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the selected files are not valid dicom files text shall be displayed
    And upload fail screen shall be displayed along with failed message
    And the yellow progress bar shall be displayed
    #step17
    And the start new button shall be displayed
    And re-upload button shall be displayed and highlighted in green color
    And the breadcrumb list of selected site, surgeon and application shall be displayed at top
    #step18
    And the yellow dot shall be displayed as soon as upload failed
    #step19
    When the user clicks on start new upload button from progress screen
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
      #step20
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
    ##Step 21
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |  
     ##Step 22
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button  
    #step23, 24, 25
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects valid and non dicom dataset and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the upload success screen shall be displayed
    And the upload successful text shall be displayed with tick mark
    And the text x of y files not uploaded files that are not uploaded may be invalid dicom or missing tags shall be displayed 
    And close, start new upload and dashboard buttons shall be displayed
    #Step 26
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 27
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    @ImageUpload_TC8587
  Scenario: TC8587 - IC Technician_Verify the Usability of Upload progress screens
    ##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    And Upload dashboad page is displayed to user
    ##Step 2
    When User clicks on Upload Files from left panel
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
    ##Step 7, 8, 9
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects valid dicom dataset and clicks on upload button
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
    ##Step 10
    And the right side header shall be displayed as upload files
    #step11
    When the user clicks on start new upload button from progress screen
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
      #step12
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
    ##Step 13
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |  
     ##Step 14
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button  
    #step15, 16
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects invalid dicom dataset and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the selected files are not valid dicom files text shall be displayed
    And upload fail screen shall be displayed along with failed message
    And the yellow progress bar shall be displayed
    #step17
    And the start new button shall be displayed
    And re-upload button shall be displayed and highlighted in green color
    And the breadcrumb list of selected site, surgeon and application shall be displayed at top
    #step18
    And the yellow dot shall be displayed as soon as upload failed
    #step19
    When the user clicks on start new upload button from progress screen
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
      #step20
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
    ##Step 21
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |  
     ##Step 22
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button  
    #step23, 24, 25
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects valid and non dicom dataset and clicks on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    When the user clicks on upload button in the popup and record the time
    Then the upload success screen shall be displayed
    And the upload successful text shall be displayed with tick mark
    And the text x of y files not uploaded files that are not uploaded may be invalid dicom or missing tags shall be displayed 
    And close, start new upload and dashboard buttons shall be displayed
    #Step 16
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 27
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
    