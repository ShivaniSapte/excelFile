package Paytm_POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hotels 
{
	PropertyFile pf;
	String working_dir="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\Paytm_POM\\config.property";
	WebDriver driver;
	
	@Test
	public void hotelsTest() throws Exception
	{
		pf=new PropertyFile(working_dir);
		By hotel=By.xpath(pf.getPropertyData("hotel_xpath"));
		By seachBox=By.xpath(pf.getPropertyData("search_xpath"));
		By option=By.xpath(pf.getPropertyData("mumbai_xpath"));
		By destHotel=By.xpath(pf.getPropertyData("destList_xpath"));
		By selectHotel=By.xpath(pf.getPropertyData("selectHotel_xpath"));
		driver.findElement(hotel).click();//click on hotel
		 
		//driver.findElement(seachBox).sendKeys("Mumbai");//click on search box
		//driver.findElement(option).click();//click on option
		//Thread.sleep(3000);
		
		  JavascriptExecutor js= (JavascriptExecutor)driver;
		  WebElement ele=driver.findElement(destHotel);
		  js.executeScript("arguments[0].scrollIntoView();", ele);
		  Thread.sleep(3000);
		  ele.click();
		  Thread.sleep(3000);
		  driver.findElement(selectHotel).click();
		  Thread.sleep(3000);
		  
	
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
