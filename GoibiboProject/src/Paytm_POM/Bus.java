/**
 * 
 */
package Paytm_POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author shivani
 *
 */
public class Bus {
	
	PropertyFile cpf;
	String working_dir="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\Paytm_POM\\config.property";
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		cpf=new PropertyFile(working_dir);
		
		//define global variables
		String browser=cpf.getPropertyData("browser");
		String url =cpf.getPropertyData("url");
		
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
	
	 @DataProvider
		public Object[][] getData() throws Exception
		{
			ExcelRead er=new ExcelRead("C:\\\\Users\\\\shivani\\\\eclipse-workspace\\\\GoibiboProject\\\\ExcelReadFile.xlsx", "Paytm_bus_Test");
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

//	 (dataProvider="getData")
	@Test
	public void busTest() throws Exception
	{
		cpf=new PropertyFile(working_dir);
		By bus=By.xpath(cpf.getPropertyData("bus_xpath"));
		By source=By.xpath(cpf.getPropertyData("source_xpath"));
		By destination=By.xpath(cpf.getPropertyData("destination_xpath"));
		By search_btn=By.xpath(cpf.getPropertyData("search_bus_xpath"));
		By selectBus=By.xpath(cpf.getPropertyData("select_bus_xpath"));
		By avlblSeat=By.xpath(cpf.getPropertyData("avlbl_bus_seat_xpath"));
		By boardingPoint=By.xpath(cpf.getPropertyData("boarding_bus_point_xpath"));
		By slctBoardingOption=By.xpath(cpf.getPropertyData("bus_boarding_option_xpath"));
		By dropPoint=By.xpath(cpf.getPropertyData("bus_drop_point_xpath"));
		By scltDropOption=By.xpath(cpf.getPropertyData("bus_dropping_oprtion_xpath"));
		By continueBtn=By.xpath(cpf.getPropertyData("bus_continue_btn_xpath"));
		
		driver.findElement(bus).click();//click on bus
		
		driver.findElement(source).sendKeys("Pune");;//enter source
		driver.findElement(By.xpath("//*[text()=\"Pune\"][1]")).click();;
		Thread.sleep(2000);
		driver.findElement(destination).sendKeys("Mumbai");//enter destination
		
		driver.findElement(By.xpath("//*[text()=\"Mumbai\"]")).click();	
		Thread.sleep(2000);

		driver.findElement(search_btn).click();//click on search button
		Thread.sleep(3000);
		
		WebElement btnele=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div[3]/div/div[2]/div[5]"));
		Actions act=new Actions(driver);
		act.moveToElement(btnele).clickAndHold().moveByOffset(0,39).build().perform();
		Thread.sleep(3000);
		
		driver.findElement(selectBus).click();//select bus
		
		WebElement ele=driver.findElement(avlblSeat);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);//scroll down till available seats
		Thread.sleep(2000);
		
		driver.findElement(boardingPoint).click();//click on boarding point
		driver.findElement(slctBoardingOption).click();//select pick up option
		driver.findElement(dropPoint).click();//click on dropping point
		driver.findElement(scltDropOption).click();//select drop location
		
		driver.findElement(continueBtn).click();//click on continue button
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
