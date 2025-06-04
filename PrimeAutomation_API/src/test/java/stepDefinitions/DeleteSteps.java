package stepDefinitions;
/*
 * package stepdefinitions;
 * 
 * import static io.restassured.RestAssured.given;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * import org.apache.log4j.Logger;
 * 
 * import io.cucumber.java.en.Given; import io.cucumber.java.en.Then; import
 * io.cucumber.java.en.When; import io.restassured.RestAssured; import
 * io.restassured.response.Response; import
 * io.restassured.response.ResponseBody; import
 * io.restassured.specification.RequestSpecification;
 * 
 * public class DeleteSteps {
 * 
 * RequestSpecification _RESP_SPEC; Response _RESPONSE; final static Logger
 * logger = Logger.getLogger(DeleteSteps.class); String userId=
 * "de5d75d1-59b4-487e-b632-f18bc0665c0d"; String
 * baseUri="https://demoqa.com/swagger/"; //String token =
 * "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3RpbmcxMjMiLCJwYXNzd29yZCI6IlBhc3N3b3JkQDEiLCJpYXQiOjE2Mjg1NjQyMjF9.lW8JJvJF7jKebbqPiHOBGtCAus8D9Nv1BK6IoIIMJQ4";
 * String isbn ="9781449337711";
 * 
 * //*********************GIVEN BLOCK*******************************
 * 
 * @Given("base url is entered") public void base_url_is_entered() throws
 * IOException { logger.info("Base_url_is_entered"); _RESP_SPEC =
 * given().baseUri(baseUri); logger.info("Base_url : " + baseUri); }
 * 
 * @When("user enters valid {string} {string} and trigger the Get api") public
 * void user_enters_valid_and_trigger_the_get_api(String Authorization, String
 * token) throws IOException { _RESP_SPEC.header(Authorization,
 * token).header("Content-Type", "application/json"); _RESPONSE =
 * _RESP_SPEC.get("/Account/v1/User/"+userId); logger.info("API is triggered");
 * }
 * 
 * @When("response is generated") public void response_is_generated() {
 * logger.info("Response is generated"); String resp =
 * _RESPONSE.then().assertThat().statusCode(200).extract().response().asString()
 * ; logger.info("Response body as : " + resp);
 * 
 * }
 * 
 * @When("user enters valid {string} {string} and trigger the Delete api")
 * public void user_enters_valid_and_trigger_the_delete_api(String
 * Authorization, String token) throws IOException {
 * _RESP_SPEC.header(Authorization, token).header("Content-Type",
 * "application/json"); _RESPONSE = _RESP_SPEC.body("{ \"isbn\": \"" + isbn +
 * "\", \"userId\": \"" + userId + "\"}").delete("/BookStore/v1/Book");
 * logger.info("API is triggered"); }
 * 
 * @Then("response generated with status code as {int}") public void
 * response_generated_with_status_code_as(Integer int1) {
 * logger.info("Response is generated"); String resp =
 * _RESPONSE.then().assertThat().statusCode(204).extract().response().asString()
 * ; logger.info("Response body as :" + resp); } }
 */