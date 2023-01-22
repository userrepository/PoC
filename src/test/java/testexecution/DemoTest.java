package testexecution;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import listeners.MyListeners;
import pom.HomePage;

//@Listeners(MyListeners.class)
public class DemoTest extends BaseClass
{
	@BeforeMethod
	public void setUp() 
	{
		loadBrowser();
		driver.get(property.getProperty("baseurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}
	
	@AfterMethod
	public void end() 
	{
		driver.quit();
	}
	
	@Test
	public void test1() 
	{
		System.out.println("this is test 1>> "+Thread.currentThread().getId());
		Assert.assertEquals(true, true);
	}
	
	@Test//(retryAnalyzer = retryfail.RetryAnalyzer.class)
	public void test2() 
	{
		System.out.println("this is test 2>> "+Thread.currentThread().getId());
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test3() 
	{
		System.out.println("this is test 3>> "+Thread.currentThread().getId());
		Assert.assertEquals(false, true);
	}

}
