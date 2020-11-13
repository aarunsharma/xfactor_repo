package com.xfactor.generics;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class XFactorListener implements ITestListener {
	XFactorReports xfr = new  XFactorReports();
	private ExtentTest et;
	@Override
	public void onStart(ITestContext context) {
		Reporter.log("Test Suite Execution Started \nTime Stamp: "+new Date(), true);
		xfr.setUpExtent();
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log(context.getName() + " has finished it's execution " + new Date(), true);
		xfr.endOfReport();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 BaseTest bt = (BaseTest) result.getInstance();
		 WebDriver driver = bt.getDriverInstance();
		 if (result.getStatus() == ITestResult.FAILURE) {
				et = xfr.getExtentTestName(result.getName());
				et.log(Status.FAIL, result.getName() + " has Failed, capturing Screen shot now: " + new Date());
				TakesScreenshot tss = (TakesScreenshot) driver;
				File src = tss.getScreenshotAs(OutputType.FILE);
				File dest = new File(System.getProperty("user.dir")+File.separator+"screenshot"+File.separator+"fail.jpg");
				try {
					FileUtils.copyFile(src, dest);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		 }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			et = xfr.getExtentTestName(result.getName());
			et.log(Status.SKIP, result.getName() + " is Skipped" + new Date());
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		if(result.getStatus() == ITestResult.STARTED)
		{
			Reporter.log(result.getName()+" has started ", true);
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			et = xfr.getExtentTestName(result.getName());
			et.log(Status.PASS, result.getName() + " has Passed " + new Date());
		}
	}
}
