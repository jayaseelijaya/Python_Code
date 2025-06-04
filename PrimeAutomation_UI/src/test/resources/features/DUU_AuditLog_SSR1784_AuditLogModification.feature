
Feature: SSR1784 - Verifying DUU web app  audit log shall not be user modifiable. 

Scenario Outline: TC0892 - Verify DUU web app audit log for all facilities shall shall not be user modifiable by IC-Admin, S&N HIL Manager, Hospital Admin 

	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>" 
	And below components is displayed on left side panel
	|screen |
	#|Choose Site |
	|File Dashboard |
	|History |
	|Audit Log |
	|Imaging Links |
	When SN user click on any facility from list
	And clicks on Select button
	Then Upload dashboard page is displayed
	When user clicks on Audit log from left panel
	Then Audit log page should be displayed with below components
	|screen |
	| 24 Hrs |
	| Filter |
	| Search box |
	| Search |
	| Events |
	| Export Selected |
	| Export all |
	| Show more |
	| Scroll bar |
	And records are displayed in the audit log page
	When user select any record from the audit log screen
	Then user should not be able to edit any details from the selected record
	And Data-Upload Application is closed 
	
	Examples: 
		|user|  
		|ic-test-snhilmanager@capgemini.com |
		#|ic-test-admin@capgemini.com|
		#|h-test-admin@capgemini.com |
		
		
Scenario Outline: TC01052 - Verify DUU web app audit log is not modifiable by IC-Admin, S&N HIL Manager, Hospital Admin 

	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>" 
	And below components is displayed on left side panel
	|screen |
	#|Choose Site |
	|File Dashboard |
	|History |
	|Audit Log |
	|Imaging Links |
	When SN user click on any facility from list
	And clicks on Select button
	Then Upload dashboard page is displayed
	When user clicks on Audit log from left panel
	Then Audit log page should be displayed with below components
	|screen |
	| 24 Hrs |
	| Filter |
	| Search box |
	| Search |
	| Events |
	| Export Selected |
	| Export all |
	| Show more |
	| Scroll bar |
	And records are displayed in the audit log page
	When user select any record from the audit log screen
	Then cross icon should not be available for the selected record
	And Data-Upload Application is closed 
	
	Examples: 
		|user|  
		|ic-test-snhilmanager@capgemini.com |
		#|ic-test-admin@capgemini.com|
		#|h-test-admin@capgemini.com |