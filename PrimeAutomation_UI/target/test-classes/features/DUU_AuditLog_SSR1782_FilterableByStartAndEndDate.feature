Feature: SSR1782 - Verifying History view is filterable based on start date and end date time stamp

Scenario Outline: TC0891 - Verify DDU web App shall filterable as start date
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
  | header		|
  | date			|
  | user			|
  | username	|
  | action		|
And the audit log records shall be displayed
And the export selected button shall be displayed
And the export all button shall be displayed
And the scrollbar shall be displayed on audit log at right side
And the show more button shall be displayed on audit log
When the user clicks on filter button on audit log
And the user clicks on date filter option
And the user clicks on start date button
And the user selects current date as start date
And the user clicks on done button to close the filter option
Then end date shall be selected as current date by default
And the audit log records shall be filtered as per current date
When the user clicks on filter button on audit log
And the user clicks on date filter option
Then the start date shall be displayed as current date
And the user clicks on start date button
When the user selects start date less than current date
And the user clicks on done button to close the filter option
Then the audit log records shall be filtered as per selected start date
And Data-Upload Application is closed


Examples: 
		|user|  
		|ic-test-admin@capgemini.com |
		#|ic-test-tech@capgemini.com |
		#|ic-test-nurse@capgemini.com |
		#|ic-test-surgeon@capgemini.com |

Scenario Outline: TC1016 - Verify DDU web App shall filterable by end date
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
  | header		|
  | date			|
  | user			|
  | username	|
  | action		|
And the audit log records shall be displayed
And the export selected button shall be displayed
And the export all button shall be displayed
And the scrollbar shall be displayed on audit log at right side
And the show more button shall be displayed on audit log
When the user clicks on filter button on audit log
And the user clicks on date filter option
And the user clicks on end date button
And the user selects end date as current date
And the user clicks on done button to close the filter option
And the audit log records shall be filtered as per current date as end date
When the user clicks on filter button on audit log
And the user clicks on date filter option
Then the start date shall display no date if date is not selected
And the end date shall be displayed as current date
When the user clicks on end date button
And the user selects end date less than current date
And the user clicks on done button to close the filter option
Then the audit log records shall be filtered as per selected new end date
And Data-Upload Application is closed

Examples: 
		|user|  
		|ic-test-admin@capgemini.com |
		#|ic-test-tech@capgemini.com |
		#|ic-test-nurse@capgemini.com |
		#|ic-test-surgeon@capgemini.com |

Scenario Outline: TC1017 - Verify DDU web App audit log shall be filterable by lesser end date than current date
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
  | header		|
  | date			|
  | user			|
  | username	|
  | action		|
And the audit log records shall be displayed
And the export selected button shall be displayed
And the export all button shall be displayed
And the scrollbar shall be displayed on audit log at right side
And the show more button shall be displayed on audit log
When the user clicks on filter button on audit log
And the user clicks on date filter option
And the user clicks on start date button
And the user selects start date less than current date
And the user clicks on end date button
And the user selects end date less than current date
And the user clicks on done button to close the filter option
Then the audit log records shall be filtered as per lesser start date and end date
And Data-Upload Application is closed

Examples: 
		|user|  
		|ic-test-admin@capgemini.com |
		#|ic-test-tech@capgemini.com |
		#|ic-test-nurse@capgemini.com |
		#|ic-test-surgeon@capgemini.com |

Scenario Outline: TC1018 - Verify DDU web App shall display no date in start date if not selected any date
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
  | header		|
  | date			|
  | user			|
  | username	|
  | action		|
And the audit log records shall be displayed
And the export selected button shall be displayed
And the export all button shall be displayed
And the scrollbar shall be displayed on audit log at right side
And the show more button shall be displayed on audit log
When the user clicks on filter button on audit log
And the user clicks on date filter option
And the user clicks on end date button
And the user selects end date as current date 
And the user clicks on done button to close the filter option
Then the audit log records shall be filtered as selected end date
When the user clicks on filter button on audit log
And the user clicks on date filter option
Then the start date shall display no date if date is not selected
And Data-Upload Application is closed



Examples: 
		|user|  
		|ic-test-admin@capgemini.com |
		#|ic-test-tech@capgemini.com |
		#|ic-test-nurse@capgemini.com |
		#|ic-test-surgeon@capgemini.com |
		

Scenario Outline: TC1019 - Verify DDU web App shall display no date in end date if not selected any date
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
  | header		|
  | date			|
  | user			|
  | username	|
  | action		|
And the audit log records shall be displayed
And the export selected button shall be displayed
And the export all button shall be displayed
And the scrollbar shall be displayed on audit log at right side
And the show more button shall be displayed on audit log
When the user clicks on filter button on audit log
And the user clicks on date filter option
And the user clicks on start date button
And the user selects current date as start date 
And the user clicks on done button to close the filter option
Then the audit log records shall be filtered as selected start date
When the user clicks on filter button on audit log
And the user clicks on date filter option
Then the end date shall display no date if date is not selected
And Data-Upload Application is closed
		
		
Examples: 
		|user|  
		|ic-test-admin@capgemini.com |
		#|ic-test-tech@capgemini.com |
		#|ic-test-nurse@capgemini.com |
		#|ic-test-surgeon@capgemini.com |
		
					
