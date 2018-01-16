package lab1.ex2;

import java.util.ArrayList;

public class User {
	
	private Person name;
	private int userNb;
	private ArrayList<Media> borrowedMedias;
	
	public User(Person name, int userNb) {
		this.name = name;
		this.userNb = userNb;
		borrowedMedias = new ArrayList<>();
	}

	public void addBorrowedMedia(Media media) {
		borrowedMedias.add(media);
		
	}

	public int getNb() {
		
		return userNb;
	}

	public ArrayList<Media> getBorrowedMedias() {
		
		return borrowedMedias;
	}

	public Object getPerson() {
		
		return name;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof User)) {
			return false;
		}
		final User user = (User)obj;
		if(this.userNb == user.userNb && this.name.equals(user.name)) {
			return true;
		}
		else {
			return false;
		}
	}

}
