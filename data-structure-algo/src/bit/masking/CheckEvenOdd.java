package bit.masking;

public class CheckEvenOdd {

	public static String isEven(int num) {
		return (num & 1) == 1 ? "odd" : "even";
	}

	public static void main(String[] args) {
		int num[] = { 3, 6, 2, 43, 856, 78, 2, 357, 34, 23, 991, 13467 };
		for (int in : num)
			System.out.println("Num " + in + " is " + (isEven(in)));
	}
}
