package lab1.ex2;

import java.util.Date;

public class Cd implements Media{

	private String title;
	private String date;
	private Person artist;
	private String genre;
	private boolean isBorrowed;
	
	public Cd(String title, String genre, Person artist, String date) {
		this.title = title;
		this.date = date;
		this.artist = artist;
		this.genre  = genre;
		this.isBorrowed = false;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Cd)) {
			return false;
		}
		final Cd cd = (Cd)obj;
		if(this.title == cd.title &&
				this.date == cd.date &&
				this.artist.equals(cd.artist) &&
				this.genre == cd.genre ) {
					return true;
		}else return false;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDate() {
		return this.date;
	}
	public boolean isBorrowed() {
		return this.isBorrowed;
	}
	public void setIsBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
}
