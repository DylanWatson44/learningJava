 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class HelloWorld extends Application{
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Create a scene for the window with the text inside it
        Scene scene = new Scene(new Group(new Text(100, 25, "Hello World!"))); 
        //Scene myscene = new Scene(new Group(new Text(28, 25, "My name is Dylan")));
        //Set title of the window
        primaryStage.setTitle("Hello World!");
         
        //Add scene to the window (underneath the window bar)
        primaryStage.setScene(scene);
      //  primaryStage.setScene(myscene); 
        //Change size of window to fit text
        primaryStage.sizeToScene();
         
        //Show the window
        primaryStage.show();
    }
 
 
    public static void main(String[] args) {
        Application.launch(args);
    }
}
