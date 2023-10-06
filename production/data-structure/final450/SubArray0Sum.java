package final450;

import java.util.HashSet;
import java.util.Set;

public class SubArray0Sum {
   public static boolean findSum(int[] num) {
      Set<Integer> set = new HashSet();
      int sum = 0;

      for(int i = 0; i < num.length; ++i) {
         sum += num[i];
         if (num[i] == 0 || sum == 0 || set.contains(sum)) {
            return true;
         }

         set.add(sum);
      }

      return false;
   }

   public static void main(String[] args) {
      int[] num = new int[]{4, 2, -3, 1, 6};
      System.out.println(findSum(num));
   }
}
