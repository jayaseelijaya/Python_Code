Feature: SSR3693 - Verify View Details functionality on History Screen for different users

  @history_TC2880
  Scenario Outline: TC2880 - IC Admin_Verify View Details functionality on History screen
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    #step2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #step3
    When Clicks on Upload Button
    Then the Site selection screen is displayed
    #step4
    When the user selects a site and click next button
    #step5
    When the user selects a surgeon and click next button
    #step6
    When the user selects an application and click next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #step7
    When the user clicks on Browse PC button and select a valid DICOM file and upload
    Then Upload successful screen is displayed
    #step8
    When User clicks on Upload Status button from homepage
    #step9
    Then User checks upload status most recent entry
    #step10
    And User clicks first entry in upload status page
    Then User clicks view details button in upload status page
    #step11
    And The view details success screen shows the check image
    And The view details success screen shows the successful upload text
    And The view details success screen shows the close button
    And The view details success screen shows the new upload button
    And The view details success screen shows the dashboard button
    #step12
    When User clicks on History button from homepage
    #step17
    Then the user clicks on the first entry in the history page
    And the user clicks the view details button in the history page
    Then print the id of the entry
    And check the total file size of the entry
    And print the uploader of the entry
    And check the patient of the entry
    And print the doctor of the entry
    And print the organization of the entry
    And check the application of the entry
    And print the upload begin of the entry
    And print the upload end of the entry
    And print the new status of the entry
    #step18
    And the upload id from view details shall be matched with history screen
    #step20
    And the uploader name from view details shall be matched with history screen
    #step21
    And the patient from view details shall be matched with history screen
    #step22
    And the doctor from view details shall be matched with history screen
    #step23
    And the organization from view details shall be matched with history screen
    #step27
    And the new status from view details shall be matched with history screen
    #step29,30
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |

  @history_TC2882
  Scenario Outline: TC2882 - IC Technician_Verify View Details functionality on History screen
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    #step2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #step3
    When Clicks on Upload Button
    Then the Site selection screen is displayed
    #step4
    When the user selects a site and click next button
    #step5
    When the user selects a surgeon and click next button
    #step6
    When the user selects an application and click next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #step7
    When the user clicks on Browse PC button and select a valid DICOM file and upload
    Then Upload successful screen is displayed
    #step8
    When User clicks on Upload Status button from homepage
    #step9
    Then User checks upload status most recent entry
    #step10
    And User clicks first entry in upload status page
    Then User clicks view details button in upload status page
    #step11
    And The view details success screen shows the check image
    And The view details success screen shows the successful upload text
    And The view details success screen shows the close button
    And The view details success screen shows the new upload button
    And The view details success screen shows the dashboard button
    #step12
    When User clicks on History button from homepage
    #step17
    Then the user clicks on the first entry in the history page
    And the user clicks the view details button in the history page
    Then print the id of the entry
    And check the total file size of the entry
    And print the uploader of the entry
    And check the patient of the entry
    And print the doctor of the entry
    And print the organization of the entry
    And check the application of the entry
    And print the upload begin of the entry
    And print the upload end of the entry
    And print the new status of the entry
    #step18
    And the upload id from view details shall be matched with history screen
    #step20
    And the uploader name from view details shall be matched with history screen
    #step21
    And the patient from view details shall be matched with history screen
    #step22
    And the doctor from view details shall be matched with history screen
    #step23
    And the organization from view details shall be matched with history screen
    #step27
    And the new status from view details shall be matched with history screen
    #step29,30
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                       |
      | ic-test-user@capgemini.com |

  @history_TC2883
  Scenario Outline: TC2883 - Hospital Admin_Verify View Details functionality on History screen
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    #step2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #step3
    When Clicks on Upload Button
    Then the Site selection screen is displayed
    #step4
    When the user selects a site and click next button
    #step5
    When the user selects a surgeon and click next button
    #step6
    When the user selects an application and click next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #step7
    When the user clicks on Browse PC button and select a valid DICOM file and upload
    Then Upload successful screen is displayed
    #step8
    When User clicks on Upload Status button from homepage
    #step9
    Then User checks upload status most recent entry
    #step10
    And User clicks first entry in upload status page
    Then User clicks view details button in upload status page
    #step11
    And The view details success screen shows the check image
    And The view details success screen shows the successful upload text
    And The view details success screen shows the close button
    And The view details success screen shows the new upload button
    And The view details success screen shows the dashboard button
    #step12
    When User clicks on History button from homepage
    #step17
    Then the user clicks on the first entry in the history page
    And the user clicks the view details button in the history page
    Then print the id of the entry
    And check the total file size of the entry
    And print the uploader of the entry
    And check the patient of the entry
    And print the doctor of the entry
    And print the organization of the entry
    And check the application of the entry
    And print the upload begin of the entry
    And print the upload end of the entry
    And print the new status of the entry
    #step18
    And the upload id from view details shall be matched with history screen
    #step20
    And the uploader name from view details shall be matched with history screen
    #step21
    And the patient from view details shall be matched with history screen
    #step22
    And the doctor from view details shall be matched with history screen
    #step23
    And the organization from view details shall be matched with history screen
    #step27
    And the new status from view details shall be matched with history screen
    #step29,30
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                                 |
      | ic-test-hospital-admin@capgemini.com |

  @history_TC2884
  Scenario Outline: TC2884 - Surgeon_Verify View Details functionality on History screen
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    #step2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #step3
    When Clicks on Upload Button
    Then the Site selection screen is displayed
    #step4
    When the user selects a site and click next button
    #step5
    When the user selects a surgeon and click next button
    #step6
    When the user selects an application and click next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #step7
    When the user clicks on Browse PC button and select a valid DICOM file and upload
    Then Upload successful screen is displayed
    #step8
    When User clicks on Upload Status button from homepage
    #step9
    Then User checks upload status most recent entry
    #step10
    And User clicks first entry in upload status page
    Then User clicks view details button in upload status page
    #step11
    And The view details success screen shows the check image
    And The view details success screen shows the successful upload text
    And The view details success screen shows the close button
    And The view details success screen shows the new upload button
    And The view details success screen shows the dashboard button
    #step12
    When User clicks on History button from homepage
    #step17
    Then the user clicks on the first entry in the history page
    And the user clicks the view details button in the history page
    Then print the id of the entry
    And check the total file size of the entry
    And print the uploader of the entry
    And check the patient of the entry
    And print the doctor of the entry
    And print the organization of the entry
    And check the application of the entry
    And print the upload begin of the entry
    And print the upload end of the entry
    And print the new status of the entry
    #step18
    And the upload id from view details shall be matched with history screen
    #step20
    And the uploader name from view details shall be matched with history screen
    #step21
    And the patient from view details shall be matched with history screen
    #step22
    And the doctor from view details shall be matched with history screen
    #step23
    And the organization from view details shall be matched with history screen
    #step27
    And the new status from view details shall be matched with history screen
    #step29,30
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                          |
      | ic-test-surgeon@capgemini.com |

  @history_TC2885
  Scenario Outline: TC2885 - Support Staff_Verify View Details functionality on History screen
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And Homepage is displayed to the user
    #step2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #step3
    When Clicks on Upload Button
    Then the Site selection screen is displayed
    #step4
    When the user selects a site and click next button
    #step5
    When the user selects a surgeon and click next button
    #step6
    When the user selects an application and click next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #step7
    When the user clicks on Browse PC button and select a valid DICOM file and upload
    Then Upload successful screen is displayed
    #step8
    When User clicks on Upload Status button from homepage
    #step9
    Then User checks upload status most recent entry
    #step10
    And User clicks first entry in upload status page
    Then User clicks view details button in upload status page
    #step11
    And The view details success screen shows the check image
    And The view details success screen shows the successful upload text
    And The view details success screen shows the close button
    And The view details success screen shows the new upload button
    And The view details success screen shows the dashboard button
    #step12
    When User clicks on History button from homepage
    #step17
    Then the user clicks on the first entry in the history page
    And the user clicks the view details button in the history page
    Then print the id of the entry
    And check the total file size of the entry
    And print the uploader of the entry
    And check the patient of the entry
    And print the doctor of the entry
    And print the organization of the entry
    And check the application of the entry
    And print the upload begin of the entry
    And print the upload end of the entry
    And print the new status of the entry
    #step18
    And the upload id from view details shall be matched with history screen
    #step20
    And the uploader name from view details shall be matched with history screen
    #step21
    And the patient from view details shall be matched with history screen
    #step22
    And the doctor from view details shall be matched with history screen
    #step23
    And the organization from view details shall be matched with history screen
    #step27
    And the new status from view details shall be matched with history screen
    #step29,30
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                        |
      | ic-test-staff@capgemini.com |

  @history_TC3532
  Scenario Outline: TC3532 - S&N HIL Manager_Verify View Details functionality on History screen
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    Then Homepage is displayed to the user
    And Choose Site screen is displayed
    Then Search for hospital
    When clicks on any of the faclity from the facility selection screen
    And click on select button
    Then Upload dashboad page is displayed to user
    #step2
    When User clicks on Upload Files from left panel
    Then the upload icon and Upload button are displayed
    #step3
    When Clicks on Upload Button
    Then the Site selection screen is displayed
    #step4
    When the user selects a site and click next button
    #step5
    When the user selects a surgeon and click next button
    #step6
    When the user selects an application and click next button
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button
    #step7
    When the user clicks on Browse PC button and select a valid DICOM file and upload
    Then Upload successful screen is displayed
    #step8
    When User clicks on Upload Status button from homepage
    #step9
    Then User checks upload status most recent entry
    #step10
    And User clicks first entry in upload status page
    Then User clicks view details button in upload status page
    #step11
    And The view details success screen shows the check image
    And The view details success screen shows the successful upload text
    And The view details success screen shows the close button
    And The view details success screen shows the new upload button
    And The view details success screen shows the dashboard button
    #step12
    When User clicks on History button from homepage
    #step17
    Then the user clicks on the first entry in the history page
    And the user clicks the view details button in the history page
    Then print the id of the entry
    And check the total file size of the entry
    And print the uploader of the entry
    And check the patient of the entry
    And print the doctor of the entry
    And print the organization of the entry
    And check the application of the entry
    And print the upload begin of the entry
    And print the upload end of the entry
    And print the new status of the entry
    #step18
    And the upload id from view details shall be matched with history screen
    #step20
    And the uploader name from view details shall be matched with history screen
    #step21
    And the patient from view details shall be matched with history screen
    #step22
    And the doctor from view details shall be matched with history screen
    #step23
    And the organization from view details shall be matched with history screen
    #step27
    And the new status from view details shall be matched with history screen
    #step29,30
    When the user clicks on exit to app button from left menu bar
    And user clicks on Logout icon from left panel
    Then user is logout from the application.

    Examples: 
      | user                                  |
      | ic-test-snn-hil-manager@capgemini.com |
