package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SubSetSumProblem {
   private int max;
   private int[] num;

   public SubSetSumProblem(int max, int[] num) {
      this.max = max;
      this.num = num;
   }

   public List<List<Integer>> solve() {
      Arrays.sort(this.num);
      return this.solve(this.num, this.max, 0, new ArrayList(), new ArrayList());
   }

   public List<List<Integer>> solve(int[] num, int max, int start, List<List<Integer>> result, List<Integer> curr) {
      if (start >= num.length && max == 0) {
         List<Integer> temp = new ArrayList();
         Iterator var10 = curr.iterator();

         while(var10.hasNext()) {
            int in = (Integer)var10.next();
            temp.add(in);
         }

         curr.clear();
         result.add(temp);
         return result;
      } else {
         for(int i = start; i < num.length; ++i) {
            if (max != 0 && max > 0) {
               List<Integer> temp = new ArrayList();
               temp.addAll(curr);
               temp.add(num[i]);
               this.solve(num, max - num[i], i + 1, result, temp);
            }
         }

         return result;
      }
   }

   public static void main(String[] args) {
      int[] num = new int[]{4, -2, 2, 3, 1};
      int max = 5;
      SubSetSumProblem ssp = new SubSetSumProblem(max, num);
      List<List<Integer>> result = ssp.solve();
      System.out.println(result);
   }
}
