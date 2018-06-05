package pk;

import java.awt.Color;

import ecs100.UI;

public class LongBalloon implements Balloon {
	private double lbx, lby;
	private int radius = 20;
	private int length = 40;
	// private double middlex = x + radius;
	// private double middley = y + radius;
	private double direction = 1.26;
	private Color col, tubeCol;

	public LongBalloon(double startx, double starty) {
		lbx = startx;
		lby = starty;
		col = Color.getHSBColor((float) (Math.random() * 1), (float) 1, (float) 1);
	}

	public void expand() {
		this.length += 20;
		this.radius += 10;
		this.lbx -= 10;
		this.lby -= 5;
		this.draw();
	}

	public void draw() {
		UI.setColor(col);
		UI.fillOval(lbx, lby, length, radius);

	}

	public boolean on(double x, double y) {
		return (x > lbx && x < lbx + radius * 2 && y > lby && y < lby + radius);

	}

}
