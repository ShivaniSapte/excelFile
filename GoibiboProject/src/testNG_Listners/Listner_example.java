package testNG_Listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listner_example implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 System.out.println("The name of the testcase failed is :"+result.getName());					

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase Skipped is :"+result.getName());					
	    		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test has been started--> "+result.getName());
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test successfully completed--> "+result.getName());
		
	}

}
