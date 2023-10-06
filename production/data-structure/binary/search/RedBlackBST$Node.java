package binary.search;

class RedBlackBST$Node {
   private Key key;
   private Value val;
   private RedBlackBST<Key, Value>.Node left;
   private RedBlackBST<Key, Value>.Node right;
   private boolean color;
   private int size;
   // $FF: synthetic field
   final RedBlackBST this$0;

   public RedBlackBST$Node(RedBlackBST var1, Comparable key, Object val, boolean color, int size) {
      this.this$0 = var1;
      this.key = key;
      this.val = val;
      this.color = color;
      this.size = size;
   }

   // $FF: synthetic method
   static boolean access$000(RedBlackBST$Node x0) {
      return x0.color;
   }

   // $FF: synthetic method
   static int access$100(RedBlackBST$Node x0) {
      return x0.size;
   }

   // $FF: synthetic method
   static Comparable access$200(RedBlackBST$Node x0) {
      return x0.key;
   }

   // $FF: synthetic method
   static RedBlackBST$Node access$300(RedBlackBST$Node x0) {
      return x0.left;
   }

   // $FF: synthetic method
   static RedBlackBST$Node access$400(RedBlackBST$Node x0) {
      return x0.right;
   }

   // $FF: synthetic method
   static Object access$500(RedBlackBST$Node x0) {
      return x0.val;
   }

   // $FF: synthetic method
   static boolean access$002(RedBlackBST$Node x0, boolean x1) {
      return x0.color = x1;
   }

   // $FF: synthetic method
   static RedBlackBST$Node access$302(RedBlackBST$Node x0, RedBlackBST$Node x1) {
      return x0.left = x1;
   }

   // $FF: synthetic method
   static RedBlackBST$Node access$402(RedBlackBST$Node x0, RedBlackBST$Node x1) {
      return x0.right = x1;
   }

   // $FF: synthetic method
   static Object access$502(RedBlackBST$Node x0, Object x1) {
      return x0.val = x1;
   }

   // $FF: synthetic method
   static int access$102(RedBlackBST$Node x0, int x1) {
      return x0.size = x1;
   }

   // $FF: synthetic method
   static Comparable access$202(RedBlackBST$Node x0, Comparable x1) {
      return x0.key = x1;
   }
}
