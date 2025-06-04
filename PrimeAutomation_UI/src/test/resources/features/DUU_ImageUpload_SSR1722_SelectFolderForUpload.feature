Feature: SSR1722-Data Upload Utility web application shall allow a user to select a folder of the user's computer file system for upload.

@ImageUpload_TC3257
Scenario: TC3257-IC Admin_Verify upload flow with invalid file.

		##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    #Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
     #Step 4
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
    When user clicks on back button in upload screen
    Then the Application selection screen is displayed with
      | componenets                                    |
      | Select the application associated with upload  |
      | list of linked Application cards               |
      | I dont see my application listed               |
      | Back and Next buttons                          |
      | previously selected application is highlighted |
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    #Step 8
    When the user selects a dataset with invalid files and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    #Step 9
    When the user clicks on upload button in the popup and record the time
    Then the user is redirected to Image uploading failure screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Upload File Label                                               |
      | Upload Failed Icon                                              |
      | Error Message                                                   |
      | Yellow Progess Bar                                              |
      | Start New Upload Button                                            |
      | Re-Upload Button                                        |
    #Step 10
    When the user clicks on the Start New Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
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
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When user clicks on back button in upload screen
    Then the Application selection screen is displayed with
      | componenets                                    |
      | Select the application associated with upload  |
      | list of linked Application cards               |
      | I dont see my application listed               |
      | Back and Next buttons                          |
      | previously selected application is highlighted |
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    
    #Step 11
    When User selects a dataset with more than 3GB file size
    Then the user is able to view pop-up with Number of files  confirming to upload
    
    #Step12
    When the user clicks on upload button in the popup and record the time
    Then the user is redirected to Image uploading failure screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Upload File Label                                               |
      | Upload Failed Icon                                              |
      | Error Message                                                   |
      | Yellow Progess Bar                                              |
      | Start New Upload Button                                         |
      | Re-Upload Button 																								|
      
    #Step13 - Verifying the Yellow Dot Notification Symbol Appears - NOT AUTOMATABLE
     
    #Step14
    When the user clicks file dashboard in left menu
    Then Upload dashboad page is displayed to user
    And Files uploaded is not displayed
    
    #Step15
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    
    #Step16 - Verifying Yellow Dot Notification Symbol Disappears - NOT AUTOMATABLE
    
    #Step17
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    
    #Step 18
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
@ImageUpload_TC7925
Scenario: TC7925-IC Technician_Verify upload flow with invalid file.

		##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    And Upload dashboad page is displayed to user
    #Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    
    #Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
     #Step 4
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
    When user clicks on back button in upload screen
    Then the Application selection screen is displayed with
      | componenets                                    |
      | Select the application associated with upload  |
      | list of linked Application cards               |
      | I dont see my application listed               |
      | Back and Next buttons                          |
      | previously selected application is highlighted |
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    #Step 8
    When the user selects a dataset with invalid files and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    #Step 9
    When the user clicks on upload button in the popup and record the time
    Then the user is redirected to Image uploading failure screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Upload File Label                                               |
      | Upload Failed Icon                                              |
      | Error Message                                                   |
      | Yellow Progess Bar                                              |
      | Start New Upload Button                                            |
      | Re-Upload Button                                        |
    #Step 10
    When the user clicks on the Start New Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
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
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When user clicks on back button in upload screen
    Then the Application selection screen is displayed with
      | componenets                                    |
      | Select the application associated with upload  |
      | list of linked Application cards               |
      | I dont see my application listed               |
      | Back and Next buttons                          |
      | previously selected application is highlighted |
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    
    #Step 11
    When User selects a dataset with more than 3GB file size
    Then the user is able to view pop-up with Number of files  confirming to upload
    
    #Step12
    When the user clicks on upload button in the popup and record the time
    Then the user is redirected to Image uploading failure screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Upload File Label                                               |
      | Upload Failed Icon                                              |
      | Error Message                                                   |
      | Yellow Progess Bar                                              |
      | Start New Upload Button                                         |
      | Re-Upload Button 																								|
      
    #Step13 - Verifying the Yellow Dot Notification Symbol Appears - NOT AUTOMATABLE
     
    #Step14
    When the user clicks file dashboard in left menu
    Then Upload dashboad page is displayed to user
    And Files uploaded is not displayed
    
    #Step15
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    
    #Step16 - Verifying Yellow Dot Notification Symbol Disappears - NOT AUTOMATABLE
    
    #Step17
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    
    #Step 18
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
 @ImageUpload_TC7926
