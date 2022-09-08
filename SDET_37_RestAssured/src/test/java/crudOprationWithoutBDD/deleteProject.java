package crudOprationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class deleteProject {
	@Test
	public void delete() {
		
		
		Response response=RestAssured.delete("http://localhost:8084/projects/TY_PROJ_003");
		ValidatableResponse validate = response.then(); 
		validate.assertThat().statusCode(204);
		validate.log().all();
		
		
	}

}
