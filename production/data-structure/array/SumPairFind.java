package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumPairFind {
   public static int[] findPair(int[] num, int val) {
      int[] result = new int[2];
      Set<Integer> set = new HashSet();

      for(int i = num.length; i > 0; --i) {
         if (set.contains(val - num[i])) {
            result[0] = num[i];
            result[1] = val - num[i];
         }

         set.add(num[i]);
      }

      return result;
   }

   public static int[] findPairInList(List<Integer> list1, List<Integer> list2, int val) {
      int[] result = new int[2];
      Collections.sort(list1);

      for(int i = 0; i < list2.size(); ++i) {
         int diff = val - (Integer)list2.get(i);
         int index = binarySearch(list1, diff);
         if (index >= 0) {
            result[0] = (Integer)list2.get(i);
            result[1] = (Integer)list1.get(index);
         }
      }

      return result;
   }

   private static int binarySearch(List<Integer> list1, int diff) {
      int start = 0;
      int end = list1.size() - 1;
      int mid = -1;

      while(start <= end) {
         mid = (start + end) / 2;
         if ((Integer)list1.get(mid) == diff) {
            return mid;
         }

         if ((Integer)list1.get(mid) > diff) {
            end = mid - 1;
         } else {
            start = mid + 1;
         }
      }

      return mid;
   }

   public static void main(String[] args) {
      int[] var10000 = new int[]{5, 2, 7, 9, 1, 0, 8};
      List<Integer> list1 = Arrays.asList(5, 2, 9, 1, 3, 2);
      List<Integer> list2 = Arrays.asList(5, 6, 7, 9, 0, 8);
      System.out.println(Arrays.toString(findPairInList(list1, list2, 9)));
   }
}
