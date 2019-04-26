package Paytm_POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PaytmMore {

	WebDriver driver;
	PropertyFile pf;
	String working_dir="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\Paytm_POM\\config.property";
	
	@Test(priority=2)
	public void gasBook() throws Exception
	{
		pf=new PropertyFile(working_dir);
		
		By cylinderBook=By.xpath(pf.getPropertyData("book_cylinder_xpath"));
		By gasBill=By.xpath(pf.getPropertyData("check_box_pay_gas_bill_xpath"));
		By gasBook=By.xpath(pf.getPropertyData("check_box_book_gas_xpath"));
		By gasMobNo=By.xpath(pf.getPropertyData("gas_mob_num_xpath"));
		By gasProceed=By.xpath(pf.getPropertyData("gas_book_proceed_xpath"));
		
		
		driver.findElement(cylinderBook).click();//click on cylinder book
		Thread.sleep(2000);
		System.out.println("By default gas book option selection is "+driver.findElement(gasBook).isSelected());
		System.out.println("Pay bill option selection is "+driver.findElement(gasBill).isSelected());
		driver.findElement(gasMobNo).sendKeys("8793849930");
		driver.findElement(gasProceed).click();
		Thread.sleep(3000);
	}
	@Test(priority=1)
	public void insuranceTest() throws Exception
	{
		pf=new PropertyFile(working_dir);
		
		By insurance=By.xpath(pf.getPropertyData("insurance_xpath"));
		By insurer=By.xpath(pf.getPropertyData("insurer_name_xpath"));
		By policyNo=By.xpath(pf.getPropertyData("inpolicy_num_xpath"));
		By dob=By.xpath(pf.getPropertyData("insurance_dob_xpath"));
		By mob=By.xpath(pf.getPropertyData("insurance_mob_xpath"));
		By proceed=By.xpath(pf.getPropertyData("insurance_btn_xpath"));
		
		
		driver.findElement(insurance).click();
		Thread.sleep(3000);
		driver.findElement(insurer).sendKeys("Bajaj Allianz Life Insurance");
		Thread.sleep(2000);
		//System.out.println("message at policy number is "+driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div[1]/div/div/div[2]/div[2]/ul/li[2]/div[2]")).getText());
		driver.findElement(policyNo).sendKeys("1234567890");
		Thread.sleep(3000);
		driver.findElement(dob).sendKeys("01021991");
		driver.findElement(mob).sendKeys("8793849930");
		driver.findElement(proceed).click();
		Thread.sleep(3000);
	
	}
	
	@Test(priority=3)
	public void googlePlayTest() throws Exception
	{
		pf=new PropertyFile(working_dir);
		
		By googlePlay=By.xpath(pf.getPropertyData("google_play_xpath"));
		By amount=By.xpath(pf.getPropertyData("gp_amount_xpath"));
		By proceed=By.xpath(pf.getPropertyData("gp_proceed_xpath"));
		
		driver.findElement(googlePlay).click();
		driver.findElement(amount).sendKeys("110");
		driver.findElement(proceed).click();
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
		
		     // By more=By.cssSelector(pf.getPropertyData("more_option_css"));
		driver.findElement(By.cssSelector("div._3CX4"));
		      Actions act=new Actions(driver);
				WebElement ele=driver.findElement(By.cssSelector("div._3CX4"));
				act.moveToElement(ele).build().perform();//mouse over more option
				Thread.sleep(2000);
				
	  }

	  @AfterMethod
	  public void tearDown() 
	  {
		  driver.close();
	  }


}
