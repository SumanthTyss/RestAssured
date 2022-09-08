package com.crm.genericUtilities;



import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIClass {

	public DataBaseUtility dlib=new DataBaseUtility();
	public JavaUtility jlib=new JavaUtility();
	public restAssuredLibrary rlib=new restAssuredLibrary();

	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		dlib.connectToDB();

	}

	@AfterSuite
	public void asConfig() 
	{
		try {
			dlib.closeDB();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
