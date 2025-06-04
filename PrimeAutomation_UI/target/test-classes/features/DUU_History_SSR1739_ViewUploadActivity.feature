Feature: SSR1739 - Verify viewing of users upload activity

  @history_TC2831
  Scenario Outline: TC2831 - Hospital Admin_Verify Admin can view all users upload activity from an organization in summary dashboard and history

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
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<secondUser>"
		Then the uploaded entry is shown on the upload dashboard
		When User clicks on History button from homepage
		Then the uploaded entry is shown in the history page table
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
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<thirdUser>"
		When Choose Canton Health Center Site and click next button
		Then the uploaded entry is shown on the upload dashboard
		When User clicks on History button from homepage
		Then the uploaded entry is shown in the history page table
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Then user is logout from the application.
		And Data-Upload Application is closed

	Examples:
		|user                        | secondUser                    | thirdUser                    |
		|ic-test-staff@capgemini.com | ic-test-surgeon@capgemini.com | ic-test-snn-hil-manager@capgemini.com |
