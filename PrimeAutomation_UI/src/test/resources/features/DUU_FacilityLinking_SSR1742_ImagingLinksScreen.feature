Feature: SSR1742 - Verify Usability of imaging links screen for roles

  @facilityLinking_TC0908
  Scenario Outline: TC0908 - Hospital Admin_Verify DUU app allows user to view linked and unlinked facilities for ability to push images to linked target organizations in imaging links for image upload
		
		Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
		And Wait 10 seconds
  	Then check imaging links menu bar button
		And user clicks imaging links menu bar button
		And Wait 5 seconds
		And check color of imaging links button in left menu bar
		And Wait 5 seconds
  	Then User clicks active facility in left table
  	Then the selected facility is highlighted in the teal color rectangular box
  	And all elements are displayed in the left section of the imaging links page
		And the user verifies details under left table
		And the user checks activate link button
		And the user check deactivate link button
		And the user verifies details under right table
		Then check icon color on top site in table for hil manager
		Then User links one facilities for canton health center
		And check icon color on top site in table for hil manager
  	When User clicks inactive facility in left table
  	Then the selected facility is highlighted in the teal color rectangular box
  	And all elements are displayed in the left section of the imaging links page
		And the user verifies details under left table
		And the user checks activate link button
		And the user check deactivate link button
		And Wait 5 seconds
		And the user verifies details under right table
		Then check icon color on top site in table for hil manager
		Then User links one facilities for canton health center
		And check icon color on top site in table for hil manager
		And the user enters Na facility name into the search bar
		And the user clicks on search button of left table
		And Wait 5 seconds
		Then User clicks NA facility in left table
  	Then the selected facility is highlighted in the teal color rectangular box
  	And all elements are displayed in the left section of the imaging links page
		And the user verifies details under left table
		And the user checks activate link button
		And the user check deactivate link button
		And the user verifies details under right table
		Then check icon color on top site in table for hil manager
		Then User links one facilities for canton health center
		And check icon color on top site in table for hil manager
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Given that the user is logged in to Data-Upload Utility Application through chrome "<secondUser>"
		And Homepage is displayed to the user
  	Then check imaging links menu bar button
		And user clicks imaging links menu bar button
		And check imaging links page header
		And check imaging links table header
		And All table headers are displayed
		And the arrows next to all table headers are displayed
		And Check right side information on imaging links page
		And Check if the remove link button is displayed below the table
		And Check if the create link button is displayed below the table
		And Search bar with search button is displayed
		And check pin linked button in the top right
		Then User clicks inactive facility in hospital admin imaging links table
		And Wait 5 seconds
		And Check right side information on imaging links page
		Then User clicks active facility in hospital admin imaging links table
		And Wait 5 seconds
		And Check right side information on imaging links page
		Then Select upload files tab in left menu bar
	  Then the upload icon and Upload button are displayed
	  When Clicks on Upload Button
	  Then the Site selection screen is displayed
	  Then There should be a site shown in the upload sequence
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		#Steps 19 - 31 are not automatable due to CLP integration, not allowing for one set of test accounts to be checked, all users would need OTP access

	Examples:
		|user                                  | secondUser                  	        |
		|ic-test-snn-hil-manager@capgemini.com | ic-test-hospital-admin@capgemini.com |

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

	@facilityLinking_TC1222
	Scenario Outline: TC1222 - Hospital Admin_Verify Hospital Admin View allows the user to remove a link from a data upload target organization to a data upload source organization.
		Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
		And Wait 5 seconds
		Then Choose Site screen is displayed
    Then Search for hospital
    When clicks on any of the faclity from the facility selection screen
    And click on select button
  	Then check imaging links menu bar button
		And user clicks imaging links menu bar button
		And check color of imaging links button in left menu bar
		Then User clicks active facility in left table
  	And all elements are displayed in the left section of the imaging links page
		And the user verifies details under left table
		And the user checks activate link button
		And the user check deactivate link button
		And the user verifies details under right table
		And check search bar and search button snhil imaging links page
		And the user verifies details under right table
		And check icon color on top site in table for hil manager
		And Check that both linked and unlinked facilities are displayed in the right table
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Given that the user is logged in to Data-Upload Utility Application through chrome "<secondUser>"
		And Homepage is displayed to the user
  	Then check imaging links menu bar button
		And user clicks imaging links menu bar button
		And check imaging links page header
		And check imaging links table header
		And All table headers are displayed
		And the arrows next to all table headers are displayed
		And Check right side information on imaging links page
		And Check if the remove link button is displayed below the table
		And Check if the create link button is displayed below the table
		And Search bar with search button is displayed
		And check pin linked button in the top right
		Then HAdmin user clicks create link button at bottom of table
		And check icon color on top site in table for hadmin
		Then HAdmin user clicks remove link button at bottom of table
		And check icon color on top site in table for hadmin
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel

	Examples:
		|user                                  | secondUser                  	        |
		|ic-test-snn-hil-manager@capgemini.com | ic-test-hospital-admin@capgemini.com |

	@facilityLinking_TC1223
	Scenario Outline: TC1223 - Hospital Admin_Verify Hospital Admin View does not allow the Hospital Admin to remove a link from a data upload target organization to a data upload source organization for unlinked image centers
		Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
		And Wait 5 seconds
		Then Choose Site screen is displayed
    Then Search for hospital
    When clicks on any of the faclity from the facility selection screen
    And click on select button
  	Then check imaging links menu bar button
		And user clicks imaging links menu bar button
		And check color of imaging links button in left menu bar
		Then User clicks active facility in left table
  	And all elements are displayed in the left section of the imaging links page
		And the user verifies details under left table
		And the user checks activate link button
		And the user check deactivate link button
		And the user verifies details under right table
		And check search bar and search button snhil imaging links page
		And the user verifies details under right table
		And check icon color on top site in table for hil manager
		And Check that both linked and unlinked facilities are displayed in the right table
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Given that the user is logged in to Data-Upload Utility Application through chrome "<secondUser>"
		And Homepage is displayed to the user
  	Then check imaging links menu bar button
		And user clicks imaging links menu bar button
		And check imaging links page header
		And check imaging links table header
		And All table headers are displayed
		And the arrows next to all table headers are displayed
		And Check right side information on imaging links page
		And Check if the remove link button is displayed below the table
		And Check if the create link button is displayed below the table
		And Search bar with search button is displayed
		And check pin linked button in the top right
		Then HAdmin user clicks create link button at bottom of table
		And check icon color on top site in table for hadmin
		Then User clicks inactive facility in hospital admin imaging links table
		And check that the remove link button is disabled hadmin table
		And check icon color on top site in table for hadmin
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		
	Examples:
		|user                                  | secondUser                  	        |
		|ic-test-snn-hil-manager@capgemini.com | ic-test-hospital-admin@capgemini.com |
		
	@facilityLinking_TC1220
	Scenario Outline: TC1220 - Hospital Admin _Verify Hospital admin View allows the user to create a link from a data upload target organization to a data upload source organization

		Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
		Then Choose Site screen is displayed
    Then Search for hospital
    When clicks on any of the faclity from the facility selection screen
    And click on select button
  	And Wait 5 seconds
  	Then check imaging links menu bar button
  	And Wait 5 seconds
		And user clicks imaging links menu bar button
		And Wait 5 seconds
		Then User clicks active facility in left table
		And check color of imaging links button in left menu bar
  	And all elements are displayed in the left section of the imaging links page
		And the user verifies details under left table
		And the user checks activate link button
		And the user check deactivate link button
		And the user verifies details under right table
		And check search bar and search button snhil imaging links page
		And the user verifies details under right table
		And Check that both linked and unlinked facilities are displayed in the right table
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel
		Given that the user is logged in to Data-Upload Utility Application through chrome "<secondUser>"
		And Homepage is displayed to the user
  	Then check imaging links menu bar button
		And user clicks imaging links menu bar button
		And check imaging links page header
		And check imaging links table header
		And All table headers are displayed
		And the arrows next to all table headers are displayed
		And Check right side information on imaging links page
		And Check if the remove link button is displayed below the table
		And Check if the create link button is displayed below the table
		And Search bar with search button is displayed
		And check pin linked button in the top right
		Then User clicks inactive facility in hospital admin imaging links table
		And Wait 5 seconds
		And Check right side information on imaging links page
		And check icon color on top site in table for hadmin
		Then HAdmin user clicks create link button at bottom of table
		And check icon color on top site in table for hadmin
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel

	Examples:
		|user                                  | secondUser                  	        |
		|ic-test-snn-hil-manager@capgemini.com | ic-test-hospital-admin@capgemini.com |

	@facilityLinking_TC1221
	Scenario Outline: TC1221 - Hospital Admin_Verify Hospital Admin View does not allow user to create link from a data upload target organization to a data upload source organization for linked image centers.
		Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
		And Homepage is displayed to the user
  	Then check imaging links menu bar button
		And user clicks imaging links menu bar button
		And Wait 5 seconds
		And check imaging links page header
		And check imaging links table header
		And All table headers are displayed
		And the arrows next to all table headers are displayed
		And Check right side information on imaging links page
		And Check if the remove link button is displayed below the table
		And Check if the create link button is displayed below the table
		And Search bar with search button is displayed
		And check pin linked button in the top right
		Then HAdmin user clicks create link button at bottom of table
		Then check icon color on top site in table for hadmin
		Then check icon color on top site in table for hadmin
		Then check that the create link button is disabled hadmin table
		Then HAdmin user clicks remove link button at bottom of table
		Then HAdmin user clicks create link button at bottom of table
		When the user clicks on exit to app button from left menu bar
		And user clicks on Logout icon from left panel

		Examples:
		| user                                 |
		| ic-test-hospital-admin@capgemini.com |
