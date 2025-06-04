Feature: SSR3334 - Verifying Data Upload Utility shall allow the S&N HIL Manager to search all active Hospital accounts by any of the fields from the organization and imaging facility link tables (including organization name, address, state, zip code, admin first name, admin last name, admin e-mail address, admin phone number).

  @facilityLinking_TC3486
  Scenario Outline: TC3486 - S&N HIL Manager_ Verify Data Upload Utility allows to search all active Hospital accounts  by any of the fields from the organization and Available Providers tables
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And Choose Site screen is displayed
    Then Search for hospital
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    Then Upload dashboad page is displayed to user
    When the user clicks on imaging links button from left menu bar
    Then the imaging links shall be higlighted in left menu bar
    And the right side header shall be displayed as Create or Modify Links
    Then User clicks active facility in left table
    And the following elements shall be displayed at left section of imaging link screen
      | elements           |
      | all organizations  |
      | search tab         |
      | search button      |
      | name of facilities |
      | facilities type    |
      | citystate          |
      | status             |
    When the user selects a facility type as "Provider" from the left table
    Then the selected facility shall be displayed in teal color
    And the details of selected provider shall be displayed as below
      | provider          |
      | organization name |
      | address           |
      | admin name        |
      | admin email       |
      | phone number      |
    When the user enters organization name in "lower case" as "Abc" in search bar of left table
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters organization name in "upper case" as "ABC" in search bar of left table
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters organization name in "Combination of Uppercase and lowercase" as "Abc" in search bar of left table
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters address in "lower case" as "abc" in search bar of left table
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters address in "upper case" as "ABC" in search bar of left table
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters address in "Combination of Uppercase and lowercase" as "Abc" in search bar of left table
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters zipcode as "01810" in search bar of left table
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters city in "lower case" as "Hadmin" in search bar of left table
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters city in "upper case" as "HADMIN" in search bar of left table
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters city in "Combination of Uppercase and lowercase" as "Hadmin" in search bar of left table
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters admin name in "lower case" as "hadmin" in search bar of left table
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters admin name in "upper case" as "HADMIN" in search bar of left table
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters admin name in "Combination of Uppercase and lowercase" as "Hadmin" in search bar of left table
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters admin email as "aao@ah.com" in search bar of left table
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters admin phone number as "4083687715" in search bar of left table
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user clears the content of left search bar
    And the user selects a facility type as "Imaging" from the left table
    Then the right section table detials shall be displayed as below
      | section            |
      | available provider |
      | toggle button      |
      | toggle button text |
      | search tab         |
      | search button      |
      | name of hospitals  |
      | linked icon        |
      | unlinked icon      |
      | citystate          |
      | contact number     |
    When the user selects a facility provider from the right table
    Then the selected provider shall be displayed in teal color
    And the details of selected provider from right table shall be displayed as below
      | provider          |
      | organization name |
      | address           |
      | admin name        |
      | admin email       |
      | phone number      |
    When the user enters organization name in "lower case" as "admin center" in search bar of right table
    And the user clicks on search button of right table
    Then the searched keyword results shall be displayed under all provider
    When the user enters organization name in "upper case" as "ADMIN CENTER" in search bar of right table
    And the user clicks on search button of right table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters organization name in "Combination of Uppercase and lowercase" as "Admin Center" in search bar of right table
    And the user clicks on search button of right table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters address in "lower case" as "123 new parkway" in search bar of right table
    And the user clicks on search button of right table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters address in "upper case" as "123 NEW PARKWAY" in search bar of right table
    And the user clicks on search button of right table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters address in "Combination of Uppercase and lowercase" as "123 New Parkway" in search bar of right table
    And the user clicks on search button of right table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters zipcode as "41613" in search bar of right table
    And the user clicks on search button of right table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters city in "lower case" as "kolhapur" in search bar of right table
    And the user clicks on search button of right table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters city in "upper case" as "KOLHAPUR" in search bar of right table
    And the user clicks on search button of right table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters city in "Combination of Uppercase and lowercase" as "Kolhapur" in search bar of right table
    And the user clicks on search button of right table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters admin name in "lower case" as "vijitest" in search bar of right table
    And the user clicks on search button of right table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters admin name in "upper case" as "VIJITEST" in search bar of right table
    And the user clicks on search button of right table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters admin name in "Combination of Uppercase and lowercase" as "Vijitest" in search bar of right table
    And the user clicks on search button of right table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters admin email as "noboqav.jesamo@gotgel.org" in search bar of right table
    And the user clicks on search button of right table
    Then the searched keyword results shall be displayed under all organizations
    When the user enters admin phone number as "8004865185" in search bar of right table
    And the user clicks on search button of right table
    Then the searched keyword results shall be displayed under all organizations
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |

  @facilityLinking_TC3488
  Scenario Outline: TC3488 - S&N HIL Manager_ Verify search by invalid data on Imaging links screen.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And Choose Site screen is displayed
    Then Search for hospital
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    Then Upload dashboad page is displayed to user
    When the user clicks on imaging links button from left menu bar
    Then the imaging links shall be higlighted in left menu bar
    And the right side header shall be displayed as Create or Modify Links
    And the following elements shall be displayed at left section of imaging link screen
      | elements           |
      | all organizations  |
      | search tab         |
      | search button      |
      | name of facilities |
      | facilities type    |
      | citystate          |
      | status             |
    Then The all organizations left table list "before" clicking search button
    When the user clicks on search button of left table
    Then The all organizations left table list "after" clicking search button
    When the user enters test data as "#@&*^%!#&*^!#%" in left table search bar
    And the user clicks on search button of left table
    Then the message no data to display shall be displayed in left table
    When the user enters test data as "Cent3r!@*&!^@" in left table search bar
    And the user clicks on search button of left table
    Then the message no data to display shall be displayed in left table
    When the user clears the content of left search bar
    And the user selects a facility type as "Provider@!@!@" from the left table
    Then the selected facility shall be displayed in teal color
    Then the right section table detials shall be displayed as below
      | section            |
      | available provider |
      | toggle button      |
      | toggle button text |
      | search tab         |
      | search button      |
      | name of hospitals  |
      | linked icon        |
      | unlinked icon      |
      | citystate          |
      | contact number     |
    Then The available provider right table list "before" clicking search button
    When the user clicks on search button of left table
    Then The available provider right table list "after" clicking search button
    When the user enters test data as "#@&!^@%!@&" in right table search bar
    And the user clicks on search button of right table
    Then the message no data to display shall be displayed in right table
    When the user enters test data as "Cent3r!@!@!@" in right table search bar
    And the user clicks on search button of right table
    Then the message no data to display shall be displayed in right table
    When the user clears the content of left search bar
    Then User clicks active facility in left table
    Then the selected provider shall be displayed in teal color
    Then the right section table detials shall be displayed as below
      | section            |
      | available provider |
      | toggle button      |
      | toggle button text |
      | search tab         |
      | search button      |
      | name of hospitals  |
      | linked icon        |
      | unlinked icon      |
      | citystate          |
      | contact number     |
    Then The available provider right table list "before" clicking search button
    When the user clicks on search button of left table
    Then The available provider right table list "after" clicking search button
    When the user enters test data as "#@&!@!@" in right table search bar
    And the user clicks on search button of right table
    Then the message no data to display shall be displayed in right table
    When the user enters test data as "Cent3r&!^#%!" in right table search bar
    And the user clicks on search button of right table
    Then the message no data to display shall be displayed in right table
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |

	@facilityLinking_TC3489
  Scenario Outline: TC3489 - S&N HIL Manager_ Verify Usability for Imaging links screen
    #Step 1
    #	Given Ensure facilities of type "Provider" and "Imaging center" with status Active, Inactive and N/A  are available.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Choose Site screen is displayed
    Then Search for hospital
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    Then Upload dashboad page is displayed to user
    When the user clicks on imaging links button from left menu bar
    #Step 2
    Then the imaging links shall be higlighted in left menu bar
    And the Create or Modify Links screen is displayed
    And the Create or Modify Links header text in white color
    #Step 3
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
    #|Show more|
    ##Step 4
    Then User clicks active facility in left table
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
    #Step 5
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
    #|Show more|
    #Step 6
    Then The user clicks the create link button under the right table
    When the user selects "provider" from the right table which is in "Linked" state
    Then the selected provider is highlighted in the teal color rectangular box
    And the following elements are displayed below the right table in white font
    | elements              				|
    | Provider Details text 				|
    | Name                  				|
    | Address               				|
    | Admin Name            				|
    | Website               				|
    | Contact number        				|
    | Create Link button Disabled  |
    | Remove Link button Enabled  	|
    When the user selects "provider" from the right table which is in "Unlinked" state
    Then the user clicks the fourth entry in the right side table
    Then the selected provider is highlighted in the teal color rectangular box
    And the following elements are displayed below the right table in white font
    | elements              			|
    | Provider Details text 			|
    | Name                  			|
    | Address               			|
    | Admin Name            			|
    | Website               			|
    | Contact number        			|
    | Create Link button Enabled  |
    | Remove Link button Disabled |
    #Step 7
    When User clicks inactive facility in left table
    Then the selected facility is highlighted in the teal color rectangular box
    And the following elements are displayed below the left table in white font
    | elements               					|
    | Provider Details text  					|
    | Name                   					|
    | Address                					|
    | Admin Name             					|
    | Email                  					|
    | Contact number         					|
    | Activate Site button Enabled    |
    | Deactivate Site button Disabled |
    #Step 8
    Then the right section table of Imaging Links screen is displayed
    |Items																		|
    |Available Imaging Facilities text				|
    |Toggle button turned on 									|
    |Pin linked centers to top								|
    |Toggle button turned off 								|
    |Search tab																|
    |Enter keyword, Name of Facility or City  |
    |Search Button														|
    |Name																			|
    |Link and delink icons										|
    |City and State 													|
    |Contact number 													|
    #|Show more|
    #Step 9
    When the user selects "Imaging center" from the right table which is in "Linked" state
    Then the selected facility is highlighted in the teal color rectangular box
    And the following elements are displayed below the right table in white font
    | elements                      |
    | Imaging Facility Details text |
    | Name                          |
    | Address                       |
    | Admin Name                    |
    | Website                       |
    | Contact number                |
    | Create Link button Disabled   |
    | Remove Link button Enabled  	|
    When the user selects "Imaging center" from the right table which is in "Unlinked" state
    Then the user clicks the fourth entry in the right side table
    Then the selected provider is highlighted in the teal color rectangular box
    And the following elements are displayed below the right table in white font
    | elements              				|
    | Imaging Facility Details text |
    | Name                  				|
    | Address               				|
    | Admin Name            				|
    | Website               				|
    | Contact number        				|
    | Create Link button Enabled  	|
    | Remove Link button Disabled  	|
    #Step 10
    Then User clicks active facility in left table
    Then the selected facility is highlighted in the teal color rectangular box
    And Highlighted Hospital details and the status are displayed under "Provider" details
    #Step 11
    Then Linked facility is displayed with link icon highlighted in Green color
    And Unlinked facility is displayed with stroked link icon highlighted in white color
    #Step 12
    Then the Activate Site and Deactivate site buttons are available under "provider" details
    Then "Deactivate Site" button is enabled
    #Step 13
    When the user clicks on "Deactivate site" button
    And Wait 5 seconds
    Then "Hospital" status is changed to "Inactive" within the table and highlighted in green color
    #Step 14
    Then "Activate Site" button is enabled
    #Step 15
    When the user clicks on "Activate site" button
    And Wait 5 seconds
    Then "Hospital" status is changed to "Active" within the table and highlighted in green color
    #Step 16
    Then User clicks active facility in left table
    Then the selected facility is highlighted in the teal color rectangular box
    And Highlighted Image center details and the status are displayed under Imaging Facility details
    #Step 17
    Then the Activate Site and Deactivate site buttons are available under "Imaging Facility" details
    Then "Deactivate Site" button is enabled
    #Step 18
    When the user clicks on "Deactivate site" button
    And Wait 5 seconds
    Then "Image center" status is changed to "Inactive" within the table and highlighted in green color
    #Step 19
    Then "Activate Site" button is enabled
    #Step 20
    When the user clicks on "Activate site" button
    And Wait 5 seconds
    Then "Image center" status is changed to "Active" within the table and highlighted in green color
    #Step 21
    When the user selects "Imaging center" from the left table which is in "Inactive" status
    Then the selected facility is highlighted in the teal color rectangular box
    #Step 22
    When the user selects "Provider" from the left table which is in "Inactive" status
    Then the selected facility is highlighted in the teal color rectangular box
    #Step 23
    Then User clicks NA facility in left table
    Then the selected facility is highlighted in the teal color rectangular box
    #Step 24
    Then User clicks NA facility in left table
    Then the selected facility is highlighted in the teal color rectangular box
    #Step 25
    When the user click on Exit Apps at the bottom of the left menu panel
    #Step 26
    When user clicks on Logout icon from left panel

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |
      
