package validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class staticValidation {
	@Test
	public void staticResponseGet()
	{
	//prerequisites
	String expData = "TY_PROJ_004";
	baseURI = "http://localhost";
	port = 8084;
	//action
	Response resp = when().get("/projects");
	//validation
	String actData = resp.jsonPath().get("[0].projectId");
	Assert.assertEquals(actData, expData);
	System.out.println("data verfied "+actData);
	resp.then().log().all();
	}
	

}
