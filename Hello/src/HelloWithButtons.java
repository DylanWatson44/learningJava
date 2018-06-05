
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWithButtons extends Application {

	int randomNumber = (int) (Math.random() * 99 + 1);

	@Override
	public void start(Stage primaryStage) throws Exception {

		final Text text = new Text("Lets play a guessing game");
		TextField numberAsk = new TextField();
		numberAsk.setText("Guess a number");

		Button btn = new Button();
		btn.setText("Generate a new Random Number");

		numberAsk.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String answer = numberAsk.getText();
				try {
					int intAnswer = Integer.parseInt(answer);
					if (intAnswer > randomNumber) {
						text.setText("You guessed too high, guess again.");
					} else if (intAnswer < randomNumber) {
						text.setText("You guessed too low, guess again.");
					} else
						text.setText("You guessed correctly!, Want to play again?");

				} catch (NumberFormatException e) {
					text.setText("Please provide an integer");
				}
			}
		});

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				randomNumber = (int) (Math.random() * 99 + 1);
			}

		});

		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(25, 25, 25, 25));
		pane.getChildren().add(text);
		pane.getChildren().add(btn);
		pane.getChildren().add(numberAsk);
		// Set title of the window
		primaryStage.setTitle("Hello World!");
		Scene scene = new Scene(pane, 300, 250);

		primaryStage.setScene(scene);
		// Add scene to the window (underneath the window bar)
		primaryStage.setScene(scene);

		// Change size of window to fit text
		primaryStage.sizeToScene();

		// Show the window
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
