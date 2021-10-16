package trie;

import java.util.Arrays;

public class Trie {

	// private final static int CHAR_COUNT = 26;

	/*
	 * private class Node { private boolean isLastChar; private Node[] child;
	 * 
	 * public Node(char c) { child = new Node[CHAR_COUNT]; Arrays.fill(child, null);
	 * isLastChar = Boolean.FALSE; } }
	 * 
	 * public Trie() { this.root = new Node(' '); }
	 * 
	 * public Node add(String str) { if (str == null) { return this.root; } return
	 * add(this.root, str.toLowerCase(), 0); }
	 * 
	 * public Node add(Node curr, String str, int index) { if(curr == null) { curr =
	 * new Node(str.charAt(index - 1)); } if(str.length() == index) {
	 * curr.isLastChar = Boolean.TRUE; }else {
	 * System.out.println(str.charAt(index)); System.out.println(str.charAt(index) -
	 * 'a'); curr.child[str.charAt(index) - 'a'] = add(curr.child[str.charAt(index)
	 * - 'a'], str, index + 1); } return curr; }
	 * 
	 * public void remove(String str) { if(str == null) return; str =
	 * str.toLowerCase(); remove(this.root, str, 0); }
	 * 
	 * private void remove(Node curr, String str, int index) { if(curr == null)
	 * return; if(str.length() == index) { if(curr.isLastChar) { curr.isLastChar =
	 * false; } return; } remove(curr.child[str.charAt(index) - 'a'], str, index +
	 * 1); }
	 * 
	 * public boolean find(String str) { if(str == null) return false; str =
	 * str.toLowerCase(); return find(this.root, str, 0); }
	 * 
	 * private boolean find(Node curr, String str, int index) { if(curr == null)
	 * return false; if(str.length() == index) { return curr.isLastChar; } return
	 * find(curr.child[str.charAt(index) - 'a'], str, index + 1); }
	 */

	private Node root = null;

	public Trie() {
		this.root = new Node("");
	}

	public void insert(String key) {
		Node temp = this.root;
		for (int i = 0; i < key.length(); ++i) {
			char c = key.charAt(i);
			int ascii = c - 'a';
			if (temp.getChild(ascii) == null) {
				Node node = new Node(String.valueOf(c));
				temp.setChild(ascii, node);
				temp = node;
			} else {
				temp = temp.getChild(ascii);
			}
		}
		temp.setLeaf(Boolean.TRUE);
	}
	
	public boolean search(String key) {
		Node temp = this.root;
		for(int i = 0; i < key.length(); ++i) {
			char c = key.charAt(i);
			int ascii = c - 'a';
			if(temp.getChild(ascii) == null) return false;
			else {
				temp = temp.getChild(ascii);
			}
		}
		if(!temp.isLeaf()) return false;
		return true;
	}
	
	public void print(Node curr) {
		for(int i = 0; i < 26; i++) {
			if(curr.getChild(i)== null) {
				continue;
			}
			else {
				System.out.println(curr.getCharacter());
				curr = curr.getChild(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Trie t = new Trie();
		String a = "apir";
		String b = "apple";
		String c = "approve";
		String d = "apee";

		/*
		 * t.add(a); t.add(d); System.out.println(t.find(a)); t.remove(a); t.remove(d);
		 * System.out.println(t.find(a)); System.out.println(t.find(c));
		 * System.out.println(t.find(d));
		 */
		
		t.insert(a);
		t.insert(b);
		t.insert(c);
		t.insert(d);
		
		//t.print(t.root);
	}
}
