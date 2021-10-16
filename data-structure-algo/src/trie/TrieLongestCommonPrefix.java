package trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrieLongestCommonPrefix {

	private Node root;
	private static int lcpIndex;

	public TrieLongestCommonPrefix() {
		this.root = new Node("");
	}

	public void insert(String key, int value) {
		key = key.toLowerCase();
		Node temp = this.root;
		Map<Character, Node> children = temp.getChildren();
		List<Node> kids = temp.getKids();
		for (int i = 0; i < key.length(); i++) {
			char ch = key.charAt(i);
			int ascii = ch - 'a';
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
		temp.setValue(value);
	}

	public Integer search(String key) {
		Node temp = this.root;
		for (int i = 0; i < key.length(); i++) {
			char ch = key.charAt(i);
			int ascii = ch - 'a';
			if (temp.getChild(ascii) == null) {
				return null;
			} else {
				temp = temp.getChild(ascii);
			}
		}
		if (!temp.isLeaf())
			return null;
		else
			return temp.getValue();
	}

	public List<String> autoComplete(String prefix) {
		Node temp = this.root;
		List<String> autoCompleteList = new ArrayList<>();
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			int ascii = ch - 'a';
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
		TrieAutoComplete tac = new TrieAutoComplete();
		// String a = "ampuir";
		// String b = "apuple";
		// String c = "apuprove";
		String g = "baus";
		String d = "baus";
		String e = "baus";
		String f = "baus";
		// String h = "apuAAPan";

		tac.insert(g, 76);
//		tac.insert(a, 10);
//		tac.insert(b, 7);
//		tac.insert(h, 11);
//		tac.insert(c, 5);
		tac.insert(d, 15);
		tac.insert(e, 134);
		tac.insert(f, 1);

		System.out.println(tac.search("air"));
		System.out.println(tac.search("computer"));
		System.out.println(tac.search("bee"));
		System.out.println(tac.search("air"));

		// System.out.println(tac.root.getChildren());

		for (String s : tac.autoComplete("b")) {
			System.out.println(s);
		}
		System.out.println("------------------");
		for (String s : tac.sort()) {
			System.out.println(s);
		}
		System.out.println("---------Longest common prefix-----------");
		System.out.println(tac.longestCommonPrefix());
	}
}
