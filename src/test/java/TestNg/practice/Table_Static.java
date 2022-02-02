package TestNg.practice;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table_Static {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.naukri.com");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		//		
		//		driver.switchTo().frame("iframeResult");
		//		
		//		List<WebElement> rowcount = driver.findElements(By.xpath("//table//tbody/tr"));
		//		
		//		List<WebElement> colcount = driver.findElements(By.xpath("//table//tbody/tr[1]/th"));
		//		
		//		System.out.println(rowcount.size());
		//		System.out.println(colcount.size());
		//		System.out.println(driver.findElement(By.xpath("//table//tbody")).getText());
		String parentwindow=driver.getWindowHandle();

		Set<String> windows = driver.getWindowHandles();

		for(String window:windows)
		{
			System.out.println(driver.switchTo().window(window).getTitle());
			if(driver.switchTo().window(window).getTitle().equalsIgnoreCase("Cognizant")) 
			{
				driver.manage().window().maximize();
				
				driver.switchTo().window(parentwindow);
				Thread.sleep(2000);
				driver.close();
				break;
			}
		}

	}

}
