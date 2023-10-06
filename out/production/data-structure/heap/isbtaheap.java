package heap;

public class isbtaheap {
   private Node root = null;

   public static void main(String[] args) {
      isbtaheap i = new isbtaheap();
      System.out.println();
      System.out.println(isHeap(i.root));
   }

   public static boolean isHeap(Node root) {
      return isHeapmax(root) && iscomplete(root, noofnodes(root), 0);
   }

   public static boolean isHeapmax(Node root) {
      if (root == null) {
         return true;
      } else if (root.left != null && root.data < root.left.data || root.right != null && root.data < root.right.data) {
         return false;
      } else {
         boolean left = isHeapmax(root.left);
         boolean right = isHeapmax(root.right);
         return left && right;
      }
   }

   public static int noofnodes(Node root) {
      return root == null ? 0 : 1 + noofnodes(root.left) + noofnodes(root.right);
   }

   public static boolean iscomplete(Node root, int totalnodes, int index) {
      if (root == null) {
         return true;
      } else if (index > totalnodes) {
         return false;
      } else {
         return iscomplete(root.left, totalnodes, 2 * index + 1) && iscomplete(root.right, totalnodes, 2 * index + 2);
      }
   }
}
