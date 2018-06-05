package helloworld;

public class helloclass {

	public static void main(String[] args) { // open brace and close brace defines a block
		// TODO Auto-generated method stub
		int foo; // this integer can only be accessed by this block
		double x;
		foo=100;
		x=15.5;
			System.out.println(foo);
		System.out.println("Hello World!");
		System.out.println(""); //adds an extra line
		System.out.println("Hello World!");
		/* slash star (press enter) will generate multiline comment
		 * 
		 */
		{
			int bar;
		}  
		// 'bar' can not be accessed outside of its scope
					}

}
