package recursion;


/**
 * First call method then do the operation
 * 
 * @author dheerajkumar02
 *
 */
public class HeadRecursion {

	public static void head(int n) {
		if(n == 0) return;
		head(n - 1);
		System.out.println("The value of n is = " + n);
	}
	public static void main(String[] args) {
		head(5);
	}
}

