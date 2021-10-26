package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shadow_Element {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://shop.polymer-project.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		WebElement element1=	driver.findElement(By.tagName("shop-app"));
		WebElement root1=expandRootElement(driver, element1);

		WebElement element2 = root1.findElement(By.tagName("app-header"));
		WebElement root2=expandRootElement(driver, element2);

		WebElement element3 = root2.findElement(By.cssSelector("shop-tabs"));
		WebElement root3=expandRootElement(driver, element3);

		WebElement element4 = root3.findElement(By.tagName("shop-tab"));
		WebElement root4=expandRootElement(driver, element4);

		root4.findElement(By.cssSelector("a")).click();

	}
	public static WebElement expandRootElement(WebDriver driver, WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].shadowRoot",element);
		return ele;
	}

}
