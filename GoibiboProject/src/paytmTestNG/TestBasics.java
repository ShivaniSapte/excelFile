package paytmTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestBasics {
  @Test
  public void TestCase1() {
	  System.out.println("Execute Test case 1");
  }

  @Test
  public void TestCase2() {
	  System.out.println("Execute Test case 2");
  }

  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("execute before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Execute after method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Execute before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Execute after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Execute before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Execute after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Execute before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("execute after suite");
  }

}
