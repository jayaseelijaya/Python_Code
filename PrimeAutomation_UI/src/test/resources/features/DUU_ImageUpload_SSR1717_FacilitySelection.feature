
Feature: SSR1717 - Data Upload Utility web application shall require an organization to be selected when initiating an upload. 

@ImageUpload_TC3346
Scenario Outline: TC3346 - IC Admin_Verify usability of Site, Surgeon and Application selection modal 

	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  Then Homepage is displayed to the user
  #step2
  When User clicks on Upload Files from left panel
  When User clicks on Upload files button from left menu bar 
  Then the upload files shall be higlighted in left menu bar
	And the right side header shall be displayed as upload files
  Then the upload icon and Upload button are displayed
  #step3
  When Clicks on Upload Button
	Then the Site selection screen is displayed with
	| Components                                      |
    | Where are you working today                     |
    | Search box is displayed with header Search Site |
    | Enter Keyword or Name of Site                   |
    | list of linked sites                            |
    | Back and Next buttons                           |
    | I dont see my Site listed                       |  
   #step4
   When the user clicks on back button
   Then the screen shall be navigated back to upload button screen
   #step5
   And Clicks on Upload Button
	Then Search facility screen is displayed to user along with back and next button
	#step6
	When the user hovers over a site 
	Then the hovered site shall be highlighted in green color
	#step7
	When user clicks on I don't see my site listed
	Then notification message is displayed to the user
	And the close button at bottom shall be displayed
	And the x button in white color shall be displayed
	#step8
	When the user clicks on close button on popup
	Then Search facility screen is displayed to user along with back and next button
	#step9
	And no organisation should be selected if more than one organisation is available
	#step10
	#And the scroll bar shall be displayed in site selection
	#step11
	When the user enters "admin" text in search box
	Then the searchbox border shall be higlighted in white color
	When the user clears the search box
	And Text Enter Keyword or Name of Site as place holder in Search bar is displayed
	#step12
	And the next button shall be displayed as disabled if no site selected
	#step19
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
   #step20
   When the user clicks on back button 
   Then Search facility screen is displayed to user along with back and next button
   And the selected site name shall be removed from top breadcrumb
   And the next button shall be displayed as enabled and higlighted in green color
   #step21
   When the user clicks on next button in site selection screen
   Then the surgeon selection screen shall be displayed
   #step22
   And No surgeon should be display as seleted by default
   #step23
   #And the scroll bar shall be displayed in surgeon selection
   #step24
   When the user clicks on I don't see my Surgeon listed
   Then notification message is displayed to the user
	 And the close button at bottom shall be displayed
	 And the x button in white color shall be displayed
	 #step25
	 When the user clicks on close button on popup
	 Then the surgeon selection screen shall be displayed
	 #step26
	 When the user hovers over a surgeon
	 Then the hovered surgeon shall be highlighted in teal color
	 #step27
	 When the user enters B text in search box
	 Then the searchbox border shall be higlighted in white color
	 When the user removes text from search box
	 And Text Enter First or Last Name of Surgeon as place holder in Search bar shall be displayed
	 #step28
	 And Next button should be in disabled mode & non-clickable
	 #step29
	 And user clicks on any of the surgeon listed
	And Next button should be in enabled mode after selecting surgeon
	#step30
	When the user clicks on back button  
   Then Search facility screen is displayed to user along with back and next button
   #step31
    When the user clicks on next button in site selection screen
   Then the surgeon selection screen shall be displayed 
	 #step32
	  When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #step33  
	 When the user clicks on back button
	 Then the screen shall be navigated back to surgeon selection screen
	 And the selected site name shall be removed from top breadcrumb
   And the next button shall be displayed as enabled and higlighted in green color
   #step34
	  When user clicks on Next button after surgeon selection
	  Then Application Selection Modal screen is displayed to user along with back and next button
	  #step35
	  And no application shall be displayed as selected by default if more than one record available 
	  #step36
	  When the user clicks on I don't see my Application listed
   Then notification message is displayed to the user
	 And the close button at bottom shall be displayed
	 And the x button in white color shall be displayed
	 #step37
	 When the user clicks on close button on popup
	 Then Application Selection Modal screen is displayed to user along with back and next button
	 #step38
	 And the next button shall be displayed as disabled if no application selected
	 #step39
	  When the user selects an application and click on Next button
	  #step42
    When the user clicks on Next button in application selection screen
    #step43
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button	 
    #step44
    When the user clicks on back button
    Then Application Selection Modal screen is displayed to user along with back and next button
    #step45
    When the user clicks on back button
	 Then the screen shall be navigated back to surgeon selection screen
	 #step46
	 When the user clicks on back button 
   Then Search facility screen is displayed to user along with back and next button
   #step47
   When the user clicks on back button
   Then the screen shall be navigated back to upload button screen
   #step48
   When Clicks on Upload Button
   Then Search facility screen is displayed with back and next button
   #step49
   When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 50
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   
   Examples: 
	|user|  
	| ic-test-admin@capgemini.com |
	
	@ImageUpload_TC7871
