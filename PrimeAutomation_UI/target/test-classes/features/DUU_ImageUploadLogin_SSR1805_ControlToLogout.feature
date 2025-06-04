Feature: SSR1805 - Data Upload Utility web application main landing page status ribbon shall provide a control to logout from the application

  @login_TC0844
  Scenario: TC0844 - IC Admin_ Verify the DUU web app main landing page status ribbon provides a control to logout from the application
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    Then the Logout icon is displayed at the bottom navigation bar in the left menu panel
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @login_TC3124
  Scenario: TC3124 - IC Technician_ Verify the DUU web app main landing page status ribbon provides a control to logout from the application
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-user@capgemini.com"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    Then the Logout icon is displayed at the bottom navigation bar in the left menu panel
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @login_TC3125
  Scenario: TC3125 - Hospital Admin_ Verify the DUU web app main landing page status ribbon provides a control to logout from the application
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-hospital-admin@capgemini.com"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    Then the Logout icon is displayed at the bottom navigation bar in the left menu panel
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @login_TC3126
  Scenario: TC3126 - Surgeon_ Verify the DUU web app main landing page status ribbon provides a control to logout from the application
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-surgeon@capgemini.com"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    Then the Logout icon is displayed at the bottom navigation bar in the left menu panel
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @login_TC3127
  Scenario: TC3127 - Support Staff_Verify the DUU web app main landing page status ribbon provides a control to logout from the application
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-staff@capgemini.com"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    Then the Logout icon is displayed at the bottom navigation bar in the left menu panel
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  @login_TC5108
  Scenario: TC5108 - S&N HIL Manager_Verify the DUU web app main landing page status ribbon provides a control to logout from the application
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-snn-hil-manager@capgemini.com"
    Then Choose Site screen is displayed
    Then the Logout icon is displayed at the bottom navigation bar in the left menu panel
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

  ######################################################
  ##The below test case is removed. Keeping for reference
  #######################################################
  
  #@login_TC1160
  #Scenario: TC1160 - IC admin_ Verify the usability of menus in left menu panel
    #Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    #Then Homepage is displayed to the user
    #And the dashboard summary shall display list of upload items
    #Then the user can only see the left menu components as per access
      #| menuitems      |
      #| File Dashboard |
      #| Upload Files   |
      #| Upload status  |
      #| History        |
      #| Audit log      |
      #| Imaging links  |
      #| Settings       |
      #| Help           |
      #| Info           |
    #Then the File Dashbord is in green color and other menus in the left menu panel is displayed in white color
    #When the user clicks on File Dashboard in the left menu panel
    #Then the File Dashboard menu in the left menu panel is highlighted in green color
    #Then the following are displayed above File Dashboard menu in the left menu panel
      #| options                  |
      #| IC admin profile picture |
      #| IC admin user name       |
      #| IC-admin                 |
    #Then the logout button is displayed in white colour at the bottom navigation in the left menu panel
    #When the user click on Exit Apps at the bottom of the left menu panel
    #Then the Application access screen is displayed
    #When user clicks on Logout icon from left panel
    #Then user is logout from the application.
    #And Data-Upload Application is closed
