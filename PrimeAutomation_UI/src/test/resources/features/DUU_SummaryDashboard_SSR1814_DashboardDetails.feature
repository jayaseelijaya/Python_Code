##This SSR is removed

#
#Feature:  Verifying summary dashboard provide details of all users upload activity to Admin users.
#
#Scenario Outline: TC0758 - Verify DDU web App summary dashboard shall provide details of all users upload activity to Admin users.
#
#Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
#When Upload dashboad page is displayed to user
#Then details of all users upload activity is displayed to the admin user in the dasboard page
#And Data-Upload Application is closed 
#
#Examples: 
#		|user|  
#		|ic-test-admin@capgemini.com |
#		#|h-test-admin@capgemini.com  |
#		#|ic-test-snhilmanager@capgemini.com |
#		
#		
#	
#Scenario Outline: TC0768 - Verify DDU web App summary dashboard shall provide details of all users upload activity to non-Admin users.
#
#Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
#When Upload dashboad page is displayed to user
#Then details of all users upload activity is displayed to the non admin user in the dasboard page
#And Data-Upload Application is closed 
#
#Examples: 	
#	|user|  
#	#|ic-test-tech@capgemini.com |
#	|ic-test-surgeon@capgemini.com  |
    #|ic-test-supportstaff@capgemini.com |
