package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTriplet {
   public static List<List<Integer>> findTripletToTheNum(int[] num, int val, List<List<Integer>> output) {
      Arrays.sort(num);

      for(int i = 0; i < num.length - 2; ++i) {
         int start = i + 1;
         int end = num.length - 1;
         int a = num[i];

         while(start < end) {
            int b = num[start];
            int c = num[end];
            int sum = a + b + c;
            if (sum == val) {
               List<Integer> curr = new ArrayList();
               curr.add(a);
               curr.add(b);
               curr.add(c);
               output.add(curr);
               ++start;
               --end;
            }

            if (sum > val) {
               --end;
            } else {
               ++start;
            }
         }
      }

      return output;
   }

   public static void main(String[] args) {
      int[] num = new int[]{2, 7, 3, 5, -5, 8, -4, 1, 0};
      List<List<Integer>> result = new ArrayList();
      System.out.println(findTripletToTheNum(num, 12, result));
   }
}
