package com.demoqa.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	// public String baseURL="https://demoqa.com/elements";

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentSparkReporter report;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/elements");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String path = System.getProperty("user.dir") + "\\test-output\\myreport.htm";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("ToolQa");
		report.config().setDocumentTitle("TestResult");
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("QA", "Shishupal dagde");

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
