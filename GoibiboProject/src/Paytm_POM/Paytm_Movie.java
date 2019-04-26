package Paytm_POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Paytm_Movie {
	PropertyFile pf;
	String working_dir="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\Paytm_POM\\config.property";
	WebDriver driver;
	
	@Test
	public void movieTest() throws Exception
	{
		pf=new PropertyFile(working_dir);
		By movie=By.xpath(pf.getPropertyData("movie_xpath"));
		By city=By.xpath(pf.getPropertyData("city_xpath"));
		By language=By.xpath(pf.getPropertyData("language_xpath"));
		By moviePic=By.xpath(pf.getPropertyData("select_movie_xpath"));
		By aboutMovie=By.xpath(pf.getPropertyData("about_movie_xpath"));
		By showTime=By.xpath(pf.getPropertyData("show_time_xpath"));
		By date=By.xpath(pf.getPropertyData("date_xpath"));
		
		System.out.println("Movie option display is "+driver.findElement(movie).isDisplayed());
		driver.findElement(movie).click();//click on movie
		driver.findElement(city).click();//select city from options
		driver.findElement(language).click();//select movie language hindi
		driver.findElement(moviePic).click();//select movie
		Thread.sleep(3000);//sleep for 3 seconds
		System.out.println("About movie display is "+driver.findElement(aboutMovie).isDisplayed());
		driver.findElement(aboutMovie).click();//click on about movie
		Thread.sleep(2000);
		driver.findElement(showTime).click();//click on show time
		Thread.sleep(3000);
		driver.findElement(date).click();
		
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
