package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class GUI {
	
	private Controller controller;
	
	//FXML attributes
	@FXML
	private TextField textField;
	
	@FXML
	private ListView<String> userList;
	
	
	public void setController(Controller controller) {
		this.controller = controller;
		//set list with initial items
		this.userList.setItems(this.controller.getUserList());
	}
	
	@FXML
	private void addUserHandler(ActionEvent ae) {
		// get user name from text field
		String user = this.textField.getText();
		// report event to controller
		this.controller.addUser(user);
		// update list display
		this.userList.setItems(this.controller.getUserList());
		System.out.println("User has been added");
		//clear text field
		this.textField.setText(null);
	}
	

}
