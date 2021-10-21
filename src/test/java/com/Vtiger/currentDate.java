package com.Vtiger;

import java.util.Date;

public class currentDate {
	
	public static void main(String[]args)
	{
		System.out.println(new Date().toString().replace(":", "_").replace(" ", "_"));
	}

}
