Feature: SSR1801 - Verifying the search criteria of organization selection
@txt
  Scenario Outline: TC0851 - Verify DUU web App shall be searchable by organization selection.
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
    And the search box shall be displayed
    And List of facility is displayed to user
    When the user enters partial site name in upper case in searchbox
    Then the list shall display searched uppercase site name
    #When the user enters valid site name in upper and lower case in search box
    #Then the list shall display searched upper and lower case site name
    #When the user enters site name in lower case in searchbox
    #Then the list shall display searched lower case site name
    #When the user enters Baystate Wing Hospital text in search box
    #Then the list shall display entered Baystate Wing Hospital text
    #When the user hover the cursor on one of site name from the list
    #Then the site name shall be displayed in green colour
    When the user clears the search box
    #Then the site shall be displayed in alphabetical order
    #And Data-Upload Application is closed 
 
 Examples: 
		|user|  
		|ic-test-admin@capgemini.com |
		#|ic-test-tech@capgemini.com |
		#|ic-test-nurse@capgemini.com |
		#|ic-test-surgeon@capgemini.com |