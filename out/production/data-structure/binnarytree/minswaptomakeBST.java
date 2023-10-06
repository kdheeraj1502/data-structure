package binnarytree;

import java.util.ArrayList;

public class minswaptomakeBST {
   public static void main(String[] args) {
      minswaptomakeBST m = new minswaptomakeBST();
      int[] arr = new int[]{5, 6, 7, 8, 9, 10, 11};
      m.getClass();
      BinaryTree tree = new BinaryTree(m, arr);
      tree.display();
      System.out.println();
      ArrayList<Integer> ans = new ArrayList();
      tree.inorder(binnarytree.minswaptomakeBST.BinaryTree.access$000(tree), ans);
      System.out.println(ans);
   }
}
