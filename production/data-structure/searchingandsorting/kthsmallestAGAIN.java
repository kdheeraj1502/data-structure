package searchingandsorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class kthsmallestAGAIN {
   public static void main(String[] args) {
      kthsmallest();
   }

   public static void kthsmallest() {
      Scanner s = new Scanner(System.in);

      for(int t = s.nextInt(); t > 0; --t) {
         int n = s.nextInt();
         int q = s.nextInt();
         int idx = 0;
         int idx1 = false;
         pair[] arr = new pair[n];

         long[] size;
         long k;
         for(size = new long[n]; n > 0; --n) {
            k = s.nextLong();
            long end = s.nextLong();
            arr[idx++] = new pair(k, end);
         }

         Arrays.sort(arr);
         merge(arr);

         for(int i = 0; i < size.length; ++i) {
            size[i] = arr[i].end - arr[i].start + 1L;
         }

         for(; q > 0; --q) {
            k = s.nextLong();
            int flag = true;

            for(int i = 0; i < size.length; ++i) {
               if (k <= size[i]) {
                  flag = false;
                  long start = arr[i].start;
                  System.out.println(start + k - 1L);
               } else {
                  k -= size[i];
               }
            }

            if (flag) {
               System.out.println(-1);
            }
         }
      }

   }

   public static void merge(pair[] arr) {
      Stack<pair> st = new Stack();

      for(int i = 0; i < arr.length; ++i) {
         pair rv = arr[i];
         if (i == 0) {
            st.push(rv);
         } else {
            pair top = (pair)st.peek();
            if (top.end >= rv.start) {
               if (top.end < rv.end) {
                  top.end = rv.end;
               }
            } else {
               st.push(rv);
            }
         }
      }

   }
}
