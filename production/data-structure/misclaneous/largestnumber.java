package misclaneous;

import java.util.Arrays;
import java.util.List;

public class largestnumber {
   public static void main(String[] args) {
   }

   public String largestNumber(List<Integer> A) {
      Integer[] arr = new Integer[A.size()];

      for(int i = 0; i < A.size(); ++i) {
         arr[i] = (Integer)A.get(i);
      }

      Arrays.parallelSort(arr, new Sort(this));
      StringBuilder ans = new StringBuilder();

      for(int i = 0; i < A.size(); ++i) {
         ans.append(arr[i]);
      }

      return ans.charAt(0) == '0' ? "0" : ans.toString();
   }
}
