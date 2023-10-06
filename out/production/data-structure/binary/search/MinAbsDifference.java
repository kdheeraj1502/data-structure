package binary.search;

public class MinAbsDifference {
   public static int minDiff(int[] num) {
      int diff = Integer.MAX_VALUE;

      for(int i = 0; i < num.length; ++i) {
         diff = Math.min(diff, Math.abs(num[i] - num[(i + 1) % num.length]));
      }

      return diff;
   }

   public static void main(String[] args) {
      int[] num = new int[]{74, 76, 90, 8, 11, 15, 25, 34, 57};
      System.out.println(minDiff(num));
   }
}
