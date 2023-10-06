package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SumDistinct {
   public static int sumDistinct(int[] num) {
      Arrays.sort(num);
      int j = 0;
      int sum = num[0];

      for(int i = 1; i < num.length; ++i) {
         if (num[i] != num[j]) {
            ++j;
            num[j] = num[i];
            sum += num[j];
         }
      }

      return sum;
   }

   public static int sumDistinctMap(int[] num) {
      Set<Integer> set = new HashSet();
      int sum = 0;

      for(int i = 0; i < num.length; ++i) {
         set.add(num[i]);
      }

      int in;
      for(Iterator var5 = set.iterator(); var5.hasNext(); sum += in) {
         in = (Integer)var5.next();
      }

      return sum;
   }

   public static void main(String[] args) {
      int[] num = new int[]{4, 5, 3, 7, 4, 9, 2, 5, 2, 9, 3, 7, 3, 4};
      System.out.println(sumDistinct(num));
      System.out.println(sumDistinctMap(num));
   }
}
