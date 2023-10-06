package linked.list.singly;

public class Node {
   Integer val;
   Node next;

   Node() {
   }

   Node(int val) {
      this.val = new Integer(val);
      this.next = null;
   }

   Node(int val, Node next) {
      this.val = new Integer(val);
      this.next = next;
   }

   public String toString() {
      return "Node [val=" + this.val + "]";
   }
}
