package lab1.ex2;

public class LibSystem {

	public static void main(String[] args){
		Library library = new Library(5);
		//instantiate medias
		Book book1 = new Book("The Great Gatsby", new Person("F. Scott", "Fitzgerald"), "1925", "Penguin", 300, "classic", 1234);
		Book book2 = new Book("Conquering the Impossible", new Person("Mike", "Horn"), "2002", "St Martin's Press", 368, "autobiography", 4321);
		Book book3 = new Book("Conquering the Impossible", new Person("Mike", "Horn"), "2002", "St Martin's Press", 368, "autobiography", 4321);
		Newspaper newspp = new Newspaper("The Economist","International", Periodicity.MONTHLY, "AnEdition", "2016/09/12", 3856);
		Magazine mag = new Magazine("Science&Vie", "Science", Periodicity.MONTHLY, "AnotherEdition", "2017/01/03", 1234, false);
		Cd cd = new Cd("Liquid Spirit", "jazz", new Person("Gregory","Porter"), "2013/02/09");
		Movie movie = new Movie("Julie&Julia", new Person("Nora","Ephron"), new Person("Laurence", "Mark"), "Comedy-drama", "2009/07/08");

		//add medias to library
		library.addMedia(book1);
		library.addMedia(book2);
		library.addMedia(book3);	// same book as book2 so adding not successful
		library.addMedia(newspp);
		library.addMedia(cd);
		library.addMedia(movie);
		
		// test all methods
		library.isMediaInLibrary(book2);
		library.searchByTitle("The Economist");	//returns newsp
		library.searchByDate("2017/01/03");	// returns mag
		library.searchByDate("2017/04/03");	// returns nothing
		library.removeMedia(book2);	
		library.removeMedia(book3);	// book3 hasn't been added to lib so removing not successful
		
		//instantiate users
		User user1 = new User(new Person("Kathryn", "Schutte"), 1);
		User user2 = new User(new Person("Lisa", "Grière"), 2);
		
		//add users
		library.addUser(user1);
		library.addUser(user2);
		
		//borrow medias
		library.borrowMedia(book1, user1.getNb());
		library.borrowMedia(book1, user2.getNb());	// book already borrowed
		library.bringBackMedia(book1, user1.getNb());
		library.bringBackMedia(book1, user2.getNb());	// book not borrowed by  user
		
		//search users
		library.searchUserByName(new Person("Kathryn","Schutte"));
		library.searchUserByName(new Person("Lisa","Schutte"));


	}
}
