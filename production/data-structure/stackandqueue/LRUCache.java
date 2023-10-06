package stackandqueue;

import java.util.HashMap;

public class LRUCache {
   public static Node head = null;
   public static Node tail = null;
   public static HashMap<Integer, Node> map;
   public static int maxcap = 0;
   public static int size = 0;

   LRUCache(int cap) {
      maxcap = cap;
      map = new HashMap();
      head = new Node(0, 0);
      tail = new Node(0, 0);
      head.next = tail;
      tail.prev = head;
      head.prev = null;
      tail.next = null;
      size = 0;
   }

   public static int get(int key) {
      if (map.get(key) != null) {
         Node rv = (Node)map.get(key);
         remove(rv);
         addFirst(rv);
         return rv.value;
      } else {
         return -1;
      }
   }

   public static void set(int key, int value) {
      Node node;
      if (map.get(key) != null) {
         node = (Node)map.get(key);
         node.value = value;
         remove(node);
         addFirst(node);
      } else {
         node = new Node(key, value);
         map.put(key, node);
         if (size < maxcap) {
            ++size;
            addFirst(node);
         } else {
            map.remove(tail.prev.key);
            remove(tail.prev);
            addFirst(node);
         }
      }

   }

   public static void addFirst(Node node) {
      node.next = head.next;
      node.next.prev = node;
      node.prev = head;
      head.next = node;
   }

   public static void remove(Node node) {
      if (node.prev != null) {
         node.prev.next = node.next;
      }

      if (node.next != null) {
         node.next.prev = node.prev;
      }

   }
}
