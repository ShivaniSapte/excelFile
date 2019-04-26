package testNG_Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelPrograms.FB_Excel_Read;

public class FB_DataProvider 
{
	public static WebDriver driver=null;
	
	@Test(dataProvider="getData")
	
		public void loginTest(String url, String username, String password) 
	{	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\chromedriver.exe");
		driver =new ChromeDriver();
		
			driver = FB_Methods.launchBrowser("chrome");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			boolean status = FB_Methods.LoginTest(driver, url, username, password);
			System.out.println("Status: "+status);
			driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws Exception{
		Object[][] data = new Object[3][3];
		
		FB_Excel_Read  dd = new FB_Excel_Read("C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\ExcelReadFile.xlsx","Sheet2");
	
		  
		//1st row
	
		data[0][0] = dd.getCellData(0, 0);
		data[0][1] = dd.getCellData(0, 1);
		data[0][2] = dd.getCellData(0, 2);
		
		// 2nd row
	
		data[1][0] = dd.getCellData(1, 0);
		data[1][1] = dd.getCellData(1, 1);
		data[1][2] = dd.getCellData(1, 2);
		
		
		// 3rd row
	
	    data[2][0] = dd.getCellData(2, 0);
		data[2][1] = dd.getCellData(2, 1);
		data[2][2] = dd.getCellData(2, 2);
		
		return data;
		
	}
}


