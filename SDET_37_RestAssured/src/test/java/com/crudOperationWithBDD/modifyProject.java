package com.crudOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class modifyProject {
	@SuppressWarnings("unchecked")
	@Test  
	public void updateProject() {
	JSONObject jObject= new JSONObject();
	jObject.put("createdBy", "radha");
	jObject.put("projectName", "myntra");
	jObject.put("status", "Created");
	jObject.put("teamSize", 50);
	given()
	.contentType(ContentType.JSON)
	.body(jObject)
	.when()
	.put("http://localhost:8084/projects/TY_PROJ_803")
	.then()
	.log().all()
	.assertThat().statusCode(200)
	.assertThat().contentType(ContentType.JSON);
	}

}
