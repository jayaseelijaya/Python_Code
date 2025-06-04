Feature: SSR1800 - Verifying DUU app should have searchable list with organization data to select correct organization from the list.

  @ImageUpload_TC3323
  Scenario Outline: TC3323 - IC Admin_Verify if Organization list updates based on search criteria
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    #And User needs to take the facility name of ic admin
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
    Then the search box shall be displayed
    #Step 5
    When the user enters Uppercase of the valid site name "APO" in search box
    Then the list of site shall be displayed for entered text
    #Step 6
    When User enters valid site with upper and Lower case of "Mg" in search box
    Then the list of site shall be displayed for entered text
    #Step 7
    When User enters valid site with lowercase "mg" in search box
    Then the list of site shall be displayed for entered text
    #Step 8
    When User enters valid full site name "<fullsite>" in search box
    Then the site is matched with the displayed text
    #Step 9
    When User Hover the mouse on the site name
    Then The site name changing into green colour
    #Step 10
    When User removed entered site name "<fullsite>" from the search box
    Then The site screen displayed all site name
    #Step 11
    #When the application has more than six sites in the site selection page
    #Then it is displaying a scroll bar on the right side
    #Step 12
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 13
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                        | fullsite    |
      | ic-test-admin@capgemini.com | MG hospital |

  @ImageUpload_TC7953
  Scenario Outline: TC7953 - IC Technician _Verify if Organization list updates based on search criteria
    #Step 1
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    #And User needs to take the facility name of ic admin
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
    Then the search box shall be displayed
    #Step 5
    When the user enters Uppercase of the valid site name "APO" in search box
    Then the list of site shall be displayed for entered text
    #Step 6
    When User enters valid site with upper and Lower case of "Mg" in search box
    Then the list of site shall be displayed for entered text
    #Step 7
    When User enters valid site with lowercase "mg" in search box
    Then the list of site shall be displayed for entered text
    #Step 8
    When User enters valid full site name "<fullsite>" in search box
    Then the site is matched with the displayed text
    #Step 9
    When User Hover the mouse on the site name
    Then The site name changing into green colour
    #Step 10
    When User removed entered site name "<fullsite>" from the search box
    Then The site screen displayed all site name
    #Step 11
    #When the application has more than six sites in the site selection page
    #Then it is displaying a scroll bar on the right side
    #Step 12
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 13
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                       | fullsite    |
      | ic-test-tech@capgemini.com | MG hospital |

  @ImageUpload_TC7954
  Scenario Outline: TC7954 - Hospital admin _Verify if Organization list updates based on search criteria
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
    Then the search box shall be displayed
    #Step 5
    When the user enters Uppercase of the valid site name "APO" in search box
    Then the list of site shall be displayed for entered text
    #Step 6
    When User enters valid site with upper and Lower case of "Ap" in search box
    Then the list of site shall be displayed for entered text
    #Step 7
    When User enters valid site with lowercase "ap" in search box
    Then the list of site shall be displayed for entered text
    #Step 8
    When User enters valid full site name "<fullsite>" in search box
    Then the site is matched with the displayed text
    #Step 9
    When User Hover the mouse on the site name
    Then The site name changing into green colour
    #Step 10
    When User removed entered site name "<fullsite>" from the search box
    Then The site screen displayed all site name
    #Step 11
    #When the application has more than six sites in the site selection page
    #Then it is displaying a scroll bar on the right side
    #Step 12
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 13
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                                 | fullsite |
      | ic-test-hospital-admin@capgemini.com | apollo   |

  @ImageUpload_TC7955
  Scenario Outline: TC7955 - Surgeon _Verify if Organization list updates based on search criteria
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
    Then the search box shall be displayed
    #Step 5
    When the user enters Uppercase of the valid site name "APO" in search box
    Then the list of site shall be displayed for entered text
    #Step 6
    When User enters valid site with upper and Lower case of "Ap" in search box
    Then the list of site shall be displayed for entered text
    #Step 7
    When User enters valid site with lowercase "ap" in search box
    Then the list of site shall be displayed for entered text
    #Step 8
    When User enters valid full site name "<fullsite>" in search box
    Then the site is matched with the displayed text
    #Step 9
    When User Hover the mouse on the site name
    Then The site name changing into green colour
    #Step 10
    When User removed entered site name "<fullsite>" from the search box
    Then The site screen displayed all site name
    #Step 11
    #When the application has more than six sites in the site selection page
    #Then it is displaying a scroll bar on the right side
    #Step 12
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 13
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                          | fullsite |
      | ic-test-surgeon@capgemini.com | apollo   |

  @ImageUpload_TC7956
  Scenario Outline: TC7956 - Support staff _Verify if Organization list updates based on search criteria
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
    Then the search box shall be displayed
    #Step 5
    When the user enters Uppercase of the valid site name "APO" in search box
    Then the list of site shall be displayed for entered text
    #Step 6
    When User enters valid site with upper and Lower case of "Ap" in search box
    Then the list of site shall be displayed for entered text
    #Step 7
    When User enters valid site with lowercase "ap" in search box
    Then the list of site shall be displayed for entered text
    #Step 8
    When User enters valid full site name "<fullsite>" in search box
    Then the site is matched with the displayed text
    #Step 9
    When User Hover the mouse on the site name
    Then The site name changing into green colour
    #Step 10
    When User removed entered site name "<fullsite>" from the search box
    Then The site screen displayed all site name
    #Step 11
    #When the application has more than six sites in the site selection page
    #Then it is displaying a scroll bar on the right side
    #Step 12
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 13
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                               | fullsite |
      | ic-test-supportstaff@capgemini.com | apollo   |

  @ImageUpload_TC7906
  Scenario Outline: TC7906 - IC Admin_Verify search of site selection screen with invalid data
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
    And the list of sites are displayed
    Then the search box shall be displayed
    #Step 5
    When the user enters invalid site name "xyz" in search box
    Then the Blank screen is displayed with no search results
    #Step 6
    When User removed entered site name "xyz" from the search box
    Then entered special character "$&%$^%^" in search bar
    And the Blank screen is displayed with no search results
    #Step 7
    When User removed entered site name "$&%$^%^" from the search box
    Then User entered site name with numbers and special characters "$&%$12345" in search bar
    Then the Blank screen is displayed with no search results
    #Step 8
    When User removed entered site name "$&%$12345" from the search box
    Then User entered spaces in search bar
    Then the Blank screen is displayed with no search results
    #Step 9
    When User removed entered spaces from the search box
    Then The site screen displayed all site name
    #Step 10
    When User entered full site "<fullsite>" name in search box
    Then the list of site shall be displayed for entered text
    #Step 11
    When User enter a full site name "MGhospital" without any space
    Then the Blank screen is displayed with no search results
    #Step 12
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 13
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                        | fullsite    |
      | ic-test-admin@capgemini.com | MG hospital |

  @ImageUpload_TC7907
  Scenario Outline: TC7907 - IC Technician_Verify search of site selection screen with invalid data
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
    And the list of sites are displayed
    Then the search box shall be displayed
    #Step 5
    When the user enters invalid site name "xyz" in search box
    Then the Blank screen is displayed with no search results
    #Step 6
    When User removed entered site name "xyz" from the search box
    Then entered special character "$&%$^%^" in search bar
    And the Blank screen is displayed with no search results
    #Step 7
    When User removed entered site name "$&%$^%^" from the search box
    Then User entered site name with numbers and special characters "$&%$12345" in search bar
    Then the Blank screen is displayed with no search results
    #Step 8
    When User removed entered site name "$&%$12345" from the search box
    Then User entered spaces in search bar
    Then the Blank screen is displayed with no search results
    #Step 9
    When User removed entered spaces from the search box
    Then The site screen displayed all site name
    #Step 10
    When User entered full site "<fullsite>" name in search box
    Then the list of site shall be displayed for entered text
    #Step 11
    When User enter a full site name "MGhospital" without any space
    Then the Blank screen is displayed with no search results
    #Step 12
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 13
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                       | fullsite    |
      | ic-test-tech@capgemini.com | MG hospital |


  @ImageUpload_TC7908
  Scenario Outline: TC7908 - Hospital Admin_Verify search of site selection screen with invalid data
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
    And the list of sites are displayed
    Then the search box shall be displayed
    #Step 5
    When the user enters invalid site name "xyz" in search box
    Then the Blank screen is displayed with no search results
    #Step 6
    When User removed entered site name "xyz" from the search box
    Then entered special character "$&%$^%^" in search bar
    And the Blank screen is displayed with no search results
    #Step 7
    When User removed entered site name "$&%$^%^" from the search box
    Then User entered site name with numbers and special characters "$&%$12345" in search bar
    Then the Blank screen is displayed with no search results
    #Step 8
    When User removed entered site name "$&%$12345" from the search box
    Then User entered spaces in search bar
    Then the Blank screen is displayed with no search results
    #Step 9
    When User removed entered spaces from the search box
    Then The site screen displayed all site name
    #Step 10
    When User entered full site "<fullsite>" name in search box
    Then the list of site shall be displayed for entered text
    #Step 11
    When User enter a full site name "<sitewithoutspace>" without any space
    Then the Blank screen is displayed with no search results
    #Step 12
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 13
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                                 | fullsite | sitewithoutspace |
      | ic-test-hospital-admin@capgemini.com | apollo   | MGhospital |

  @ImageUpload_TC7909
  Scenario Outline: TC7909 - Surgeon_Verify search of site selection screen with invalid data
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
    And the list of sites are displayed
    Then the search box shall be displayed
    #Step 5
    When the user enters invalid site name "xyz" in search box
    Then the Blank screen is displayed with no search results
    #Step 6
    When User removed entered site name "xyz" from the search box
    Then entered special character "$&%$^%^" in search bar
    And the Blank screen is displayed with no search results
    #Step 7
    When User removed entered site name "$&%$^%^" from the search box
    Then User entered site name with numbers and special characters "$&%$12345" in search bar
    Then the Blank screen is displayed with no search results
    #Step 8
    When User removed entered site name "$&%$12345" from the search box
    Then User entered spaces in search bar
    Then the Blank screen is displayed with no search results
    #Step 9
    When User removed entered spaces from the search box
    Then The site screen displayed all site name
    #Step 10
    When User entered full site "<fullsite>" name in search box
    Then the list of site shall be displayed for entered text
    #Step 11
    When User enter a full site name "<sitewithoutspace>" without any space
    Then the Blank screen is displayed with no search results
    #Step 12
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 13
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                          | fullsite | sitewithoutspace |
      | ic-test-surgeon@capgemini.com | apollo   | MGhospital |

  @ImageUpload_TC7910
  Scenario Outline: TC7910 - Support Staff_Verify search of site selection screen with invalid data
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
    And the list of sites are displayed
    Then the search box shall be displayed
    #Step 5
    When the user enters invalid site name "xyz" in search box
    Then the Blank screen is displayed with no search results
    #Step 6
    When User removed entered site name "xyz" from the search box
    Then entered special character "$&%$^%^" in search bar
    And the Blank screen is displayed with no search results
    #Step 7
    When User removed entered site name "$&%$^%^" from the search box
    Then User entered site name with numbers and special characters "$&%$12345" in search bar
    Then the Blank screen is displayed with no search results
    #Step 8
    When User removed entered site name "$&%$12345" from the search box
    Then User entered spaces in search bar
    Then the Blank screen is displayed with no search results
    #Step 9
    When User removed entered spaces from the search box
    Then The site screen displayed all site name
    #Step 10
    When User entered full site "<fullsite>" name in search box
    Then the list of site shall be displayed for entered text
    #Step 11
    When User enter a full site name "<sitewithoutspace>" without any space
    Then the Blank screen is displayed with no search results
    #Step 12
    When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 13
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                               | fullsite | sitewithoutspace |
      | ic-test-supportstaff@capgemini.com | apollo   | MGHospital |
                                           
