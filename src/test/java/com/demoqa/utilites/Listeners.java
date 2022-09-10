package com.demoqa.utilites;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
	
	ExtentReports extent=reporting.ExtentReports();
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		
	extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Testpass");
		
	}

	public void onTestFailure(ITestResult result) {
	
		test.fail(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {

		
	}


	public void onStart(ITestContext context) {
	
	
	}

	public void onFinish(ITestContext context) {
	
		extent.flush();
	}

}
