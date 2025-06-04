Feature: SSR1802 - Verifying Data Upload Utility web app workflow shall provide a list of surgeons at the correct organization for the user to make a surgeon selection.

  @ImageUpload_TC7960
  Scenario Outline: TC7960 - Hospital Admin_Verify Search functionality for Surgeon list
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
    Then List of Surgeon is displayed
    #Step 5
    When The user enters the first name of the surgeon in uppercase into the search box
    Then the list will be displayed for entering text
    #step 6
    When The user enters the first name of the surgeon in upper and lower case into the search box
    Then the list will be displayed for entering text
    #Step 7
    When The user enters the first name of the surgeon in lowercase into the search box
    Then the list will be displayed for entering text
    #Step 8
    When The user enters the last name of the surgeon in uppercase into the search box
    Then the list will be displayed for entering text
    #Step 9
    When The user enters the last name of the surgeon in upper and lower case into the search box
    Then the list will be displayed for entering text
    #Step 10
    When The user enters the last name of the surgeon in lowercase into the search box
    Then the list will be displayed for entering text
    #Step 11
    When The user enters the full name of the surgeon in uppercase into the search box
    Then the list will be displayed for entering text
    #Step 12
    When The user enters the full name of the surgeon in  upper and lower case into the search box
    Then the list will be displayed for entering text
    #Step 13
    When The user enters the full name of the surgeon in lower case into the search box
    Then the list will be displayed for entering text
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                                 |
      | ic-test-hospital-admin@capgemini.com |

  @ImageUpload_TC7961
  Scenario Outline: TC7961 - IC Technician_Verify Search functionality for Surgeon list
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
    Then List of Surgeon is displayed
    #Step 5
    When The user enters the first name of the surgeon in uppercase into the search box
    Then the list will be displayed for entering text
    #step 6
    When The user enters the first name of the surgeon in upper and lower case into the search box
    Then the list will be displayed for entering text
    #Step 7
    When The user enters the first name of the surgeon in lowercase into the search box
    Then the list will be displayed for entering text
    #Step 8
    When The user enters the last name of the surgeon in uppercase into the search box
    Then the list will be displayed for entering text
    #Step 9
    When The user enters the last name of the surgeon in upper and lower case into the search box
    Then the list will be displayed for entering text
    #Step 10
    When The user enters the last name of the surgeon in lowercase into the search box
    Then the list will be displayed for entering text
    #Step 11
    When The user enters the full name of the surgeon in uppercase into the search box
    Then the list will be displayed for entering text
    #Step 12
    When The user enters the full name of the surgeon in  upper and lower case into the search box
    Then the list will be displayed for entering text
    #Step 13
    When The user enters the full name of the surgeon in lower case into the search box
    Then the list will be displayed for entering text
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                       |
      | ic-test-tech@capgemini.com |

  @ImageUpload_TC7962
  Scenario Outline: TC7962 - Support Staff_Verify Search functionality for Surgeon list
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
    Then List of Surgeon is displayed
    #Step 5
    When The user enters the first name of the surgeon in uppercase into the search box
    Then the list will be displayed for entering text
    #step 6
    When The user enters the first name of the surgeon in upper and lower case into the search box
    Then the list will be displayed for entering text
    #Step 7
    When The user enters the first name of the surgeon in lowercase into the search box
    Then the list will be displayed for entering text
    #Step 8
    When The user enters the last name of the surgeon in uppercase into the search box
    Then the list will be displayed for entering text
    #Step 9
    When The user enters the last name of the surgeon in upper and lower case into the search box
    Then the list will be displayed for entering text
    #Step 10
    When The user enters the last name of the surgeon in lowercase into the search box
    Then the list will be displayed for entering text
    #Step 11
    When The user enters the full name of the surgeon in uppercase into the search box
    Then the list will be displayed for entering text
    #Step 12
    When The user enters the full name of the surgeon in  upper and lower case into the search box
    Then the list will be displayed for entering text
    #Step 13
    When The user enters the full name of the surgeon in lower case into the search box
    Then the list will be displayed for entering text
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                               |
      | ic-test-supportstaff@capgemini.com |

  @ImageUpload_TC7963
  Scenario Outline: TC7963 - Surgeon_Verify Search functionality for Surgeon list
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
    Then List of Surgeon is displayed
    #Step 5
    When The user enters the first name of the surgeon in uppercase into the search box
    Then the list will be displayed for entering text
    #step 6
    When The user enters the first name of the surgeon in upper and lower case into the search box
    Then the list will be displayed for entering text
    #Step 7
    When The user enters the first name of the surgeon in lowercase into the search box
    Then the list will be displayed for entering text
    #Step 8
    When The user enters the last name of the surgeon in uppercase into the search box
    Then the list will be displayed for entering text
    #Step 9
    When The user enters the last name of the surgeon in upper and lower case into the search box
    Then the list will be displayed for entering text
    #Step 10
    When The user enters the last name of the surgeon in lowercase into the search box
    Then the list will be displayed for entering text
    #Step 11
    When The user enters the full name of the surgeon in uppercase into the search box
    Then the list will be displayed for entering text
    #Step 12
    When The user enters the full name of the surgeon in  upper and lower case into the search box
    Then the list will be displayed for entering text
    #Step 13
    When The user enters the full name of the surgeon in lower case into the search box
    Then the list will be displayed for entering text
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                          |
      | ic-test-surgeon@capgemini.com |

  @ImageUpload_TC3334
  Scenario Outline: TC3334 - IC Admin_Verify Search functionality for Surgeon list
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
    Then List of Surgeon is displayed
    #Step 5
    When The user enters the first name of the surgeon in uppercase into the search box
    Then the list will be displayed for entering text
    #step 6
    When The user enters the first name of the surgeon in upper and lower case into the search box
    Then the list will be displayed for entering text
    #Step 7
    When The user enters the first name of the surgeon in lowercase into the search box
    Then the list will be displayed for entering text
    #Step 8
    When The user enters the last name of the surgeon in uppercase into the search box
    Then the list will be displayed for entering text
    #Step 9
    When The user enters the last name of the surgeon in upper and lower case into the search box
    Then the list will be displayed for entering text
    #Step 10
    When The user enters the last name of the surgeon in lowercase into the search box
    Then the list will be displayed for entering text
    #Step 11
    When The user enters the full name of the surgeon in uppercase into the search box
    Then the list will be displayed for entering text
    #Step 12
    When The user enters the full name of the surgeon in  upper and lower case into the search box
    Then the list will be displayed for entering text
    #Step 13
    When The user enters the full name of the surgeon in lower case into the search box
    Then the list will be displayed for entering text
    #Step 14
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 15
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |

  @ImageUpload_TC7911
  Scenario Outline: TC7911 - IC Admin_Verify search of surgeon selection screen with invalid data
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
    Then List of Surgeon is displayed
    And the surgeon search box is displayed
    #Step 5
    When The user enters the invalid "xyz" surgeon name in search box
    Then the blankscreen displays with no search results
    #step 6
    When The user enters the surgeon name with special characters "Jaya surgeon$%$^^$" in search box
    Then the blankscreen displays with no search results
    #Step 7
    When The user enters the valid surgeon name with numbers and special characters "new surgeon1234#$#%" in search box
    Then the blankscreen displays with no search results
    #Step 8
    When The user enters spaces in search box
    Then the blankscreen displays with no search results
    #Step 9
    When The user clear the spaces from the search bar
    Then List of Surgeon is displayed
    #Step 10
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 11
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |

  @ImageUpload_TC7912
  Scenario Outline: TC7912 - Hospital Admin_Verify search of surgeon selection screen with invalid data
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
    Then List of Surgeon is displayed
    And the surgeon search box is displayed
    #Step 5
    When The user enters the invalid "xyz" surgeon name in search box
    Then the blankscreen displays with no search results
    #step 6
    When The user enters the surgeon name with special characters "Jaya surgeon$%$^^$" in search box
    Then the blankscreen displays with no search results
    #Step 7
    When The user enters the valid surgeon name with numbers and special characters "new surgeon1234#$#%" in search box
    Then the blankscreen displays with no search results
    #Step 8
    When The user enters spaces in search box
    Then the blankscreen displays with no search results
    #Step 9
    When The user clear the spaces from the search bar
    Then List of Surgeon is displayed
    #Step 10
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 11
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                                 |
      | ic-test-hospital-admin@capgemini.com |

  @ImageUpload_TC7913
  Scenario Outline: TC7913 - IC Technician_Verify search of surgeon selection screen with invalid data
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
    Then List of Surgeon is displayed
    And the surgeon search box is displayed
    #Step 5
    When The user enters the invalid "xyz" surgeon name in search box
    Then the blankscreen displays with no search results
    #step 6
    When The user enters the surgeon name with special characters "Jaya surgeon$%$^^$" in search box
    Then the blankscreen displays with no search results
    #Step 7
    When The user enters the valid surgeon name with numbers and special characters "new surgeon1234#$#%" in search box
    Then the blankscreen displays with no search results
    #Step 8
    When The user enters spaces in search box
    Then the blankscreen displays with no search results
    #Step 9
    When The user clear the spaces from the search bar
    Then List of Surgeon is displayed
    #Step 10
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 11
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                       |
      | ic-test-tech@capgemini.com |

  @ImageUpload_TC7914
  Scenario Outline: TC7914 - Surgeon_Verify search of surgeon selection screen with invalid data
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
    Then List of Surgeon is displayed
    And the surgeon search box is displayed
    #Step 5
    When The user enters the invalid "xyz" surgeon name in search box
    Then the blankscreen displays with no search results
    #step 6
    When The user enters the surgeon name with special characters "Jaya surgeon$%$^^$" in search box
    Then the blankscreen displays with no search results
    #Step 7
    When The user enters the valid surgeon name with numbers and special characters "new surgeon1234#$#%" in search box
    Then the blankscreen displays with no search results
    #Step 8
    When The user enters spaces in search box
    Then the blankscreen displays with no search results
    #Step 9
    When The user clear the spaces from the search bar
    Then List of Surgeon is displayed
    #Step 10
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 11
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                          |
      | ic-test-surgeon@capgemini.com |

  @ImageUpload_TC7915
  Scenario Outline: TC7915 - Support Satff_Verify search of surgeon selection screen with invalid data
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
    Then List of Surgeon is displayed
    And the surgeon search box is displayed
    #Step 5
    When The user enters the invalid "xyz" surgeon name in search box
    Then the blankscreen displays with no search results
    #step 6
    When The user enters the surgeon name with special characters "Jaya surgeon$%$^^$" in search box
    Then the blankscreen displays with no search results
    #Step 7
    When The user enters the valid surgeon name with numbers and special characters "new surgeon1234#$#%" in search box
    Then the blankscreen displays with no search results
    #Step 8
    When The user enters spaces in search box
    Then the blankscreen displays with no search results
    #Step 9
    When The user clear the spaces from the search bar
    Then List of Surgeon is displayed
    #Step 10
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 11
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                               |
      | ic-test-supportstaff@capgemini.com |
