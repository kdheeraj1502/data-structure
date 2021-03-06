package trie.ternary.search.tree;

public class TernarySearchTree {

	private Node root;

	public void put(String key, int value) {
		this.root = insert(this.root, key, value, 0);
	}

	private Node insert(Node node, String key, int value, int index) {
		char ch = key.charAt(index);
		if (node == null) {
			node = new Node(ch);
		}
		if (ch < node.getCharacter()) {
			node.setLeftChild(insert(node.getLeftChild(), key, value, index));
		} else if (ch > node.getCharacter()) {
			node.setRightChild(insert(node.getRightChild(), key, value, index));
		} else if (index < key.length() - 1) {
			node.setMiddleChild(insert(node.getMiddleChild(), key, value, index + 1));
		} else {
			node.setLeaf(Boolean.TRUE);
			node.setValue(value);
		}
		return node;
	}

	public int get(String key) {
		return search(this.root, key, 0);
	}

	private Integer search(Node node, String key, int index) {
		char ch = key.charAt(index);
		if (node == null)
			return null;
		if (ch < node.getCharacter()) {
			return search(node.getLeftChild(), key, index);
		} else if (ch > node.getCharacter()) {
			return search(node.getRightChild(), key, index);
		} else if (index < key.length() - 1) {
			return search(node.getMiddleChild(), key, index + 1);
		} else {
			if (!node.isLeaf())
				return null;
			return node.getValue();
		}
	}

	public void traverse() {
		if (this.root != null)
			traverse(this.root, "");
	}

	private void traverse(Node curr, String s) {
		if (curr == null)
			return;
		if (curr.getMiddleChild() == null || curr.getValue() != 0) {
			System.out.println(s + curr.getCharacter() + " " + curr.getValue());
			s = "";
		}
		if (curr.getLeftChild() != null) {
			traverse(curr.getLeftChild(), s);
		}
		if (curr.getMiddleChild() != null) {
			traverse(curr.getMiddleChild(), s + curr.getCharacter());
		}
		if (curr.getRightChild() != null) {
			traverse(curr.getRightChild(), s);
		}
	}

	public static void main(String[] args) {
		TernarySearchTree tst = new TernarySearchTree();

		tst.put("car", 10);
		tst.put("bus", 5);
		tst.put("banana", 7);
		tst.put("city", 20);
		tst.put("person", 2);

		System.out.println(tst.get("car"));
		System.out.println(tst.get("bus"));
		System.out.println(tst.get("banana"));
		System.out.println(tst.get("city"));
		System.out.println(tst.get("person"));

		tst.traverse();
	}
}
