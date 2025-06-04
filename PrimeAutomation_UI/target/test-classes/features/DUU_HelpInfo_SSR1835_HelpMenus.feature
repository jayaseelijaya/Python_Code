Feature: SSR1835 - Verifying Data-Upload Utility Application shall provide help menu details.
	
	@helpInfo_TC0693 
    Scenario Outline: TC0693 - IC_Admin_Verify DUU web app shall provide help menus for all screens.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the below components shall be displayed on top bar of pdf viewer
      | screen           |
      | Toggle Sidebar   |
      | Find in Document |
      | Previous Page    |
      | Next Page        |
      | Page             |
      | Zoom Out         |
      | Zoom In          |
      | Page Width       |
      | Print            |
      | Download         |
      | Tools            |
    And Scroll bar is displayed to the user
    When user clicks on Download button on pdf viewer
    Then file gets downloaded in the current user system
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    And all the page of the pdf is displayed in left side bar
    When user clicks on Find in Document button
    Then Search box is displayed on pdf viewer
    When user enters any keyword to search
    Then Number of matching words in the pdf shall be displayed
    When user clicks on Next page button
    Then user redirects to PDF Next page
    When user clicks on Previous page button
    Then user redirects to PDF Previous page
    When user clicks on Zoom out icon
    Then pdf page is zoomed out
    When user clicks on Zoom in icon
    Then pdf page is zoomed in
    When user clicks on page width field
    And selects any of the value
    Then PDF is displayed as per the resolution selected on page width field
    #When user clicks on Print button
    #Then print pop up screen is displayed
    When user verifies software information menu icon is displayed on the bottom of left menu
    And clicks on software information icon
    Then software information is displayed on the screen
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |

  #|ic-test-tech@capgemini.com |
  #|ic-test-nurse@capgemini.com |
  #|ic-test-surgeon@capgemini.com |
  
    @helpInfo_TC1232  
    Scenario Outline: TC1232 - SNN_Manager_Verify DUU web app shall provide help menus for all screens.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the below components shall be displayed on top bar of pdf viewer
      | screen           |
      | Toggle Sidebar   |
      | Find in Document |
      | Previous Page    |
      | Next Page        |
      | Page             |
      | Zoom Out         |
      | Zoom In          |
      | Page Width       |
      | Print            |
      | Download         |
      | Tools            |
    And Scroll bar is displayed to the user
    When user clicks on Download button on pdf viewer
    Then file gets downloaded in the current user system
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    And all the page of the pdf is displayed in left side bar
    When user clicks on Find in Document button
    Then Search box is displayed on pdf viewer
    When user enters any keyword to search
    Then Number of matching words in the pdf shall be displayed
    When user clicks on Next page button
    Then user redirects to PDF Next page
    When user clicks on Previous page button
    Then user redirects to PDF Previous page
    When user clicks on Zoom out icon
    Then pdf page is zoomed out
    When user clicks on Zoom in icon
    Then pdf page is zoomed in
    When user clicks on page width field
    And selects any of the value
    Then PDF is displayed as per the resolution selected on page width field
    #When user clicks on Print button
    #Then print pop up screen is displayed
    When user verifies software information menu icon is displayed on the bottom of left menu
    And clicks on software information icon
    Then software information is displayed on the screen
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed
    
    Examples: 
      | user                           |
      | ic-test-snnadmin@capgemini.com |
	
			
	@helpInfo_TC1236
  Scenario Outline: TC1236 - Hospital_Admin_Verify DUU web app shall provide help menus for all screens for hospital admin.
    
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the below components shall be displayed on top bar of pdf viewer
      | screen           |
      | Toggle Sidebar   |
      | Find in Document |
      | Previous Page    |
      | Next Page        |
      | Page             |
      | Zoom Out         |
      | Zoom In          |
      | Page Width       |
      | Print            |
      | Download         |
      | Tools            |
    And Scroll bar is displayed to the user
    When user clicks on Download button on pdf viewer
    Then file gets downloaded in the current user system
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    And all the page of the pdf is displayed in left side bar
    When user clicks on Find in Document button
    Then Search box is displayed on pdf viewer
    When user enters any keyword to search
    Then Number of matching words in the pdf shall be displayed
    When user clicks on Next page button
    Then user redirects to PDF Next page
    When user clicks on Previous page button
    Then user redirects to PDF Previous page
    When user clicks on Zoom out icon
    Then pdf page is zoomed out
    When user clicks on Zoom in icon
    Then pdf page is zoomed in
    When user clicks on page width field
    And selects any of the value
    Then PDF is displayed as per the resolution selected on page width field
    #When user clicks on Print button
    #Then print pop up screen is displayed
    When user verifies software information menu icon is displayed on the bottom of left menu
    And clicks on software information icon
    Then software information is displayed on the screen
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed
    
    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |
      
	@helpInfo_TC1240
  Scenario Outline: TC1240 - IC_technician_Verify DUU web app shall provide help menus for all screens.
    
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the below components shall be displayed on top bar of pdf viewer
      | screen           |
      | Toggle Sidebar   |
      | Find in Document |
      | Previous Page    |
      | Next Page        |
      | Page             |
      | Zoom Out         |
      | Zoom In          |
      | Page Width       |
      | Print            |
      | Download         |
      | Tools            |
    And Scroll bar is displayed to the user
    When user clicks on Download button on pdf viewer
    Then file gets downloaded in the current user system
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    And all the page of the pdf is displayed in left side bar
    When user clicks on Find in Document button
    Then Search box is displayed on pdf viewer
    When user enters any keyword to search
    Then Number of matching words in the pdf shall be displayed
    When user clicks on Next page button
    Then user redirects to PDF Next page
    When user clicks on Previous page button
    Then user redirects to PDF Previous page
    When user clicks on Zoom out icon
    Then pdf page is zoomed out
    When user clicks on Zoom in icon
    Then pdf page is zoomed in
    When user clicks on page width field
    And selects any of the value
    Then PDF is displayed as per the resolution selected on page width field
    #When user clicks on Print button
    #Then print pop up screen is displayed
    When user verifies software information menu icon is displayed on the bottom of left menu
    And clicks on software information icon
    Then software information is displayed on the screen
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed

    Examples: 
      | user                       |
      | ic-test-tech@capgemini.com |
      	
  @helpInfo_TC1237
  Scenario Outline: TC1237 - Surgeon_Verify DUU web app shall provide help menus for all screens.
    
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the below components shall be displayed on top bar of pdf viewer
      | screen           |
      | Toggle Sidebar   |
      | Find in Document |
      | Previous Page    |
      | Next Page        |
      | Page             |
      | Zoom Out         |
      | Zoom In          |
      | Page Width       |
      | Print            |
      | Download         |
      | Tools            |
    And Scroll bar is displayed to the user
    When user clicks on Download button on pdf viewer
    Then file gets downloaded in the current user system
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    And all the page of the pdf is displayed in left side bar
    When user clicks on Find in Document button
    Then Search box is displayed on pdf viewer
    When user enters any keyword to search
    Then Number of matching words in the pdf shall be displayed
    When user clicks on Next page button
    Then user redirects to PDF Next page
    When user clicks on Previous page button
    Then user redirects to PDF Previous page
    When user clicks on Zoom out icon
    Then pdf page is zoomed out
    When user clicks on Zoom in icon
    Then pdf page is zoomed in
    When user clicks on page width field
    And selects any of the value
    Then PDF is displayed as per the resolution selected on page width field
    #When user clicks on Print button
    #Then print pop up screen is displayed
    When user verifies software information menu icon is displayed on the bottom of left menu
    And clicks on software information icon
    Then software information is displayed on the screen
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed
   
    Examples: 
      | user                          |
      | ic-test-surgeon@capgemini.com |
      
	@helpInfo_TC1238
  Scenario Outline: TC1238 - Support_staff_Verify DUU web app shall provide help menus for all screens for support staff.
    
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the below components shall be displayed on top bar of pdf viewer
      | screen           |
      | Toggle Sidebar   |
      | Find in Document |
      | Previous Page    |
      | Next Page        |
      | Page             |
      | Zoom Out         |
      | Zoom In          |
      | Page Width       |
      | Print            |
      | Download         |
      | Tools            |
    And Scroll bar is displayed to the user
    When user clicks on Download button on pdf viewer
    Then file gets downloaded in the current user system
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    And all the page of the pdf is displayed in left side bar
    When user clicks on Find in Document button
    Then Search box is displayed on pdf viewer
    When user enters any keyword to search
    Then Number of matching words in the pdf shall be displayed
    When user clicks on Next page button
    Then user redirects to PDF Next page
    When user clicks on Previous page button
    Then user redirects to PDF Previous page
    When user clicks on Zoom out icon
    Then pdf page is zoomed out
    When user clicks on Zoom in icon
    Then pdf page is zoomed in
    When user clicks on page width field
    And selects any of the value
    Then PDF is displayed as per the resolution selected on page width field
    #When user clicks on Print button
    #Then print pop up screen is displayed
    When user verifies software information menu icon is displayed on the bottom of left menu
    And clicks on software information icon
    Then software information is displayed on the screen
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed
   
   
    Examples: 
      | user                        |
      | ic-test-nurse@capgemini.com |
            
	@helpInfo_TC1283
  Scenario Outline: TC1283 - IC_Technician_Verify DUU web app shall help menus tool feature.
    
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the below components shall be displayed on top bar of pdf viewer
      | screen           |
      | Toggle Sidebar   |
      | Find in Document |
      | Previous Page    |
      | Next Page        |
      | Page             |
      | Zoom Out         |
      | Zoom In          |
      #| Page Width       |
      | Print            |
      | Download         |
      | Tools            |
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on page number textbox and enters 2
    Then the 2 page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on go to first page
    Then the first page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on go to last page
    Then the last page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on rotate clockwise
    Then the pdf document shall be rotated clockwise
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on rotate counterclockwise
    Then the pdf document shall be rotated counterclockwise
    When the user clicks on tools icon on top right side of pdf viewer
    Then the text selection tool shall be displayed as selected
    When the user selects any text on pdf viewer
    Then the user should be able to select text on pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on hand tool
    Then the hand tool shall be enabled
    And the user shall be able to move the pdf document using hand cursor tool
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on horizontal scrolling
    Then the horizontal scrolling bar shall be displayed at the bottom of pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on wrapped scrolling
    Then the wrapped scrolling bar shall be displayed at the bottom of pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on odd spreads
    Then the pdf pages shall be displayed side by side starting with odd pages
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on even spreads
    Then the pdf pages shall be displayed side by side starting with even pages
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on document properties
    Then the pdf document properties pop up shall be displayed
    And the following properties of pdf document shall be displayed
      | properties        |
      | file name         |
      | file size         |
      | title             |
      | author            |
      | subject           |
      | keywords          |
      | creation date     |
      | modification date |
      | creator           |
      | pdf producer      |
      | pdf version       |
      | page count        |
      | page size         |
      | fast web view     |
      | close button      |
    When the user clicks on close
    Then the pdf document properties popup shall be closed
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed
    

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |
      
   @helpInfo_TC1286 
  Scenario Outline: TC1286 - IC_Admin_Verify DUU web app shall help menus tool feature.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the below components shall be displayed on top bar of pdf viewer
      | screen           |
      | Toggle Sidebar   |
      | Find in Document |
      | Previous Page    |
      | Next Page        |
      | Page             |
      | Zoom Out         |
      | Zoom In          |
      | Page Width       |
      | Print            |
      | Download         |
      | Tools            |
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on page number textbox and enters 2
    Then the 2 page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on go to first page
    Then the first page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on go to last page
    Then the last page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on rotate clockwise
    Then the pdf document shall be rotated clockwise
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on rotate counterclockwise
    Then the pdf document shall be rotated counterclockwise
    When the user clicks on tools icon on top right side of pdf viewer
    Then the text selection tool shall be displayed as selected
    When the user selects any text on pdf viewer
    Then the user should be able to select text on pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on hand tool
    Then the hand tool shall be enabled
    And the user shall be able to move the pdf document using hand cursor tool
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on horizontal scrolling
    Then the horizontal scrolling bar shall be displayed at the bottom of pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on wrapped scrolling
    Then the wrapped scrolling bar shall be displayed at the bottom of pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on odd spreads
    Then the pdf pages shall be displayed side by side starting with odd pages
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on even spreads
    Then the pdf pages shall be displayed side by side starting with even pages
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on document properties
    Then the pdf document properties pop up shall be displayed
    And the following properties of pdf document shall be displayed
      | properties        |
      | file name         |
      | file size         |
      | title             |
      | author            |
      | subject           |
      | keywords          |
      | creation date     |
      | modification date |
      | creator           |
      | pdf producer      |
      | pdf version       |
      | page count        |
      | page size         |
      | fast web view     |
      | close button      |
    When the user clicks on close
    Then the pdf document properties popup shall be closed
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-tech@capgemini.com  |
      
	@helpInfo_TC1287 
  Scenario Outline: TC1287 - Hospital_admin_Verify DUU web app shall help menus tool feature.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the below components shall be displayed on top bar of pdf viewer
      | screen           |
      | Toggle Sidebar   |
      | Find in Document |
      | Previous Page    |
      | Next Page        |
      | Page             |
      | Zoom Out         |
      | Zoom In          |
      | Page Width       |
      | Print            |
      | Download         |
      | Tools            |
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on page number textbox and enters 2
    Then the 2 page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on go to first page
    Then the first page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on go to last page
    Then the last page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on rotate clockwise
    Then the pdf document shall be rotated clockwise
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on rotate counterclockwise
    Then the pdf document shall be rotated counterclockwise
    When the user clicks on tools icon on top right side of pdf viewer
    Then the text selection tool shall be displayed as selected
    When the user selects any text on pdf viewer
    Then the user should be able to select text on pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on hand tool
    Then the hand tool shall be enabled
    And the user shall be able to move the pdf document using hand cursor tool
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on horizontal scrolling
    Then the horizontal scrolling bar shall be displayed at the bottom of pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on wrapped scrolling
    Then the wrapped scrolling bar shall be displayed at the bottom of pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on odd spreads
    Then the pdf pages shall be displayed side by side starting with odd pages
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on even spreads
    Then the pdf pages shall be displayed side by side starting with even pages
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on document properties
    Then the pdf document properties pop up shall be displayed
    And the following properties of pdf document shall be displayed
      | properties        |
      | file name         |
      | file size         |
      | title             |
      | author            |
      | subject           |
      | keywords          |
      | creation date     |
      | modification date |
      | creator           |
      | pdf producer      |
      | pdf version       |
      | page count        |
      | page size         |
      | fast web view     |
      | close button      |
    When the user clicks on close
    Then the pdf document properties popup shall be closed
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

   @helpInfo_TC1288	
  Scenario Outline: TC1288 - Surgeon_Verify DUU web app shall help menus tool feature.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the below components shall be displayed on top bar of pdf viewer
      | screen           |
      | Toggle Sidebar   |
      | Find in Document |
      | Previous Page    |
      | Next Page        |
      | Page             |
      | Zoom Out         |
      | Zoom In          |
      | Page Width       |
      | Print            |
      | Download         |
      | Tools            |
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on page number textbox and enters 2
    Then the 2 page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on go to first page
    Then the first page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on go to last page
    Then the last page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on rotate clockwise
    Then the pdf document shall be rotated clockwise
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on rotate counterclockwise
    Then the pdf document shall be rotated counterclockwise
    When the user clicks on tools icon on top right side of pdf viewer
    Then the text selection tool shall be displayed as selected
    When the user selects any text on pdf viewer
    Then the user should be able to select text on pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on hand tool
    Then the hand tool shall be enabled
    And the user shall be able to move the pdf document using hand cursor tool
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on horizontal scrolling
    Then the horizontal scrolling bar shall be displayed at the bottom of pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on wrapped scrolling
    Then the wrapped scrolling bar shall be displayed at the bottom of pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on odd spreads
    Then the pdf pages shall be displayed side by side starting with odd pages
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on even spreads
    Then the pdf pages shall be displayed side by side starting with even pages
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on document properties
    Then the pdf document properties pop up shall be displayed
    And the following properties of pdf document shall be displayed
      | properties        |
      | file name         |
      | file size         |
      | title             |
      | author            |
      | subject           |
      | keywords          |
      | creation date     |
      | modification date |
      | creator           |
      | pdf producer      |
      | pdf version       |
      | page count        |
      | page size         |
      | fast web view     |
      | close button      |
    When the user clicks on close
    Then the pdf document properties popup shall be closed
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed

    Examples: 
      | user                          |
      | ic-test-surgeon@capgemini.com |

  @helpInfo_TC1289
  Scenario Outline: TC1289 - Support_staff_Verify DUU web app shall help menus tool feature
      
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the below components shall be displayed on top bar of pdf viewer
      | screen           |
      | Toggle Sidebar   |
      | Find in Document |
      | Previous Page    |
      | Next Page        |
      | Page             |
      | Zoom Out         |
      | Zoom In          |
      | Page Width       |
      | Print            |
      | Download         |
      | Tools            |
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on page number textbox and enters 2
    Then the 2 page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on go to first page
    Then the first page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on go to last page
    Then the last page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on rotate clockwise
    Then the pdf document shall be rotated clockwise
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on rotate counterclockwise
    Then the pdf document shall be rotated counterclockwise
    When the user clicks on tools icon on top right side of pdf viewer
    Then the text selection tool shall be displayed as selected
    When the user selects any text on pdf viewer
    Then the user should be able to select text on pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on hand tool
    Then the hand tool shall be enabled
    And the user shall be able to move the pdf document using hand cursor tool
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on horizontal scrolling
    Then the horizontal scrolling bar shall be displayed at the bottom of pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on wrapped scrolling
    Then the wrapped scrolling bar shall be displayed at the bottom of pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on odd spreads
    Then the pdf pages shall be displayed side by side starting with odd pages
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on even spreads
    Then the pdf pages shall be displayed side by side starting with even pages
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on document properties
    Then the pdf document properties pop up shall be displayed
    And the following properties of pdf document shall be displayed
      | properties        |
      | file name         |
      | file size         |
      | title             |
      | author            |
      | subject           |
      | keywords          |
      | creation date     |
      | modification date |
      | creator           |
      | pdf producer      |
      | pdf version       |
      | page count        |
      | page size         |
      | fast web view     |
      | close button      |
    When the user clicks on close
    Then the pdf document properties popup shall be closed
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-nurse@capgemini.com |

  @helpInfo_TC1290
  Scenario Outline: TC1290 - Verify DUU web app shall help menus tool feature for sn HIL manager.
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the below components shall be displayed on top bar of pdf viewer
      | screen           |
      | Toggle Sidebar   |
      | Find in Document |
      | Previous Page    |
      | Next Page        |
      | Page             |
      | Zoom Out         |
      | Zoom In          |
      | Page Width       |
      | Print            |
      | Download         |
      | Tools            |
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on page number textbox and enters 2
    Then the 2 page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on go to first page
    Then the first page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on go to last page
    Then the last page of pdf viewer shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on rotate clockwise
    Then the pdf document shall be rotated clockwise
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on rotate counterclockwise
    Then the pdf document shall be rotated counterclockwise
    When the user clicks on tools icon on top right side of pdf viewer
    Then the text selection tool shall be displayed as selected
    When the user selects any text on pdf viewer
    Then the user should be able to select text on pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on hand tool
    Then the hand tool shall be enabled
    And the user shall be able to move the pdf document using hand cursor tool
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on horizontal scrolling
    Then the horizontal scrolling bar shall be displayed at the bottom of pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on wrapped scrolling
    Then the wrapped scrolling bar shall be displayed at the bottom of pdf viewer
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on odd spreads
    Then the pdf pages shall be displayed side by side starting with odd pages
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on even spreads
    Then the pdf pages shall be displayed side by side starting with even pages
    When the user clicks on tools icon on top right side of pdf viewer
    And the user clicks on document properties
    Then the pdf document properties pop up shall be displayed
    And the following properties of pdf document shall be displayed
      | properties        |
      | file name         |
      | file size         |
      | title             |
      | author            |
      | subject           |
      | keywords          |
      | creation date     |
      | modification date |
      | creator           |
      | pdf producer      |
      | pdf version       |
      | page count        |
      | page size         |
      | fast web view     |
      | close button      |
    When the user clicks on close
    Then the pdf document properties popup shall be closed
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed

    Examples: 
      | user                           |
      | ic-test-hicadmin@capgemini.com |


  @helpInfo_TC1241
  Scenario Outline: TC1241 - Verify DUU web app help menus UI for IC admin with display resolution 1920X1080(normal resolution).
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    #And the header text as help center shall be displayed at top left of the screen
    #And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
     And the below components shall be displayed on top bar of pdf viewer
      | screen           |
      | Toggle Sidebar   |
      | Find in Document |
      | Previous Page    |
      | Next Page        |
      | Page             |
      | Zoom Out         |
      | Zoom In          |
      | Page Width       |
      | Print            |
      | Download         |
      | Tools            |
   When user clicks on Next page button
   Then the second page of pdf viewer shall be displayed
   And the next page icon shall be disabled
   And the previous page icon shall be shall be enabled
   When user clicks on Previous page button
   Then the first page of pdf viewer shall be displayed
   And the next page icon shall be enabled
   And the previous page icon shall be shall be disabled
   #And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
   # When the user clicks on show document outline
   # Then the user shall not be able to click on show document outline icon if no otline available
   # When the user clicks on show attachments
   # Then the user shall not be able to click on show attachments icon if no attachments available
   # When the user clicks on search icon at top left bar of pdf viewer
   # Then a find search bar with text find in document shall be displayed
   # And the states find the previous occurrence of the phrase shall be displayed
  #  And the states find the next occurrence of the phrase shall be displayed
   # And the checkbox for highlight all shall be displayed
   # And the checkbox for match case shall be displayed
    #And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    #When User clicks on Upload files button from left menu bar
    #Then the right side header shall be displayed as upload files
    #And the upload file icon shall be displayed
   # And upload button shall be displayed
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on history button from left menu bar
    Then the right side header shall be displayed as history
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on audit log button from left menu bar
    Then the right side header shall be displayed as audit log
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on imaging links button from left menu bar
    Then the right side header shall be displayed as provider links
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on settings button from left menu bar
    Then the right side header shall be displayed as settings
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-admin@capgemini.com |


	@helpInfo_TC1242
  Scenario Outline: TC1242 - Verify DUU web app help menus UI for S&N HIL Manager with display resolution 1920X1080(normal resolution).
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When User clicks on Upload files button from left menu bar
    Then the right side header shall be displayed as upload files
    And the upload file icon shall be displayed
    And upload button shall be displayed
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on history button from left menu bar
    Then the right side header shall be displayed as history
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on audit log button from left menu bar
    Then the right side header shall be displayed as audit log
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on imaging links button from left menu bar
    Then the right side header shall be displayed as provider links
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on settings button from left menu bar
    Then the right side header shall be displayed as settings
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed

    Examples: 
      | user                           |
      | ic-test-hicadmin@capgemini.com |

  @helpInfo_TC1243
  Scenario Outline: TC1243 - Verify DUU web app help menus UI for IC technician with display resolution 1280X720 (min resolution).
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When User clicks on Upload files button from left menu bar
    Then the right side header shall be displayed as upload files
    And the upload file icon shall be displayed
    And upload button shall be displayed
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on history button from left menu bar
    Then the right side header shall be displayed as history
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on audit log button from left menu bar
    Then the right side header shall be displayed as audit log
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on imaging links button from left menu bar
    Then the right side header shall be displayed as provider links
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on settings button from left menu bar
    Then the right side header shall be displayed as settings
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed

    Examples: 
      | user                       |
      | ic-test-tech@capgemini.com |

  @helpInfo_TC1244
  Scenario Outline: TC1244 - Verify DUU web app help menus UI for Support staff with display resolution 1280X720 (min resolution).
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When User clicks on Upload files button from left menu bar
    Then the right side header shall be displayed as upload files
    And the upload file icon shall be displayed
    And upload button shall be displayed
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on history button from left menu bar
    Then the right side header shall be displayed as history
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on audit log button from left menu bar
    Then the right side header shall be displayed as audit log
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on imaging links button from left menu bar
    Then the right side header shall be displayed as provider links
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on settings button from left menu bar
    Then the right side header shall be displayed as settings
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed

    Examples: 
      | user                        |
      | ic-test-nurse@capgemini.com |


  @helpInfo_TC1275
  Scenario Outline: TC1275 - Verify DUU web app help menus UI for hospital admin with display resolution 1280X800 (min resolution).
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When User clicks on Upload files button from left menu bar
    Then the right side header shall be displayed as upload files
    And the upload file icon shall be displayed
    And upload button shall be displayed
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on history button from left menu bar
    Then the right side header shall be displayed as history
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on audit log button from left menu bar
    Then the right side header shall be displayed as audit log
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on imaging links button from left menu bar
    Then the right side header shall be displayed as provider links
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on settings button from left menu bar
    Then the right side header shall be displayed as settings
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed

    Examples: 
      | user                       |
      | h-test-admin@capgemini.com |

 @helpInfo_TC1278 
  Scenario Outline: TC1278 - Verify DUU web app help menus UI for surgeon with display resolution 1280X800 (min resolution).
    Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    And file dashboad page is displayed to user
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When User clicks on Upload files button from left menu bar
    Then the right side header shall be displayed as upload files
    And the upload file icon shall be displayed
    And upload button shall be displayed
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on upload status button from left menu bar
    Then the right side header shall be displayed as upload status
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on history button from left menu bar
    Then the right side header shall be displayed as history
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on audit log button from left menu bar
    Then the right side header shall be displayed as audit log
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on imaging links button from left menu bar
    Then the right side header shall be displayed as provider links
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on settings button from left menu bar
    Then the right side header shall be displayed as settings
    When user clicks on help center menu icon
    Then pdf viewer is displayed on left menu panel
    And the header text as help center shall be displayed at top left of the screen
    And the pdf viewer popup shall be displayed
    And the help center text shall be displayed in white colour
    And the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When user clicks on Next page button
    Then the second page of pdf viewer shall be displayed
    And the next page icon shall be disabled
    And the previous page icon shall be shall be enabled
    When user clicks on Previous page button
    Then the first page of pdf viewer shall be displayed
    And the next page icon shall be enabled
    And the previous page icon shall be shall be disabled
    And the content of pdf viewer shall be displayed in black colour
    When user clicks on Toggle Sidebar
    Then the menu bar slights from left to right that displays below components
      | screen                |
      | Show Thumbnails       |
      | Show Document Outline |
      | Show Attachments      |
    When the user clicks on show document outline
    Then the user shall not be able to click on show document outline icon if no otline available
    When the user clicks on show attachments
    Then the user shall not be able to click on show attachments icon if no attachments available
    When the user clicks on search icon at top left bar of pdf viewer
    Then a find search bar with text find in document shall be displayed
    And the states find the previous occurrence of the phrase shall be displayed
    And the states find the next occurrence of the phrase shall be displayed
    And the checkbox for highlight all shall be displayed
    And the checkbox for match case shall be displayed
    And the checkbox for whole words shall be displayed
    When the user clicks on tools icon on top right side of pdf viewer
    Then the following tool feature pop up shall be opened
      | option                  |
      | Go to first page        |
      | Go to last page         |
      | Rotate clockwise        |
      | Rotate counterclockwise |
      | text selection tool     |
      | Hand tool               |
      | Vertical scrolling      |
      | Horizontal scrolling    |
      | Wrapped scrolling       |
      | No spreads              |
      | Odd Spreads             |
      | Even spreads            |
      | Document properties     |
    When the user clicks on exit to app button from left menu bar
    Then the Application access screen is displayed
    When user clicks on Logout icon from left panel
    Then user is logout from the application.
   # And Data-Upload Application is closed

    Examples: 
      | user                          |
      | ic-test-surgeon@capgemini.com |
