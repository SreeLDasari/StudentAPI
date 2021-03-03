package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import model.requests.RestRequest;
import model.response.RestResponse;

public class PostStudentDetails {

	Response response;
	RestResponse rest=new RestResponse(response);
	RestRequest request=new RestRequest(response);

	
	@Given("User should set the content type to json")
	public void user_should_set_the_content_type_to_json() {
		rest.Contentype();
	}

	@When("create the student record in student API")
	public void create_the_student_record_in_student_api() {
		
		request.createNewStudent();

	}

	@Then("student details created data fetched with status code {int}")
	public void student_details_created_data_fetched_with_status_code(int expected) {

		int actual=request.createNewStudent().getStatusCode();
		Assert.assertEquals(actual, expected);

	}

}
