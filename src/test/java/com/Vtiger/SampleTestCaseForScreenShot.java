package com.Vtiger;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseClass;

//@Listeners(com.vtiger.generic.ListenerImplementation.class)
public class SampleTestCaseForScreenShot extends BaseClass {
	
	@Test
	public void demoTest()
	{
		System.out.println(10/0);
	}
	
	

}
