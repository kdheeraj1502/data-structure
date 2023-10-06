package binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairIn2List {
   public static List<Integer[]> findPair(int[] num1, int[] num2, int val) {
      Arrays.sort(num1);
      List<Integer[]> result = new ArrayList();

      for(int i = 0; i < num2.length; ++i) {
         int start = 0;
         int end = num1.length;
         int a = num2[i];

         while(start < end) {
            int mid = (start + end) / 2;
            int diff = val - a;
            if (diff == num1[mid]) {
               Integer[] output = new Integer[]{a, num1[mid]};
               result.add(output);
               break;
            }

            if (diff < num1[mid]) {
               --end;
            } else {
               ++start;
            }
         }
      }

      return result;
   }

   public static List<Integer[]> findPair_1(int[] num1, int[] num2, int val) {
      Arrays.sort(num1);
      Arrays.sort(num2);
      List<Integer[]> result = new ArrayList();
      int start = 0;
      int end = num2.length - 1;

      while(start < num1.length && end >= 0) {
         if (num1[start] + num2[end] == val) {
            Integer[] output = new Integer[]{num1[start], num2[end]};
            result.add(output);
            ++start;
         } else if (num1[start] + num2[end] < val) {
            ++start;
         } else {
            --end;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      int[] num1 = new int[]{34, 8, 74, 76, 11, 25, 11, 90, 57, 0, 15};
      int[] num2 = new int[]{13, 18, 14, 36, 11, 25, 1, 9, 15, 10, 5};
      findPair_1(num1, num2, 43).stream().forEach((r) -> {
         System.out.println(Arrays.toString(r));
      });
   }
}
