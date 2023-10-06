package stackandqueue;

public class LRUCache$Node {
   int key;
   int value;
   LRUCache$Node prev;
   LRUCache$Node next;

   LRUCache$Node(int k, int v) {
      this.key = k;
      this.value = v;
      this.prev = null;
      this.next = null;
   }
}
