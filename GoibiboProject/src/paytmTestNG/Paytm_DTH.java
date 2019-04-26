package paytmTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Paytm_DTH {
	
	public String baseUrl = "https://paytm.com/";//app url
    String driverPath = "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\chromedriver.exe";//driver path
    public WebDriver driver ; 
    
    @BeforeMethod
	  public void Launch_Browser() 
  {
    	System.out.println("launching Chrome browser"); 
        System.setProperty("webdriver.chrome.driver", driverPath);//set property
        driver = new ChromeDriver();//initialize browser
        driver.manage().window().maximize();//maximize window
        driver.manage().deleteAllCookies();//delete all cookies of browser 
        driver.get(baseUrl);//enter url
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);//implicit wait for 2 seconds
  }
  @Test(enabled=false)
  public void signin() throws Exception //test cases for sign in page
  {
	  driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[3]/div[4]")).click();//click on sign in button
	Thread.sleep(3000);
	  //click on login
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/qr-code-login/div[2]/div[2]/div[3]/span")).click();
	  //enter username
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456789");
	  //enter password
	  driver.findElement(By.xpath("//*[@id='loginForm']/div/md-content/md-input-container[2]")).sendKeys("123456");
	  //click on login securely
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div[3]/form/div/md-content/button")).click();
	  Thread.sleep(3000);
  }

	@Test(priority=3)
	  public void dth()//test cases for dth
	  {
		  driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[1]/div/a[3]")).click();//click on dth
		  
		  driver.findElement(By.xpath("//*[@id='app']/div/div[4]/div[1]/div[1]/div/div[2]/div[1]/ul/li[1]/div/div/input")).sendKeys("Dish TV");//enter service provider
		  driver.findElement(By.xpath("//*[@id='app']/div/div[4]/div[1]/div[1]/div/div[2]/div[1]/ul/li[2]/div[1]/input")).sendKeys("123456789");//enter dth no.
		  driver.findElement(By.xpath("//*[@id='app']/div/div[4]/div[1]/div[1]/div/div[2]/div[1]/ul/li[3]/div[1]/div/input")).sendKeys("50");//enter value
		  driver.findElement(By.xpath("//*[@id='app']/div/div[4]/div[1]/div[1]/div/div[2]/div[4]/button")).click();//click on proceed to recharge
	  }
	
	
	
	@AfterMethod
	public void tearDown()//close browser
	{
		System.out.println("Closing browser");
		driver.close();
	}
}

