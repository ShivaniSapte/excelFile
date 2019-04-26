package testNG_Listners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

@Listeners(testNG_Listners.Listner_example.class)

public class Test {
	WebDriver driver;
	@org.testng.annotations.Test
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\chromedriver.exe");//set property
	    driver=new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("title--> "+driver.getTitle());
		
	}
	@org.testng.annotations.Test
	public void teardown(){
		driver.close();
	}
	@org.testng.annotations.Test		
	public void TestToFail()				
	{		
	    System.out.println("This method to test fail");					
	    Assert.assertTrue(false);			
	}	
}
