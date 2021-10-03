package bit.masking;

public class Divide2Integer {

	public static int divide(int dividend, int divisor) {
		boolean sign = (((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0))) ? false : true;
		if ((dividend > Integer.MAX_VALUE || dividend < Integer.MIN_VALUE)
				|| (divisor > Integer.MAX_VALUE || divisor < Integer.MIN_VALUE)) {
			if (sign) {
				return -Integer.MAX_VALUE;
			} else {
				return Integer.MAX_VALUE;
			}
		}
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int res = 0;
		while ((dividend - divisor) >= 0) {
			int count = 0;
			while ((dividend - (divisor << 1 << count)) >= 0) {
				count++;
			}
			res += (1 << count);
			dividend -= (divisor << count);
		}
		return sign == true ? -res : res;

	}

	public static void main(String[] args) {
		int a = -2147483648, b = -1;
		System.out.println(divide(a, b));
	}
}
