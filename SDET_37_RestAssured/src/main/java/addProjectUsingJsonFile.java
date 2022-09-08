import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class addProjectUsingJsonFile {
	@SuppressWarnings("unchecked")
	@Test
	private void createProject() {
		
		

		File file=new File("./src/test/resources/abc.json");
		


		given()
		.body(file).contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();

	}


}
