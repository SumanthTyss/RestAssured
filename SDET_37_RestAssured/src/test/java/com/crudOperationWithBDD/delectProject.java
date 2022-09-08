package com.crudOperationWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;


public class delectProject {
	@Test
	public void delete() {
		
	when()
	.delete("http://localhost:8084/projects/TY_PROJ_402")
	.then()
	.log().all()
	.assertThat().statusCode(500);
	}

}