Scenario Outline: TC7871 - IC Technician_Verify usability of Site, Surgeon and Application selection modal 

	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  Then Homepage is displayed to the user
  #step2
  When User clicks on Upload Files from left panel
  When User clicks on Upload files button from left menu bar 
  Then the upload files shall be higlighted in left menu bar
	And the right side header shall be displayed as upload files
  Then the upload icon and Upload button are displayed
  #step3
  When Clicks on Upload Button
	Then the Site selection screen is displayed with
	| Components                                      |
    | Where are you working today                     |
    | Search box is displayed with header Search Site |
    | Enter Keyword or Name of Site                   |
    | list of linked sites                            |
    | Back and Next buttons                           |
    | I dont see my Site listed                       |  
   #step4
   When the user clicks on back button
   Then the screen shall be navigated back to upload button screen
   #step5
   And Clicks on Upload Button
	Then Search facility screen is displayed to user along with back and next button
	#step6
	When the user hovers over a site 
	Then the hovered site shall be highlighted in green color
	#step7
	When user clicks on I don't see my site listed
	Then notification message is displayed to the user
	And the close button at bottom shall be displayed
	And the x button in white color shall be displayed
	#step8
	When the user clicks on close button on popup
	Then Search facility screen is displayed to user along with back and next button
	#step9
	And no organisation should be selected if more than one organisation is available
	#step10
	#And the scroll bar shall be displayed in site selection
	#step11
	When the user enters "admin" text in search box
	Then the searchbox border shall be higlighted in white color
	When the user clears the search box
	And Text Enter Keyword or Name of Site as place holder in Search bar is displayed
	#step12
	And the next button shall be displayed as disabled if no site selected
	#step19
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
   #step20
   When the user clicks on back button 
   Then Search facility screen is displayed to user along with back and next button
   And the selected site name shall be removed from top breadcrumb
   And the next button shall be displayed as enabled and higlighted in green color
   #step21
   When the user clicks on next button in site selection screen
   Then the surgeon selection screen shall be displayed
   #step22
   And No surgeon should be display as seleted by default
   #step23
   #And the scroll bar shall be displayed in surgeon selection
   #step24
   When the user clicks on I don't see my Surgeon listed
   Then notification message is displayed to the user
	 And the close button at bottom shall be displayed
	 And the x button in white color shall be displayed
	 #step25
	 When the user clicks on close button on popup
	 Then the surgeon selection screen shall be displayed
	 #step26
	 When the user hovers over a surgeon
	 Then the hovered surgeon shall be highlighted in teal color
	 #step27
	 When the user enters B text in search box
	 Then the searchbox border shall be higlighted in white color
	 When the user removes text from search box
	 And Text Enter First or Last Name of Surgeon as place holder in Search bar shall be displayed
	 #step28
	 And Next button should be in disabled mode & non-clickable
	 #step29
	 And user clicks on any of the surgeon listed
	And Next button should be in enabled mode after selecting surgeon
	#step30
	When the user clicks on back button  
   Then Search facility screen is displayed to user along with back and next button
   #step31
    When the user clicks on next button in site selection screen
   Then the surgeon selection screen shall be displayed 
	 #step32
	  When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #step33  
	 When the user clicks on back button
	 Then the screen shall be navigated back to surgeon selection screen
	 And the selected site name shall be removed from top breadcrumb
   And the next button shall be displayed as enabled and higlighted in green color
   #step34
	  When user clicks on Next button after surgeon selection
	  Then Application Selection Modal screen is displayed to user along with back and next button
	  #step35
	  And no application shall be displayed as selected by default if more than one record available 
	  #step36
	  When the user clicks on I don't see my Application listed
   Then notification message is displayed to the user
	 And the close button at bottom shall be displayed
	 And the x button in white color shall be displayed
	 #step37
	 When the user clicks on close button on popup
	 Then Application Selection Modal screen is displayed to user along with back and next button
	 #step38
	 And the next button shall be displayed as disabled if no application selected
	 #step39
	  When the user selects an application and click on Next button
	  #step42
    When the user clicks on Next button in application selection screen
    #step43
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button	 
    #step44
    When the user clicks on back button
    Then Application Selection Modal screen is displayed to user along with back and next button
    #step45
    When the user clicks on back button
	 Then the screen shall be navigated back to surgeon selection screen
	 #step46
	 When the user clicks on back button 
   Then Search facility screen is displayed to user along with back and next button
   #step47
   When the user clicks on back button
   Then the screen shall be navigated back to upload button screen
   #step48
   When Clicks on Upload Button
   Then Search facility screen is displayed with back and next button
   #step49
   When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 50
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   
   Examples: 
	|user|  
	| ic-test-user@capgemini.com |
	
	@ImageUpload_TC7872
