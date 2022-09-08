package com.DifferentWaysToPost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class addProjectWithJsonObject {
	@SuppressWarnings("unchecked")
	@Test
	private void createProject() {
		
				JavaUtility jlib = new JavaUtility();
				int rand = jlib.getRandomNumber();
				JSONObject json=new JSONObject();
				json.put("createdBy", "Dhyan");
				json.put("projectName", "Redmi"+rand);
				json.put("status", "on going");
				json.put("teamSize", 5);
				
				
				given()
				.body(json).contentType(ContentType.JSON)
				.when()
				.post("http://localhost:8084/addProject")
				.then()
				.assertThat().statusCode(201)
				.log().all();

}
}
