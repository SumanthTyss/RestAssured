package dataDrivenTesting;

import static io.restassured.RestAssured.*;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.genericUtilities.IConstants;
import com.crm.genericUtilities.JavaUtility;
import com.crm.genericUtilities.endPointLibrary;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pojoClassForCrudOperation.pojoClassForAddProject;

public class CreateMultipleProjectWithDiffData {
	@Test(dataProvider = "getdata")
	
	private void CreateProject(String createdBy, String projectName, String status, int	teamSize) {
		
		//Prerequisties
		JavaUtility jLib = new JavaUtility();
		pojoClassForAddProject pLib = new pojoClassForAddProject(createdBy,projectName+jLib.getRandomNumber(), status, teamSize);
		
			given().body(pLib).contentType(ContentType.JSON)
			.when().post(IConstants.BAseURI+endPointLibrary.createproject)
			.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
			
		
	}
	
	
		@DataProvider(name="getdata")
		public Object[][] data()
		{
			Object[][] data = new Object[3][4];
			data[0][0] = "Chaitra";
			data[0][1] = "Dell";
			data[0][2] = "Completed";
			data[0][3] = 12;
			
			data[1][0] = "Vijay";
			data[1][1] = "HP";
			data[1][2] = "Created";
			data[1][3] = 15;
			
			data[2][0] = "Pavan";
			data[2][1] = "TYSS";
			data[2][2] = "On Going";
			data[2][3] = 20;
			return data;
		}
	
	

}