Scenario: TC7926-Hospital Admin_Verify upload flow with invalid file.

		##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    #Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
     #Step 4
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
    When user clicks on back button in upload screen
    Then the Application selection screen is displayed with
      | componenets                                    |
      | Select the application associated with upload  |
      | list of linked Application cards               |
      | I dont see my application listed               |
      | Back and Next buttons                          |
      | previously selected application is highlighted |
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    #Step 8
    When the user selects a dataset with invalid files and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    #Step 9
    When the user clicks on upload button in the popup and record the time
    Then the user is redirected to Image uploading failure screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Upload File Label                                               |
      | Upload Failed Icon                                              |
      | Error Message                                                   |
      | Yellow Progess Bar                                              |
      | Start New Upload Button                                            |
      | Re-Upload Button                                        |
    #Step 10
    When the user clicks on the Start New Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
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
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When user clicks on back button in upload screen
    Then the Application selection screen is displayed with
      | componenets                                    |
      | Select the application associated with upload  |
      | list of linked Application cards               |
      | I dont see my application listed               |
      | Back and Next buttons                          |
      | previously selected application is highlighted |
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    
    #Step 11
    When User selects a dataset with more than 3GB file size
    Then the user is able to view pop-up with Number of files  confirming to upload
    
    #Step12
    When the user clicks on upload button in the popup and record the time
    Then the user is redirected to Image uploading failure screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Upload File Label                                               |
      | Upload Failed Icon                                              |
      | Error Message                                                   |
      | Yellow Progess Bar                                              |
      | Start New Upload Button                                         |
      | Re-Upload Button 																								|
      
    #Step13 - Verifying the Yellow Dot Notification Symbol Appears - NOT AUTOMATABLE
     
    #Step14
    When the user clicks file dashboard in left menu
    Then Upload dashboad page is displayed to user
    And Files uploaded is not displayed
    
    #Step15
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    
    #Step16 - Verifying Yellow Dot Notification Symbol Disappears - NOT AUTOMATABLE
    
    #Step17
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    
    #Step 18
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
 @ImageUpload_TC7927
Scenario: TC7927-Surgeon_Verify upload flow with invalid file.

		##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
    #Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
     #Step 4
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
    When user clicks on back button in upload screen
    Then the Application selection screen is displayed with
      | componenets                                    |
      | Select the application associated with upload  |
      | list of linked Application cards               |
      | I dont see my application listed               |
      | Back and Next buttons                          |
      | previously selected application is highlighted |
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    #Step 8
    When the user selects a dataset with invalid files and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    #Step 9
    When the user clicks on upload button in the popup and record the time
    Then the user is redirected to Image uploading failure screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Upload File Label                                               |
      | Upload Failed Icon                                              |
      | Error Message                                                   |
      | Yellow Progess Bar                                              |
      | Start New Upload Button                                            |
      | Re-Upload Button                                        |
    #Step 10
    When the user clicks on the Start New Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
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
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When user clicks on back button in upload screen
    Then the Application selection screen is displayed with
      | componenets                                    |
      | Select the application associated with upload  |
      | list of linked Application cards               |
      | I dont see my application listed               |
      | Back and Next buttons                          |
      | previously selected application is highlighted |
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    
    #Step 11
    When User selects a dataset with more than 3GB file size
    Then the user is able to view pop-up with Number of files  confirming to upload
    
    #Step12
    When the user clicks on upload button in the popup and record the time
    Then the user is redirected to Image uploading failure screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Upload File Label                                               |
      | Upload Failed Icon                                              |
      | Error Message                                                   |
      | Yellow Progess Bar                                              |
      | Start New Upload Button                                         |
      | Re-Upload Button 																								|
      
    #Step13 - Verifying the Yellow Dot Notification Symbol Appears - NOT AUTOMATABLE
     
    #Step14
    When the user clicks file dashboard in left menu
    Then Upload dashboad page is displayed to user
    And Files uploaded is not displayed
    
    #Step15
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    
    #Step16 - Verifying Yellow Dot Notification Symbol Disappears - NOT AUTOMATABLE
    
    #Step17
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    
    #Step 18
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
 @ImageUpload_TC7928
