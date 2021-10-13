package string;

public class POW {

	public int pow(int x, int n) {
		int value;
		if (n == 0)
			return 1;
		else if (n % 2 == 0) {
			value = pow(x, n / 2);
			return value * value;
		} else {
			value = pow(x, n / 2);
			return x * value * value;
		}
	}

	public static void main(String[] args) {
		POW p = new POW();
		System.out.println(p.pow(5, 4));
	}
}
