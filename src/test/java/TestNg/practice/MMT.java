package TestNg.practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MMT
{
	
	@Test(dataProvider ="getvalue")
	public void mmt(String src, String dest)
	{
		//System.out.println(src +"  "+ dest);


		Date date = new Date();

		String s = date.toString();

		String[] arr = s.split(" ");

		String day=arr[0];

		String month = arr[1];

		String currentdate = arr[2];

		String year = arr[5];

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.makemytrip.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']")).click();

		WebElement close=driver.findElement(By.xpath("//span[@class='langCardClose']"));

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(close)).click();

		driver.findElement(By.id("fromCity")).sendKeys(src);

		driver.findElement(By.xpath("//div[contains(text(),'"+src+"')]")).click();

		driver.findElement(By.id("toCity")).sendKeys(dest);

		driver.findElement(By.xpath("//div[contains(text(),'"+dest+"')]")).click();

		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

		driver.findElement(By.xpath("//div[@aria-label='"+day+" "+month+" "+currentdate+" "+year+"']")).click();

	}

	@DataProvider
	public Object[][] getvalue() 
	{

		Object arr[][] = new Object[5][2];

		arr[0][0]="PNQ";
		arr[0][1]="HYD";

		arr[1][0]="BLR";
		arr[1][1]="MAA";

		arr[2][0]="BOM";
		arr[2][1]="DEL";

		arr[3][0]="KOL";
		arr[3][1]="MAA";

		arr[4][0]="BOM";
		arr[4][1]="PNQ";

		return arr;



	}




}
