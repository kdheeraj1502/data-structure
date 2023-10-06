package binary.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticleOrder {
   static int min;
   static int max;
   static Node root;

   public static List<List<Integer>> verticalTraversal(Node root) {
      Queue<Pair<Node, Integer>> queue = new ArrayDeque();
      queue.add(new Pair(root, 0));
      TreeMap<Integer, List<Integer>> distaceMap = new TreeMap();

      while(!queue.isEmpty()) {
         Map<Integer, List<Integer>> map = new HashMap();
         int size = queue.size();
         int index = ((Pair)queue.peek()).index;

         while(size-- > 0) {
            Pair<Node, Integer> temp = (Pair)queue.remove();
            index = temp.index;
            List<Integer> list = (List)map.getOrDefault(index, new ArrayList());
            list.add(temp.node.val);
            Collections.sort(list);
            map.put(index, new ArrayList(list));
            if (temp.node.left != null) {
               queue.add(new Pair(temp.node.left, index - 1));
               min = Math.min(min, index - 1);
            }

            if (temp.node.right != null) {
               queue.add(new Pair(temp.node.right, index + 1));
               max = Math.max(max, index + 1);
            }
         }

         Iterator var9 = map.entrySet().iterator();

         while(var9.hasNext()) {
            Map.Entry<Integer, List<Integer>> entry = (Map.Entry)var9.next();
            List<Integer> list = (List)distaceMap.getOrDefault(entry.getKey(), new ArrayList());
            list.addAll((Collection)entry.getValue());
            distaceMap.put(entry.getKey(), list);
         }
      }

      System.out.println(distaceMap);
      return new ArrayList(distaceMap.values());
   }

   public static void main(String[] args) {
      root = new Node(3);
      root.left = new Node(1);
      root.right = new Node(4);
      root.left.left = new Node(0);
      root.left.right = new Node(2);
      root.right.left = new Node(2);
      System.out.println(verticalTraversal(root));
   }
}
