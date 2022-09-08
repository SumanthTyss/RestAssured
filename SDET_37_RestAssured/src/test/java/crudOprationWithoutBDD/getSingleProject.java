package crudOprationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class getSingleProject {
	
	@Test
	public void singleFetch() {
		//preconditions(body and content type)
		RequestSpecification reqspc=RestAssured.given();
		reqspc.contentType(ContentType.JSON);
		
		//Validation
		Response response=reqspc.get("http://localhost:8084/projects/TY_PROJ_004");
		ValidatableResponse validate = response.then(); 
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		validate.log().all();
		
	}
	
	

}
