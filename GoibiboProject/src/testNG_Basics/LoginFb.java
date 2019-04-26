package testNG_Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFb {

	public static void main(String[] args) throws Exception {
		String driverPath = "C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\driverLib\\chromedriver.exe";//driver path
		System.setProperty("webdriver.chrome.driver", driverPath);//set property
		WebDriver d=new ChromeDriver();
		d.get("https://www.fb.com");
		
		d.findElement(By.name("email")).sendKeys("abc@gmail.com");
		d.findElement(By.name("pass")).sendKeys("123456");
		d.findElement(By.xpath("//input[@value='Log In']")).click();
		Thread.sleep(5000);
		

	}

}
