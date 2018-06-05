package linkedNodePk;

import javafx.animation.KeyFrame;

import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class UI extends Application {
	private int width = 1000;
	private int height = 600;
	private int viewWidth = width / 10;
	private int viewHeight = height / 10;
	private int buttonWidth = 75;
	private int windowX;
	private int windowY;

	// UI settings
	private int speed = 10;
	private int count = 0;
	private boolean running = false;

	// Menu Stuff
	VBox MenuPane = new VBox();
	VBox container = new VBox();
	Button startButton = new Button();
	Button stopButton = new Button();
	Button newButton = new Button();
	Slider speedSlider = new Slider();
	Text speedLabel = new Text();

	// World world = new World(100, 100);

	// Test 2D array to be replaced later
	// private Cell[][] test2 = new Cell[viewWidth + 100][viewHeight + 60];
	// private Cell[][] test2 = world.getArray();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

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

		// Sets up buttons, sliders etc. Sent to outside method for simplicity.
		menuSetup();

		Group root = new Group();

		for (Node n : grid.getNodelist()) {
			root.getChildren().add(n);
		}
		Scene scene = new Scene(root, width, height, Color.AQUA);
		root.getChildren().add(container);

		// Set clicked cells to alive

		// scene.setOnMouseDragged(mouseHandler);
		// scene.setOnMouseClicked(mouseHandler);

		KeyFrame frame = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {

				if (running) {

					grid.checkNextGen(grid.getRoot());

					for (Node n : grid.getNodelist()) {
						n.updateCells();
					}
				}

				for (Node n : grid.getNodelist()) {
					(n).setOnMousePressed(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							
							(n).setStatus(true);
						}
					});
					// windowX = (test2.length / 2) - (viewWidth / 2);
					// windowY = (test2[0].length / 2) - (viewHeight / 2);

					// root.getChildren().retainAll(container);

					// for (int i = windowX, a=0; i < viewWidth + windowX; i++,
					// a++)
					// {
					// for (int j = windowY, b=0; j < viewHeight + windowY; j++,
					// b++)
					// {
					// if (test2[i][j].getStatus() == true)
					// {
					// Rectangle temp = new Rectangle ((a * 10) + 1, (b * 10) +
					// 1, 9, 9);
					// temp.setFill(Color.STEELBLUE);
					// root.getChildren().add(temp);
					// }
					//
					// else
					// {
					// Rectangle temp = new Rectangle ((a * 10) + 1, (b * 10) +
					// 1, 9, 9);
					// temp.setFill(Color.WHITE);
					// root.getChildren().add(temp);
					// }
					// }
					// }

				}
			}
		});

		TimelineBuilder.create().cycleCount(javafx.animation.Animation.INDEFINITE).keyFrames(frame).build().play();

		primaryStage.setWidth(1114);
		primaryStage.setTitle("Conways Game of Life");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void menuSetup() {
		// Button listeners
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Run program e.g. world1.startWorld()
				
				running = true;
				System.out.println("Start Pressed");
			}

		});

		stopButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Stop/pause program e.g. world1.stopWorld()
				running = false;
				System.out.println("Stop Pressed");
			}

		});

		newButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Reset program e.g. world1.reset()
				System.out.println("New Pressed");
			}

		});

		// Slider listener
		speedSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				speed = 20 - (int) speedSlider.getValue();
				// Alters speed of game e.g. world1.setSpeed(i)
				System.out.println("Speed Set To " + speed);
			}
		});

		// Slider value setup
		speedSlider.setValue(10);
		speedSlider.setMin(0);
		speedSlider.setMax(20);

//		 Outer VBox
		container.getChildren().add(MenuPane);
		//container.setPadding(new Insets(0, 0, 0, 1000));

		// Inner VBox
		MenuPane.setPrefSize(100, 600);
		MenuPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		MenuPane.setPadding(new Insets(10, 0, 0, 14));
		MenuPane.setSpacing(10);

		// Set labels/texts
		startButton.setText("Start");
		stopButton.setText("Stop");
		newButton.setText("New");
		speedLabel.setText("      Speed");

		// Add style details
		startButton.setStyle("-fx-font: 15 arial; -fx-base: #4178A5");
		stopButton.setStyle("-fx-font: 15 arial; -fx-base: #4178A5");
		newButton.setStyle("-fx-font: 15 arial; -fx-base: #4178A5");

		// Add dimension details
		startButton.setPrefWidth(buttonWidth);
		stopButton.setPrefWidth(buttonWidth);
		newButton.setPrefWidth(buttonWidth);
		speedSlider.setMaxWidth(buttonWidth);

		// Add as Children
		MenuPane.getChildren().add(startButton);
		MenuPane.getChildren().add(stopButton);
		MenuPane.getChildren().add(newButton);
		MenuPane.getChildren().add(speedLabel);
		MenuPane.getChildren().add(speedSlider);
	}
}