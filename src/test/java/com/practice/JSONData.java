package com.practice;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONData {

	public static void main(String[] args) throws IOException, ParseException 
	{
		FileReader inputfile = new FileReader("./CommonData.json");

		//Parsing the JSON into Java
		
		JSONParser parser = new JSONParser();
		
		Object obj =parser.parse(inputfile);
		
		//type casting
		HashMap jobj = (HashMap) obj;
		
		String value =jobj.get("username").toString();
		
		System.out.println(value);
		
		
	}

}
