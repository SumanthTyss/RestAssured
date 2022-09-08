package com.DifferentWaysToPost;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class addProjectWithHashMap {
	@SuppressWarnings("unchecked")
	@Test
	private void createProject() {
		
		

		JavaUtility jlib = new JavaUtility();
		int rand = jlib.getRandomNumber();
		HashMap hash = new HashMap();
		hash.put("createdBy", "Dhyan1");
		hash.put("projectName", "Redmi MI"+rand);
		hash.put("status", "on going");
		hash.put("teamSize", 5);


		given()
		.body(hash).contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();

	}

}



