package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GetUsersStepDefinitions {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
    private String usersEndpoint = "https://reqres.in/api";
    private String usersPath = "/users";
    private String userIdPath = "/users/{userid}";
	
	@Given("users exist in the system on page {int}")
	public void users_exist_in_the_system_on_page(Integer pageNo) {
	    request = given().param("page", pageNo).contentType("application/json");
	}

	@When("user requests the list of all users on page {int}")
	public void user_requests_the_list_of_all_users_on_page(Integer pageNo) {
		response = request.when().get(usersEndpoint + usersPath);
	}
	
	@Then("return the list of users on page {int}")
	public void return_the_list_of_users_on_page(Integer pageNo) {
		response.then().body("page", equalTo(pageNo));
	}
	
	@Then("the user list has the correct schema")
	public void the_user_list_has_the_correct_schema() {
		response.then().assertThat().body(matchesJsonSchemaInClasspath("users_schema.json"));
	}
	
	@Then("status code is {int}")
	public void status_code_is(Integer statusCode) {
		response.then().statusCode(statusCode);
	}
	
	@Given("users exist in the system with id of {int}")                           
	public void users_exist_in_the_system_with_id_of(Integer userId) {               
		request = given().pathParam("userid", userId).contentType("application/json");
	}                                                                                                              
	                                                                               
	@When("user requests the user with id of {int}")                               
	public void user_requests_the_user_with_id_of(Integer userId) {                  
		response = request.when().get(usersEndpoint + userIdPath);
	}

	@Then("return the data for user with id of {int}")                             
	public void return_the_data_for_user_with_id_of(Integer userId) {
		response.then().body("data.id", equalTo(userId));
	}
	
	@Then("the email address is {string}")                             
	public void the_email_address_is(String userEmail) {
		response.then().body("data.email", equalTo(userEmail));
	}
	
}
