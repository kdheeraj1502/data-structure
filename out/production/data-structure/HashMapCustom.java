public class HashMapCustom<K, V> {
   HashMapCustom$Node<K, V>[] obj;
   int currSize;
   int size;

   HashMapCustom(int size) {
      this.obj = new HashMapCustom$Node[size];
      this.currSize = 0;
      this.size = size;
   }

   HashMapCustom$Node<K, V> newNode(K key, V value) {
      return new HashMapCustom$Node(key, value);
   }

   public void put(K key, V value) {
      int index = this.hash(key);
      HashMapCustom$Node<K, V> node = new HashMapCustom$Node(key, value);
      if (this.obj[index] == null) {
         this.obj[index] = node;
      } else if (this.obj[index] instanceof HashMapCustom$Node) {
         HashMapCustom$Node<K, V> temp = this.obj[index];

         HashMapCustom$Node curr;
         for(curr = temp; curr.next != null; curr = curr.next) {
         }

         curr.next = node;
      }

      ++this.currSize;
   }

   private int hash(Object key) {
      return key.hashCode() % this.size;
   }

   public Object get(Object key) {
      --this.currSize;
      return this.obj[this.hash(key)];
   }

   public static void main(String[] args) {
      HashMapCustom hmc = new HashMapCustom(10);
      Object key = new Integer(1);
      Object value = new String("One");
      hmc.put(key, value);
      System.out.println(hmc.get(key).toString());
      Object key1 = new Integer(1);
      Object value1 = new String("Two");
      hmc.put(key1, value1);
      System.out.println(hmc.get(key1).toString());
   }
}
