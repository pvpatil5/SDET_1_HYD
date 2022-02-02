package javapac;

import java.util.Arrays;

public class Anagram_String{

	public static void main(String[] args)
	{
		String s1="Graab";
		String s2="braga";
		
		if(s1.length()==s2.length())
		{
			char[] ch1 = s1.toCharArray();
			char[] ch2 = s2.toCharArray();
			Arrays.sort(ch1);
			Arrays.sort(ch2);
			if(Arrays.equals(ch1,ch2)==true)
			{
				System.out.println("Both Strings are anagrams");
			}
			else
				System.out.println("not anagram");
			
		}
		else {
			System.out.println("Not anagrams outr");
		}

		

	}

}
