package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import reports.GenerateExtentReport;

public class MyListeners extends GenerateExtentReport implements ITestListener
{
	GenerateExtentReport ger = new GenerateExtentReport();
	
	public void onStart(ITestContext context) 
	{
		generateReport();
	}
	
	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		logger = extent.createTest(result.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel("Name of Test Case: " + result.getName(), ExtentColor.GREEN));
//		try {
//			logger.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(driver, result.getName())).build());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public void onTestFailure(ITestResult result) 
	{
		logger = extent.createTest(result.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel("Name of Test Case: " + result.getName(), ExtentColor.RED));
		logger.log(Status.FAIL, "Test Case Failed is: "+result.getThrowable());
		try {
			logger.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(driver, result.getName())).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		logger = extent.createTest(result.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel("Name of Test Case: " + result.getName(), ExtentColor.ORANGE));
		logger.log(Status.SKIP, "Test Case Failed is: "+result.getThrowable());
		try {
			logger.log(Status.SKIP, MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(driver, result.getName())).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@AfterMethod
//	public void tearDown(ITestResult result) throws IOException 
//	{
//		if(ITestResult.SUCCESS == result.getStatus()) 
//		{
//			getScreenshot(driver, result.getName());
//		}
//		else if(ITestResult.FAILURE == result.getStatus()) 
//		{
//			getScreenshot(driver, result.getName());
//		}
//		else if(ITestResult.SKIP == result.getStatus()) 
//		{
//			getScreenshot(driver, result.getName());
//		}
//	}
	


}
