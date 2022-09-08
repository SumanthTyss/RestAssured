package CRUDOperationUsingGenericUtilities;

import org.testng.annotations.Test;

import com.crm.genericUtilities.IConstants;
import com.crm.genericUtilities.endPointLibrary;

import io.restassured.http.ContentType;
import pojoClassForCrudOperation.pojoClassForAddProject;

import static io.restassured.RestAssured.*;

public class UpdateProject {
	@Test
	public void updateProject() {

		pojoClassForAddProject pojo=new pojoClassForAddProject("sumanth", "flipkart", "ongoing", 5);
		given().body(pojo).contentType(ContentType.JSON)
		.when().put(IConstants.BAseURI+endPointLibrary.updateproject+"TY_PROJ_649")
		.then().assertThat().statusCode(200).log().all();
	}

}
