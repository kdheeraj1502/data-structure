package binary.search;

public class NumOfNodes {

	public static int numOfNodes(Node root) {
		if(root == null) return 0;
		return (1 + numOfNodes(root.left) + numOfNodes(root.right));
	}
}
