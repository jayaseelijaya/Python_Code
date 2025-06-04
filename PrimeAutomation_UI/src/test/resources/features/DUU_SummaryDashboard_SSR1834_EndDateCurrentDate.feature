Feature: SSR1834 - Verifying multiple users ability to select end date up to current date


  @dashboard_TC0700
  Scenario Outline: TC0700 - IC Admin_ Verify the user is allowed to select end date up to current date under date filter in Upload Dashboard screen
  
  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
		And Homepage is displayed to the user
	 	And the filter button is displayed in the top right
	 	Then the user clicks the filter button
	 	And the user clicks the plus button on the date filter
	 	And the user clicks the end button in the date filter
	 	And verify all dates after the current date are not enabled
	 	Then the user selects current date as end date from the date picker table
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Then user is logout from the application.
		
	Examples:
		|user                        |
		|ic-test-admin@capgemini.com |
		
  @dashboard_TC2983
  Scenario Outline: TC2983 - IC Technician_ Verify the user is allowed to select end date up to current date under date filter in Upload Dashboard screen
  
  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
		And Homepage is displayed to the user
	 	And the filter button is displayed in the top right
	 	Then the user clicks the filter button
	 	And the user clicks the plus button on the date filter
	 	And the user clicks the end button in the date filter
	 	And verify all dates after the current date are not enabled
	 	Then the user selects current date as end date from the date picker table
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Then user is logout from the application.
		
	Examples:
		|user                        |
		|ic-test-user@capgemini.com |
		
	@dashboard_TC2984
  Scenario Outline: TC2984 - Hospital Admin_Verify the user is allowed to select end date up to current date under date filter in Upload Dashboard screen
  
  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
		And Homepage is displayed to the user
	 	And the filter button is displayed in the top right
	 	Then the user clicks the filter button
	 	And the user clicks the plus button on the date filter
	 	And the user clicks the end button in the date filter
	 	And verify all dates after the current date are not enabled
	 	Then the user selects current date as end date from the date picker table
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Then user is logout from the application.
		
	Examples:
		|user                                 |
		|ic-test-hospital-admin@capgemini.com |
				
	@dashboard_TC2985
  Scenario Outline: TC2985 - Surgeon_Verify the user is allowed to select end date up to current date under date filter in Upload Dashboard screen
  
  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
		And Homepage is displayed to the user
	 	And the filter button is displayed in the top right
	 	Then the user clicks the filter button
	 	And the user clicks the plus button on the date filter
	 	And the user clicks the end button in the date filter
	 	And verify all dates after the current date are not enabled
	 	Then the user selects current date as end date from the date picker table
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Then user is logout from the application.
		
	Examples:
		|user                          |
		|ic-test-surgeon@capgemini.com |
		
	@dashboard_TC2986
  Scenario Outline: TC2986 - Support Staff_Verify the user is allowed to select end date up to current date under date filter in Upload Dashboard screen

  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
		And Homepage is displayed to the user
	 	And the filter button is displayed in the top right
	 	Then the user clicks the filter button
	 	And the user clicks the plus button on the date filter
	 	And the user clicks the end button in the date filter
	 	And verify all dates after the current date are not enabled
	 	Then the user selects current date as end date from the date picker table
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Then user is logout from the application.
		
	Examples:
		|user                        |
		|ic-test-staff@capgemini.com |
		
	@dashboard_TC2987
  Scenario Outline: TC2987 - SN HIL Manager_Verify the user is allowed to select end date up to current date under date filter in Upload Dashboard screen
  
  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  	When Choose Canton Health Center Site and click next button
		And Homepage is displayed to the user
	 	And the filter button is displayed in the top right
	 	Then the user clicks the filter button
	 	And the user clicks the plus button on the date filter
	 	And the user clicks the end button in the date filter
	 	And verify all dates after the current date are not enabled
	 	Then the user selects current date as end date from the date picker table
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Then user is logout from the application.

		
	Examples:
		|user                                  |
		|ic-test-snn-hil-manager@capgemini.com |