Scenario Outline: TC1020 - Verify DDU web App audit log shall be filterable by start date and end date
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
  | header		|
  | date			|
  | user			|
  | username	|
  | action		|
And the audit log records shall be displayed
And the export selected button shall be displayed
And the export all button shall be displayed
And the scrollbar shall be displayed on audit log at right side
And the show more button shall be displayed on audit log
When the user clicks on filter button on audit log
And the user clicks on date filter option
And the user clicks on start date button
And the user selects current date as start date
And the user clicks on end date button
And the user selects end date as current date
And the user clicks on done button to close the filter option
Then the audit log records shall be filtered as current start and end date
When the user clicks on filter button on audit log
And the user clicks on date filter option
And the user clicks on start date button
And the user selects start date lesser than end date
And the user clicks on end date button
And the user selects end date as current date 
And the user clicks on done button to close the filter option
Then the audit log records shall be filtered as current start and end date
When the user clicks on filter button on audit log
And the user clicks on date filter option
Then the selected start date and end date shall be displayed
And the user clicks on start date button
And the user selects lesser start date than current date
And the user clicks on end date button
And the user selects greater end date than start date
And the user clicks on done button to close the filter option
Then the audit log records shall be filtered as per selected lesser start and greater end date
When the user clicks on date column to sort the table
Then the audit log records shall be sorted in ascending order
And Data-Upload Application is closed

Examples: 
		|user|  
		|ic-test-admin@capgemini.com |
		#|ic-test-tech@capgemini.com |
		#|ic-test-nurse@capgemini.com |
		#|ic-test-surgeon@capgemini.com |
		
		
Scenario Outline: TC1021 - Verify DDU web App audit log shall not be filterable as per greater start date than end date 
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
  | header		|
  | date			|
  | user			|
  | username	|
  | action		|
And the audit log records shall be displayed
And the export selected button shall be displayed
And the export all button shall be displayed
And the scrollbar shall be displayed on audit log at right side
And the show more button shall be displayed on audit log
When the user clicks on filter button on audit log
And the user clicks on date filter option
And the user clicks on start date button
And the user selects greater date in start date
And the user clicks on end date button
And the user selects lesser date in end date
And Data-Upload Application is closed


Examples: 
		|user|  
		|ic-test-admin@capgemini.com |
		#|ic-test-tech@capgemini.com |
		#|ic-test-nurse@capgemini.com |
		#|ic-test-surgeon@capgemini.com |
		
	
Scenario Outline: TC1022 - Verify DDU web App audit log shall not be filterable as per greater start date than current date 
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
  | header		|
  | date			|
  | user			|
  | username	|
  | action		|
And the audit log records shall be displayed
And the export selected button shall be displayed
And the export all button shall be displayed
And the scrollbar shall be displayed on audit log at right side
And the show more button shall be displayed on audit log
When the user clicks on filter button on audit log
And the user clicks on date filter option
And the user clicks on start date button
And the user selects start date greater than current date
And Data-Upload Application is closed


Examples: 
		|user|  
		|ic-test-admin@capgemini.com |
		#|ic-test-tech@capgemini.com |
		#|ic-test-nurse@capgemini.com |
		#|ic-test-surgeon@capgemini.com |
		
	
Scenario Outline: TC1023 - Verify DDU web App audit log shall not be filterable as per greater end date than current date 
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
  | header		|
  | date			|
  | user			|
  | username	|
  | action		|
And the audit log records shall be displayed
And the export selected button shall be displayed
And the export all button shall be displayed
And the scrollbar shall be displayed on audit log at right side
And the show more button shall be displayed on audit log
When the user clicks on filter button on audit log
And the user clicks on date filter option
And the user clicks on end date button
And the user selects end date greater than current date
And Data-Upload Application is closed


Examples: 
		|user|  
		|ic-test-admin@capgemini.com |
		#|ic-test-tech@capgemini.com |
		#|ic-test-nurse@capgemini.com |
		#|ic-test-surgeon@capgemini.com |

		
Scenario Outline: TC1024 - Verify DDU web App audit log shall unselect a selected start date and end date 
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
  | header		|
  | date			|
  | user			|
  | username	|
  | action		|
And the audit log records shall be displayed
And the export selected button shall be displayed
And the export all button shall be displayed
And the scrollbar shall be displayed on audit log at right side
And the show more button shall be displayed on audit log
When the user clicks on filter button on audit log
And the user clicks on date filter option
And the user clicks on start date button
And the user selects current date as start date
And the user clicks on end date button
And the user selects end date as current date
And the user clicks on done button to close the filter option
Then the audit log records shall be filtered as current start and end date
When the user clicks on filter button on audit log
And the user clicks on date filter option
#And the user clicks on clear button  #PRSAMD-2205 - feature yet to be implemented
#And the user clicks on done button to close the filter option
#When the user clicks on filter button on audit log
#And the user clicks on date filter option
#Then the selected start and end date shall be unselected
And Data-Upload Application is closed


Examples: 
		|user|  
		|ic-test-admin@capgemini.com |
		#|ic-test-tech@capgemini.com |
		#|ic-test-nurse@capgemini.com |
		#|ic-test-surgeon@capgemini.com |				
		