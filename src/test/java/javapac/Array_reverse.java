package javapac;

public class Array_reverse {

	public static void main(String[] args) {
		int arr[]= {1,5,4,7,8,3};
		
		for (int i = 0; i < arr.length; i++) 
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println("--------");
		for (int i = arr.length-1; i >=0; i--) 
		{
			System.out.print(arr[i]+" ");
		}

	}

}
