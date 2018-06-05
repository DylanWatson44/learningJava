package pk;

import java.awt.Color;

import ecs100.UI;

public class RoundBalloon implements Balloon {
	private double rbx, rby;
	private double radius = 10;
	private Color col;

	public RoundBalloon(double startx, double starty) {
		rbx = startx;
		rby = starty;
		col = Color.getHSBColor((float) Math.random(), (float) 1, (float) 1);
	}

	public void expand() {
		this.radius += 10;
		this.rbx -= 5;
		this.rby -= 5;
		this.draw();
	}

	public boolean on(double x, double y) {
		return (x > rbx && x < rbx + radius * 2 && y > rby && y < rby + radius * 2);
	}

	public void draw() {
		UI.setColor(col);
		UI.fillOval(rbx, rby, radius, radius);
	}

}
