package recursion;


/**
 * First we do operation then call the method
 * 
 * @author dheerajkumar02
 *
 */
public class TailRecursion {

	public static void tail(int n) {
		if(n == 0) return;
		System.out.println("The value of n is = " + n);
		tail(n - 1);
	}
	public static void main(String[] args) {
		tail(5);
	}
}
