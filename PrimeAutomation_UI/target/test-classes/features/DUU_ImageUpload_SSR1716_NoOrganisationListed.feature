
Feature: SSR1716 - Verifying that DUU Data Upload Utility web application shall only allow the selection of organizations that have been added as linked data target organizations.

@ImageUpload_TC3220
Scenario Outline: TC3220 - IC Technician_Verify DUU shall show validation message when no linked organization data available. 
	
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
    And error message is displayed if no data available for linked sites
	When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
	Examples: 
	|user|  
	| ic-test-user@capgemini.com |
	

@ImageUpload_TC3219	 
Scenario Outline: TC3219 - IC Admin_Verify DUU shall show validation message when no linked organization data available.
 
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
    And error message is displayed if no data available for linked sites
	When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
	Examples: 
	|user|  
	| ic-test-admin@capgemini.com |


@ImageUpload_TC3221	 
Scenario Outline: TC3221 - Hospital Admin_Verify DUU shall show validation message when no linked organization data available.
 
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
    And error message is displayed if no data available for linked sites
	When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
	Examples: 
	|user|  
	| ic-test-hospital-admin@capgemini.com |
	

@ImageUpload_TC3222 
Scenario Outline: TC3222 - Surgeon_Verify DUU shall show validation message when no linked organization data available.
 
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
    And error message is displayed if no data available for linked sites
	When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
	Examples: 
	|user|  
	| ic-test-surgeon@capgemini.com |
	
@ImageUpload_TC3223 
Scenario Outline: TC3223 - Support staff_Verify DUU shall show validation message when no linked organization data available.
 
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
    And error message is displayed if no data available for linked sites
	When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
    
	Examples: 
	|user|  
	| ic-test-staff@capgemini.com |
