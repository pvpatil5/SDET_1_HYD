package com.vtiger.generic;

import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	private JavaUtility() {
		
	}
	
	public static JavaUtility getInstanceofJavaUtility() 
	{
		JavaUtility jv = new JavaUtility();
		return jv;
	}

/**
 * This method is going to genrate random number
 * @return random number
 */
	public int generateRandomNo() 
	{
		Random random = new Random();
		return random.nextInt(1000);
	}
	Date dateobj = new  Date();
	String currentdate = dateobj.toString();
	String[] arr = currentdate.split(" ");
	
	/**
	 * Get Month
	 * @return
	 */
	public String getday() 
	{	
		return arr[0];
	}
	/**
	 * Get Current Month
	 * @return
	 */
	public String getmonth() {

		return arr[1];
	}

	/**
	 * Get Current Date
	 * @return
	 */
	public String getCurrentDate()
	{

		String day = arr[0];
		String month = arr[1];
		String todaysdate = arr[2];
		String year=arr[5];
		return day+" "+month+" "+todaysdate+" "+year;	

	}
}
