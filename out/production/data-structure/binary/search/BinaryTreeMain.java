package binary.search;

public class BinaryTreeMain {
   public static void main(String[] args) {
      int[] num = new int[]{1, 2, 3, 98, 45, 78, 65, 4, 5, 6, 7, 8, 9, 10};
      CompleteBinaryTree.levelOrderBinaryTree(num);
      Node node = CompleteBinaryTree.getRoot();
      System.out.println("--------Level Order Top To Down---------");
      LevelOrderTraversal.levelOrderTopToDown(node);
      System.out.println();
      int depth = TreeDepth.treeDepthWithoutRecursion(node);
      System.out.println("depth is " + depth);
      System.out.println("--------Level Order Down To Top---------");
      System.out.println("--------In Order WithOut Recursion---------");
      System.out.println("---------Level Order Top To Down Line By Line---------");
      System.out.println("--------Spiral Order---------");
      System.out.println("--------Nth Pre Order Val---------");
      System.out.println("--------Nth Post Order Val---------");
      System.out.println("--------Nth In Order Val---------");
      System.out.println("--------Print all path---------");
      PrintAllPath.printAllPath(node);
      System.out.println("--------Num Of Nodes---------");
      System.out.println("--------search val---------");
      System.out.println("--------search val---------");
      System.out.println("--------Copy Tree---------------------");
      Node copy = CopyTree.copyTree(node);
      LevelOrderTraversal.levelOrderTopToDown(copy);
      int[] num1 = new int[]{13, 15, 17, 19, 21, 23, 25, 27, 29, 31};
      Node tree = BinaryTreeFromSortedList.createBinaryTree(num1);
      System.out.println("--------Check if it is binary tree---------");
      System.out.println(IsTreeBinary.isBinary(node));
      Node tree2 = DeleteNode.delete(tree, 16);
      System.out.println("--------Level Order Top To Down---------");
      LevelOrderTraversal.levelOrderTopToDown(tree2);
      System.out.println("--------Least Common Ancestor---------");
      System.out.println(LeastCommonAncestor.leastCommonAncestor(tree, 17, 19));
      System.out.println();
      System.out.println("--------Ceil Of BST---------");
      System.out.print(CeilBST.ceilBST(tree, 16) + ", ");
      System.out.println();
      System.out.println("--------Floor Of BST---------");
      System.out.print(FLoorBST.floorBST(tree, 16) + ", ");
      System.out.println();
      System.out.println("--------Trim outside range---------");
      Node tree3 = TrimOutSodeRange.tripOutsideRange(tree, 19, 27);
      LevelOrderTraversal.levelOrderTopToDown(tree3);
      System.out.println("--------Print in range Nodes---------");
      PrintTreeNodesOfRange.print(tree, 19, 27);
   }
}
