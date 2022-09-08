package validation;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;
import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class createUpdateReadAndDeleteVerifyUsingGUI {
	@SuppressWarnings("unchecked")
	@Test
	private void VerifyUsingGUI() throws SQLException {
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
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8084");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		WebElement allproject = driver.findElement(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr/td"));
		
}
}
