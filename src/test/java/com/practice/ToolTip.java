package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ToolTip  {
	

	WebDriver driver = new ChromeDriver();
	Sample s1 = new Sample(driver);

	@Test
	public  void login() {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");

		//WebElement un=driver.findElement(By.xpath("//input[@name='user_name']"));

		//driver.navigate().refresh();
		driver.findElement(s1.un).sendKeys("admin");
		//driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("12345");
		driver.navigate().refresh();
		//pwd.sendKeys("12345");
		driver.findElement(By.id("submitButton")).click();

		WebElement element=driver.findElement(By.xpath("//input[@value='Search...']"));


		element.sendKeys("SDETQWE");
		//		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		//
		//		WebElement target= driver.findElement(By.xpath("//img[@title='Search in Organizations...']"));
		//		
		//		Actions action = new Actions(driver);
		//		action.moveToElement(target).build().perform();


		System.out.println(element.getAttribute("value"));
	}

}
