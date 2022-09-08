package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class preamtiveAuth {
	@Test
	public void PreamtiveAuth() {
		//Example Amazon prime (Without username and password we cannot enter into it)
	
		given().auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when().get("http://localhost:8084/login")
		.then().assertThat().log().all();
	}

}
