package queue;

public class CustomQueueUsingLinkedList {
   private int size;
   private Node tail;

   public void add(int val) {
      Node node = new Node(val, (Node)null);
      if (this.tail == null) {
         this.tail = node;
         this.tail.next = this.tail;
      } else {
         node.next = this.tail.next;
         this.tail.next = node;
         this.tail = node;
      }

      ++this.size;
   }

   public int remove() {
      int val = true;
      int val;
      if (this.tail == this.tail.next) {
         val = this.tail.val;
         this.tail = null;
      } else {
         val = this.tail.next.val;
         this.tail.next = this.tail.next.next;
      }

      --this.size;
      return val;
   }

   public int peek() {
      int val = true;
      int val;
      if (this.tail == this.tail.next) {
         val = this.tail.val;
      } else {
         val = this.tail.next.val;
      }

      return val;
   }

   public boolean isEmpty() {
      return this.size == 0;
   }

   public int size() {
      return this.size;
   }

   public void print() {
      Node curr = this.tail.next;

      for(int i = this.size + 1; curr != null && i >= 0; curr = curr.next) {
         System.out.println(curr.val);
         --i;
      }

   }

   public static void main(String[] args) {
      CustomQueueUsingLinkedList cq = new CustomQueueUsingLinkedList();
      cq.add(5);
      cq.add(15);
      cq.add(20);
      System.out.println(cq.remove());
      System.out.println("-------------------");
      cq.print();
   }
}
