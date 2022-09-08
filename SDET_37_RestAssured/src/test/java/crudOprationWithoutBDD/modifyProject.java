package crudOprationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class modifyProject {
	@Test
	public void Modify(){
		
		//Json Body
		JSONObject json=new JSONObject();
		json.get("createdBy");
		json.get("projectName");
		json.get("status");
		json.get("teamSize");
		
		//preconditions(body and content type)
		RequestSpecification reqspc=RestAssured.given();
		reqspc.body(json);
		reqspc.contentType(ContentType.JSON);
		
		//Validation
		Response response=reqspc.post("http://localhost:8084/addProject");
		ValidatableResponse validate = response.then(); 
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(409);
		validate.log().all();
	}
}
