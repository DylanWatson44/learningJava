import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {

	int width = 400, height = 300;
	float x = 100, y = 100, dx = -1.5f, dy = -1.5f;

	@Override
	public void start(Stage primaryStage) throws Exception {
		final MyCircle circle = new MyCircle(100, 100, 30);
		final MyCircle circle2 = new MyCircle(200, 100, 10);
		final ArrayList<MyCircle> circlelist = new ArrayList<MyCircle>();
		circlelist.add(circle);
		circlelist.add(circle2);
		circle2.setFill(Color.RED);
		Group root = new Group(circle, circle2);
		final Scene scene = new Scene(root, width, height);
		KeyFrame frame = new KeyFrame(Duration.millis(16), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				for (MyCircle c : circlelist) {
					
					if (c.getCenterX() + c.getTranslateX() < c.getRadius()
							|| c.getCenterX() + c.getTranslateX() > scene.getWidth() - c.getRadius()) {
						c.setDx(-(c.getDx()));

					}

					if (c.getCenterY() + c.getTranslateY() < c.getRadius()
							|| c.getCenterY() + c.getTranslateY() > scene.getHeight() - c.getRadius()) {
						c.setDy(-(c.getDy()));

					}
					c.setTranslateX(c.getTranslateX() + c.getDx());
					c.setTranslateY(c.getTranslateY() + c.getDy());
				}
			}
		});
		TimelineBuilder.create().cycleCount(javafx.animation.Animation.INDEFINITE).keyFrames(frame).build().play();

		primaryStage.setTitle("Hello Animation");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();

	}

}
