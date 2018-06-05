package evaluatingexpressions;

public class go {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a =5; int b = 10; int c= 15; boolean flag=true;
		if (!((a > 5) || (c < (a + b))))
		System.out.println("this is true");
		else
			System.out.println("this is not true");
		if (!(b <= 12) && ( a % 2 ==0))
		System.out.println("this is true too");
		else
			System.out.println("actually this is false");
		if ((a != 7) && (c >= 6) || flag)
			System.out.println("this is true");
		else
			System.out.println("yeah not so much");
	}

}
