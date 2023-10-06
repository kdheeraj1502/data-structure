package linked.list.singly;

public class DetectLoopPoint {
   public Node detectCycle(Node head) {
      Node slow = head;
      Node fast = head;

      while(fast != null && fast.next != null) {
         fast = fast.next.next;
         slow = slow.next;
         if (fast == slow) {
            break;
         }
      }

      if (fast != null && fast.next != null) {
         for(slow = head; fast != slow; slow = slow.next) {
            fast = fast.next;
         }

         return slow;
      } else {
         return null;
      }
   }

   public static void main(String[] args) {
      LinkedList instances = LinkedList.getInstance();
      instances.addAtTail(1);
      instances.addAtTail(2);
      instances.addAtTail(3);
      instances.addAtTail(4);
      instances.addAtTail(5);
      instances.addAtTail(6);
      Node curr = instances.getHead();

      Node fourNode;
      for(fourNode = null; curr.next != null; curr = curr.next) {
         if (curr.val == 3) {
            fourNode = curr;
         }
      }

      curr.next = fourNode;
      DetectLoopPoint dp = new DetectLoopPoint();
      Node node1 = dp.detectCycle(instances.getHead());
      System.out.println(node1.val);
   }
}
