package lab2.ex1;

public class ColoredWord extends Word{

	private Color color;
	
	public ColoredWord(String word, Color color) {
		super(word);
		this.color = color;
	}
	
	// inner class
		public enum Color{
			RED, GREEN, BLUE, YELLOW, PURPLE, TURQUOISE;
		}
	
		
		
	@Override
	public String toString(){
		String string = this.word +", color = " + this.color.name();
		return string;
	}
}
