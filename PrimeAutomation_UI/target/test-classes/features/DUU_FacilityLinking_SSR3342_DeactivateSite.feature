Feature: SSR3342 - Data Upload Utility shall allow the S&N HIL Manager to deactivate an image center or provider in the imaging links page

  @facilityLinking_TC3475
  Scenario Outline: TC3475 - S&N HIL Manager_Verify Data Upload Utility shall allow the SN HIL Manager to change a status of an Image Center from Active to Inactive

    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Choose Site screen is displayed
    Then Search for hospital
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    Then Upload dashboad page is displayed to user
    When the user clicks on imaging links button from left menu bar
    Then Verify all organizations are displayed in the left table
    #Type status Active in search bar (not functional)
    Then User clicks active facility in left table
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
    Then Verify activate site button should be disabled
    And Verify deactivate site button should be enabled
    Then User clicks deactivate site button under left table
    And Wait 5 seconds
    And Verify the site that was just deactivated, is inactive
    Then the user clicks on "Activate site" button
    And Wait 5 seconds
    When user clicks on Logout icon from left panel

 	 Examples:
    | user                                  |
    | ic-test-snn-hil-manager@capgemini.com |

