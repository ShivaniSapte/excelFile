package Paytm_POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Browser {
	PropertyFile cpf;
	String working_dir="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\Paytm_POM\\config.property";
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		cpf=new PropertyFile(working_dir);
		
		//define global variables
		String browser=cpf.getPropertyData("browser");
		String url =cpf.getPropertyData("url");
		String actualTitle=cpf.getPropertyData("actualTitle");
		
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
	      
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	      driver.manage().deleteAllCookies();
	      driver.get(url);
	      //for title of page
	      System.out.println("Title of page--> "+driver.getTitle());
	      String expectedTitle="Paytm.com – Recharge & Utility Payments, Entertainment, Travel, DTH, Wallet & Payments";
	      Assert.assertEquals(expectedTitle, actualTitle);
	      //for logo of page
	      System.out.println("Logo displaying is--> "+driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/a/i")).isDisplayed());
   	
	      
	}
	
	@Test
	public void loginTest() throws Exception
	{
		cpf=new PropertyFile(working_dir);
		
		By login=By.xpath(cpf.getPropertyData("login_xpath"));
		By frame=By.xpath(cpf.getPropertyData("frame_xpath"));
		By login_with_num=By.xpath(cpf.getPropertyData("login_with_num_xpath"));
		
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[3]/div[4]/div")).click();
		Thread.sleep(2000);
		WebElement frame_ele=driver.findElement(By.xpath("//*[@id='app']/div/div[6]/div[2]/div/iframe"));
		driver.switchTo().frame(frame_ele);
		driver.findElement(By.xpath("//*[@id='wallet-container-new qr-bg-white']/qr-code-login/div[2]/div[2]/div[3]/span")).click();
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();

	}

}
