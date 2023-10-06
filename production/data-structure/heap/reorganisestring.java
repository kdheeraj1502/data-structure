package heap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class reorganisestring {
   public static void main(String[] args) {
      System.out.println(reorganise("aaabbbccc"));
   }

   public static String reorganise(String s) {
      HashMap<Character, Integer> map = new HashMap();

      for(int i = 0; i < s.length(); ++i) {
         map.put(s.charAt(i), (Integer)map.getOrDefault(s.charAt(i), 0) + 1);
      }

      PriorityQueue<pair> heap = new PriorityQueue();
      Iterator var3 = map.keySet().iterator();

      while(var3.hasNext()) {
         char c = (Character)var3.next();
         heap.add(new pair(c, (Integer)map.get(c)));
      }

      int maxfrq = ((pair)heap.peek()).frq;
      if (maxfrq > s.length() - maxfrq + 1) {
         System.out.println("not possible");
         return "";
      } else {
         StringBuilder ans = new StringBuilder();

         pair ch;
         while(heap.size() > 1) {
            ch = (pair)heap.remove();
            pair ch2 = (pair)heap.remove();
            ans.append(ch.ch);
            ans.append(ch2.ch);
            --ch.frq;
            --ch2.frq;
            if (ch.frq > 0) {
               heap.add(ch);
            }

            if (ch2.frq > 0) {
               heap.add(ch2);
            }
         }

         if (heap.size() != 0) {
            ch = (pair)heap.remove();
            ans.append(ch.ch);
         }

         return ans.toString();
      }
   }
}
