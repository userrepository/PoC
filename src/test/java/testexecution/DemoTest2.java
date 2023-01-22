package testexecution;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest2 
{
	@Test
	public void test4() 
	{
		System.out.println("this is test 4>> "+Thread.currentThread().getId());
		Assert.assertEquals(true, true);
	}
	
	@Test
	public void test5() 
	{
		System.out.println("this is test 5>> "+Thread.currentThread().getId());
		Assert.assertEquals(false, true);
	}
	

}
