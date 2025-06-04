Feature: SSR3344 - Data Upload Utility shall allow the S&N HIL Manager to change the Active Status of a Hospital from 'Active' to 'Inactive'

  @facilityLinking_TC3465
  Scenario Outline: TC3465 - SN HIL Manager_Verify Data Upload Utility shall allow the S&N HIL Manager to change a status of a Hospital from Active to Inactive. 
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
    #When the user enters status as "Active" in search bar of left table (Not functional)
    #And the user clicks on search button of left table
    #Then the list of all active status shall be displayed under all organizations
    Then User clicks active facility in left table
    And Wait 5 seconds
    Then the selected facility is highlighted in the teal color rectangular box
    And Highlighted Hospital details and the status are displayed under "Provider" details
    Then the Activate Site and Deactivate site buttons are available under "provider" details
    Then The user clicks the deactivate site button under the left table
    And Wait 5 seconds
    And The user clicks the activate site button under the left table
    And Wait 5 seconds
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |
        