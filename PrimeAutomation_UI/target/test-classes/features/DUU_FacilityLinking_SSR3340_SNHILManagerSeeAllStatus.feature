Feature: SSR3340 - Data Upload Utility shall allow the S&N HIL Manager to see all 'Active', 'Inactive', 'N/A' registered Image Centers and Hospitals linked to an active Hospital account.

  @facilityLinking_TC3497
  Scenario Outline: TC3497 - SN HIL Manager_Verify  Data Upload Utility shall allow the SN HIL Manager to see all Active  Inactive  NA  status Hospitals
    #	Given Ensure facilities of type "Provider" and "Imaging center" with status Active, Inactive and N/A  are available.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    Then Search for hospital
    And Choose Site screen is displayed
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    Then Upload dashboad page is displayed to user
    When the user clicks on imaging links button from left menu bar
    Then the imaging links shall be higlighted in left menu bar
    And the right side header shall be displayed as Create or Modify Links
    Then the all organizations text shall be displayed
    And the available imaging or available provider text shall be displayed
    And the left table shall be displayed along with search button  
    And the right table shall be displayed along with search button
    Then User clicks active facility in left table
    Then the linked imaging centers shall be displayed in the right hospital
    When the user selects a facility type as "Provider" from the left table
    Then the unlinked imaging centers shall be displayed in the right hospital
    When User clicks inactive facility in left table
    Then the linked imaging centers shall be displayed in the right hospital
    When the user selects a facility type as "Provider" from the left table
    Then User clicks NA facility in left table
    And Check that both linked and unlinked facilities are displayed in the right table
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |
      
  @facilityLinking_TC3498
  Scenario Outline: TC3498 - SN HIL Manager_Verify Data Upload Utility shall allow the S&N HIL Manager to see all Active Inactive and NA status Image Centers.
    #	Given Ensure facilities of type "Provider" and "Imaging center" with status Active, Inactive and N/A  are available.
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
    Then the all organizations text shall be displayed
    And the available imaging or available provider text shall be displayed
    And the left table shall be displayed along with search button  
    And the right table shall be displayed along with search button
    And Wait 5 seconds
    And the user enters active facility name into the search bar
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations 
    When the user clears the content of left search bar
    Then User clicks active facility in left table
    Then the list of linked and unlinked hospitals shall be displayed in right table
    And Wait 5 seconds
    And the user enters Inactive facility name into the search bar
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user clears the content of left search bar
    When User clicks inactive facility in left table
    Then the list of linked and unlinked hospitals shall be displayed in right table
    And Wait 5 seconds
    And the user enters Na facility name into the search bar
    And the user clicks on search button of left table
    Then the searched keyword results shall be displayed under all organizations
    When the user clears the content of left search bar
    Then User clicks NA facility in left table
    And Check that both linked and unlinked facilities are displayed in the right table
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |
