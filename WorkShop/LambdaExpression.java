package map;

import java.util.Comparator;

public class LambdaExpression {

	public CustomInterface lambdaExpressionMethod(String name, int a, int b) {
		Runnable run = () -> {
			System.out.println("hey i am in run " + name);
			Comparator<Integer> iAmComparator1 = new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {

					return o2 - o1;
				}
			};
			System.out.println(iAmComparator1.compare(a, b));
		};
		Thread thread = new Thread(run);
		thread.start();
		
		CustomInterface cum = new CustomInterface() {
			@Override
			public void display() {
				System.out.println("I am in Custom Display " + name);		
			}
		};
		return cum;
	}

	public static void main(String[] args) {
		LambdaExpression le = new LambdaExpression();
		CustomInterface cum = le.lambdaExpressionMethod("Dheeraj", 16, 90);
		cum.display();
	}
}

interface CustomInterface {
	
	void display();
}
