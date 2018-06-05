package doWhile;

public class dowhileclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1; 
		String spaces= "";
		do {
			
			System.out.println(spaces + i);
			i++ ; // means increment by one, could do i+=2 to increment by 2
			spaces = spaces + " ";
			
		} while (i < 10);
		
	} 

}
