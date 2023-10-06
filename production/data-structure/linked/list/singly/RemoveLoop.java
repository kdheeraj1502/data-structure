package linked.list.singly;

public class RemoveLoop {
   public static void removeLoop(Node node, Node head) {
      Node a = node;
      Node b = node;

      int k;
      for(k = 1; a.next != b; ++k) {
         a = a.next;
      }

      a = head;
      b = head;

      for(int i = 0; i < k; ++i) {
         b = b.next;
      }

      while(a != b) {
         a = a.next;
         b = b.next;
      }

      while(b.next != a) {
         b = b.next;
      }

      b.next = null;
   }

   public static void main(String[] args) {
   }
}
