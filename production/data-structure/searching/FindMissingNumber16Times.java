package searching;

public class FindMissingNumber16Times {
   public static int findMissingNumber2TImes(int[] num) {
      int max = Integer.MIN_VALUE;

      int expectedTotal;
      for(expectedTotal = 0; expectedTotal < num.length; ++expectedTotal) {
         if (max < num[expectedTotal]) {
            max = num[expectedTotal];
         }
      }

      expectedTotal = 2 * (max * (max + 1) / 2);
      int arrayTotal = 0;

      int result;
      for(result = 0; result < num.length; ++result) {
         arrayTotal += num[result];
      }

      result = Math.abs(expectedTotal - arrayTotal);
      return result;
   }
}
