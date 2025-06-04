Feature: File upload

	@fileUpload_demo
  Scenario Outline: File upload

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
		When the user clicks on Browse PC button and select a valid DICOM file and upload
		Then upload successful screen is displayed
		Then the user clicks file dashboard in left menu
		
		 Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
      
      
      
    @fileUploadInavlid_demo
  	Scenario Outline: File upload

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
		Then The user uploads invalid dicom files
  	And Upload failed screen is displayed with the following components
  	| components           |
  	| failed text          |
  	| not dicom text       |
  	| start new upload btn |
  	| re upload btn        |
		
		 Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
      