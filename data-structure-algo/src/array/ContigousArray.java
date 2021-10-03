package array;

import java.math.BigInteger;
import java.util.ArrayList;

public class ContigousArray {

	public static int contigousArray(int num[]) {
		int currMax = 0;
		int maxSum = 0;
		for (int i = 0; i < num.length; i++) {
			currMax = Math.max(num[i], currMax + num[i]);
			if (currMax < 0)
				currMax = 0;
			if (currMax > maxSum)
				maxSum = currMax;
		}
		return maxSum;
	}

    static ArrayList<BigInteger> factorial(int N){
        ArrayList<BigInteger> result = new ArrayList<>();
        result.add(factorial_1(BigInteger.valueOf(N)));
        return result;
    }
    
    static BigInteger factorial_1(BigInteger N){
        if(N.intValue() == 1) return BigInteger.valueOf(1);
        return N.multiply(factorial_1(N.subtract(BigInteger.valueOf(1))));
    }
    
	public static void main(String[] args) {
		// int num[] = { 4, 9, -7, -3, 2, -8, 9, -8 };
		// int num[] = { 1, 2, 3, -2, 5 };
		int num[] = { -1, -2, -3, -4 };
		System.out.println(contigousArray(num));
		System.out.println(factorial(897).get(0));
	}
}
