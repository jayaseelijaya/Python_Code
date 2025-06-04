Feature: SSR2337 - Data Upload Utility web application main landing page status ribbon shall provide a control to navigate back to the Common Login Portal
  applications view

  @login_TC0843
  Scenario: TC0843 - IC Admin_Verify Main landing page status ribbon provides a control to navigate back to the applications view
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    Then the Exit to Apps is displayed at bottom of the left menu panel
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @login_TC3445
  Scenario: TC3445 - IC Technician_Verify Main landing page status ribbon provides a control to navigate back to the applications view
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    Then the Exit to Apps is displayed at bottom of the left menu panel
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @login_TC3446
  Scenario: TC3446 - S&N HIL Manager_Verify Main landing page status ribbon provides a control to navigate back to the applications view
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-snn-hil-manager@capgemini.com"
    And Choose Site screen is displayed
    Then Choose Site menu in the left menu panel is highlighted
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    And the dashboard summary shall display list of upload items
    Then the Exit to Apps is displayed at bottom of the left menu panel
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @login_TC3447
  Scenario: TC3447 - Hospital Admin_Verify Main landing page status ribbon provides a control to navigate back to the applications view
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    Then the Exit to Apps is displayed at bottom of the left menu panel
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @login_TC3448
  Scenario: TC3448 - Support Staff_Verify Main landing page status ribbon provides a control to navigate back to the applications view
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    Then the Exit to Apps is displayed at bottom of the left menu panel
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @login_TC3449
  Scenario: TC3449 - Surgeon_Verify Main landing page status ribbon provides a control to navigate back to the applications view
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    Then the Exit to Apps is displayed at bottom of the left menu panel
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed
