Feature: SSR3471 - The system shall provide interface for user to check software Information with software version numbers

  @login_SSR3471
  Scenario Outline: TC0903 - IC Admin_Verify DUU app shall view login information on landing page
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Given a valid file is uploaded
    Then Homepage is displayed to the user
    ##Step 2
    And the heading Smith and Nephew shall be displayed at the top left side in orange color
    ##Step 3
    And user verifies name of the logged-in user on left menu bar
    And user verifies role of the user logged-in
    ##Step 4
    And user verifies profile picture of the logged-in user on left menu bar
    ##Step 5
    And the welcome message shall be displayed
    ##Step 6
    And user verifies name of the logged-in user on left menu bar
    ##Step 7
    And user verifies role of the user logged-in
    ##Step 8
    Then the following information shall be displayed at left navigation bar
      | infomation     |
      | File dashboard |
      | Upload files   |
      | Upload status  |
      | History        |
      | Audit log      |
      | imaging links  |
      | settings       |
      | Help           |
      | Info           |
      | Logout         |
      | Exit to app    |
    ##Step 9
    And Upload dashboad page is displayed to user
    And the following components shall be displayed on right side of upload dashboard
      | dashboard                  |
      | dashboard heading          |
      | uploaded records table     |
      | processing status checkbox |
      | uploaded status checkbox   |
      | complete status checkbox   |
      | error status checkbox      |
      | 24hrs checkbox             |
      | filter                     |
      | search box                 |
      | search button              |
    #Step 10
    When User clicks on Upload Files from left panel
    Then the following components shall be displayed on right side of upload files
      | upload               |
      | upload files heading |
      | upload icon          |
      | upload button        |
    #Step 11
    When the user clicks on upload status button from left menu bar
    Then the following components shall be displayed on right side of upload status
      | status                 |
      | upload status heading  |
      | uploaded records table |
      | view details buttom    |
    #Step 12
    When the user clicks on history button from left menu bar
    ######For the show more button to be displayed, make sure that more than 25 records are displayed in the history screen
    Then the following components shall be displayed on right side of history
      | history             |
      | history heading     |
      | 24hrs checkbox      |
      | filter              |
      | search textbox      |
      | search button       |
      | record table        |
      | view details button |
      | show more           |
    ##Step 13
    When the user clicks on audit log button from left menu bar
    Then the following components shall be displayed on right side of audit log
      | audit                |
      | audit log heading    |
      | 24hrs checkbox       |
      | filter               |
      | search textbox       |
      | search button        |
      | audit log list table |
      | exported selected    |
      | exported all         |
      | show more            |
    ##Step 14
    When the user clicks on imaging links button from left menu bar
    Then the following components shall be displayed on right side of imaging links
      | imaging                   |
      | Provider Links            |
      | search textbox            |
      | search button             |
      | Provider details          |
      | list of linked facilities |
      | remove button             |
    ##Step 15
    Then the list of linked facilities and Remove button is displayed
    #Step 16
    When the user clicks on settings button from left menu bar
    Then the following components shall be displayed on right side of settings
      | settings                     |
      | successful expiration        |
      | unsuccessful expiration      |
      | global viewing toggle button |
      | reset to default             |
      | save button                  |
    ##Step 17
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    ##Step 18
    When the user clicks on software information icon from left menu bar
    Then the software information popup shall be displayed
    And the software version details shall be displayed
    And the cross button shall be displayed
    When the user click on cross button
    ##Step 19
    And the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    #And Data-Upload Application is closed
    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |

  @login_SSR3471
  Scenario Outline: TC1256 - Surgeon_Verify Surgeon view and login information on landing page
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Given a valid file is uploaded
    Then Homepage is displayed to the user
    ##Step 2
    And the heading Smith and Nephew shall be displayed at the top left side in orange color
    ##Step 3
    And user verifies name of the logged-in user on left menu bar
    And user verifies role of the user logged-in
    ##Step 4
    And user verifies profile picture of the logged-in user on left menu bar
    ##Step 5
    And the welcome message shall be displayed
    ##Step 6
    And user verifies name of the logged-in user on left menu bar
    ##Step 7
    And user verifies role of the user logged-in
    #Step 8
    Then the following information shall be displayed at left navigation bar
      | infomation     |
      | File dashboard |
      | Upload files   |
      | Upload status  |
      | History        |
      | Help           |
      | Info           |
      | Logout         |
      | Exit to app    |
    ##Step 9
    Then the following information should not be displayed at left navigation bar
      | infomation    |
      | Audit log     |
      | Settings      |
      | Imaging Links |
    ##Step 10
    And Upload dashboad page is displayed to user
    And the following components shall be displayed on right side of upload dashboard
      | dashboard                  |
      | dashboard heading          |
      | uploaded records table     |
      | processing status checkbox |
      | uploaded status checkbox   |
      | complete status checkbox   |
      | error status checkbox      |
      | 24hrs checkbox             |
      | filter                     |
      | search box                 |
      | search button              |
    ##Step 11
    When User clicks on Upload Files from left panel
    Then the following components shall be displayed on right side of upload files
      | upload               |
      | upload files heading |
      | upload icon          |
      | upload button        |
    ##Step 12
    When the user clicks on upload status button from left menu bar
    Then the following components shall be displayed on right side of upload status
      | status                 |
      | upload status heading  |
      | uploaded records table |
      | view details buttom    |
    ##Step 13
    When the user clicks on history button from left menu bar
    Then the following components shall be displayed on right side of history
      | history             |
      | history heading     |
      | 24hrs checkbox      |
      | filter              |
      | search textbox      |
      | search button       |
      | record table        |
      | view details button |
      | show more           |
    ##Step 14
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    ##Step 15
    When the user clicks on software information icon from left menu bar
    Then the software information popup shall be displayed
    And the software version details shall be displayed
    And the cross button shall be displayed
    When the user click on cross button
    ##Step 16
    And the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    #And Data-Upload Application is closed
    Examples: 
      | user                          |
      | ic-test-surgeon@capgemini.com |

  @login_TSSR3471
  Scenario Outline: TC1257 - IC Technician_Verify IC technician view and login information on landing page
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Given a valid file is uploaded
    Then Homepage is displayed to the user
    ##Step 2
    And the heading Smith and Nephew shall be displayed at the top left side in orange color
    ##Step 3
    And user verifies name of the logged-in user on left menu bar
    And user verifies role of the user logged-in
    ##Step 4
    And user verifies profile picture of the logged-in user on left menu bar
    ##Step 5
    And the welcome message shall be displayed
    ##Step 6
    And user verifies name of the logged-in user on left menu bar
    ##Step 7
    And user verifies role of the user logged-in
    #Step 8
    Then the following information shall be displayed at left navigation bar
      | infomation     |
      | File dashboard |
      | Upload files   |
      | Upload status  |
      | History        |
      | Help           |
      | Info           |
      | Logout         |
      | Exit to app    |
    ##Step 9
    Then the following information should not be displayed at left navigation bar
      | infomation    |
      | Audit log     |
      | Settings      |
      | Imaging Links |
    ##Step 10
    And Upload dashboad page is displayed to user
    And the following components shall be displayed on right side of upload dashboard
      | dashboard                  |
      | dashboard heading          |
      | uploaded records table     |
      | processing status checkbox |
      | uploaded status checkbox   |
      | complete status checkbox   |
      | error status checkbox      |
      | 24hrs checkbox             |
      | filter                     |
      | search box                 |
      | search button              |
    ##Step 11
    When User clicks on Upload Files from left panel
    Then the following components shall be displayed on right side of upload files
      | upload               |
      | upload files heading |
      | upload icon          |
      | upload button        |
    ##Step 12
    When the user clicks on upload status button from left menu bar
    Then the following components shall be displayed on right side of upload status
      | status                 |
      | upload status heading  |
      | uploaded records table |
      | view details buttom    |
    ##Step 13
    When the user clicks on history button from left menu bar
    Then the following components shall be displayed on right side of history
      | history             |
      | history heading     |
      | 24hrs checkbox      |
      | filter              |
      | search textbox      |
      | search button       |
      | record table        |
      | view details button |
      | show more           |
    ##Step 14
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    ##Step 15
    When the user clicks on software information icon from left menu bar
    Then the software information popup shall be displayed
    And the software version details shall be displayed
    And the cross button shall be displayed
    When the user click on cross button
    ##Step 16
    And the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    #And Data-Upload Application is closed
    Examples: 
      | user                       |
      | ic-test-tech@capgemini.com |

  @login_SSR3471
  Scenario Outline: TC1258 - Support Staff_Verify DUU app shall view login information on landing page.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Given a valid file is uploaded
    Then Homepage is displayed to the user
    ##Step 2
    And the heading Smith and Nephew shall be displayed at the top left side in orange color
    ##Step 3
    And user verifies name of the logged-in user on left menu bar
    And user verifies role of the user logged-in
    ##Step 4
    And user verifies profile picture of the logged-in user on left menu bar
    ##Step 5
    And the welcome message shall be displayed
    ##Step 6
    And user verifies name of the logged-in user on left menu bar
    ##Step 7
    And user verifies role of the user logged-in
    #Step 8
    Then the following information shall be displayed at left navigation bar
      | infomation     |
      | File dashboard |
      | Upload files   |
      | Upload status  |
      | History        |
      | Help           |
      | Info           |
      | Logout         |
      | Exit to app    |
    ##Step 9
    Then the following information should not be displayed at left navigation bar
      | infomation    |
      | Audit log     |
      | Settings      |
      | Imaging Links |
    ##Step 10
    And Upload dashboad page is displayed to user
    And the following components shall be displayed on right side of upload dashboard
      | dashboard                  |
      | dashboard heading          |
      | uploaded records table     |
      | processing status checkbox |
      | uploaded status checkbox   |
      | complete status checkbox   |
      | error status checkbox      |
      | 24hrs checkbox             |
      | filter                     |
      | search box                 |
      | search button              |
    ##Step 11
    When User clicks on Upload Files from left panel
    Then the following components shall be displayed on right side of upload files
      | upload               |
      | upload files heading |
      | upload icon          |
      | upload button        |
    ##Step 12
    When the user clicks on upload status button from left menu bar
    Then the following components shall be displayed on right side of upload status
      | status                 |
      | upload status heading  |
      | uploaded records table |
      | view details buttom    |
    ##Step 13
    When the user clicks on history button from left menu bar
    Then the following components shall be displayed on right side of history
      | history             |
      | history heading     |
      | 24hrs checkbox      |
      | filter              |
      | search textbox      |
      | search button       |
      | record table        |
      | view details button |
      | show more           |
    ##Step 14
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    ##Step 15
    When the user clicks on software information icon from left menu bar
    Then the software information popup shall be displayed
    And the software version details shall be displayed
    And the cross button shall be displayed
    When the user click on cross button
    ##Step 16
    And the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    #And Data-Upload Application is closed
    Examples: 
      | user                               |
      | ic-test-supportstaff@capgemini.com |

  @login_SSR3471
  Scenario Outline: TC1259 - Hospital Admin_Verify DUU app shall view login information on landing page.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Given a valid file is uploaded
    Then Homepage is displayed to the user
    ##Step 2
    And the heading Smith and Nephew shall be displayed at the top left side in orange color
    ##Step 3
    And user verifies name of the logged-in user on left menu bar
    And user verifies role of the user logged-in
    ##Step 4
    And user verifies profile picture of the logged-in user on left menu bar
    ##Step 5
    And the welcome message shall be displayed
    ##Step 6
    And user verifies name of the logged-in user on left menu bar
    ##Step 7
    And user verifies role of the user logged-in
    ##Step 8
    Then the following information shall be displayed at left navigation bar
      | infomation     |
      | File dashboard |
      | Upload files   |
      | Upload status  |
      | History        |
      | Audit log      |
      | imaging links  |
      | settings       |
      | Help           |
      | Info           |
      | Logout         |
      | Exit to app    |
    ##Step 9
    And Upload dashboad page is displayed to user
    And the following components shall be displayed on right side of upload dashboard
      | dashboard                  |
      | dashboard heading          |
      | uploaded records table     |
      | processing status checkbox |
      | uploaded status checkbox   |
      | complete status checkbox   |
      | error status checkbox      |
      | 24hrs checkbox             |
      | filter                     |
      | search box                 |
      | search button              |
    ##Step 10
    When User clicks on Upload Files from left panel
    Then the following components shall be displayed on right side of upload files
      | upload               |
      | upload files heading |
      | upload icon          |
      | upload button        |
    ##Step 11
    When the user clicks on upload status button from left menu bar
    Then the following components shall be displayed on right side of upload status
      | status                 |
      | upload status heading  |
      | uploaded records table |
      | view details buttom    |
    ##Step 12
    When the user clicks on history button from left menu bar
    Then the following components shall be displayed on right side of history
      | history             |
      | history heading     |
      | 24hrs checkbox      |
      | filter              |
      | search textbox      |
      | search button       |
      | record table        |
      | view details button |
      | show more           |
    ##Step 13
    When the user clicks on audit log button from left menu bar
    Then the following components shall be displayed on right side of audit log
      | audit                |
      | audit log heading    |
      | 24hrs checkbox       |
      | filter               |
      | search textbox       |
      | search button        |
      | audit log list table |
      | exported selected    |
      | exported all         |
      | show more            |
    ##Step 14
    When the user clicks on imaging links button from left menu bar
    Then the following components shall be displayed on right side of imaging links
      | imaging                                 |
      | Imaging links                           |
      | Pin linked centers to top toggle button |
      | search textbox                          |
      | search button                           |
      | Provider details                        |
      | list of linked facilities               |
      | remove button                           |
      | create button                           |
    ##Step 15
    Then the list of linked facilities and Remove Link and Create Link is displayed
    ##Step 16
    When the user clicks on settings button from left menu bar
    Then the following components shall be displayed on right side of settings
      | settings                     |
      | successful expiration        |
      | unsuccessful expiration      |
      | global viewing toggle button |
      | reset to default             |
      | save button                  |
    ##Step 17
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    ##Step 18
    When the user clicks on software information icon from left menu bar
    Then the software information popup shall be displayed
    And the software version details shall be displayed
    And the cross button shall be displayed
    When the user click on cross button
    ##Step 19
    And the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    #And Data-Upload Application is closed
    Examples: 
      | user                                 |
      | ic-test-hospital-admin@capgemini.com |

  @login_SSR3471
  Scenario Outline: TC1260 - S&N HIL Manager_Verify DUU app shall view login information on landing page.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Choose Site screen is displayed
    ##Step 2
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    Then Upload dashboad page is displayed to user
    And the following components shall be displayed on right side of upload dashboard
      | dashboard                  |
      | dashboard heading          |
      | uploaded records table     |
      | processing status checkbox |
      | uploaded status checkbox   |
      | complete status checkbox   |
      | error status checkbox      |
      | 24hrs checkbox             |
      | filter                     |
      | search box                 |
      | search button              |
    ##Step 3
    And the heading Smith and Nephew shall be displayed at the top left side in orange color
    ##Step 4
    And user verifies name of the logged-in user on left menu bar
    And user verifies role of the user logged-in
    ##Step 5
    And user verifies profile picture of the logged-in user on left menu bar
    ##Step 6
    And the welcome message shall be displayed
    ##Step 7
    And user verifies name of the logged-in user on left menu bar
    ##Step 8
    And user verifies role of the user logged-in
    ##Step 9
    Then the following information shall be displayed at left navigation bar
      | infomation     |
      | File dashboard |
      | Choose Site    |
      | History        |
      | Audit log      |
      | imaging links  |
      | Help           |
      | Info           |
      | Logout         |
      | Exit to app    |
    ##Step 10
    Then the following information should not be displayed at left navigation bar
      | infomation    |
      | Upload status |
      | Upload files  |
      | Settings      |
    ##Step 11
    When the user clicks on history button from left menu bar
    Then the following components shall be displayed on right side of history
      | history             |
      | history heading     |
      | 24hrs checkbox      |
      | filter              |
      | search textbox      |
      | search button       |
      | record table        |
      | view details button |
      | show more           |
    ##Step 12
    When the user clicks on audit log button from left menu bar
    Then the following components shall be displayed on right side of audit log
      | audit                |
      | audit log heading    |
      | 24hrs checkbox       |
      | filter               |
      | search textbox       |
      | search button        |
      | audit log list table |
      | exported selected    |
      | exported all         |
      | show more            |
    ##Step 13
    When the user clicks on imaging links button from left menu bar
    Then the following components shall be displayed on imaging links screen
      | imaging                                      |
      | Create or Modify links                       |
      | Two tables for Providers and Imaging centers |
      | Provider table                               |
      | All Organization heading                     |
      | search textbox                               |
      | search button                                |
      | List registered organizations                |
      | Provider details of the 1st provider         |
      | Activate Site                                |
      | Deactivate Site                              |
      | Imaging center table                         |
      | Pin linked centers to top toggle button      |
      | search textbox                               |
      | search button                                |
      | List of linked and unlinked facilities       |
      | facility details of 1st record               |
      | remove button                                |
      | create button                                |
      ##Step 14
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    ##Step 15
    When the user clicks on software information icon from left menu bar
    Then the software information popup shall be displayed
    And the software version details shall be displayed
    And the cross button shall be displayed
    When the user click on cross button
    ##Step 16
    And the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    #And Data-Upload Application is closed

    Examples: 
      | user                               |
      | ic-test-snn-hil-manager@capgemini.com |
