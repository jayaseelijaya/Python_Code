Feature: SSR1826 - Verifying that summary dashboard displays error message when no data available for applied filter and search criteria.

@dashboard_TC0767
Scenario Outline: TC0767 - IC admin_Verify the Upload dashboard screen displays error message when no data available for applied filter. 

Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
And hrs filter is displayed at top-right of the Upload Dashboard screen
When user clicks on Hours checkbox filter 
Then the text No data to display is displayed in upload dashboard screen
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed

	Examples: 
	|user|  
	|ic-test-admin@capgemini.com |


@dashboard_TC2972
Scenario Outline: TC2972 - IC Technician_Verify the Upload dashboard screen displays error message when no data available for applied filter. 

Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
And hrs filter is displayed at top-right of the Upload Dashboard screen
When user clicks on Hours checkbox filter 
Then the text No data to display is displayed in upload dashboard screen
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed

	Examples: 
	|user|  
	|ic-test-user@capgemini.com |

@dashboard_TC2973
Scenario Outline: TC2973 - Hospital admin_Verify the Upload dashboard screen displays error message when no data available for applied filter. 

Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
And hrs filter is displayed at top-right of the Upload Dashboard screen
When user clicks on Hours checkbox filter 
Then the text No data to display is displayed in upload dashboard screen
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed

	Examples: 
	|user|  
	|ic-test-hospital-admin@capgemini.com |
	
	
@dashboard_TC2974
Scenario Outline: TC2974 - Surgeon _Verify the Upload dashboard screen displays error message when no data available for applied filter. 

Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
And hrs filter is displayed at top-right of the Upload Dashboard screen
When user clicks on Hours checkbox filter 
Then the text No data to display is displayed in upload dashboard screen
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed

	Examples: 
	|user|  
	|ic-test-surgeon@capgemini.com |


@dashboard_TC2975
Scenario Outline: TC2975 - Support staff _Verify the Upload dashboard screen displays error message when no data available for applied filter. 

Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
And hrs filter is displayed at top-right of the Upload Dashboard screen
When user clicks on Hours checkbox filter 
Then the text No data to display is displayed in upload dashboard screen
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed

	Examples: 
	|user |  
	|ic-test-staff@capgemini.com |
		
	
@dashboard_TC2976
Scenario Outline: TC2976 - S&N HIL Manager_Verify the Upload dashboard screen displays error message when no data available for applied filter. 

Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
When choose site screen is displayed to user
And user selects facilty which has no data associated
And click on select button after selecting facility
And upload dashboard summary page is displayed to user
Then hrs filter is displayed at top-right of the Upload Dashboard screen
When user clicks on Hours checkbox filter 
Then the text No data to display is displayed in upload dashboard screen
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed
	
	Examples: 
	|user |  
	|ic-test-snn-hil-manager@capgemini.com |
	
	
@dashboard_TC2966
Scenario Outline: TC2966 - IC Technician _Verify the Upload dashboard screen does not display records. 

Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
When upload dashboard summary page is displayed to user
Then the text No data to display is displayed in upload dashboard screen
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed

	Examples: 
	|user|  
	|ic-test-user@capgemini.com |


@dashboard_TC2967
Scenario Outline: TC2967 - Hospital admin _Verify the Upload dashboard screen does not display records. 

Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
When upload dashboard summary page is displayed to user
Then the text No data to display is displayed in upload dashboard screen
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed

	Examples: 
	|user|  
	|ic-test-hospital-admin@capgemini.com |	


@dashboard_TC2968
Scenario Outline: TC2968 - Surgeon_Verify the Upload dashboard screen does not display records. 

Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
When upload dashboard summary page is displayed to user
Then the text No data to display is displayed in upload dashboard screen
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed

	Examples: 
	|user|  
	|ic-test-surgeon@capgemini.com |	

@dashboard_TC2969
Scenario Outline: TC2969 - Supportstaff _Verify the Upload dashboard screen does not display records. 

Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
When upload dashboard summary page is displayed to user
Then the text No data to display is displayed in upload dashboard screen
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed

	Examples: 
	|user|  
	| ic-test-staff@capgemini.com |


@dashboard_TC2970	
Scenario Outline: TC2970 - S&N HIL Manager_Verify the Upload dashboard screen does not display records. 

Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
When choose site screen is displayed to user
And user selects facilty which has no data associated
And click on select button after selecting facility
And upload dashboard summary page is displayed to user
Then the text No data to display is displayed in upload dashboard screen
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed

	Examples: 
	|user|  
	| ic-test-snn-hil-manager@capgemini.com |

	

@dashboard_TC0579	
Scenario Outline: TC0579 -  ICadmin_Verify the Upload dashboard screen does not display records. 

Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
When choose site screen is displayed to user
And user selects facilty which has no data associated
And click on select button after selecting facility
And upload dashboard summary page is displayed to user
Then the text No data to display is displayed in upload dashboard screen
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed

	Examples: 
	|user|  
	|ic-test-admin@capgemini.com |
	