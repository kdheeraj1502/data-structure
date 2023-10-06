package binary.search;

public class NthPostOrder {
   public static int nthPostOrderNode(Node root, int index) {
      int[] counter = new int[]{0};
      return nthPostOrderNode(root, counter, index, -1);
   }

   private static int nthPostOrderNode(Node root, int[] counter, int index, int result) {
      if (result != -1) {
         root = null;
      }

      if (root != null) {
         result = nthPostOrderNode(root.left, counter, index, result);
         result = nthPostOrderNode(root.right, counter, index, result);
         int var10002 = counter[0]++;
         if (counter[0] == index) {
            result = root.val;
            return result;
         }
      }

      return result;
   }
}
