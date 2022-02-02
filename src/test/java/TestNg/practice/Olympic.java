package TestNg.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Olympic {

	public static void main(String[] args) 
	{

		WebDriver driver = new ChromeDriver();

		driver.get("https://olympics.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		String text=driver.findElement(By.xpath("//span[text()='Eliud KIPCHOGE']/ancestor::ul/li[4]//div[@class='featured-athlete__medals text-body-sm']")).getText();

		System.out.println(text);

		//		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='b2p-list  featured-athletes--4']/li"));
		//
		//		for (int i = 0; i < list.size(); i++) {
		//			System.out.println(list.get(i).getText());
		//		}

		
		String tooltip=driver.findElement(By.xpath("")).getAttribute("title");
	}
}
