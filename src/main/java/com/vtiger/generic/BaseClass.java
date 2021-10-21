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

import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public FileUtility fileutility= new FileUtility();
	public HomePage hp;
	
	@BeforeSuite
	public void startConnection()
	{
		System.out.println("Start the Connection with DataBase");
	}
	
	@BeforeClass
	public void launchBrowser() throws Throwable
	{
		if
		(fileutility.readDatafromPropfile("browser").equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if
		(fileutility.readDatafromPropfile("browser").equalsIgnoreCase("ff"))
		{
			driver = new FirefoxDriver();
		}
		else if
		(fileutility.readDatafromPropfile("browser").equalsIgnoreCase("safari"))
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
	
	@BeforeMethod
	public void login() throws Throwable
	{
		LoginPage lp= new LoginPage(driver);
		lp.logintoApp();
	}
	
	@AfterMethod
	public void logout()
	{
		hp = new HomePage(driver);
		hp.logoutfromApp();
	}
	
	@AfterClass
	public void closeBrowser() throws Throwable
	{
		Thread.sleep(2000);
		driver.close();
	}
	
	@AfterSuite
	public void closeConnection()
	{
		System.out.println("Close the Connection with DataBase");
	}

}
