Feature: SSR1788 - Data Upload Utility web application audit log for Hospital shall be viewable only by H Admin

  @TC1007
  Scenario Outline: TC1007 - Verify audit log for Hospital shall be viewable only by H Admin
    Given that the user is logged in to Data-Upload Utility Application through chrome "ic-test-admin@capgemini.com"
    Then Homepage is displayed to the user
    When the user clicks on audit log button from left menu bar
    Then Audit log page should be displayed with below components
      | screen          |
      | 24 Hrs          |
      | Filter          |
      | Search box      |
      | Search          |
      | Events          |
      | Export Selected |
      | Export all      |
      | Show more       |
      | Scroll bar      |
    #When the user clicks on Export All button
    #Then the data should download and match excel "TC1007.csv"
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    When Email-Address is entered as "h-test-admin@capgemini.com"
    And Password is entered by the user
    And the Login button is clicked
    Then Homepage is displayed to the user
    When the user clicks on audit log button from left menu bar
    Then Audit log page should be displayed with below components
      | screen          |
      | 24 Hrs          |
      | Filter          |
      | Search box      |
      | Search          |
      | Events          |
      | Export Selected |
      | Export all      |
      | Show more       |
      | Scroll bar      |
    Then the h-admin should not see records of Imaging center from "TC1007.csv"
    #Then the audit log record for Hospital account should only be displayed
    And Data-Upload Application is closed

  @TC1008
  Scenario Outline: TC1008 - Verify H-admin can view the records with 24hrs filter
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    When the user clicks on audit log button from left menu bar
    Then Audit log page should be displayed with below components
      | screen          |
      | 24 Hrs          |
      | Filter          |
      | Search box      |
      | Search          |
      | Events          |
      | Export Selected |
      | Export all      |
      | Show more       |
      | Scroll bar      |
    Then the audit log record for Hospital account should only be displayed
    When the user clicks on 24hrs filter
    Then audit log records within 24hrs are only displayed
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

  @TC1010
  Scenario Outline: TC1010 - Verify that hospital admin can view logs of all users belongs to Hospital account
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    When the user clicks on audit log button from left menu bar
    Then Audit log page should be displayed with below components
    | screen          |
    | 24 Hrs          |
    | Filter          |
    | Search box      |
    | Search          |
    | Events          |
    | Export Selected |
    | Export all      |
    | Show more       |
    | Scroll bar      |
    #Then the audit log record for Hospital account should only be displayed
    When the user click on filter and expand the User Name filter option by clicking +
    #Then the User name filter should show the names of all user who has audit log records for Hospital account
    When the user selects H-admin user name and click on done
    Then the list should show the Audit logs for H-admin
    When the user click on filter and expand the User Name filter option by clicking +
    And the user unselects the "H-admin" filter
    And the user selects "Surgeon" user name and click on done
    #Then the list should show the Audit logs for "Surgeon"
    #When the user click on filter and expand the User Name filter option by clicking +
    #And the user unselects the "Surgeon" filter
    #The below commenetd steps are not valid, the manual testcase will be updated
    #And the user selects "Technician" user name and click on done
    #Then the list should show the Audit logs for "Technician"
    #When the user click on filter and expand the User Name filter option by clicking +
    #And the user unselects the "Technician" filter
    #And the user selects "Support staff" user name and click on done
    #Then the list should show the Audit logs for "Support staff"
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

  @TC1011
  Scenario Outline: TC1011 - Verify that H-admin can view the audit log records based on single filter criteria applied
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    When the user clicks on audit log button from left menu bar
    Then Audit log page should be displayed with below components
    | screen          |
    | 24 Hrs          |
    | Filter          |
    | Search box      |
    | Search          |
    | Events          |
    | Export Selected |
    | Export all      |
    | Show more       |
    | Scroll bar      |
    #Then the audit log record for Hospital account should only be displayed
    Then All the records should display in descending order based on Date Time column
    When the user clicks on filter button on audit log
    And the user clicks on date filter option
    And the user clicks on start date button
    And the user selects current date as start date
    And the user clicks on done button to close the filter option
    Then the audit log records shall be filtered as selected start date
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

  @TC1012
  Scenario Outline: TC1012 - Verify that H-admin can view the audit log records based on multiple filter applied
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    When the user clicks on audit log button from left menu bar
    Then Audit log page should be displayed with below components
    | screen          |
    | 24 Hrs          |
    | Filter          |
    | Search box      |
    | Search          |
    | Events          |
    | Export Selected |
    | Export all      |
    | Show more       |
    | Scroll bar      |
    #Then the audit log record for Hospital account should only be displayed
    Then All the records should display in descending order based on Date Time column
    When the user clicks on filter button on audit log
    And the user clicks on date filter option
    And the user clicks on start date button
    And the user selects start date lesser than end date
    And the user clicks on end date button
    And the user selects greater end date than start date
    When the user clicks on user name filer
    And the user selects H-admin user name and click on done
    Then the list is filterd on start date, end date and user name
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

  @TC1013
  Scenario Outline: TC1013 - Verify that H-admin can view the audit log records based on search criteria
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    When the user clicks on audit log button from left menu bar
    Then Audit log page should be displayed with below components
    | screen          |
    | 24 Hrs          |
    | Filter          |
    | Search box      |
    | Search          |
    | Events          |
    | Export Selected |
    | Export all      |
    | Show more       |
    | Scroll bar      |
    #Then the audit log record for Hospital account should only be displayed
    Then All the records should display in descending order based on Date Time column
    When the user searchs a user in search box and click on search button
    Then records should be displayed based on username search
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

  @TC1014
  Scenario Outline: TC1014 - Verify that H-admin can view the audit log records based on sorting applied
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    When the user clicks on audit log button from left menu bar
    Then Audit log page should be displayed with below components
    | screen          |
    | 24 Hrs          |
    | Filter          |
    | Search box      |
    | Search          |
    | Events          |
    | Export Selected |
    | Export all      |
    | Show more       |
    | Scroll bar      |
    #Then the audit log record for Hospital account should only be displayed
    Then All the records should display in descending order based on Date Time column
    #When the user clicks on the sort arrow for user column
    #Then the list should get sorted out in "descending" order of  User column
    #When the user clicks on the sort arrow for user column
    #Then the list should get sorted out in "ascending" order of  User column
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

  @TC1015
  Scenario Outline: TC1015 - Verify that H-admin can view the audit log records based on entered filter, sorting and search criteria
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    When the user clicks on audit log button from left menu bar
    Then Audit log page should be displayed with below components
    | screen          |
    | 24 Hrs          |
    | Filter          |
    | Search box      |
    | Search          |
    | Events          |
    | Export Selected |
    | Export all      |
    | Show more       |
    | Scroll bar      |
    #Then the audit log record for Hospital account should only be displayed
    Then All the records should display in descending order based on Date Time column
    #When the user clicks on the sort arrow for user column
    #Then the list should get sorted out in "descending" order of  User column
    #When the user clicks on the sort arrow for user column
    #Then the list should get sorted out in "ascending" order of  User column
    When the user clicks on filter button on audit log
    And the user clicks on date filter option
    And the user clicks on start date button
    And the user selects start date lesser than end date
    And the user clicks on end date button
    And the user selects greater end date than start date
    When the user clicks on user name filer
    And the user selects H-admin user name and click on done
    Then the list is filterd on start date, end date and user name
    When the user searchs a user in search box and click on search button
    Then records should be displayed based on username search
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |
