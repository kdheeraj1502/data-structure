import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class NestedList {
   public static List<Integer> sort(List<List<Integer>> list) {
      List<Integer> one = new ArrayList((Collection)list.get(0));
      List<Integer> sorted = null;

      for(int k = 1; k < list.size(); ++k) {
         List<Integer> two = (List)list.get(k);
         int i = 0;
         int j = 0;
         sorted = new ArrayList();

         while(true) {
            while(i < one.size() && j < two.size()) {
               if (i < one.size() && j < two.size() && (Integer)one.get(i) <= (Integer)two.get(j)) {
                  sorted.add(one.get(i++));
               } else {
                  sorted.add(two.get(j++));
               }
            }

            while(i < one.size()) {
               sorted.add(one.get(i++));
            }

            while(j < two.size()) {
               sorted.add(two.get(j++));
            }

            one = new ArrayList(sorted);
            break;
         }
      }

      return sorted;
   }

   public static void main(String[] args) {
      List<Integer> list1 = Arrays.asList(1, 2, 3);
      List<Integer> list2 = Arrays.asList(1, 2, 4);
      List<Integer> list3 = Arrays.asList(2, 6);
      List<List<Integer>> list = Arrays.asList(list1, list2, list3);
      sort(list).stream().forEach((n) -> {
         System.out.print(n + ", ");
      });
   }
}
