package input;
import java.util.Scanner;
public class input3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer=1;
		Scanner scan=new Scanner(System.in);
do{
	
	System.out.println("Please enter an integer:");
	answer=scan.nextInt();
	
}while(answer!=3);
scan.close();
	}

}
