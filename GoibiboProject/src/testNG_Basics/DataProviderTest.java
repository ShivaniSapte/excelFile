package testNG_Basics;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderTest {
  @Test(dataProvider = "getData")
  public void loginT(String username, String password, String expected, String browser ) 
  {
	  System.out.println(username+"----"+password+"----"+expected+"----"+browser);
  }

  @DataProvider
  public Object[][] getData() 
  {
	  Object [] [] data=new Object[3][4];
	  
	  data[0][0] = "UN1";
	  data[0][1] = "PW1";
	  data[0][2] = "Pass";
	  data[0][3] = "Mozila";
	  
	  data[1][0] = "UN2";
	  data[1][1] = "PW2";
	  data[1][2] = "Pass";
	  data[1][3] = "Chrome";
	  
	  data[2][0] = "UN3";
	  data[2][1] = "PW3";
	  data[2][2] = "Fail";
	  data[2][3] = "Safari";
	  
    return data;
  }
}
