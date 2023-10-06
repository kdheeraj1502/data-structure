package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingSmallestPositiveNum {
   public static int findSmallestPositiveNumber(int[] num) {
      for(int i = 1; i <= num.length; ++i) {
         int found = false;

         for(int j = 0; j < num.length; ++j) {
            if (num[j] == i) {
               found = true;
               break;
            }
         }

         if (!found) {
            return i;
         }
      }

      return -1;
   }

   public static int findSmallestPositiveNumberHashMap(int[] num) {
      Set<Integer> map = new HashSet();

      int i;
      for(i = 0; i < num.length; ++i) {
         map.add(num[i]);
      }

      for(i = 1; i <= num.length; ++i) {
         if (!map.contains(i)) {
            return i;
         }
      }

      return -1;
   }

   public static int findSmallestPositiveNumberUsingAux(int[] num) {
      int[] aux = new int[num.length];
      Arrays.fill(aux, -1);

      int i;
      for(i = 0; i < num.length; ++i) {
         if (num[i] > 0 && num[i] <= num.length) {
            aux[num[i] - 1] = num[i];
         }
      }

      for(i = 0; i < num.length; ++i) {
         if (aux[i] != i + 1) {
            return i + 1;
         }
      }

      return -1;
   }

   public static void main(String[] args) {
      int[] num = new int[]{8, 5, 6, 1, 9, 11, 2, 4, 3};
      System.out.println(findSmallestPositiveNumberUsingAux(num));
   }
}
