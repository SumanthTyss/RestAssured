package parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class pathParameter {
	@Test
	private void PathParameter() {
		
		//Response allProjects = when().get("http://localhost:8084/projects");
		//String projID = allProjects.jsonPath().get("projectId");

		given()
		.pathParam("projectID", "TY_PROJ_007")
		.when()
		.get("http://localhost:8084/projects/{projectID}")
		.then()
		.assertThat().statusCode(200).log().all();
	}
	



}
