package array;

import array.reduction.Main;
import java.util.Arrays;

public class WaveFormOddEvenArray {
   public static void waveForm(int[] num) {
      for(int i = 1; i < num.length; i += 2) {
         if (i - 1 >= 0 && num[i] > num[i - 1]) {
            Main.swap(num, i, i - 1);
         }

         if (i + 1 < num.length && num[i] > num[i + 1]) {
            Main.swap(num, i, i + 1);
         }
      }

   }

   public static void sortInWave(int[] arr, int n) {
      Arrays.sort(arr);

      for(int i = 0; i < n - 1; i += 2) {
         Main.swap(arr, i, i + 1);
      }

   }

   public static void sortInWave(int[] arr) {
      for(int i = 0; i < arr.length; i += 2) {
         if (i > 0 && arr[i - 1] > arr[i]) {
            Main.swap(arr, i - 1, i);
         }

         if (i < arr.length - 1 && arr[i] < arr[i + 1]) {
            Main.swap(arr, i, i + 1);
         }
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{8, 1, 2, 3, 4, 5, 6, 4, 2};
      sortInWave(num);
      System.out.println(Arrays.toString(num));
   }
}
