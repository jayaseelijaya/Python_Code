
Feature: SSR1720 - Verifying that DUU web app shall allow selection of application that have been associated with selected facility/surgeon.

@A
Scenario Outline: TC3252 - IC Admin_Verify user is not able to begin with data upload if application is not selected.
	
	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
	And Upload dashboad page is displayed to user
	When User clicks on Upload Files from left panel
	Then the upload icon and Upload button are displayed
	When Clicks on Upload Button
	Then the Site selection screen is displayed with
    | Components                                      |
    | Where are you working today                     |
    | Search box is displayed with header Search Site |
    | Enter Keyword or Name of Site                   |
    | list of linked sites                            |
    | Back and Next buttons                           |
    | I dont see my Site listed                       |
    When the user selects a site and click on next button
	And the Surgeon selection screen is displayed with
     | Components                                         |
     | Which surgeon are you supporting                   |
     | Search box is displayed with header Search Surgeon |
     | Enter First or Last Name of Surgeon                |
     | list of linked surgeons                            |
     | close icon                                         |
     | Back and Next buttons                              |
     | I dont see my Surgeon listed                       |
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    Then Application card is displayed as not selected if there is more than one card
	And user doesn't select any card & verifies the Next button
	When user selects one application card 
	Then verify other application card should be in unselected mode
	When user selects another application card
	Then verify other application card should be in unselected mode
	When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

	Examples: 
	|user|  
	|ic-test-admin@capgemini.com |
	


Scenario Outline: TC3253 - IC Technician_Verify user is not able to begin with data upload if application is not selected.
	
	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
	And Upload dashboad page is displayed to user
	When User clicks on Upload Files from left panel
	Then the upload icon and Upload button are displayed
	When Clicks on Upload Button
	Then the Site selection screen is displayed with
    | Components                                      |
    | Where are you working today                     |
    | Search box is displayed with header Search Site |
    | Enter Keyword or Name of Site                   |
    | list of linked sites                            |
    | Back and Next buttons                           |
    | I dont see my Site listed                       |
    When the user selects a site and click on next button
	And the Surgeon selection screen is displayed with
     | Components                                         |
     | Which surgeon are you supporting                   |
     | Search box is displayed with header Search Surgeon |
     | Enter First or Last Name of Surgeon                |
     | list of linked surgeons                            |
     | close icon                                         |
     | Back and Next buttons                              |
     | I dont see my Surgeon listed                       |
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    Then Application card is displayed as not selected if there is more than one card
	And user doesn't select any card & verifies the Next button
	When user selects one application card 
	Then verify other application card should be in unselected mode
	When user selects another application card
	Then verify other application card should be in unselected mode
	When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

	Examples: 
	|user|  
	|ic-test-user@capgemini.com |

Scenario Outline: TC3254 -  Hospital admin_Verify user is not able to begin with data upload if application is not selected.
	
	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
	And Upload dashboad page is displayed to user
	When User clicks on Upload Files from left panel
	Then the upload icon and Upload button are displayed
	When Clicks on Upload Button
	Then the Site selection screen is displayed with
    | Components                                      |
    | Where are you working today                     |
    | Search box is displayed with header Search Site |
    | Enter Keyword or Name of Site                   |
    | list of linked sites                            |
    | Back and Next buttons                           |
    | I dont see my Site listed                       |
    When the user selects a site and click on next button
	And the Surgeon selection screen is displayed with
     | Components                                         |
     | Which surgeon are you supporting                   |
     | Search box is displayed with header Search Surgeon |
     | Enter First or Last Name of Surgeon                |
     | list of linked surgeons                            |
     | close icon                                         |
     | Back and Next buttons                              |
     | I dont see my Surgeon listed                       |
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    Then Application card is displayed as not selected if there is more than one card
	And user doesn't select any card & verifies the Next button
	When user selects one application card 
	Then verify other application card should be in unselected mode
	When user selects another application card
	Then verify other application card should be in unselected mode
	When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

	Examples: 
	|user|  
	|ic-test-hospital-admin@capgemini.com |


Scenario Outline: TC3255 - Surgeon_Verify user is not able to begin with data upload if application is not selected.
	
	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
	And Upload dashboad page is displayed to user
	When User clicks on Upload Files from left panel
	Then the upload icon and Upload button are displayed
	When Clicks on Upload Button
	Then the Site selection screen is displayed with
    | Components                                      |
    | Where are you working today                     |
    | Search box is displayed with header Search Site |
    | Enter Keyword or Name of Site                   |
    | list of linked sites                            |
    | Back and Next buttons                           |
    | I dont see my Site listed                       |
    When the user selects a site and click on next button
	And the Surgeon selection screen is displayed with
     | Components                                         |
     | Which surgeon are you supporting                   |
     | Search box is displayed with header Search Surgeon |
     | Enter First or Last Name of Surgeon                |
     | list of linked surgeons                            |
     | close icon                                         |
     | Back and Next buttons                              |
     | I dont see my Surgeon listed                       |
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    Then Application card is displayed as not selected if there is more than one card
	And user doesn't select any card & verifies the Next button
	When user selects one application card 
	Then verify other application card should be in unselected mode
	When user selects another application card
	Then verify other application card should be in unselected mode
	When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

	Examples: 
	|user|  
	|ic-test-surgeon@capgemini.com |



Scenario Outline: TC3256 - Support staff _Verify user is not able to begin with data upload if application is not selected.
	
	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
	And Upload dashboad page is displayed to user
	When User clicks on Upload Files from left panel
	Then the upload icon and Upload button are displayed
	When Clicks on Upload Button
	Then the Site selection screen is displayed with
    | Components                                      |
    | Where are you working today                     |
    | Search box is displayed with header Search Site |
    | Enter Keyword or Name of Site                   |
    | list of linked sites                            |
    | Back and Next buttons                           |
    | I dont see my Site listed                       |
    When the user selects a site and click on next button
	And the Surgeon selection screen is displayed with
     | Components                                         |
     | Which surgeon are you supporting                   |
     | Search box is displayed with header Search Surgeon |
     | Enter First or Last Name of Surgeon                |
     | list of linked surgeons                            |
     | close icon                                         |
     | Back and Next buttons                              |
     | I dont see my Surgeon listed                       |
    When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    Then Application card is displayed as not selected if there is more than one card
	And user doesn't select any card & verifies the Next button
	When user selects one application card 
	Then verify other application card should be in unselected mode
	When user selects another application card
	Then verify other application card should be in unselected mode
	When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.

	Examples: 
	|user|  
	|ic-test-staff@capgemini.com |

	
	
Scenario Outline: TC0546 - Verify that notification message is displayed to user if no Application Card associated with selected surgeon.
	
	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
	And Homepage is displayed to the user
	When User clicks on Upload Files from left panel
	And Clicks on Upload Button
	Then Search facility screen is displayed to user along with back and next button
	When User clicks on facility which has surgeon associated
	And user clicks on Next button
	Then surgeon list should be display as per the selected facility
	When user clicks on surgeon which deosn't have application card associated
	And user clicks on Next button after surgeon selection
	Then Notification message should be displayed to user if no application card is present
	And Data-Upload Application is closed 
	
	Examples: 
	|user|  
	|ic-test-admin@capgemini.com |
	#|ic-test-tech@capgemini.com |
	#|ic-test-surgeon@capgemini.com|
	#|ic-test-supportstaff@capgemini.com |
	#|h-test-admin@capgemini.com |