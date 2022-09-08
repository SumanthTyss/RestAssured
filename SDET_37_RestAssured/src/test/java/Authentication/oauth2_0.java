package Authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class oauth2_0 {

	@Test
	private void oauth2() {
		Response response = given()
				.formParam("client_id", "rmgyantra")
				.formParam("client_secret", "12d8b2139cc3d89f8e486b7089d47e94")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "https://example.com")
				.formParam("code", "authorization_code")

				.when()
				.post("http://coop.apps.symfonycasts.com/token");

				String token = response.jsonPath().get("access_token");
		given()

		.auth().oauth2(token)
		.pathParam("USER_ID", "3743")

		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")

		.then().log().all();


	}

}
