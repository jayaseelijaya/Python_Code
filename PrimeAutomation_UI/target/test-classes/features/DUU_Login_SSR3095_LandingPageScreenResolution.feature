Feature: SSR3095 - Verifying user can view login information on landing page
#
#Scenario Outline: TC1600 - Hospital Admin_Verify DUU app shall view login information on landing page with display resolution of 1280X720.
#Given that the user is logged in to Data-Upload Utility Application through chrome with minimum screen resolution "<user>"
#Then Homepage is displayed to the user
#And the following information shall be displayed at left navigation bar
      #| infomation     |
      #| File dashboard |  
      #| Upload files   |
      #| Upload status  |
      #| History        |
      #| Audit log      |
      #| imaging links  |
      #| settings       |
      #| Exit to app    |
#And Upload dashboad page is displayed to user 
#And the following components shall be displayed on right side of upload dashboard
  #| dashboard										|
  #| dashboard heading						|
  #| uploaded records table			|
  #| processing status checkbox	|
  #| uploaded status checkbox		|
  #| complete status checkbox		|
  #| error status checkbox				|
  #| 24hrs checkbox							|
  #| filter											|
  #| search box									|
  #| search button								|
#When User clicks on Upload Files from left panel
#Then the following components shall be displayed on right side of upload files
   #| upload								|
   #| upload files heading	|
   #| upload icon					|
   #| upload button				| 
#When the user clicks on upload status button from left menu bar
#Then the following components shall be displayed on right side of upload status
   #| status		|
   #| upload status heading	|
   #| uploaded records table	|
   #| view details buttom		|
#When the user clicks on history button from left menu bar
#Then the following components shall be displayed on right side of history
   #| history							|
   #| history heading			|
   #| 24hrs checkbox				|
   #| filter								|
   #| search textbox				|
   #| search button				|
   #| record table					|
   #| view details button	|
   #| show more						| 
#When the user clicks on audit log button from left menu bar 
#Then the following components shall be displayed on right side of audit log
   #| audit							|
   #| audit log heading	|
   #| 24hrs checkbox			|
   #| filter							|
   #| search textbox				|
   #| search button				| 
   #| audit log list table	|
   #| exported selected		|
   #| exported all					|
   #| show more						|
#When the user clicks on imaging links button from left menu bar
#Then the following components shall be displayed on right side of imaging links
   #| imaging										|
   #| list of linked facilities	|
   #| remove button							|
#When the user clicks on settings button from left menu bar  
#Then the following components shall be displayed on right side of settings
   #| settings											|
   #| successful expiration				|
   #| unsuccessful expiration			|
   #| global viewing toggle button	|
   #| reset to default							|
   #| save button									|
#When user clicks on help center menu icon
#Then pdf viewer is displayed on left menu panel 
#When the user clicks on software information icon from left menu bar
#Then the software information popup shall be displayed
#And the software version details shall be displayed
#And the cross button shall be displayed
#When the user click on cross button
#And the user clicks on exit to app button from left menu bar
#Then the right side header shall be displayed as exit to app works
#When user clicks on Logout icon from left panel
#Then user is logout from the application.
#And Data-Upload Application is closed
#
  #Examples: 
#		|user|  
#		|h-test-admin@capgemini.com |
#		
#		
#Scenario Outline: TC1601 - IC Technician_Verify DUU app shall view login information on landing page with display resolution of 1280X720.
#Given that the user is logged in to Data-Upload Utility Application through chrome with minimum screen resolution "<user>"
#Then Homepage is displayed to the user
#And the following information shall be displayed at left navigation bar
      #| infomation     |
      #| File dashboard |  
      #| Upload files   |
      #| Upload status  |
      #| History        |
      #| Audit log      |
      #| imaging links  |
      #| settings       |
      #| Exit to app    |
#And Upload dashboad page is displayed to user 
#And the following components shall be displayed on right side of upload dashboard
  #| dashboard										|
  #| dashboard heading						|
  #| uploaded records table			|
  #| processing status checkbox	|
  #| uploaded status checkbox		|
  #| complete status checkbox		|
  #| error status checkbox				|
  #| 24hrs checkbox							|
  #| filter											|
  #| search box									|
  #| search button								|
#When User clicks on Upload Files from left panel
#Then the following components shall be displayed on right side of upload files
   #| upload								|
   #| upload files heading	|
   #| upload icon					|
   #| upload button				| 
#When the user clicks on upload status button from left menu bar
#Then the following components shall be displayed on right side of upload status
   #| status		|
   #| upload status heading	|
   #| uploaded records table	|
   #| view details buttom		|
#When the user clicks on history button from left menu bar
#Then the following components shall be displayed on right side of history
   #| history							|
   #| history heading			|
   #| 24hrs checkbox				|
   #| filter								|
   #| search textbox				|
   #| search button				|
   #| record table					|
   #| view details button	|
   #| show more						| 
#When the user clicks on audit log button from left menu bar 
#Then the following components shall be displayed on right side of audit log
   #| audit							|
   #| audit log heading	|
   #| 24hrs checkbox			|
   #| filter							|
   #| search textbox				|
   #| search button				| 
   #| audit log list table	|
   #| exported selected		|
   #| exported all					|
   #| show more						|
#When the user clicks on imaging links button from left menu bar
#Then the following components shall be displayed on right side of imaging links
   #| imaging										|
   #| list of linked facilities	|
   #| remove button							|
#When the user clicks on settings button from left menu bar  
#Then the following components shall be displayed on right side of settings
   #| settings											|
   #| successful expiration				|
   #| unsuccessful expiration			|
   #| global viewing toggle button	|
   #| reset to default							|
   #| save button									|
#When user clicks on help center menu icon
#Then pdf viewer is displayed on left menu panel 
#When the user clicks on software information icon from left menu bar
#Then the software information popup shall be displayed
#And the software version details shall be displayed
#And the cross button shall be displayed
#When the user click on cross button
#And the user clicks on exit to app button from left menu bar
#Then the right side header shall be displayed as exit to app works
#When user clicks on Logout icon from left panel
#Then user is logout from the application.
#And Data-Upload Application is closed
#
  #Examples: 
#		|user|  
#		|ic-test-tech@capgemini.com |		
#		
								