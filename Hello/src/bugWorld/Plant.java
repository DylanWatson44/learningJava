package bugWorld;


import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Plant extends Rectangle {
	
	public Plant(int width, int height) {
		super((int) (Math.random() * (BugWorld.windowWidth-30)), (int) (Math.random() * (BugWorld.windowHeight-30)), width, height);
		setFill(Color.GREENYELLOW);
	}
}
