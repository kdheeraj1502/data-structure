package bit.masking;

public class SetBitCountFrom1ToN {
	
	public static int largestPowerOf2(int N) {
		int x = 0;
		// find nearest power 2 power
		// 1 << 0 is 1, 1 << 1 is 2 , 1 << 2 is 4, i << 3 is 8
		while((1 << x) <= N) { 
			x++;
		}
		return x - 1;
	}
	
	public static int setCount(int N) {
		if(N == 0) return 0;
		int x = largestPowerOf2(N);
		int bitUpTo2RaiseX = x * (1 << (x - 1)); // 3 * 2^2 = 12
		int setCountForRemaining = N - (1 << x) + 1;
		int remaing = N - (1 << x);
		int result = bitUpTo2RaiseX + setCountForRemaining + setCount(remaing);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(setCount(1000000000));
	}
}
