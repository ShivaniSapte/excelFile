/**
 * 
 */
package naukriProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author shivani
 *
 */
public class Monster_reg_exp {
	WebDriver driver;
	Function_PropertyFile pf;
	String objfile="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\naukriProject\\objects.property";
	
	public Monster_reg_exp(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void reg_exp_test() throws Exception
	{
	pf=new Function_PropertyFile(objfile);
		
		By login=By.xpath(pf.getData("login_xpath"));
		By signup=By.xpath(pf.getData("signup_xpath"));
		By professional=By.xpath(pf.getData("reg_pro_xpath"));
		By name=By.xpath(pf.getData("reg_name_xpath"));
		By mail=By.xpath(pf.getData("reg_email_xpath"));
		By pass=By.xpath(pf.getData("reg_pass_xpath"));
		By city=By.xpath(pf.getData("reg_city_xpath"));
		By isd=By.xpath(pf.getData("reg_isd_xpath"));
		By mobile=By.xpath(pf.getData("reg_mobile_xpath"));
		By resume=By.xpath(pf.getData("reg_resume_xpath"));
		By registration=By.xpath(pf.getData("reg_continue_xpath"));
	
		
		
		driver.findElement(login).click();
		Thread.sleep(3000);
		driver.findElement(signup).click();
		driver.findElement(professional).click();//select professional option
		driver.findElement(name).sendKeys("admin");//enter full name
		driver.findElement(mail).sendKeys("admin@gmail.com");//enter mail id
		driver.findElement(pass).sendKeys("admin@123456");//enter password
		Thread.sleep(2000);
		//driver.findElement(city).sendKeys("Pune",Keys.ENTER);//enter city
		//Thread.sleep(2000);
		
		WebElement code_ele=driver.findElement(isd);
		Select code_sel=new Select(code_ele);//select country code
		System.out.println("First default selected country code is "+code_sel.getFirstSelectedOption().getText());
		code_sel.selectByValue("43");
		Thread.sleep(2000);
		System.out.println("After selecting option "+code_sel.getFirstSelectedOption().getText());
		code_sel.selectByValue("+91");
		Thread.sleep(2000);
		driver.findElement(mobile).sendKeys("8793849930");//enter mobile number
		
		driver.findElement(By.xpath("//*[@id=\"registerThemeDefault\"]/div/div[2]/div[2]/div[2]/form/div[6]/div[1]/div[1]/div[1]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"registerThemeDefault\"]/div/div[2]/div[2]/div[2]/form/div[6]/div[1]/div[1]/div[1]/div/div[3]/ul/li[3]/span")).click();
		Thread.sleep(2000);
		
		driver.findElement(resume).sendKeys("admin resume");
		driver.findElement(registration).submit();//click on submit button

	
		
	}

}
