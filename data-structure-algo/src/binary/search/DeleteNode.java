package binary.search;

public class DeleteNode {

	public static Node delete(Node root, int val) {
		Node temp = null;
		if(root != null) {
			if(root.val == val) {
				if(root.left == null && root.right == null) {
					return null;
				}
				else {
					if(root.left == null) {
						temp = root.right;
						return temp;
					}
					if(root.right == null) {
						temp = root.left;
						return temp;
					}
					int minNodeVal = BST.findMin(root.right);
					root.val = minNodeVal;
					root.right = delete(root.right, minNodeVal);
				}
			}else {
				if(val < root.val) {
					root.left = delete(root.left, val);
				}
				else {
					root.right = delete(root.right, val);
				}
			}
		}
		return root;
	}
}
