package parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class queryParameter {
	@Test
	private void QueryParameter() {
		given()
		.queryParam("page", 2)
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.assertThat().statusCode(200).log().all();
	}

}
