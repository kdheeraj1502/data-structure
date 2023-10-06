package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class defkin {
   public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);

      for(int t = scn.nextInt(); t > 0; --t) {
         int x = scn.nextInt();
         int y = scn.nextInt();
         int n = scn.nextInt();
         int[] posx = new int[n + 2];
         int[] posy = new int[n + 2];
         posx[0] = 0;
         posy[0] = 0;

         for(int i = 1; i < posx.length - 1; ++i) {
            posx[i] = scn.nextInt();
            posy[i] = scn.nextInt();
         }

         posx[n + 1] = x + 1;
         posy[n + 1] = y + 1;
         solve(posx, posy, x, y);
      }

   }

   public static void solve(int[] posx, int[] posy, int x, int y) {
      Arrays.parallelSort(posx);
      Arrays.parallelSort(posy);
      int maxwidth = 0;
      int maxheight = 0;

      for(int i = 0; i < posx.length - 1; ++i) {
         maxwidth = Math.max(maxwidth, posx[i + 1] - posx[i] - 1);
         maxheight = Math.max(maxheight, posy[i + 1] - posy[i] - 1);
      }

      System.out.println(maxheight * maxwidth);
   }
}
