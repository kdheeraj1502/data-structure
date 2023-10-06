package leet.code;

public class RotateList {
   public Node rotateRight(Node head, int k) {
      Node nodeToReverse = null;
      int size = 0;

      for(Node curr = head; curr != null; curr = curr.next) {
         ++size;
      }

      if (size >= 2 && k % size != 0) {
         k %= size;
         int i = k;
         Node fastPtr = head;

         Node slowPtr;
         for(slowPtr = head; i-- > 0; fastPtr = fastPtr.next) {
         }

         while(fastPtr.next != null) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
         }

         nodeToReverse = slowPtr.next;
         slowPtr.next = null;
         Node tmpHead = head;

         for(head = nodeToReverse; nodeToReverse.next != null; nodeToReverse = nodeToReverse.next) {
         }

         nodeToReverse.next = tmpHead;
         return head;
      } else {
         return head;
      }
   }

   public static void main(String[] args) {
      RotateList rl = new RotateList();
      Node node = new Node(1);
      node.next = new Node(2);

      for(Node result = rl.rotateRight(node, 0); result != null; result = result.next) {
         System.out.println(result);
      }

   }
}
