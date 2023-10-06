package searching;

import java.util.HashSet;
import java.util.Set;

public class FindMissingNumberUseSet {
   public static int findMissingNumberSet(int[] num) {
      Set<Integer> set = new HashSet();
      int[] var2 = num;
      int var3 = num.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Integer in = var2[var4];
         set.add(in);
      }

      for(int i = 1; i < set.size(); ++i) {
         if (!set.contains(i)) {
            return i;
         }
      }

      return -1;
   }
}
