package model;

import java.util.ArrayList;
import java.util.List;

public class UserList extends java.util.Observable implements Model{

	private List<String> userList;
	
	public UserList() {
		this.userList = new ArrayList<>();
	}
	
	public boolean addUser(String user) {
		this.userList.add(user);
		this.notifyObservers();
		return true;
	}
	
	@Override
	public String[] getData() {
		return this.userList.toArray(new String[this.userList.size()]);
	}
}
