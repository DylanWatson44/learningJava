package bugWorld;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BugWorld extends Application {

	// fields.
	static int windowWidth = 500;
	static int windowHeight = 300;
	ArrayList<Bug> buglist = new ArrayList<Bug>();
	ArrayList<Node> shapelist = new ArrayList<Node>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		final Bug Beetle1 = new Beetle(100, 100, 15);
		final Bug lionant1 = new LionAnt(200, 100, 15);
		final Bug lionant2 = new LionAnt(20, 100, 15);
		final Bug lionant3 = new LionAnt(200, 20, 15);

		buglist.add(Beetle1);
		buglist.add(lionant1);
		buglist.add(lionant2);
		buglist.add(lionant3);

		playerBug player = new playerBug(5, 150, 30);
		player.setFill(Color.LIGHTCORAL);

		Button btn = new Button();
		btn.setText("Reset Player");
		btn.setAlignment(Pos.TOP_LEFT);

		ArrayList<Plant> plantlist = new ArrayList<Plant>();
		Plant plant1 = new Plant(50, 50);
		Plant plant2 = new Plant(50, 50);
		
		plantlist.add(plant1);
		plantlist.add(plant2);

		shapelist.addAll(buglist);
		shapelist.addAll(plantlist);
		Group root = new Group(Beetle1, lionant1, lionant2, lionant3, plant1, plant2, player);
		final Scene scene = new Scene(root, windowWidth, windowHeight);

		KeyFrame frame = new KeyFrame(Duration.millis(25), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				// if there is no plants, generate a new one
				if (plantlist.isEmpty()) {
					Plant p = new Plant(50, 50);
					Plant d = new Plant(50, 50);
					plantlist.add(p);
					plantlist.add(d);
					root.getChildren().add(p);
					root.getChildren().add(d);
				}

				// if there is no bugs alive, generate a new beetle
				if (allBugsDead()) {
					Bug newBeetle = new Beetle();
					Bug newBeetle2 = new Beetle();
					root.getChildren().add(newBeetle);
					root.getChildren().add(newBeetle2);
					buglist.add(newBeetle);
					buglist.add(newBeetle2);
				}
				// actions for each bug
				for (int i = 0; i < buglist.size(); i++) {
					buglist.get(i).setColliding(false);
					// collisions for each other bug
					for (int j = i + 1; j < buglist.size(); j++) {

						Bug.checkCollision(buglist.get(i), buglist.get(j));

						if (buglist.get(i).isColliding()) {
							//the bug farthest to the left will go left
							if (buglist.get(i).getCenterX() < buglist.get(j).getCenterX()) {
								Bug.moveLeft(buglist.get(i));
								Bug.moveRight(buglist.get(j));
							} else {
								Bug.moveRight(buglist.get(i));
								Bug.moveLeft(buglist.get(j));
							}
							//the bug highest on the screen will go up
							if (buglist.get(i).getCenterY() < buglist.get(j).getCenterY()) {
								Bug.moveUp(buglist.get(i));
								Bug.moveDown(buglist.get(j));
							} else {
								Bug.moveDown(buglist.get(i));
								Bug.moveUp(buglist.get(j));
							}
						}
					}
					// Collision with plants
					if (!plantlist.isEmpty()) {
						for (int p = 0; p < plantlist.size(); p++) {
							if (buglist.get(i).checkCollision(buglist.get(i), plantlist.get(p))
									&& plantlist.get(p).getScaleX() > 0.1) {
								buglist.get(i).setDx(-buglist.get(i).getDx());
								buglist.get(i).setDy(-buglist.get(i).getDy());
								plantlist.get(p).setScaleX(plantlist.get(p).getScaleX() - 0.2);
								plantlist.get(p).setScaleY(plantlist.get(p).getScaleY() - 0.2);
								buglist.get(i).eatPlant();
							}
							if (plantlist.get(p).getScaleX() <= 0.1) {
								plantlist.remove(plantlist.get(p));
							}
						}
					}

					// collision with a player. if true, we add the players
					// speed to bugs speed.
					if (buglist.get(i).checkPlayerCollision(buglist.get(i), player)) {
						if (Math.abs(buglist.get(i).getDx() + player.getDx()) < buglist.get(i).getMaxSpeed()) {
							buglist.get(i).setDx(buglist.get(i).getDx() + player.getDx());
							// we also give it one more point of speed to keep
							// it ahead of the player
							if (buglist.get(i).getDx() > 0)
								buglist.get(i).setDx(buglist.get(i).getDx() + 1);
							else
								buglist.get(i).setDx(buglist.get(i).getDx() - 1);
						}
						if (Math.abs(buglist.get(i).getDy() + player.getDy()) < buglist.get(i).getMaxSpeed()) {
							buglist.get(i).setDy(buglist.get(i).getDy() + player.getDy());
							if (buglist.get(i).getDy() > 0)
								buglist.get(i).setDy(buglist.get(i).getDy() + 1);
							else
								buglist.get(i).setDy(buglist.get(i).getDy() - 1);
						}
						// if the bug is not colliding with the player, reset
						// its speed
					} else {
						buglist.get(i).setNormalSpeed();
					}

					// collision with left wall
					if (buglist.get(i).getCenterX() + buglist.get(i).getTranslateX() < buglist.get(i).getRadius()) {
						buglist.get(i).setDx(Math.abs((buglist.get(i).getDx())));
					}
					// collision with right wall
					if (buglist.get(i).getCenterX() + buglist.get(i).getTranslateX() > scene.getWidth()
							- buglist.get(i).getRadius()) {
						buglist.get(i).setDx(-(Math.abs((buglist.get(i).getDx()))));
					}
					// collision with top wall
					if (buglist.get(i).getCenterY() + buglist.get(i).getTranslateY() < buglist.get(i).getRadius()) {
						buglist.get(i).setDy(Math.abs((buglist.get(i).getDy())));
					}
					// collision with bottom wall
					if (buglist.get(i).getCenterY() + buglist.get(i).getTranslateY() > scene.getHeight()
							- buglist.get(i).getRadius()) {
						buglist.get(i).setDy(-(Math.abs((buglist.get(i).getDy()))));
					}

					// creating erratic movements. Roll the dice!
					double diceroll = Math.random() * 50 + 1;

					// most of the time it continues in its current direction
					if (diceroll < 48) {
						buglist.get(i).setTranslateX(buglist.get(i).getTranslateX() + buglist.get(i).getDx());
						buglist.get(i).setTranslateY(buglist.get(i).getTranslateY() + buglist.get(i).getDy());
					}
					// but sometimes it changes its dx
					else if (diceroll == 49) {
						buglist.get(i).setDx(-(buglist.get(i).getDx()));
					}
					// or sometimes it changes its dy
					else {
						buglist.get(i).setDy(-(buglist.get(i).getDy()));
					}

					// we decrease the bugs energy level for every cycle
					buglist.get(i).expendEnergy();
				}
				
				// move the player
				player.setTranslateX(player.getTranslateX() + player.getDx());
				player.setTranslateY(player.getTranslateY() + player.getDy());

				// event handler for pressing bugs
				for (Bug b : buglist) {
					(b).setOnMousePressed(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							(b).killBug();
						}
					});
				}
			}
		});
		TimelineBuilder.create().cycleCount(javafx.animation.Animation.INDEFINITE).keyFrames(frame).build().play();

		primaryStage.setTitle("Bug Herder");
		primaryStage.setScene(scene);
		player.requestFocus();
		primaryStage.show();
		
		player.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			// event handler for controlling the player
			@Override
			public void handle(KeyEvent event) {
				
				if (event.getCode() == KeyCode.RIGHT) {
					player.moveRight();
				}
				if (event.getCode() == KeyCode.LEFT) {
					player.moveLeft();
				}
				if (event.getCode() == KeyCode.UP) {
					player.moveUp();
				}
				if (event.getCode() == KeyCode.DOWN) {
					player.moveDown();
				}
				if (event.getCode() == KeyCode.SPACE) {
					if ((Math.abs(player.getDx() * 3) < player.getMaxSpeed())) {
						player.setDx(player.getDx() * 3);
					}
					if ((Math.abs(player.getDy() * 3) < player.getMaxSpeed())) {
						player.setDy(player.getDy() * 3);
					}
				}
			}

		});
		// resets the speed when space is released
		player.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.SPACE) {
					player.setDx(player.getDx() / 3);
					player.setDy(player.getDy() / 3);
				}

			}

		});
		
		btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				player.setCenterX(windowWidth / 2);
				player.setCenterY(windowHeight / 2);
			}
		});
	}

	/*
	 * Method to check and remove dead bugs from the bug list. if the list is
	 * empty it returns true
	 */
	public boolean allBugsDead() {
		for (int i = 0; i < buglist.size(); i++) {
			if (!buglist.get(i).checkAlive()) {
				buglist.remove(buglist.get(i));
			}
		}
		if (buglist.isEmpty()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		launch();

	}

}
