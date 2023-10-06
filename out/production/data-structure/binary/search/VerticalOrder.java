package binary.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrder {
   static Node root;

   public static List<List<Integer>> verticalTraversal(Node root) {
      if (root == null) {
         return new ArrayList();
      } else {
         TreeMap<Integer, List<Integer>> distanceMap = new TreeMap();
         Queue<NodeDistance> q = new LinkedList();
         q.add(new NodeDistance(0, root));

         while(!q.isEmpty()) {
            HashMap<Integer, List<Integer>> levelMap = new HashMap();
            int size = q.size();

            List nodeList;
            while(size-- > 0) {
               NodeDistance current = (NodeDistance)q.poll();
               int distance = current.dist;
               nodeList = (List)levelMap.getOrDefault(distance, new ArrayList());
               nodeList.add(current.node.val);
               Collections.sort(nodeList);
               levelMap.put(distance, new ArrayList(nodeList));
               if (current.node.left != null) {
                  q.add(new NodeDistance(distance - 1, current.node.left));
               }

               if (current.node.right != null) {
                  q.add(new NodeDistance(distance + 1, current.node.right));
               }
            }

            Iterator var8 = levelMap.entrySet().iterator();

            while(var8.hasNext()) {
               Map.Entry<Integer, List<Integer>> entry = (Map.Entry)var8.next();
               nodeList = (List)distanceMap.getOrDefault(entry.getKey(), new ArrayList());
               nodeList.addAll((Collection)entry.getValue());
               distanceMap.put(entry.getKey(), nodeList);
            }
         }

         return new ArrayList(distanceMap.values());
      }
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
