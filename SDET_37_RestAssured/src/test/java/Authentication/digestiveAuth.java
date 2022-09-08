package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class digestiveAuth {
	@Test
	private void DigestiveAuth() {
		//Example flipkart without username and password we can enter into the application
		
		given().auth().digest("rmgyantra", "rmgy@9999")
		.when().get("http://localhost:8084/login")
		.then().assertThat().log().all();
	}

}
