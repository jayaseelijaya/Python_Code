#Feature: SSR1764 - Verifying Filter in summary dashboard, history and audit log screen.
#	
#Scenario Outline: TC0633 - To verify DDU web App shall filter the Summary dashboard by applying multiple filters.
#Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
#Then Homepage is displayed to the user
#And the dashboard summary shall display list of upload items
#When the user clicks on filter button
#And the user selects surgeon filter on summary dashboard
#And the user selects site filter on summary dashboard
#And the user selects application filter on summary dashboard
#And the user clicks on Done button
#Then the summary dashboard shall display multiple filtered list
#When the user removes the filter
#Then summary dashboard shall display all items without filter
#Then Data-Upload Application is closed
 #
  #Examples: 
#		|user|  
#		|ic-test-admin@capgemini.com |
#		#|ic-test-tech@capgemini.com |
#		#|ic-test-nurse@capgemini.com |
#		#|ic-test-surgeon@capgemini.com |
#
#Scenario Outline: TC0633 - To verify DDU web App shall filter the History page by applying multiple filters.
#Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
#Then Homepage is displayed to the user
#And the dashboard summary shall display list of upload items
#When the user clicks on history button from left menu bar
#Then the history tab shall be displayed
#When the user clicks on Filter Button
#And the user selects uploader filter on history page
#And the user selects patient filter on history page
#And the user selects surgeon filter on history page
#And the user selects site filter on history page
#And the user clicks on Done button
#Then the history page shall display multiple filtered list
#When the user removes the filter
#Then history shall display all items without filter
#And Data-Upload Application is closed
 #
  #Examples: 
#		|user|  
#		|ic-test-admin@capgemini.com |
#		#|ic-test-tech@capgemini.com |
#		#|ic-test-nurse@capgemini.com |
#		#|ic-test-surgeon@capgemini.com |	
#		
#
#Scenario Outline: TC0633 - To verify DDU web App shall filter the Audit Log page by applying multiple filters.
#Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
#Then Homepage is displayed to the user
#And the dashboard summary shall display list of upload items
#When the user clicks on audit log button from left menu bar
#Then the audit log tab shall be displayed
#When the user clicks on audit log filter button
#And the user selects date filter on audit log
#And the user selects username filter on audit log
#And the user clicks on Done button
#Then the audit log shall display multiple filtered list
#When the user removes the filter
#Then audit log shall display all items without filter
#And Data-Upload Application is closed
 #
  #Examples: 
#		|user|  
#		|ic-test-admin@capgemini.com |
#		#|ic-test-tech@capgemini.com |
#		#|ic-test-nurse@capgemini.com |
#		#|ic-test-surgeon@capgemini.com |				
#		