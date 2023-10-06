package binary.search;

class StringTree$Node {
   private String value;
   private int count;
   private StringTree$Node left;
   private StringTree$Node right;
   // $FF: synthetic field
   final StringTree this$0;

   private StringTree$Node(StringTree var1) {
      this.this$0 = var1;
   }

   private StringTree$Node(StringTree var1, String value) {
      this.this$0 = var1;
      this.value = value;
      this.count = 0;
      this.left = this.right = null;
   }

   // $FF: synthetic method
   static String access$000(StringTree$Node x0) {
      return x0.value;
   }

   // $FF: synthetic method
   static int access$100(StringTree$Node x0) {
      return x0.count;
   }

   // $FF: synthetic method
   static StringTree$Node access$200(StringTree$Node x0) {
      return x0.left;
   }

   // $FF: synthetic method
   static StringTree$Node access$300(StringTree$Node x0) {
      return x0.right;
   }

   // $FF: synthetic method
   StringTree$Node(StringTree x0, String x1, StringTree.1 x2) {
      this(x0, x1);
   }

   // $FF: synthetic method
   static int access$102(StringTree$Node x0, int x1) {
      return x0.count = x1;
   }

   // $FF: synthetic method
   static StringTree$Node access$202(StringTree$Node x0, StringTree$Node x1) {
      return x0.left = x1;
   }

   // $FF: synthetic method
   static StringTree$Node access$302(StringTree$Node x0, StringTree$Node x1) {
      return x0.right = x1;
   }

   // $FF: synthetic method
   static int access$108(StringTree$Node x0) {
      return x0.count++;
   }
}