Scenario Outline: TC7872 - Hospital Admin_Verify usability of Site, Surgeon and Application selection modal 

	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  Then Homepage is displayed to the user
  #step2
  When User clicks on Upload Files from left panel
  When User clicks on Upload files button from left menu bar 
  Then the upload files shall be higlighted in left menu bar
	And the right side header shall be displayed as upload files
  Then the upload icon and Upload button are displayed
  #step3
  When Clicks on Upload Button
	Then the Site selection screen is displayed with
	| Components                                      |
    | Where are you working today                     |
    | Search box is displayed with header Search Site |
    | Enter Keyword or Name of Site                   |
    | list of linked sites                            |
    | Back and Next buttons                           |
    | I dont see my Site listed                       |  
   #step4
   When the user clicks on back button
   Then the screen shall be navigated back to upload button screen
   #step5
   And Clicks on Upload Button
	Then Search facility screen is displayed to user along with back and next button
	#step6
	When the user hovers over a site 
	Then the hovered site shall be highlighted in green color
	#step7
	When user clicks on I don't see my site listed
	Then notification message is displayed to the user
	And the close button at bottom shall be displayed
	And the x button in white color shall be displayed
	#step8
	When the user clicks on close button on popup
	Then Search facility screen is displayed to user along with back and next button
	#step9
	And no organisation should be selected if more than one organisation is available
	#step10
	#And the scroll bar shall be displayed in site selection
	#step11
	When the user enters "admin" text in search box
	Then the searchbox border shall be higlighted in white color
	When the user clears the search box
	And Text Enter Keyword or Name of Site as place holder in Search bar is displayed
	#step12
	And the next button shall be displayed as disabled if no site selected
	#step19
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
   #step20
   When the user clicks on back button 
   Then Search facility screen is displayed to user along with back and next button
   And the selected site name shall be removed from top breadcrumb
   And the next button shall be displayed as enabled and higlighted in green color
   #step21
   When the user clicks on next button in site selection screen
   Then the surgeon selection screen shall be displayed
   #step22
   And No surgeon should be display as seleted by default
   #step23
   #And the scroll bar shall be displayed in surgeon selection
   #step24
   When the user clicks on I don't see my Surgeon listed
   Then notification message is displayed to the user
	 And the close button at bottom shall be displayed
	 And the x button in white color shall be displayed
	 #step25
	 When the user clicks on close button on popup
	 Then the surgeon selection screen shall be displayed
	 #step26
	 When the user hovers over a surgeon
	 Then the hovered surgeon shall be highlighted in teal color
	 #step27
	 When the user enters B text in search box
	 Then the searchbox border shall be higlighted in white color
	 When the user removes text from search box
	 And Text Enter First or Last Name of Surgeon as place holder in Search bar shall be displayed
	 #step28
	 And Next button should be in disabled mode & non-clickable
	 #step29
	 And user clicks on any of the surgeon listed
	And Next button should be in enabled mode after selecting surgeon
	#step30
	When the user clicks on back button  
   Then Search facility screen is displayed to user along with back and next button
   #step31
    When the user clicks on next button in site selection screen
   Then the surgeon selection screen shall be displayed 
	 #step32
	  When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #step33  
	 When the user clicks on back button
	 Then the screen shall be navigated back to surgeon selection screen
	 And the selected site name shall be removed from top breadcrumb
   And the next button shall be displayed as enabled and higlighted in green color
   #step34
	  When user clicks on Next button after surgeon selection
	  Then Application Selection Modal screen is displayed to user along with back and next button
	  #step35
	  And no application shall be displayed as selected by default if more than one record available 
	  #step36
	  When the user clicks on I don't see my Application listed
   Then notification message is displayed to the user
	 And the close button at bottom shall be displayed
	 And the x button in white color shall be displayed
	 #step37
	 When the user clicks on close button on popup
	 Then Application Selection Modal screen is displayed to user along with back and next button
	 #step38
	 And the next button shall be displayed as disabled if no application selected
	 #step39
	  When the user selects an application and click on Next button
	  #step42
    When the user clicks on Next button in application selection screen
    #step43
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button	 
    #step44
    When the user clicks on back button
    Then Application Selection Modal screen is displayed to user along with back and next button
    #step45
    When the user clicks on back button
	 Then the screen shall be navigated back to surgeon selection screen
	 #step46
	 When the user clicks on back button 
   Then Search facility screen is displayed to user along with back and next button
   #step47
   When the user clicks on back button
   Then the screen shall be navigated back to upload button screen
   #step48
   When Clicks on Upload Button
   Then Search facility screen is displayed with back and next button
   #step49
   When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 50
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   
   Examples: 
	|user|  
	| ic-test-hospital-admin@capgemini.com |
	
	@ImageUpload_TC7874
