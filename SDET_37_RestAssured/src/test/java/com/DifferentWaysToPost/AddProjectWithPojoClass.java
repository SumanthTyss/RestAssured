package com.DifferentWaysToPost;

import static io.restassured.RestAssured.given;

import pojoClassForCrudOperation.pojoClassForAddProject;

public class AddProjectWithPojoClass {
	
	public static void main(String[] args) {
		pojoClassForAddProject pojo=new pojoClassForAddProject("Sumanth", "Tummoc", "On going", 5);
		given()
			.body(pojo).contentType(io.restassured.http.ContentType.JSON)
		.when()
			.post("http://localhost8084/addProject")
		.then()
			.assertThat().statusCode(201).contentType(io.restassured.http.ContentType.JSON);
		
	}
	
	
	
	

}
