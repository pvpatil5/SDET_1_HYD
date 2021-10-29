package com.Vtiger;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.generic.BaseClass;
import com.vtiger.generic.FileUtility;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebDriverUtility;

import objectRepo.HomePage;
import objectRepo.LoginPage;

@Listeners(com.vtiger.generic.ListenerImplementation.class)
public class TC_001_CreateOrgWith_DDTest extends BaseClass{

	@Test
	public void TC001_createOrgwithDD() throws InterruptedException, IOException 
	{

		
		int randomnumber =JavaUtility.getInstanceofJavaUtility().generateRandomNo();

		String orgname="QSPHYD"+randomnumber;
		System.out.println(orgname);

	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		//step 3 click on org link
	    hp = new HomePage(driver);
		hp.getOrglink().click();

		//step 4 clcik on + btn
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Step 5 Fill the details and select value from DD
		// organaization name
		driver.findElement(By.name("accountname")).sendKeys(orgname);

		WebElement industryDropdown=driver.findElement(By.name("industry"));
	
		WebDriverUtility.getInstanceofwebdriverUtility().selectelementfromDropdown(industryDropdown, "Education");

		WebElement ratingDropdown=driver.findElement(By.name("rating"));
		WebDriverUtility.getInstanceofwebdriverUtility().selectelementfromDropdown(ratingDropdown, "Active");


		WebElement typeDropdown=driver.findElement(By.name("accounttype"));
		WebDriverUtility.getInstanceofwebdriverUtility().selectelementfromDropdown(typeDropdown, 3);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(3000);

		//Click on org link
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		//
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname);

		Thread.sleep(5000);
		WebElement searchfldDropdown=driver.findElement(By.name("search_field"));
		WebDriverUtility.getInstanceofwebdriverUtility().selectelementfromDropdown(searchfldDropdown,"accountname" );

		driver.findElement(By.name("submit")).click();

		WebElement actulelement=driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+orgname+"']"));

		System.out.println(actulelement.isDisplayed());

		//Assert.assertEquals(actulelement.isDisplayed(), true);
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actulelement.isDisplayed(),true);
		
		Assert.assertEquals(false, true);
	}
}
