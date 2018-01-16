package lab1.ex2;


public abstract class Publication implements Media{

	private String edition;
	private String title;
	private String date;
	private boolean isBorrowed;
	
	public Publication(String title, String edition, String date) {
		this.title = title;
		this.date = date;
		this.edition = edition;
		this.isBorrowed = false;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	protected String getEdition() {
		return this.edition;
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
