package lab1.ex1;

public class HelloWorld {

	String s = "Hello World !";
	
	public static void main(String[] args) {
		HelloWorld hw = new HelloWorld();
		System.out.println(hw);
		
	}
	@Override
	public String toString(){
		return s;
	}
}