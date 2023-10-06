package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CommonElement {
   public static ArrayList<Integer> commonElements(int[] A, int[] B, int[] C) {
      Set<Integer> set1 = new HashSet();
      Set<Integer> set2 = new HashSet();
      int[] var5 = A;
      int var6 = A.length;

      int var7;
      int val;
      for(var7 = 0; var7 < var6; ++var7) {
         val = var5[var7];
         set1.add(val);
      }

      var5 = B;
      var6 = B.length;

      for(var7 = 0; var7 < var6; ++var7) {
         val = var5[var7];
         if (set1.contains(val)) {
            set2.add(val);
         }
      }

      ArrayList<Integer> result = new ArrayList();
      int[] var11 = C;
      var7 = C.length;

      for(val = 0; val < var7; ++val) {
         int val = var11[val];
         if (set2.contains(val) && !result.contains(val)) {
            result.add(val);
         }
      }

      return result;
   }

   public static void main(String[] args) {
      int[] num1 = new int[]{1, 5, 10, 20, 40, 80};
      int[] num2 = new int[]{6, 7, 20, 80, 100};
      int[] num3 = new int[]{3, 4, 15, 20, 30, 70, 80, 120};
      System.out.println(commonElements(num1, num2, num3));
   }
}
