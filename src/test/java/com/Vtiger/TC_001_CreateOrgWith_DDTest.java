package com.Vtiger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.generic.FileUtility;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebDriverUtility;

public class TC_001_CreateOrgWith_DDTest {

	WebDriver driver ;

	@Test
	public void TC001_createOrgwithDD() throws InterruptedException, IOException 
	{

		JavaUtility jv = new JavaUtility();	
		int randomnumber =jv.generateRandomNo();

		String orgname="QSPHYD"+randomnumber;
		System.out.println(orgname);



		FileUtility fileutility= new FileUtility();


		//Step 1 Launch App
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		//Step 2 Login to app
		driver.findElement(By.name("user_name")).sendKeys(fileutility.readDatafromPropfile("username"));
		driver.findElement(By.name("user_password")).sendKeys(fileutility.readDatafromPropfile("password"));
		driver.findElement(By.id("submitButton")).click();

		//step 3 click on org link
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		//step 4 clcik on + btn
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Step 5 Fill the details and select value from DD
		// organaization name
		driver.findElement(By.name("accountname")).sendKeys(orgname);

		WebElement industryDropdown=driver.findElement(By.name("industry"));
		WebDriverUtility webulity = new WebDriverUtility();
		webulity.selectelementfromDropdown(industryDropdown, "Education");

		WebElement ratingDropdown=driver.findElement(By.name("rating"));
		webulity.selectelementfromDropdown(ratingDropdown, "Active");


		WebElement typeDropdown=driver.findElement(By.name("accounttype"));
		webulity.selectelementfromDropdown(typeDropdown, 3);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(3000);

		//Click on org link
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		//
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname);

		WebElement searchfldDropdown=driver.findElement(By.name("search_field"));
		webulity.selectelementfromDropdown(searchfldDropdown,"Organization Name" );

		driver.findElement(By.name("submit")).click();

		WebElement actulelement=driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+orgname+"']"));

		System.out.println(actulelement.isDisplayed());

		Assert.assertEquals(actulelement.isDisplayed(), true);

		//logout from app
		webulity.movetoelement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();


		//Close the browser
		Thread.sleep(5000);
		driver.close();
	}

}
