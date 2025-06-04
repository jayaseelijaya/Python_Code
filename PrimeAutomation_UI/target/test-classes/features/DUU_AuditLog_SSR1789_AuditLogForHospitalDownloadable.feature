Feature: SSR1789 - Data Upload Utility web application audit log for Hospital shall be downloadable by H Admin

  @TC0888
  Scenario Outline: TC0888 - Verify audit log for Hospital shall be downloadable only by H Admin
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
    And the audit log header text shall be displayed
    And the 24hrs filter shall be displayed on audit log
    And the filter button shall be displayed on audit log
    And the search textbox shall be displayed on audit log
    And the search button shall be displayed on audit log
    And the following audit log table header shall be displayed
      | header   |
      | date     |
      | user     |
      | username |
      | action   |
    And the audit log records shall be displayed
    And the export selected button shall be displayed
    And the export all button shall be displayed
    And the scrollbar shall be displayed on audit log at right side
    And the show more button shall be displayed on audit log
    Then the audit log record for Hospital account should only be displayed
    And the export selected button shall be "disabled"
    And the export all button shall be "enabled"
    When the user selects one record
    Then the record should be selected
    And the export selected button shall be "enabled"
    When the user clicks on export selected button
    Then the details of selected records should get download in following columns for excel sheet "TC0888_1.csv"
      | header        |
      | ActionDate    |
      | UserFirstName |
      | UserLastName  |
      | UserName      |
      | Action        |
    #| FacilityId    |
    Then the data should match on screen and excel "TC0888_1.csv" for selected record
    When the user unselects one record
    #When the user clicks on Export All button
    #Then the details of selected records should get download in following columns for excel sheet "TC0888_2.csv"
    #| header        |
    #| ActionDate    |
    #| UserFirstName |
    #| UserLastName  |
    #| UserName      |
    #| Action        |
    #| FacilityId    |
    #Then the data should match on screen and excel "TC0888_2.csv" for all records
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

  @TC0996
  Scenario Outline: TC0996 - Verify able to download audit logs for Hospital admin with 24hrs filter applied
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
    Then the audit log record for Hospital account should only be displayed
    When the user clicks on 24hrs filter
    Then audit log records within 24hrs are only displayed
    And the export selected button shall be "disabled"
    And the export all button shall be "enabled"
    When the user selects one record
    Then the record should be selected
    And the export selected button shall be "enabled"
    When the user clicks on export selected button
    Then the details of selected records should get download in following columns for excel sheet "TC0996_1.csv"
      | header        |
      | ActionDate    |
      | UserFirstName |
      | UserLastName  |
      | UserName      |
      | Action        |
    #| FacilityId    |
    Then the data should match on screen and excel "TC0996_1.csv" for selected record
    When the user unselects one record
    #When the user clicks on Export All button
    #Then the details of selected records should get download in following columns for excel sheet "TC0996_2.csv"
    #| header        |
    #| ActionDate    |
    #| UserFirstName |
    #| UserLastName  |
    #| UserName      |
    #| Action        |
    #| FacilityId    |
    #Then the data should match on screen and excel "TC0996_2.csv" for all records
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

  @TC0997
  Scenario Outline: TC0997- Verify that hospital admin can download logs of all users belongs to Hospital account
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
    Then the audit log record for Hospital account should only be displayed
    When the user click on filter and expand the User Name filter option by clicking +
    Then the User name filter should show the names of all user who has audit log records for Hospital account
    When the user selects H-admin user name and click on done
    Then the list should show the Audit logs for H-admin
    And the export selected button shall be "disabled"
    And the export all button shall be "enabled"
    When the user selects one record
    Then the record should be selected
    And the export selected button shall be "enabled"
    When the user clicks on export selected button
    Then the details of selected records should get download in following columns for excel sheet "TC0997_1.csv"
      | header        |
      | ActionDate    |
      | UserFirstName |
      | UserLastName  |
      | UserName      |
      | Action        |
    #| FacilityId    |
    Then the data should match on screen and excel "TC0997_1.csv" for selected record
    When the user unselects one record
    #When the user clicks on Export All button
    #Then the details of selected records should get download in following columns for excel sheet "TC0997_2.csv"
    #| header        |
    #| ActionDate    |
    #| UserFirstName |
    #| UserLastName  |
    #| UserName      |
    #| Action        |
    #| FacilityId    |
    #Then the data should match on screen and excel "TC0997_2.csv" for all records
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

  @TC0998
  Scenario Outline: TC0998- Verify H-admin can download audit log records based on single filter criteria applied
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
    Then the audit log record for Hospital account should only be displayed
    Then All the records should display in descending order based on Date Time column
    When the user clicks on filter button on audit log
    And the user clicks on date filter option
    And the user clicks on start date button
    And the user selects current date as start date
    And the user clicks on done button to close the filter option
    Then the audit log records shall be filtered as selected start date
    And the export selected button shall be "disabled"
    And the export all button shall be "enabled"
    When the user selects one record
    Then the record should be selected
    And the export selected button shall be "enabled"
    When the user clicks on export selected button
    Then the details of selected records should get download in following columns for excel sheet "TC0998_1.csv"
      | header        |
      | ActionDate    |
      | UserFirstName |
      | UserLastName  |
      | UserName      |
      | Action        |
    #| FacilityId    |
    Then the data should match on screen and excel "TC0998_1.csv" for selected record
    When the user unselects one record
    #When the user clicks on Export All button
    #Then the details of selected records should get download in following columns for excel sheet "TC0998_2.csv"
    #| header        |
    #| ActionDate    |
    #| UserFirstName |
    #| UserLastName  |
    #| UserName      |
    #| Action        |
    #| FacilityId    |
    #Then the data should match on screen and excel "TC0998_2.csv" for all records
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

  @TC0999
  Scenario Outline: TC0999 - Verify that H-admin can download the audit log records based on multiple filter applied
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
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
    And the export selected button shall be "disabled"
    And the export all button shall be "enabled"
    When the user selects one record
    Then the record should be selected
    And the export selected button shall be "enabled"
    When the user clicks on export selected button
    Then the details of selected records should get download in following columns for excel sheet "TC0999_1.csv"
      | header        |
      | ActionDate    |
      | UserFirstName |
      | UserLastName  |
      | UserName      |
      | Action        |
    #| FacilityId    |
    Then the data should match on screen and excel "TC0999_1.csv" for selected record
    When the user unselects one record
    #When the user clicks on Export All button
    #Then the details of selected records should get download in following columns for excel sheet "TC0999_2.csv"
    #| header        |
    #| ActionDate    |
    #| UserFirstName |
    #| UserLastName  |
    #| UserName      |
    #| Action        |
    #| FacilityId    |
    #Then the data should match on screen and excel "TC0999_2.csv" for all records
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

  @TC1000
  Scenario Outline: TC1000 - Verify that H-admin can able to download the audit log records based on search criteria
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
    #Then the audit log record for Hospital account should only be displayed
    Then All the records should display in descending order based on Date Time column
    When the user searchs a user in search box and click on search button
    Then records should be displayed based on username search
    And the export selected button shall be "disabled"
    And the export all button shall be "enabled"
    When the user selects one record
    Then the record should be selected
    And the export selected button shall be "enabled"
    When the user clicks on export selected button
    Then the details of selected records should get download in following columns for excel sheet "TC1000_1.csv"
      | header        |
      | ActionDate    |
      | UserFirstName |
      | UserLastName  |
      | UserName      |
      | Action        |
    #| FacilityId    |
    Then the data should match on screen and excel "TC1000_1.csv" for selected record
    When the user unselects one record
    #When the user clicks on Export All button
    #Then the details of selected records should get download in following columns for excel sheet "TC1000_2.csv"
    #| header        |
    #| ActionDate    |
    #| UserFirstName |
    #| UserLastName  |
    #| UserName      |
    #| Action        |
    #| FacilityId    |
    #Then the data should match on screen and excel "TC1000_2.csv" for all records
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

  @TC1001
  Scenario Outline: TC1001 - Verify that H-admin can download the audit log records based on sorting applied
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
    #Then the audit log record for Hospital account should only be displayed
    Then All the records should display in descending order based on Date Time column
    #When the user clicks on the sort arrow for user column
    #Then the list should get sorted out in "descending" order of  User column
    #When the user clicks on the sort arrow for user column
    #Then the list should get sorted out in "ascending" order of  User column
    And the export selected button shall be "disabled"
    And the export all button shall be "enabled"
    When the user selects one record
    Then the record should be selected
    And the export selected button shall be "enabled"
    When the user clicks on export selected button
    Then the details of selected records should get download in following columns for excel sheet "TC1001_1.csv"
      | header        |
      | ActionDate    |
      | UserFirstName |
      | UserLastName  |
      | UserName      |
      | Action        |
    #| FacilityId    |
    Then the data should match on screen and excel "TC1001_1.csv" for selected record
    When the user unselects one record
    #When the user clicks on Export All button
    #Then the details of selected records should get download in following columns for excel sheet "TC1001_2.csv"
    #| header        |
    #| ActionDate    |
    #| UserFirstName |
    #| UserLastName  |
    #| UserName      |
    #| Action        |
    #| FacilityId    |
    #Then the data should match on screen and excel "TC1001_2.csv" for all records
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

  @TC1002
  Scenario Outline: TC1002 - Verify that H-admin can download the audit log records based on entered filter, sorting and search criteria
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
    Then the audit log record for Hospital account should only be displayed
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
    And the export selected button shall be "disabled"
    And the export all button shall be "enabled"
    When the user selects one record
    Then the record should be selected
    And the export selected button shall be "enabled"
    When the user clicks on export selected button
    Then the details of selected records should get download in following columns for excel sheet "TC1002_1.csv"
      | header        |
      | ActionDate    |
      | UserFirstName |
      | UserLastName  |
      | UserName      |
      | Action        |
    #| FacilityId    |
    Then the data should match on screen and excel "TC1002_1.csv" for selected record
    When the user unselects one record
    #When the user clicks on Export All button
    #Then the details of selected records should get download in following columns for excel sheet "TC1002_2.csv"
    #| header        |
    #| ActionDate    |
    #| UserFirstName |
    #| UserLastName  |
    #| UserName      |
    #| Action        |
    #| FacilityId    |
    #Then the data should match on screen and excel "TC1002_2.csv" for all records
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |
      

  @TC1004
  Scenario Outline: TC1004 - Verify non-admin users can not view and download the audit logs for hospital account
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    Then the Audit login option should not be displayed
    And Data-Upload Application is closed

    Examples: 
      | user                               |
      | ic-test-surgeon@capgemini.com      |
      | ic-test-tech@capgemini.com         |
      | ic-test-supportstaff@capgemini.com |

  @TC1005
  Scenario Outline: TC1005 - Verify Export all should not export single record
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
    #Then the audit log record for Hospital account should only be displayed
    And the export selected button shall be "disabled"
    And the export all button shall be "enabled"
    When the user selects one record
    And the user clicks on Export All button
    #Then the Application should download all the records and ignore the selected records "TC1005.csv"
    #Then following columns should be there in excel sheet "TC1005.csv"
      #| header        |
      #| ActionDate    |
      #| UserFirstName |
      #| UserLastName  |
      #| UserName      |
      #| Action        |
    #| FacilityId    |
    #Then the data should match on screen and excel "TC1005.csv"
    And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

   @TC1006
  Scenario Outline: TC1006 - Verify Export all should not export single record when filter applied
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
    #Then the audit log record for Hospital account should only be displayed
    And the export selected button shall be "disabled"
    And the export all button shall be "enabled"
    When the user selects one record
    And the user clicks on Export All button
    #Then the Application should download all the records and ignore the selected records "TC1006_1.csv"
    #Then following columns should be there in excel sheet "TC1006_1.csv"
      #| header        |
      #| ActionDate    |
      #| UserFirstName |
      #| UserLastName  |
      #| UserName      |
      #| Action        |
    #| FacilityId    |
    #Then the data should match on screen and excel "TC1006_1.csv"
    When the user clicks on 24hrs filter
    When the user selects one record
    And the user clicks on Export All button
    #Then the Application should download all the records and ignore the selected records "TC1006_2.csv"
    #Then following columns should be there in excel sheet "TC1006_2.csv"
      #| header        |
      #| ActionDate    |
      #| UserFirstName |
      #| UserLastName  |
      #| UserName      |
      #| Action        |
    #| FacilityId    |
    #Then the data should match on screen and excel "TC1006_2.csv"
    When the user clicks on the sort arrow for user column
    Then the list should get sorted out in "descending" order of  User column
     When the user selects one record
    And the user clicks on Export All button
    #Then the Application should download all the records and ignore the selected records "TC1006_3.csv"
    #Then following columns should be there in excel sheet "TC1006_3.csv"
      #| header        |
      #| ActionDate    |
      #| UserFirstName |
      #| UserLastName  |
      #| UserName      |
      #| Action        |
    #| FacilityId    |
    #Then the data should match on screen and excel "TC1006_3.csv"
    When the user clicks on the sort arrow for user column
    Then the list should get sorted out in "ascending" order of  User column
     When the user selects one record
    And the user clicks on Export All button
    #Then the Application should download all the records and ignore the selected records "TC1006_4.csv"
    #Then following columns should be there in excel sheet "TC1006_4.csv"
      #| header        |
      #| ActionDate    |
      #| UserFirstName |
      #| UserLastName  |
      #| UserName      |
      #| Action        |
    #| FacilityId    |
    #Then the data should match on screen and excel "TC1006_4.csv"
    
    When the user clicks on filter button on audit log
    And the user clicks on date filter option
    And the user clicks on start date button
    And the user selects start date lesser than end date
    And the user clicks on end date button
    And the user selects greater end date than start date
    When the user clicks on user name filer
    And the user selects H-admin user name and click on done
    Then the list is filterd on start date, end date and user name
    When the user selects one record
    And the user clicks on Export All button
    #Then the Application should download all the records and ignore the selected records "TC1006_5.csv"
    #Then following columns should be there in excel sheet "TC1006_5.csv"
      #| header        |
      #| ActionDate    |
      #| UserFirstName |
      #| UserLastName  |
      #| UserName      |
      #| Action        |
    #| FacilityId    |
    #Then the data should match on screen and excel "TC1006_5.csv"
    #
    When the user searchs a user in search box and click on search button
    Then records should be displayed based on username search
    When the user selects one record
    And the user clicks on Export All button
    #Then the Application should download all the records and ignore the selected records "TC1006_6.csv"
    #Then following columns should be there in excel sheet "TC1006_6.csv"
      #| header        |
      #| ActionDate    |
      #| UserFirstName |
      #| UserLastName  |
      #| UserName      |
      #| Action        |
    #| FacilityId    |
    #Then the data should match on screen and excel "TC1006_6.csv"
    
     Examples: 
      | user                       |
      | h-test-admin@capgemini.com |
    

    
    
      