package testNG_Data_Provider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest 
{
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
	}
	@DataProvider
	public Object[][] getData() throws Exception{
		TestUtil  tu = new TestUtil("C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\ExcelReadFile.xlsx","DP_LoginTest");
		Object[][] data=new Object[tu.excelSh.getLastRowNum()][tu.excelSh.getRow(0).getLastCellNum()];
		for(int i=0;i < tu.excelSh.getLastRowNum();i++){
			for(int j=0; j<tu.excelSh.getRow(0).getLastCellNum();j++){
				data[i][j] =tu.excelSh.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		return data;

	}
	@Test(dataProvider=  "getData")
	public void loginTest(String emailID,String password )
	{
		driver.findElement(By.name("email")).sendKeys(emailID);
		driver.findElement(By.name("pass")).sendKeys(password);
		
		WebElement login_ele=driver.findElement(By.xpath("//input[@value='Log In']"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",login_ele);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
