package com.demoqa.utilites;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class reporting {

	
	
	public static ExtentReports extent;
	
	
	public static  ExtentReports ExtentReports()
	{
		String path=System.getProperty("user.dir")+"\\test-output\\myreport.htm";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("ToolQa");
		report.config().setDocumentTitle("TestResult");
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("QA", "Shishupal dagde");
		
		return extent;
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
