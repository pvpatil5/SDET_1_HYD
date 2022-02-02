package javapac;

public class RoatationArray {

	public static void main(String[] args) {

		int arr[]= {2,5,8,3,7,1,4,6};
		int value=arr.length-1;

		for (int i = 0; i < arr.length-1; i++)
		{
			int temp=arr[i];
			arr[i]=arr[value];
			arr[value]=temp;
			value--;
			System.out.println(arr[i]);

		}

//		for (int i = 0; i < arr.length; i++)
//		{
//			System.out.println(arr[i]);
//		}
	}

}
