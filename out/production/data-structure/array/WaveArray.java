package array;

import array.reduction.Main;
import java.util.Arrays;

public class WaveArray {
   public static void waveArray(int[] num) {
      for(int i = 1; i < num.length; i += 2) {
         if (i - 1 >= 0 && num[i] > num[i - 1]) {
            Main.swap(num, i, i - 1);
         }

         if (i + 1 < num.length && num[i] > num[i + 1]) {
            Main.swap(num, i, i + 1);
         }
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{8, 1, 2, 3, 4, 5, 6, 4, 2};
      waveArraySelf_1(num);
      System.out.println(Arrays.toString(num));
   }

   public static void waveArraySelf(int[] num) {
      for(int i = 1; i < num.length; i += 2) {
         if (i - 1 >= 0 && num[i] > num[i - 1]) {
            Main.swap(num, i, i - 1);
         }

         if (i + 1 < num.length && num[i] > num[i + 1]) {
            Main.swap(num, i, i + 1);
         }
      }

   }

   public static void waveArraySelf_1(int[] num) {
      for(int i = 1; i < num.length; i += 2) {
         if (i - 1 >= 0 && num[i] > num[i - 1]) {
            Main.swap(num, i - 1, i);
         }

         if (i + 1 < num.length && num[i] > num[i + 1]) {
            Main.swap(num, i + 1, i);
         }
      }

   }
}
