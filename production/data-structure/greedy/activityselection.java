package greedy;

import java.util.ArrayList;
import java.util.Collections;

public class activityselection {
   public static void main(String[] args) {
      int[] s = new int[]{5, 3, 0, 5, 8, 1};
      int[] e = new int[]{9, 4, 6, 7, 9, 2};
      solve(s, e);
   }

   public static void solve(int[] s, int[] e) {
      ArrayList<pair> arr = new ArrayList();

      int count;
      for(count = 0; count < s.length; ++count) {
         arr.add(new pair(s[count], e[count]));
      }

      Collections.sort(arr);
      count = 1;
      int end = ((pair)arr.get(0)).end;

      for(int i = 1; i < arr.size(); ++i) {
         if (end < ((pair)arr.get(i)).start) {
            ++count;
            end = ((pair)arr.get(i)).end;
         }
      }

      System.out.println(count);
   }
}
