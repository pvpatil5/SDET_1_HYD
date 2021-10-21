package com.Vtiger.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AdminTest {

	@Test
	public void readDATAfromCMD()
	{
		String value=System.getProperty("url");
		WebDriver driver = new ChromeDriver();
		driver.get(value);
	}

}
