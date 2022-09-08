package com.crudOperationWithBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class addProject {
	@SuppressWarnings("unchecked")
	@Test
	public void createProject() {
	JSONObject jObject= new JSONObject();
	jObject.put("createdBy", "erjrgwletjkg");
	jObject.put("projectName", "ergege-2");
	jObject.put("status", "Created");
	jObject.put("teamSize", 10);
	given()
	.contentType(ContentType.JSON)
	.body(jObject)
	.when()                                                                           
	.post("http://localhost:8084/addProject")
	.then()
	.log().all()
	.assertThat().statusCode(201)
	.assertThat().contentType(ContentType.JSON);
	}

}
