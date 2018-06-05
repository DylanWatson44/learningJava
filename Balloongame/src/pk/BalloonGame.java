package pk;

import java.awt.Color;

import ecs100.*;

public class BalloonGame {
	private int MaxBalloons = 10;
	private Balloon[] balloonmap = new Balloon[MaxBalloons];

	public BalloonGame() {
		UI.setMouseListener(this::doMouse);
		UI.addButton("Start Game", this::NewGame);
		this.NewGame();

	}

	public void doMouse(String action, double x, double y) {
		if (action.equals("pressed")) {
			for (Balloon b : balloonmap) {
				if (b.on(x, y)) {
					b.expand();

				}
			}
		}
	}

	public void NewGame() {
		UI.clearGraphics();
		for (int n = 0; n < MaxBalloons - 1; n++) {
			double x = 30 + Math.random() * 600;
			double y = 30 + Math.random() * 400;
			RoundBalloon b = new RoundBalloon(x, y);
			b.draw();
			balloonmap[n] = b;
		}
		LongBalloon balloon1 = new LongBalloon(30 + Math.random() * 600, 30 + Math.random() * 400);
		balloonmap[MaxBalloons - 1] = balloon1;
		balloon1.draw();
	}

	// public void doMouse(){
	// if (a.equals("released")){
	// for(RoundBalloon b : balloonmap){
	//
	// }
	// }
	// }

	public static void main(String[] args) {
		BalloonGame bg = new BalloonGame();

	}

}
