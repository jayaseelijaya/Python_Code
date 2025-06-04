Feature: SSR1746 - Verifying Data Upload Utility web application shall link Hospital automatically to itself as a source data upload organization. 

   @facilityLinking_TC0940
  Scenario Outline: TC0940 - Hospital Admin_Verify the Usability of Imaging links screen.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    When the user clicks on imaging links button from left menu bar
    Then the imaging links shall be higlighted in left menu bar
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
    And the search bar shall be displayed along with search icon
    And the linked facilities shall be displayed in green color
    And the unlinked facilities shall be displayed in white color
    When the user selects an unlinked image center from the table
    Then the selected image center shall be highlighted in green color
    And the following details shall be displayed at right section of the screen
      | section                            |
      | profile                            |
      | image center details               |
      | link inactive text                 |
      | name                               |
      | name of selected imaging center    |
      | Affliation                         |
      | name of selected organization      |
      | address                            |
      | address of selected imaging center |
      | site contact                       |
      | contact information                |
    When the user selects a linked image center from the table
    Then the selected image center shall be highlighted in green color
    And the following details shall be displayed at right section of the screen
      | section                            |
      | profile                            |
      | image center details               |
      | link active text                   |
      | name                               |
      | name of selected imaging center    |
      | Affliation                         |
      | name of selected organization      |
      | address                            |
      | address of selected imaging center |
      | site contact                       |
      | contact information                |
    And the toggle button with text pin linked center to top shall be displayed and enabled
    When the user clicks on toggle button
    Then the toggle button shall be disabled
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed

    Examples: 
      | user                                 |
      | ic-test-hospital-admin@capgemini.com |

  @facilityLinking_TC3458
  Scenario Outline: TC3458 - Hospital Admin_Verify Hospital admin link Hospital automatically to itself as a source data upload organization.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And Choose Site screen is displayed
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    Then Upload dashboad page is displayed to user
    When the user clicks on imaging links button from left menu bar
    Then the imaging links shall be higlighted in left menu bar
    And the right side header shall be displayed as Create or Modify Links
    And the following elements shall be displayed at left section of imaging link screen
      | elements	|
      | all organizations |
      | search tab		|
      | search button	|
      | name of facilities	|
      | facilities type	|
      | citystate	|
      | status	|
    #And the facility of hospital admin shall be displayed under all organization table along with active status 
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.
    And Data-Upload Application is closed   
    
    
    
    Examples: 
      | user                        |
      | ic-test-snn-hil-manager@capgemini.com  |
    
    
    
    
    
    
    
    
    
          