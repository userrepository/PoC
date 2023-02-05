package testexecution;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pom.HomePage;

public class HomePageTest extends BaseClass
{
	HomePage hm;
	
	@BeforeMethod
	public void setUp() throws InterruptedException 
	{
		loadBrowser();
		driver.get(property.getProperty("baseurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		Thread.sleep(10);
		hm = new HomePage();
		
	}
	
	@AfterMethod
	public void end() 
	{
		driver.quit();
	}

	@Test
	public void validateConnectTitle() throws InterruptedException 
	{
		String title =  hm.getMyConnect();
		 Assert.assertEquals(title, "\r\n"
		 		+ "	MyConnect V2 - GL_Home Page");
	}
}
