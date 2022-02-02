package javapac;

import java.util.ArrayList;
import java.util.Collections;

public class LongestWordinSentence {

	public static void main(String[] args) {
		String s1= "welcome to hyderabad the city of food";
		String[] str = s1.split(" ");
		
		for (int i = 0; i < str.length; i++) 
		{
			for (int j = i+1; j < str.length; j++) 
			{
				if(str[i].length()>str[j].length()) 
				{
					String temp=str[i];
					str[i]=str[j];
					str[j]=temp;	
				}
			}			
		}
		
		System.out.println(str[str.length-1]);
		

	}
}

