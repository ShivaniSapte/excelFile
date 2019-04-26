package paytmTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class PaytmAC {
	public String baseUrl = "https://paytm.com/";//app url
    String driverPath = "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\chromedriver.exe";//driver path
    public WebDriver driver ; 

  @BeforeTest
  public void beforeTest()
  {
	  System.out.println("launching Chrome browser"); 
      System.setProperty("webdriver.chrome.driver", driverPath);//set property
      driver = new ChromeDriver();//initialize browser
      driver.manage().window().maximize();//maximize window
      driver.manage().deleteAllCookies();//delete all cookies of browser 
      driver.get(baseUrl);//enter url
      driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);//global or implicit wait for 2 seconds
	
  }
  @Test(priority=1)
  public void scrollDown() throws Exception 
  {
  JavascriptExecutor js= (JavascriptExecutor)driver;
  WebElement ele=driver.findElement(By.linkText("View All"));
  js.executeScript("arguments[0].scrollIntoView();", ele);
  Thread.sleep(3000);
  ele.click();
  }
  @Test(priority=2)
  public void selectAC() throws Exception
  {
	//click on ac
	driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[7]/div[1]/div[2]/div/div/div[1]/div[3]/div/a/div")).click();
	Thread.sleep(3000);
	//click on change password
	driver.findElement(By.xpath("//span[@class='_2oRS']")).click();
	Thread.sleep(3000);
	//enter pincode
	driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[2]/div[1]/div[1]/div/div/div[2]/div[4]/div/div/div/div/input")).sendKeys("411001");
	Thread.sleep(3000);
	//select offer
	driver.findElement(By.cssSelector("span.eLIZ")).click();
	//click on buy
	driver.findElement(By.xpath("//button[@class='_2CNI']")).click();
	Thread.sleep(3000);
	//click on my orders
	driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div/div[3]/div[1]/div/span[2]")).click();
	Thread.sleep(3000);
	//click on add offers
	WebElement frame_ele=driver.findElement(By.xpath("//*[@id='app']/div/div[6]/div[2]/div/iframe"));
	driver.switchTo().frame(frame_ele);
	
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("8793849930");
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456789");
	Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@id='loginForm']/div/md-content/button")).click();
	Thread.sleep(3000);
	
	/**driver.findElement(By.xpath("//i[@class='iconPlus _11_M']")).click();
	Thread.sleep(3000);
	//enter promocode
	driver.findElement(By.xpath("//input[@placeholder='Have a promocode? Enter here']")).sendKeys("abcdqpr");
	//click on apply
	driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div/div[1]/div/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div[1]/div[2]/div[1]/div[2]/div[2]/span")).click();
    Thread.sleep(3000);**/
  }
 
  @AfterTest
  public void afterTest() 
  {
	  System.out.println("Closing browser");
	  driver.close();//close browser
  }

}
