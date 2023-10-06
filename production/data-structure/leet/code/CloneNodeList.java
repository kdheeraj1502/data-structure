package leet.code;

public class CloneNodeList {
   public ListNode.Node copyRandomList(ListNode.Node head) {
      if (head == null) {
         return null;
      } else {
         ListNode.Node curr;
         ListNode.Node newHead;
         for(curr = head; curr != null; curr = curr.next.next) {
            newHead = new ListNode.Node(curr.val);
            newHead.next = curr.next;
            curr.next = newHead;
         }

         curr = head;
         newHead = new ListNode.Node(0);

         ListNode.Node newCurr;
         for(newCurr = newHead; curr != null; curr = curr.next.next) {
            if (curr.random != null) {
               curr.next.random = curr.random.next;
            }
         }

         for(curr = head; curr != null; curr = curr.next) {
            ListNode.Node tempNode = curr.next;
            curr.next = curr.next.next;
            newCurr.next = tempNode;
            newCurr = newCurr.next;
         }

         return newHead.next;
      }
   }

   public static void main(String[] args) {
      ListNode.Node ln = new ListNode.Node(1);
      ln.random = null;
      ln.next = new ListNode.Node(2);
      ln.next.random = new ListNode.Node(0);
      ln.next.next = new ListNode.Node(3);
      ln.next.next.random = new ListNode.Node(4);
      ln.next.next.next = new ListNode.Node(4);
      ln.next.next.next.random = new ListNode.Node(2);
      ln.next.next.next.next = new ListNode.Node(5);
      ln.next.next.next.next.random = new ListNode.Node(0);
      CloneNodeList cnl = new CloneNodeList();

      for(ListNode.Node node = cnl.copyRandomList(ln); node != null; node = node.next) {
         System.out.print(node + ", ");
      }

   }
}
