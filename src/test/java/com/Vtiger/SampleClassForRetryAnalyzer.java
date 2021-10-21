package com.Vtiger;

import org.testng.annotations.Test;

public class SampleClassForRetryAnalyzer {
	
	@Test(retryAnalyzer = com.vtiger.generic.RetryAnalyzer.class)
	public void sampleTest()
	{
		System.out.println(10/0);
	}

}
