
Feature: Verify login page scenarios
@CLP_Login
  Scenario Outline: Launching Data Upload Utility Application in Chrome
    
    Given Chrome Browser is opened
    And CLP app url is entered 
    Then the CLP screen shall be displayed
    When the user clicks on go to login button
    Then the CLP Signin page shall be displayed
    And Email-Address is entered as "<user>"
    And Password is entered by the user 
    Then the Login button is clicked
    When the user enters otp
    Then the signin button is clicked
    And the application product page shall be displayed
    When the user clicks data upload launch button
    And Homepage is displayed to the user
    When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Then user is logout from the application.
		
    
    Examples:
   |user|  
|	ic-test-admin@capgemini.com |


	Scenario Outline: Loging out of Data Upload Utility
		Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.