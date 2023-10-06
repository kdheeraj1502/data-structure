package stack;

public class StackUsingLinkedList<T> {
   private int size;
   private Node head = null;

   StackUsingLinkedList() {
   }

   public int getSize() {
      return this.size;
   }

   public boolean isEmpty() {
      return this.size == 0;
   }

   public void push(T val) {
      ++this.size;
      Node node = new Node(val, (Node)null);
      if (this.head == null) {
         this.head = node;
      } else {
         stack.StackUsingLinkedList.Node.access$002(node, this.head);
         this.head = node;
      }

   }

   public Object pop() {
      --this.size;
      Object val = null;
      if (this.size > 0) {
         val = stack.StackUsingLinkedList.Node.access$100(this.head);
         this.head = stack.StackUsingLinkedList.Node.access$000(this.head);
      } else {
         val = null;
      }

      return val;
   }

   public void print() {
      for(Node curr = this.head; curr != null; curr = stack.StackUsingLinkedList.Node.access$000(curr)) {
         System.out.print(stack.StackUsingLinkedList.Node.access$100(curr) + ", ");
      }

      System.out.println();
   }
}
