package array;

public class findduplicate {
   public static void main(String[] args) {
      int[] arr = new int[]{1, 3, 3, 4, 2, 2};
      duplicatetwopointer(arr);
   }

   public static void findduplicate(int[] arr) {
      int[] temp = new int[arr.length];

      int i;
      for(i = 0; i < arr.length; ++i) {
         ++temp[arr[i]];
      }

      for(i = 0; i < temp.length; ++i) {
         if (temp[i] > 1) {
            System.out.println(i);
         }
      }

   }

   public static void duplicate(int[] arr) {
      int n = arr.length;

      int i;
      for(i = 0; i < arr.length; ++i) {
         arr[arr[i] % n] += n;
      }

      for(i = 0; i < arr.length; ++i) {
         if (arr[i] / n > 1) {
            System.out.println(i + " duplicate");
         }

         arr[i] %= n;
         System.out.println(arr[i]);
      }

   }

   public static void duplicatetwopointer(int[] arr) {
      int slow = arr[0];
      int fast = arr[0];

      do {
         slow = arr[slow];
         fast = arr[arr[fast]];
      } while(slow != fast);

      for(fast = arr[0]; slow != fast; fast = arr[fast]) {
         slow = arr[slow];
      }

      System.out.println(slow);
   }
}
