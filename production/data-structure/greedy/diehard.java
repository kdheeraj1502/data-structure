package greedy;

import java.util.Scanner;

public class diehard {
   public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);

      for(int t = scn.nextInt(); t > 0; --t) {
         int h = scn.nextInt();
         int a = scn.nextInt();
         solve(h, a);
      }

   }

   public static void solve(int h, int a) {
      int i;
      for(i = 0; h > 0 && a > 0; ++i) {
         if (i % 2 == 0) {
            h += 3;
            a += 2;
         } else if (h - 5 > 0 && a - 10 > 0) {
            h -= 5;
            a -= 10;
         } else {
            if (h - 20 <= 0 || a + 5 <= 0) {
               break;
            }

            h -= 20;
            a += 5;
         }
      }

      System.out.println(i);
   }
}
