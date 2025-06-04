@parallel=false 
@UTC_570711 @TC_570711 @USUID_566677

Feature: get Random number with name

	Background:
		* url randomNum_host
	
	@S_1	
	Scenario: incorrect path
		Given path '/generate1'
		When method get
		Then status 404

  