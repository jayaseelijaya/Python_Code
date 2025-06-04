#Feature: UI - Verifying Summary Dashboard screen UI for Admin users.
#
  #Scenario Outline: TC0800 - Verify the screen summary dashobard UI for admin user
    #Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    #Then Homepage is displayed to the user
    #And the file dashboard on left menu panel shall be highlighted
    #And the header text as upload dashboard shall be displayed
    #And the processing checkbox shall be displayed
    #And the processing checkbox shall have circled arrow in grey colour
    #And the uploaded checkbox shall be displayed
    #And the uploaded checkbox shall have tick mark icon in white colour
    #And the complete checkbox shall be displayed
    #And the complete checkbox shall have tick mark icon in green colour
    #And the error checkbox shall be displayed
    #And the error checkbox shall have exclamation mark icon in yellow colour
    #And the 24hrs checkbox shall be displayed
    #And the 24hrs checkbox shall have icon in white colour
    #And the filter button shall be displayed
    #And the filter button shall have three lines icon in white colour
    #And the Searchbox shall be displayed
    #And the search box shall have icon in white colour
    #And the search button shall be displayed
    #And the search button shall be displayed in green colour
    #When the user clicks on filter button
    #Then the following filter menu shall be displayed
      #| menu        |
      #| filter by   |
      #| date        |
      #| surgeon     |
      #| site        |
      #| application |
      #| file status |
    #And the done button shall be displayed in green colour
    #When the user selects multiple filters
    #And the user clicks on Done button
    #And the selected filters shall be displayed on top left corner
    #And selected filter shall have icon as X
    #And Data-Upload Application is closed
#
    #Examples: 
      #| user                       |
      #  | ic-test-admin@capgemini.com |
      #| ic-test-tech@capgemini.com |
#
  #|ic-test-nurse@capgemini.com |
  #|ic-test-surgeon@capgemini.com |
#
  #Scenario Outline: TC0802 - Verify the screen summary dashobard UI for non-admin user
    #Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    #Then Homepage is displayed to the user
    #And the file dashboard on left menu panel shall be highlighted
    #And the header text as upload dashboard shall be displayed
    #And the processing checkbox shall be displayed
    #And the processing checkbox shall have circled arrow in grey colour
    #And the uploaded checkbox shall be displayed
    #And the uploaded checkbox shall have tick mark icon in white colour
    #And the complete checkbox shall be displayed
    #And the complete checkbox shall have tick mark icon in green colour
    #And the error checkbox shall be displayed
    #And the error checkbox shall have exclamation mark icon in yellow colour
    #And the 24hrs checkbox shall be displayed
    #And the 24hrs checkbox shall have icon in white colour
    #And the filter button shall be displayed
    #And the filter button shall have three lines icon in white colour
    #And the Searchbox shall be displayed
    #And the search box shall have icon in white colour
    #And the search button shall be displayed
    #And the search button shall be displayed in green colour
    #When the user clicks on filter button
    #Then the following filter menu shall be displayed
      #| menu        |
      #| filter by   |
      #| date        |
      #| surgeon     |
      #| site        |
      #| application |
      #| file status |
    #And the done button shall be displayed in green colour
    #When the user selects multiple filters
    #And the user clicks on Done button
    #And the selected filters shall be displayed on top left corner
    #And selected filter shall have icon as X
    #And Data-Upload Application is closed
#
    #Examples: 
      #| user                       |
        #| ic-test-admin@capgemini.com |
      #| ic-test-tech@capgemini.com |
#		#|ic-test-nurse@capgemini.com |
#		#|ic-test-surgeon@capgemini.com |
