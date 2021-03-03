package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import model.requests.RestRequest;
import model.response.RestResponse;

public class GetStudentRecords {
	Response response;
	RestResponse rest=new RestResponse(response);
	RestRequest request=new RestRequest(response);

	@Given("A list of students are available")
	public void a_list_of_students_are_available() {

		request.getAllStudents();

	}

	@When("I get the details of students")
	public void i_get_the_details_of_students() {
		rest.getContent("/list");

	}

	@Then("Students details should be displayed with status code {int}")
	public void students_details_should_be_displayed_with_status_code(int statuscode) {

		int actual=rest.getStatusCode("/list");
		Assert.assertEquals(actual, statuscode);

	}


}
