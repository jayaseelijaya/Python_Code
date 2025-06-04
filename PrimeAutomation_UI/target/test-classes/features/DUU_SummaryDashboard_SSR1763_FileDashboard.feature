#
#Feature: Verifying summary dashboard, upload history and user activity logs 
#
#Scenario Outline: TC0833 - Verify DDU web App shall provide access to Summary dashboard, upload history and user activity logs
#
#Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
#Then Homepage is displayed to the user
#And the dashboard summary shall display list of upload items
#When the user enters Lisa text as surgeon name in search box
#And the user clicks on search button
#Then the matching Lisa text surgeon name list shall be displayed
#When the user clicks on filter button
#And the user selcts filter as surgeon name
#Then the list shall be filtered as selected surgeon name
#When the user clicks on history button from left menu bar
#Then the history tab shall be displayed
#When the user enters Patrick text as patient name in search box
#And the user clicks on Search Button
#Then the matching Patrick text patient name list shall be displayed
#When the user clicks on Filter Button
#And the user selects filter as patient name
#Then the list shall be filtered as selected patient name
#When the user clicks on audit log button from left menu bar
#And the audit log tab shall be displayed
#When the user enters ic-test-admin@capgemini.com email as user name in search box
#And the user clicks on Search button
#Then the matching ic-test-admin@capgemini.com email user name list shall be displayed
#When the user clicks on Filter button
#And the user selcts filter as user name
#Then the list shall be filtered as selected user name
#And Data-Upload Application is closed
 #
  #Examples: 
#		|user|  
#		|ic-test-admin@capgemini.com |
#		#|ic-test-tech@capgemini.com |
#		#|ic-test-nurse@capgemini.com |
#		#|ic-test-surgeon@capgemini.com |
#		