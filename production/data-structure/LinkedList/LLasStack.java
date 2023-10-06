package LinkedList;

public class LLasStack {
   private Node head = null;
   private Node tail = null;
   private int size = 0;

   public void push(int x) {
      Node node = new Node(this, (1)null);
      node.data = x;
      if (this.head == null) {
         this.head = node;
         this.tail = node;
         node.next = null;
      } else {
         node.next = this.head;
         this.head = node;
      }

      ++this.size;
   }

   public int peek() throws Exception {
      if (this.size == 0) {
         throw new Exception("Linked List is empty");
      } else {
         return this.head.data;
      }
   }

   public int pop() throws Exception {
      if (this.size == 0) {
         throw new Exception("Linked List is empty");
      } else {
         int rv = this.head.data;
         if (this.size == 1) {
            this.head = null;
            this.tail = null;
         } else {
            this.head = this.head.next;
         }

         --this.size;
         return rv;
      }
   }

   public void display() {
      Node temp = this.head;
      System.out.println("----------------------");

      while(temp != null) {
         System.out.print(temp.data + " ");
         temp = temp.next;
      }

      System.out.println();
      System.out.println("----------------------");
   }

   public static void main(String[] args) {
   }
}