Scenario Outline: TC7874 - Support Staff_Verify usability of Site, Surgeon and Application selection modal 

	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  Then Homepage is displayed to the user
  #step2
  When User clicks on Upload Files from left panel
  When User clicks on Upload files button from left menu bar 
  Then the upload files shall be higlighted in left menu bar
	And the right side header shall be displayed as upload files
  Then the upload icon and Upload button are displayed
  #step3
  When Clicks on Upload Button
	Then the Site selection screen is displayed with
	| Components                                      |
    | Where are you working today                     |
    | Search box is displayed with header Search Site |
    | Enter Keyword or Name of Site                   |
    | list of linked sites                            |
    | Back and Next buttons                           |
    | I dont see my Site listed                       |  
   #step4
   When the user clicks on back button
   Then the screen shall be navigated back to upload button screen
   #step5
   And Clicks on Upload Button
	Then Search facility screen is displayed to user along with back and next button
	#step6
	When the user hovers over a site 
	Then the hovered site shall be highlighted in green color
	#step7
	When user clicks on I don't see my site listed
	Then notification message is displayed to the user
	And the close button at bottom shall be displayed
	And the x button in white color shall be displayed
	#step8
	When the user clicks on close button on popup
	Then Search facility screen is displayed to user along with back and next button
	#step9
	And no organisation should be selected if more than one organisation is available
	#step10
	#And the scroll bar shall be displayed in site selection
	#step11
	When the user enters "admin" text in search box
	Then the searchbox border shall be higlighted in white color
	When the user clears the search box
	And Text Enter Keyword or Name of Site as place holder in Search bar is displayed
	#step12
	And the next button shall be displayed as disabled if no site selected
	#step19
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
   #step20
   When the user clicks on back button 
   Then Search facility screen is displayed to user along with back and next button
   And the selected site name shall be removed from top breadcrumb
   And the next button shall be displayed as enabled and higlighted in green color
   #step21
   When the user clicks on next button in site selection screen
   Then the surgeon selection screen shall be displayed
   #step22
   And No surgeon should be display as seleted by default
   #step23
   #And the scroll bar shall be displayed in surgeon selection
   #step24
   When the user clicks on I don't see my Surgeon listed
   Then notification message is displayed to the user
	 And the close button at bottom shall be displayed
	 And the x button in white color shall be displayed
	 #step25
	 When the user clicks on close button on popup
	 Then the surgeon selection screen shall be displayed
	 #step26
	 When the user hovers over a surgeon
	 Then the hovered surgeon shall be highlighted in teal color
	 #step27
	 When the user enters B text in search box
	 Then the searchbox border shall be higlighted in white color
	 When the user removes text from search box
	 And Text Enter First or Last Name of Surgeon as place holder in Search bar shall be displayed
	 #step28
	 And Next button should be in disabled mode & non-clickable
	 #step29
	 And user clicks on any of the surgeon listed
	And Next button should be in enabled mode after selecting surgeon
	#step30
	When the user clicks on back button  
   Then Search facility screen is displayed to user along with back and next button
   #step31
    When the user clicks on next button in site selection screen
   Then the surgeon selection screen shall be displayed 
	 #step32
	  When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #step33  
	 When the user clicks on back button
	 Then the screen shall be navigated back to surgeon selection screen
	 And the selected site name shall be removed from top breadcrumb
   And the next button shall be displayed as enabled and higlighted in green color
   #step34
	  When user clicks on Next button after surgeon selection
	  Then Application Selection Modal screen is displayed to user along with back and next button
	  #step35
	  And no application shall be displayed as selected by default if more than one record available 
	  #step36
	  When the user clicks on I don't see my Application listed
   Then notification message is displayed to the user
	 And the close button at bottom shall be displayed
	 And the x button in white color shall be displayed
	 #step37
	 When the user clicks on close button on popup
	 Then Application Selection Modal screen is displayed to user along with back and next button
	 #step38
	 And the next button shall be displayed as disabled if no application selected
	 #step39
	  When the user selects an application and click on Next button
	  #step42
    When the user clicks on Next button in application selection screen
    #step43
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button	 
    #step44
    When the user clicks on back button
    Then Application Selection Modal screen is displayed to user along with back and next button
    #step45
    When the user clicks on back button
	 Then the screen shall be navigated back to surgeon selection screen
	 #step46
	 When the user clicks on back button 
   Then Search facility screen is displayed to user along with back and next button
   #step47
   When the user clicks on back button
   Then the screen shall be navigated back to upload button screen
   #step48
   When Clicks on Upload Button
   Then Search facility screen is displayed with back and next button
   #step49
   When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 50
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   
   Examples: 
	|user|  
	| ic-test-staff@capgemini.com |
	
	@ImageUpload_TC7873
