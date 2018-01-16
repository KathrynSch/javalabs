package lab1.ex2;

import java.util.Date;

public class Newspaper extends Periodic{
	
	private String type;

	public Newspaper(String name, String type, Periodicity periodicity, String edition, String date, int issueNb) {
		super(name, periodicity, edition, date, issueNb);
		this.type = type;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Newspaper)) {
			return false;
		}
		final Newspaper newspp = (Newspaper)obj;
		if(this.getTitle() == newspp.getTitle() &&
				this.type == newspp.type &&
				this.getPeriodicity() == newspp.getPeriodicity() &&
				this.getDate() == newspp.getDate() &&
				this.getEdition() == newspp.getEdition() &&
				this.getIssueNb() == newspp.getIssueNb() ) {
					return true;
		}else return false;
	}
	
	public String getTitle() {
		return super.getTitle();
	}
	public Periodicity getPeriodicity() {
		return super.getPeriodicity();
	}
	public String getDate() {
		return super.getDate();
	}
	public String getEdition() {
		return super.getEdition();
	}
	public int getIssueNb() {
		return super.getIssueNb();
	}
}
