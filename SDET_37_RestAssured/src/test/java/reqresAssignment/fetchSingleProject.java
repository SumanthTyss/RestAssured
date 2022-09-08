package reqresAssignment;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class fetchSingleProject {
	@Test
	private void fetchproject() {
		
		when()
		.get("https://reqres.in/api/users/2")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}

}
