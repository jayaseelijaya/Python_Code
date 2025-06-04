Feature: SSR1803 - Verifying UI of surgeon selection screen UI

  @abcd
  Scenario Outline: TC0702 - Verify the UI of surgeon selection modal UI
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    When User clicks on Upload Files from left panel
    And Clicks on Upload Button
    Then Search facility screen is displayed to user along with back and next button
    When User clicks on facility which has surgeon associated
    And user clicks on Next button
    And the surgeon search box shall be displayed
    And the upload files header shall be displayed
    And which surgeon are you supporting text shall be displayed
    And Search surgeon heading shall be displayed
    And the surgeon search box shall be displayed
    And the text of surgeon search box shall be displayed
    #And I don't see my listed site link shall be displayed
    And x button shall be displayed
    And the following information shall be displayed at left navigation bar
      | infomation     |
      | SN logo        |
      | Profile image  |
      | File dashboard |
      | Upload files   |
      | Upload status  |
      | History        |
      | Audit log      |
      | imaging links  |
      | settings       |
      | Exit to app    |
    And Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
		#|ic-test-tech@capgemini.com |
		#|ic-test-nurse@capgemini.com |
		#|ic-test-surgeon@capgemini.com |
