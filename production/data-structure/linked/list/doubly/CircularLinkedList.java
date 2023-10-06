package linked.list.doubly;

public class CircularLinkedList {
   static int count = 0;

   public static void addTail(int val, DoubleLinkedList list) {
      Node node = new Node(val, (Node)null, (Node)null);
      if (list.getHead() == null) {
         list.setTail(node);
         list.setHead(node);
         node.next = list.getTail();
         list.setSize(++count);
      } else {
         node.next = list.getTail().next;
         list.getTail().next = node;
         list.setSize(++count);
      }

   }

   public static void addHead(int val, DoubleLinkedList list) {
      Node node = new Node(val, (Node)null, (Node)null);
      if (list.getHead() == null) {
         list.setHead(node);
         node.next = list.getHead();
         list.setTail(node);
         list.setSize(++count);
      } else {
         node.next = list.getHead().next;
         list.getHead().next = node;
         list.setSize(++count);
      }

   }

   public static int remove(DoubleLinkedList list) {
      int val = list.getTail().next.val;
      if (list.getTail() == list.getTail().next) {
         list.getTail().next = null;
      } else {
         list.getTail().next = list.getTail().next.next;
      }

      list.setSize(--count);
      return val;
   }

   public static void removeNode(DoubleLinkedList list, int val, int size) {
      if (list.getTail() == list.getTail().next) {
         if (list.getTail().val == val) {
            list.setTail((Node)null);
            list.setHead((Node)null);
         }
      } else {
         for(Node curr = list.getHead(); size > 0 && curr.next != null; curr = curr.next) {
            if (curr.next.val == val) {
               curr.next = curr.next.next;
               curr.next.prev = curr;
            }

            --size;
         }
      }

   }

   public static void removeNodeWithoutSize(DoubleLinkedList list, int val) {
      if (list.getTail() == list.getTail().next && list.getTail().val == val) {
         list.setTail((Node)null);
         list.setHead((Node)null);
      }

   }

   public static void main(String[] args) {
      DoubleLinkedList list = new DoubleLinkedList();
      addHead(32, list);
      addHead(26, list);
      addHead(17, list);
      addHead(13, list);
      addHead(9, list);
      Node head = list.getHead();
      Node curr = head;
      System.out.println(list.getSize());
      int i = 0;
      System.out.println("-------------nodes------------");

      while(i < 5 && curr.next != null) {
         System.out.println(curr.val);
         curr = curr.next;
         ++i;
      }

      System.out.println("----------remove--------");
      removeNodeWithoutSize(list, 17);
      i = 0;

      for(curr = head; i < 5 && curr.next != null; ++i) {
         System.out.println(curr.val);
         curr = curr.next;
      }

   }
}
