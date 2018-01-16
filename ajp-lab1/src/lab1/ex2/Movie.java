package lab1.ex2;

import java.util.Date;

public class Movie implements Media {

	private String title;
	private String date;
	private Person director;
	private Person producer;
	private String genre;
	private boolean isBorrowed;

	public Movie(String title, Person director, Person producer, String genre, String date) {
		this.title = title;
		this.date = date;
		this.director = director;
		this.producer = producer;
		this.genre = genre;
		this.isBorrowed = false;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Movie)) {
			return false;
		}
		final Movie movie = (Movie)obj;
		if(this.title == movie.title &&
				this.date == movie.date &&
				this.director.equals(movie.director) &&
				this.producer.equals(movie.producer) &&
				this.genre == movie.genre ) {
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
