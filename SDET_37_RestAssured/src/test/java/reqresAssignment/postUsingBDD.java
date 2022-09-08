package reqresAssignment;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class postUsingBDD {
	@SuppressWarnings("unchecked")
	@Test
	public void createData() {
		JSONObject json=new JSONObject();
		json.put("name", "sumanth");
		json.put("job", "SDET");

		given()
		.body(json).contentType(ContentType.JSON)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.assertThat().statusCode(201)
		.log().all();

	}

}
