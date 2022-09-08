package CRUDOperationUsingGenericUtilities;

import org.testng.annotations.Test;

import com.crm.genericUtilities.IConstants;
import com.crm.genericUtilities.endPointLibrary;

import static io.restassured.RestAssured.*;

public class deleteProject {
	@Test
	
	public void DeleteProject() {
		
		when().delete(IConstants.BAseURI+endPointLibrary.deleteproject+"TY_PROJ_649")
		.then().assertThat().statusCode(204).log().all();
	}

}
