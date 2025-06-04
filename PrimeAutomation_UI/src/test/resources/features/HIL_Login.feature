
Feature: Verify HIL login page scenarios

	@hil_login
  Scenario Outline: Launching HIL Application in Chrome
    
    Given Chrome Browser is opened
    And HIL app url is entered 
    And the user clicks go to login button
    When email address is entered as "<user>"
    And enter the password
    Then the HIL Login button is clicked
    And the application product page shall be displayed
    When the user clicks HIL launch button
    When the user clicks on Logout button at top right section
    Then the user is logged out successfully and navigated to CLP login screen
    
    Examples:
    |user|  
		|ic-test-snn-hil-manager@capgemini.com|


#	Scenario Outline: Loging out of Data Upload Utility
#		Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    #When the user click on Exit Apps at the bottom of the left menu panel
    #Then the Application access screen is displayed
    #When user clicks on Logout icon from left panel
    #Then user is logout from the application.