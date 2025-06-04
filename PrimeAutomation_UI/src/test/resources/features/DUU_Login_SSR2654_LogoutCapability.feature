Feature: SSR2654 - The system shall provide a logout capability for user-initiated communications sessions whenever authentication is used to gain access

  @login_SSR2654
  Scenario: TC0844 - IC Admin_ Verify the DUU web app main landing page status ribbon provides a control to logout from the application
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    Then the Logout icon is displayed at the bottom navigation bar in the left menu panel
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @login_SSR2654
  Scenario: TC3124 - IC Technician_ Verify the DUU web app main landing page status ribbon provides a control to logout from the application
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    Then the Logout icon is displayed at the bottom navigation bar in the left menu panel
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @login_SSR2654
  Scenario: TC3125 - Hospital Admin_ Verify the DUU web app main landing page status ribbon provides a control to logout from the application
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    Then the Logout icon is displayed at the bottom navigation bar in the left menu panel
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @login_SSR2654
  Scenario: TC3126 - Surgeon_ Verify the DUU web app main landing page status ribbon provides a control to logout from the application
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    Then the Logout icon is displayed at the bottom navigation bar in the left menu panel
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @login_SSR2654
  Scenario: TC3127 - Support Staff_Verify the DUU web app main landing page status ribbon provides a control to logout from the application
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    Then the Logout icon is displayed at the bottom navigation bar in the left menu panel
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @login_SSR2654
  Scenario: TC5108 - S&N HIL Manager_Verify the DUU web app main landing page status ribbon provides a control to logout from the application
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-snn-hil-manager@capgemini.com"
    Then Choose Site screen is displayed
    Then the Logout icon is displayed at the bottom navigation bar in the left menu panel
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed
