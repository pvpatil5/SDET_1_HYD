package TestNg.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Sample1 {
	
	@BeforeSuite
	public void startConnection()
	{
		System.out.println("Connecting to DataBase");
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
	
	@Test
	public void createContact()
	{
		System.out.println("Contact Created");
	}
	
	@Test
	public void createLead()
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
