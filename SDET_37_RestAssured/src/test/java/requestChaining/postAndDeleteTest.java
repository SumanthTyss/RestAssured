package requestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class postAndDeleteTest {
	@Test

	private void requestChaining1() {

		JavaUtility jlib = new JavaUtility();
		int rand = jlib.getRandomNumber();
		JSONObject json=new JSONObject();
		json.put("createdBy", "Deepika");
		json.put("projectName", "prestige"+rand);
		json.put("status", "idk");
		json.put("teamSize", 12);

		Response resp = given().body(json).contentType(ContentType.JSON).when().post("http://localhost:8084/addProject");

		String projID = resp.jsonPath().get("projectId");

		given()
		.pathParam("projectID", projID)
		.when().delete("http://localhost:8084/projects/{projectID}")
		.then()
		.assertThat().statusCode(204).log().all();

	}


}
