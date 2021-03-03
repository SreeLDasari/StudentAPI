package model.response;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import model.spec.SpecFactory;

public class RestResponse{
	
	private Response response;
	private RequestSpecification request= RestAssured.given();
	

			
	public RestResponse(Response response){
		this.response=response;
	
	}
	
	public RequestSpecification Contentype() {
		return request.header("Content-Type", "application/json");
	}
	
	public Response getResponse() {
		return response;
	}
	
	public String getContent(String reqPath) {
		return get(reqPath).getContentType();
	}

	
	public int getStatusCode(String reqPath) {
		return get(reqPath).getStatusCode();

	}
	
	public Response doGetReq(String reqPath) {
		return given()
				.when()
				.get(reqPath);
	}
	
	public Response doPostreq(Object body) {
		return given()
				.spec(SpecFactory.getGenericRequestSpec())
				.contentType(ContentType.JSON)
				.when()
				.body(body)
				.post();
	}
	public void expectHeadersSatuscode() {
				given()
				.when()
				.get()
				.then()
				.spec(SpecFactory.getGenericResponseSpec()).log().all();
				
	}

}
