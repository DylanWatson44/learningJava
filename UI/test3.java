public class test3 {
/**Hundred lolipop test. Uses a for loop with int 'n' which starts at 100 and decreases
 * every time the loop completes (generating a lolipop of random size and start point,
 * terminating when n hits 0. Utilizes the randomcolour boolean to produce randomly
 * coloured lolipops. Alternatively, one could use the commented-out UI.askBoolean
 * if they wished to set the boolean on or off with user input.
 */
	
	public static void main(String[] args) {
		
		Lolipop hundred = new Lolipop();
		boolean randomcolour = true;// UI.askBoolean("Do you want random colours? true or false:");
		for (int n = 100; n > 0;  n--){
		double x = Math.random()*500 + 10;		//
		double y = Math.random()*400 + 10;		//+10 to fit in console better, and
		double size = Math.random()*50 +10;		//to give size a minimum value
		double length = size;
		
		hundred.lolidrawing(x, y, size, length, randomcolour);  
	}}}															
																
