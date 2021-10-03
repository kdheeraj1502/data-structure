package heap.or.priorityqueue;

import java.util.Arrays;

public class BuildMaxHeap {

	private static void heapify(int num[], int i) {
		int largest = i;
		int left = (2 * i) + 1;
		int right = (2 * i) + 2;

		if (left < num.length && num[left] > num[largest])
			largest = left;
		if (right < num.length && num[right] > num[largest])
			largest = right;
		if (largest != i) {
			swap(num, i, largest);
			heapify(num, largest);
		}
	}

	private static void swap(int num[], int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public static void buildHeap(int num[]) {
		int startIdx = (num.length / 2) - 1;
		for (int i = startIdx; i >= 0; i--)
			heapify(num, i);/*
							 * for (int i = 0; i <= num.length / 2; i++) heapify(num, i);
							 */
	}

	public static void printHeap(int[] num) {
		for (int i = 0; i <= num.length / 2; i++) {
			System.out.print(
					" PARENT : " + num[i] + " LEFT CHILD : " + ((2 * i + 1) < num.length ? (num[2 * i + 1]) : null)
							+ " RIGHT CHILD :" + ((2 * i + 2) < num.length ? (num[2 * i + 2]) : null));
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int num[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
		buildHeap(num);
		System.out.println("--------------------Print heap----------------");
		System.out.println(Arrays.toString(num));
		printHeap(num);
	}
}
