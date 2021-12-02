package binary.search;

import java.util.*;

public class VerticleOrder {

	static int min;
	static int max;
	static Node root;
	/*
	 * static class Node { public int data; public Node left; public Node right;
	 * 
	 * Node(int data) { this.data = data; }
	 * 
	 * Node(int data, Node left, Node right) { this.data = data; this.left = left;
	 * this.right = right; }
	 * 
	 * @Override public String toString() { return "" + data + ""; }
	 */
	// }
	public static List<List<Integer>> verticalTraversal(Node root) {
		Queue<Pair<Node, Integer>> queue = new ArrayDeque<>();
		queue.add(new Pair<Node, Integer>(root, 0));
		TreeMap<Integer, List<Integer>> distaceMap = new TreeMap<>();
		while (!queue.isEmpty()) {
			Map<Integer, List<Integer>> map = new HashMap<>();
			int size = queue.size();
			int index = queue.peek().index;
			while (size-- > 0) {
				Pair<Node, Integer> temp = queue.remove();
				index = temp.index;
				List<Integer> list = map.getOrDefault(index, new ArrayList<>());
				list.add(temp.node.val);
				Collections.sort(list);
				map.put(index, new ArrayList<>(list));
				if (temp.node.left != null) {
					queue.add(new Pair<>(temp.node.left, index - 1));
					min = Math.min(min, index - 1);
				}
				if (temp.node.right != null) {
					queue.add(new Pair<>(temp.node.right, index + 1));
					max = Math.max(max, index + 1);
				}
			}
			for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
				List<Integer> list = distaceMap.getOrDefault(entry.getKey(), new ArrayList<>());
				list.addAll(entry.getValue());
				distaceMap.put(entry.getKey(), list);
			}
		}
System.out.println(distaceMap);
		return new ArrayList<>(distaceMap.values());
	}

	public static void main(String[] args) {
		root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(0);
		root.left.right = new Node(2);
		root.right.left = new Node(2);
		System.out.println(verticalTraversal(root));
	}
}

class Pair<K, V> {
	Node node;
	Integer index;

	Pair(Node root, Integer index) {
		this.index = index;
		this.node = root;
	}

	public Node getNode() {
		return node;
	}

	public Integer getIndex() {
		return index;
	}
}
