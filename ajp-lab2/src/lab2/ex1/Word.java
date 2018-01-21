package lab2.ex1;

import java.util.ArrayList;


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
			String colorName =theColor.name();
			s+= ", color = " + colorName;
			
			return s;
		
	}
}
