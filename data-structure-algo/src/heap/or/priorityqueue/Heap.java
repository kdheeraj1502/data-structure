package heap.or.priorityqueue;

public class Heap {

	private static final int CAPACITY = 32;
	private int size;
	private int arr[];
	private boolean isMinHeap;

	public Heap(boolean isMin) {
		arr = new int[CAPACITY];
		size = 0;
		this.isMinHeap = isMin;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public int peek() {
		if (isEmpty())
			throw new IllegalStateException();
		return arr[0];
	}

	public static void main(String[] args) {
		int g = 16;
		
		int count = 0;
		while(g > 0) {
			g = (g)& (g - 1);
			count++;
		}
		System.out.println("1 count is " + count);
		
		int n = 0;
		while(g > 0) {
			g = g/10;
			n++;
		}
		System.out.println(n);
		
		int h;
		String key = "Dheeraj";
		h = key.hashCode();
		System.out.println("h is " + h); // -111011101000010101101010101001
		System.out.println((h = key.hashCode()) ^ (h >>> 16));
		System.out.println("Only shift " + (h >>> 16));
		int m = (2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2);
		int div = h / m;
		System.out.println("new shift is " + ((h) ^ div));
		System.out.println("Shift 1 " + (h ^ (h >>> 16)));
		System.out.println("Shift 1 " + (h ^ 50270));
		/// System.out.println((111011101000010101101010101001) ^
		/// (111011101000010101101010101001 >>> 16));

		System.out.println(" 2 ^1 " + (2 ^ 1));
		System.out.println(2 << 6);
		System.out.println(128 >> 6);

	}
}
