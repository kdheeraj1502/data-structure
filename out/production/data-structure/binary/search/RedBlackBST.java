package binary.search;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
   private static final boolean RED = true;
   private static final boolean BLACK = false;
   private RedBlackBST<Key, Value>.Node root;

   private boolean isRed(RedBlackBST<Key, Value>.Node x) {
      if (x == null) {
         return false;
      } else {
         return binary.search.RedBlackBST.Node.access$000(x);
      }
   }

   private int size(RedBlackBST<Key, Value>.Node x) {
      return x == null ? 0 : binary.search.RedBlackBST.Node.access$100(x);
   }

   public int size() {
      return this.size(this.root);
   }

   public boolean isEmpty() {
      return this.root == null;
   }

   public Value get(Key key) {
      if (key == null) {
         throw new IllegalArgumentException("argument to get() is null");
      } else {
         return this.get(this.root, key);
      }
   }

   private Value get(RedBlackBST<Key, Value>.Node x, Key key) {
      while(true) {
         if (x != null) {
            int cmp = key.compareTo(binary.search.RedBlackBST.Node.access$200(x));
            if (cmp < 0) {
               x = binary.search.RedBlackBST.Node.access$300(x);
               continue;
            }

            if (cmp > 0) {
               x = binary.search.RedBlackBST.Node.access$400(x);
               continue;
            }

            return binary.search.RedBlackBST.Node.access$500(x);
         }

         return null;
      }
   }

   public boolean contains(Key key) {
      return this.get(key) != null;
   }

   public void put(Key key, Value val) {
      if (key == null) {
         throw new IllegalArgumentException("first argument to put() is null");
      } else if (val == null) {
         this.delete(key);
      } else {
         this.root = this.put(this.root, key, val);
         binary.search.RedBlackBST.Node.access$002(this.root, false);
      }
   }

   private RedBlackBST<Key, Value>.Node put(RedBlackBST<Key, Value>.Node h, Key key, Value val) {
      if (h == null) {
         return new Node(this, key, val, true, 1);
      } else {
         int cmp = key.compareTo(binary.search.RedBlackBST.Node.access$200(h));
         if (cmp < 0) {
            binary.search.RedBlackBST.Node.access$302(h, this.put(binary.search.RedBlackBST.Node.access$300(h), key, val));
         } else if (cmp > 0) {
            binary.search.RedBlackBST.Node.access$402(h, this.put(binary.search.RedBlackBST.Node.access$400(h), key, val));
         } else {
            binary.search.RedBlackBST.Node.access$502(h, val);
         }

         if (this.isRed(binary.search.RedBlackBST.Node.access$400(h)) && !this.isRed(binary.search.RedBlackBST.Node.access$300(h))) {
            h = this.rotateLeft(h);
         }

         if (this.isRed(binary.search.RedBlackBST.Node.access$300(h)) && this.isRed(binary.search.RedBlackBST.Node.access$300(binary.search.RedBlackBST.Node.access$300(h)))) {
            h = this.rotateRight(h);
         }

         if (this.isRed(binary.search.RedBlackBST.Node.access$300(h)) && this.isRed(binary.search.RedBlackBST.Node.access$400(h))) {
            this.flipColors(h);
         }

         binary.search.RedBlackBST.Node.access$102(h, this.size(binary.search.RedBlackBST.Node.access$300(h)) + this.size(binary.search.RedBlackBST.Node.access$400(h)) + 1);
         return h;
      }
   }

   public void deleteMin() {
      if (this.isEmpty()) {
         throw new NoSuchElementException("BST underflow");
      } else {
         if (!this.isRed(binary.search.RedBlackBST.Node.access$300(this.root)) && !this.isRed(binary.search.RedBlackBST.Node.access$400(this.root))) {
            binary.search.RedBlackBST.Node.access$002(this.root, true);
         }

         this.root = this.deleteMin(this.root);
         if (!this.isEmpty()) {
            binary.search.RedBlackBST.Node.access$002(this.root, false);
         }

      }
   }

   private RedBlackBST<Key, Value>.Node deleteMin(RedBlackBST<Key, Value>.Node h) {
      if (binary.search.RedBlackBST.Node.access$300(h) == null) {
         return null;
      } else {
         if (!this.isRed(binary.search.RedBlackBST.Node.access$300(h)) && !this.isRed(binary.search.RedBlackBST.Node.access$300(binary.search.RedBlackBST.Node.access$300(h)))) {
            h = this.moveRedLeft(h);
         }

         binary.search.RedBlackBST.Node.access$302(h, this.deleteMin(binary.search.RedBlackBST.Node.access$300(h)));
         return this.balance(h);
      }
   }

   public void deleteMax() {
      if (this.isEmpty()) {
         throw new NoSuchElementException("BST underflow");
      } else {
         if (!this.isRed(binary.search.RedBlackBST.Node.access$300(this.root)) && !this.isRed(binary.search.RedBlackBST.Node.access$400(this.root))) {
            binary.search.RedBlackBST.Node.access$002(this.root, true);
         }

         this.root = this.deleteMax(this.root);
         if (!this.isEmpty()) {
            binary.search.RedBlackBST.Node.access$002(this.root, false);
         }

      }
   }

   private RedBlackBST<Key, Value>.Node deleteMax(RedBlackBST<Key, Value>.Node h) {
      if (this.isRed(binary.search.RedBlackBST.Node.access$300(h))) {
         h = this.rotateRight(h);
      }

      if (binary.search.RedBlackBST.Node.access$400(h) == null) {
         return null;
      } else {
         if (!this.isRed(binary.search.RedBlackBST.Node.access$400(h)) && !this.isRed(binary.search.RedBlackBST.Node.access$300(binary.search.RedBlackBST.Node.access$400(h)))) {
            h = this.moveRedRight(h);
         }

         binary.search.RedBlackBST.Node.access$402(h, this.deleteMax(binary.search.RedBlackBST.Node.access$400(h)));
         return this.balance(h);
      }
   }

   public void delete(Key key) {
      if (key == null) {
         throw new IllegalArgumentException("argument to delete() is null");
      } else if (this.contains(key)) {
         if (!this.isRed(binary.search.RedBlackBST.Node.access$300(this.root)) && !this.isRed(binary.search.RedBlackBST.Node.access$400(this.root))) {
            binary.search.RedBlackBST.Node.access$002(this.root, true);
         }

         this.root = this.delete(this.root, key);
         if (!this.isEmpty()) {
            binary.search.RedBlackBST.Node.access$002(this.root, false);
         }

      }
   }

   private RedBlackBST<Key, Value>.Node delete(RedBlackBST<Key, Value>.Node h, Key key) {
      if (key.compareTo(binary.search.RedBlackBST.Node.access$200(h)) < 0) {
         if (!this.isRed(binary.search.RedBlackBST.Node.access$300(h)) && !this.isRed(binary.search.RedBlackBST.Node.access$300(binary.search.RedBlackBST.Node.access$300(h)))) {
            h = this.moveRedLeft(h);
         }

         binary.search.RedBlackBST.Node.access$302(h, this.delete(binary.search.RedBlackBST.Node.access$300(h), key));
      } else {
         if (this.isRed(binary.search.RedBlackBST.Node.access$300(h))) {
            h = this.rotateRight(h);
         }

         if (key.compareTo(binary.search.RedBlackBST.Node.access$200(h)) == 0 && binary.search.RedBlackBST.Node.access$400(h) == null) {
            return null;
         }

         if (!this.isRed(binary.search.RedBlackBST.Node.access$400(h)) && !this.isRed(binary.search.RedBlackBST.Node.access$300(binary.search.RedBlackBST.Node.access$400(h)))) {
            h = this.moveRedRight(h);
         }

         if (key.compareTo(binary.search.RedBlackBST.Node.access$200(h)) == 0) {
            RedBlackBST<Key, Value>.Node x = this.min(binary.search.RedBlackBST.Node.access$400(h));
            binary.search.RedBlackBST.Node.access$202(h, binary.search.RedBlackBST.Node.access$200(x));
            binary.search.RedBlackBST.Node.access$502(h, binary.search.RedBlackBST.Node.access$500(x));
            binary.search.RedBlackBST.Node.access$402(h, this.deleteMin(binary.search.RedBlackBST.Node.access$400(h)));
         } else {
            binary.search.RedBlackBST.Node.access$402(h, this.delete(binary.search.RedBlackBST.Node.access$400(h), key));
         }
      }

      return this.balance(h);
   }

   private RedBlackBST<Key, Value>.Node rotateRight(RedBlackBST<Key, Value>.Node h) {
      assert h != null && this.isRed(binary.search.RedBlackBST.Node.access$300(h));

      RedBlackBST<Key, Value>.Node x = binary.search.RedBlackBST.Node.access$300(h);
      binary.search.RedBlackBST.Node.access$302(h, binary.search.RedBlackBST.Node.access$400(x));
      binary.search.RedBlackBST.Node.access$402(x, h);
      binary.search.RedBlackBST.Node.access$002(x, binary.search.RedBlackBST.Node.access$000(binary.search.RedBlackBST.Node.access$400(x)));
      binary.search.RedBlackBST.Node.access$002(binary.search.RedBlackBST.Node.access$400(x), true);
      binary.search.RedBlackBST.Node.access$102(x, binary.search.RedBlackBST.Node.access$100(h));
      binary.search.RedBlackBST.Node.access$102(h, this.size(binary.search.RedBlackBST.Node.access$300(h)) + this.size(binary.search.RedBlackBST.Node.access$400(h)) + 1);
      return x;
   }

   private RedBlackBST<Key, Value>.Node rotateLeft(RedBlackBST<Key, Value>.Node h) {
      assert h != null && this.isRed(binary.search.RedBlackBST.Node.access$400(h));

      RedBlackBST<Key, Value>.Node x = binary.search.RedBlackBST.Node.access$400(h);
      binary.search.RedBlackBST.Node.access$402(h, binary.search.RedBlackBST.Node.access$300(x));
      binary.search.RedBlackBST.Node.access$302(x, h);
      binary.search.RedBlackBST.Node.access$002(x, binary.search.RedBlackBST.Node.access$000(binary.search.RedBlackBST.Node.access$300(x)));
      binary.search.RedBlackBST.Node.access$002(binary.search.RedBlackBST.Node.access$300(x), true);
      binary.search.RedBlackBST.Node.access$102(x, binary.search.RedBlackBST.Node.access$100(h));
      binary.search.RedBlackBST.Node.access$102(h, this.size(binary.search.RedBlackBST.Node.access$300(h)) + this.size(binary.search.RedBlackBST.Node.access$400(h)) + 1);
      return x;
   }

   private void flipColors(RedBlackBST<Key, Value>.Node h) {
      binary.search.RedBlackBST.Node.access$002(h, !binary.search.RedBlackBST.Node.access$000(h));
      binary.search.RedBlackBST.Node.access$002(binary.search.RedBlackBST.Node.access$300(h), !binary.search.RedBlackBST.Node.access$000(binary.search.RedBlackBST.Node.access$300(h)));
      binary.search.RedBlackBST.Node.access$002(binary.search.RedBlackBST.Node.access$400(h), !binary.search.RedBlackBST.Node.access$000(binary.search.RedBlackBST.Node.access$400(h)));
   }

   private RedBlackBST<Key, Value>.Node moveRedLeft(RedBlackBST<Key, Value>.Node h) {
      this.flipColors(h);
      if (this.isRed(binary.search.RedBlackBST.Node.access$300(binary.search.RedBlackBST.Node.access$400(h)))) {
         binary.search.RedBlackBST.Node.access$402(h, this.rotateRight(binary.search.RedBlackBST.Node.access$400(h)));
         h = this.rotateLeft(h);
         this.flipColors(h);
      }

      return h;
   }

   private RedBlackBST<Key, Value>.Node moveRedRight(RedBlackBST<Key, Value>.Node h) {
      this.flipColors(h);
      if (this.isRed(binary.search.RedBlackBST.Node.access$300(binary.search.RedBlackBST.Node.access$300(h)))) {
         h = this.rotateRight(h);
         this.flipColors(h);
      }

      return h;
   }

   private RedBlackBST<Key, Value>.Node balance(RedBlackBST<Key, Value>.Node h) {
      if (this.isRed(binary.search.RedBlackBST.Node.access$400(h)) && !this.isRed(binary.search.RedBlackBST.Node.access$300(h))) {
         h = this.rotateLeft(h);
      }

      if (this.isRed(binary.search.RedBlackBST.Node.access$300(h)) && this.isRed(binary.search.RedBlackBST.Node.access$300(binary.search.RedBlackBST.Node.access$300(h)))) {
         h = this.rotateRight(h);
      }

      if (this.isRed(binary.search.RedBlackBST.Node.access$300(h)) && this.isRed(binary.search.RedBlackBST.Node.access$400(h))) {
         this.flipColors(h);
      }

      binary.search.RedBlackBST.Node.access$102(h, this.size(binary.search.RedBlackBST.Node.access$300(h)) + this.size(binary.search.RedBlackBST.Node.access$400(h)) + 1);
      return h;
   }

   public int height() {
      return this.height(this.root);
   }

   private int height(RedBlackBST<Key, Value>.Node x) {
      return x == null ? -1 : 1 + Math.max(this.height(binary.search.RedBlackBST.Node.access$300(x)), this.height(binary.search.RedBlackBST.Node.access$400(x)));
   }

   public Key min() {
      if (this.isEmpty()) {
         throw new NoSuchElementException("calls min() with empty symbol table");
      } else {
         return binary.search.RedBlackBST.Node.access$200(this.min(this.root));
      }
   }

   private RedBlackBST<Key, Value>.Node min(RedBlackBST<Key, Value>.Node x) {
      return binary.search.RedBlackBST.Node.access$300(x) == null ? x : this.min(binary.search.RedBlackBST.Node.access$300(x));
   }

   public Key max() {
      if (this.isEmpty()) {
         throw new NoSuchElementException("calls max() with empty symbol table");
      } else {
         return binary.search.RedBlackBST.Node.access$200(this.max(this.root));
      }
   }

   private RedBlackBST<Key, Value>.Node max(RedBlackBST<Key, Value>.Node x) {
      return binary.search.RedBlackBST.Node.access$400(x) == null ? x : this.max(binary.search.RedBlackBST.Node.access$400(x));
   }

   public Key floor(Key key) {
      if (key == null) {
         throw new IllegalArgumentException("argument to floor() is null");
      } else if (this.isEmpty()) {
         throw new NoSuchElementException("calls floor() with empty symbol table");
      } else {
         RedBlackBST<Key, Value>.Node x = this.floor(this.root, key);
         if (x == null) {
            throw new NoSuchElementException("argument to floor() is too small");
         } else {
            return binary.search.RedBlackBST.Node.access$200(x);
         }
      }
   }

   private RedBlackBST<Key, Value>.Node floor(RedBlackBST<Key, Value>.Node x, Key key) {
      if (x == null) {
         return null;
      } else {
         int cmp = key.compareTo(binary.search.RedBlackBST.Node.access$200(x));
         if (cmp == 0) {
            return x;
         } else if (cmp < 0) {
            return this.floor(binary.search.RedBlackBST.Node.access$300(x), key);
         } else {
            RedBlackBST<Key, Value>.Node t = this.floor(binary.search.RedBlackBST.Node.access$400(x), key);
            return t != null ? t : x;
         }
      }
   }

   public Key ceiling(Key key) {
      if (key == null) {
         throw new IllegalArgumentException("argument to ceiling() is null");
      } else if (this.isEmpty()) {
         throw new NoSuchElementException("calls ceiling() with empty symbol table");
      } else {
         RedBlackBST<Key, Value>.Node x = this.ceiling(this.root, key);
         if (x == null) {
            throw new NoSuchElementException("argument to ceiling() is too small");
         } else {
            return binary.search.RedBlackBST.Node.access$200(x);
         }
      }
   }

   private RedBlackBST<Key, Value>.Node ceiling(RedBlackBST<Key, Value>.Node x, Key key) {
      if (x == null) {
         return null;
      } else {
         int cmp = key.compareTo(binary.search.RedBlackBST.Node.access$200(x));
         if (cmp == 0) {
            return x;
         } else if (cmp > 0) {
            return this.ceiling(binary.search.RedBlackBST.Node.access$400(x), key);
         } else {
            RedBlackBST<Key, Value>.Node t = this.ceiling(binary.search.RedBlackBST.Node.access$300(x), key);
            return t != null ? t : x;
         }
      }
   }

   public Key select(int rank) {
      if (rank >= 0 && rank < this.size()) {
         return this.select(this.root, rank);
      } else {
         throw new IllegalArgumentException("argument to select() is invalid: " + rank);
      }
   }

   private Key select(RedBlackBST<Key, Value>.Node x, int rank) {
      if (x == null) {
         return null;
      } else {
         int leftSize = this.size(binary.search.RedBlackBST.Node.access$300(x));
         if (leftSize > rank) {
            return this.select(binary.search.RedBlackBST.Node.access$300(x), rank);
         } else {
            return leftSize < rank ? this.select(binary.search.RedBlackBST.Node.access$400(x), rank - leftSize - 1) : binary.search.RedBlackBST.Node.access$200(x);
         }
      }
   }

   public int rank(Key key) {
      if (key == null) {
         throw new IllegalArgumentException("argument to rank() is null");
      } else {
         return this.rank(key, this.root);
      }
   }

   private int rank(Key key, RedBlackBST<Key, Value>.Node x) {
      if (x == null) {
         return 0;
      } else {
         int cmp = key.compareTo(binary.search.RedBlackBST.Node.access$200(x));
         if (cmp < 0) {
            return this.rank(key, binary.search.RedBlackBST.Node.access$300(x));
         } else {
            return cmp > 0 ? 1 + this.size(binary.search.RedBlackBST.Node.access$300(x)) + this.rank(key, binary.search.RedBlackBST.Node.access$400(x)) : this.size(binary.search.RedBlackBST.Node.access$300(x));
         }
      }
   }

   public Iterable<Key> keys() {
      return (Iterable)(this.isEmpty() ? new PriorityQueue() : this.keys(this.min(), this.max()));
   }

   public Iterable<Key> keys(Key lo, Key hi) {
      if (lo == null) {
         throw new IllegalArgumentException("first argument to keys() is null");
      } else if (hi == null) {
         throw new IllegalArgumentException("second argument to keys() is null");
      } else {
         Queue<Key> queue = new PriorityQueue();
         this.keys(this.root, queue, lo, hi);
         return queue;
      }
   }

   private void keys(RedBlackBST<Key, Value>.Node x, Queue<Key> queue, Key lo, Key hi) {
      if (x != null) {
         int cmplo = lo.compareTo(binary.search.RedBlackBST.Node.access$200(x));
         int cmphi = hi.compareTo(binary.search.RedBlackBST.Node.access$200(x));
         if (cmplo < 0) {
            this.keys(binary.search.RedBlackBST.Node.access$300(x), queue, lo, hi);
         }

         if (cmplo <= 0 && cmphi >= 0) {
            queue.add(binary.search.RedBlackBST.Node.access$200(x));
         }

         if (cmphi > 0) {
            this.keys(binary.search.RedBlackBST.Node.access$400(x), queue, lo, hi);
         }

      }
   }

   public int size(Key lo, Key hi) {
      if (lo == null) {
         throw new IllegalArgumentException("first argument to size() is null");
      } else if (hi == null) {
         throw new IllegalArgumentException("second argument to size() is null");
      } else if (lo.compareTo(hi) > 0) {
         return 0;
      } else {
         return this.contains(hi) ? this.rank(hi) - this.rank(lo) + 1 : this.rank(hi) - this.rank(lo);
      }
   }

   private boolean check() {
      if (!this.isBST()) {
         System.out.println("Not in symmetric order");
      }

      if (!this.isSizeConsistent()) {
         System.out.println("Subtree counts not consistent");
      }

      if (!this.isRankConsistent()) {
         System.out.println("Ranks not consistent");
      }

      if (!this.is23()) {
         System.out.println("Not a 2-3 tree");
      }

      if (!this.isBalanced()) {
         System.out.println("Not balanced");
      }

      return this.isBST() && this.isSizeConsistent() && this.isRankConsistent() && this.is23() && this.isBalanced();
   }

   private boolean isBST() {
      return this.isBST(this.root, (Comparable)null, (Comparable)null);
   }

   private boolean isBST(RedBlackBST<Key, Value>.Node x, Key min, Key max) {
      if (x == null) {
         return true;
      } else if (min != null && binary.search.RedBlackBST.Node.access$200(x).compareTo(min) <= 0) {
         return false;
      } else if (max != null && binary.search.RedBlackBST.Node.access$200(x).compareTo(max) >= 0) {
         return false;
      } else {
         return this.isBST(binary.search.RedBlackBST.Node.access$300(x), min, binary.search.RedBlackBST.Node.access$200(x)) && this.isBST(binary.search.RedBlackBST.Node.access$400(x), binary.search.RedBlackBST.Node.access$200(x), max);
      }
   }

   private boolean isSizeConsistent() {
      return this.isSizeConsistent(this.root);
   }

   private boolean isSizeConsistent(RedBlackBST<Key, Value>.Node x) {
      if (x == null) {
         return true;
      } else if (binary.search.RedBlackBST.Node.access$100(x) != this.size(binary.search.RedBlackBST.Node.access$300(x)) + this.size(binary.search.RedBlackBST.Node.access$400(x)) + 1) {
         return false;
      } else {
         return this.isSizeConsistent(binary.search.RedBlackBST.Node.access$300(x)) && this.isSizeConsistent(binary.search.RedBlackBST.Node.access$400(x));
      }
   }

   private boolean isRankConsistent() {
      for(int i = 0; i < this.size(); ++i) {
         if (i != this.rank(this.select(i))) {
            return false;
         }
      }

      Iterator var3 = this.keys().iterator();

      Comparable key;
      do {
         if (!var3.hasNext()) {
            return true;
         }

         key = (Comparable)var3.next();
      } while(key.compareTo(this.select(this.rank(key))) == 0);

      return false;
   }

   private boolean is23() {
      return this.is23(this.root);
   }

   private boolean is23(RedBlackBST<Key, Value>.Node x) {
      if (x == null) {
         return true;
      } else if (this.isRed(binary.search.RedBlackBST.Node.access$400(x))) {
         return false;
      } else if (x != this.root && this.isRed(x) && this.isRed(binary.search.RedBlackBST.Node.access$300(x))) {
         return false;
      } else {
         return this.is23(binary.search.RedBlackBST.Node.access$300(x)) && this.is23(binary.search.RedBlackBST.Node.access$400(x));
      }
   }

   private boolean isBalanced() {
      int black = 0;

      for(RedBlackBST<Key, Value>.Node x = this.root; x != null; x = binary.search.RedBlackBST.Node.access$300(x)) {
         if (!this.isRed(x)) {
            ++black;
         }
      }

      return this.isBalanced(this.root, black);
   }

   private boolean isBalanced(RedBlackBST<Key, Value>.Node x, int black) {
      if (x == null) {
         return black == 0;
      } else {
         if (!this.isRed(x)) {
            --black;
         }

         return this.isBalanced(binary.search.RedBlackBST.Node.access$300(x), black) && this.isBalanced(binary.search.RedBlackBST.Node.access$400(x), black);
      }
   }

   public static void main(String[] args) {
      RedBlackBST<String, Integer> st = new RedBlackBST();
      st.put("one", 1);
      System.out.println();
      Iterator var2 = st.keys().iterator();

      while(var2.hasNext()) {
         String s = (String)var2.next();
         System.out.println(s + " " + st.get(s));
      }

      System.out.println();
   }
}
