package binnarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class RightView {
   ArrayList<Integer> rightView(Node node) {
      ArrayList<Integer> result = new ArrayList();
      if (node == null) {
         return result;
      } else if (node.left == null && node.right == null) {
         result.add(node.data);
         return result;
      } else {
         Queue<Node> queue = new ArrayDeque();
         queue.add(node);

         while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 1; i <= size; ++i) {
               Node temp = (Node)queue.remove();
               if (i == 1) {
                  result.add(temp.data);
               }

               if (temp.right != null) {
                  queue.add(temp.right);
               }

               if (temp.left != null) {
                  queue.add(temp.left);
               }
            }
         }

         return result;
      }
   }
}
