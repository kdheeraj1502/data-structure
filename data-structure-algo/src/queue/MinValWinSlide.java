package queue;

import java.util.ArrayDeque;

public class MinValWinSlide {

	public static void minValWinSlide(int num[], int k){
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for(int i = 0; i < num.length; i++) {
			if(queue.size() > 0 && queue.peek() <= i - k) {
				queue.remove();
			}
			while(queue.size() > 0 && num[queue.peekLast()] > num[i]) {
				queue.removeLast();
			}
			queue.add(i);
			if(i >= k - 1) {
				System.out.println("min val is " + num[queue.peek()]);
			}
		}
	}
	
	public static void main(String[] args) {
		int num[] = { 11, 2, 75, 92, 59, 90, 55 };
		// int num[] = { 11, 10, 9, 8, 7, 56, 5 };
		int k = 3;
		minValWinSlide(num, k);
	}
}
