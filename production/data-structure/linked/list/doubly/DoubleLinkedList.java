package linked.list.doubly;

public class DoubleLinkedList {
   private Node head;
   private Node tail;
   private int size = 0;

   public int getSize() {
      return this.size;
   }

   public void setSize(int size) {
      this.size = size;
   }

   public Node getHead() {
      return this.head;
   }

   public void setHead(Node head) {
      this.head = head;
   }

   public Node getTail() {
      return this.tail;
   }

   public void setTail(Node tail) {
      this.tail = tail;
   }

   public void print(Node node) {
      if (node != null) {
         System.out.print(node.val + ", ");
         this.print(node.next);
      }
   }

   public void addHead(int val) {
      Node node = new Node(val, (Node)null, (Node)null);
      if (this.size == 0) {
         this.tail = this.head = node;
      } else {
         this.head.prev = node;
         node.next = this.head;
         this.head = node;
      }

      ++this.size;
   }

   public void addBack(int val) {
      Node node = new Node(val, (Node)null, (Node)null);
      if (this.size == 0) {
         this.tail = this.head = node;
      } else {
         this.tail.next = node;
         node.prev = this.tail;
         this.tail = node;
      }

      ++this.size;
   }

   public void sortedInsert(int val) {
      Node node = new Node(val, (Node)null, (Node)null);
      if (this.head == null) {
         this.tail = this.head = node;
      }

      if (this.head.next == null) {
         if (this.head.val > val) {
            this.addHead(val);
         } else {
            this.tail = node;
            this.head.next = node;
         }
      } else {
         for(Node curr = this.head; curr.next != null; curr = curr.next) {
            if (curr.next.val > val) {
               node.prev = curr;
               curr.next.prev = node;
               node.next = curr.next;
               curr.next = node;
               ++this.size;
               break;
            }
         }
      }

   }

   public int removeHead() {
      int val = this.head.val;
      this.head = this.head.next;
      this.head.prev = null;
      --this.size;
      return val;
   }

   public void removeNode(int val) {
      if (this.head.val == val) {
         this.removeHead();
      }

      if (this.head.next.val == val && this.head.next.next == null) {
         this.head.next = null;
      }

      for(Node curr = this.head; curr.next != null; curr = curr.next) {
         if (curr.next.val == val) {
            curr.next = curr.next.next;
            curr.next.prev = curr;
            break;
         }
      }

   }
}
