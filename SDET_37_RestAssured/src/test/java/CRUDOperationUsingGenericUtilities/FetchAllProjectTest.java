package CRUDOperationUsingGenericUtilities;

import org.testng.annotations.Test;

import com.crm.genericUtilities.IConstants;
import com.crm.genericUtilities.endPointLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FetchAllProjectTest {
	@Test
	
	public void fetchallProject() {
		
		when().get(IConstants.BAseURI+endPointLibrary.getsingleproject)
		.then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		
		
	}

}
