package FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RoundTrip {
	WebDriver driver;
		
	By roundTrip = By.xpath("//*[@id='content']/div/div[2]/div/div[1]/div[2]/div[1]/div/span[2]");
	By from=By.id("gosuggest_inputSrc");
	By destination = By.id("gosuggest_inputDest");
	By departure_date = By.xpath("//*[@id='searchWidgetCommon']/div[1]/div[1]/div[1]/div/div[5]/input");
	By return_date = By.xpath("//*[@id='searchWidgetCommon']/div[1]/div[1]/div[1]/div/div[5]/input");
	By search=By.id("gi_search_btn");
	By travellers =By.id("pax_link_common");
	By traveler_class= By.id("gi_class");

	public RoundTrip(WebDriver driver){
		this.driver=driver;
	}
	
	public void twoWayTrip() throws Exception{
		driver.findElement(roundTrip).click();
		driver.findElement(from).sendKeys("Pune",Keys.ENTER);
		driver.findElement(destination).sendKeys("Mumbai",Keys.ENTER);
		Thread.sleep(2000);
	}
	public void Calendar(){
		driver.findElement(departure_date).click();//departure date
		driver.findElement(By.xpath("//*[@id='searchWidgetCommon']/div[1]/div[1]/div[1]/div/div[5]/div/div/div[2]/div[3]/div[5]/div[5]")).click();
		driver.findElement(return_date).click();//return date
		driver.findElement(By.xpath("//*[@id='fare_20190330']")).click();
	}
	public void noOfTravellers(){
		driver.findElement(travellers).click();//click on traveler and economy
		driver.findElement(By.id("adultPaxPlus")).click();//for adults
		driver.findElement(By.id("childPaxPlus")).click();// for children
		driver.findElement(By.id("infantPaxPlus")).click();//for infants below 2 years
		
		Select sel=new Select(driver.findElement(traveler_class));//drop down for traveler class option
		WebElement ele=sel.getFirstSelectedOption();
		System.out.println("Default selected option of class--> "+ele.getText());
		sel.selectByVisibleText("First class");
		
		driver.findElement(By.id("pax_close")).click();//close traveler box
	
	}
	public void searchButton(){
		driver.findElement(search).click();
	}
}
