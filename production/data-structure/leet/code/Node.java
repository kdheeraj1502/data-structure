package leet.code;

public class Node {
   int val;
   Node next;

   Node() {
   }

   Node(int val) {
      this.val = val;
   }

   Node(int val, Node next) {
      this.val = val;
      this.next = next;
   }

   public String toString() {
      return "ListNode [val=" + this.val + "]";
   }
}
