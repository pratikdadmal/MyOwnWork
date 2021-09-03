package com.JunitCoverageProgram.JunitCoverageProgram;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest 
{
	AppProduct app = new AppProduct();
	
	
	@Test
	public void showTest()
	{
		String str = app.show();
		Assert.assertEquals("pratik", str);
	}
	
	@Test
	public void addTest()
	{
		int com = app.add();
		Assert.assertEquals(30, com);
	}
	
}
