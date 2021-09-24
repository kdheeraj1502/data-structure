package binary.search;

import binary.search.NthPostOrder;
import binary.search.NthPreOrder;

public class BinaryTreeMain {

	public static void main(String[] args) {
		int num[] = { 1, 2, 3, 98, 45, 78, 65, 4, 5, 6, 7, 8, 9, 10 };
		CompleteBinaryTree.levelOrderBinaryTree(num);
		Node node = CompleteBinaryTree.getRoot();
		System.out.println("--------Level Order Top To Down---------");
		LevelOrderTraversal.levelOrderTopToDown(node);
		System.out.println("--------Level Order Down To Top---------");
		// LevelOrderTraversal.levelOrderDownToTop(node);
		System.out.println("--------In Order WithOut Recursion---------");
		// InOrderTraversal.inOrderWithOutRecursion(node);
		System.out.println("---------Level Order Top To Down Line By Line---------");
		// LevelOrderTraversal.levelOrderTopToDownLineByLine(node);
		System.out.println("--------Spiral Order---------");
		// SpiralTraversal.spiralOrder(node);
		System.out.println("--------Nth Pre Order Val---------");
		// System.out.println(NthPreOrder.nthPreOrderNode(node, 4));
		System.out.println("--------Nth Post Order Val---------");
		// System.out.println(NthPostOrder.nthPostOrderNode(node, 4));
		// PostOrderTraversal.postOrder(node);
		System.out.println("--------Nth In Order Val---------");
		// System.out.println(NthInOrder.nThInOrder(node, 9));
		// InOrderTraversal.inOrder(node);
		// PrintAllPath.printAllPath(node);
		System.out.println("--------Num Of Nodes---------");
		// System.out.println(NumOfNodes.numOfNodes(node));
		// System.out.println("--------Sum Of Nodes---------");
		// System.out.println(SumAllNodes.sumAllNodes(node));
		// System.out.println("--------Num Of Leaf Nodes---------");
		// System.out.println(NumOfLeafNodes.numOfLeafNodesWithoutStack(node));
		System.out.println("--------search val---------");
	//	System.out.println(SearchValInTree.search(node, 2));
		System.out.println("--------search val---------");
	//	System.out.println(FindMaxVal.findMax(node, "parent"));
		System.out.println("--------Tree Depth---------");
		System.out.println(TreeDepth.treeDepth(node));
		System.out.println("--------Max Path Length---------");
		System.out.println(MaxPathLength.maxPathLength_self(node));
		System.out.println("--------Is equal---------------------");
		CompleteBinaryTree.levelOrderBinaryTree(num);
		Node node2 = CompleteBinaryTree.getRoot();
		System.out.println(IdenticalBinaryTree.isEquals(node, node2));
		System.out.println("--------Copy Tree---------------------");
		Node copy = CopyTree.copyTree(node);
		LevelOrderTraversal.levelOrderTopToDown(copy);
		System.out.println("--------Copy Minor Tree---------------------");
		Node copyMinor = CopyMinorTree.copyMinorTree(node);
		LevelOrderTraversal.levelOrderTopToDown(copyMinor);
		System.out.println("--------Is Complete Tree---------------------");
		System.out.println(IsCompleteTree.isCompleteTree(node));
		System.out.println("--------Pre Order With Recursion---------");
		PreOrderTraversal.preOrder(node);
		System.out.println();
		System.out.println("--------Pre Order Without Recursion---------");
		PreOrderTraversal.preOrderIterative(node);
		System.out.println();
		System.out.println("--------In Order With Recursion---------");
		InOrderTraversal.inOrder(node);
		System.out.println("--------In Order WithOut Recursion---------");
		InOrderTraversal.inOrder_self(node);
		System.out.println();
		System.out.println("--------Post Order With Recursion---------");
		PostOrderTraversal.postOrder(node);
		System.out.println();
		System.out.println("--------Post Order Without Recursion---------");
		PostOrderTraversal.postOrderWithoutRecursion(node);
	}

}
