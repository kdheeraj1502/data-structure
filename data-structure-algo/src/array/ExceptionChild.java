package array;

import java.io.IOException;

public class ExceptionChild extends ExceptionParent {

	@Override
	public void display() {
			System.out.println("In child");
	}

	public static void main(String[] args)  {
		ExceptionParent ec = new ExceptionChild();
	//	ec.display();
	}
}

class ExceptionParent {

	public void display() throws IOException {
		System.out.println("In Parent");
	}
}