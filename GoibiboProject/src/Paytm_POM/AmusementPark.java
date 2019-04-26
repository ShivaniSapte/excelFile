package Paytm_POM;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmusementPark 
{
	WebDriver driver;
	PropertyFile pf;
	String working_dir="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\Paytm_POM\\config.property";
	
	@Test
	public void amusementParkTest() throws Exception
	{
		pf=new PropertyFile(working_dir);
		
		By amusement=By.xpath(pf.getPropertyData("amusement_xpath"));//amusement 
		By waterpark=By.xpath(pf.getPropertyData("waterPark_xpath"));//water park
		By selectPark=By.xpath(pf.getPropertyData("selectPark_xpath"));//select one park
		By calendar=By.xpath(pf.getPropertyData("calendar_xpath"));
		
		driver.findElement(amusement).click();//click on amusement park option
		driver.findElement(waterpark).click();//click on water park
		
		String parentWin=driver.getWindowHandle();
		driver.findElement(selectPark).click();//select one park
		
		Thread.sleep(3000);

		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		while(i1.hasNext())
		{
			String childWin=i1.next();
			if(!parentWin.equals(childWin))
			{
				driver.switchTo().window(childWin);
				Thread.sleep(2000);
				System.out.println("Title of child Window = "+driver.getTitle());
				driver.findElement(calendar).click();//click on calendar
				Thread.sleep(3000);
				driver.close();
			}
		}

		driver.switchTo().window(parentWin);
		
	
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
