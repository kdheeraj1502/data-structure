package binarysearchtree;

import java.util.Arrays;

public class targetsum2bst {
   public static void main(String[] args) {
      int[] arr1 = new int[]{897, 684, 585, 786, 188, 943, 980, 523, 39, 797, 281, 808, 739, 579, 118, 967, 256};
      int[] arr2 = new int[]{841, 991, 759, 722, 51, 752, 619, 870, 371, 649, 78, 871, 418, 326, 554, 2, 111, 93, 944, 91, 615, 334, 239, 896, 142, 977, 826, 259, 944, 433, 245, 136, 423, 3, 858};
      Arrays.sort(arr1);
      Arrays.sort(arr2);
      BST tree1 = new BST(arr1);
      tree1.display();
      BST tree2 = new BST(arr2);
      System.out.println();
      tree2.display();
      System.out.println();
      System.out.println(binarysearchtree.targetsum2bst.BST.countPairs(binarysearchtree.targetsum2bst.BST.access$000(tree1), binarysearchtree.targetsum2bst.BST.access$000(tree2), 825));
   }
}
