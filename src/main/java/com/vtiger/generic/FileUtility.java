package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
	private FileUtility()
	{
		
	}
	
	public static FileUtility getinstanceofPropfile() {
		FileUtility fileutility= new FileUtility();
		return fileutility;
	}
	
	/**
	 * This Method will read the the data from prop file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDatafromPropfile(String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream("./commondata.properties");

		Properties prop = new Properties();
		prop.load(fis);

		return prop.getProperty(key);
	}
	
	


}
