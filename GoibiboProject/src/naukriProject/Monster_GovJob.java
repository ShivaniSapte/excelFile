/**
 * 
 */
package naukriProject;

import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * @author shivani
 *
 */
public class Monster_GovJob {

	WebDriver driver;
	Function_PropertyFile pf;
	String objfile="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\naukriProject\\objects.property";
	
	public Monster_GovJob(WebDriver driver) {
		this.driver=driver;
	}

	public void govJobTest() throws Exception
	{
		pf=new Function_PropertyFile(objfile);
		By govJob=By.xpath(pf.getData("gov_job_xpath"));
		By jobTitle=By.xpath(pf.getData("gov_jobTitle_xpath"));
		By organization=By.xpath(pf.getData("gov_selJobTitle_xpath"));
		
		String parentWindow=driver.getWindowHandle();
		driver.findElement(govJob).click();
		
		Set<String> s1=driver.getWindowHandles();
		Iterator<String>i1=s1.iterator();
		while(i1.hasNext())
		{
			String childWindow=i1.next();
			if(!parentWindow.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(childWindow);
				System.out.println("Title of child window = "+driver.getTitle());
				driver.findElement(jobTitle).click();
				driver.findElement(By.xpath("//*[@id=\"mid_container\"]/div/div[1]/div[2]/div[2]/ul/li[3]/a")).click();
				driver.findElement(organization).click();
				driver.close();
				
			}
		}
		driver.switchTo().window(parentWindow);
		
	}
}
