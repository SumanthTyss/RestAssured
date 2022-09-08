package requestChaining;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class postAndPut {
	@SuppressWarnings("unchecked")
	@Test
	public void requestChaining3() {
		JavaUtility jlib = new JavaUtility();
		int rand = jlib.getRandomNumber();
		JSONObject json=new JSONObject();
		json.put("createdBy", "Deepika");
		json.put("projectName", "prestige"+rand);
		json.put("status", "idk");
		json.put("teamSize", 12);

		Response resp = given().body(json).contentType(ContentType.JSON).when().post("http://localhost:8084/addProject");

		String projID = resp.jsonPath().get("projectId");

		JSONObject json1=new JSONObject();
		json1.put("createdBy", "radha");
		json1.put("projectName", "cooker"+rand);
		json1.put("status", "idk");
		json1.put("teamSize", 12);
		given()
		.body(json1).contentType(ContentType.JSON)
		.pathParam("projectID", projID)
		.when().put("http://localhost:8084/projects/{projectID}")
		.then().assertThat().statusCode(200).log().all();




	}

}
