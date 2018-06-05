package bugWorld;

import javafx.scene.paint.Color;

public class Beetle extends Bug {
	
	private static final float NORMAL_SPEED= 2f;
	private static final float MAX_SPEED= 14f;
	
	public Beetle(int i, int j, int k) {
		super(i, j, k*2);
		setDx(-2f);
		setDy(-2f);
		setFill(Color.CHOCOLATE);
	}
	public Beetle(){
		super((int)(Math.random()*200)+30,(int)(Math.random()*200)+30,20);
		setFill(Color.CHOCOLATE);
	}

}
