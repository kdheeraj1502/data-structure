package trie.ternary.search.tree;

public class Node {

	private char character;
	private int value;
	private Node leftChild;
	private Node middleChild;
	private Node rightChild;
	private boolean isLeaf;
	
	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Node(char character) {
		this.character = character;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getMiddleChild() {
		return middleChild;
	}

	public void setMiddleChild(Node middleChild) {
		this.middleChild = middleChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "Node [character=" + character + "]";
	}
}
