package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserList {
	
	//using the interface ObservableList to implement the data structure of the user list
	private ObservableList<String> userList;
	
	public UserList() {
		this.userList = FXCollections.observableArrayList();
		//adding users to the list
		this.addUser("Kathryn");
		this.addUser("Lisa");
	}
	
	public boolean addUser(String user) {
		this.userList.add(user);
		return true;
	}
	
	public ObservableList<String> getData() {
		return this.userList;
	}
}
