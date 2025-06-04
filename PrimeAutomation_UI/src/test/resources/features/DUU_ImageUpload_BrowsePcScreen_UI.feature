
Feature: Verifying Browse PC screen UI.

Scenario Outline: TC0704 -  Verify the usability of browse PC screen

    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    When User clicks on Upload Files from left panel
    And Clicks on Upload Button
    Then Search facility screen is displayed to user along with back and next button
    When the user selects a facility from the list
    And the user clicks on Next Button
    Then the surgeon selection screen shall be displayed
    When the user selects a surgeon from the list
    And the user clicks on Next Button
    Then the application card selection screen shall be displayed
    When the user selctes a application card from the list
    And the user clicks on Next Button
    Then the browse pc screen shall be displayed
    And the top center header Facility Surgeon Application shall be displayed
    And the below components shall be displayed on browse pc screen
      | screen	                             |
      | select files to upload or drop below |
      | Back button                          |
      | Browse PC button                     |
      | Drag and Drop Here                   |
      | Dotted line box                      |
      | Upload Icon                          |
      | Browse PC button highlighted         |
    And Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
		#|ic-test-tech@capgemini.com |
		#|ic-test-nurse@capgemini.com |
		#|ic-test-surgeon@capgemini.com |
