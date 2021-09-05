package recursion;

public class Fibonacci {
	
	private static int fibonacci(int num){
		if(num <= 1) return num;
		return fibonacci(num - 1) + fibonacci(num - 2);
	}

	public static void main(String[] args) {
		int n = 7;
		System.out.println(fibonacci(n));
	}
}

//0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
