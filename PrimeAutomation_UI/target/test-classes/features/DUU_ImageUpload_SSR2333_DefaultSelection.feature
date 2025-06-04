Feature: SSR2333 : Data Upload Utility web application data upload workflow shall default select an organization if only one organization is selectable.

  @ImageUpload_TC08033
  Scenario: TC08033 - IC Admin _Verify DUU web application data upload workflow shall default select a site, surgeon and application if only one site, application and surgeon available.
   
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    When Clicks on Upload Button
    Then the Site selection screen is displayed with following components
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    And only one site is displayed on facility selection screen
    And user click on the site & verifies next button state 
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
    And only one surgeon is displayed on Surgeon selection screen
    Then user clicks on Surgeon & verifies next button state
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    And only one Application card is displayed on application selection screen
    And user click on the card & verifies next button state 
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When the user clicks on cancel button in Select Folder to upload pop-up
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects datase with "valid" and click on upload button
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
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    And Record details of "valid" dicom folder is displayed
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
      
  @ImageUpload_TC08099
  Scenario: TC08099 - Surgeon _Verify DUU web application data upload workflow shall default select a site, surgeon and application if only one site, application and surgeon available.
   
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    When Clicks on Upload Button
    Then the Site selection screen is displayed with following components
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    And only one site is displayed on facility selection screen
    And user click on the site & verifies next button state 
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
    And only one surgeon is displayed on Surgeon selection screen
    Then user clicks on Surgeon & verifies next button state
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    And only one Application card is displayed on application selection screen
    And user click on the card & verifies next button state 
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When the user clicks on cancel button in Select Folder to upload pop-up
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects datase with "valid" and click on upload button
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
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    And Record details of "valid" dicom folder is displayed
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    

@ImageUpload_TC08097
Scenario: TC08097 - Hospital admin _Verify DUU web application data upload workflow shall default select a site, surgeon and application if only one site, application and surgeon available.
   
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    When Clicks on Upload Button
    Then the Site selection screen is displayed with following components
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    And only one site is displayed on facility selection screen
    And user click on the site & verifies next button state 
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
    And only one surgeon is displayed on Surgeon selection screen
    Then user clicks on Surgeon & verifies next button state
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    And only one Application card is displayed on application selection screen
    And user click on the card & verifies next button state 
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When the user clicks on cancel button in Select Folder to upload pop-up
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects datase with "valid" and click on upload button
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
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    And Record details of "valid" dicom folder is displayed
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.


@ImageUpload_TC08096
Scenario: TC08096 - Hospital admin _Verify DUU web application data upload workflow shall default select a site, surgeon and application if only one site, application and surgeon available.
   
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    And Upload dashboad page is displayed to user
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    When Clicks on Upload Button
    Then the Site selection screen is displayed with following components
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    And only one site is displayed on facility selection screen
    And user click on the site & verifies next button state 
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
    And only one surgeon is displayed on Surgeon selection screen
    Then user clicks on Surgeon & verifies next button state
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    And only one Application card is displayed on application selection screen
    And user click on the card & verifies next button state 
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When the user clicks on cancel button in Select Folder to upload pop-up
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects datase with "valid" and click on upload button
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
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    And Record details of "valid" dicom folder is displayed
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.  
    
    
@ImageUpload_TC08098
Scenario: TC08098 - Support staff _Verify DUU web application data upload workflow shall default select a site, surgeon and application if only one site, application and surgeon available.
   
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    And Upload dashboad page is displayed to user
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    When Clicks on Upload Button
    Then the Site selection screen is displayed with following components
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    And only one site is displayed on facility selection screen
    And user click on the site & verifies next button state 
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
    And only one surgeon is displayed on Surgeon selection screen
    Then user clicks on Surgeon & verifies next button state
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    And only one Application card is displayed on application selection screen
    And user click on the card & verifies next button state 
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When the user clicks on cancel button in Select Folder to upload pop-up
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    When user selects datase with "valid" and click on upload button
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
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    And Record details of "valid" dicom folder is displayed
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    And Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.  
    
    
    