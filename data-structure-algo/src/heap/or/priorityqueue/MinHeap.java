package heap.or.priorityqueue;

public class MinHeap {

	static private class Heap {
		int[] num; // pointer to array of elements in heap
		int capacity; // maximum possible size of min heap
		int size; // Current number of elements in min heap

		private Heap(int num[], int size) {
			size = size;
			this.num = num; // store address of array
			int i = (size - 1) / 2;
			while (i >= 0) {
				minHeapify(i);
				i--;
			}
		}

		private int parent(int i) {
			return (i - 1) / 2;
		}

		private int left(int i) {
			return ((2 * i) + 1);
		}

		private int right(int i) {
			return ((2 * i) + 2);
		}

		private int getMin() {
			return this.num[0];
		}

		private int extractMin() {
			if (size == 0)
				return Integer.MAX_VALUE;
			int root = num[0];
			if (size > 1) {
				num[0] = num[size - 1];
				minHeapify(0);
			}
			size--;
			return root;
		}

		private void minHeapify(int i) {
			int l = left(i);
			int r = right(i);
			int smallest = i;
			if (l < size && num[l] < num[i])
				smallest = l;
			if (r < size && num[r] < num[smallest])
				smallest = r;
			if (smallest != i) {
				int t = num[i];
				num[i] = num[smallest];
				num[smallest] = t;
				minHeapify(smallest);
			}
		}
	};

	public static int kthSmallest(int num[], int k) {
		Heap heap = new Heap(num, num.length);
		for (int i = 0; i < k - 1; i++) {
			heap.extractMin();
		}
		return heap.getMin();
	}

	public static void main(String[] args) {
		// int num[] = { 12, 3, 5, 7, 19 };
		int num[] = { 73, 188, 894, 915, 940, 616, 900, 548 };
		System.out.println(kthSmallest(num, 7));
		for (int i = 1; i <= num.length; i++) {
		///	System.out.println(kthSmallest(num, i));
		}
	}
}
