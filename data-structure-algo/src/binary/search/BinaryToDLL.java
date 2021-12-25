package binary.search;

import java.util.Stack;
public class BinaryToDLL {

	Node headOfDLL = null;
	Node prev = null;

	Node bToDLL(Node root) {
		if (root == null) {
			return null;
		}
		bToDLL(root.left);
		if (prev == null) {
			headOfDLL = root;
			prev = root;
		} else {
			root.left = prev;
			prev.right = root;
			prev = root;
		}
		bToDLL(root.right);
		return headOfDLL;
	}
	
	Node bToDLL_Iteration(Node root) {
		Stack<Node> stack = new Stack<>();
		Node temp = root;
		while(!stack.isEmpty() || temp != null) {
			if(temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				Node curr = stack.pop();
				temp = curr;
				if(prev == null) {
					headOfDLL = temp;
					prev = temp;
				} else {
					temp.left = prev;
					prev.right = temp;
					prev = temp;
				}
				temp = curr.right;
			}
		}
		return headOfDLL;
	}
	
	public static void main(String[] args) {
		Node root = new Node(11);
	
		root.left = new Node(27);
		root.right = new Node(30);

		root.left.left = new Node(19);
		root.left.right = new Node(15);

		root.right.left = new Node(14);
		root.right.right = new Node(23);
		BinaryToDLL btd = new BinaryToDLL();
	//	Node dll1 = btd.bToDLL(root);
		
	/*
	 * while(dll1 != null) { System.out.print(dll1.val + ", "); dll1 = dll1.right; }
	 */
		Node dll2 = btd.bToDLL_Iteration(root);
		System.out.println();
		System.out.println("-------------------------");
		while(dll2 != null) {
			System.out.print(dll2.val + ", ");
			dll2 = dll2.right;
		}
	}
}
