package array;

public class MaxDIstanceGeek {
   public static int maxIndexDiff(int[] arr, int n) {
      int[] RMax = new int[n];
      int[] LMin = new int[n];
      LMin[0] = arr[0];

      int i;
      for(i = 1; i < n; ++i) {
         LMin[i] = Math.min(arr[i], LMin[i - 1]);
      }

      RMax[n - 1] = arr[n - 1];

      int j;
      for(j = n - 2; j >= 0; --j) {
         RMax[j] = Math.max(arr[j], RMax[j + 1]);
      }

      i = 0;
      j = 0;
      int maxDiff = -1;

      while(j < n && i < n) {
         if (LMin[i] <= RMax[j]) {
            maxDiff = Math.max(maxDiff, j - i);
            ++j;
         } else {
            ++i;
         }
      }

      return maxDiff;
   }

   public static int maxDiff(int[] num) {
      int maxDiff = -1;
      int[] leftMin = new int[num.length];
      int[] rightMax = new int[num.length];
      leftMin[0] = num[0];

      int i;
      for(i = 1; i < num.length; ++i) {
         leftMin[i] = Math.min(num[i], leftMin[i - 1]);
      }

      rightMax[num.length - 1] = num[num.length - 1];

      for(i = num.length - 2; i >= 0; --i) {
         rightMax[i] = Math.max(num[i], rightMax[i + 1]);
      }

      i = 0;
      int j = 0;

      while(i < num.length && j < num.length) {
         if (leftMin[i] <= rightMax[j]) {
            maxDiff = Math.max(maxDiff, j - i);
            ++j;
         } else {
            ++i;
         }
      }

      return maxDiff;
   }

   public static void main(String[] args) {
      int[] num = new int[]{33, 9, 10, 3, 2, 60, 30, 33, 11};
      System.out.println(maxDiff(num));
   }
}
