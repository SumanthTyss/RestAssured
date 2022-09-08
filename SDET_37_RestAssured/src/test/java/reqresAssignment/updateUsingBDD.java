package reqresAssignment;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class updateUsingBDD {
	@SuppressWarnings("unchecked")
	@Test
	public void updatereqres() {
		JSONObject json=new JSONObject();
		json.put("name","radha");
		json.put("job", "test Engineer");
		
		given()
		.body(json).contentType(ContentType.JSON)
		.when()
		.put("https://reqres.in/api/users/2")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}

}
