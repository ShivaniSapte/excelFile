/**
 * 
 */
package testNG_Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author shivani
 *
 */
public class PropertyFileTest {
	public PropertyFileReader dataFile;
	public String working_dir="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\testNG_Basics\\Property_file";	 String driverPath = "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\chromedriver.exe";//driver path
	WebDriver driver;
	public String url;
	@Test
	public void login() throws Exception 
	{
		dataFile=new PropertyFileReader(working_dir);
	      System.setProperty("webdriver.chrome.driver", driverPath);//set property
	      driver = new ChromeDriver();//initialize browser
	      driver.manage().window().maximize();//maximize window
	      driver.manage().deleteAllCookies();//delete all cookies of browser 
	      
		  
	      url = dataFile.getData("url");
		  System.out.println("url  " + url);
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	WebElement userid = driver.findElement(By.xpath(".//input[@name='user_name']"));
	System.out.println(userid.isEnabled());
	userid.click();
	//System.out.println(userid.isEnabled());
	userid.sendKeys(dataFile.getData("username"));

	// Get the password element
	WebElement passwd = driver.findElement(By.xpath(".//input[@name='password']"));
	System.out.println(passwd.isEnabled());
	passwd.click();
	System.out.println(passwd.isEnabled());
	passwd.sendKeys(dataFile.getData("password"));
	
	driver.findElement(By.xpath(".//input[@name='Submit']")).click();
		
	driver.quit();
	}
	
}
