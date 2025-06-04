#
#Feature: SSR1836 - Verifying that DUU web app shall reflect the state options as Uploaded, Processing, Complete, Error, Recalled.
#
#Scenario Outline: TC0752 - Verify that file status should be displayed as Uploaded, Processing, Completed, Error, Recalled to user a.
#	
#	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
#	And Upload dashboad page is displayed to user
#	When User clicks on Filter button from upload dashboard page
#	And Clicks on File Status 
#	Then File status as Complete is displayed to user 
#	And File status as Processing is displayed to user
#	And File status as Error is displayed to user
#	And File status as Recalled is displayed to user
#	And File status as Uploaded is displayed to user
#	And Data-Upload Application is closed 
#	
#	Examples: 
#	|user|  
#	|ic-test-admin@capgemini.com |
#	#|ic-test-tech@capgemini.com |
#	#|ic-test-surgeon@capgemini.com|
#	#|ic-test-supportstaff@capgemini.com |
#	#|ic-test-snhilmanager@capgemini.com |
#	#|h-test-admin@capgemini.com  |
#	#|ic-test-snhilmanager@capgemini.com |
#
 #
