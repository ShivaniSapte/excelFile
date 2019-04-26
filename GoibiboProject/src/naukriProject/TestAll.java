/**
 * 
 */
package naukriProject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author shivani
 *
 */
public class TestAll {
	Naukri_LauchBrowser lb;
	Naukri_Login log;
	
	@BeforeMethod
	public void setUp() throws Exception
	{
	    lb= new Naukri_LauchBrowser();
		lb.setUp();
		System.out.println("title of page = "+Naukri_LauchBrowser.driver.getTitle());
	}
	@Test(priority=1,enabled=false,groups= {"LoginTest"})
	public void testCases() throws Exception
	{
		 log=new Naukri_Login(Naukri_LauchBrowser.driver);
 		 log.loginTest();
	}
	@Test(priority=2,enabled=false,groups= {"LoginTest"})
	public void professionalTest() throws Exception
	{
		Monster_reg_exp re=new Monster_reg_exp(Naukri_LauchBrowser.driver);
		re.reg_exp_test();
	}
	@Test(priority=3,enabled=false)
	public void jobSearchTest() throws Exception
	{
		Monster_JobSearch js=new Monster_JobSearch(Naukri_LauchBrowser.driver);
		js.jobsearchTest();
	}
	@Test(priority=4,enabled=false)
	public void employeeTest() throws Exception
	{
		Monster_Employer emp=new Monster_Employer(Naukri_LauchBrowser.driver);
		emp.employerTest();
		emp.buyOnlineTest();
		emp.thinkingTest();
	}

	@Test(priority=3,groups= {"JobTest"})
	public void govJobTest() throws Exception	
	{
		Monster_GovJob gj=new Monster_GovJob(Naukri_LauchBrowser.driver);
		gj.govJobTest();
	}
	
	@Test(priority=6,groups= {"JobTest"})
	public void contractJobTest() throws Exception
	{
		Monster_contractJob cj=new Monster_contractJob(Naukri_LauchBrowser.driver);
		cj.contractJobTest();
	}
	@AfterMethod
	public void tearDown()
	{
		lb.tearDown();
	}
}
