package validation;

import static io.restassured.RestAssured.when;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class hamCrestBodyyValidation {
	@Test
	private void bodyValidation() {
		when().get("http://localhost:8084/projects")
		.then().assertThat().body("[0].projectName", Matchers.equalTo("Kluster")).log().all();

	}

}
