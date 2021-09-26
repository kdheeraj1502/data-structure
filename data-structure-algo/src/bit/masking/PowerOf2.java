package bit.masking;

public class PowerOf2 {

	static void PowerOfTwo(long N) {
		for (int i = 0; i < 64; i++) {
			long x = 1;
			if ((N & (x << i)) > 0)
				System.out.print(i + " ");
		}
	}

	// Driver Code
	public static void main(String[] args) {
		long n = 12345;
		
		int digit = 0;
		while(n > 0) {
			n = n/2;
			digit++;
		}
		System.out.println(digit);
		
		n = 12345;
		for(int i = 0; i <= 14; i++) {
			//System.out.println(Integer.toBinaryString(1 << i));
		//	System.out.println(n & (1 << i));
			if((n & (1 << i)) > 0){
				System.out.print(i + " ");
				System.out.println((n & (1 << i)));
			}
		}
		
		///PowerOfTwo(n);
	}
}
