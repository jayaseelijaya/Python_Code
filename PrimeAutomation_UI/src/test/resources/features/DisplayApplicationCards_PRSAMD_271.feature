#@gh
#Feature: PRSAMD_271 - Verifying user can view the Application card selection Modal based on after selecting the Facility and Surgeon. 
#
#Scenario Outline: PRSAMD_271 - Verifying application card for the surgeon selected which has card listed. 
#
#	#Given chrome browser is opened 
#	#And Application url is entered 
#	#When username is entered as "<user>" 
#	#And Password is entered 
#	#And Login button is clicked 
#	#Then the homescreen is displayed 
#	#When user clicked on Upload files button from left menu bar 
#	#And then user clicks on Upload File 
#	#Then Search facility screen is displayed and user selects facility from the list 
#	#And once facility is selected user clicks on Next button 
#	#And Surgoen list associated with the facility is displayed and user selects surgeon 
#	#Then application card should is displayed as per the selected surgeon 
#	#And applicaton is closed 
#	
#	# Examples: 
#		#|user|  
#		#|ic-test-admin@capgemini.com |
#		#|ic-test-tech@capgemini.com |
#		#|ic-test-nurse@capgemini.com |
#		#|ic-test-surgeon@capgemini.com |
#		
# Scenario Outline: PRSAMD_271- Verifying application card for the surgeon selected which has no card listed. 
#
#	# Given chrome browser is opened 
#	# And Application url is entered 
#	# When username is entered as "<user>" 
#	# And Password is entered 
#	# And Login button is clicked 
#	# Then the homescreen is displayed 
#	# When user clicked on Upload files button from left menu bar 
#	# And then user clicks on Upload File 
#	# Then Search facility screen is displayed and user selects facility from the list 
#	#And once facility is selected user clicks on Next button 
#	# And user selects surgeon which deosn't have application cards and click on Next 
#	# Then application card should not be displayed with notification message 
#	# And applicaton is closed 
#	
#	#Examples: 
#	#	|user|  
#		#|ic-test-admin@capgemini.com |
#	#	|ic-test-tech@capgemini.com |
#	#	|ic-test-nurse@capgemini.com |
#		#|ic-test-surgeon@capgemini.com |
#		
 # Scenario Outline:PRSAMD_271 - Verifying Application card for the surgoen which has more than 9 cards listed. 
#
#	# Given chrome browser is opened 
#	# And Application url is entered 
#	# When username is entered as "<user>" 
#	# And Password is entered 
#	# And Login button is clicked 
#	# Then the homescreen is displayed 
#	# When user clicked on Upload files button from left menu bar 
#	# And then user clicks on Upload File 
#	# Then user selects facility from the list 
#	# And once facility is selected user clicks on Next button 
#	# And user selects surgeon which have more than Nine application cards 
#	# And clicked next button 
#	#Then more than nine application card is displayed 
#	 # And applicaton is closed 
#	
#	# Examples: 
#		#|user|  
#		#|ic-test-admin@capgemini.com |
#		# |ic-test-tech@capgemini.com |
#		# |ic-test-nurse@capgemini.com |
#		# |ic-test-surgeon@capgemini.com |