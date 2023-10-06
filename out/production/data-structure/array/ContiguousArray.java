package array;

public class ContiguousArray {
   public static int maxConSub(int[] num) {
      int currMax = 0;
      int max = 0;

      for(int i = 0; i < num.length; ++i) {
         currMax = Math.max(currMax, currMax + num[i]);
         if (currMax < 0) {
            currMax = 0;
         }

         if (currMax > max) {
            max = currMax;
         }
      }

      return max;
   }

   public static void main(String[] args) {
      int[] num = new int[]{7, 6, -1, -3, -4, 8, -3, 9, -1, 0};
      System.out.println(maxConSub(num));
   }
}
