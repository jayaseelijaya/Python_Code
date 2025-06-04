Feature: SSR1783 - Verifying user activity on audit log page

  Scenario Outline: TC0898 - Verify DDU web App audit log  user activity for organization, surgeon, application selection and upload initiated, upload cancelled, upload successful
    #User has manually uploaded the files and then checking log on audit log page
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
    And the following audit log table header shall be displayed
      | header   |
      | date     |
      | user     |
      | username |
      | action   |
    And the audit log shall display file upload action logs performed by user
    Then Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
     #|ic-test-tech@capgemini.com |
     #|ic-test-nurse@capgemini.com |
     #|ic-test-surgeon@capgemini.com |
  Scenario Outline: TC1044 - Verify DDU web App audit log  user activity for recall button
    #User has manually reuploaded the files and then checking summary dashbaord recall button and log on audit log page
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    And the recall button shall be displayed for uploaded files
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
    And the following audit log table header shall be displayed
      | header   |
      | date     |
      | user     |
      | username |
      | action   |
    And the audit log shall display file upload action logs performed by user
    Then Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
     #|ic-test-tech@capgemini.com |
     #|ic-test-nurse@capgemini.com |
     #|ic-test-surgeon@capgemini.com |
  Scenario Outline: TC1046 - Verify DDU web App audit log user activity for recall button, acknowledge button and unread button
    #User has manually uploaded the files and then checking summary dashbaord recall, acknowledge, and unread button and log on audit log page
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    And the recall button shall be displayed for uploaded files
    When the user clicks on recall button
    And the user clicks on acknowedge button
    Then the yellow dot notification shall be disappeared
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
    And the following audit log table header shall be displayed
      | header   |
      | date     |
      | user     |
      | username |
      | action   |
    And the audit log shall display file upload action logs performed by user
    Then Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
     #|ic-test-tech@capgemini.com |
     #|ic-test-nurse@capgemini.com |
     #|ic-test-surgeon@capgemini.com |
  Scenario Outline: TC1048 - Verify DDU web App audit log user activity for image linking
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on imaging links button from left menu bar
    Then the image linking tab shall be displayed
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
    And the following audit log table header shall be displayed
      | header   |
      | date     |
      | user     |
      | username |
      | action   |
    And the audit log shall display file upload action logs performed by user
    Then Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
     #|ic-test-tech@capgemini.com |
     #|ic-test-nurse@capgemini.com |
     #|ic-test-surgeon@capgemini.com |
  Scenario Outline: TC1049 - Verify DDU web App audit log user activity for settings
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on settings button from left menu bar
    And the user changes the value of successful upload
    And the user changes the value of unsuccessful upload
    And the user clicks on gloabl viewing toggle button
    And the user clicks on save button on settings tab
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
    And the following audit log table header shall be displayed
      | header   |
      | date     |
      | user     |
      | username |
      | action   |
    And the audit log shall display file upload action logs performed by user
    Then Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
     #|ic-test-tech@capgemini.com |
     #|ic-test-nurse@capgemini.com |
     #|ic-test-surgeon@capgemini.com |
  Scenario Outline: TC1050 - Verify DDU web App audit log  user activity for dicom images
    #User has manually uploaded the files and then checking log on audit log page
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And the dashboard summary shall display list of upload items
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
    And the following audit log table header shall be displayed
      | header   |
      | date     |
      | user     |
      | username |
      | action   |
    And the audit log shall display file upload action logs performed by user
    Then Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
     #|ic-test-tech@capgemini.com |
     #|ic-test-nurse@capgemini.com |
     #|ic-test-surgeon@capgemini.com |
 
  Scenario Outline: TC1051 - Verify DDU web App audit log  user activity for search and filter
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Upload dashboad page is displayed to user
    When the user enters Lisa text as surgeon name in search box
    And the user clicks on search button
    Then the matching Lisa text as surgeon name list shall be displayed to the user
    When the user removes text in searchbox on dashbaord
    And the user selects 24hrs filters on dashboard
    Then the dashbaord shall display records based on 24hrs filters
    When the user clicks on history button from left menu bar
    Then the history tab shall be displayed
    When the user enters Patrick text as patient name in search box
    And the user clicks on Search Button
    Then the matching Patrick text patient name list shall be displayed
    When user removes search text from search bar on history
    And the user selects 24hrs filter checkbox
    Then the table shall display records based on 24hrs filter
    When the user clicks on audit log button from left menu bar
    Then the audit log tab shall be displayed
    When the user enters ic-test-admin@capgemini.com email as user name in search box
    And the user clicks on Search Button
    Then the matching ic-test-admin@capgemini.com email user name list shall be displayed
    When user removes search text from search bar on auditlog
    And the user selects 24hrs filter on audit log
    And the following audit log table header shall be displayed
    | header   |
    | date     |
    | user     |
    | username |
    | action   |
    And the audit log shall display file upload action logs performed by user
    Then Data-Upload Application is closed
    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
     #|ic-test-tech@capgemini.com |
     #|ic-test-nurse@capgemini.com |
     #|ic-test-surgeon@capgemini.com |
