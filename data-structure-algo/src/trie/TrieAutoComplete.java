package trie;

import java.util.*;

public class TrieAutoComplete {

	private Node root;

	public TrieAutoComplete() {
		this.root = new Node("");
	}

	public void insert(String key, int value) {
		Node temp = this.root;
		Map<Character, Node> children = temp.getChildren();
		for (int i = 0; i < key.length(); i++) {
			char ch = key.charAt(i);
			int ascii = ch - 'a';
			if (temp.getChild(ascii) == null) {
				Node node = new Node(String.valueOf(ch));
				temp.setChild(ascii, node);
				children.put(ch, node);
				temp = node;
			} else {
				temp = temp.getChild(ascii);
			}
			children = temp.getChildren();
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
	
	public List<String> sort(){
		return autoComplete("");
	}

	public static void main(String[] args) {
		TrieAutoComplete tac = new TrieAutoComplete();
		String a = "air";
		String b = "apple";
		String c = "approve";
		String g = "bzz";
		String d = "bee";
		String e = "banana";
		String f = "bus";

		tac.insert(g, 76);
		tac.insert(a, 10);
		tac.insert(b, 7);
		tac.insert(c, 5);
		tac.insert(d, 15);
		tac.insert(e, 134);
		tac.insert(f, 1);

		System.out.println(tac.search("air"));
		System.out.println(tac.search("computer"));
		System.out.println(tac.search("bee"));
		System.out.println(tac.search("air"));

	//	System.out.println(tac.root.getChildren());

		for (String s : tac.autoComplete("b")) {
			System.out.println(s);
		}
		System.out.println("------------------");
		for(String s : tac.sort()) {
			System.out.println(s);
		}
	}
}
