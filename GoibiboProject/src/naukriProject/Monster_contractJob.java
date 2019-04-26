/**
 * 
 */
package naukriProject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author shivani
 *
 */
public class Monster_contractJob {

	WebDriver driver;
	Function_PropertyFile pf;
	String objfile="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\naukriProject\\objects.property";
	
	public Monster_contractJob(WebDriver driver) {
		this.driver=driver;
	}
	
	public void contractJobTest() throws Exception
	{
		pf=new Function_PropertyFile(objfile);
		By contract=By.xpath(pf.getData("contract_job_xpath"));
		
		String parentWindow=driver.getWindowHandle();
		driver.findElement(contract).click();
		
		Set<String> s1=driver.getWindowHandles();
		Iterator<String>i1=s1.iterator();
		while(i1.hasNext())
		{
			String childWindow=i1.next();
			if(!parentWindow.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(childWindow);
				System.out.println("Title of child window = "+driver.getTitle());
				driver.close();
				
			}
		}
		driver.switchTo().window(parentWindow);
		
	}


}
