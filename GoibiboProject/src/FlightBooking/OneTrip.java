package FlightBooking;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OneTrip {
	WebDriver driver;
	By oneTrip= By.xpath("//*[@id='content']/div/div[2]/div/div[1]/div[2]/div[1]/div/span[1]");
	By from=By.id("gosuggest_inputSrc");
	By destination = By.id("gosuggest_inputDest");
	By departure_date = By.xpath("//*[@id='searchWidgetCommon']/div[1]/div[1]/div[1]/div/div[5]/input");
	By return_date = By.xpath("//*[@id='searchWidgetCommon']/div[1]/div[1]/div[1]/div/div[5]/input");
	By search=By.id("gi_search_btn");
	
	public OneTrip(WebDriver driver){
		this.driver=driver;
	}
	
	public void oneWayTrip(){
		driver.findElement(oneTrip).click();//select one way trip
		
		driver.findElement(from).sendKeys("Pune (PNQ)",Keys.ENTER);

		List <WebElement> list= driver.findElements(from);//take list of all suggestions   
		System.out.println("Auto suggest list is --> "+list.size());//print size of all suggestions
		
		for(WebElement from_list:list){
			System.out.println("List of source--> "+from_list.getAttribute("innerHTML"));
			if(from_list.getAttribute("innerHTML").contentEquals("Pune (PNQ)")){
				from_list.click();
			}
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(destination).sendKeys("Mumbai (BOM)",Keys.ENTER);
	}
	public void Calendar(){
		driver.findElement(departure_date).click();//departure date
		driver.findElement(By.xpath("//*[@id='searchWidgetCommon']/div[1]/div[1]/div[1]/div/div[5]/div/div/div[2]/div[3]/div[5]/div[5]")).click();
		driver.findElement(return_date).click();//return date
		driver.findElement(By.xpath("//*[@id='fare_20190330']")).click();
	}
	public void searchButton(){
		driver.findElement(search).click();
		//driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}
	
	
}
