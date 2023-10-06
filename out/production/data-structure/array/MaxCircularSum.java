package array;

public class MaxCircularSum {
   public static int maxCircularSum(int[] num) {
      int sumAll = 0;
      int currVal = 0;

      int i;
      for(i = 0; i < num.length; ++i) {
         sumAll += num[i];
         currVal += i * num[i];
      }

      int maxVal = currVal;

      for(i = 1; i < num.length; ++i) {
         currVal = currVal + sumAll - num.length * num[num.length - 1];
         if (currVal > maxVal) {
            maxVal = currVal;
         }
      }

      return maxVal;
   }

   public static void main(String[] args) {
      int[] num = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
      System.out.println("Max Circular Sum : " + maxCircularSum(num));
   }
}
