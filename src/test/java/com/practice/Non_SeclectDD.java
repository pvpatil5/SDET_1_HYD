package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Non_SeclectDD {

	public static void main(String[] args) throws InterruptedException {
		// = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-popup-blocking");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.hdfcbank.com/");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//img[@class='closeSummer']")).click();

		driver.findElement(By.xpath("//div[@class='dropdown']")).click();

		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));

		for (int i = 0; i < list.size(); i++) 
		{
			String str=list.get(i).getText();
			if(str.equalsIgnoreCase("Accounts"))
			{
				list.get(i).click();
				break;
			}

		}

	}

}
