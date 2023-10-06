package linked.list.singly;

public class FindIntersectionLinkedList {
   public static Node findInteresection(Node head1, Node head2) {
      int len1 = 0;
      int len2 = 0;
      Node node1 = head1;

      Node node2;
      for(node2 = head2; node1 != null; node1 = node1.next) {
         ++len1;
      }

      while(node2 != null) {
         ++len2;
         node2 = node2.next;
      }

      int diff = false;
      Node tempSmall = null;
      Node tempLarge = null;
      int diff;
      if (len1 < len2) {
         diff = len2 - len2;
         tempSmall = head1;
         tempLarge = head2;
      } else {
         diff = len1 - len2;
         tempSmall = head2;
         tempLarge = head1;
      }

      while(diff > 0) {
         tempLarge = tempLarge.next;
         --diff;
      }

      while(tempSmall != tempLarge) {
         tempSmall = tempSmall.next;
         tempLarge = tempLarge.next;
      }

      return tempSmall;
   }

   public static void main(String[] args) {
      LinkedList list1 = new LinkedList();
      LinkedList list2 = new LinkedList();
      LinkedList list3 = new LinkedList();
      list1.addAtTail(3);
      list1.addAtTail(6);
      list1.addAtTail(9);
      list3.addAtTail(15);
      list3.addAtTail(30);
      list2.addAtTail(10);
      list2.addAtTail(16);
      Node node1 = list1.getHead();
      Node node2 = list2.getHead();

      Node node3;
      for(node3 = list3.getHead(); node1.next != null; node1 = node1.next) {
      }

      while(node2.next != null) {
         node2 = node2.next;
      }

      node1.next = node3;
      node2.next = node3;
      Node result = findInteresection(list1.getHead(), list2.getHead());
      LinkedList.getInstance();
      LinkedList.print(result);
   }
}
