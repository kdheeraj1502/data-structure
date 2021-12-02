package binary.search;

import java.util.*;

public class VerticalOrder {

	static Node root;
	static class NodeDistance {
		int dist;
		Node node;

		NodeDistance(int dist, Node node) {
			this.dist = dist;
			this.node = node;
		}
	}

	public static List<List<Integer>> verticalTraversal(Node root) {
		if (root == null)
			return new ArrayList<>();
		TreeMap<Integer, List<Integer>> distanceMap = new TreeMap<>();
		Queue<NodeDistance> q = new LinkedList<>();
		q.add(new NodeDistance(0, root));

		while (!q.isEmpty()) {
			HashMap<Integer, List<Integer>> levelMap = new HashMap<>();
			int size = q.size();
			while (size-- > 0) {
				NodeDistance current = q.poll();
				int distance = current.dist;
				List<Integer> nodeList = levelMap.getOrDefault(distance, new ArrayList<>());
				nodeList.add(current.node.val);
				Collections.sort(nodeList);
				levelMap.put(distance, new ArrayList<>(nodeList));

				if (current.node.left != null) {
					q.add(new NodeDistance(distance - 1, current.node.left));
				}

				if (current.node.right != null) {
					q.add(new NodeDistance(distance + 1, current.node.right));
				}
			}

			for (Map.Entry<Integer, List<Integer>> entry : levelMap.entrySet()) {
				List<Integer> nodeList = distanceMap.getOrDefault(entry.getKey(), new ArrayList<>());
				nodeList.addAll(entry.getValue());
				distanceMap.put(entry.getKey(), nodeList);
			}
		}
		return new ArrayList<>(distanceMap.values());
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