Scenario Outline: TC7873 - Surgeon_Verify usability of Site, Surgeon and Application selection modal 

	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  Then Homepage is displayed to the user
  #step2
  When User clicks on Upload Files from left panel
  When User clicks on Upload files button from left menu bar 
  Then the upload files shall be higlighted in left menu bar
	And the right side header shall be displayed as upload files
  Then the upload icon and Upload button are displayed
  #step3
  When Clicks on Upload Button
	Then the Site selection screen is displayed with
	| Components                                      |
    | Where are you working today                     |
    | Search box is displayed with header Search Site |
    | Enter Keyword or Name of Site                   |
    | list of linked sites                            |
    | Back and Next buttons                           |
    | I dont see my Site listed                       |  
   #step4
   When the user clicks on back button
   Then the screen shall be navigated back to upload button screen
   #step5
   And Clicks on Upload Button
	Then Search facility screen is displayed to user along with back and next button
	#step6
	When the user hovers over a site 
	Then the hovered site shall be highlighted in green color
	#step7
	When user clicks on I don't see my site listed
	Then notification message is displayed to the user
	And the close button at bottom shall be displayed
	And the x button in white color shall be displayed
	#step8
	When the user clicks on close button on popup
	Then Search facility screen is displayed to user along with back and next button
	#step9
	And no organisation should be selected if more than one organisation is available
	#step10
	#And the scroll bar shall be displayed in site selection
	#step11
	When the user enters "admin" text in search box
	Then the searchbox border shall be higlighted in white color
	When the user clears the search box
	And Text Enter Keyword or Name of Site as place holder in Search bar is displayed
	#step12
	And the next button shall be displayed as disabled if no site selected
	#step19
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
   #step20
   When the user clicks on back button 
   Then Search facility screen is displayed to user along with back and next button
   And the selected site name shall be removed from top breadcrumb
   And the next button shall be displayed as enabled and higlighted in green color
   #step21
   When the user clicks on next button in site selection screen
   Then the surgeon selection screen shall be displayed
   #step22
   And No surgeon should be display as seleted by default
   #step23
   #And the scroll bar shall be displayed in surgeon selection
   #step24
   When the user clicks on I don't see my Surgeon listed
   Then notification message is displayed to the user
	 And the close button at bottom shall be displayed
	 And the x button in white color shall be displayed
	 #step25
	 When the user clicks on close button on popup
	 Then the surgeon selection screen shall be displayed
	 #step26
	 When the user hovers over a surgeon
	 Then the hovered surgeon shall be highlighted in teal color
	 #step27
	 When the user enters B text in search box
	 Then the searchbox border shall be higlighted in white color
	 When the user removes text from search box
	 And Text Enter First or Last Name of Surgeon as place holder in Search bar shall be displayed
	 #step28
	 And Next button should be in disabled mode & non-clickable
	 #step29
	 And user clicks on any of the surgeon listed
	And Next button should be in enabled mode after selecting surgeon
	#step30
	When the user clicks on back button  
   Then Search facility screen is displayed to user along with back and next button
   #step31
    When the user clicks on next button in site selection screen
   Then the surgeon selection screen shall be displayed 
	 #step32
	  When the user selects a surgeon and click on next button
    Then the Application selection screen is displayed with
      | componenets                                   |
      | Select the application associated with upload |
      | list of linked Application cards              |
      | I dont see my application listed              |
      | Back and Next buttons                         |
    #step33  
	 When the user clicks on back button
	 Then the screen shall be navigated back to surgeon selection screen
	 And the selected site name shall be removed from top breadcrumb
   And the next button shall be displayed as enabled and higlighted in green color
   #step34
	  When user clicks on Next button after surgeon selection
	  Then Application Selection Modal screen is displayed to user along with back and next button
	  #step35
	  And no application shall be displayed as selected by default if more than one record available 
	  #step36
	  When the user clicks on I don't see my Application listed
   Then notification message is displayed to the user
	 And the close button at bottom shall be displayed
	 And the x button in white color shall be displayed
	 #step37
	 When the user clicks on close button on popup
	 Then Application Selection Modal screen is displayed to user along with back and next button
	 #step38
	 And the next button shall be displayed as disabled if no application selected
	 #step39
	  When the user selects an application and click on Next button
	  #step42
    When the user clicks on Next button in application selection screen
    #step43
    Then the Upload screen is displayed with drag drop area, Back and Browse PC button	 
    #step44
    When the user clicks on back button
    Then Application Selection Modal screen is displayed to user along with back and next button
    #step45
    When the user clicks on back button
	 Then the screen shall be navigated back to surgeon selection screen
	 #step46
	 When the user clicks on back button 
   Then Search facility screen is displayed to user along with back and next button
   #step47
   When the user clicks on back button
   Then the screen shall be navigated back to upload button screen
   #step48
   When Clicks on Upload Button
   Then Search facility screen is displayed with back and next button
   #step49
   When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 50
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   
   Examples: 
	|user|  
	| ic-test-surgeon@capgemini.com |
   
   @ImageUpload_TC7894
