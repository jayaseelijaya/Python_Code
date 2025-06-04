Feature: SSR5730 - Verifying Hospital Admin to search the linked facilities by any column within the imaging links table.

  @facilityLinking_TC3680
  Scenario Outline: TC3680 - IC Admin_ Verify Data Upload utility app allow user to search the linked facilities by any column within the imaging links table. 
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
      | search box                 |
      | search button              |
    And the linked facilities shall be displayed in green color
    When the user enters site name as "acmh hospital" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters site name as "ACMH HOSPITAL" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters site name as "AcmH HospitaL" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters address keyword as "briarwood circle building" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters address keyword as "BRIARWOOD CIRCLE BUILDING" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters address keyword as "Briarwood Circle Building" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters city name as "kittanning" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters city name as "KITTANNING" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters city name as "KittaNning" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters contact name as "surgeonxyz" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters contact name as "SURGEONXYZ" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters contact name as "SurgeonXYZ" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user enters phone number as "9879876890" in search bar
    And the user clicks on search button in facility linking
    Then the site matching with search criteria shall be displayed in the table
    When the user clears the content in search bar
    Then the list of linked image center shall be displayed
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |

  @facilityLinking_TC7733
  Scenario Outline: TC3467 - IC Admin_Verify search by invalid data on Imaging links screen.
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
      | search box                 |
      | search button              |
    And Search bar with search button is displayed
    Then image linking table list "before*&@^*@&^#" clicking search button
    And the user clicks on search button in facility linking
    Then image linking table list "after@*#&^*@#&^" clicking search button
    When the user enters test data as "000985300!I#!#&" in search bar
    And the user clicks on search button in facility linking
    #Then the message no data to display shall be displayed
    When the user enters test data as "H@spital!I#T@UY#" in search bar
    And the user clicks on search button in facility linking
    #Then the message no data to display shall be displayed
    When the user enters test data as "Cent3r@I#UY@I#U" in search bar
    And the user clicks on search button in facility linking
    #Then the message no data to display shall be displayed
    When the user enters test data as ".#@Alex@#&^@#*&" in search bar
    And the user clicks on search button in facility linking
    #Then the message no data to display shall be displayed
    When the user clears the content in search bar
    Then the list of linked image center shall be displayed
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |

  @facilitylinking_TC3459
	Scenario Outline: TC3459 - IC admin_Verify the usability of Imaging Links screen
	
		Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  	Then check imaging links menu bar button
		And user clicks imaging links menu bar button
		And check color of imaging links button in left menu bar
		And check imaging links page header
		And check imaging links table header
		And All table headers are displayed
		And the arrows next to all table headers are displayed
		And Check right side information on imaging links page
		And Check if the remove link button is displayed below the table
		Then User clicks remove link button in ic admin
		And Wait 5 seconds
		And Search bar with search button is displayed
		And Check color of first entry in imaging links table
		And Check color of first entry in imaging links table
		And Check right side information on imaging links page
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel

	Examples:
		|user                        |
		|ic-test-admin@capgemini.com |
