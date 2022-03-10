package binary.search;

import java.util.Arrays;

public class InOrderTraversalIterative {
	
//	 			8
//     		  /   \    
//   		4      12
//		  /  \    /  \
//		 2    6  10   14

	public static void findFloorAndCeil(Node root, int key, int result[]) {
		if(root == null) return;
		else {
			if(root.val <= key) {
				result[0] = root.val;
				findFloorAndCeil(root.right, key, result);
			} if(root.val >= key) {
				result[1] = root.val;
				findFloorAndCeil(root.left, key, result);
			}
		}
	}

	public static void main(String[] args) {
		Node node = new Node(8);
		node.left = new Node(4);
		node.right = new Node(12);
		node.left.left = new Node(2);
		node.left.right = new Node(6);
		node.right.left = new Node(10);
		node.right.right = new Node(14);
		int result[] = {-1, -1};
		findFloorAndCeil(node, 11, result);
		System.out.println(Arrays.toString(result));
	}
}
