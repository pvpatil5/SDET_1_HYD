package javapac;

public class RemoveDuplicatesfromStringandArray {

	public static void main(String[] args) {
		String s1= "TestYantra";

		s1=s1.toLowerCase();
		char[] ch = s1.toCharArray();
		
	//	int[] ch = {1,5,7,5,7,4,2};

		for (int i = 0; i < ch.length; i++) 
		{
			int count=1;
			for (int j = i+1; j < ch.length; j++) 
			{
				if(ch[i]==ch[j]) 
				{
					count++;
					ch[j]=0;
				}
				
				
			}
			if(ch[i]!=0)
			{
				System.out.println(ch[i]+" "+count+" ");
				
			}
		}
	}
}