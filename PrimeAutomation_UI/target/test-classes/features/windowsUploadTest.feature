Feature: Uploading using windows 

@uploadingWindows 
Scenario Outline: Upload using windows 
	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>" 
	And Homepage is displayed to the user 
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
	Then the user uploads a valid dicom folder using windows file explorer 
	#When User clicks on Upload Files from left panel
	#Then the upload icon and Upload button are displayed
	#When Clicks on Upload Button
	#Then the Site selection screen is displayed
	#When the user selects a site and click on next button
	#Then the Site is selected
	#And the Surgeon selection screen is displayed
	#When the user selects a surgeon and click on next button
	#Then the Surgeon is selected
	#And the Application selection screen is displayed
	#When the user selects an application and click on Next button
	#Then the Upload screen is displayed with drag drop area, Back and Browse PC button
	#Then the user uploads an invalid dicom folder using windows file explorer
	#When User clicks on Upload Files from left panel
	#Then the upload icon and Upload button are displayed
	#When Clicks on Upload Button
	#Then the Site selection screen is displayed
	#When the user selects a site and click on next button
	#Then the Site is selected
	#And the Surgeon selection screen is displayed
	#When the user selects a surgeon and click on next button
	#Then the Surgeon is selected
	#And the Application selection screen is displayed
	#When the user selects an application and click on Next button
	#Then the Upload screen is displayed with drag drop area, Back and Browse PC button
	#Then the user uploads a non dicom folder using windows file explorer
	When the user click on Exit Apps at the bottom of the left menu panel 
	When user clicks on Logout icon from left panel 
	
	Examples: 
		|user                        |
		|ic-test-admin@capgemini.com |
