package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class clonegraph {
   HashMap<Node, Node> map = new HashMap();

   public static void main(String[] args) {
   }

   public Node cloneGraph(Node node) {
      if (node == null) {
         return null;
      } else {
         this.map.put(node, new Node(this, node.val, new ArrayList()));
         Iterator var2 = node.neighbors.iterator();

         while(var2.hasNext()) {
            Node neighbor = (Node)var2.next();
            Node copy;
            if (this.map.containsKey(neighbor)) {
               copy = (Node)this.map.get(node);
               copy.neighbors.add(this.map.get(neighbor));
            } else {
               copy = (Node)this.map.get(node);
               copy.neighbors.add(this.cloneGraph(neighbor));
            }
         }

         return (Node)this.map.get(node);
      }
   }
}
