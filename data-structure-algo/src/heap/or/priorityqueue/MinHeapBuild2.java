package heap.or.priorityqueue;

public class MinHeapBuild2 {

	private int heap[];
	private int size;
	private int capacity;

	public MinHeapBuild2(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.heap = new int[this.capacity];
	}

	private int left(int i) {
		return (2 * i) + 1;
	}

	private int right(int i) {
		return (2 * i) + 2;
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private void swap(int num[], int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public void insert(int val) {
		this.heap[size] = val;
		int current = size;
		int parent = parent(current);
		while (this.heap[current] < this.heap[parent]) {
			swap(this.heap, current, parent);
			current = parent;
			parent = parent(current);
		}
		size++;
	}

	public void heapify(int i) {
		int small = i;
		int left = left(i);
		int right = right(i);
		if (left < this.size && this.heap[left] < this.heap[small])
			small = left;
		if (right < this.size && this.heap[right] < this.heap[small])
			small = right;
		if (small != i) {
			swap(this.heap, small, i);
			heapify(small);
		}
	}

	public int extractMin() {
		int root = this.heap[0];
		if (this.size > 0) {
			this.heap[0] = this.heap[size - 1];
			heapify(0);
		}
		size--;
		return root;
	}

	public int kthSmallest(int k) {
		for (int i = 0; i < k - 1; i++) {
			extractMin();
		}
		return extractMin();
	}

	public void print() {
		for (int i = 0; i <= this.heap.length / 2; i++) {
			System.out.println("PARENT : " + this.heap[i] + " LEFT CHILD : "
					+ ((2 * i + 1) < this.heap.length ? this.heap[(2 * i + 1)] : null) + " RIGHT CHILD : "
					+ ((2 * i + 2) < this.heap.length ? this.heap[(2 * i + 2)] : null));
		}
	}

	public static void main(String[] args) {
		int num[] = { 73, 188, 894, 915, 940, 616, 900, 548 };
		MinHeapBuild2 minHeapBuild2 = new MinHeapBuild2(num.length);
		for (int in : num) {
			minHeapBuild2.insert(in);
		}
		minHeapBuild2.print();
		System.out.println(minHeapBuild2.kthSmallest(7));
	}
}
