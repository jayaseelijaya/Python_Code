
Feature: SSR1801 - Verifying UI of facility selection screen

Scenario Outline: TC0701 - Verify the UI of facility selection modal

 Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
	Then Homepage is displayed 
	When User clicks on Upload files button from left menu bar 
	And than user clicks on Upload File 
	Then Search facility screen is displayed with back and next button
	And the upload files header shall be displayed
	And where are you working today text shall be displayed
	And Search site heading shall be displayed
	And the search box shall be displayed
	And the text of search box shall be displayed
	#And I don't see my listed site link shall be displayed
	And x button shall be displayed
	And the following information shall be displayed at left navigation bar
	  | infomation  		|
	  | SN logo					|
	  | Profile image		|
	  | File dashboard	|
	  | Upload files		|
	  | Upload status		|
	  | History					|
	  | Audit log				|
	  | imaging links		|
	  | settings				|
	  | Exit to app 		|
	And Data-Upload Application is closed 
 
 Examples: 
		|user|  
		|ic-test-admin@capgemini.com |
		#|ic-test-tech@capgemini.com |
		#|ic-test-nurse@capgemini.com |
		#|ic-test-surgeon@capgemini.com |
		