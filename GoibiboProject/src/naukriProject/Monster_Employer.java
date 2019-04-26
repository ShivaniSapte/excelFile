/**
 * 
 */
package naukriProject;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import bsh.commands.dir;

/**
 * @author shivani
 *
 */
public class Monster_Employer {
	WebDriver driver;
	Function_PropertyFile pf;
	String objfile="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\naukriProject\\objects.property";
		
	public Monster_Employer(WebDriver driver) {
		this.driver=driver;
	}
	@Test
	public void employerTest() throws Exception
	{
		pf=new Function_PropertyFile(objfile);
		
		By employer=By.xpath(pf.getData("emp_xpath"));
		
		driver.findElement(employer).click();
		Thread.sleep(2000);
	}
		
		@Test(priority=1,dependsOnMethods= {"employerTest"})
		public void thinkingTest() throws IOException, InterruptedException
		{
			pf=new Function_PropertyFile(objfile);
			By thinking=By.xpath(pf.getData("emp_think_xpath"));
			
			String parentWin=driver.getWindowHandle();
			driver.findElement(thinking).click();//click on thinking option
		
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		while(i1.hasNext())
		{
			String childWin=i1.next();
			if(!parentWin.equals(childWin))
			{
				driver.switchTo().window(childWin);
				Thread.sleep(2000);
				System.out.println("Title of child Window = "+driver.getTitle());
				driver.close();
			}
		}
		Thread.sleep(2000);
		driver.switchTo().window(parentWin);
		Thread.sleep(2000);
		}
		
		@Test(priority=2,dependsOnMethods= {"employerTest"})
		public void buyOnlineTest() throws Exception
		{
			pf=new Function_PropertyFile(objfile);
			By buyOnline=By.xpath(pf.getData("emp_buyOnline_xpath"));
			By name=By.xpath(pf.getData("emp_bo_name_xpath"));
			By organization=By.xpath(pf.getData("emp_bo_org_xpath"));
			By city=By.xpath(pf.getData("emp_bo_city_xpath"));
			By mobile=By.xpath(pf.getData("emp_bo_mobile_xpath"));
			By mail=By.xpath(pf.getData("emp_bo_mail_xpath"));
			By submit=By.xpath(pf.getData("emp_bo_submit_xpath"));
			
			String parentWin=driver.getWindowHandle();
			
		driver.findElement(buyOnline).click();//click on buy online
		Thread.sleep(2000);
		Set<String> s2=driver.getWindowHandles();
		Iterator<String> i2=s2.iterator();
		while(i2.hasNext())
		{
			String childWin=i2.next();
			if(!parentWin.equals(childWin))
			{
				driver.switchTo().window(childWin);
				Thread.sleep(2000);
				System.out.println("Title of child Window = "+driver.getTitle());
				driver.findElement(name).sendKeys("admin");
				driver.findElement(organization).sendKeys("admin.pvt.ltd");
				driver.findElement(city).sendKeys("Pune");
				driver.findElement(mobile).sendKeys("8793849930");
				driver.findElement(mail).sendKeys("admin@gmail.com");
				driver.findElement(submit).submit();
				driver.close();
			}
		}

		Thread.sleep(2000);
		driver.switchTo().window(parentWin);
		Thread.sleep(2000);
		
	}

}
