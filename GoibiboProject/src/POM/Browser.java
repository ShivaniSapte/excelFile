package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	public static WebDriver driver=null;
	public static String browser= "chrome";

	public static void launchBrowser() {
		if (driver == null){
			if(browser.equalsIgnoreCase("chrome"));{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\chromedriver.exe");
	    driver=new ChromeDriver();
	}
}
	else if( browser.equalsIgnoreCase("Firefox")){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\geckoedriver.exe");
	    driver=new FirefoxDriver();
	}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.goibibo.com");

	}

public static void quit(){
	System.out.println("quiting the browser");
	driver.quit();
	driver = null;
}
}
