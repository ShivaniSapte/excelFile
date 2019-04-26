/**
 * 
 */
package naukriProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author shivani 
 *
 */
public class Monster_JobSearch {
	WebDriver driver;
	Function_PropertyFile pf;
	String objfile="C:\\Users\\shivani\\eclipse-workspace\\GoibiboProject\\src\\naukriProject\\objects.property";
	
	
	public Monster_JobSearch(WebDriver driver)
	{
		this.driver=driver;
	}
	public void jobsearchTest() throws Exception
	{
		pf=new Function_PropertyFile(objfile);
		
		By jobsearch=By.xpath(pf.getData("job_search_xpath"));
		By keyword=By.id(pf.getData("js_keyword_id"));
		By location=By.id(pf.getData("js_loc_id"));
		By industry=By.xpath(pf.getData("js_industry_xpath"));
		By indusName=By.xpath(pf.getData("js_industryName_xpath"));
		By apply=By.xpath(pf.getData("js_apply_xpath"));
		By qualification=By.xpath(pf.getData("js_qualification_xpath"));
		
		driver.findElement(jobsearch).click();//click on job search
		Thread.sleep(2000);
		driver.findElement(keyword).sendKeys("Testing Engineer");
		
		driver.findElement(location).sendKeys("Pune",Keys.ENTER);
		//driver.findElement(industry).click();
		//driver.findElement(indusName).sendKeys("software",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(qualification).click();
		driver.findElement(apply).click();//click on apply button
	
	}

}
