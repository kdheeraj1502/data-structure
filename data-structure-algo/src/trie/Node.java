package trie;

import java.util.*;

public class Node {

	private String character;
	private Node[] child;
	private boolean isLeaf;
	private boolean isVisited;
	private int value;
	private Map<Character, Node> children;
	private List<Node> kids;

	public Node(String character) {
		this.character = character;
		// this.child = new Node[Contstants.ALPHABET_SIZE];
		this.child = new Node[Contstants.CHARACTER_SIZE];
		this.children = new HashMap<>();
		this.kids = new ArrayList<>();
	}

	public List<Node> getKids() {
		return kids;
	}

	public void setKids(List<Node> kids) {
		this.kids = kids;
	}

	public Map<Character, Node> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, Node> children) {
		this.children = children;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public void setChild(int index, Node node) {
		this.child[index] = node;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public Node getChild(int index) {
		return child[index];
	}

	@Override
	public String toString() {
		return character;
	}

}
