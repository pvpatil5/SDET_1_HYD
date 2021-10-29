package com.vtiger.generic;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author PAVAN
 *
 */
public class WebDriverUtility 
{
	private  WebDriverUtility() {

	}
	
	public static  WebDriverUtility getInstanceofwebdriverUtility() {
		WebDriverUtility webdriverutil= new WebDriverUtility();
		return webdriverutil;

	}
	
	
	/**
	 * @author PAVAN
	 * Description This method is going to work as implicit wait
	 * @param driver
	 */
	


	public void pageloadtimeout(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * This method will maximise the window
	 * @param Webdriver driver
	 */
	public void maximisewindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will wait for the visiblity of element
	 * @param driver
	 * @param element
	 */

	public void waitforelementtovisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait and click the elemnt 
	 * @param driver
	 * @param element
	 */
	public void waitandclick(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	/**
	 * This mtd will select the the value from DD based on Visisble text
	 * @param element
	 * @param text
	 */
	public void slectelementfromDropdown(WebElement element, String text) 
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * This mtd will select the the value from DD based on Index number
	 * @param element
	 * @param int
	 */

	public void selectelementfromDropdown(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This mtd will select the the value from DD based on Value
	 * @param element
	 * @param text
	 */
	public void selectelementfromDropdown(WebElement element,String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This mtd is going to switch to frame based on Index no of frame
	 * @param driver
	 * @param index
	 */
	public void switchframebyindex(WebDriver driver,int index) 
	{
		driver.switchTo().frame(index);
	}

	/**
	 * This mtd is going to switch to frame based on WebElement 
	 * @param driver
	 * @param element
	 */
	public void switchframebyElement(WebDriver driver,WebElement element) 
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This mtd is going to switch to frame based on nameOrId 
	 * @param driver
	 * @param nameOrId
	 */

	public void switchframebyElement(WebDriver driver,String nameOrId ) 
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This Mtd is going to move cursor to element 
	 * @param driver
	 * @param element
	 */

	public void movetoelement(WebDriver driver,WebElement element) 
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	/**
	 * This method is going to do right click
	 * @param driver
	 * @param element
	 */

	public void rightClick(WebDriver driver,WebElement element) 
	{
		Actions action = new Actions(driver);
		action.contextClick(element);
	}
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This mtd can switch the window
	 * @param driver
	 * @param title
	 */

	public void switchTowindow(WebDriver driver, String title) 
	{
		Set<String> windowId = driver.getWindowHandles();
		Iterator<String> iterator=windowId.iterator();

		while(iterator.hasNext()) 
		{
			String currentwindow=iterator.next();
			String currenttitle=driver.switchTo().window(currentwindow).getTitle();
			if(currenttitle.contains(title)) {
				break;
			}
		}
	}


}
