package CRUDOperationUsingGenericUtilities;

import org.testng.annotations.Test;

import com.crm.genericUtilities.IConstants;
import com.crm.genericUtilities.endPointLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FetchSingleProject {
	@Test
	
	public void fetchSingleProject() {
		
		when().get(IConstants.BAseURI+endPointLibrary.getsingleproject+"TY_PROJ_649")
		.then().assertThat().statusCode(200).log().all();
		
	}

}
