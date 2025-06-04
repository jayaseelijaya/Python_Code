#Feature: SSR1811 - Verifying summary dashboard file processing status
#
  #Scenario Outline: TC0746 - Verify DDU web App Summary dashboard shall display file processing status of already uploaded files
    #Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    #Then Homepage is displayed to the user
    #And the dashboard summary shall display list of upload items
    #And the following information shall be displayed at left navigation bar
    #| infomation  		|
#	  | File dashboard	|
#	  | Upload files		|
#	  | Upload status		|
#	  | History					|
#	  | Audit log				|
#	  | imaging links		|
#	  | settings				|
#	 And the below six columns shall be displayed
    #| columns 			|
    #| uploader icon |
    #| surgeon name	|
    #| patient name	|
    #| application	  |
   #And the first column shall display file processing status icon
   #And the second column shall display surgeon name with first name last name
   #And the date of the file uploaded shall be displayed  
   #And Data-Upload Application is closed
   #
   #Examples: 
#		|user|  
#		|ic-test-admin@capgemini.com |
#		#|ic-test-tech@capgemini.com |
#		#|ic-test-nurse@capgemini.com |
#		#|ic-test-surgeon@capgemini.com |
#		
#	@new
#	Scenario Outline: TC0746 - Verify DDU web App Summary dashboard shall display file processing status of already uploaded files
    #Given that the user is logged in to Data-Upload Utility Application through chrome "<user>"
    #Then Homepage is displayed to the user
    #And the dashboard summary shall display list of upload items
    #And the each dashboard item shall be displayed with respective processing status
    #And Data-Upload Application is closed
   #
   #Examples: 
#		|user|  
#		|ic-test-admin@capgemini.com |
#		#|ic-test-tech@capgemini.com |
#		#|ic-test-nurse@capgemini.com |
#		#|ic-test-surgeon@capgemini.com |
#		
#		
