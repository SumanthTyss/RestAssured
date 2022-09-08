package reqresAssignment;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class patchUsingBDD {
	@SuppressWarnings("unchecked")
	@Test
	public void patchReqres() {
		JSONObject json=new JSONObject();
		json.put("name", "sangthosh");
		json.put("job", "testEnginerr");
		
		given()
		.body(json).contentType(ContentType.JSON)
		.when()
		.patch("https://reqres.in/api/users/2")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
		
	}

}
