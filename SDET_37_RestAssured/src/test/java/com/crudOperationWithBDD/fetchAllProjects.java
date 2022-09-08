package com.crudOperationWithBDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


import io.restassured.http.ContentType;

public class fetchAllProjects {
	@Test
	public void getAllProjects() {
	when()
	.get("http://localhost:8084/projects")
	.then()
	.assertThat().statusCode(200)
	.assertThat().contentType(ContentType.JSON)
	.log().all();
	}
	
}
