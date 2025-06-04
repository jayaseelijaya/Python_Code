
Feature: SSR1832 - Verifying History view is searchable and Filterbale by certain fields.
		
@history_TC1120
Scenario Outline: TC1120 - IC Admin_Verify combined search & filter functionalities on history screen.
Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
When the user clicks on history button from left menu bar
Then the history tab shall be displayed
And History label at the top left side is highlighted in white color
And hours checkbox is displayed 
And Filter option is displayed
And Search Box is displayed 
And Search Button is displayed
And Record entry text is displayed at the top
And the below table header shall be displayed on history page
  | header 	   |
  | date	   |
  | upload id  |
  | upload user|
  | patient	   |
  | doctor	   |
  | hospital   |
  | status	   |
And View Details button in disabled mode is displayed
And Show More button is displayed
And list of history records are displayed to user
When the user selects 24hrs filter checkbox
Then the table shall display records based on 24hrs filter
When the user enters a patient first name in search box
And the user clicks on Search Button on history page
Then the entered patient record shall be displayed in 24hrs filter
When the user clicks on filter button in history page
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |	
When clicks on file status & selects any status 
And click on Done button from the filter option
Then the 24hrs checkbox filter shall be removed automatically
And the selected filter shall be displayed at top left section
#And list of history records are displayed to user

When the user clicks on filter button in history page	
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
When clicks on site option & selects any site 
And click on Done button from the filter option
Then list of history records are displayed to user
When the user clicks on filter button in history page	
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
When clicks on uploader option & selects any uploader 
And click on Done button from the filter option
Then list of history records are displayed to user
When the user selects 24hrs filter checkbox
Then the table shall display records based on 24hrs filter
When the user selects 24hrs filter checkbox
Then list of history records are displayed to user
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed


Examples: 
		|user|  
		|ic-test-admin@capgemini.com |

@history_TC2788
Scenario Outline: TC2788 - IC Technician_Verify combined search & filter functionalities on history screen.
Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
When the user clicks on history button from left menu bar
Then the history tab shall be displayed
And History label at the top left side is highlighted in white color
And hours checkbox is displayed 
And Filter option is displayed
And Search Box is displayed 
And Search Button is displayed
And Record entry text is displayed at the top
And the below table header shall be displayed on history page
  | header 	   |
  | date	   |
  | upload id  |
  | upload user|
  | patient	   |
  | doctor	   |
  | hospital   |
  | status	   |
And View Details button in disabled mode is displayed
And Show More button is displayed
And list of history records are displayed to user
When the user selects 24hrs filter checkbox
Then the table shall display records based on 24hrs filter
When the user enters a patient first name in search box
And the user clicks on Search Button on history page
Then the entered patient record shall be displayed in 24hrs filter
When the user clicks on filter button in history page
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |	
When clicks on file status & selects any status 
And click on Done button from the filter option
Then the 24hrs checkbox filter shall be removed automatically
And the selected filter shall be displayed at top left section
#And list of history records are displayed to user

When the user clicks on filter button in history page	
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
When clicks on site option & selects any site 
And click on Done button from the filter option
Then list of history records are displayed to user
When the user clicks on filter button in history page	
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
When clicks on uploader option & selects any uploader 
And click on Done button from the filter option
Then list of history records are displayed to user
When the user selects 24hrs filter checkbox
Then the table shall display records based on 24hrs filter
When the user selects 24hrs filter checkbox
Then list of history records are displayed to user
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed


Examples: 
		|user|  
		|ic-test-tech@capgemini.com |
	

@history_TC2789
Scenario Outline: TC2789 - Hospital Admin_Verify combined search & filter functionalities on history screen.
Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
When the user clicks on history button from left menu bar
Then the history tab shall be displayed
And History label at the top left side is highlighted in white color
And hours checkbox is displayed 
And Filter option is displayed
And Search Box is displayed 
And Search Button is displayed
And Record entry text is displayed at the top
And the below table header shall be displayed on history page
  | header 	   |
  | date	   |
  | upload id  |
  | upload user|
  | patient	   |
  | doctor	   |
  | hospital   |
  | status	   |
