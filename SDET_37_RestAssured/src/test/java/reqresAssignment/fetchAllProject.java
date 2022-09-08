package reqresAssignment;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class fetchAllProject {
	@Test
	private void getAllProject() {
		when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.assertThat().statusCode(200)
		.log().all();



	}

}
