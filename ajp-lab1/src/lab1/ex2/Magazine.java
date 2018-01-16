package lab1.ex2;

import java.util.Date;

public class Magazine extends Periodic {

	private String topic;
	private boolean specialIssue;
	
	public Magazine(String name, String topic, Periodicity periodicity, String edition, String date, int issueNb, boolean specialIssue) {
		
		super(name, periodicity, edition, date, issueNb);
		this.topic = topic;
		this.specialIssue = specialIssue;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Magazine)) {
			return false;
		}
		final Magazine mag = (Magazine)obj;
		if(this.getTitle() == mag.getTitle() &&
				this.topic == mag.topic &&
				this.getPeriodicity() == mag.getPeriodicity() &&
				this.getDate() == mag.getDate() &&
				this.getEdition() == mag.getEdition() &&
				this.getIssueNb() == mag.getIssueNb() &&
				this.specialIssue == mag.specialIssue ) {
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
