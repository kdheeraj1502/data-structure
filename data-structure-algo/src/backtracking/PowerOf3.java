package backtracking;

public class PowerOf3 {

    public static boolean isPowerOfThree(int n) {
        while(n > 0 && n % 3 == 0){
            n = n/3;
        }
        return n == 1 ? true : false;
    }
    
    public static boolean isPowerOfFour(int n) {
        while(n > 0 && n % 4 == 0){
            n = n/ 4;
        }
        return n == 1 ? true : false;
    }
    
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(27));
		System.out.println(isPowerOfFour(64));
	}
}
