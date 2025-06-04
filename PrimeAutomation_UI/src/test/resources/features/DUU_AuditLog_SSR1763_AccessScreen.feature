
Feature: SSR1763 - Verifying Data Upload utility shall allow HIL Manager user to access summary dashboard, upload history and user activity logs. 

Scenario Outline: TC0883 - Verify DDU web App shall provide access to Summary dashboard, upload history and user activity logs to HIL Manager.

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
	And upload records are displayed in the page
	When user clicks on Show more button 
	Then upload records are displayed in the page
	When user clicks on filter button from upload dashboard page
	And selects any surgeon for filtering from upload dashboard page
	Then upload records are displayed in the page
	When user removes the filter from the upload dashboard page
	And clicks on quick filter
	Then upload records are displayed in the page
	When user click on Processing quick filer
	And the user enters Lisa text as surgeon name in search box
	And the user clicks on search button
	Then upload records are displayed in the page
	When user clicks on History from left panel
	Then records are displayed on history screen
	When user clicks on filter button from History page
    And selects any patient for filtering from History page
    Then the list shall be filtered as selected patient name
   # Then records are displayed on history screen
    When user removes the filter from the history page
    When the user enters Patrick text as patient name in search box
    And the user clicks on Search Button
    Then the matching Patrick text patient name list shall be displayed
    #When user clicks on hrs quick filter
    Then records are displayed on history screen
    When user selects one record from the list 
    And clicks on View Details 
    Then Record entry page is displayed to the user
	
	Examples: 
		|user|  
		|ic-test-snhilmanager@capgemini.com |
