package bit.masking;

public class PalindromicBinaryRepresentation {

	public static int findNumberBinaryPalindrom(int A) {
		int count = 1;
		int len = 1;
		int eleForThisLen;
		while (count < A) {
			len++;
			eleForThisLen = (1 << ((len - 1) / 2));
			count += eleForThisLen;
		}
		
		count = count - (1 << ((len - 1) / 2));
		int offSet = A - count - 1;
		int result = (1 << len - 1);
		result |= (offSet << len/2);
		int valForRev = (result >> len/2);
		int rev = getRev(valForRev);
		result |= rev;
		return result;
	}
	
	private static int getRev(int n) {
		int rev = 0;
		while(n > 0) {
			int lb = n & 1;
			rev |= lb;
			rev <<= 1;
			n >>= 1;
		}
		rev >>= 1;
		return rev;
	}

	public static void main(String[] args) {
		System.out.println(findNumberBinaryPalindrom(1));
	}
}
