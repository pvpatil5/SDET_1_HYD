package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sample {

	WebDriver driver;
	
	By un=By.xpath("//input[@name='user_name']");

	By pwd=By.xpath("//input[@name='user_password']");

	


	public void convert(By locator) {

	}

	public Sample(WebDriver driver) 
	{
		this.driver=driver;
	}

}
