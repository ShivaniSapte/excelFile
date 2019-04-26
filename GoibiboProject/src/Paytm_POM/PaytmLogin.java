package Paytm_POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PaytmLogin {
	PropertyFile pf;
	WebDriver driver=null;
	String working_dir="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\Paytm_POM\\config.property";

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
			
			
	}
    
	@Test(dataProvider="getData")
	public void loginTest(String mobile,String pass) throws Exception 
	{
			
		By login=By.xpath(pf.getPropertyData("login_xpath"));
        By frame=By.xpath(pf.getPropertyData("frame_xpath"));
        By login_with_num=By.xpath(pf.getPropertyData("login_with_num_xpath"));
        By mobilenum=By.xpath(pf.getPropertyData("mobilenum_xpath"));
        By password=By.xpath(pf.getPropertyData("password_xpath"));
        By login_btn=By.xpath(pf.getPropertyData("login_button_xpath"));
        
        Thread.sleep(3000);
        
       // WebDriverWait wait= new WebDriverWait(driver,10);
        //wait.until(ExpectedConditions.elementToBeClickable(login));//wait until element to be clickable
	  
       	driver.findElement(login).click(); //click on log in button	
    	Thread.sleep(3000);
		
		WebElement frame_ele=driver.findElement(frame);//switch to element
		driver.switchTo().frame(frame_ele);
		
		driver.findElement(login_with_num).click();//click on login with no.
		Thread.sleep(3000);
		
		driver.findElement(mobilenum).sendKeys(mobile);
		driver.findElement(password).sendKeys(pass);
		Thread.sleep(3000);
		driver.findElement(login_btn).click();
		
		
	}
	
	 @DataProvider
		public Object[][] getData() throws Exception
		{
			ExcelRead er=new ExcelRead("C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\ExcelReadFile.xlsx", "Paytm_Login_Test");
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
	 @AfterMethod
	 public void tearDown()
	 {
		 driver.close();//close browser
			
	 }
	
	

}
