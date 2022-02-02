package javapac;

public class AlpahaNumeric_Summation {

	public static void main(String[] args) {
		String s1="1s23et";

		char[] arr = s1.toCharArray();

		int a=0;

		for (int i = 0; i < arr.length; i++) {

			//System.out.println(arr[i]);
			if(arr[i]>=48 && arr[i]<=57)
			{
				a=a+arr[i]-48;
			}
			
		}
		System.out.println(a);
	}

}
