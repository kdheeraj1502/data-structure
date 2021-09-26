package bit.masking;

public class Divide2Integers {

	public static int divide(int dividend, int divisor) {
		if (dividend == 1 << 31 && divisor == -1)
			return Integer.MAX_VALUE;

		boolean sign = ((dividend >= 0) == (divisor >= 0) ? true : false);

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		int q = 0;
		while (dividend - divisor >= 0) {
			int count = 0;
			while (dividend - (divisor << 1 << count) >= 0) {
				count++;
			}
			q += 1 << count;
			dividend -= divisor << count;
		}
		return sign ? q : -q;
	}

	public static int divide_self(int dividend, int divisor) {
		if (dividend == 1 << 31 && divisor == -1)
			return Integer.MAX_VALUE;
		boolean sign = ((dividend >= 0) == (divisor >= 0) ? true : false);
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int q = 0;
		while ((dividend - divisor) >= 0) {
			int count = 0;
			while ((dividend - (divisor << 1 << count)) >= 0) {
				count++;
			}
			q += 1 << count;
			dividend -= divisor << count;
		}
		return sign ? q : -q;
	}

	public static void main(String[] args) {
		System.out.println("output :: " + divide_self(-9, 3));
	}
}
