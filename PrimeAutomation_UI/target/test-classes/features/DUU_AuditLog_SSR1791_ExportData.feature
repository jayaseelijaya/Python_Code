
Feature: SSR1791 - Verifying DUU web app audit log for all facilities shall be downloadable only by Smith and Nephew Admin. 

Scenario Outline: TC0889 - Verify DUU web app audit log for all facilities for all facilities shall be downloadable by Smith and Nephew Admin. 

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
	When user clicks on filter tab
	Then below components is displayed
	|screen |
	| Filter By |
	| Date | 
	| User Name |
	| Done |
	When user clicks on filter tab
	And clicks on Date field
	And click on start and select any date 
	And click on end and select any date
	And clicks on Done button
	Then records are displayed based on date selected
	When user select any record from the audit log screen
	And click on export selected and file should be downloaded
	Then click on export all button
	And file should be downloaded with all data 
	When user removes the filter criteria
	And user clicks on filter tab 
	When user clicks on username field from filter tab
	And select any username
	And clicks on Done button
	Then records is displayed based on filter username
	When user select any record from the audit log screen
	And click on export selected and file should be downloaded
	Then click on export all button
	And file should be downloaded with all data
	When user removes the filter criteria
	And user search with username
	And clicks on Search button 
	Then records should be displayed based on username search criteria
	When user select any record from the audit log screen
	And click on export selected and file should be downloaded
	Then click on export all button
	And file should be downloaded with all data
	When user clears the text from the search box
	And user search with uservalue
	And clicks on Search button 
	Then records should be displayed based on uservalue search criteria
	When user select any record from the audit log screen
	And click on export selected and file should be downloaded
	Then click on export all button
	And file should be downloaded with all data
	When user clears the text from the search box
	And user search with action value
	And clicks on Search button 
	Then records should be displayed based on action value search criteria
	When user select any record from the audit log screen
	And click on export selected and file should be downloaded
	Then click on export all button
	And file should be downloaded with all data
	When user selects two record from audit log screen
	And click on export selected and file should be downloaded
	Then click on export all button
	And file should be downloaded with all data
	And Data-Upload Application is closed 
	
	Examples: 
		|user|  
		|ic-test-snhilmanager@capgemini.com |
	
	
	
	
	
	
	