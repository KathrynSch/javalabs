package lab2.ex1;


public class Word {

	static String s ="Myword";
	
//	@Override
//	public String toString(){
//		return s;
//	}
	
	private enum ColoredWord{
		red, green, blue, yellow, purple, turquoise;
	}
	
		@Override
		public String toString(){
			ColoredWord theColor = ColoredWord.red;
			s+= ", color = " + theColor.name();
			
			return s;
		
	}
}