Scenario: TC7928-Support Staff_Verify upload flow with invalid file.

		##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    And Upload dashboad page is displayed to user
    #Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
     #Step 4
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
    When user clicks on back button in upload screen
    Then the Application selection screen is displayed with
      | componenets                                    |
      | Select the application associated with upload  |
      | list of linked Application cards               |
      | I dont see my application listed               |
      | Back and Next buttons                          |
      | previously selected application is highlighted |
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #Step 7
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    #Step 8
    When the user selects a dataset with invalid files and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    #Step 9
    When the user clicks on upload button in the popup and record the time
    Then the user is redirected to Image uploading failure screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Upload File Label                                               |
      | Upload Failed Icon                                              |
      | Error Message                                                   |
      | Yellow Progess Bar                                              |
      | Start New Upload Button                                            |
      | Re-Upload Button                                        |
    #Step 10
    When the user clicks on the Start New Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
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
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    When the user selects an application and click on Next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When user clicks on back button in upload screen
    Then the Application selection screen is displayed with
      | componenets                                    |
      | Select the application associated with upload  |
      | list of linked Application cards               |
      | I dont see my application listed               |
      | Back and Next buttons                          |
      | previously selected application is highlighted |
    When the user clicks on Next button in application selection screen
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    When the user clicks on browse pc button
    Then Select Folder to upload pop-up is displayed with upload and cancel buttons along with folders in users computer
    
    #Step 11
    When User selects a dataset with more than 3GB file size
    Then the user is able to view pop-up with Number of files  confirming to upload
    
    #Step12
    When the user clicks on upload button in the popup and record the time
    Then the user is redirected to Image uploading failure screen with
      | components                                                      |
      | Breadcrumb of selected Site name, surgeon name application name |
      | Upload File Label                                               |
      | Upload Failed Icon                                              |
      | Error Message                                                   |
      | Yellow Progess Bar                                              |
      | Start New Upload Button                                         |
      | Re-Upload Button 																								|
      
    #Step13 - Verifying the Yellow Dot Notification Symbol Appears - NOT AUTOMATABLE
     
    #Step14
    When the user clicks file dashboard in left menu
    Then Upload dashboad page is displayed to user
    And Files uploaded is not displayed
    
    #Step15
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    
    #Step16 - Verifying Yellow Dot Notification Symbol Disappears - NOT AUTOMATABLE
    
    ##Step17
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    
    ##Step 18
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
 
    
 @ImageUpload_TC0812
Scenario: TC0812- IC admin _Verify DUU web app allows to upload duplicate DICOM formatted images containing ePHI of a single patient file using browse PC . 

		##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    #Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
     #Step 4
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
    #Step 8
    When the user selects a dataset with valid DICOM files and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    #Step 9
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
    #Step 10
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
      
    #Step 11
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    
    #Step12
    And the record details in the summary dashboard is recorded
    
    #Step13
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
 @ImageUpload_TC8044
Scenario: TC8044- IC Technician _Verify DUU web app allows to upload duplicate DICOM formatted images containing ePHI of a single patient file using browse PC . 

		##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    And Upload dashboad page is displayed to user
    #Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
     #Step 4
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
    #Step 8
    When the user selects a dataset with valid DICOM files and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    #Step 9
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
    #Step 10
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
      
    #Step 11
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    
    #Step12
    And the record details in the summary dashboard is recorded
    
    #Step13
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
  @ImageUpload_TC8045
Scenario: TC8045- Hospital admin _Verify DUU web app allows to upload duplicate DICOM formatted images containing ePHI of a single patient file using browse PC . 

		##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    And Upload dashboad page is displayed to user
    #Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
     #Step 4
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
    #Step 8
    When the user selects a dataset with valid DICOM files and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    #Step 9
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
    #Step 10
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
      
    #Step 11
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    
    #Step12
    And the record details in the summary dashboard is recorded
    
    #Step13
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
  @ImageUpload_TC8046
Scenario: TC8046- Surgeon _Verify DUU web app allows to upload duplicate DICOM formatted images containing ePHI of a single patient file using browse PC . 

		##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    And Upload dashboad page is displayed to user
    #Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
     #Step 4
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
    #Step 8
    When the user selects a dataset with valid DICOM files and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    #Step 9
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
    #Step 10
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
      
    #Step 11
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    
    #Step12
    And the record details in the summary dashboard is recorded
    
    #Step13
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
  @ImageUpload_TC8047
Scenario: TC8047- Support Staff _Verify DUU web app allows to upload duplicate DICOM formatted images containing ePHI of a single patient file using browse PC . 

		##Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    And Upload dashboad page is displayed to user
    #Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
     #Step 4
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
    #Step 8
    When the user selects a dataset with valid DICOM files and click on upload button
    Then the user is able to view pop-up with Number of files  confirming to upload
    #Step 9
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
    #Step 10
    When the user wait until the file upload is done
    Then upload successful screen is displayed with
      | components                      |
      | Upload Successful               |
      | Close, Start New Upload         |
      | Dashboard button in green color |
      
    #Step 11
    When Click on Dashboard button in the upload screen
    Then Upload dashboad page is displayed to user
    
    #Step12
    And the record details in the summary dashboard is recorded
    
    #Step13
    When the user clicks on upload status from left menu bar
    Then the right side header shall be displayed as upload status
    Then Date Time recorded,Organization,Surgeon,Application and Status as Uploaded is displayed in Upload Status screen
    
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.