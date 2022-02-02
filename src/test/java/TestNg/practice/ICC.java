package TestNg.practice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICC {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		
		List<WebElement> points = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		for (int i = 0; i < points.size(); i++) 
		{
			String point=points.get(i).getText();
			int a=Integer.parseInt(point);
			a1.add(a);
			
		}
		
		Collections.sort(a1);
		int matches=a1.get(a1.size()-1);
		System.out.println(matches);
		
		for (int j = 0; j <= a1.size()-1; j++) 
		{
			String point=points.get(j).getText();
			int b=Integer.parseInt(point);
			if(b==matches) 
			{
				System.out.println(driver.findElement(By.xpath("//tbody/tr["+j+"]/td[2]/span[@class='u-hide-phablet']")).getText());
			break;
			}
			
		}
		
	}

}
