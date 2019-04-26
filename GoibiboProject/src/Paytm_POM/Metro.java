package Paytm_POM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Metro {
	PropertyFile pf;
	String working_dir="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\Paytm_POM\\config.property";
	WebDriver driver;
	
  @Test
  public void metroTest() throws Exception 
  {
	  pf=new PropertyFile(working_dir);
	  By metro=By.xpath(pf.getPropertyData("metro_xpath"));
	  By metroName=By.xpath(pf.getPropertyData("metroName_xpath"));
	  By cardNo=By.xpath(pf.getPropertyData("card_xpath"));
	  By amount=By.xpath(pf.getPropertyData("amount_xpath"));
	  By proceed=By.xpath(pf.getPropertyData("proceed_xpath"));
	  By logo=By.xpath(pf.getPropertyData("logo_xpath"));
	  By checkBox=By.cssSelector(pf.getPropertyData("checkbox_css"));
	  By payment=By.xpath(pf.getPropertyData("pay_xpath"));
	  By frame=By.xpath(pf.getPropertyData("frame_xpath"));
	  By login=By.xpath(pf.getPropertyData("login_xpath"));
	  By registerdNo=By.xpath(pf.getPropertyData("paytmNo_xpath"));
	  By password=By.xpath(pf.getPropertyData("paytmPass_xpath"));
	  By loginSecurely=By.xpath(pf.getPropertyData("loginSecurely_xpath"));
	  
	  
	  driver.findElement(metro).click();//click on metro
	  driver.findElement(metroName).sendKeys("Delhi Metro");//enter metro name
	  driver.findElement(cardNo).sendKeys("123456789");//enter card number
	  driver.findElement(amount).sendKeys("100");//enter amount
	  driver.findElement(proceed).click();//click on proceed
	  Thread.sleep(3000);
	
	  //Assert.assertEquals("Paytm Promo Codes, Coupons, Cashback, Discounts, Vouchers | Paytm.com",driver.getTitle());
	  System.out.println("Title after clicking on proceed to pay---> "+driver.getTitle());
	  System.out.println("Logo display is---> "+driver.findElement(logo).isDisplayed());

	  driver.findElement(checkBox).click();//select check box
	  driver.findElement(payment).click();//click on proceed
	  Thread.sleep(5000);
	  WebElement frameEle=driver.findElement(frame);
	  driver.switchTo().frame(frameEle);//switch to frame
	  driver.findElement(login).click();//click on login
	  driver.findElement(registerdNo).sendKeys("8793849930");
	  driver.findElement(password).sendKeys("123456789");
	  driver.findElement(loginSecurely).click();
	  Thread.sleep(3000);
	 
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[6]/div[2]/div/div/a")).click();
	  Thread.sleep(5000);
	  
	  
  
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
