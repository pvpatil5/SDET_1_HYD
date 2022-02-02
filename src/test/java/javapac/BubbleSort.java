package javapac;

public class BubbleSort {
	public static void main(String[] args) {

		//int[] arr= {1,-2,11,7,66,13};
		
		char [] arr= {'q','a','c','r','b','y'};

		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					char temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}

		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+",");
		}

	}

}
