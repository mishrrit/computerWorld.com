package webSite.listeners;

import java.io.IOException;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;


import ComputerWorld.utils.Utilities;

public class listenersImplementation implements ITestListener,ISuiteListener,IInvokedMethodListener{
	
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
	System.out.println("\n  Before Invocations :"+testResult.getTestClass().getName()+
			 " => " +method.getTestMethod().getMethodName());	
		
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("\n After Invocations :"+testResult.getTestClass().getName()+
				 " => " +method.getTestMethod().getMethodName());	
		
	}
	
	@Override
	public void onStart(ISuite suite) {
		
		System.out.println("\n Before Suite Run "+suite.getName());
		
	}

	@Override
	public void onFinish(ISuite suite) {
		
		System.out.println("\n\n After Suite Run  " +suite.getName());
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		// runs before the test 
		System.out.println("\n ******Runs before the test******" +result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// runs after the test success
		System.out.println("\n Runs after the test is Success "+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// runs after the test is failed
		System.out.println("\n runs after the test is failed "+result.getName());
		try {
			Utilities.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("\n Test Skipped are "+result.getStatus());
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("\n Before the test tag in xml "+context.getName());
		ITestNGMethod method[] = context.getAllTestMethods();
		for(ITestNGMethod methods:method) {
			System.out.println("Methods available in the classes are :"+methods.getMethodName());
		}
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("\n onFinish -> :"+context.getName());
		
	}

}
