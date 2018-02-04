package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.UserList;
import view.GUI;

public class Controller extends Application {
	
	// private attributes
	private Stage primaryStage;
	private BorderPane layout;
	
	private UserList userList;
	private GUI view;

	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("User list app");
		//init layout
		try {
			//load layout from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Controller.class.getResource("/view/UserOverview.fxml"));
			this.layout = (BorderPane) loader.load();
			//set scene to stage
			Scene scene = new Scene(layout);
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
			
			//create model
			this.userList = new UserList();
			
			//give the view access to the controller
			view = loader.getController();
			view.setController(this);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage() {
		return this.primaryStage;
	}
	
	public ObservableList<String> getUserList() {
		return this.userList.getData();
	}
	
	public void addUser(String user) {
		this.userList.addUser(user);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
