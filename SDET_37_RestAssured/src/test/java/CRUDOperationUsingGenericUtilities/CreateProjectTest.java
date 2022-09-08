package CRUDOperationUsingGenericUtilities;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.crm.genericUtilities.BaseAPIClass;
import com.crm.genericUtilities.IConstants;
import com.crm.genericUtilities.JavaUtility;
import com.crm.genericUtilities.endPointLibrary;

import io.restassured.http.ContentType;
import pojoClassForCrudOperation.pojoClassForAddProject;

public class CreateProjectTest extends BaseAPIClass {
	@Test
	public void createProject() {
		JavaUtility jlib=new JavaUtility();
		int rand = jlib.getRandomNumber();
		pojoClassForAddProject pojo=new pojoClassForAddProject("abc", "pqr"+rand, "created", 5);

		given().body(pojo).contentType(ContentType.JSON)

		.when().post(IConstants.BAseURI+endPointLibrary.createproject)
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();

	}


}
