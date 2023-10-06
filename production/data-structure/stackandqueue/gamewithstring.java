package stackandqueue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class gamewithstring {
   static int minValue(String s, int k) {
      HashMap<Character, Integer> map = new HashMap();

      for(int i = 0; i < s.length(); ++i) {
         map.put(s.charAt(i), (Integer)map.getOrDefault(s.charAt(i), 0) + 1);
      }

      PriorityQueue<Integer> q = new PriorityQueue(Collections.reverseOrder());
      Iterator var4 = map.values().iterator();

      while(var4.hasNext()) {
         Integer freq = (Integer)var4.next();
         q.add(freq);
      }

      int sum;
      int val;
      for(sum = 0; sum < k; ++sum) {
         val = (Integer)q.remove();
         q.add(val - 1);
      }

      for(sum = 0; !q.isEmpty(); sum += val * val) {
         val = (Integer)q.remove();
      }

      return sum;
   }
}
