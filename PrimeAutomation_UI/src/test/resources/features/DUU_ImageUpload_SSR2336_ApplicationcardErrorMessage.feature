Feature: SSR2336 - Verifying that DUU web app shall display error message if no Applications are available for selected surgeon.

  @ImageUpload_TC3291
  Scenario Outline: TC3291 - IC Admin_Verify DUU shall show validation message when no linked application data available
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Upload dashboad page is displayed to user
    #Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    #Step 4
    When the user enters the site name into the search field and selects a site
    Then click on the next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    Then user clicks on surgeon which deosn't have application card associate
    #Step 5
    Then the error message "<errormsg>" is displayed
    #Step 6
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 7
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                        | errormsg                                                                   |
      | ic-test-admin@capgemini.com | No Application available. Please request administrator to add application. |

  @ImageUpload_TC3297
  Scenario Outline: TC3297 - IC Technician_Verify DUU shall show validation message when no linked application data available
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Upload dashboad page is displayed to user
    #Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    #Step 4
    When the user enters the site name into the search field and selects a site
    Then click on the next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    Then user clicks on surgeon which deosn't have application card associate
    #Step 5
    Then the error message "<errormsg>" is displayed
    #Step 6
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 7
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                        | errormsg                                                                  |
      | ic-test-tech@capgemini.com | No Application available. Please request administrator to add application. |

  @ImageUpload_TC3299
  Scenario Outline: TC3299 - Hospital Admin_Verify DUU shall show validation message when no linked application data available
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Upload dashboad page is displayed to user
    #Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    #Step 4
    When the user selects a site and click on next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    Then user clicks on surgeon which deosn't have application card associate
    #Step 5
    Then the error message "<errormsg>" is displayed
    #Step 6
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 7
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                                 | errormsg                                                                   |
      | ic-test-hospital-admin@capgemini.com | No Application available. Please request administrator to add application. |

  @ImageUpload_TC3300
  Scenario Outline: TC3300 - Support Staff_Verify DUU shall show validation message when no linked application data available
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Upload dashboad page is displayed to user
    #Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    #Step 4
    When the user selects a site and click on next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    Then user clicks on surgeon which deosn't have application card associate
    #Step 5
    Then the error message "<errormsg>" is displayed
    #Step 6
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 7
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                               | errormsg                                                                   |
      | ic-test-supportstaff@capgemini.com | No Application available. Please request administrator to add application. |

  @ImageUpload_TC3301
  Scenario Outline: TC3301 - Surgeon_Verify DUU shall show validation message when no linked application data available
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Upload dashboad page is displayed to user
    #Step 2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #Step 3
    When Clicks on Upload Button
    Then the Site selection screen is displayed with
      | Components                                      |
      | Where are you working today                     |
      | Search box is displayed with header Search Site |
      | Enter Keyword or Name of Site                   |
      | list of linked sites                            |
      | Back and Next buttons                           |
      | I dont see my Site listed                       |
    #Step 4
    When the user selects a site and click on next button
    And the Surgeon selection screen is displayed with
      | Components                                         |
      | Which surgeon are you supporting                   |
      | Search box is displayed with header Search Surgeon |
      | Enter First or Last Name of Surgeon                |
      | list of linked surgeons                            |
      | close icon                                         |
      | Back and Next buttons                              |
      | I dont see my Surgeon listed                       |
    Then user clicks on surgeon which deosn't have application card associate
    #Step 5
    Then the error message "<errormsg>" is displayed
    #Step 6
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 7
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                          | errormsg                                                                   |
      | ic-test-surgeon@capgemini.com | No Application available. Please request administrator to add application. |
