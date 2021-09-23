package binary.search;

import binary.search.NthPostOrder;
import binary.search.NthPreOrder;

public class BinaryTreeMain {

	public static void main(String[] args) {
		int num[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		CompleteBinaryTree.levelOrderBinaryTree(num);
		Node node = CompleteBinaryTree.getRoot();
		System.out.println("--------Level Order Top To Down---------");
		LevelOrderTraversal.levelOrderTopToDown(node);
		System.out.println();
		System.out.println("--------Level Order Down To Top---------");
		// LevelOrderTraversal.levelOrderDownToTop(node);
		System.out.println();
		System.out.println("--------In Order With Recursion---------");
		// InOrderTraversal.inOrder(node);
		System.out.println();
		System.out.println("--------In Order WithOut Recursion---------");
		// InOrderTraversal.inOrderWithOutRecursion(node);
		System.out.println();
		System.out.println("---------Level Order Top To Down Line By Line---------");
		// LevelOrderTraversal.levelOrderTopToDownLineByLine(node);
		System.out.println("--------Spiral Order---------");
		// SpiralTraversal.spiralOrder(node);
		System.out.println("--------Nth Pre Order Val---------");
		System.out.println(NthPreOrder.nthPreOrderNode(node, 4));
		System.out.println("--------Nth Post Order Val---------");
		System.out.println(NthPostOrder.nthPostOrderNode(node, 4));
		PostOrderTraversal.postOrder(node);
	}

}
