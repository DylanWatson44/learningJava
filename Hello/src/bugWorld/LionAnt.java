package bugWorld;

import javafx.scene.paint.Color;

public class LionAnt extends Bug {

	private static final float NORMAL_SPEED= 1f;
	private static final float MAX_SPEED= 14f;
	public LionAnt(int i, int j, int k) {
		super(i, j, k);
		setDx(-1f);
		setDy(-1f);
		setFill(Color.BLUEVIOLET);
	}

}
