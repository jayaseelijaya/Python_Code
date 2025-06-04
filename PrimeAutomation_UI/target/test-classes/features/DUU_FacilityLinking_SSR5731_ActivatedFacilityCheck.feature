Feature: SSR5731 - Date Upload Utility shall allow users to upload to facilities that are linked with that specific site
  
  @linking_5019
  Scenario Outline: TC5019 - S&N HIL Manager_ Verify Data Upload Utility shall only allow facilities that have been activated (Active )by the S&N HIL Manager to initiate an upload for IC admin and IC tech

  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  	When Choose Canton Health Center Site and click next button
		And Homepage is displayed to the user
		And user clicks imaging links menu bar button
		Then User unlinks all facilities for canton health center
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<secondUser>"
		And Homepage is displayed to the user
		When User clicks on Upload Files from left panel
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be no site in the upload sequence
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<thirdUser>"
		And Homepage is displayed to the user
		When User clicks on Upload Files from left panel
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be no site in the upload sequence
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  	When Choose Canton Health Center Site and click next button
		And Homepage is displayed to the user
		And user clicks imaging links menu bar button
		Then User links one facilities for canton health center
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<secondUser>"
		And Homepage is displayed to the user
		When User clicks on Upload Files from left panel
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be a site shown in the upload sequence
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<thirdUser>"
		And Homepage is displayed to the user
		When User clicks on Upload Files from left panel
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be a site shown in the upload sequence
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Then user is logout from the application.
		And Data-Upload Application is closed

	Examples:
		|user                                  | secondUser                  | thirdUser                   |
		|ic-test-snn-hil-manager@capgemini.com | ic-test-admin@capgemini.com | ic-test-admin@capgemini.com |
		#ic-test-user@capgemini.com
		
  @linking_5023
  Scenario Outline: TC5023 - S&N HIL Manager_ Verify Data Upload Utility shall only allow facilities that have been activated (Active)by the S&N HIL Manager to initiate an upload for Hospital admin ,Support Staff and Surgeon.  

  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  	When Choose Canton Health Center Site and click next button
		And Homepage is displayed to the user
		And user clicks imaging links menu bar button
		Then User unlinks all facilities for canton health center
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<secondUser>"
		And Homepage is displayed to the user
		When User clicks on Upload Files from left panel
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be no site in the upload sequence
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<thirdUser>"
		And Homepage is displayed to the user
		When User clicks on Upload Files from left panel
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be no site in the upload sequence
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  	When Choose Canton Health Center Site and click next button
		And Homepage is displayed to the user
		And user clicks imaging links menu bar button
		Then User links one facilities for canton health center
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<secondUser>"
		And Homepage is displayed to the user
		When User clicks on Upload Files from left panel
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be a site shown in the upload sequence
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<thirdUser>"
		And Homepage is displayed to the user
		When User clicks on Upload Files from left panel
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be a site shown in the upload sequence
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Then user is logout from the application.
		And Data-Upload Application is closed

	Examples:
		|user                                  | secondUser                  | thirdUser                   |
		|ic-test-snn-hil-manager@capgemini.com | ic-test-admin@capgemini.com | ic-test-admin@capgemini.com |
		#ic-test-surgeon@capgemini.com
		#ic-test-staff@capgemini.com
		
	@linking_7936
  Scenario Outline: TC7936 - S&N HIL Manager_ Verify that Data Upload Utility Shall not allow users from facilities with an " Inactive " status to initiate an Upload for IC admin and IC Tech.
  
  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  	When Choose Canton Health Center Site and click next button
		And Homepage is displayed to the user
		And user clicks imaging links menu bar button
		And all elements are displayed in the left section of the imaging links page
		Then The user clicks on canton health center in the left table
		And the user verifies details under left table
		And the user checks activate link button
		And the user check deactivate link button
		And the user verifies details under right table
		Then User unlinks all facilities for canton health center	
		#User clicks deactivate site button
		#The site status should be inactive	
		#The user clicks a site in the right table
		#The create link button should be disabled
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<secondUser>"
		And Homepage is displayed to the user
		When User clicks on Upload Files from left panel
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be no site in the upload sequence
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<thirdUser>"
		And Homepage is displayed to the user
		When User clicks on Upload Files from left panel
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be no site in the upload sequence
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Then user is logout from the application.
		And Data-Upload Application is closed
	
	Examples:
		|user                                  | secondUser                  | thirdUser                   |
		|ic-test-snn-hil-manager@capgemini.com | ic-test-admin@capgemini.com | ic-test-admin@capgemini.com |
		#ic-test-user@capgemini.com
		
		
	@linking_7937
  Scenario Outline: TC7937 - S&N HIL Manager_ Verify that Data Upload Utility Shall not allow users from facilities with an N/A status to initiate an Upload for IC admin and IC Tech
  
  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  	When Choose Canton Health Center Site and click next button
		And Homepage is displayed to the user
		And user clicks imaging links menu bar button
		And all elements are displayed in the left section of the imaging links page
		Then The user clicks on canton health center in the left table
		And the user verifies details under left table
		And the user checks activate link button
		And the user check deactivate link button
		And the user verifies details under right table
		Then User unlinks all facilities for canton health center		
		Then User links one facilities for canton health center
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<secondUser>"
		And Homepage is displayed to the user
		When User clicks on Upload Files from left panel
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be a site shown in the upload sequence
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<thirdUser>"
		And Homepage is displayed to the user
		When User clicks on Upload Files from left panel
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be a site shown in the upload sequence
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Then user is logout from the application.
		And Data-Upload Application is closed

	Examples:
		|user                                  | secondUser                  | thirdUser                   |
		|ic-test-snn-hil-manager@capgemini.com | ic-test-admin@capgemini.com | ic-test-admin@capgemini.com |
		#ic-test-user@capgemini.com
		
	@linking_7938
  Scenario Outline: TC7938 - S&N HIL Manager_ Verify Data Upload Utility shall not allow facilities  with an "Inactive" status  to initiate an upload for Hospital admin ,Support Staff and Surgeon
  
  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  	When Choose Canton Health Center Site and click next button
		And Homepage is displayed to the user
		And user clicks imaging links menu bar button
		And all elements are displayed in the left section of the imaging links page
		Then The user clicks on canton health center in the left table
		And the user verifies details under left table
		And the user checks activate link button
		And the user check deactivate link button
		And the user verifies details under right table
		Then User unlinks all facilities for canton health center	
		#User clicks deactivate site button
		#The site status should be inactive	
		#The user clicks a site in the right table
		#The create link button should be disabled
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<secondUser>"
		And Homepage is displayed to the user
		When User clicks on Upload Files from left panel
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be no site in the upload sequence
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<thirdUser>"
		And Homepage is displayed to the user
		When User clicks on Upload Files from left panel
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be no site in the upload sequence
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Then user is logout from the application.
		And Data-Upload Application is closed
	
	Examples:
		|user                                  | secondUser                  | thirdUser                   |
		|ic-test-snn-hil-manager@capgemini.com | ic-test-admin@capgemini.com | ic-test-admin@capgemini.com |
		#ic-test-user@capgemini.com
		
	@linking_7947
  Scenario Outline: TC7947 - S&N HIL Manager_ Verify Data Upload Utility shall not allow facilities  with an NA status  to initiate an upload for Hospital admin ,Support Staff and Surgeon.
  
  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  	When Choose Canton Health Center Site and click next button
		And Homepage is displayed to the user
		And user clicks imaging links menu bar button
		And all elements are displayed in the left section of the imaging links page
		Then The user clicks on canton health center in the left table
		And the user verifies details under left table
		And the user checks activate link button
		And the user check deactivate link button
		And the user verifies details under right table
		Then User unlinks all facilities for canton health center		
		Then User links one facilities for canton health center
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<secondUser>"
		And Homepage is displayed to the user
		When User clicks on Upload Files from left panel
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be a site shown in the upload sequence
		And Data-Upload Application is closed
		Given that the user is logged in to Data-Upload Utility Application through chrome "<thirdUser>"
		And Homepage is displayed to the user
		When User clicks on Upload Files from left panel
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be a site shown in the upload sequence
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Then user is logout from the application.
		And Data-Upload Application is closed

	Examples:
		|user                                  | secondUser                  | thirdUser                   |
		|ic-test-snn-hil-manager@capgemini.com | ic-test-admin@capgemini.com | ic-test-admin@capgemini.com |
		#ic-test-surgeon@capgemini.com
		#ic-test-staff@capgemini.com