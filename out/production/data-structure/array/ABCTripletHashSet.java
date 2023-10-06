package array;

import java.util.HashSet;

public class ABCTripletHashSet {
   public static void main(String[] args) {
      int[] num = new int[]{1, 2, 3, 4};
      findTriplet(num);
   }

   private static void findTriplet(int[] num) {
      HashSet<Integer> set = new HashSet();

      for(int i = 0; i < num.length - 1; ++i) {
         for(int j = i + 1; j < num.length; ++j) {
            int sum = -(num[i] + num[j]);
            System.out.println("Sum : " + sum + " num[i] : " + num[i] + " num[j] : " + num[j]);
            if (set.contains(sum)) {
               System.out.println("Found");
               System.out.println(num[i] + " " + num[j] + " " + sum);
            } else {
               set.add(num[j]);
            }
         }
      }

   }
}
