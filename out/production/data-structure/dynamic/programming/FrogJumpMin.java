package dynamic.programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FrogJumpMin {
   private HashMap<Integer, HashSet> checked = new HashMap();

   public int minJump(int[] num) {
      int[] jumps = new int[num.length];
      jumps[0] = 0;

      int i;
      for(i = 1; i < jumps.length; ++i) {
         jumps[i] = Integer.MAX_VALUE;
      }

      for(i = 1; i < num.length; ++i) {
         for(int j = 0; j < i; ++j) {
            if (i <= j + num[j] && jumps[j] != Integer.MAX_VALUE) {
               jumps[i] = Math.min(jumps[i], jumps[j] + 1);
            }
         }
      }

      return jumps[jumps.length - 1];
   }

   public boolean canCross(int[] stones) {
      Map<Integer, Set<Integer>> dp = new HashMap();
      int[] var3 = stones;
      int var4 = stones.length;

      int var5;
      int val;
      for(var5 = 0; var5 < var4; ++var5) {
         val = var3[var5];
         dp.put(val, new HashSet());
      }

      ((Set)dp.get(stones[0])).add(1);
      var3 = stones;
      var4 = stones.length;

      for(var5 = 0; var5 < var4; ++var5) {
         val = var3[var5];
         Iterator var7 = ((Set)dp.get(val)).iterator();

         while(var7.hasNext()) {
            int jump = (Integer)var7.next();
            if (jump != 0 && dp.containsKey(val + jump)) {
               ((Set)dp.get(val + jump)).add(jump - 1);
               ((Set)dp.get(val + jump)).add(jump);
               ((Set)dp.get(val + jump)).add(jump + 1);
            }
         }
      }

      return !((Set)dp.get(stones[stones.length - 1])).isEmpty();
   }

   public static void main(String[] args) {
      int[] num = new int[]{1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
      FrogJumpMin fjm = new FrogJumpMin();
      System.out.println();
      System.out.print("Minimum number of jumps to reach end is " + fjm.canCross(num));
   }
}
