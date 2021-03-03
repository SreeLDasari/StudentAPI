package model.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecFactory {


	public static RequestSpecification getGenericRequestSpec() {

		RequestSpecBuilder requestSpec;
		RequestSpecification requestSpecification;

		requestSpec = new RequestSpecBuilder();
		requestSpecification = requestSpec.setContentType("application/json;charset=UTF-8").build();

		return requestSpecification;

	}
	public static ResponseSpecification getGenericResponseSpec() {

		ResponseSpecBuilder responseSpec;
		ResponseSpecification responseSpecification;

		responseSpec = new ResponseSpecBuilder();
		responseSpec.expectHeader("Content-Type","application/json;charset=UTF-8");
		responseSpec.expectHeader("Transfer-Encoding","chunked");
		responseSpec.expectStatusLine("HTTP/1.1 200");
		responseSpecification = responseSpec.build();

		return responseSpecification;

	}

}
