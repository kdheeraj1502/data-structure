package bit.masking;

public class IsPowerOf2 {

	public static boolean isPower2(int n) {
		// 1. if power of 2 the only 1 set bit and AND operation with Number - 1 is 0
		return n != 0 && ((n & (n - 1)) == 0);
	}
	public static void main(String[] args) {
			System.out.println(33554432 + " is power of 2 " + isPower2(33554432));
			System.out.println(Integer.toBinaryString(33554432));
	}
}
