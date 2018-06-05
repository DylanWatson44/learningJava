import ecs100.UI;

public class test1 {
/** first test of the lolidrawing method. Simply takes user input for the start point
 * and size of the loli and draws it once.
 * 
 */
	
	public static void main(String[] args) {
		
		boolean randomcolour = false;
		double x = UI.askDouble("Insert starting x coordinate:");
		double y = UI.askDouble("Insert starting y coordinate:");
		double size = UI.askDouble("Insert size of loli:");
		double length = UI.askDouble("Insert length of stick:");
		Lolipop wow = new Lolipop();
		wow.lolidrawing(x, y, size, length, randomcolour);
	}

}
