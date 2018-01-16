package lab1.ex2;

public class Person {

	private String firstName;
	private String lastName;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Person)) {
			return false;
		}
		final Person person = (Person)obj;
		if(this.firstName == person.firstName && this.lastName == person.lastName) {
			return true;
		}
		else {
			return false;
		}
	}
}
