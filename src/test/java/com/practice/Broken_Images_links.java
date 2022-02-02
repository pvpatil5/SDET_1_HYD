package com.practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Broken_Images_links {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.get("https://www.bluestone.com/");

		List<WebElement> links=driver.findElements(By.tagName("img"));

		System.out.println("Total links are "+links.size());

		for(int i=0;i<links.size();i++)
		{

			WebElement ele= links.get(i);

			String url=ele.getAttribute("src");

			verifyLinkActive(url);

		}

	}

	public static void verifyLinkActive(String linkUrl)
	{
		try 
		{
			URL url = new URL(linkUrl);

			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();

			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.connect();

			if(httpURLConnect.getResponseCode()==200)
			{
				System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
			}
			else if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
			{
				System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) 
		{
	
		}
	} 
}

