#
#Feature: PRSAMD_263 - Verify List of Surgeon's displayed in Surgeon Select Screen Modal when user selects Facility from list of items displayed.
#
 # Scenario Outline: PRSAMD_263 - Verify Surgeon's List in Surgeon Select Screen Modal associated with the Facility selected by the user.
 #   Given that the chrome browser is opened
 #   And that app url is entered
 #   When the Username is entered as "<user>"
 #   And the password is entered
 #   And the login button is clicked
 #   Then the homepage shall be displayed
 #   When user clicked on upload files button from left menu bar
 #   And then user click on Upload File
  #  Then Search facility screen should be displayed and user selects facility from the list
 #   And after selecting facility user click on Next button
 #   Then Surgoen list associated with the facility is displayed
 #   And the applicaton is closed 
  #
 # Examples: 
 # |user|  
  #|ic-test-admin@capgemini.com |
 # |ic-test-nurse@capgemini.com|
#|ic-test-tech@capgemini.com|
#|ic-test-surgeon@capgemini.com |
 #
    #
 #Scenario Outline: PRSAMD_263 - Verify Surgeon's List when there is no Surgeon associated with the Facility selected by the user.
    #Given that the chrome browser is opened
    #And that app url is entered
    #When the Username is entered as "<user>"
    #And the password is entered
    #And the login button is clicked
    #Then the homepage shall be displayed
    #When user clicked on upload files button from left menu bar
    #And then user click on Upload File
    #Then Search facility screen should be displayed and user selects facility which doesnt have Surgeon associated
    #And after selecting facility user click on Next button
    #Then no surgoen name associated with the facility is displayed along with notification message
    #And the applicaton is closed 
    #
  #Examples:
  #|user|  
  #|ic-test-admin@capgemini.com |
  #|ic-test-nurse@capgemini.com|
#|ic-test-tech@capgemini.com|
#|ic-test-surgeon@capgemini.com |