Feature: SSR3472 - Verifying Data Upload Utility web application shall be able to pin / unpin linked facilities to the top when viewing links.

	@facilityLinking_TC5030
  Scenario Outline: TC5030 - Hospital Admin_Verify Hospital admin View allows the user to pin unpin linked image centers.
  
  Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  Then Homepage is displayed to the user
  When the user clicks on imaging links button from left menu bar
  And Wait 5 seconds
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
  When user clicks on toggle 
  Then All linked image centers are displayed above in table 
  And all unlinked image centers are displayed below in the table
  When user turns off the toggle 
  Then image center list sorted in Alphabet order based on Site column
  When user clicks on file dashboard page and verifies the header
  And the user clicks on imaging links button from left menu bar
  Then Check if pinned facilities are at the top of the table
  When the user clicks on exit to app button from left menu bar
  And user clicks on Logout icon from left panel  
  
  Examples: 
    | user                                 |
    | ic-test-hospital-admin@capgemini.com |
    
  @facilityLinking_TC5032
  Scenario Outline: TC5032 - SN HIL Manager_Verify Data Upload Utility  allows user pin unpin linked facilities on top of the table
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
	  Then Choose Site screen is displayed
    Then Search for hospital
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    Then Upload dashboad page is displayed to user
    When the user clicks on imaging links button from left menu bar
	  And Wait 5 seconds
    Then the left section table of Imaging Links screen is displayed
	    |Items																		|
	    |All organizations												|
	    |Search tab																|
	    |Enter keyword, Name of Facility or City	|
	    |Search Button														|
	    |Name of the all the facilities						|
	    |Facility type 														|
	    |City, State of the facilities						|
	    |Active status 														|
   	Then User clicks active facility in left table
   	Then The user clicks the create link button under the right table
   	Then the selected facility is highlighted in the teal color rectangular box
   	And the following elements are displayed below the left table in white font
      | elements                       |
      | Imaging Facility Details text  |
      | Name                           |
      | Address                        |
      | Admin                          |
      | Email                          |
      | Contact number                 |
      | Activate Site button Disabled  |
      | Deactivate Site button Enabled |
    Then the right section table of Imaging Links screen is displayed
	    |Items																		|
	    |Available Providers header text					|
	    |Toggle button turned on 									|
	    |Pin linked centers to top								|
	    |Toggle button turned off 								|
	    |Search tab																|
	    |Enter keyword, Name of Facility or City	|
	    |Search Button														|
	    |Name																			|
	    |Link and delink icons										|
	    |City and State 													|
	    |Contact number 													|
	  And Check pin linked button above right table
	  Then User clicks pin linked button above right table
	  #Check that the list is in alphabetical order (not possible with invalid sites in tables)
	  Then user clicks on file dashboard page and verifies the header
	  When the user clicks on imaging links button from left menu bar
	  And Wait 5 seconds
	  Then User clicks active facility in left table
	  And Wait 5 seconds
	  And Check if the imaging links right table is in the correct pinned facility to top order
	  When the user clicks on exit to app button from left menu bar
	  And user clicks on Logout icon from left panel 
	  
  Examples: 
    | user                                  |
    | ic-test-snn-hil-manager@capgemini.com |
      
 	@linking_TC0940
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
