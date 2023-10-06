package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class oliverandthegame {
   public static int t = 1;

   public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      Long n = scn.nextLong();
      HashMap<Long, ArrayList<Long>> vtces = new HashMap();

      long noe;
      for(noe = 1L; noe <= n; ++noe) {
         ArrayList<Long> nbr = new ArrayList();
         vtces.put(noe, nbr);
      }

      long nq;
      long t;
      for(noe = n - 1L; noe > 0L; --noe) {
         nq = scn.nextLong();
         t = scn.nextLong();
         ArrayList<Long> nbru = (ArrayList)vtces.get(nq);
         ArrayList<Long> nbrv = (ArrayList)vtces.get(t);
         nbru.add(t);
         nbrv.add(nq);
      }

      for(nq = scn.nextLong(); nq > 0L; --nq) {
         t = scn.nextLong();
         long x = scn.nextLong();
         long y = scn.nextLong();
         boolean ans = game(vtces, n, t, x, y);
         if (ans) {
            System.out.println("YES");
         } else {
            System.out.println("NO");
         }
      }

   }

   public static boolean game(HashMap<Long, ArrayList<Long>> vtces, long n, long t, long x, long y) {
      long[] intime = new long[(int)(n + 1L)];
      long[] outtime = new long[(int)(n + 1L)];
      dfs(vtces, 0L, intime, outtime, 1L);
      if (!check(x, y, intime, outtime) && !check(y, x, intime, outtime)) {
         return false;
      } else {
         return t == 0L ? check(x, y, intime, outtime) : check(y, x, intime, outtime);
      }
   }

   private static boolean check(long x, long y, long[] intime, long[] outtime) {
      return intime[(int)x] < intime[(int)y] && outtime[(int)x] > outtime[(int)y];
   }

   public static void dfs(HashMap<Long, ArrayList<Long>> vtces, long par, long[] intime, long[] outtime, long src) {
      intime[(int)src] = (long)(t++);
      ArrayList<Long> nbr = (ArrayList)vtces.get(src);
      Iterator var8 = nbr.iterator();

      while(var8.hasNext()) {
         Long i = (Long)var8.next();
         if (i != par) {
            dfs(vtces, src, intime, outtime, i);
         }
      }

      outtime[(int)src] = (long)(t++);
   }
}
