package binary.search;

import java.util.Arrays;

public class IsMajority {
   public static void main(String[] args) {
      int[] num = new int[]{4, 6, 7, 3, 5, 2, 3, 2, 3, 3, 3, 5, 3, 3, 3, 3, 3, 5, 3};
      System.out.println(majorityEle(num));
   }

   private static boolean majorityEle(int[] num) {
      Arrays.sort(num);
      int start = 0;
      int end = num.length - 1;
      int target = num[num.length / 2];
      int firstInd = findFirstOccuranceInArray(num, target, start, end);
      return firstInd + num.length / 2 < num.length && num[firstInd] == num[firstInd + num.length / 2];
   }

   private static int findFirstOccuranceInArray(int[] num, int target, int start, int end) {
      int mid = (start + end) / 2;
      int result = true;
      int result;
      if (num[mid] != target || mid != 0 && num[mid - 1] >= target) {
         if (num[mid] < target) {
            result = findFirstOccuranceInArray(num, target, start + 1, end);
         } else {
            result = findFirstOccuranceInArray(num, target, start, mid - 1);
         }
      } else {
         result = mid;
      }

      return result;
   }
}
