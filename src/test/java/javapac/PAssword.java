package javapac;


class sample1
{
	public void mukesh() 
	{
		System.out.println("mukesh");
	}
}

class sample2
{
	public void ratish() 
	{
		System.out.println("ratish");
	}
}

public class PAssword {

	public static void main(String[] args) {
		//String s1= "Mukesh";

		//		StringBuffer sb = new StringBuffer("MOuli");
		//		System.out.println(sb.reverse());
		//
		//		StringBuilder builder = new StringBuilder("Ismail");
		//		System.out.println(	builder.reverse());


		//		String reverse="";
		//		
		//		for (int i = s1.length()-1; i >=0; i--) 
		//		{
		//		reverse=reverse+s1.charAt(i);
		//		}
		//		
		//		System.out.println(reverse);
		//		
		//		String input = "Ratish";
		//		char[] arr = input.toCharArray();
		//		String output="";
		//		
		//		for (int i = arr.length-1; i >=0; i--) 
		//		{
		//			output=output+arr[i];
		//		}
		//		System.out.println(output);


		//		String s1="TYSS";
		//		String s2="qwertyy";
		//
		//		System.out.println(s1.equals(s2));

		//	System.out.println(s1==s2);

		sample1 s1 = new sample1();
		s1.mukesh();


		sample2 s2 = new sample2();
		s2.ratish();

		System.out.println(s1);

		System.out.println(s2);

		System.out.println(s1.equals(s2));


	}

}
