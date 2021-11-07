package dynamic.programming;

import java.util.LinkedList;
import java.util.Queue;

public class FrogJumpBFS {

	public static int jump(int[] num) {
		boolean visited[] = new boolean[num.length];
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0));
		visited[0] = true;
		while (!queue.isEmpty()) {
		//	Node temp = queue.peek();
			Node temp = queue.poll();
			for (int i = temp.index + 1; i < Math.min(num.length, temp.index + num[temp.index] + 1); i++) {
				if (!visited[i]) {
					if (i == num.length - 1) {
						return temp.dist + 1;
					}
					queue.add(new Node(i, temp.dist + 1));
					visited[i] = true;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int num[] = { 2, 3, 1, 1, 4 };
		System.out.println(jump(num));
	}
}

class Node {
	int index;
	int dist;

	Node(int index, int dist) {
		this.index = index;
		this.dist = dist;
	}
}