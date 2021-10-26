package com.vtiger.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public FileUtility fileutility= new FileUtility();
	public HomePage hp;
	public static WebDriver staticdriver;

	@BeforeSuite(groups= {"smoke","regression"})
	public void startConnection()
	{
		System.out.println("Start the Connection with DataBase");
	}

	//@Parameters("browser")
	@BeforeTest(groups= {"smoke","regression"})
	public void launchBrowser() throws Throwable
	{
		String browsername=fileutility.readDatafromPropfile("browser");
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

		staticdriver=driver;
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

	@AfterTest(groups= {"smoke","regression"})
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
	public static String getscreenshot( String name) throws IOException 
	{
		File srcfile =((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile= System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File finaldest = new File(destfile) ;
		FileUtils.copyFile(srcfile,finaldest);

		return destfile;
	}

}
