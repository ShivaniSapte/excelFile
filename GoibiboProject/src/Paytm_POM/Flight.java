package Paytm_POM;

import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flight {
	WebDriver driver;
	PropertyFile pf;
	String working_dir="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\Paytm_POM\\config.property";
	
	@Test
	public void flightTest() throws Exception
	{
		pf=new PropertyFile(working_dir);
		
		By flight=By.xpath(pf.getPropertyData("flight_xpath"));
		By source=By.xpath(pf.getPropertyData("flight_source_xpath"));
		By destination=By.xpath(pf.getPropertyData("flight_dest_xpath"));
		By travellers=By.xpath(pf.getPropertyData("flight_travellers_xpath"));
		By addAdults=By.xpath(pf.getPropertyData("flight_adults_xpath"));
		By addChild=By.xpath(pf.getPropertyData("flight_child_xpath"));
		By businessClass=By.xpath(pf.getPropertyData("flight_business_class_xpath"));
		By doneTraveller=By.xpath(pf.getPropertyData("flight_done_xpath"));
		By search=By.xpath(pf.getPropertyData("flight_search_xpath"));
		By depart=By.xpath(pf.getPropertyData("flight_depart_xpath"));
		By duration=By.xpath(pf.getPropertyData("flight_duration_xpath"));
		By arrival=By.xpath(pf.getPropertyData("flight_arrival_xpath"));
		By fareCalendar=By.xpath(pf.getPropertyData("flight_fare_calendar_xpath"));
		
		driver.findElement(flight).click();
		driver.findElement(source).sendKeys("Pune");//enter source location
		driver.findElement(By.xpath("//*[text()=\"Pune\"][1]")).click();
		driver.findElement(destination).sendKeys("Tokyo");//enter destination location
		driver.findElement(By.xpath("//*[text()=\"Tokyo\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"datePickerOnward\"]/div/div/input")).click();//click on calemdar
		driver.findElement(By.xpath("//*[@id=\"datePickerOnward\"]/div[2]/div/div[2]/table/tbody/tr[1]/td[5]/div/div")).click();//click on date
		driver.findElement(travellers).sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);//click on travelers
		driver.findElement(addAdults).click();//add adults
		driver.findElement(addChild).click();//add children
		driver.findElement(businessClass).click();//click on business class
		driver.findElement(doneTraveller).click();//click on done of traveler class
		Thread.sleep(2000);
		
		driver.findElement(search).click();//click on search button
		Thread.sleep(3000);
		
		driver.findElement(depart).click();//click on departure
		driver.findElement(duration).click();//click on duration
		driver.findElement(arrival).click();//click on arrival 
		
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


	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
