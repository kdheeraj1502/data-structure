package binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PostOrderNAry {
   static List<Integer> result = new ArrayList();

   public static List<Integer> postorder(Node root) {
      if (root == null) {
         return result;
      } else {
         if (root.children != null) {
            Iterator var1 = root.children.iterator();

            while(var1.hasNext()) {
               Node child = (Node)var1.next();
               postorder(child);
            }
         }

         result.add(root.val);
         return result;
      }
   }

   public static void main(String[] args) {
      Node node = new Node(1);
      Node three = new Node(3);
      node.children = Arrays.asList(three, new Node(2), new Node(4));
      three.children = Arrays.asList(new Node(5), new Node(6));
      System.out.println(postorder(node));
   }
}
