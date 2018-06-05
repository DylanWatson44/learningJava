package exercise1;

public class odd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int i = 1;
		int b = 0;
		do{
			
			b=i+b;	
			i+=2;		
			}
			while (i < 11);
		System.out.print(b);
		
	}

}