And View Details button in disabled mode is displayed
And Show More button is displayed
And list of history records are displayed to user
When the user selects 24hrs filter checkbox
Then the table shall display records based on 24hrs filter
When the user enters a patient first name in search box
And the user clicks on Search Button on history page
Then the entered patient record shall be displayed in 24hrs filter
When the user clicks on filter button in history page
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |	
When clicks on file status & selects any status 
And click on Done button from the filter option
Then the 24hrs checkbox filter shall be removed automatically
And the selected filter shall be displayed at top left section
#And list of history records are displayed to user

When the user clicks on filter button in history page	
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
When clicks on site option & selects any site 
And click on Done button from the filter option
Then list of history records are displayed to user
When the user clicks on filter button in history page	
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
When clicks on uploader option & selects any uploader 
And click on Done button from the filter option
Then list of history records are displayed to user
When the user selects 24hrs filter checkbox
Then the table shall display records based on 24hrs filter
When the user selects 24hrs filter checkbox
Then list of history records are displayed to user
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed


Examples: 
		|user|  
		|h-test-admin@capgemini.com |

@history_TC2790
Scenario Outline: TC2790 - Surgeon_Verify combined search & filter functionalities on history screen.
Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
When the user clicks on history button from left menu bar
Then the history tab shall be displayed
And History label at the top left side is highlighted in white color
And hours checkbox is displayed 
And Filter option is displayed
And Search Box is displayed 
And Search Button is displayed
And Record entry text is displayed at the top
And the below table header shall be displayed on history page
  | header 	   |
  | date	   |
  | upload id  |
  | upload user|
  | patient	   |
  | doctor	   |
  | hospital   |
  | status	   |
And View Details button in disabled mode is displayed
And Show More button is displayed
And list of history records are displayed to user
When the user selects 24hrs filter checkbox
Then the table shall display records based on 24hrs filter
When the user enters a patient first name in search box
And the user clicks on Search Button on history page
Then the entered patient record shall be displayed in 24hrs filter
When the user clicks on filter button in history page
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |	
When clicks on file status & selects any status 
And click on Done button from the filter option
Then the 24hrs checkbox filter shall be removed automatically
And the selected filter shall be displayed at top left section
#And list of history records are displayed to user
When the user clicks on filter button in history page	
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
When clicks on site option & selects any site 
And click on Done button from the filter option
Then list of history records are displayed to user
When the user clicks on filter button in history page	
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
When clicks on uploader option & selects any uploader 
And click on Done button from the filter option
Then list of history records are displayed to user
When the user selects 24hrs filter checkbox
Then the table shall display records based on 24hrs filter
When the user selects 24hrs filter checkbox
Then list of history records are displayed to user
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed


Examples: 
		|user|  
		|ic-test-surgeon@capgemini.com |

@history_TC2791
Scenario Outline: TC2791 - Support-staff_Verify combined search & filter functionalities on history screen.
Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
When the user clicks on history button from left menu bar
Then the history tab shall be displayed
And History label at the top left side is highlighted in white color
And hours checkbox is displayed 
And Filter option is displayed
And Search Box is displayed 
And Search Button is displayed
And Record entry text is displayed at the top
And the below table header shall be displayed on history page
  | header 	   |
  | date	   |
  | upload id  |
  | upload user|
  | patient	   |
  | doctor	   |
  | hospital   |
  | status	   |
And View Details button in disabled mode is displayed
And Show More button is displayed
And list of history records are displayed to user
When the user selects 24hrs filter checkbox
Then the table shall display records based on 24hrs filter
When the user enters a patient first name in search box
And the user clicks on Search Button on history page
Then the entered patient record shall be displayed in 24hrs filter
When the user clicks on filter button in history page
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |	
When clicks on file status & selects any status 
And click on Done button from the filter option
Then the 24hrs checkbox filter shall be removed automatically
And the selected filter shall be displayed at top left section
#And list of history records are displayed to user

