package EndtoEndwebtest;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.browserInitialization;

public class Listeners implements ITestListener {
	browserInitialization bi=new browserInitialization();
	

	
    public void onTestStart(ITestResult result) 
    {
        
    }
    
    public void onTestSuccess(ITestResult result) 
    {
        
    }
    public void onTestFailure(ITestResult result)
    {
       try {
		bi.getScreenshot(result.getName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
   
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped");
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed but within success percentage");
    }
    public void onStart(ITestContext context) {
        System.out.println("This is onStart method");
    }
    public void onFinish(ITestContext context) {
        System.out.println("This is onFinish method");
        System.out.println("This is onFinish method");
    }
    

	

}
