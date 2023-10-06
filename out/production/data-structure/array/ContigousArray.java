package array;

import java.math.BigInteger;
import java.util.ArrayList;

public class ContigousArray {
   public static int contigousArray(int[] num) {
      int currMax = 0;
      int maxSum = 0;

      for(int i = 0; i < num.length; ++i) {
         currMax = Math.max(num[i], currMax + num[i]);
         if (currMax < 0) {
            currMax = 0;
         }

         if (currMax > maxSum) {
            maxSum = currMax;
         }
      }

      return maxSum;
   }

   static ArrayList<BigInteger> factorial(int N) {
      ArrayList<BigInteger> result = new ArrayList();
      result.add(factorial_1(BigInteger.valueOf((long)N)));
      return result;
   }

   static BigInteger factorial_1(BigInteger N) {
      return N.intValue() == 1 ? BigInteger.valueOf(1L) : N.multiply(factorial_1(N.subtract(BigInteger.valueOf(1L))));
   }

   public static void main(String[] args) {
      int[] num = new int[]{-1, -2, -3, -4};
      System.out.println(contigousArray(num));
      System.out.println(factorial(897).get(0));
   }
}
