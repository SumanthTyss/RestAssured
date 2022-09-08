package validation;

import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class hamCrestResponseTimeValidation {
	@Test
	private void responseTimeValidation() {
			when().get("http://localhost:8084/projects")
			.then().assertThat().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
			.log().all();
			
			

	}

}