When the user clicks on filter button in history page	
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
When clicks on site option & selects any site 
And click on Done button from the filter option
Then list of history records are displayed to user
When the user clicks on filter button in history page	
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
When clicks on uploader option & selects any uploader 
And click on Done button from the filter option
Then list of history records are displayed to user
When the user selects 24hrs filter checkbox
Then the table shall display records based on 24hrs filter
When the user selects 24hrs filter checkbox
Then list of history records are displayed to user
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed

Examples: 
		|user|  
		|ic-test-staff@capgemini.com  |

@history_TC2792
Scenario Outline: TC2792 - S&N HIL Manager_Verify combined search & filter functionalities on history screen.
Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
When the user clicks on history button from left menu bar
Then the history tab shall be displayed
And History label at the top left side is highlighted in white color
And hours checkbox is displayed 
And Filter option is displayed
And Search Box is displayed 
And Search Button is displayed
And Record entry text is displayed at the top
And the below table header shall be displayed on history page
  | header 	   |
  | date	   |
  | upload id  |
  | upload user|
  | patient	   |
  | doctor	   |
  | hospital   |
  | status	   |
And View Details button in disabled mode is displayed
And Show More button is displayed
And list of history records are displayed to user
When the user selects 24hrs filter checkbox
Then the table shall display records based on 24hrs filter
When the user enters a patient first name in search box
And the user clicks on Search Button on history page
Then the entered patient record shall be displayed in 24hrs filter
When the user clicks on filter button in history page
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |	
When clicks on file status & selects any status 
And click on Done button from the filter option
Then the 24hrs checkbox filter shall be removed automatically
And the selected filter shall be displayed at top left section
#And list of history records are displayed to user

When the user clicks on filter button in history page	
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
When clicks on site option & selects any site 
And click on Done button from the filter option
Then list of history records are displayed to user
When the user clicks on filter button in history page	
Then the following filter menu shall be displayed
      | menu        |
      | date        |
      | uploader    |
      | patient     |
      | surgeon     |
      | site        |
      | file status |
When clicks on uploader option & selects any uploader 
And click on Done button from the filter option
Then list of history records are displayed to user
When the user selects 24hrs filter checkbox
Then the table shall display records based on 24hrs filter
When the user selects 24hrs filter checkbox
Then list of history records are displayed to user
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed

Examples: 
		|user|  
		|ic-test-snn-hil-manager@capgemini.com |

@history_TC0882	
Scenario Outline: TC0882 - IC Admin_Verify History records search and filter functionality by Invalid input data.
Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
When the user clicks on history button from left menu bar
Then the history tab shall be displayed
And History label at the top left side is highlighted in white color
And hours checkbox is displayed 
And Filter option is displayed
And Search Box is displayed 
And Search Button is displayed
And Record entry text is displayed at the top
And the below table header shall be displayed on history page
  | header 	   |
  | date	   |
  | upload id  |
  | upload user|
  | patient	   |
  | doctor	   |
  | hospital   |
  | status	   |
And View Details button in disabled mode is displayed
And Show More button is displayed
And list of history records are displayed to user
When the user enters current date in the search box
And the user clicks on Search Button on history page
Then the history view shall be displayed as no data to display
When the user removes text in searchbox
Then the history view table shall be displayed
When the user enter any upload user name in search box from the history screen
And the user clicks on Search Button on history page
Then list of history records are displayed to user
When the user clicks on Filter Option
And click on uploader icon & selects another uploader name
And click on Done button from the filter option
Then the history view shall be displayed as no data to display
When the user removes upload user text from searchbox
And the user clicks on Search Button on history page
#Then list of history records are displayed to user
And user removes the filter from screen
When the user enters any data which is not present in history record in the search box
And the user clicks on Search Button on history page
Then the history view shall be displayed as no data to display
When user removes text from searchbox & click on hours quick filter
Then the history view shall be displayed as no data to display
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed

Examples: 
		|user|  
		|ic-test-admin@capgemini.com |
				

