package com.Vtiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TC_002_CreateContactTest 
{
	@Test
	public void createcontact() throws InterruptedException 
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("../SDETHYD_1/src/test/resources/Extent.html");

		reporter.config().setDocumentTitle("SDET-1");
		reporter.config().setReportName("VTiger");
		reporter.config().setTheme(Theme.DARK);

		ExtentReports reports = new ExtentReports();
		reports.attachReporter(reporter);

		reports.setSystemInfo("AppURL", "http://localhost:8888");
		reports.setSystemInfo("Env", "Test QA");
		reports.setSystemInfo("Build", "2.1");
		reports.setSystemInfo("Reporter name", "Pavan");


		ExtentTest	test=reports.createTest("createcontact");
		test.log(Status.PASS, "This TC is pass");

		//Step 1 Launch App
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Step 2 Login to app
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("12345");
		driver.findElement(By.id("submitButton")).click();

		//step 3 click on org link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

//		//step 4 clcik on + btn
//		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//
//		//step 5
//		WebElement intialsDD=driver.findElement(By.name("salutationtype"));
//
//		Select intialsDropdown= new Select(intialsDD);
//		intialsDropdown.selectByVisibleText("Mr.");
//
//		driver.findElement(By.name("firstname")).sendKeys("SHAM");
//
//		driver.findElement(By.name("lastname")).sendKeys("QSP");
//
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//
//		Thread.sleep(3000);
//
//		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//
//		// Check contact is created or not
//		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("SHAM");
//
//		WebElement searchfldDropdown=driver.findElement(By.name("search_field"));
//		Select searchfldyDD = new Select(searchfldDropdown);
//		searchfldyDD.selectByVisibleText("First Name");
//
//		driver.findElement(By.name("submit")).click();
//
//		// Validate with Assert
//		WebElement actulelement=driver.findElement(By.xpath("//a[@title='Contacts' and text()='SHAM']"));
//
//		System.out.println(actulelement.isDisplayed());
//
//		Assert.assertEquals(actulelement.isDisplayed(), true);

		//Logout from App
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).build().perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		//Close the browser
		Thread.sleep(5000);
		driver.close();
		
		reports.flush();
	}

}
