package com.crudOperationWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class fetchParticularProject {

	@Test
	public void fetch_1_Project() {
		when()
		.get("http://localhost:8084/projects/TY_PROJ_803")
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}

}

