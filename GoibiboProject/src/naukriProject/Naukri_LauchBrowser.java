package naukriProject;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Naukri_LauchBrowser 
{
	public static WebDriver driver=null;
	Function_PropertyFile pf;
	String objfile="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\naukriProject\\objects.property";
	
	public void setUp() throws IOException
	{
		pf=new Function_PropertyFile(objfile);
		String browser=pf.getData("browser");
		String url=pf.getData("url");
		By logo=By.xpath(pf.getData("logo_xpath"));
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();

		}
		System.out.println("Launch browser ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(url);
		System.out.println("logo display is "+driver.findElement(logo).isDisplayed());
		
		List<WebElement> linkele= driver.findElements(By.tagName("a"));
		System.out.println("Number of links on page = "+linkele.size());
		
		for(WebElement link:linkele)
		{
			System.out.println("Links on page = "+link.getText());
		}
		
	}
	
	public void tearDown()
	{
		System.out.println("Close browser");
		driver.quit();
		driver=null;
	}

}
