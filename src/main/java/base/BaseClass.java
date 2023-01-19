package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	public static Properties property = new Properties();
	public static String path = System.getProperty("user.dir");
	
	@BeforeMethod
	public void readPropertyFile() throws IOException 
	{
		FileInputStream fis = new FileInputStream(path+"//configproperties//config.properties");
		property.load(fis);
	}
	
	public void loadBrowser()
	{
		String browser = (String) property.get("browser");
		
		if(browser.equalsIgnoreCase("chrome")) 
		{
			driver = WebDriverManager.chromedriver().create();
		}
		else if(browser.equalsIgnoreCase("firefox")) 
		{
			driver = WebDriverManager.firefoxdriver().create();
		}
		else 
		{
			driver = WebDriverManager.edgedriver().create();
		}
		
		
	}

}
