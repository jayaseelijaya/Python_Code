Feature: SSR1714 - Verifying DUU web app Data Upload Utility web app shall take less than 1 minute to initialize and launch in the browser.

  @login_TC3194
  Scenario Outline: TC3194 - IC Admin_Verify DUU launch in less than one minute.
    Given login to clp as "<user>"
    Then the Application access screen is displayed
    Then click on launch for DUU and verify launch takes less than 1 min
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    #	And Data-Upload Application is closed
    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |

  @login_TC3195
  Scenario Outline: TC3195 - IC Technician_Verify DUU launch in less than one minute.
    Given login to clp as "<user>"
    Then the Application access screen is displayed
    Then click on launch for DUU and verify launch takes less than 1 min
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    #	And Data-Upload Application is closed
    Examples: 
      | user                       |
      | ic-test-tech@capgemini.com |

  @login_TC3196
  Scenario Outline: TC3196 - Hospital_Admin_Verify DUU launch in less than one minute.
    Given login to clp as "<user>"
    Then the Application access screen is displayed
    Then click on launch for DUU and verify launch takes less than 1 min
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    #	And Data-Upload Application is closed
    Examples: 
      | user                                  |
      | ic-test-hospital-admin@capgemini.com  |

  @login_TC3197
  Scenario Outline: TC3197 - Surgeon_Verify DUU launch in less than one minute.
    Given login to clp as "<user>"
    Then the Application access screen is displayed
    Then click on launch for DUU and verify launch takes less than 1 min
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    #	And Data-Upload Application is closed
    Examples: 
      | user                          |
      | ic-test-surgeon@capgemini.com |

  @login_TC3198
  Scenario Outline: TC3198 - Support-staff_Verify DUU launch in less than one minute.
    Given login to clp as "<user>"
    Then the Application access screen is displayed
    Then click on launch for DUU and verify launch takes less than 1 min
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    #	And Data-Upload Application is closed
    Examples: 
      | user                               |
      | ic-test-supportstaff@capgemini.com |

  @login_TC5110
  Scenario Outline: TC5110 - S&N HIL Manager_ Verify DUU launches within 1 min
    Given login to clp as "<user>"
    Then the Application access screen is displayed
    Then click on launch for DUU and verify launch takes less than 1 min
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    #	And Data-Upload Application is closed
    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |
