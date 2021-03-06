package queue;

import java.util.*;

public class JosephusQueue {
	public static void main(String[] args) {
		int position = 2;
		int count = 6;

		ArrayDeque<Integer> queue = printJosephusPositions(count, position);
		System.out.println(queue.getFirst());
	}

	public static ArrayDeque<Integer> printJosephusPositions(int count, int position) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i < count; i++) {
			queue.add(i);
		}
		while (!queue.isEmpty() && queue.size() > 1) {
			for (int i = 1; i <= position; i++) {
				int eliminatedPosition = queue.remove();
				if (i == position) {
					break;
				}
				queue.add(eliminatedPosition);
			}
		}
		return queue;
	}
}
