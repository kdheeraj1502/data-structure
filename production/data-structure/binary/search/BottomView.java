package binary.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
   static Node root;

   public static ArrayList<Integer> bottomView(Node root) {
      ArrayList<Integer> result = new ArrayList();
      Map<Integer, List<Integer>> map = verticleOrder(root);
      Iterator var3 = map.entrySet().iterator();

      while(var3.hasNext()) {
         Map.Entry<Integer, List<Integer>> entry = (Map.Entry)var3.next();
         int size = ((List)entry.getValue()).size();
         int val = (Integer)((List)entry.getValue()).get(size - 1);
         result.add(val);
      }

      return result;
   }

   static Map<Integer, List<Integer>> verticleOrder(Node root) {
      Queue<Pair<Node, Integer>> queue = new LinkedList();
      queue.add(new Pair(root, 0));
      Map<Integer, List<Integer>> distance = new TreeMap();

      while(!queue.isEmpty()) {
         Map<Integer, List<Integer>> map = new HashMap();
         int size = queue.size();

         List list;
         while(size-- > 0) {
            Pair<Node, Integer> temp = (Pair)queue.remove();
            int index = temp.getIndex();
            list = (List)map.getOrDefault(map.get(index), new ArrayList());
            list.add(temp.node.val);
            map.put(index, list);
            if (temp.node.left != null) {
               queue.add(new Pair(temp.node.left, index - 1));
            }

            if (temp.node.right != null) {
               queue.add(new Pair(temp.node.right, index + 1));
            }
         }

         Iterator var8 = map.entrySet().iterator();

         while(var8.hasNext()) {
            Map.Entry<Integer, List<Integer>> entry = (Map.Entry)var8.next();
            list = (List)distance.getOrDefault(entry.getKey(), new ArrayList());
            list.addAll((Collection)entry.getValue());
            distance.put(entry.getKey(), list);
         }
      }

      return distance;
   }

   public static void main(String[] args) {
      root = new Node(3);
      root.left = new Node(1);
      root.right = new Node(4);
      root.left.left = new Node(0);
      root.left.right = new Node(2);
      root.right.left = new Node(2);
      System.out.println(bottomView(root));
   }
}
