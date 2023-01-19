package testexecution;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest
{
	@Test
	public void test1() 
	{
		System.out.println("this is test 1");
		Assert.assertEquals(true, true);
	}
	
	@Test//(retryAnalyzer = retryfail.RetryAnalyzer.class)
	public void test2() 
	{
		System.out.println("this is test 2");
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test3() 
	{
		System.out.println("this is test 3");
		Assert.assertEquals(false, true);
	}

}
