package trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrieLongestCommonPrefixIP {


	private Node root;
	private static int lcpIndex;

	public TrieLongestCommonPrefixIP() {
		this.root = new Node("");
	}

	public void insert(String key) {
		key = key.toLowerCase();
		Node temp = this.root;
		Map<Character, Node> children = temp.getChildren();
		List<Node> kids = temp.getKids();
		for (int i = 0; i < key.length(); i++) {
			char ch = key.charAt(i);
			int ascii = ch;
			if (temp.getChild(ascii) == null) {
				Node node = new Node(String.valueOf(ch));
				temp.setChild(ascii, node);
				children.put(ch, node);
				kids.add(node);
				temp = node;
			} else {
				temp = temp.getChild(ascii);
			}
			children = temp.getChildren();
			kids = temp.getKids();
		}
		temp.setLeaf(Boolean.TRUE);
	}

	public boolean search(String key) {
		Node temp = this.root;
		for (int i = 0; i < key.length(); i++) {
			char ch = key.charAt(i);
			int ascii = ch;
			if (temp.getChild(ascii) == null) {
				return false;
			} else {
				temp = temp.getChild(ascii);
			}
		}
		if (!temp.isLeaf())
			return false;
		else
			return temp.isLeaf();
	}

	public List<String> autoComplete(String prefix) {
		Node temp = this.root;
		List<String> autoCompleteList = new ArrayList<>();
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			int ascii = ch;
			if (temp.getChild(ascii) == null) {
				return autoCompleteList;
			} else {
				temp = temp.getChild(ascii);
			}
		}
		collect(temp, prefix, autoCompleteList);
		return autoCompleteList;
	}

	private void collect(Node curr, String prefix, List<String> autoCompleteList) {
		if (curr == null)
			return;
		if (curr.isLeaf())
			autoCompleteList.add(prefix);

		for (Map.Entry<Character, Node> entry : curr.getChildren().entrySet()) {
			Node child = entry.getValue();
			if (entry.getValue() == null)
				continue;
			String childCharacter = child.getCharacter();
			collect(child, prefix + childCharacter, autoCompleteList);
		}
	}

	public List<String> sort() {
		return autoComplete("");
	}

	public String longestCommonPrefix() {
		Node node = this.root;
		String lcp = "";
		while (numOfChildren(node) == 1 && !node.isLeaf()) {
			node = node.getKids().get(lcpIndex);
			lcp = lcp + node.getCharacter();
		}
		return lcp;
	}

	private int numOfChildren(Node curr) {
		int numOfChildren = 0;
		for (int i = 0; i < curr.getKids().size(); i++) {
			if (curr.getKids().get(i) != null) {
				numOfChildren++;
				lcpIndex = i;
			}
		}
		return numOfChildren;
	}

	public static void main(String[] args) {
		TrieLongestCommonPrefixIP tlcp = new TrieLongestCommonPrefixIP();
		tlcp.insert("243.189.345.123");
		tlcp.insert("243.189.562.173");
		tlcp.insert("243.145.111.173");
		tlcp.insert("243.189.123.763");
		tlcp.insert("243.189.345.223");

		// found
		System.out.println("243.189.562.173 is " + ((tlcp.search("243.189.562.173") == true) ? "present" : "Not found"));
		// Not found
		System.out.println("999.189.345.123 is " + ((tlcp.search("999.189.345.123") == true) ? "present" : "Not found"));
		// found
		System.out.println("243.189.345.123 is " + ((tlcp.search("243.189.345.123") == true) ? "present" : "Not found"));
		// Not found
		System.out.println("air is " + ((tlcp.search("air") == true) ? "present" : "Not found"));

		System.out.println("---------Longest common prefix-----------");
		System.out.println(tlcp.longestCommonPrefix());
	}

}
