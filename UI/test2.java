import ecs100.UI;

public class test2 {
/** Line of lolipops test. Again, takes user input for the starting parameters, then
 * uses	a for loop to generate multiple lolis of increasing size, up to a set limit 
 * (x<500).
 */
	
	
	public static void main(String[] args) {
		
		boolean randomcolour = false;
		double x = UI.askDouble("Insert starting x coordinate:");
		double y = UI.askDouble("Insert starting y coordinate:");
		double size = UI.askDouble("Insert size of loli:");
		double length = UI.askDouble("Insert length of stick:");
		Lolipop line = new Lolipop();
		for(; x < 500; x+=size, size+=(size/3), length+=(size/3)) 
		line.lolidrawing(x, y, size, length, randomcolour);
	}

}
