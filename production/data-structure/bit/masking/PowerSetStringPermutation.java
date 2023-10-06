package bit.masking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PowerSetStringPermutation {
   static List<List<String>> getSubset(String[] set, int index) {
      Object result;
      if (index < 0) {
         result = new ArrayList();
         ((List)result).add(new ArrayList());
      } else {
         result = getSubset(set, index - 1);
         String item = set[index];
         List<List<String>> moreSubsets = new ArrayList();
         Iterator var5 = ((List)result).iterator();

         while(var5.hasNext()) {
            List<String> subset = (List)var5.next();
            List<String> newSubset = new ArrayList();
            newSubset.addAll(subset);
            newSubset.add(item);
            moreSubsets.add(newSubset);
         }

         ((List)result).addAll(moreSubsets);
      }

      return (List)result;
   }

   public static void main(String[] args) {
      String[] set = new String[]{"d", "m", "x", "n"};
      int index = set.length - 1;
      List<List<String>> result = getSubset(set, index);
      System.out.println(result);
   }
}