Scenario Outline: TC7894 - IC Admin_Verify usability of Site, Surgeon and Application selection modal 

	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  Then Homepage is displayed to the user
  #step2
  When User clicks on Upload Files from left panel
  When User clicks on Upload files button from left menu bar 
  Then the upload files shall be higlighted in left menu bar
	And the right side header shall be displayed as upload files
  Then the upload icon and Upload button are displayed
  #step3
  When Clicks on Upload Button
	Then the Site selection screen is displayed with
	| Components                                      |
    | Where are you working today                     |
    | Search box is displayed with header Search Site |
    | Enter Keyword or Name of Site                   |
    | list of linked sites                            |
    | Back and Next buttons                           |
    | I dont see my Site listed                       |  
   #step4
  And no facility should be by-default selected and next button should be in disabled mode
  #step5
  And the user shall not be proceed to next screen without selecting site
  #step6
  When user selects one site and try to select second site
  Then the user shall not be able to select multiple site
   #step7
   When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 8
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   
   Examples: 
	|user|  
	| ic-test-admin@capgemini.com |
	
	@ImageUpload_TC7896
Scenario Outline: TC7896 - IC Technician_Verify usability of Site, Surgeon and Application selection modal 

	Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
  Then Homepage is displayed to the user
  #step2
  When User clicks on Upload Files from left panel
  When User clicks on Upload files button from left menu bar 
  Then the upload files shall be higlighted in left menu bar
	And the right side header shall be displayed as upload files
  Then the upload icon and Upload button are displayed
  #step3
  When Clicks on Upload Button
	Then the Site selection screen is displayed with
	| Components                                      |
    | Where are you working today                     |
    | Search box is displayed with header Search Site |
    | Enter Keyword or Name of Site                   |
    | list of linked sites                            |
    | Back and Next buttons                           |
    | I dont see my Site listed                       |  
   #step4
  And no facility should be by-default selected and next button should be in disabled mode
  #step5
  And the user shall not be proceed to next screen without selecting site
  #step6
  When user selects one site and try to select second site
  Then the user shall not be able to select multiple site
   #step7
   When the user click on Exit Apps at the bottom of the left menu panel
    Then the Application access screen is displayed
    #Step 8
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   
   Examples: 
	|user|  
	| ic-test-user@capgemini.com |
	

	