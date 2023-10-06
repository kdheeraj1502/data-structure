package linked.list.singly;

public class ReverseLinkedList {
   public static Node reverse(Node node) {
      Node result = null;
      if (node != null && node.next != null) {
         result = reverse(node.next);
         node.next.next = node;
         node.next = null;
         return result;
      } else {
         return node;
      }
   }

   public static Node reverse_self(Node node) {
      Node result = null;
      if (node != null && node.next != null) {
         result = reverse_self(node.next);
         node.next.next = node;
         node.next = null;
         return result;
      } else {
         return node;
      }
   }

   public static Node reverse_without_recursion(Node node) {
      Node temp = node;
      Node next = null;

      Node prev;
      for(prev = null; temp != null; temp = next) {
         next = temp.next;
         temp.next = prev;
         prev = temp;
      }

      return prev;
   }
}
