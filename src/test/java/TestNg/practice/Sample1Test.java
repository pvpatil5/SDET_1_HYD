package TestNg.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample1Test {
	
	@BeforeSuite
	public void startConnection()
	{
		System.out.println("Connecting to DataBase");
	}
	@BeforeTest
	public void beforetest() {
		System.out.println("Before test");
	}
	@AfterTest
	public void Aftertest() {
		System.out.println("Aftertest ");
	}
	
	@BeforeClass
	public void launchBrowser()
	{
		System.out.println("Launching the Browser");
	}
	
	@BeforeMethod
	public void login()
	{
		System.out.println("Login");
	}
	
	@Test()
	public void TYSS()
	{
		System.out.println("Contact Created");
	}
	@Test()
	public void JSP()
	{
		System.out.println("Org Created");
	}
	
	@Test()
	public void QSP()
	{
		System.out.println("Lead Created");
	}
	
	@AfterMethod
	public void logout()
	{
		System.out.println("Logout");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("closing the Browser");
	}
	
	@AfterSuite
	public void closeConnection()
	{
		System.out.println("Close connection to DataBase");
	}

}
