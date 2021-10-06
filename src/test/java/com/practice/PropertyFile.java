package com.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("./commondata.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		
		String value=prop.getProperty("URL");
		
		System.out.println(value);	
	}

}
