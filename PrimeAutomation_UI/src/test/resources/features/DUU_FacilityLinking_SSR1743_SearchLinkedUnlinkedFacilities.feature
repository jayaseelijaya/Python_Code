Feature: SSR1743 - Verifying Hospital Admin to search the linked and unlinked facilities by any column within the imaging links table.

  @facilityLinking_TC0936
  Scenario Outline: TC0936 - Hospital Admin_ Verify Data Upload utility app allow user to search the linked and unlinked facilities by any column within the imaging links table.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    When the user clicks on imaging links button from left menu bar
    And the right side header shall be displayed as provider links
    And the following details shall be displayed on facility linking screen
      | details                    |
      | all available image center |
      | site                       |
      | address                    |
      | city state zipcode         |
      | contact                    |
      | phone number               |
      | remove link                |
      | create link                |
      | search box                 |
      | search button              |
      | toggle button              |
    And the linked facilities shall be displayed in green color
    And the unlinked facilities shall be displayed in white color
    When the user enters site name as "ruby royal tower" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters site name as "RUBY ROYAL TOWER" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters site name as "Ruby royal toweR" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters address keyword as "123 New Parkway" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters address keyword as "123 NEW PARKWAY" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters address keyword as "123 New parkwaY" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters city name as "Kolhapur" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters city name as "KOLHAPUR" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters city name as "KolhapuR" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters contact name as "vijitest" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters contact name as "VIJITEST" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters contact name as "VijitesT" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters phone number as "8004865185" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user clears the content in search bar
    Then the list of linked and unliked image center shall be displayed
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel

    Examples: 
      | user                                 |
      | ic-test-hospital-admin@capgemini.com |

  @facilityLinking_TC3467
  Scenario Outline: TC3467 - Hospital Admin_Verify search by invalid data on Imaging links screen.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    When the user clicks on imaging links button from left menu bar
    And the right side header shall be displayed as provider links
    And the following details shall be displayed on facility linking screen
      | details                    |
      | all available image center |
      | site                       |
      | address                    |
      | city state zipcode         |
      | contact                    |
      | phone number               |
      | remove link                |
      | create link                |
      | search box                 |
      | search button              |
      | toggle button              |
    And the linked facilities shall be displayed in green color
    And the unlinked facilities shall be displayed in white color
    Then image linking table list "before" clicking search button
    And the user clicks on search button in facility linking
    Then image linking table list "after" clicking search button
    When the user enters test data as "000985300" in search bar
    And the user clicks on search button in facility linking
    #Then the message no data to display shall be displayed (not functional)
    When the user enters test data as "H@spital" in search bar
    And the user clicks on search button in facility linking
    #Then the message no data to display shall be displayed (not functional)
    When the user enters test data as "Cent3r" in search bar
    And the user clicks on search button in facility linking
    #Then the message no data to display shall be displayed (not functional)
    When the user enters test data as ".#@Alex" in search bar
    And the user clicks on search button in facility linking
    #Then the message no data to display shall be displayed (not functional)
    When the user clears the content in search bar
    Then the list of linked and unliked image center shall be displayed
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel

    Examples: 
      | user                                 |
      | ic-test-hospital-admin@capgemini.com |

  @facilityLinking_TC0940
  Scenario Outline: TC0940 - Hospital Admin_Verify the Usability of Imaging links screen

  	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  	Then check imaging links menu bar button
		And user clicks imaging links menu bar button
		And check color of imaging links button in left menu bar
		And check imaging links page header
		And check imaging links table header
		And All table headers are displayed
		And the arrows next to all table headers are displayed
		And Search bar with search button is displayed
		And Check right side information on imaging links page
		And Check if the remove link button is displayed below the table
		And Check if the create link button is displayed below the table
		Then User clicks inactive facility in hospital admin imaging links table
		And Wait 5 seconds
		And Check right side information on imaging links page
		And Check right side information on imaging links page
		And Check color of first entry in imaging links table
		Then HAdmin user clicks create link button at bottom of table
		And Wait 5 seconds
		Then check that the create link button is disabled hadmin table
		And Check right side information on imaging links page
		And Check color of first entry in imaging links table
		And check pin linked button in the top right
		And The user clicks pin linked button in the top right
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel

	Examples:
		|user                                 |
		|ic-test-hospital-admin@capgemini.com |

