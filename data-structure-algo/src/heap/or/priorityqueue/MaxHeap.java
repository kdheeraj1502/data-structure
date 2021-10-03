package heap.or.priorityqueue;

public class MaxHeap {

	int num[];
	int size;
	int maxSize;

	public MaxHeap(int maxSize) {
		this.maxSize = maxSize;
		this.num = new int[this.maxSize];
		this.size = 0;
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private int leftChild(int i) {
		return (2 * i) + 1;
	}

	private int rightChild(int i) {
		return (2 * i) + 2;
	}

	private boolean isLeaf(int pos) {
		if (pos > (size / 2) && pos <= size)
			return true;
		return false;
	}

	private void swap(int i, int j) {
		int tmp;
		tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}

	private void maxHeapify(int i) {
		if (isLeaf(i))
			return;
		int max = i;
		int left = leftChild(i);
		int right = rightChild(i);

		if (left < num.length && this.num[left] > this.num[i]) {
			max = left;
		}
		if (right < num.length && this.num[right] > this.num[i]) {
			max = right;
		}
		if (max != i) {
			swap(i, max);
			maxHeapify(max);
		}
		/*
		 * if (num[i] < num[left] || num[i] < num[right]) {
		 * 
		 * if (num[leftChild(i)] > num[right]) { swap(i, left); maxHeapify(left); } else
		 * { swap(i, right); maxHeapify(right); } }
		 */
	}

	public void insert(int element) {
		num[size] = element;
		int current = size;
		while (num[current] > num[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		size++;
	}

	public void print() {
		for (int i = 0; i <= size / 2; i++) {
			System.out.print(
					" PARENT : " + num[i] + " LEFT CHILD : " + ((2 * i + 1) < num.length ? (num[2 * i + 1]) : null)
							+ " RIGHT CHILD :" + ((2 * i + 2) < num.length ? (num[2 * i + 2]) : null));
			System.out.println();
		}
	}

	public int extractMax() {
		int popped = num[0];
		num[0] = num[--size];
		maxHeapify(0);
		return popped;
	}

	public static void main(String[] arg) {
		System.out.println("The Max Heap is ");
		int num[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
		MaxHeap maxHeap = new MaxHeap(num.length);

		for (int in : num) {
			maxHeap.insert(in);
		}

		/*
		 * maxHeap.insert(5); maxHeap.insert(3); maxHeap.insert(17); maxHeap.insert(10);
		 * maxHeap.insert(84); maxHeap.insert(19); maxHeap.insert(6);
		 * maxHeap.insert(22); maxHeap.insert(9);
		 */

		maxHeap.print();

		System.out.println("The max val is " + maxHeap.extractMax());
	}
}
