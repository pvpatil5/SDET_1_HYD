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

public class TC_001_CreateOrgWith_DDTest {

	@Test
	public void TC001_createOrgwithDD() throws InterruptedException {


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
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		//step 4 clcik on + btn
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Step 5 Fill the details and select value from DD
		driver.findElement(By.name("accountname")).sendKeys("QSPHYD");

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
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("QSPHYD2");

		WebElement searchfldDropdown=driver.findElement(By.name("search_field"));
		Select searchfldyDD = new Select(searchfldDropdown);
		searchfldyDD.selectByVisibleText("Organization Name");

		driver.findElement(By.name("submit")).click();

		WebElement actulelement=driver.findElement(By.xpath("//a[@title='Organizations' and text()='QSPHYD2']"));

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