@history_TC1582
Scenario Outline: TC1582 - Surgeon_Verify History records search and filter functionality by Invalid input data.
Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
When the user clicks on history button from left menu bar
Then the history tab shall be displayed
And History label at the top left side is highlighted in white color
And hours checkbox is displayed 
And Filter option is displayed
And Search Box is displayed 
And Search Button is displayed
And Record entry text is displayed at the top
And the below table header shall be displayed on history page
  | header 	   |
  | date	   |
  | upload id  |
  | upload user|
  | patient	   |
  | doctor	   |
  | hospital   |
  | status	   |
And View Details button in disabled mode is displayed
And Show More button is displayed
And list of history records are displayed to user
When the user enters current date in the search box
And the user clicks on Search Button on history page
Then the history view shall be displayed as no data to display
When the user removes text in searchbox
Then the history view table shall be displayed
When the user enter any upload user name in search box from the history screen
And the user clicks on Search Button on history page
Then list of history records are displayed to user
When the user clicks on Filter Option
And click on uploader icon & selects another uploader name
And click on Done button from the filter option
Then the history view shall be displayed as no data to display
When the user removes upload user text from searchbox
And the user clicks on Search Button on history page
#Then list of history records are displayed to user
And user removes the filter from screen
When the user enters any data which is not present in history record in the search box
And the user clicks on Search Button on history page
Then the history view shall be displayed as no data to display
When user removes text from searchbox & click on hours quick filter
Then the history view shall be displayed as no data to display
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed


Examples: 
		|user|  
		|ic-test-surgeon@capgemini.com |
		

@history_TC1581
Scenario Outline: TC1581 - Hospital_Admin_Verify History records search and filter functionality by Invalid input data.
Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
When the user clicks on history button from left menu bar
Then the history tab shall be displayed
And History label at the top left side is highlighted in white color
And hours checkbox is displayed 
And Filter option is displayed
And Search Box is displayed 
And Search Button is displayed
And Record entry text is displayed at the top
And the below table header shall be displayed on history page
  | header 	   |
  | date	   |
  | upload id  |
  | upload user|
  | patient	   |
  | doctor	   |
  | hospital   |
  | status	   |
And View Details button in disabled mode is displayed
And Show More button is displayed
And list of history records are displayed to user
When the user enters current date in the search box
And the user clicks on Search Button on history page
Then the history view shall be displayed as no data to display
When the user removes text in searchbox
Then the history view table shall be displayed
When the user enter any upload user name in search box from the history screen
And the user clicks on Search Button on history page
Then list of history records are displayed to user
When the user clicks on Filter Option
And click on uploader icon & selects another uploader name
And click on Done button from the filter option
Then the history view shall be displayed as no data to display
When the user removes upload user text from searchbox
And the user clicks on Search Button on history page
#Then list of history records are displayed to user
And user removes the filter from screen
When the user enters any data which is not present in history record in the search box
And the user clicks on Search Button on history page
Then the history view shall be displayed as no data to display
When user removes text from searchbox & click on hours quick filter
Then the history view shall be displayed as no data to display
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed


Examples: 
		|user|  
		|h-test-admin@capgemini.com |

		
@history_TC1583
Scenario Outline: TC1583 - Support-staff_Verify History records search and filter functionality by Invalid input data.
Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
When the user clicks on history button from left menu bar
Then the history tab shall be displayed
And History label at the top left side is highlighted in white color
And hours checkbox is displayed 
And Filter option is displayed
And Search Box is displayed 
And Search Button is displayed
And Record entry text is displayed at the top
And the below table header shall be displayed on history page
  | header 	   |
  | date	   |
  | upload id  |
  | upload user|
  | patient	   |
  | doctor	   |
  | hospital   |
  | status	   |
