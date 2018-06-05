package linkedNodePk;

import javafx.animation.KeyFrame;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import linkedNodePk.LinkedNodes;
import linkedNodePk.Node;

public class LinkedNodeUI extends Application {
	private int width = 1000;
	private int height = 600;
	private int viewWidth = width / 10;
	private int viewHeight = height / 10;
	private int xOffset = 0;
	private int yOffset = 0;
	private int mouseXOffset = 0;
	private int mouseYOffset = 0;

	

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Display 100 x 60 Cells. Size 9 x 9 plus a border of 1.

		LinkedNodes grid = new LinkedNodes(width / 2, height / 2);
		for (int i = 0; i < 10; i++) {
			
			grid.addBottomRow(grid.findFarthestLeft(grid.findBottomNode(grid.getRoot())));
			grid.joinBottomRow(grid.findBottomNode(grid.findFarthestRight(grid.getRoot())));
			
			grid.addTopRow(grid.findFarthestLeft(grid.findTopNode(grid.getRoot())));
			grid.joinTopRow(grid.findTopNode(grid.findFarthestRight(grid.getRoot())));
			
			grid.addLeftRow(grid.findTopNode(grid.findFarthestLeft(grid.getRoot())));
			grid.joinLeftRow(grid.findFarthestLeft(grid.findBottomNode(grid.getRoot())));
			
			grid.addRightRow(grid.findTopNode(grid.findFarthestRight(grid.getRoot())));
			grid.joinRightRow(grid.findFarthestRight(grid.findBottomNode(grid.getRoot())));
			
		}

		Group root = new Group();
		for (Node n : grid.getNodelist()) {
			root.getChildren().add(n);
		}

		
		
		
		Scene scene = new Scene(root, width, height);

		KeyFrame frame = new KeyFrame(Duration.millis(100),new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
			
				for (Node n : grid.getNodelist()) {
					(n).setOnMousePressed(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							(n).setStatus(true);
						}
					});
				
			}
			}
		});
		 TimelineBuilder.create().cycleCount(javafx.animation.Animation.INDEFINITE)
		 .keyFrames(frame).build().play();

		primaryStage.setTitle("Animation");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
