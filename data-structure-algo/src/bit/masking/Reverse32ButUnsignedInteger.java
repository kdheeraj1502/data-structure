package bit.masking;

public class Reverse32ButUnsignedInteger {

	public  static long reverse(long n) {
		long reverse = n & 1;
	    int i = 1;
	    //only need 31 times
	    while (i < 32) {
	      n = n >> 1;
	      reverse = reverse << 1;
	      //plus the old tail
	      reverse += n & 1;
	      i++;
	    }
	    return reverse;
	}
	
	public static void main(String[] args) {
		System.out.println(reverse(6));
		
		int num = 6;
		int i = 1;
		int reverse = num & 1;
		while(i < 32) {
			num = num >> 1;
			reverse = reverse << 1;
			reverse = reverse + (num & 1);
			i++;
		}
		System.out.println(reverse);
	}
}
