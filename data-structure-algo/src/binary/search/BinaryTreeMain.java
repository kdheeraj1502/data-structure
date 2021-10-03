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
		// LevelOrderTraversal.levelOrder(node);
		// LevelOrderTraversal.printCurrentLevel(node);
		System.out.println();
		int depth = TreeDepth.treeDepthWithoutRecursion(node);
		System.out.println("depth is " + depth);
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
		System.out.println("--------Print all path---------");
		PrintAllPath.printAllPath(node);
		System.out.println("--------Num Of Nodes---------");
		// System.out.println(NumOfNodes.numOfNodes(node));
		// System.out.println("--------Sum Of Nodes---------");
		// System.out.println(SumAllNodes.sumAllNodes(node));
		// System.out.println("--------Num Of Leaf Nodes---------");
		// System.out.println(NumOfLeafNodes.numOfLeafNodesWithoutStack(node));
		System.out.println("--------search val---------");
		// System.out.println(SearchValInTree.search(node, 2));
		System.out.println("--------search val---------");
		// System.out.println(FindMaxVal.findMax(node, "parent"));
		// System.out.println("--------Tree Depth---------");
		// System.out.println(TreeDepth.treeDepth(node));
		// System.out.println("--------Max Path Length---------");
		// System.out.println(MaxPathLength.maxPathLength_self(node));
		// System.out.println("--------Is equal---------------------");
		// CompleteBinaryTree.levelOrderBinaryTree(num);
		// Node node2 = CompleteBinaryTree.getRoot();
		// System.out.println(IdenticalBinaryTree.isEquals(node, node2));
		System.out.println("--------Copy Tree---------------------");
		Node copy = CopyTree.copyTree(node);
		LevelOrderTraversal.levelOrderTopToDown(copy);
		// System.out.println("--------Copy Minor Tree---------------------");
		// Node copyMinor = CopyMinorTree.copyMinorTree(node);
		// LevelOrderTraversal.levelOrderTopToDown(copyMinor);
		// System.out.println("--------Is Complete Tree---------------------");
		// System.out.println(IsCompleteTree.isCompleteTree(node));
		// System.out.println("--------Pre Order With Recursion---------");
		// PreOrderTraversal.preOrder(node);
		// System.out.println();
		// System.out.println("--------Pre Order Without Recursion---------");
		// PreOrderTraversal.preOrderIterative(node);
		// System.out.println();
		// System.out.println("--------In Order With Recursion---------");
		// InOrderTraversal.inOrder(node);
		// System.out.println("--------In Order WithOut Recursion---------");
		// InOrderTraversal.inOrder_self(node);
		// System.out.println();
		// System.out.println("--------Post Order With Recursion---------");
		// PostOrderTraversal.postOrder(node);
		// System.out.println();
		// System.out.println("--------Post Order Without Recursion---------");
		// PostOrderTraversal.postOrderWithoutRecursion(node);
		// System.out.println();

		// System.out.println("--------Create Binary from sorted list---------");
		int num1[] = { 13, 15, 17, 19, 21, 23, 25, 27, 29, 31 };
		Node tree = BinaryTreeFromSortedList.createBinaryTree(num1);
		// System.out.println("--------Level Order Top To Down---------");
		// LevelOrderTraversal.levelOrderTopToDown(tree);
		//
		// for(int in : num) {
		// BST.insert(in);
		// }
		// Node tree1 = BST.getRoot();
		// System.out.println("--------Level Order Top To Down---------");
		// LevelOrderTraversal.levelOrderTopToDown(tree1);
		// System.out.println();
		// System.out.println("--------Find in BST---------");
		// for(int in : num1) {
		// System.out.print(BST.find(tree, in) + ", ");
		// }
		// System.out.print(BST.find(tree, 31) + ", ");
		// System.out.println();
		// System.out.println("--------Find min in BST---------");
		// System.out.println(BST.findMin(tree));
		// System.out.println("--------Find min Node in BST---------");
		// System.out.println(BST.findMinNode(tree).val);
		// System.out.println("--------Find max in BST---------");
		// System.out.println(BST.findMax(tree));
		// System.out.println("--------Find max Node in BST---------");
		// System.out.println(BST.findMaxNode(tree).val);
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
