package Paytm_POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Paytm_DTH {
	PropertyFile pf;
	WebDriver driver=null;
	String working_dir="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\Paytm_POM\\config.property";

	@Test
	public void dthTest() throws Exception
	{
		 driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[1]/div/a[3]")).click();//click on dth
		  
		  driver.findElement(By.xpath("//*[@id='app']/div/div[4]/div[1]/div[1]/div/div[2]/div[1]/ul/li[1]/div/div/input")).sendKeys("Dish TV");//enter service provider
		  driver.findElement(By.xpath("//*[@id='app']/div/div[4]/div[1]/div[1]/div/div[2]/div[1]/ul/li[2]/div[1]/input")).sendKeys("123456789");//enter dth no.
		  driver.findElement(By.xpath("//*[@id='app']/div/div[4]/div[1]/div[1]/div/div[2]/div[1]/ul/li[3]/div[1]/div/input")).sendKeys("50");//enter value
		  driver.findElement(By.xpath("//*[@id='app']/div/div[4]/div[1]/div[1]/div/div[2]/div[4]/button")).click();//click on proceed to recharge

		  Thread.sleep(3000);
		  
		pf=new PropertyFile(working_dir);
		
		By dth=By.xpath(pf.getPropertyData("dth_xpath"));
		By srvicProvider=By.xpath(pf.getPropertyData("srvc_provider_xpath"));
		By dthNo=By.xpath(pf.getPropertyData("dthNum_xpath"));
		By amount=By.xpath(pf.getPropertyData("amount_xpath"));
		By proceed=By.xpath(pf.getPropertyData("procced_xpath"));
		
/**		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[1]/div/a[3]")).click();//click on dth
		  Thread.sleep(3000);
		  driver.findElement(srvicProvider).sendKeys("Dish TV");//enter service provider
		  driver.findElement(dthNo).sendKeys("123456789");//enter dth no.
		  driver.findElement(amount).sendKeys("50");//enter value
		  driver.findElement(proceed).click();//click on proceed to recharge**/

	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		//read data from property file
				pf=new PropertyFile(working_dir);
		    
				String browser=pf.getPropertyData("browser");
		        String url=pf.getPropertyData("url");
		  	
		    	if(browser.equalsIgnoreCase("chrome"))
		    	{
		    		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\chromedriver.exe");//set property
		    		driver=new ChromeDriver();
		    	}
		    	else if(browser.equalsIgnoreCase("Firefox"))
		    	{
		    		driver=new FirefoxDriver();
		    	}
		    	else { System.out.println("browser is not matching");}
		    	
		    	driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.get(url);
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
			Thread.sleep(5000);
			
	}

	 @AfterMethod
	 public void tearDown()
	 {
		 driver.close();//close browser
			
	 }


}
