package binary.search;

import java.util.ArrayDeque;
import java.util.Queue;

public class StringTree {
   private Node root;

   public static void print(Node curr) {
      if (curr != null) {
         System.out.print("[ Value : " + binary.search.StringTree.Node.access$000(curr));
         System.out.println(", Count : " + binary.search.StringTree.Node.access$100(curr) + " ]");
         print(binary.search.StringTree.Node.access$200(curr));
         print(binary.search.StringTree.Node.access$300(curr));
      }

   }

   public void add(String value) {
      this.root = this.add(value, this.root);
   }

   private Node add(String value, Node curr) {
      if (curr == null) {
         curr = new Node(this, value, (1)null);
         binary.search.StringTree.Node.access$102(curr, 1);
         binary.search.StringTree.Node.access$202(curr, binary.search.StringTree.Node.access$302(curr, (Node)null));
      } else {
         int compare = binary.search.StringTree.Node.access$000(curr).compareTo(value);
         if (compare == 0) {
            binary.search.StringTree.Node.access$108(curr);
         } else if (compare == 1) {
            binary.search.StringTree.Node.access$202(curr, this.add(value, binary.search.StringTree.Node.access$200(curr)));
         } else {
            binary.search.StringTree.Node.access$302(curr, this.add(value, binary.search.StringTree.Node.access$300(curr)));
         }
      }

      return curr;
   }

   public boolean find(String value) {
      return this.find(this.root, value);
   }

   private boolean find(Node curr, String value) {
      if (curr == null) {
         return false;
      } else {
         int compare = binary.search.StringTree.Node.access$000(curr).compareTo(value);
         if (compare == 0) {
            return true;
         } else {
            return compare == 1 ? this.find(binary.search.StringTree.Node.access$200(curr), value) : this.find(binary.search.StringTree.Node.access$300(curr), value);
         }
      }
   }

   public int frequencey(String value) {
      return this.frequencey(this.root, value);
   }

   private int frequencey(Node curr, String value) {
      if (curr == null) {
         return 0;
      } else {
         int compare = binary.search.StringTree.Node.access$000(curr).compareTo(value);
         if (compare == 0) {
            return binary.search.StringTree.Node.access$100(curr);
         } else {
            return compare > 1 ? this.frequencey(binary.search.StringTree.Node.access$200(curr), value) : this.frequencey(binary.search.StringTree.Node.access$300(curr), value);
         }
      }
   }

   public void freeTree() {
      this.root = null;
   }

   public void levelOrder(Node curr) {
      Queue<Node> queue = new ArrayDeque();
      Node temp = null;
      if (curr != null) {
         queue.add(curr);
      }

      while(!queue.isEmpty()) {
         if (!queue.isEmpty()) {
            temp = (Node)queue.remove();
         }

         System.out.println(binary.search.StringTree.Node.access$000(temp));
         if (binary.search.StringTree.Node.access$200(temp) != null) {
            queue.add(binary.search.StringTree.Node.access$200(temp));
         }

         if (binary.search.StringTree.Node.access$300(temp) != null) {
            queue.add(binary.search.StringTree.Node.access$300(temp));
         }
      }

   }

   public static void main(String[] args) {
      StringTree st = new StringTree();
      st.add("Parth");
      st.add("Ayansh");
      st.add("Ryan");
      st.add("Samar");
      st.add("Pranav");
      st.add("Aditya");
      st.add("Daksh");
      print(st.root);
      st.levelOrder(st.root);
   }
}
