package array;

public class pallindromicarray {
   public static void main(String[] args) {
      pallindrome(243);
   }

   public static int pallindromicarray(int[] arr) {
      for(int i = 0; i < arr.length; ++i) {
         if (!pallindrome(arr[i])) {
            return 0;
         }
      }

      return 1;
   }

   public static boolean pallindrome(int n) {
      int reverse = 0;
      int temp = n;

      int rem;
      for(int rem = false; temp > 0; reverse = reverse * 10 + rem) {
         rem = temp % 10;
         temp /= 10;
      }

      return n == reverse;
   }
}
