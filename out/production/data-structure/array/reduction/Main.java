package array.reduction;

public class Main {
   public static void swap(int[] num, int a, int b) {
      int temp = num[a];
      num[a] = num[b];
      num[b] = temp;
   }

   public static boolean ifFirstIsGreaterThanSecond(int a, int b) {
      return a > b;
   }

   public static void main(String[] args) {
   }
}
