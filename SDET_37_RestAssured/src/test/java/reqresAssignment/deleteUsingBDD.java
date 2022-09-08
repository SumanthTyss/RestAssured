package reqresAssignment;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class deleteUsingBDD {

	@Test
	public void deleteReqres() {
		when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.assertThat().statusCode(204)
		.log().all();


	}

}
