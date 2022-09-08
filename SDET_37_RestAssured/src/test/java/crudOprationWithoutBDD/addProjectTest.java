package crudOprationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class addProjectTest {
	
	@Test
	public void Create(){
		
		JavaUtility jlib=new JavaUtility();
		int rand = jlib.getRandomNumber();
		
		//Json Body
		JSONObject json=new JSONObject();
		json.put("createdBy", "Dhyan");
		json.put("projectName", "Redmi"+rand);
		json.put("status", "on going");
		json.put("teamSize", 5);
		
		//preconditions(body and content type)
		RequestSpecification reqspc=RestAssured.given();
		reqspc.body(json);
		reqspc.contentType(ContentType.JSON);
		
		//Validation
		Response response=reqspc.when().post("http://localhost:8084/addProject");
		ValidatableResponse validate = response.then(); 
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201);
		validate.log().all();
		

	}
	

}