And View Details button in disabled mode is displayed
And Show More button is displayed
And list of history records are displayed to user
When the user enters current date in the search box
And the user clicks on Search Button on history page
Then the history view shall be displayed as no data to display
When the user removes text in searchbox
Then the history view table shall be displayed
When the user enter any upload user name in search box from the history screen
And the user clicks on Search Button on history page
Then list of history records are displayed to user
When the user clicks on Filter Option
And click on uploader icon & selects another uploader name
And click on Done button from the filter option
Then the history view shall be displayed as no data to display
When the user removes upload user text from searchbox
And the user clicks on Search Button on history page
#Then list of history records are displayed to user
And user removes the filter from screen
When the user enters any data which is not present in history record in the search box
And the user clicks on Search Button on history page
Then the history view shall be displayed as no data to display
When user removes text from searchbox & click on hours quick filter
Then the history view shall be displayed as no data to display
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed


Examples: 
		|user|  
		|ic-test-staff@capgemini.com |
		

@history_TC1585
Scenario Outline: TC1585 - S&N HIL Manager_Verify History records search and filter functionality by Invalid input data.
Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
When the user clicks on history button from left menu bar
Then the history tab shall be displayed
And History label at the top left side is highlighted in white color
And hours checkbox is displayed 
And Filter option is displayed
And Search Box is displayed 
And Search Button is displayed
And Record entry text is displayed at the top
And the below table header shall be displayed on history page
  | header 	   |
  | date	   |
  | upload id  |
  | upload user|
  | patient	   |
  | doctor	   |
  | hospital   |
  | status	   |
And View Details button in disabled mode is displayed
And Show More button is displayed
And list of history records are displayed to user
When the user enters current date in the search box
And the user clicks on Search Button on history page
Then the history view shall be displayed as no data to display
When the user removes text in searchbox
Then the history view table shall be displayed
When the user enter any upload user name in search box from the history screen
And the user clicks on Search Button on history page
Then list of history records are displayed to user
When the user clicks on Filter Option
And click on uploader icon & selects another uploader name
And click on Done button from the filter option
Then the history view shall be displayed as no data to display
When the user removes upload user text from searchbox
And the user clicks on Search Button on history page
#Then list of history records are displayed to user
And user removes the filter from screen
When the user enters any data which is not present in history record in the search box
And the user clicks on Search Button on history page
Then the history view shall be displayed as no data to display
When user removes text from searchbox & click on hours quick filter
Then the history view shall be displayed as no data to display
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed


Examples: 
		|user|  
		|ic-test-snn-hil-manager@capgemini.com |
		

@history_TC1584
Scenario Outline: TC1584 - IC Technician_Verify History records search and filter functionality by Invalid input data.
Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
Then Homepage is displayed to the user
And the dashboard summary shall display list of upload items
When the user clicks on history button from left menu bar
Then the history tab shall be displayed
And History label at the top left side is highlighted in white color
And hours checkbox is displayed 
And Filter option is displayed
And Search Box is displayed 
And Search Button is displayed
And Record entry text is displayed at the top
And the below table header shall be displayed on history page
  | header 	   |
  | date	   |
  | upload id  |
  | upload user|
  | patient	   |
  | doctor	   |
  | hospital   |
  | status	   |
And View Details button in disabled mode is displayed
And Show More button is displayed
And list of history records are displayed to user
When the user enters current date in the search box
And the user clicks on Search Button on history page
Then the history view shall be displayed as no data to display
When the user removes text in searchbox
Then the history view table shall be displayed
When the user enter any upload user name in search box from the history screen
And the user clicks on Search Button on history page
Then list of history records are displayed to user
When the user clicks on Filter Option
And click on uploader icon & selects another uploader name
And click on Done button from the filter option
Then the history view shall be displayed as no data to display
When the user removes upload user text from searchbox
And the user clicks on Search Button on history page
#Then list of history records are displayed to user
And user removes the filter from screen
When the user enters any data which is not present in history record in the search box
And the user clicks on Search Button on history page
Then the history view shall be displayed as no data to display
When user removes text from searchbox & click on hours quick filter
Then the history view shall be displayed as no data to display
When the user clicks on exit to app button from left menu bar
And user clicks on Logout icon from left panel
Then user is logout from the application.
And Data-Upload Application is closed


Examples: 
		|user|  
		|ic-test-tech@capgemini.com |
