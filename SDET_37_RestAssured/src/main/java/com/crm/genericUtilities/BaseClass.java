package com.crm.genericUtilities;
/**
 * 
 * @author SanjayBabu
 *
 */

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver sdriver;
	public WebDriver driver;
	public DataBaseUtility dLib=new DataBaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility  wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();

	/**
	 * connecting to database
	 * @throws Throwable 
	 */
	@BeforeSuite
	public void dbConfig() throws Throwable
	{
		dLib.connectToDB();
	}
	/**
	 * launching the browser
	 * @throws Throwable
	 */
	//@Parameters("BROWSER")
	@BeforeClass
	public void launchTheBrowser()
	{  
		String BROWSER = null;
		try {
			BROWSER = fLib.getPropertKeyValue("browser");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//System.out.println(BROWSER);
		String URL = null;
		try {
			URL = fLib.getPropertKeyValue("url");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			//	ChromeOptions chromeOptions=new ChromeOptions();
			//	chromeOptions.setBinary("C:\\Users\\SanjayBabu\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
			//	driver=new ChromeDriver(chromeOptions);
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else {
			driver=new ChromeDriver();
		}

		System.out.println("Browser successfully launched");
		//implicitly wait
		sdriver=driver;
		wLib.waitForPageToLoad(driver);
		//enter the URL of the Application
		sdriver.get(URL);
		//maximize the screen
		driver.manage().window().maximize();
	}
	/**
	 * login to application
	 */
//	@BeforeMethod
//	public void loginToAppln()
//	{
//		String USERNAME = null;
//		try {
//			USERNAME = fLib.getPropertKeyValue("username");
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		String PASSWORD = null;
//		try {
//			PASSWORD = fLib.getPropertKeyValue("password");
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		LoginPage lpage=new LoginPage(driver);
//		lpage.loginToApp(USERNAME, PASSWORD);
//		System.out.println("Login successful");
//	}
//	/**
//	 * logout from application
//	 */
//	@AfterMethod
//	public void logoutFromAppln()
//	{
//		HomePage hpage=new HomePage(driver);
//		hpage.logOut(driver);
//		System.out.println("Logout successful");
//	}
//	/**
//	 * close the browser
//	 */
//	@AfterClass
//	public void closeTheBrowser()
//	{
//		driver.quit();
//		System.out.println("Browser successfully closed");
//	}
	/**
	 * close database configuration
	 * @throws Throwable 
	 */
	@AfterSuite
	public void closeDBconfig() throws Throwable
	{
		dLib.closeDB();
	}
}