package testNG_Basics;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssrt {
	SoftAssert softAssert = new SoftAssert();
	 
	@BeforeMethod
	public void beforemethod() {
		System.out.println("-----Before Method-----");
	}
	
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("-----After Method-----");
	}
	
	@Test
	public void Test2() {
		
		int a = 2;
		int b = 3;
		System.out.println("Executing Test2");
		String Actualtitle = "Amazon";
		System.out.println("Actaultitle :" + Actualtitle);
		String Expectedtitle  = "Amazon";
		softAssert.assertEquals(Expectedtitle, Actualtitle);
		System.out.print("A \n");
		if(a == b) {
			Assert.fail("Both values are same failling test cases");
		}
		
		System.out.print("B \n");
		softAssert.assertEquals(a, b);
		System.out.print("c \n");
		softAssert.assertAll();
		
		
		
	}



}
