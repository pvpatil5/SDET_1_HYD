package TestNg.practice;

import org.testng.annotations.Test;

public class MavenTest {

	@Test
	public void readDatafromCMD() {
		String url=System.getProperty("url");

		System.out.println(url);
		String un=System.getProperty("un");

		System.out.println(un);

		//		WebDriver driver = new ChromeDriver();
		//		driver.get(url);


	}

}
