package model.requests;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.pojo.StudentPOJO;
import model.response.RestResponse;

public class RestRequest{
	Response response;
	public RestRequest(Response response) {
		this.response=response;
	}

	RestResponse restResponse=new RestResponse(response);
	
	public Response getAllStudents() {
		
		response=restResponse.doGetReq("/list");
		return response;
	}
	public Response createNewStudent() {
		Faker fake=new Faker();
		ArrayList<String> courses=new ArrayList<>();
		courses.add("java");
		courses.add("cpp");
		StudentPOJO stu=new StudentPOJO();
		stu.setSid(fake.number().randomDigit());
		stu.setCourses(courses);
		stu.setEmail(fake.internet().emailAddress());
		stu.setFirstName(fake.name().firstName());
		stu.setLastName(fake.name().lastName());
		stu.setProgramme(fake.educator().course());
		response=restResponse.doPostreq(stu);
		return response;

	}
	public void getStudent(String reqPath) {
		restResponse.doGetReq(reqPath).as(StudentPOJO.class);
	}

	
}

