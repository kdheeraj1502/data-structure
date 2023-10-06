package bit.masking.xor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinXORValue {
   public static int findMinXor(List<Integer> A) {
      Collections.sort(A);
      int first = 0;
      int second = first + 1;
      int minXor = Integer.MAX_VALUE;

      for(int xor = false; second < A.size() - 1 && first < A.size(); ++first) {
         second = first + 1;
         int xor = (Integer)A.get(first) ^ (Integer)A.get(second);
         minXor = Math.min(minXor, xor);
      }

      return minXor;
   }

   public static void main(String[] args) {
      List<Integer> list = Arrays.asList(0, 4, 7, 9);
      System.out.println(findMinXor(list));
   }
}
