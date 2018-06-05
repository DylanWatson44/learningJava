package buses;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Output extends Application {
	
	private int width = 1000;
	private int height = 600;
	
	private String outputString="";
	VBox container = new VBox();
	Text output = new Text();
	
	
	public static void main(String[] args) {
		
		
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		NewBusHandler handle = new NewBusHandler();
		
		outputString =handle.calcDisrupts();
		handle.findRoutesActive("Yes");
		handle.updateDisruptions();
		handle.findRouteHistory("");
		handle.top10MostAffected();
		handle.top10LeastAffected();
		handle.routesAffectedTimeFrame(5);
		
		Group root = new Group();
		Scene scene = new Scene(root, width, height, Color.AQUA);
		root.getChildren().add(container);
		
		
		
		output.setText(outputString);
		
		container.getChildren().add(output);
		//System.out.println("sds");
		
		primaryStage.setWidth(1114);
		primaryStage.setTitle("Bus Emergency Route Planner");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
