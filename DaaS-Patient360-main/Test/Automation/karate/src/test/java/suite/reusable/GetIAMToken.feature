Feature: IAM Token

  Scenario: GET request to IAM
  	* def client = {client_id: "#(authInfo.username)", client_secret:"#(authInfo.password)"}
    * def authResponse = call read('classpath:suite/reusable/BasicAuth.js') { username: "#(authInfo.username)", password: "#(authInfo.password)" }
    * def username =  authInfo.iam_uname
    * def password =  authInfo.iam_pword
    And print authInfo.username
    And print authInfo.password
    And header Content-Type = 'application/x-www-form-urlencoded'
    And header Api-version = 2
    And header Authorization = authResponse
    Given url IAM_URL
    And request "grant_type=password&username="+username+"&password="+password
    And print authResponse
    When method POST
    Then status 200
    And print response
		And print response.access_token
		And def Access_Token = response.access_token
		And print Access_Token