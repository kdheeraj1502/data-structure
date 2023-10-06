package array;

import java.util.HashSet;
import java.util.Set;

public class subarraysum0 {
   public static void main(String[] args) {
      int[] arr = new int[]{10, -10};
      System.out.println(subarraysum(arr));
   }

   public static boolean subarraysum(int[] arr) {
      Set<Integer> temp = new HashSet();
      int sum = 0;

      for(int i = 0; i < arr.length; ++i) {
         temp.add(sum);
         sum += arr[i];
         System.out.println(temp);
         if (temp.contains(sum)) {
            return true;
         }
      }

      return false;
   }
}
