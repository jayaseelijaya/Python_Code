@parallel=false 
@UTC_570708 @TC_570708 @USUID_566677

Feature: get customized greeting 

	Background:
		* url greet_host
	
	@S_1	
	Scenario: incorrect path
		Given path '/hello1'
		When method get
		Then status 404
		