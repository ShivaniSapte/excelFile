package Paytm_POM;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PaytmAC {
	PropertyFile pf;
	String working_dir="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\Paytm_POM\\config.property";
	WebDriver driver;
	
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
	  pf=new PropertyFile(working_dir);
		
	  By ac=By.xpath(pf.getPropertyData("ac_xpath"));
	  By chngPincode=By.xpath(pf.getPropertyData("chng_pincod_xpath"));
	  By pincode=By.xpath(pf.getPropertyData("entr_pincod_xpath"));
	  By chckPincode=By.cssSelector(pf.getPropertyData("chek_pincod_css"));
	  By buy=By.cssSelector(pf.getPropertyData("buy_css"));
	  By myOrder=By.xpath(pf.getPropertyData("my_order_xpath"));
	  By frame=By.xpath(pf.getPropertyData("frame_xpath"));
	  By uname=By.xpath(pf.getPropertyData("user_name_xpath"));
	  By pass=By.xpath(pf.getPropertyData("password_xpath"));
	  By login=By.xpath(pf.getPropertyData("login_xpath"));
	  
	driver.findElement(ac).click();//click on ac
	Thread.sleep(3000);
	
	driver.findElement(chngPincode).click();//click on change pincode
	Thread.sleep(3000);
	
	driver.findElement(pincode).sendKeys("411001");//enter pincode
	driver.findElement(chckPincode).click();//click on check pincode

	driver.findElement(buy).click();//click on buy
	Thread.sleep(3000);
	
	driver.findElement(myOrder).click();//click on my orders
		
	WebElement frame_ele=driver.findElement(frame);
	driver.switchTo().frame(frame_ele);
	
	driver.findElement(uname).sendKeys("8793849930");//enter user name

	driver.findElement(pass).sendKeys("123456789");//enter password
	Thread.sleep(3000);
    driver.findElement(login).click();
	Thread.sleep(3000);
	
	/**driver.findElement(By.xpath("//i[@class='iconPlus _11_M']")).click();
	Thread.sleep(3000);
	//enter promocode
	driver.findElement(By.xpath("//input[@placeholder='Have a promocode? Enter here']")).sendKeys("abcdqpr");
	//click on apply
	driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div/div[1]/div/div[2]/div/div/div[2]/div[1]/div/div[1]/div/div[1]/div[2]/div[1]/div[2]/div[2]/span")).click();
    Thread.sleep(3000);**/
  }
 
  @BeforeMethod
  public void setup() throws Exception 
  {
	pf=new PropertyFile(working_dir);
		
		//define global variables
		String browser=pf.getPropertyData("browser");
		String url =pf.getPropertyData("url");
		
		//define object property
	     if(browser.equalsIgnoreCase("chrome")){
	    	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\chromedriver.exe");//set property
		      driver=new ChromeDriver();
	      }
	      else if(browser.equalsIgnoreCase("Firefox"))
	      {
	    	  driver=new FirefoxDriver();
	      }
	      else
	      {
	    	  System.out.println("Browser value is not mathcing");
	      }
	      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	      driver.manage().deleteAllCookies();
	      driver.get(url);
	
  }

  @AfterMethod
  public void tearDown() 
  {
	  driver.close();
  }



}
