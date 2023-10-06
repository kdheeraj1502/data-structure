class HashMapCustom$Node<K, V> {
   final V val;
   final K key;
   HashMapCustom$Node next;

   HashMapCustom$Node(K key, V val) {
      this.val = val;
      this.key = key;
      this.next = null;
   }

   public String toString() {
      return "Node{val=" + this.val + ", key=" + this.key + ", next=" + this.next + '}';
   }
}
