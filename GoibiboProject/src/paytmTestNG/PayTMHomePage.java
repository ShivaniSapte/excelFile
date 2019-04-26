package paytmTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class PayTMHomePage {
	public String baseUrl = "https://paytm.com/";//app url
    String driverPath = "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\chromedriver.exe";//driver path
    public WebDriver driver ; 

  @BeforeTest
	  public void Launch_Browser() 
  {
	  System.out.println("launching Chrome browser"); 
      System.setProperty("webdriver.chrome.driver", driverPath);//set property
      driver = new ChromeDriver();//initialize browser
      driver.manage().window().maximize();//maximize window
      driver.manage().deleteAllCookies();//delete all cookies of browser 
      driver.get(baseUrl);//enter url
      driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);//implicit wait for 2 seconds
	  }

  @Test(priority=1,groups={"sanity"})
  public void homePage() throws Exception //test cases for home page
  {
  	  String expectedTitle="Paytm.com – Recharge & Utility Payments, Entertainment, Travel, DTH, Wallet & Payments";
	  String actualTitle=driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);//comparing actual and expected title
	  System.out.println(actualTitle);//print actual title
	  
	  Thread.sleep(3000);
  }
  
  @Test(priority=2)
  public void mobileRecharge() throws Exception//test cases for mobile recharge
  {
	/**WebElement preEle=driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/div[1]/label/i"));
	//preEle.click();
	System.out.println("Prepaid button is selected ---->"+preEle.isSelected());//for prepaid button
	System.out.println("Prepaid button is displayed ---->"+preEle.isDisplayed());//for prepaid button
	System.out.println("Prepaid button is enabled ----->"+preEle.isEnabled());//for prepaid button**/
	
	//enter mobile no.
	driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[2]/div[1]/div[1]/div/div[1]/div[2]/ul/li[1]/div/div/input")).sendKeys("8793849930");
	//enter service provider
	driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[2]/div[1]/div[1]/div/div[1]/div[2]/ul/li[2]/div/div/input")).sendKeys("Tata Docomo");
	//enter state
	driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[2]/div[1]/div[1]/div/div[1]/div[2]/ul/li[3]/div/div/input")).sendKeys("Maharashtra");
	//enter amount
	driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[2]/div[1]/div[1]/div/div[1]/div[2]/ul/li[4]/div/div/input")).sendKeys("35");
	//click on top_up button
	driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[2]/div[1]/div[1]/div/div[1]/div[2]/ul/li[3]/div/div[1]/input")).click();
	driver.findElement(By.cssSelector("div.gbIh")).click();//click on proceed to recharge button
	
	Thread.sleep(2000);
	//click on proceed to pay
	driver.findElement(By.xpath("//*[@id='app']/div/div[4]/div[2]/div/div[1]/div/ul/div[2]/li[2]/button")).click();
  
    }
  @Test(priority=3,enabled=false)
  public void search_box()
  {
	  driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/input")).click();
	  WebElement ele=driver.findElement(By.cssSelector("span.F7TQ"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).click().build().perform();

	  
  }
  

  @AfterTest
  public void afterMethod() //close browser
  {
	  System.out.println("Closing browser");
	  driver.close();
  }

}
