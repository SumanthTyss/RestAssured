package validation;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;
import com.mysql.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class createUpdateReadAndDeleteVerifyUsingJDBC {
	@SuppressWarnings("unchecked")
	@Test
	private void VerifyUsingJDBC() throws SQLException {
		JavaUtility jlib = new JavaUtility();
		int rand = jlib.getRandomNumber();
		JSONObject json=new JSONObject();
		json.put("createdBy", "ruchityh");
		json.put("projectName", "prestige"+rand);
		json.put("status", "idk");
		json.put("teamSize", 12);

		Response resp = given().body(json).contentType(ContentType.JSON).when().post("http://localhost:8084/addProject");

		String projID = resp.jsonPath().get("projectId");

		JSONObject json1=new JSONObject();
		json1.put("createdBy", "rashmi");
		json1.put("projectName", "cooker");
		json1.put("status", "idk");
		json1.put("teamSize", 12);
		given()
		.body(json1).contentType(ContentType.JSON)
		.pathParam("projectID", projID)
		.when().put("http://localhost:8084/projects/{projectID}")
		.then().assertThat().statusCode(200).log().all();

		Response allProjects = when().get("http://localhost:8084/projects");
		allProjects.then().assertThat().statusCode(200).log().all();

		String projID1 = allProjects.jsonPath().get("[0].projectId");
		System.out.println(projID1);

		given()
		.pathParam("projectID", projID1)
		.when()
		.delete("http://localhost:8084/projects/{projectID}")
		.then()
		.assertThat().statusCode(204).log().all();

		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement = connection.createStatement();
		String query="select * from project";
		ResultSet result = statement.executeQuery(query);
		while(result.next()) {
			String allproject = result.getString(1);
			if (allproject.contains(projID)) {
				System.out.println("project is deleted");

			}else {
				System.out.println("project is not deleted");
			}
		}



	}

}
