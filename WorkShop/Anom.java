package map;

import java.util.Comparator;

public class Anom {

	public int annonimousClassMethod(int a, int b) {
		Comparator<Integer> iAmComparator1 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};

		Comparator<Integer> iAmComparator2 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};
		Comparator<Integer> iAmComparator3 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};
		Comparator<Integer> iAmComparator4 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};
		Comparator<Integer> iAmComparator5 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};
		iAmComparator1.compare(a, b);
		iAmComparator2.compare(a, b);
		iAmComparator3.compare(a, b);
		iAmComparator4.compare(a, b);
		return iAmComparator5.compare(a, b);
	}

	/*
	 * public int annonimousClassInLambdaExpression(int a, int b) {
	 * Comparator<Integer> iAmComparator = (o1, o2) -> o2 - o1; return
	 * iAmComparator.compare(a, b); }
	 */
	public void lambdaExpressionMethod(String name) {
		Runnable run = () -> System.out.println("hey i am in run " + name);
		Thread thread = new Thread(run);
		thread.start();
	}

	public static void main(String[] args) {
		Anom anom = new Anom();
		System.out.println(anom.annonimousClassMethod(8, 10));
	//	System.out.println(anom.annonimousClassInLambdaExpression(8, 10));
		anom.lambdaExpressionMethod("Dheeraj");
	}
}
