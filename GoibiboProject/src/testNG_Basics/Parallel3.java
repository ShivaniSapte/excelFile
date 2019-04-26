package testNG_Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Parallel3 {
	public String baseUrl = "https://facebook.com/";//app url
    String driverPath = "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\chromedriver.exe";//driver path
    public WebDriver driver ; 
    
    @Test
    public void launchBrowser(){
    	 System.out.println("launching Chrome browser"); 
         System.setProperty("webdriver.chrome.driver", driverPath);//set property
         driver = new ChromeDriver();//initialize browser
         driver.manage().window().maximize();//maximize window
         driver.manage().deleteAllCookies();//delete all cookies of browser 
         driver.get(baseUrl);//enter url
         driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);//implicit wait for 2 seconds
         System.out.println(driver.getTitle());
         driver.close();
    }

}
