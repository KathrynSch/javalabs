package lab1.ex2;

import java.util.Date;

public class Book extends Publication{

	private Person author;
	private int nbPages;
	private String genre;
	private int isbnNb;

	public Book(String title, Person author, String date, String edition, int nbPages, String genre, int isbnNb){
		super(title, edition, date);
		this.author = author;
		this.nbPages = nbPages;
		this.genre = genre;
		this.isbnNb = isbnNb;
	}
	@Override 
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Book)) {
			return false;
		}
		final Book book = (Book)obj;
		if(super.getTitle() == book.getTitle() &&
				this.author.equals(book.author) &&
				this.getDate() == book.getDate() &&
				super.getEdition() == book.getEdition() &&
				this.nbPages == book.nbPages &&
				this.genre == book.genre &&
				this.isbnNb == book.isbnNb) {
					return true;
		}else return false;
	}
	
	public String getTitle() {
		String title = super.getTitle();
		return title;
	}
	
	public String getEdition() {
		return super.getEdition();
	}
	public String getDate() {
		return super.getDate();
	}
	
	
}