package array;

import java.util.Arrays;

public class RotateArray {
   public static void rotateArray(int[] num, int k) {
      reverseArray(num, 0, k - 1);
      reverseArray(num, k, num.length - 1);
      reverseArray(num, 0, num.length - 1);
   }

   public static void reverseArray(int[] num, int a, int b) {
      while(a <= b) {
         int temp = num[a];
         num[a] = num[b];
         num[b] = temp;
         ++a;
         --b;
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{10, 20, 30, 40, 50, 60};
      rotateArray(num, 2);
      System.out.println(Arrays.toString(num));
   }
}
