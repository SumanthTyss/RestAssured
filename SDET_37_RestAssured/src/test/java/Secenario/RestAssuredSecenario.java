package Secenario;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.genericUtilities.IConstants;
import com.crm.genericUtilities.JavaUtility;
import com.crm.genericUtilities.endPointLibrary;
import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

public class RestAssuredSecenario {
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@Test
	private void VerifyUsingGUI() throws SQLException {
		JavaUtility jlib = new JavaUtility();
		int rand = jlib.getRandomNumber();
		JSONObject json=new JSONObject();
		json.put("createdBy", "ruchityh");
		json.put("projectName", "prestige"+rand);
		json.put("status", "idk");
		json.put("teamSize", 12);

		Response resp = given().body(json).contentType(ContentType.JSON)
				.when().post("http://localhost:8084/addProject");
		
		String projId = resp.jsonPath().get("projectId");
		
		System.out.println(projId);
		
		 
		
		

		//Validate With respect To GUI project created or not
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8084");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		List<WebElement> allproject = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr/td[1]"));
		for (WebElement allProj : allproject) {
			if (allProj.equals(projId)) 
			{
				System.out.println("project is created in GUI");
			}
			else {
				System.out.println("project not created in GUI");
			}
			
		}

		
		driver.quit();
		
		//Validate with respect to Data Base
		
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection connection = DriverManager.getConnection(IConstants.DbUrl+IConstants.DBname,IConstants.DBUsername,IConstants.DBPassword);
		Statement statement = connection.createStatement();
		String query="select * from project";
		ResultSet result = statement.executeQuery(query);
		while(result.next()) {
			String allproject1 = result.getString(1);
			if (allproject1.equals(projId)) {
				System.out.println("project is created in DB");
				

			}else {
				System.out.println("project is not created in DB");
			}
		}
		
		//Delete Using API
		
		when().delete(IConstants.BAseURI+endPointLibrary.deleteproject+projId)
		.then().assertThat().log().all();
		
		//Validate With respect To GUI project deleted or not
				WebDriverManager.chromedriver().setup();
				WebDriver driver1=new ChromeDriver();
				driver1.get("http://localhost:8084");
				driver1.manage().window().maximize();
				driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver1.findElement(By.id("usernmae")).sendKeys("rmgyantra");
				driver1.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
				driver1.findElement(By.xpath("//button[.='Sign in']")).click();
				driver1.findElement(By.xpath("//a[.='Projects']")).click();
				
				List<WebElement> allproject1 = driver1.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr/td[1]"));
				for (WebElement allProj1 : allproject1) {
					if (allProj1.equals(projId)) 
					{
						System.out.println("project is deleted in GUI");
					}
					else {
						System.out.println("project not deleted in GUI");
					}
					
				}

				
				driver1.quit();
		
		
		
		
		
		
		
		
		

	}
	

}
