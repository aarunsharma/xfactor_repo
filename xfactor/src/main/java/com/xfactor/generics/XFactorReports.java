package com.xfactor.generics;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class XFactorReports {
	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports reports;
	
	public void setUpExtent()
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+File.separator+"extent-reports"+File.separator+"TestResults.html");
		htmlReporter.config().setDocumentTitle("Test Case Report");
		htmlReporter.config().setReportName("Xfactor Test Case Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("OS", "Windows");
		
	}
	
	public void endOfReport()
	{
		reports.flush();
	}
	
	public ExtentTest getExtentTestName(String testName)
	{
		return reports.createTest(testName);
	}
	
}
