Feature: SSR3691 - Settings Page Verify UI

	@settings_TC0862
  Scenario Outline: TC1104 - IC Admin_Verify Global Viewing settings is modifiable by Hospital admin.
    #Make sure successful and unsuccessful expiration is set to 14 days by default
  	Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Homepage is displayed to the user
    #Step2
    When click settings page button from left menu
    And disable global view setting
    #step3
  	When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #step4
    When Clicks on Upload Button
    #step5
    Then the Site selection screen is displayed
    When the user selects a site and click on next button
    Then the Site is selected
    #step6
		And the Surgeon selection screen is displayed
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		#step7
		And the Application selection screen is displayed
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		#step8
		When the user clicks on Browse PC button and select a valid DICOM file and upload
		Then the Upload successful screen is displayed
		#step9
		Then the user clicks file dashboard in left menu
		#step10
		And the user is able to view image upload records in dashboard
		#Step11
		Then the user clicks history in left menu
		#step12
		And the user is able to view image upload records in history
		#step13,14,15
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #Step16
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech1@capgemini.com"
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
		Then the Upload successful screen is displayed
		#step17
		When the user clicks file dashboard in left menu
		#step18
		Then the user is able to view image upload records in dashboard
		#Step19
		When the user clicks history in left menu
		#step20,21
		Then the user is able to view image upload records in history
		#step22,23,24
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #step25
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech2@capgemini.com"
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
		Then the Upload successful screen is displayed
		#step26
		When the user clicks file dashboard in left menu
		#Step27
		Then the user is able to view image upload records in dashboard
		#Step28
		When the user clicks history in left menu
		#step29,30
		Then the user is able to view image upload records in history
		#step31,32
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #step33
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
		And Homepage is displayed to the user
		#step34,#step35
		When the user clicks history in left menu
		#Step36
    When click settings page button from left menu
    And successful uploads text is displayed
    And unsuccessful uploads text is displayed
    And global viewing toggle is displayed
    And reset to default button is displayed and enabled
    And save button is displayed and disabled
    And settings page header is displayed
    #step37
    When turn on global view setting
    And click on Save Button
    #step38
		When the user clicks file dashboard in left menu
		#step39
		When the user clicks history in left menu
    #step40,41
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #step42
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech1@capgemini.com"
  	And Homepage is displayed to the user
  	#step43,  	#step44
		When the user clicks history in left menu
		#step45,46
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #step47
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech2@capgemini.com"
  	And Homepage is displayed to the user
  	#step48,#step49
		When the user clicks history in left menu
		#step50,51,52
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	
	
	@settings_TC1104
  Scenario Outline: TC1104 - Hospital Admin_Verify Global Viewing settings is modifiable by Hospital admin.
    #Make sure successful and unsuccessful expiration is set to 14 days by default
  	Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    And Homepage is displayed to the user
    #Step2
    When click settings page button from left menu
    And disable global view setting
    #step3
  	When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #step4
    When Clicks on Upload Button
    #step5
    Then the Site selection screen is displayed
    When the user selects a site and click on next button
    Then the Site is selected
    #step6
		And the Surgeon selection screen is displayed
		When the user selects a surgeon and click on next button
		Then the Surgeon is selected
		#step7
		And the Application selection screen is displayed
		When the user selects an application and click on Next button
		Then the Upload screen is displayed with drag drop area, Back and Browse PC button
		#step8
		When the user clicks on Browse PC button and select a valid DICOM file and upload
		Then the Upload successful screen is displayed
		#step9
		Then the user clicks file dashboard in left menu
		#step10
		And the user is able to view image upload records in dashboard
		#Step11
		Then the user clicks history in left menu
		#step12
		And the user is able to view image upload records in history
		#step13,14,15
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #Step16
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech1@capgemini.com"
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
		Then the Upload successful screen is displayed
		#step17
		When the user clicks file dashboard in left menu
		#step18
		Then the user is able to view image upload records in dashboard
		#Step19
		When the user clicks history in left menu
		#step20,21
		Then the user is able to view image upload records in history
		#step22,23,24
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #step25
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech2@capgemini.com"
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
		Then the Upload successful screen is displayed
		#step26
		When the user clicks file dashboard in left menu
		#Step27
		Then the user is able to view image upload records in dashboard
		#Step28
		When the user clicks history in left menu
		#step29,30
		Then the user is able to view image upload records in history
		#step31,32
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #step33
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
		And Homepage is displayed to the user
		#step34,#step35
		When the user clicks history in left menu
		#Step36
    When click settings page button from left menu
    And successful uploads text is displayed
    And unsuccessful uploads text is displayed
    And global viewing toggle is displayed
    And reset to default button is displayed and enabled
    And save button is displayed and disabled
    And settings page header is displayed
    #step37
    When turn on global view setting
    And click on Save Button
    #step38
		When the user clicks file dashboard in left menu
		#step39
		When the user clicks history in left menu
    #step40,41
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #step42
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech1@capgemini.com"
  	And Homepage is displayed to the user
  	#step43,  	#step44
		When the user clicks history in left menu
		#step45,46
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
	  #step47
	  Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-tech2@capgemini.com"
  	And Homepage is displayed to the user
  	#step48,#step49
		When the user clicks history in left menu
		#step50,51,52
		When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel
	  Then user is logout from the application.
  	
  
  
