package testNG_Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class config_Property_Read {

	config_Property_File cpf;
	String working_dir="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\testNG_Basics\\config.property";
	WebDriver driver;
	
	@Test
	public void loginTest() throws Exception
	{
		cpf=new config_Property_File(working_dir);
		
		//define global variables
		String browser=cpf.getPropertyData("browser");
		String url =cpf.getPropertyData("url");
		String email =cpf.getPropertyData("email");
		String password =cpf.getPropertyData("password");
		
		//define object property
		By mailid=By.name(cpf.getPropertyData("email_name"));
		By pass=By.name(cpf.getPropertyData("password_name"));
		By btn=By.xpath(cpf.getPropertyData("loginBtn_xpath"));

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
	      driver.findElement(mailid).sendKeys(email);
	      driver.findElement(pass).sendKeys(password);
	      driver.findElement(btn).click();
	      System.out.println("title--> "+driver.getTitle());
	      
	      driver.close();
	}
}
