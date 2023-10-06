package recursion;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Permutation {
   public static List<List<Integer>> permutation(int[] num) {
      List<List<Integer>> result = new ArrayList();
      permutation(num, result, 0);
      return result;
   }

   public static void permutation(int[] num, List<List<Integer>> result, int index) {
      if (index == num.length) {
         List<Integer> curr = new ArrayList();
         int[] var4 = num;
         int var5 = num.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            int in = var4[var6];
            curr.add(in);
         }

         result.add(curr);
      } else {
         for(int i = index; i < num.length; ++i) {
            swap(num, i, index);
            permutation(num, result, index + 1);
            swap(num, i, index);
         }

      }
   }

   public static void swap(int[] num, int i, int j) {
      int temp = num[i];
      num[i] = num[j];
      num[j] = temp;
   }

   public static void main(String[] args) {
      int[] num = new int[5];

      for(int i = 0; i < 5; num[i] = i++) {
      }

      Stream var10000 = permutation(num).stream();
      PrintStream var10001 = System.out;
      var10000.forEach(var10001::println);
   }
}
