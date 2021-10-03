package bit.masking;

public class CopySetBitInRange {

	// 1. problem statement = of range l and r what ever position the bit is set in
	// A ,
	// similarly make B bits set at same position
	// ------------------- steps--------------
	// 1. creat a mask of bits , having all 1 wihtin the range and then make AND
	// operation with A
	// 2. Make OR operation of B with above mask
	//
	// 1. 1 To create mask, start bits with all 0 and
	// then modify the bit value with 1 in the range using shift property
	public static int copySerBitInRange(int x, int y, int l, int r) {
		int mask = 0;
		// set (right - left + 1) bit
		mask = (1 << (r - l + 1));
		// set all element before (right - left + 1) to 1 but minus 1
		mask -= 1;
		// push mask twice from left is left is 3
		mask = (mask << (l - 1)); 
		mask &= y;
		x = x | mask;
		return x;
	}

	public static void main(String[] args) {
		int A = 10;
		int B = 13;
		int l = 2;
		int r = 3;
		System.out.println(copySerBitInRange(A, B, l, r));
	}
}
