package testNG_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FB_Methods {

	private static WebElement ele=null;
	
	public static WebDriver launchBrowser(String browser)
	{
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("Chrome")){
			System.out.println("Launch chrome driver");
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\chromedriver.exe");
		}else if(browser.equalsIgnoreCase("Firefox")){
			System.out.println("Launch Firefox driver");
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\geckodriver.exe");

		}
		return driver;
	}

	public static boolean LoginTest(WebDriver driver,String url,String username,String password)
	{
		  driver.get(url);
		  WebElement ele_email=driver.findElement(By.id("email"));
		  ele_email.sendKeys(username);
		  WebElement ele_pass = driver.findElement(By.id("pass"));
		  ele_pass.sendKeys(password);
		  boolean status=driver.findElement(By.xpath("//input[@value='Log In']")).isDisplayed();
		  return status;
	}

}
