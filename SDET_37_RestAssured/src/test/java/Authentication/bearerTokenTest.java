package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class bearerTokenTest {
	@Test
	private void bearerToken() {
		
		given().auth().oauth2("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")
		.when().get("https://api.github.com/user/repos")
		.then().assertThat().statusCode(200).log().all();
	} 

}
