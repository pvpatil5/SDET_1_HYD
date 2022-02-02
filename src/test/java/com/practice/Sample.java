package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.vtiger.generic.JavaUtility;

import objectRepo.HomePage;

public class Sample extends BaseClass
{

	@Test
	public void run1() 
	{
		System.out.println(getTitle());
		System.out.println(getPageURL());
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
		
		throw new SkipException("Skipping this exception");

	}

}
