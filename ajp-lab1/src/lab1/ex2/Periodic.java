package lab1.ex2;

public abstract class Periodic extends Publication{
	
	private Periodicity periodicity;
	private int issueNb;
	
	public Periodic(String name, Periodicity periodicity, String edition, String date, int issueNb) {
		super(name, edition, date);
		this.periodicity = periodicity;
		this.issueNb = issueNb;
	}
	
	public String getTitle() {
		return super.getTitle();
	}
	protected Periodicity getPeriodicity() {
		return this.getPeriodicity();
	}
	public String getDate() {
		return super.getDate();
	}
	protected String getEdition() {
		return super.getEdition();
	}
	protected int getIssueNb() {
		return this.getIssueNb();
	}
}
