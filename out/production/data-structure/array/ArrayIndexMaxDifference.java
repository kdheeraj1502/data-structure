package array;

public class ArrayIndexMaxDifference {
   public static int arrayIndexMaxDiff(int[] num) {
      int maxDiff = -1;

      for(int i = 0; i < num.length; ++i) {
         for(int j = num.length - 1; j > i; --j) {
            if (num[j] > num[i]) {
               maxDiff = Math.max(maxDiff, j - i);
               break;
            }
         }
      }

      return maxDiff;
   }

   public static int arrayIndexMaxDiffSelf(int[] num) {
      int maxDiff = -1;

      for(int i = 0; i < num.length; ++i) {
         for(int j = num.length - 1; j > i && j >= 0; --j) {
            if (num[j] > num[i]) {
               maxDiff = Math.max(maxDiff, j - 1);
               break;
            }
         }
      }

      return maxDiff;
   }

   public static void main(String[] args) {
      int[] num = new int[]{33, 9, 10, 3, 2, 60, 30, 33, 1};
      System.out.println(arrayIndexMaxDiffSelf(num));
   }
}
