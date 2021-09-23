package binary.search;

public class NthInOrder {

	public static int nThInOrder(Node root, int index) {
		int counter[] = { 0 };
		return nThInOrder(root, counter, index, -1);
	}
	
	private static int nThInOrder(Node root, int counter[], int index, int result) {
		if(root != null) {
			result = nThInOrder(root.left, counter, index, result);
			counter[0]++;
			if(counter[0] == index) {
				result = root.val;
				return result;
			}
			result = nThInOrder(root.right, counter, index, result);
		}
		return result;
	}
}
