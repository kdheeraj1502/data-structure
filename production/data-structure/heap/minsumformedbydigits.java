package heap;

import java.util.PriorityQueue;

public class minsumformedbydigits {
   public static void main(String[] args) {
   }

   String solve(int[] arr, int n) {
      PriorityQueue<Integer> queue = new PriorityQueue();

      for(int i = 0; i < n; ++i) {
         queue.add(arr[i]);
      }

      String s1 = "";
      String s2 = "";

      while(queue.size() > 0) {
         s1 = s1 + queue.remove();
         if (queue.size() > 0) {
            s2 = s2 + queue.remove();
         }
      }

      return this.largesum(s1, s2);
   }

   String largesum(String str1, String str2) {
      String str;
      if (str1.length() > str2.length()) {
         str = str1;
         str1 = str2;
         str2 = str;
      }

      str = "";
      int n1 = str1.length();
      int n2 = str2.length();
      str1 = (new StringBuilder(str1)).reverse().toString();
      str2 = (new StringBuilder(str2)).reverse().toString();
      int carry = 0;

      int i;
      int sum;
      for(i = 0; i < n1; ++i) {
         sum = str1.charAt(i) - 48 + (str2.charAt(i) - 48) + carry;
         str = str + (char)(sum % 10 + 48);
         carry = sum / 10;
      }

      for(i = n1; i < n2; ++i) {
         sum = str2.charAt(i) - 48 + carry;
         str = str + (char)(sum % 10 + 48);
         carry = sum / 10;
      }

      if (carry > 0) {
         str = str + (char)(carry + 48);
      }

      str = (new StringBuilder(str)).reverse().toString();
      return str;
   }
}
