Feature: SSR1727 - Test recall functionality within 15 minutes of upload

	@dashboard321_TC0803
  Scenario Outline: TC0803 - IC Admin_Verify Recall button disappears from Upload dashboard screen after 15 mins of successful file upload
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
		Then the uploaded entry is shown on the upload dashboard
		And check for recall button on first entry
		And check for white uploaded check mark
		And Wait 15 minutes
		Then the user clicks upload status in left menu
		Then the user clicks file dashboard in left menu
		And Wait 5 seconds
		And the recall button is no longer displayed
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel

	Examples:
		|user                        |
		|ic-test-admin@capgemini.com |

	@dashboard_TC2962
  Scenario Outline: TC2962 - IC Tech_Verify Recall button disappears from Upload dashboard screen after 15 mins of successful file upload
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
		Then the uploaded entry is shown on the upload dashboard
		And check for recall button on first entry
		And check for white uploaded check mark
		And Wait 15 minutes
		Then the user clicks upload status in left menu
		Then the user clicks file dashboard in left menu
		And Wait 5 seconds
		And the recall button is no longer displayed
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel

	Examples:
		|user                       |
		|ic-test-tech@capgemini.com |

	@dashboard321_TC2963
  Scenario Outline: TC2963 - Hospital Admin_Verify Recall button disappears from Upload dashboard screen after 15 mins of successful file upload
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
		Then the uploaded entry is shown on the upload dashboard
		And check for recall button on first entry
		And check for white uploaded check mark
		And Wait 15 minutes
		Then the user clicks upload status in left menu
		Then the user clicks file dashboard in left menu
		And Wait 5 seconds
		And the recall button is no longer displayed
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel

	Examples:
		|user                                 |
		|ic-test-hospital-admin@capgemini.com |

	@dashboard321_TC2964
  Scenario Outline: TC2964 - Surgeon_Verify Recall button disappears from Upload dashboard screen after 15 mins of successful file upload
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
		Then the uploaded entry is shown on the upload dashboard
		And check for recall button on first entry
		And check for white uploaded check mark
		And Wait 15 minutes
		Then the user clicks upload status in left menu
		Then the user clicks file dashboard in left menu
		And Wait 5 seconds
		And the recall button is no longer displayed
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel

	Examples:
		|user                          |
		|ic-test-surgeon@capgemini.com |

	@dashboard_TC2965
  Scenario Outline: TC2964 - Surgeon_Verify Recall button disappears from Upload dashboard screen after 15 mins of successful file upload
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
		Then the uploaded entry is shown on the upload dashboard
		And check for recall button on first entry
		And check for white uploaded check mark
		And Wait 15 minutes
		Then the user clicks upload status in left menu
		Then the user clicks file dashboard in left menu
		And Wait 5 seconds
		And the recall button is no longer displayed
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel

	Examples:
		|user                        |
		|ic-test-staff@capgemini.com |
		
