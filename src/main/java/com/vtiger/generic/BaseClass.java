package com.vtiger.generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public FileUtility fileutility= new FileUtility();
	public HomePage hp;
	
	@BeforeSuite(groups= {"smoke","regression"})
	public void startConnection()
	{
		System.out.println("Start the Connection with DataBase");
	}
	
	@Parameters("browser")
	@BeforeClass(groups= {"smoke","regression"})
	public void launchBrowser(String browsername) throws Throwable
	{
		//String browsername=fileutility.readDatafromPropfile("browser");
		if
		(browsername.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if
		(browsername.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if
		(browsername.equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
		}

		else
		{
			driver= new ChromeDriver();
		}


		driver.get(fileutility.readDatafromPropfile("URL"));
		driver.manage().window().maximize();
	}
	
	@BeforeMethod(groups= {"smoke","regression"})
	public void login() throws Throwable
	{
		LoginPage lp= new LoginPage(driver);
		lp.logintoApp();
	}
	
	@AfterMethod(groups= {"smoke","regression"})
	public void logout()
	{
		hp = new HomePage(driver);
		hp.logoutfromApp();
	}
	
	@AfterClass(groups= {"smoke","regression"})
	public void closeBrowser() throws Throwable
	{
		Thread.sleep(2000);
		driver.close();
	}
	
	@AfterSuite(groups= {"smoke","regression"})
	public void closeConnection()
	{
		System.out.println("Close the Connection with DataBase");
	}

}
