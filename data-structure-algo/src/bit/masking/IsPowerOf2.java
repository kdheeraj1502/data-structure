package bit.masking;

public class IsPowerOf2 {

	public static boolean isPower2(int n) {
		// 1. if power of 2 then
		// the number has only one set bit 
		// Its AND operation with (Number - 1) is becomes  0
		/// example
		//   16 : 10000
		//   15 : 01111
		//  Ans   00000
        if(((n != 0 && n < Integer.MAX_VALUE && n > Integer.MIN_VALUE) ? (n & (n - 1)) : 1) == 0)
            return true;
        return false;
		
		
	}
	
    public static boolean isPowerOfTwo(int n) {
        if(n == 1)
            return true;
        if(n%2 != 0 || n == 0)
            return false;
        if(isPowerOfTwo(n/2))
            return true;
        return false;
    }
    
	public static void main(String[] args) {
			System.out.println(33554432 + " is power of 2 " + isPower2(33554432));
			System.out.println(Integer.toBinaryString(33554432));
			
			System.out.println(isPowerOfTwo(98));
	}
}
