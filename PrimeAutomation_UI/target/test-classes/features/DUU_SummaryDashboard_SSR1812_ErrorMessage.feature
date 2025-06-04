#
#Feature: SSR1812 - Verifying that summary dashboard displays error message when no data available.
#
#@dashboard_TC0579
#Scenario Outline: TC0579 -IC admin_Verify the Upload dashboard screen does not display records when there is no data to be displayed when navigating to Upload Dashboard screen. 
#
#Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
#Then Homepage is displayed to the user
#When upload dashboard summary page is displayed to user
#Then the text No data to display is displayed in upload dashboard screen
#When the user clicks on exit to app button from left menu bar
#And user clicks on Logout icon from left panel
#Then user is logout from the application.
#And Data-Upload Application is closed
#
#	Examples: 
#	|user|  
#	|ic-test-admin@capgemini.com |	
