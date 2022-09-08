package validation;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class dynamicValidation {
	@Test
	public void dynamic() {
		String expProjID="TY_PROJ_004";
		Response response = when().get("http://localhost:8084/projects");

		List<String> projectId = response.jsonPath().get("projectId");
		boolean flag=false;

		for (String actProjectID : projectId) {
			if (actProjectID.equals(expProjID)) {
				System.out.println("project name is matching");
				flag=true;
			}


		}
		Assert.assertTrue(flag);


	}

}
