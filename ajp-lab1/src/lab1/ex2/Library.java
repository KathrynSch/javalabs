package lab1.ex2;

import java.util.ArrayList;
public class Library {

	private ArrayList<Media> medias;
	private ArrayList<User> users;
	private int maxNbMedias;
	
	public Library (int max) {
			this.maxNbMedias = max;
			this.medias = new ArrayList<>();
			this.users = new ArrayList<>();
	}
		
	public boolean addMedia(Media media){
			//check if book already in library
			if(isMediaInLibrary(media)){
				System.out.println("Media not added");
				return false;
			}
			else{		
				//check before adding a book if you have reach max nb books
				if(medias.size()< maxNbMedias) {
					this.medias.add(media);
					System.out.println("Media added");
					return true;
				}
				else {
					System.out.println("Could not add media in library");
					return false;
				}
			}
			
	}
		
	public boolean isMediaInLibrary(Media media){
			for (int i = 0; i<medias.size();i++) {
				if (medias.get(i).equals(media)) {
					System.out.println("Media in library");
					return true;
				}
			}
			System.out.println("Media not in library");
			return false;
				
	}
	
	public Media removeMedia(Media mediaToRemove) {
		
		//check if media in library
		for (int i = 0; i<medias.size();i++) {
			if (medias.get(i).equals(mediaToRemove)) {
				medias.remove(i);
				System.out.println("Media removed");
				return mediaToRemove;
			}
		}
		System.out.println("Media not in library");
		return null;
	}
	
	public ArrayList<Media> searchByTitle(String title){
		
		ArrayList<Media> resultMedias = new ArrayList<>();
		//go through all medias
		for(int i=0; i<medias.size(); i++) {
			//check if titles are the same
			if (medias.get(i).getTitle() == title) {
				//add to research result
				resultMedias.add(medias.get(i));
			}
		}
		if (resultMedias.isEmpty()) {
			System.out.println("No match found");
			return null;
		}else {
			System.out.println("Match found");
			return resultMedias;
		}
		
	}
	
	public ArrayList<Media> searchByDate(String date){
		
		ArrayList<Media> resultMedias = new ArrayList<>();
		//go through all medias
		for(int i=0; i<medias.size(); i++) {
			//check if dates are the same
			if (medias.get(i).getDate().equals(date)) {
				//add to research result
				resultMedias.add(medias.get(i));
			}
		}
		if (resultMedias.isEmpty()) {
			System.out.println("No match found");
			return null;
		}else {
			System.out.println("Match found");
			return resultMedias;
		}
	}
	
	public boolean addUser(User user) {
		//check if user not already in lib system
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).equals(user)) {
				System.out.println("User already registered");
				return false;
			}
		}
		users.add(user);
		System.out.println("User successfully registered");
		return true;
	}
	
	public boolean borrowMedia(Media media, int userNb) {
		//check is user exists
		for (int j=0; j<users.size(); j++) {
			if (users.get(j).getNb() == userNb) {
				//check if media in library
				for(int i=0; i<medias.size(); i++) {
					if(medias.get(i).equals(media)) {
						//check if media not already borrowed
						if(medias.get(i).isBorrowed()) {
							System.out.println("Cannot borrow. Media not available");
							return false;
						}
						else {
							//set status to borrowed
							medias.get(i).setIsBorrowed(true);
							//add media to list of borrowed media of user
							users.get(j).addBorrowedMedia(media);
							System.out.println("Media successfully borrowed");
							return true;
						}
					}
				}
				System.out.println("Media not in library");
				return false;
			}
		}
		System.out.println("User does not exist");
		return false;
	}
	
	public boolean bringBackMedia(Media media, int userNb) {
		//check if user exists
		for (int j=0; j<users.size(); j++) {
			if (users.get(j).getNb() == userNb) {
				//check if book in user list
				for(int i=0; i<users.get(j).getBorrowedMedias().size(); i++) {
					if(users.get(j).getBorrowedMedias().get(i).equals(media)) {
						//change status of media
						users.get(j).getBorrowedMedias().get(i).setIsBorrowed(false);
						//remove book from user list
						users.get(j).getBorrowedMedias().remove(i);
						System.out.println("Media brought back");
						return true;
					}
				}
				System.out.println("Media not in user list");
				return false;
			}
		}
		System.out.println("User does not exist");
		return false;
	}

	public ArrayList<User> searchUserByName(Person name) {
		ArrayList<User> resultUsers = new ArrayList<>();
		//go through user list 
		for (int i=0; i<users.size(); i++) {
			if(users.get(i).getPerson().equals(name)) {
				// if names are the same, add to result list of users
				resultUsers.add(users.get(i));
			}
		}
		if (resultUsers.isEmpty()) {
			System.out.println("No matching user");
			return null;
		}else {
			System.out.println("Matching users found");
			return resultUsers;
		}
	}
}
