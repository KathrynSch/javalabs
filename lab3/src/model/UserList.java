package model;

import java.util.ArrayList;
import java.util.List;

public class UserList implements Model{

	private List<String> userList;
	
	public UserList() {
		this.userList = new ArrayList<>();
	}
	
	public boolean addUser(String user) {
		this.userList.add(user);
		return true;
	}
	
	@Override
	public String[] getData() {
		return this.userList.toArray(new String[this.userList.size()]);
	}
}
