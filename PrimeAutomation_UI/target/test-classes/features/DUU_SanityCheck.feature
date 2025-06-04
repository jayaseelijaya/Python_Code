Feature: DUU Sanity Check

  @SanityCheck_HAdmin
  Scenario Outline: Hospital Admin Sanity Check
  	
  	Given Chrome Browser is opened
    And CLP app url is entered 
    Then the CLP screen shall be displayed
    When the user clicks on go to login button
    Then the CLP Signin page shall be displayed
    And Email-Address is entered as "<user>"
    And Password is entered by the user 
    Then the Login button is clicked
    When the user enters otp
    Then the signin button is clicked
    And the application product page shall be displayed
    And wait 2 seconds
    When the user clicks data upload launch button
    And Homepage is displayed to the user
    Then Verify Admin Can View the following components in the left menu bar
  	| components    |
  	| Dashboard     |
  	| Upload Files  |
  	| Upload Status |
  	| History       |
  	| Audit Log     |
  	| Imaging Links |
  	| Help          |
  	| Info          |
  	| Logout        |
  	| Exit to Apps  |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And No Data to display text is displayed
  	Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		When the user clicks on Browse PC button and select a valid DICOM file and upload
		Then upload successful screen is displayed
  	#Then Upload successful screen is displayed with the following components
  	#| components        |
  	#| header            |
  	#| title             |
  	#| icon              |
  	#| close button      |
  	#| dashboard button  |
  	#| new upload button |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Entry is found in upload status table
  	And Check first entry status
  	And View details button is displayed at bottom
  	When User clicks on History button from homepage
  	Then History screen is displayed with the following components
  	| components       |
  	| 24hr check       |
  	| filter menu      |
  	| search box       |
  	| search btn       |
  	| table            |
  	| view details btn |
  	And Verify first entry in history page
  	When user clicks on Audit log from left panel
  	Then Audit log page should be displayed with below components
		| screen          |
	  | 24 Hrs          |
	  | Filter          |
	  | Search box      |
	  | Search          |
	  | Events          |
	  | Export Selected |
	  | Export all      |
	  | Scroll bar      |
	  And Verify first entry in audit log
	  Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
	  Then The user uploads non dicom files
  	And Upload failed screen is displayed with the following components
  	| components           |
  	| failed text          |
  	| not dicom text       |
  	| start new upload btn |
  	| re upload btn        |
		Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
	  Then The user uploads invalid dicom files
  	And Upload failed screen is displayed with the following components
  	| components           |
  	| failed text          |
  	| not dicom text       |
  	| start new upload btn |
  	| re upload btn        |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Check first two entries status
		Then click settings page button from left menu
  	Then the following components shall be displayed on right side of settings
    | settings                     |
    | heading											 |
    | successful expiration        |
    | unsuccessful expiration      |
    | global viewing toggle button |
    | reset to default             |
    | save button                  |
    Then Enter 1 into successful uploads input box
    Then the user clicks on save button in settings
  	When the user clicks on dashbaord button from left menu bar
  	Then the upload dashboard will display uploads from only today
  	Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		When the user clicks on Browse PC button and select a valid DICOM file and upload
		Then upload successful screen is displayed
  	Then Upload successful screen is displayed with the following components
  	| components        |
  	| header            |
  	| title             |
  	| icon              |
  	| close button      |
  	| dashboard button  |
  	| new upload button |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Entry is found in upload status table
  	And View details button is displayed at bottom
  	And Wait 15 minutes
  	When the user clicks on dashbaord button from left menu bar
  	And Check upload dashboard first entry status
  	Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		Then The user uploads invalid dicom files
  	And Upload failed screen is displayed with the following components
  	| components           |
  	| failed text          |
  	| not dicom text       |
  	| start new upload btn |
  	| re upload btn        |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Entry is found in upload status table
  	And View details button is displayed at bottom
  	And Wait 15 minutes
  	When the user clicks on dashbaord button from left menu bar
  	And Check upload dashboard first entry status
  	And Wait 5 minutes
  	Then The user selects Upload Status button from the left menu bar
  	And Check first entry status
    When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel		
    
  Examples:
   	| user                       				   |  
		| ic-test-hospital-admin@capgemini.com |
		
	@SanityCheck_ICAdmin
  Scenario Outline: IC Admin Sanity Check
  	
  	Given Chrome Browser is opened
    And CLP app url is entered 
    Then the CLP screen shall be displayed
    When the user clicks on go to login button
    Then the CLP Signin page shall be displayed
    And Email-Address is entered as "<user>"
    And Password is entered by the user 
    Then the Login button is clicked
    When the user enters otp
    Then the signin button is clicked
    And the application product page shall be displayed
    When the user clicks data upload launch button
    And Homepage is displayed to the user
    Then Verify Admin Can View the following components in the left menu bar
  	| components    |
  	| Dashboard     |
  	| Upload Files  |
  	| Upload Status |
  	| History       |
  	| Audit Log     |
  	| Imaging Links |
  	| Help          |
  	| Info          |
  	| Logout        |
  	| Exit to Apps  |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And No Data to display text is displayed
  	Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		When the user clicks on Browse PC button and select a valid DICOM file and upload
		Then upload successful screen is displayed
  	Then Upload successful screen is displayed with the following components
  	| components        |
  	| header            |
  	| title             |
  	| icon              |
  	| close button      |
  	| dashboard button  |
  	| new upload button |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Entry is found in upload status table
  	And Check first entry status
  	And View details button is displayed at bottom
  	When User clicks on History button from homepage
  	Then History screen is displayed with the following components
  	| components       |
  	| 24hr check       |
  	| filter menu      |
  	| search box       |
  	| search btn       |
  	| table            |
  	| view details btn |
  	And Verify first entry in history page
  	When user clicks on Audit log from left panel
  	Then Audit log page should be displayed with below components
		| screen          |
	  | 24 Hrs          |
	  | Filter          |
	  | Search box      |
	  | Search          |
	  | Events          |
	  | Export Selected |
	  | Export all      |
	  | Scroll bar      |
	  And Verify first entry in audit log
	  Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
	  Then The user uploads non dicom files
  	And Upload failed screen is displayed with the following components
  	| components           |
  	| failed text          |
  	| not dicom text       |
  	| start new upload btn |
  	| re upload btn        |
		Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
	  Then The user uploads invalid dicom files
  	And Upload failed screen is displayed with the following components
  	| components           |
  	| failed text          |
  	| not dicom text       |
  	| start new upload btn |
  	| re upload btn        |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Check first two entries status
		Then click settings page button from left menu
  	Then the following components shall be displayed on right side of settings
    | settings                     |
    | heading											 |
    | successful expiration        |
    | unsuccessful expiration      |
    | global viewing toggle button |
    | reset to default             |
    | save button                  |
    Then Enter 1 into successful uploads input box
    Then the user clicks on save button in settings
  	When the user clicks on dashbaord button from left menu bar
  	Then the upload dashboard will display uploads from only today
  	Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		When the user clicks on Browse PC button and select a valid DICOM file and upload
		Then upload successful screen is displayed
  	Then Upload successful screen is displayed with the following components
  	| components        |
  	| header            |
  	| title             |
  	| icon              |
  	| close button      |
  	| dashboard button  |
  	| new upload button |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Entry is found in upload status table
  	And View details button is displayed at bottom
  	And Wait 15 minutes
  	When the user clicks on dashbaord button from left menu bar
  	And Check upload dashboard first entry status
  	Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		Then The user uploads invalid dicom files
  	And Upload failed screen is displayed with the following components
  	| components           |
  	| failed text          |
  	| not dicom text       |
  	| start new upload btn |
  	| re upload btn        |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Entry is found in upload status table
  	And View details button is displayed at bottom
  	And Wait 15 minutes
  	When the user clicks on dashbaord button from left menu bar
  	And Check upload dashboard first entry status
  	And Wait 5 minutes
  	Then The user selects Upload Status button from the left menu bar
  	And Check first entry status
    When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel		
    
  Examples:
   	| user                        |  
		| ic-test-admin@capgemini.com |
  
  @SanityCheck_ICTech
  Scenario Outline: IC Technician Sanity Check
  	Given Chrome Browser is opened
    And CLP app url is entered 
    Then the CLP screen shall be displayed
    When the user clicks on go to login button
    Then the CLP Signin page shall be displayed
    And Email-Address is entered as "<user>"
    And Password is entered by the user 
    Then the Login button is clicked
    When the user enters otp
    Then the signin button is clicked
    When the user clicks data upload launch button
    And Homepage is displayed to the user
    Then Verify Staff Can View the following components in the left menu bar
  	| components    |
  	| Dashboard     |
  	| Upload Files  |
  	| Upload Status |
  	| History       |
  	| Help          |
  	| Info          |
  	| Logout        |
  	| Exit to Apps  |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And No Data to display text is displayed
  	Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		When the user clicks on Browse PC button and select a valid DICOM file and upload
		Then upload successful screen is displayed
  	Then Upload successful screen is displayed with the following components
  	| components        |
  	| header            |
  	| title             |
  	| icon              |
  	| close button      |
  	| dashboard button  |
  	| new upload button |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Entry is found in upload status table
  	And Check first entry status
  	And View details button is displayed at bottom
  	When User clicks on History button from homepage
  	Then History screen is displayed with the following components
  	| components       |
  	| 24hr check       |
  	| filter menu      |
  	| search box       |
  	| search btn       |
  	| table            |
  	| view details btn |
  	And Verify first entry in history page
  	Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
	  Then The user uploads non dicom files
  	And Upload failed screen is displayed with the following components
  	| components           |
  	| failed text          |
  	| not dicom text       |
  	| start new upload btn |
  	| re upload btn        |
		Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
	  Then The user uploads invalid dicom files
  	And Upload failed screen is displayed with the following components
  	| components           |
  	| failed text          |
  	| not dicom text       |
  	| start new upload btn |
  	| re upload btn        |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Check first two entries status
  	Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		Then The user uploads invalid dicom files
  	And Upload failed screen is displayed with the following components
  	| components           |
  	| failed text          |
  	| not dicom text       |
  	| start new upload btn |
  	| re upload btn        |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Entry is found in upload status table
  	And View details button is displayed at bottom
  	And Wait 15 minutes
  	When the user clicks on dashbaord button from left menu bar
  	And Check upload dashboard first entry status
  	And Wait 5 minutes
  	Then The user selects Upload Status button from the left menu bar
  	And Check first entry status
    When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel		
    
  Examples:
   	| user                       |  
		| ic-test-tech@capgemini.com |
  
  @SanityCheck_ICSurgeon
  Scenario Outline: IC Surgeon Sanity Check
  	Given Chrome Browser is opened
    And CLP app url is entered 
    Then the CLP screen shall be displayed
    When the user clicks on go to login button
    Then the CLP Signin page shall be displayed
    And Email-Address is entered as "<user>"
    And Password is entered by the user 
    Then the Login button is clicked
    When the user enters otp
    Then the signin button is clicked
    When the user clicks data upload launch button
    And Homepage is displayed to the user
    Then Verify Staff Can View the following components in the left menu bar
  	| components    |
  	| Dashboard     |
  	| Upload Files  |
  	| Upload Status |
  	| History       |
  	| Help          |
  	| Info          |
  	| Logout        |
  	| Exit to Apps  |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And No Data to display text is displayed
  	Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		When the user clicks on Browse PC button and select a valid DICOM file and upload
		Then upload successful screen is displayed
  	Then Upload successful screen is displayed with the following components
  	| components        |
  	| header            |
  	| title             |
  	| icon              |
  	| close button      |
  	| dashboard button  |
  	| new upload button |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Entry is found in upload status table
  	And Check first entry status
  	And View details button is displayed at bottom
  	When User clicks on History button from homepage
  	Then History screen is displayed with the following components
  	| components       |
  	| 24hr check       |
  	| filter menu      |
  	| search box       |
  	| search btn       |
  	| table            |
  	| view details btn |
  	And Verify first entry in history page
  	Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
	  Then The user uploads non dicom files
  	And Upload failed screen is displayed with the following components
  	| components           |
  	| failed text          |
  	| not dicom text       |
  	| start new upload btn |
  	| re upload btn        |
		Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
	  Then The user uploads invalid dicom files
  	And Upload failed screen is displayed with the following components
  	| components           |
  	| failed text          |
  	| not dicom text       |
  	| start new upload btn |
  	| re upload btn        |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Check first two entries status
  	Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		Then The user uploads invalid dicom files
  	And Upload failed screen is displayed with the following components
  	| components           |
  	| failed text          |
  	| not dicom text       |
  	| start new upload btn |
  	| re upload btn        |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Entry is found in upload status table
  	And View details button is displayed at bottom
  	And Wait 15 minutes
  	When the user clicks on dashbaord button from left menu bar
  	And Check upload dashboard first entry status
  	And Wait 5 minutes
  	Then The user selects Upload Status button from the left menu bar
  	And Check first entry status
    When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel		
    
  Examples:
   	| user                          |  
		| ic-test-surgeon@capgemini.com |
		
	@SanityCheck_ICStaffUser
  Scenario Outline: IC Staff User Sanity Check
  	Given Chrome Browser is opened
    And CLP app url is entered 
    Then the CLP screen shall be displayed
    When the user clicks on go to login button
    Then the CLP Signin page shall be displayed
    And Email-Address is entered as "<user>"
    And Password is entered by the user 
    Then the Login button is clicked
    When the user enters otp
    Then the signin button is clicked
    When the user clicks data upload launch button
    And Homepage is displayed to the user
    Then Verify Staff Can View the following components in the left menu bar
  	| components    |
  	| Dashboard     |
  	| Upload Files  |
  	| Upload Status |
  	| History       |
  	| Help          |
  	| Info          |
  	| Logout        |
  	| Exit to Apps  |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And No Data to display text is displayed
  	Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		When the user clicks on Browse PC button and select a valid DICOM file and upload
		Then upload successful screen is displayed
  	Then Upload successful screen is displayed with the following components
  	| components        |
  	| header            |
  	| title             |
  	| icon              |
  	| close button      |
  	| dashboard button  |
  	| new upload button |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Entry is found in upload status table
  	And Check first entry status
  	And View details button is displayed at bottom
  	When User clicks on History button from homepage
  	Then History screen is displayed with the following components
  	| components       |
  	| 24hr check       |
  	| filter menu      |
  	| search box       |
  	| search btn       |
  	| table            |
  	| view details btn |
  	And Verify first entry in history page
  	Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
	  Then The user uploads non dicom files
  	And Upload failed screen is displayed with the following components
  	| components           |
  	| failed text          |
  	| not dicom text       |
  	| start new upload btn |
  	| re upload btn        |
		Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
	  Then The user uploads invalid dicom files
  	And Upload failed screen is displayed with the following components
  	| components           |
  	| failed text          |
  	| not dicom text       |
  	| start new upload btn |
  	| re upload btn        |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Check first two entries status
  	Then User clicks upload files button in left menu bar navigation
  	And The upload files header is displayed
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  #And The site selection screen is displayed with the following components
  	#| components   |
  	#| working text |
  	#| search box   |
  	#| search text  |
  	#| table        |
  	#| back button  |
  	#| next button  |
  	#| no site text |
	  When the user selects a site and click on next button
	  Then the Site is selected
		And the Surgeon selection screen is displayed
		#Then Surgeon screen is displayed with the following components
  	#| components      |
  	#| surgeon text    |
  	#| search box      |
  	#| search text     |
  	#| table           |
  	#| back button     |
  	#| next button     |
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		And the Application selection screen is displayed
		#Then Application selection screen is displayed with the following components
  	#| components  |
  	#| header      |
  	#| table       |
  	#| back button |
  	#| next button |
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		Then The user uploads invalid dicom files
  	And Upload failed screen is displayed with the following components
  	| components           |
  	| failed text          |
  	| not dicom text       |
  	| start new upload btn |
  	| re upload btn        |
  	Then The user selects Upload Status button from the left menu bar
  	And Upload status header is displayed
  	And Entry is found in upload status table
  	And View details button is displayed at bottom
  	And Wait 15 minutes
  	When the user clicks on dashbaord button from left menu bar
  	And Check upload dashboard first entry status
  	And Wait 5 minutes
  	Then The user selects Upload Status button from the left menu bar
  	And Check first entry status
    When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel		
    
  Examples:
   	| user                         			 |  
		| ic-test-supportstaff@capgemini.com |
  
  @SanityCheck_SNNHILManager
  Scenario Outline: SNNHIL Manager Sanity Check
  
  	Given Chrome Browser is opened
    And SNN HIL Manager CLP app url is entered
    Then the CLP screen shall be displayed
    When the user clicks on go to login button
    Then the CLP Signin page shall be displayed
    And Email-Address is entered as "<user>"
    And Password is entered by the user 
    Then the Login button is clicked
    And wait 2 seconds
    Then the snn hil manager user clicks data upload launch button
    Then Choose Site screen is displayed
		When the user clicks on dashbaord button from left menu bar
  	And Verify HIL Manager Can View the following components in the left menu bar
  	| components    |
  	| Dashboard     |
  	| Choose Site   |
  	| History       |
  	| Audit Log     |
  	| Imaging Links |
  	| Help          |
  	| Info          |
  	| Logout        |
  	| Exit to Apps  |
  	When the user clicks on imaging links button from left menu bar
    Then the imaging links shall be higlighted in left menu bar
    And the Create or Modify Links screen is displayed
    And the Create or Modify Links header text in white color
    Then Verify the following components are displayed in the left imaging links table
      | components                              |
      | All organizations                       |
      | Search tab                              |
      | Enter keyword, Name of Facility or City |
      | Search Button                           |
      | Facility type                           |
      | Active status                           |
    Then User clicks active facility in left table
    And the following elements are displayed below the left table in white font
      | elements                       |
      | Name                           |
      | Address                        |
      | Admin                          |
      | Email                          |
      | Contact number                 |
      | Activate Site button Disabled  |
      | Deactivate Site button Enabled |
    Then the right section table of Imaging Links screen is displayed
      | Items                                   |
      | Available Providers header text         |
      | Toggle button turned on                 |
      | Pin linked centers to top               |
      | Toggle button turned off                |
      | Search tab                              |
      | Enter keyword, Name of Facility or City |
      | Search Button                           |
      | Name                                    |
      | Link and delink icons                   |
      | City and State                          |
      | Contact number                          |
    Then The user clicks the deactivate site button under the left table
    And The deactivate site button should be disabled
    And The user clicks the activate site button under the left table
    And The deactivate site button should be enabled
    When the user selects "provider" from the right table which is in "Unlinked" state
    Then the selected provider is highlighted in the teal color rectangular box
    #And the following elements are displayed below the right table in white font
    #  | elements                    |
    #  | Provider Details text       |
    #  | Name                        |
    #  | Address                     |
    #  | Admin Name                  |
    #  | Website                     |
    #  | Contact number              |
    #  | Create Link button Enabled  |
    #  | Remove Link button Disabled |
    And wait 2 seconds
		#Then The user clicks create link button under right table
		#And The create link button should be disabled
		#Then The user clicks remove link button under right table
		#And The create link button should be enabled
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel	
    
  Examples: 
    | user                                  |
    | ic-test-snn-hil-manager@capgemini.com |