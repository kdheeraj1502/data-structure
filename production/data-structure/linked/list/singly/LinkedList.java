package linked.list.singly;

public class LinkedList {
   private Node head;

   public Node getHead() {
      return this.head;
   }

   public static LinkedList getInstance() {
      return new LinkedList();
   }

   public void addAtFront(int val) {
      Node node = new Node(val);
      node.next = this.head;
      this.head = node;
   }

   public void addAtTail(int val) {
      Node node = new Node(val, (Node)null);
      if (this.head == null) {
         this.head = node;
      } else {
         Node curr;
         for(curr = this.head; curr.next != null; curr = curr.next) {
         }

         curr.next = node;
      }
   }

   public static void print(Node node) {
      if (node != null) {
         System.out.print(node.val + ", ");
         print(node.next);
      }
   }

   public void sortedInsert(int val) {
      Node node = new Node(val);
      if (this.head == null) {
         this.head = node;
      }

      Node curr = this.head;

      while(curr.next != null) {
         curr = curr.next;
         if (curr.val > val) {
            break;
         }
      }

      Node next = curr.next;
      curr.next = node;
      node.next = next;
   }

   public boolean search(int val) {
      for(Node curr = this.head; curr != null; curr = curr.next) {
         if (curr.val == val) {
            return true;
         }
      }

      return false;
   }

   public void deleteNode(int val) {
      if (this.head.val == val) {
         this.head = this.head.next;
      }

      Node curr = this.head;

      while(curr.next != null) {
         if (curr.next.val == val) {
            Node next = curr.next.next;
            if (next != null) {
               curr.next = next;
            } else {
               curr.next = null;
            }
         } else {
            curr = curr.next;
         }
      }

   }

   public Node reverse() {
      Node curr = this.head;
      Node prev = null;
      Node next = null;
      if (curr.next == null) {
         return this.head;
      } else {
         while(curr.next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
         }

         curr.next = prev;
         return curr;
      }
   }

   public Node reverseRecursion(Node node) {
      if (node != null && node.next != null) {
         Node rest = this.reverseRecursion(node.next);
         node.next.next = node;
         node.next = null;
         return rest;
      } else {
         return node;
      }
   }

   public Node reverseRecursionUtil(Node curr, Node prev) {
      if (this.head == null) {
         return this.head;
      } else if (curr.next == null) {
         this.head = curr;
         curr.next = prev;
         return this.head;
      } else {
         Node next = curr.next;
         curr.next = prev;
         this.reverseRecursionUtil(next, curr);
         return this.head;
      }
   }

   public Node reverseRecursionUtilSelf(Node curr, Node prev) {
      Node node = null;
      if (curr == null) {
         return node;
      } else if (curr.next == null) {
         curr.next = prev;
         return curr;
      } else {
         Node next = curr.next;
         curr.next = prev;
         node = this.reverseRecursionUtilSelf(next, curr);
         return node;
      }
   }

   public void removeDUplicateFromSorted(Node node) {
   }

   public static void main(String[] args) {
      LinkedList instance = getInstance();
      instance.addAtFront(5);
      instance.addAtFront(4);
      instance.addAtFront(3);
      instance.addAtFront(2);
      instance.addAtFront(1);
      print(instance.head);
      print(ReverseLinkedList.reverse(instance.head));
      System.out.println();
      System.out.println();
      LinkedList instances = getInstance();
      instances.addAtTail(1);
      instances.addAtTail(2);
      instances.addAtTail(3);
      instances.addAtTail(4);
      instances.addAtTail(5);
      instances.addAtTail(6);
      Node curr = instances.head;

      Node fourNode;
      for(fourNode = null; curr.next != null; curr = curr.next) {
         if (curr.val == 4) {
            fourNode = curr;
         }
      }

      curr.next = fourNode;
      System.out.println();
      System.out.println("-------------Find loop--------------");
      DetectLoop.detectLoop(instances.head);
      System.out.println("-------------------");
      Node node = DetectLoop.detectLoop_SPFP(instances.head);
      RemoveLoop.removeLoop(node, instances.head);
      print(instances.head);
   }
}
