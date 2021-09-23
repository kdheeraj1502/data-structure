package binary.search;

public class NthPreOrder {

	public static int nthPreOrderNode(Node root, int index) {
		int[] counter = {0};
		return nthPreOrderNode(root,counter, index, -1);
	}

	private static int nthPreOrderNode(Node root, int[] counter, int index, int result) {
		if(result != -1) {
			root = null;
		}
		if(root != null) {
			counter[0]++;
			if(counter[0] == index) {
				result = root.val;
				return result;
			}
			result = nthPreOrderNode(root.left, counter, index, result);
			result = nthPreOrderNode(root.right, counter, index, result);
		}
		return result;
	}
}
