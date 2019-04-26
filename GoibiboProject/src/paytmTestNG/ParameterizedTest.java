package paytmTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ParameterizedTest {
	public String baseUrl = "https://paytm.com/";//app url
    String driverPath = "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\chromedriver.exe";//driver path
    String driverPath2 = "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\geckodriver.exe";//driver path
    public WebDriver driver=null ; 

  @Test
  @Parameters("browser")
  public void lauchBrowser(String browser) 
  {
	  if(browser.equalsIgnoreCase("chrome")){
		  System.out.println("launching Chrome browser"); 
	      System.setProperty("webdriver.chrome.driver", driverPath);//set property
	      driver = new ChromeDriver();//initialize browser
	  }else if(browser.equalsIgnoreCase("firefox")){
		  System.out.println("launching firefox browser"); 
	      System.setProperty("webdriver.gecko.driver", driverPath2);//set property
	      driver = new FirefoxDriver();//initialize browser
	  }
	  driver.manage().window().maximize();//maximize window
      driver.manage().deleteAllCookies();//delete all cookies of browser 
      driver.get(baseUrl);//enter url
      driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);//global or implicit wait for 2 seconds
	  
	  
	  
  }

}
