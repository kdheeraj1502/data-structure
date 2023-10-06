package stack;

class StackUsingLinkedList$Node<T> {
   private T val;
   private StackUsingLinkedList$Node next;

   StackUsingLinkedList$Node() {
   }

   StackUsingLinkedList$Node(T val) {
      this.val = val;
      this.next = null;
   }

   StackUsingLinkedList$Node(T val, StackUsingLinkedList$Node next) {
      this.val = val;
      this.next = next;
   }

   // $FF: synthetic method
   static StackUsingLinkedList$Node access$002(StackUsingLinkedList$Node x0, StackUsingLinkedList$Node x1) {
      return x0.next = x1;
   }

   // $FF: synthetic method
   static Object access$100(StackUsingLinkedList$Node x0) {
      return x0.val;
   }

   // $FF: synthetic method
   static StackUsingLinkedList$Node access$000(StackUsingLinkedList$Node x0) {
      return x0.next;
   }
}
