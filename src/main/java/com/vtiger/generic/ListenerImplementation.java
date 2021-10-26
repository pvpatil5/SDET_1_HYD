package com.vtiger.generic;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {

	ExtentHtmlReporter reporter ;
	ExtentReports reports;
	ExtentTest test;

	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, "This method"+result.getMethod().getMethodName()+"is Failed");
		test.log(Status.FAIL,result.getThrowable() );

		try {
			String path=BaseClass.getscreenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void onTestStart(ITestResult result) {
		test= reports.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "This method"+result.getMethod().getMethodName()+"is Passed");

	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "This method"+result.getMethod().getMethodName()+"is skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		JavaUtility jv = new JavaUtility();
		String date = jv.getCurrentDate();
		
		reporter= new ExtentHtmlReporter("../SDETHYD_1/src/test/resources/Vtiger"+date+".html");
		reporter.config().setDocumentTitle("SDET-1");
		reporter.config().setReportName("VTiger");
		reporter.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(reporter);

		reports.setSystemInfo("AppURL", "http://localhost:8888");
		reports.setSystemInfo("Env", "Test QA");
		reports.setSystemInfo("Build", "2.1");
		reports.setSystemInfo("Reporter name", "Pavan");

	}

	public void onFinish(ITestContext context) {
		reports.flush();

	}



}
