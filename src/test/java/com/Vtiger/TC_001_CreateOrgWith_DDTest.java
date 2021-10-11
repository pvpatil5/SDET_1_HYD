package com.Vtiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_001_CreateOrgWith_DDTest {

	WebDriver driver ;

	@Test
	public void TC001_createOrgwithDD() throws InterruptedException, IOException 
	{


		Random random = new Random();
		int randomnumber = random.nextInt(1000);
		System.out.println(randomnumber);
		String orgname="QSPHYD"+randomnumber;
		System.out.println(orgname);


		FileInputStream fis = new FileInputStream("./commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		
		
		//Step 1 Launch App
		if
		(prop.getProperty("browser").equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if
		(prop.getProperty("browser").equalsIgnoreCase("ff"))
		{
			driver = new FirefoxDriver();
		}
		else if
		(prop.getProperty("browser").equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
		}
		
		else
		{
			driver= new ChromeDriver();
		}


		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		//Step 2 Login to app
		driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("submitButton")).click();

		//step 3 click on org link
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		//step 4 clcik on + btn
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Step 5 Fill the details and select value from DD
		// organaization name
		driver.findElement(By.name("accountname")).sendKeys(orgname);

		WebElement industryDropdown=driver.findElement(By.name("industry"));
		Select industryDD = new Select(industryDropdown);
		industryDD.selectByVisibleText("Education");

		WebElement ratingDropdown=driver.findElement(By.name("rating"));
		Select ratingDD = new Select(ratingDropdown);
		ratingDD.selectByValue("Active");


		WebElement typeDropdown=driver.findElement(By.name("accounttype"));
		Select typeDD = new Select(typeDropdown);
		typeDD.selectByIndex(3);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(3000);

		//Click on org link
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		//
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname);

		WebElement searchfldDropdown=driver.findElement(By.name("search_field"));
		Select searchfldyDD = new Select(searchfldDropdown);
		searchfldyDD.selectByVisibleText("Organization Name");

		driver.findElement(By.name("submit")).click();

		WebElement actulelement=driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+orgname+"']"));

		System.out.println(actulelement.isDisplayed());

		Assert.assertEquals(actulelement.isDisplayed(), true);

		//logout from app
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).build().perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();


		//Close the browser
		Thread.sleep(5000);
		driver.close();
	}

}
