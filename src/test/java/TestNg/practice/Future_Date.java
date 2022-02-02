package TestNg.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Future_Date {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.makemytrip.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']")).click();

		WebElement close=driver.findElement(By.xpath("//span[@class='langCardClose']"));

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(close)).click();

		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();


		for (int i = 0; i < 11; i++) 
		{
			try {
				driver.findElement(By.xpath("//div[@aria-label='Wed Apr 06 2022']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}

		}


	}

}
