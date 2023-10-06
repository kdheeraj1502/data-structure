package LinkedList;

public class LinkedList {
   private Node head = null;
   private Node tail = null;
   private int size = 0;

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

   public void addLast(int x) {
      Node node = new Node(this, (1)null);
      node.data = x;
      node.next = null;
      if (this.head == null) {
         this.head = node;
      } else {
         this.tail.next = node;
      }

      this.tail = node;
      ++this.size;
   }

   public void addFirst(int x) {
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

   public int getfirst() throws Exception {
      if (this.size == 0) {
         throw new Exception("Linked List is empty");
      } else {
         return this.head.data;
      }
   }

   public int getlast() throws Exception {
      if (this.size == 0) {
         throw new Exception("Linked List is empty");
      } else {
         return this.tail.data;
      }
   }

   public int getAt(int i) throws Exception {
      if (this.size == 0) {
         throw new Exception("Linked List is empty");
      } else if (i >= 0 && i < this.size) {
         Node temp;
         for(temp = this.head; i > 0; --i) {
            temp = temp.next;
         }

         return temp.data;
      } else {
         throw new Exception("invalid index");
      }
   }

   private Node getNodeAt(int i) throws Exception {
      if (this.size == 0) {
         throw new Exception("Linked List is empty");
      } else if (i >= 0 && i < this.size) {
         Node temp;
         for(temp = this.head; i > 0; --i) {
            temp = temp.next;
         }

         return temp;
      } else {
         throw new Exception("invalid index");
      }
   }

   public void addAt(int x, int i) throws Exception {
      if (i >= 0 && i <= this.size) {
         if (i == 0) {
            this.addFirst(x);
         } else if (i == this.size) {
            this.addLast(x);
         } else {
            Node n = this.getNodeAt(i - 1);
            Node node = new Node(this, (1)null);
            node.data = x;
            node.next = n.next;
            n.next = node;
            ++this.size;
         }

      } else {
         throw new Exception("invalid index");
      }
   }

   public int removeFirst() throws Exception {
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

   public int removeLast() throws Exception {
      if (this.size == 0) {
         throw new Exception("Linked List is empty");
      } else {
         int rv = this.tail.data;
         if (this.size == 1) {
            this.head = null;
            this.tail = null;
         } else {
            this.tail = this.getNodeAt(this.size - 2);
            this.tail.next = null;
         }

         --this.size;
         return rv;
      }
   }

   public int removeAt(int i) throws Exception {
      if (i >= 0 && i <= this.size) {
         int rv = false;
         int rv;
         if (i == 0) {
            rv = this.removeFirst();
         } else if (i == this.size) {
            rv = this.removeLast();
         } else {
            Node n = this.getNodeAt(i - 1);
            rv = n.next.data;
            n.next = n.next.next;
            --this.size;
         }

         return rv;
      } else {
         throw new Exception("invalid index");
      }
   }

   public void reverseData() {
      int[] data = new int[this.size];
      Node temp = this.head;

      for(int i = 0; temp != null; temp = temp.next) {
         data[i] = temp.data;
         ++i;
      }

      int j = this.size - 1;

      for(temp = this.head; temp != null; temp = temp.next) {
         temp.data = data[j];
         --j;
      }

   }

   public void reversePointers() {
      Node prev = this.head;

      Node ahead;
      for(Node curr = prev.next; curr != null; curr = ahead) {
         ahead = curr.next;
         curr.next = prev;
         prev = curr;
      }

      ahead = this.head;
      this.head = this.tail;
      this.tail = ahead;
      this.tail.next = null;
   }

   public int getMid() {
      Node temp = this.head;

      for(Node temp2 = this.head; temp2.next != null && temp2.next.next != null; temp2 = temp2.next.next) {
         temp = temp.next;
      }

      return temp.data;
   }
}
