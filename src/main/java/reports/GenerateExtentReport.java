package reports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.util.IOUtils;
import org.bouncycastle.util.encoders.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;

public class GenerateExtentReport extends BaseClass
{
	public static ExtentReports extent; //specify the location of the project
	public static ExtentTest logger;   //what details should be there in the report
	
	public void generateReport() 
	{
		ExtentSparkReporter report;
		String time = new SimpleDateFormat("YYYY.MM.DD.HH.MM.SS").format(new Date());
		String name = "Test-Report "+time+".html";
		report = new ExtentSparkReporter(path+"//extentreport/"+name+"-");
		extent = new ExtentReports();
		extent.attachReporter(report);
		
		//system information
		extent.setSystemInfo("Machine: ", "Report");
		extent.setSystemInfo("OS: ", "Windows 11");
		extent.setSystemInfo("Browser: ", "Chrome");
		
		//report configuration
		report.config().setDocumentTitle("Test Report: ");
		report.config().setReportName("Demo Report: ");
		report.config().setTheme(Theme.DARK);
		
	}
	
	public String getScreenshot(WebDriver driver, String name) throws IOException 
	{
//		File screenshot = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
//		String datentime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY.MM.DD.hh.mm.ss"));
//		String destination = path+"//screenshots/snap-"+name+" "+datentime+".png";
//		File location = new File(destination);
//		FileUtils.copyFile(screenshot, location);
//		return destination;	
		
		File screenshot = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
		String datentime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY.MM.DD.hh.mm.ss"));
		String destination = path+"//screenshots/snap-"+name+" "+datentime+".png";
		File location = new File(destination);
		FileUtils.copyFile(screenshot, location);
		byte[] base64 = org.apache.commons.io.IOUtils.toByteArray(new FileInputStream(destination));
		return Base64.toBase64String(base64);
		
		
	}

}
