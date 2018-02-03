package application;
	
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			final URL url = getClass().getResource("exo1.fxml");
			final FXMLLoader fxmlLoader = new FXMLLoader(url);
			final AnchorPane root = fxmlLoader.load();
			
			//Group root = new Group();
			
			//set text area
			TextArea text = new TextArea();
			text.setText("Hello World");
			root.getChildren().add(text);
			//set button
			Button btn = new Button();
			btn.setText("Display text in console");
			root.getChildren().add(btn);
			//set scene
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
