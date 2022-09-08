import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class assignmentOnPetStoreTest {
	@SuppressWarnings("unchecked")
	@Test
	private void PostStore() {
		JSONObject json=new JSONObject();
		json.put("id", 1234);
		json.put("petId", 01234);
		json.put("quantity", 5);
		json.put("shipDate", "jan 5th");
		json.put("status", "Shipping");
		json.put("complete", true);

		given()
		.body(json).contentType(ContentType.JSON)

		.when()
		.post("https://petstore.swagger.io/v2/store/order")

		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();


	}

}
