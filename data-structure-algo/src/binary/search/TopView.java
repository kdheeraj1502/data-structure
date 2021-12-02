package binary.search;

import java.util.*;

public class TopView {
	
	static Node root;

	static ArrayList<Integer> topView(Node root) {
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		int max = width(root);
		//int num[] = new int[max];

		Map<Integer, List<Integer>> map = verticleOrder(root);
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			int val = entry.getValue().get(0);
			result.add(val);
		}
		return result;
	}

	static int width(Node root) {
		Queue<Pair<Node, Integer>> queue = new LinkedList<>();
		queue.add(new Pair<>(root, 0));
		int max = 0;
		while (!queue.isEmpty()) {
			int lm = queue.peek().getIndex();
			int rm = lm;
			int size = queue.size();
			while (size-- > 0) {
				Pair<Node, Integer> temp = queue.remove();
				rm = temp.getIndex();
				if (temp.node.left != null) {
					queue.add(new Pair<>(temp.node.left, 2 * lm));
				}
				if (temp.node.right != null) {
					queue.add(new Pair<>(temp.node.right, 2 * rm + 1));
				}
				max = Math.max(max, rm - lm + 1);
			}
		}
		return max;
	}

	static Map<Integer, List<Integer>> verticleOrder(Node root) {
		Queue<Pair<Node, Integer>> queue = new LinkedList<>();
		queue.add(new Pair<>(root, 0));
		Map<Integer, List<Integer>> distance = new TreeMap<>();

		while (!queue.isEmpty()) {
			Map<Integer, List<Integer>> map = new HashMap<>();
			int size = queue.size();
			while (size-- > 0) {
				Pair<Node, Integer> temp = queue.remove();
				int index = temp.getIndex();
				List<Integer> list = map.getOrDefault(map.get(index), new ArrayList<>());
				list.add(temp.node.val);
				map.put(index, list);
				if (temp.node.left != null) {
					queue.add(new Pair<>(temp.node.left, index - 1));
				}
				if (temp.node.right != null) {
					queue.add(new Pair<>(temp.node.right, index + 1));
				}
			}
			for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
				List<Integer> list = distance.getOrDefault(entry.getKey(), new ArrayList<>());
				list.addAll(entry.getValue());
				distance.put(entry.getKey(), list);
			}
		}
		return distance;
	}
	public static void main(String[] args) {
		root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(0);
		root.left.right = new Node(2);
		root.right.left = new Node(2);
		System.out.println(topView(root));
	}
}