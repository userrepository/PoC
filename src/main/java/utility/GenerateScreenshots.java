package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import reports.GenerateExtentReport;

public class GenerateScreenshots extends GenerateExtentReport
{
	public String getScreenshot(WebDriver driver, String name) throws IOException 
	{
		File screenshot = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
		String datentime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY.MM.DD.hh.mm.ss"));
		String destination = path+"//screenshots//"+name+datentime+".png";
		File location = new File(destination);
		FileUtils.copyFile(screenshot, location);
		return destination;	
	}

}
