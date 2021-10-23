package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICCRanking_WebTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		List<WebElement> headers = driver.findElements(By.xpath("//table/thead/tr/th"));

		for (int i = 0; i < headers.size(); i++) 
		{

			System.out.print(headers.get(i).getText()+" ");

		}
		System.out.println();
//
//		List<WebElement> teams = driver.findElements(By.xpath("//table/tbody/tr"));
//
//		for (int i = 0; i < teams.size(); i++) 
//		{
//
//			System.out.print(teams.get(i).getText()+" ");
//			System.out.println();
//
//		}
			
		driver.navigate().refresh();

		System.out.println(driver.findElement(By.xpath("(//table/tbody/tr)[last()]")).getText());


	}

}
