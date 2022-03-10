package java8;

public class Main {

	public static void main(String[] args) {
		FunctionalInterfaceChildOne fip = () -> {
			System.out.println("Hi there");
		};
		
		fip.method();
	}
}
