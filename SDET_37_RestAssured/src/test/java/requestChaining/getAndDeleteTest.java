package requestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class getAndDeleteTest {
	
	@Test
	private void reqestChaining2() {
		Response allProjects = when().get("http://localhost:8084/projects");
		allProjects.then().assertThat().statusCode(200).log().all();
		
		String projID = allProjects.jsonPath().get("[0].projectId");
		System.out.println(projID);
		
		given()
		.pathParam("projectID", projID)
		.when()
		.delete("http://localhost:8084/projects/{projectID}")
		.then()
		.assertThat().statusCode(204).log().all();
		
		
	}

}
