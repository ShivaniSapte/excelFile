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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DownloadApp {
	PropertyFile pf;
	String working_dir="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\Paytm_POM\\config.property";
	WebDriver driver;
	
	@Test(dataProvider="getData")
	public void downloadAppTest(String mobileNo) throws Exception
	{
		pf=new PropertyFile(working_dir);
		
		By downloadApp=By.cssSelector(pf.getPropertyData("downloadApp_css"));
		By mobile=By.xpath(pf.getPropertyData("mobile_num_xpath"));
		By sendLink=By.xpath(pf.getPropertyData("send_link_xpath"));
		
		System.out.println("Check download app displaying is "+driver.findElement(downloadApp).isDisplayed());
		
		
		Actions act=new Actions(driver);//mouse hover action on download app 
		WebElement ele=driver.findElement(downloadApp);
		act.moveToElement(ele).build().perform();
		Thread.sleep(3000);
		driver.findElement(mobile).sendKeys(mobileNo);// enter mobile no
		driver.findElement(sendLink).click();//click on send link  
		Thread.sleep(5000);
		
	}
	
	@Test(priority=2)
	public void payment_wallet() throws Exception
	{
		pf=new PropertyFile(working_dir);
		
		By wallet=By.cssSelector(pf.getPropertyData("wallet_xpath"));
		
		WebElement ele=driver.findElement(wallet);//move to element of payment wallet option
		System.out.println("Paytm wallet displaying is "+ele.isDisplayed());
		
		Actions act=new Actions(driver);
		act.moveToElement(ele).build().perform();
		Thread.sleep(3000);
		act.click();
		
		WebElement sub_ele=driver.findElement(By.xpath("/html/body"));//click on sub option of payment wallet
		act.moveToElement(sub_ele).click().build().perform();
		Thread.sleep(3000);

	}

	
	@DataProvider
	public Object[][] getData() throws Exception
	{
		ExcelRead er=new ExcelRead("C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\PaytmProject.xlsx", "Download_App_Test");
		Object[][] data=new Object[er.sh.getLastRowNum()][er.sh.getRow(0).getLastCellNum()];
		for(int i=0;i<er.sh.getLastRowNum();i++)
		{
			for(int j=0;j<er.sh.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=er.sh.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		return data;
		
	}	

	
	@BeforeMethod
	public void setUp() throws Exception
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
