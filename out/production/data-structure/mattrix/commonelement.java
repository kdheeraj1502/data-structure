package mattrix;

import java.util.HashMap;
import java.util.Map;

public class commonelement {
   public static void main(String[] args) {
   }

   public static void ce(int[][] m) {
      Map<Integer, Integer> mp = new HashMap();

      int i;
      for(i = 0; i < m[0].length; ++i) {
         mp.put(m[0][i], 1);
      }

      for(i = 1; i < m.length; ++i) {
         for(int j = 0; j < m.length; ++j) {
            if (mp.get(m[i][j]) != null && (Integer)mp.get(m[i][j]) == i) {
               mp.put(m[i][j], i + 1);
               if (i == m.length - 1) {
                  System.out.print(m[i][j] + " ");
               }
            }
         }
      }

   }
}
