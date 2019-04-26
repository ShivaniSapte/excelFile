package train;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TrainBooking {
	WebDriver driver;
	By from=By.id("gosuggest_inputL");
	By train=By.xpath("//*[@id='header']/div[1]/ul/li[5]/a/i");
	By frames=By.tagName("iframe");
	By pnr =By.xpath("/html/body/div[1]/div/div[2]/div[3]/div[1]/div/span[2]/span[1]/a");
	By pnrNo=By.id("pnrNumber");
	By checkStatus=By.id("checkStatus");
	
	public TrainBooking(WebDriver driver) {
		this.driver=driver;
	}
	public void frame(){
		System.out.println("total number of frames--> "+driver.findElements(frames).size());
		driver.switchTo().frame("welogin").close();
		driver.findElement(By.id("phone")).sendKeys("8793849930");
		driver.findElement(By.id("c_success")).click();
		
	}
	public void selectTrain(){
		driver.findElement(train).click();
	}
	public void enter_Source_destination(){//enter source and destination
		driver.findElement(from).sendKeys("Pune Junction",Keys.ENTER);//enter source
		driver.findElement(from).sendKeys(Keys.TAB,"Mumbai",Keys.ENTER);//enter destination
	}
	public void calendar(){//select date
		driver.findElement(By.xpath("//*[@id='gi_search']/div/div[3]/div[1]/div/div/input")).click();//click on calendar
		driver.findElement(By.xpath("//*[@id='gi_search']/div/div[3]/div[1]/div/div/div/div[2]/div[3]/div[5]/div[6]")).click();//click on date
	}
	public void selectClass(){//select class of traveler
	Select Train_class	=new Select(driver.findElement(By.xpath("//*[@id='gi_search']/div/div[3]/div[2]/select")));
	System.out.println("First default selected option in train class--> "+Train_class.getFirstSelectedOption().getText());
	Train_class.selectByValue("3A");
	
	}
	public void checkPNRstatus(){
		driver.findElement(pnr).click();
		driver.findElement(pnrNo).sendKeys("12124");
		driver.findElement(checkStatus).click();
	}
	public void search(){
		driver.findElement(By.id("gi_search_btn")).click();
	}
	
}
		